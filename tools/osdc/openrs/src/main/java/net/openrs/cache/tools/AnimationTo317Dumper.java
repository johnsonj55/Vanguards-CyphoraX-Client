package net.openrs.cache.tools;

import net.openrs.cache.*;
import net.openrs.cache.skeleton.Skeleton;
import net.openrs.cache.skeleton.Skin;
import net.openrs.cache.type.CacheIndex;
import net.openrs.cache.util.CompressionUtils;
import net.openrs.util.GZip;

import java.io.*;
import java.nio.ByteBuffer;

public class AnimationTo317Dumper {

    public static boolean headerPacked;

    public static void main(String[] args) throws Exception {
        try (Cache cache = new Cache(FileStore.open(Constants.CACHE_PATH))) {
            final File dir = new File("./dump/anims/");

            if (!dir.exists()) {
                dir.mkdirs();
            }

            final ReferenceTable skeletonTable = cache.getReferenceTable(CacheIndex.SKELETONS);

            final Skeleton[][] skeletons = new Skeleton[skeletonTable.capacity()][];

            for (int mainSkeletonId = 0; mainSkeletonId < skeletonTable.capacity(); mainSkeletonId++) {

                if (skeletonTable.getEntry(mainSkeletonId) == null) {
                    continue;
                }

                final ByteArrayOutputStream bos = new ByteArrayOutputStream();

                try (DataOutputStream dat = new DataOutputStream(bos)) {
                    Archive skeletonArchive = Archive.decode(cache.read(CacheIndex.SKELETONS, mainSkeletonId).getData(), skeletonTable.getEntry(mainSkeletonId).size());

                    final int subSkeletonCount = skeletonArchive.size();

                    headerPacked = false;

                    skeletons[mainSkeletonId] = new Skeleton[subSkeletonCount];

                    for (int subSkeletonId = 0; subSkeletonId < subSkeletonCount; subSkeletonId++) {
                        readNext(cache, dat, skeletonArchive, mainSkeletonId, subSkeletonId, skeletons);
                    }
                }

                try (FileOutputStream fos = new FileOutputStream(new File(dir, mainSkeletonId + ".gz"))) {
                    fos.write(GZip.compress(bos.toByteArray()));
                }

                double progress = (double) (mainSkeletonId + 1) / skeletonTable.capacity() * 100;

                System.out.println(String.format("%.2f%s", progress, "%"));

            }

            System.out.println(String.format("Dumped %d skeletons.", skeletonTable.capacity()));
        }

    }

    public static void readNext(Cache cache, DataOutputStream dos, Archive archive, int mainSkeletonId, int subSkeletonId, Skeleton[][] skeletons) throws IOException {
        final ByteBuffer skeletonBuffer = archive.getEntry(subSkeletonId);

        if (skeletonBuffer.remaining() == 0) {
            return;
        }

        final int skinId = ((skeletonBuffer.array()[0] & 255) << 8) | (skeletonBuffer.array()[1] & 255);

        final Container skinContainer = cache.read(CacheIndex.SKINS, skinId);

        final ByteBuffer skinBuffer = skinContainer.getData();

        if (skinBuffer == null) {
            return;
        }

        final Skin skin = Skin.decode(skinBuffer);

        if (!headerPacked) {
            dos.writeShort(skin.count);

            for (int i = 0; i < skin.count; ++i) {
                dos.writeShort(skin.transformationTypes[i]);
            }

            for (int i = 0; i < skin.count; ++i) {
                dos.writeShort(skin.skinList[i].length);
            }

            for (int i = 0; i < skin.count; ++i) {
                for (int j = 0; j < skin.skinList[i].length; ++j) {
                    dos.writeShort(skin.skinList[i][j]);
                }
            }

            dos.writeShort(archive.size());
            headerPacked = true;
        }

        dos.writeShort(subSkeletonId);

        skeletons[mainSkeletonId][subSkeletonId] = Skeleton.decode(skeletonBuffer, skin, dos);
    }

}

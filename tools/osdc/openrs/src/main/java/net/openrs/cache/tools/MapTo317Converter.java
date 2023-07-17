package net.openrs.cache.tools;

import net.openrs.cache.Cache;
import net.openrs.cache.Container;
import net.openrs.cache.FileStore;
import net.openrs.cache.util.XTEAManager;
import net.openrs.util.GZip;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

public class MapTo317Converter {

    public static void main(String[] args) throws IOException {
        File dir = new File("F:/dump/");

        if (!dir.exists()) {
            dir.mkdirs();
        }

        File mapDir = new File("F:/dump/index4/");

        if (!mapDir.exists()) {
            mapDir.mkdirs();
        }
        XTEAManager.loadFromJSON(new File("C:\\Users\\James\\osdcnew\\osrs-data-converter\\osdc\\misc\\xteas.json"));


        try(Cache cache = new Cache(FileStore.open("C:\\Users\\James\\osdcnew\\osrs-data-converter\\osdc\\dump\\caches\\#177\\")); RandomAccessFile raf = new RandomAccessFile(new File(dir,
                "map_index").toPath().toString(), "rw")) {
            System.out.println("Generating map_index...");

            int total = 0;
            raf.seek(2L);

            int end;

            int mapCount = 0;
            int landCount = 0;

            for (end = 0; end < 256; end++) {
                for (int i = 0; i < 256; i++) {
                    int var17 = end << 8 | i;
                    int x = cache.getFileId(5, "m" + end + "_" + i);
                    int y = cache.getFileId(5, "l" + end + "_" + i);
                    if ((x != -1) && (y != -1)) {
                        raf.writeShort(var17);
                        raf.writeShort(x);
                        raf.writeShort(y);
                        total++;
                    }
                }
            }

            end = (int) raf.getFilePointer();
            raf.seek(0L);
            raf.writeShort(total);
            raf.seek(end);
            raf.close();
            System.out.println("Done dumping map_index.");

            for (int i = 0; i < MAX_REGION; i++) {
                int[] keys = XTEAManager.lookup(i);
                int x = i >> 8;
                int y = i & 0xFF;
                int map = cache.getFileId(5, "m" + x + "_" + y);
                int land = cache.getFileId(5, "l" + x + "_" + y);

                if (map != -1) {
                    try {
                        Container container = cache.read(5, map);
                        byte[] data = new byte[container.getData().limit()];
                        container.getData().get(data);

                        try(FileOutputStream fos = new FileOutputStream(new File(mapDir, map + ".gz"))) {
                            fos.write(GZip.compress(data));
                        }

                        mapCount++;
                    } catch (Exception ex) {
                        System.out.println(String.format("Failed to decrypt map: %d", map));
                    }
                }

                if (land != -1) {
                    try {
                        Container container = cache.read(5, land, keys);
                        byte[] data = new byte[container.getData().limit()];
                        container.getData().get(data);

                        try(FileOutputStream fos = new FileOutputStream(new File(mapDir, land + ".gz"))) {
                            fos.write(GZip.compress(data));
                        }

                        landCount++;
                    } catch (Exception ex) {
                        System.out.println(String.format("Failed to decrypt landscape: %d", land));
                    }
                }

                double progress = (double) (i + 1) / MAX_REGION * 100;
                System.out.println(String.format("%.2f%s", progress, "%"));

            }

            int totalCount = mapCount + landCount;

            System.out.println(String.format("Dumped %d map count %d land count %d total count", mapCount, landCount, totalCount));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    private static final int MAX_REGION = 32768;
    private static final int MAP_SCALE = 2;

    private static final boolean LABEL = true;
    private static final boolean OUTLINE = true;
    private static final boolean FILL = true;

}

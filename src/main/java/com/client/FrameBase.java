package com.client;

public final class FrameBase {

    public FrameBase(Buffer stream) {
        int anInt341 = stream.readUShort();
        transformationType = new int[anInt341];
        skinList = new int[anInt341][];
        for(int j = 0; j < anInt341; j++)
        	transformationType[j] = stream.readUShort();
		for(int j = 0; j < anInt341; j++)
			skinList[j] = new int[stream.readUShort()];
        for(int j = 0; j < anInt341; j++)
			for(int l = 0; l < skinList[j].length; l++)
				skinList[j][l] = stream.readUShort();
    }

    public final int[] transformationType;//anIntArray342
    public final int[][] skinList;//anIntArray343
}

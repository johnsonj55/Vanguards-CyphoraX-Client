package com.client;

public final class Frame {

	public static void method528() {
	 	animationlist = new Frame[4500][0];
	}

	public static void load(int file, byte[] fileData){
		try {
			Buffer stream = new Buffer(fileData);
            FrameBase class18 = new FrameBase(stream);
			int k1 = stream.readUShort();
			animationlist[file] = new Frame[(int)(k1*3)];
			int ai[] = new int[500];
			int ai1[] = new int[500];
			int ai2[] = new int[500];
			int ai3[] = new int[500];
			for(int l1 = 0; l1 < k1; l1++) {
				int i2 = stream.readUShort();
				Frame class36 = animationlist[file][i2] = new Frame();
				class36.base = class18;
				int j2 = stream.readUnsignedByte();
				int l2 = 0;
				int k2 = -1;
				for(int i3 = 0; i3 < j2; i3++) {
					int j3 = stream.readUnsignedByte();
					if(j3 > 0) {
						if(class18.transformationType[i3] != 0) {
							for(int l3 = i3 - 1; l3 > k2; l3--) {
								if(class18.transformationType[l3] != 0)
									continue;
								ai[l2] = l3;
								ai1[l2] = 0;
								ai2[l2] = 0;
								ai3[l2] = 0;
								l2++;
								break;
							}
						}
						ai[l2] = i3;
						short c = 0;
						if(class18.transformationType[i3] == 3)
							c = (short)128;
						if((j3 & 1) != 0)
							ai1[l2] = (short)stream.readShort2();
						else
							ai1[l2] = c;
						if((j3 & 2) != 0)
							ai2[l2] = stream.readShort2();
						else
							ai2[l2] = c;
						if((j3 & 4) != 0)
							ai3[l2] = stream.readShort2();
						else
							ai3[l2] = c;
						k2 = i3;
						l2++;
					}
				}
				class36.transformationCount = l2;
				class36.transformationIndices = new int[l2];
				class36.transformX = new int[l2];
				class36.transformY = new int[l2];
				class36.transformZ = new int[l2];
				for(int k3 = 0; k3 < l2; k3++) {
					class36.transformationIndices[k3] = ai[k3];
					class36.transformX[k3] = ai1[k3];
					class36.transformY[k3] = ai2[k3];
					class36.transformZ[k3] = ai3[k3];
				}
			}
		} catch(Exception exception) {
			System.err.println("Error reading Class36 file: " + file);
		}
	}

    public static int getClass36Id(int i) {
		try {
			String s = "";
			int file = 0;
			int k = 0;
			s = Integer.toHexString(i);
			file = Integer.parseInt(s.substring(0, s.length() - 4), 16);
			k = Integer.parseInt(s.substring(s.length() - 4), 16);
			return file;
		} catch (NumberFormatException | StringIndexOutOfBoundsException e) {
			return 0;
		}
	}

	public static Frame method531(int i) {
		try {
			String s = "";
			int file = 0;
			int k = 0;
			s = Integer.toHexString(i);
			file = Integer.parseInt(s.substring(0, s.length() - 4), 16);
			k = Integer.parseInt(s.substring(s.length() - 4), 16);
			if(animationlist[file].length == 0) {
				clientInstance.resourceProvider.provide(1, file);
				return null;
			}
			return animationlist[file][k];
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static void nullLoader() {
		animationlist = null;
	}

	public static boolean noAnimationInProgress(int i) {
		return i == -1;
	}
	
	public static Frame animationlist[][];
	public int anInt636;
	public FrameBase base;
	public int transformationCount;
	public int transformationIndices[];
	public int transformX[];
	public int transformY[];
	public int transformZ[];
	public static Client clientInstance;

}

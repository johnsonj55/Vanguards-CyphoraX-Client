package com.client.definitions;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Arrays;

import com.client.Configuration;
import com.client.ReferenceCache;
import com.client.Model;
import com.client.Buffer;
import com.client.FileArchive;

public final class GraphicsDefinition {

	public static void unpackConfig(FileArchive streamLoader) {
		Buffer stream = new Buffer(streamLoader.readFile("spotanim.dat"));
		int length = stream.readUShort();
		if (cache == null)
			cache = new GraphicsDefinition[length + 15000];
		for (int j = 0; j < length; j++) {
			if (cache[j] == null) {
				cache[j] = new GraphicsDefinition();
			}
			if (j == 65535) {
				j = -1;
			}
			cache[j].id = j;
			cache[j].setDefault();
			cache[j].readValues(stream);
		}
		cache[1282] = new GraphicsDefinition();
		cache[1282].id = 1282;
		cache[1282].modelId = 44811;
		cache[1282].animationId = 7155;
		cache[1282].animationSequence = AnimationDefinition.anims[cache[1282].animationId];

		if (Configuration.dumpDataLists) {
			gfxDump();
		}
	}

	public static void gfxDump() {
		try {
			BufferedWriter fw = new BufferedWriter(new FileWriter("./temp/gfx_list.txt"));
			for (int i = 0; i < cache.length; i++) {
				GraphicsDefinition item = cache[i];
				if (item == null)
					continue;
				fw.write("case " + i + ":");
				fw.write(System.getProperty("line.separator"));

				fw.write("gfx.anIntArray409 = \"" + Arrays.toString(item.recolorToReplace) + "\";");
				fw.write(System.getProperty("line.separator"));

				fw.write("gfx.modelId = \"" + item.modelId + "\";");
				fw.write(System.getProperty("line.separator"));

				fw.write("break;");
				fw.write(System.getProperty("line.separator"));
				fw.write(System.getProperty("line.separator"));
			}
			fw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public short[] textureReplace;
	public short[] textureFind;

	private void readValues(Buffer buffer) {
		while(true) {
			int opcode = buffer.readUnsignedByte();
			if (opcode == 0) {
				return;
			}
			if (opcode == 1) {
				modelId = buffer.readUShort();
			} else if (opcode == 2) {
				animationId = buffer.readUShort();
				if (AnimationDefinition.anims != null) {
					animationSequence = AnimationDefinition.anims[animationId];
				}
			} else if (opcode == 4) {
				resizeXY = buffer.readUShort();
			} else if (opcode == 5) {
				resizeZ = buffer.readUShort();
			} else if (opcode == 6) {
				rotation = buffer.readUShort();
			} else if (opcode == 7) {
				modelBrightness = buffer.readUnsignedByte();
			} else if (opcode == 8) {
				modelShadow = buffer.readUnsignedByte();
			} else if (opcode == 40) {
				int j = buffer.readUnsignedByte();
				for (int k = 0; k < j; k++) {
					recolorToFind[k] = buffer.readUShort();
					recolorToReplace[k] = buffer.readUShort();
				}
			} else if (opcode == 41) { // re-texture
				int len = buffer.readUnsignedByte();
				textureFind = new short[len];
				textureReplace = new short[len];
				for (int i = 0; i < len; i++) {
					textureFind[i] = (short) buffer.readUShort();
					textureReplace[i] = (short) buffer.readUShort();
				}
			} else {
				System.out.println("Error unrecognised spotanim config code: " + opcode);
			}
		}
	}

	
	public static GraphicsDefinition fetch(int modelId) {
		for (GraphicsDefinition anim : cache) {
			if (anim == null) {
				continue;
			}
			if (anim.modelId == modelId) {
				return anim;
			}
		}
		return null;
	}

	public Model getModel() {
		Model model = (Model) aMRUNodes_415.get(id);
		if (model != null)
			return model;
		model = Model.getModel(modelId);
		if (model == null)
			return null;
		for (int i = 0; i < recolorToFind.length; i++)
			if (recolorToFind[0] != 0) //default frame id
				model.recolor(recolorToFind[i], recolorToReplace[i]);
		if (textureReplace != null) {
			for (int i1 = 0; i1 < textureReplace.length; i1++)
				model.retexture(textureReplace[i1], textureFind[i1]);
		}
		aMRUNodes_415.put(model, id);
		return model;
	}
	
	private void setDefault() {
		modelId = -1;
		animationId = -1;
		recolorToFind = new int[6];
		recolorToReplace = new int[6];
		resizeXY = 128;
		resizeZ = 128;
		rotation = 0;
		modelBrightness = 0;
		modelShadow = 0;
	}

	public GraphicsDefinition() {
		anInt400 = 9;
		animationId = -1;
		recolorToFind = new int[6];
		recolorToReplace = new int[6];
		resizeXY = 128;
		resizeZ = 128;
	}
	
	public int getModelId() {
		return modelId;
	}
	
	public int getIndex() {
		return id;
	}

	public final int anInt400;
	public static GraphicsDefinition cache[];
	public int id;
	private int modelId;
	public int animationId;
	public AnimationDefinition animationSequence;
	public int[] recolorToFind;
	public int[] recolorToReplace;
	public int resizeXY;
	public int resizeZ;
	public int rotation;
	public int modelBrightness;
	public int modelShadow;
	public static ReferenceCache aMRUNodes_415 = new ReferenceCache(30);

}

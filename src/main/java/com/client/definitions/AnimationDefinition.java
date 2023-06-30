package com.client.definitions;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Arrays;

import com.client.*;
import com.client.definitions.custom.AnimationDefinitionCustom;
import com.google.common.collect.Lists;

public final class AnimationDefinition {

	public static void unpackConfig(FileArchive streamLoader) {
		Buffer1 stream = new Buffer1(streamLoader.readFile("seq.dat"));
		int length = stream.readUShort();
		if (anims == null)
			anims = new AnimationDefinition[length];

		for (int j = 0; j < length; j++) {
			if (anims[j] == null)
				anims[j] = new AnimationDefinition();
			anims[j].id = j;
			anims[j].readValues(stream);
			AnimationDefinitionCustom.custom(j, anims);

			if (Configuration.dumpAnimationData) {
				if (anims[j].durations != null && anims[j].durations.length > 0) {
					int sum = 0;
					for (int i = 0; i < anims[j].durations.length; i++) {
						if (anims[j].durations[i] < 100) {
							sum += anims[j].durations[i];
						}
					}

					System.out.println(j + ":" + sum);
				}
			}
		}

		if (Configuration.dumpAnimationData) {
			System.out.println("Dumping animation lengths..");

			try (BufferedWriter writer = new BufferedWriter(new FileWriter("./temp/animation_lengths.cfg"))) {
				for (int j = 0; j < length; j++) {
					if (anims[j].durations != null && anims[j].durations.length > 0) {
						int sum = 0;
						for (int i = 0; i < anims[j].durations.length; i++) {
							if (anims[j].durations[i] < 100) {
								sum += anims[j].durations[i];
							}
						}
						writer.write(j + ":" + sum);
						writer.newLine();
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			System.out.println("Dumping animation sounds..");
			for (int j = 0; j < length; j++) {
				if (anims[j].frameSounds != null) {
					System.out.println(j +":" + Arrays.toString(anims[j].frameSounds));
				}
			}

			System.out.println("Dumping animation fields to /temp/animation_dump.txt");
			dump();
		}
	}

	public int getFrameSound(int frameIndex) {
		if (frameSounds != null && frameIndex < frameSounds.length && frameSounds[frameIndex] != 0) {
			return frameSounds[frameIndex];
		} else {
			return -1;
		}
	}

	public int method258(int i) {
		try {
			int j = durations[i];
			if (j == 0) {
				Frame class36 = Frame.method531(primaryFrames[i]);
				if (class36 != null)
					j = durations[i] = class36.anInt636;
			}
			if (j == 0)
				j = 1;
			return j;
		} catch (Exception e) {
			System.err.println("Error in animation id: " + id);
			e.printStackTrace();
			return 0;
		}
	}

	private void readValues(Buffer1 buffer) {
		int opcode;
		while ((opcode = buffer.readUnsignedByte()) != 0) {

			if (opcode == 1) {
				frameCount = buffer.readUShort();
				primaryFrames = new int[frameCount];
				secondaryFrames = new int[frameCount];
				durations = new int[frameCount];

				for (int j = 0; j < frameCount; j++) {
					durations[j] = buffer.readUShort();
				}

				for (int j = 0; j < frameCount; j++) {
					primaryFrames[j] = buffer.readUShort();
					secondaryFrames[j] = -1;
				}

				for (int j = 0; j < frameCount; j++) {
					primaryFrames[j] += buffer.readUShort() << 16;
				}
			} else if (opcode == 2)
				loopOffset = buffer.readUShort();
			else if (opcode == 3) {
				int k = buffer.readUnsignedByte();
				interleaveOrder = new int[k + 1];
				for (int l = 0; l < k; l++)
					interleaveOrder[l] = buffer.readUnsignedByte();
				interleaveOrder[k] = 9999999;
			} else if (opcode == 4)
				stretches = true;
			else if (opcode == 5)
				forcedPriority = buffer.readUnsignedByte();
			else if (opcode == 6)
				playerOffhand = buffer.readUShort();
			else if (opcode == 7)
				playerMainhand = buffer.readUShort();
			else if (opcode == 8)
				maximumLoops = buffer.readUnsignedByte();
			else if (opcode == 9)
				animatingPrecedence = buffer.readUnsignedByte();
			else if (opcode == 10)
				priority = buffer.readUnsignedByte();
			else if (opcode == 11)
				replayMode = buffer.readUnsignedByte();
			else if (opcode == 12) {
				int len = buffer.readUnsignedByte();
				chatFrameIds = new int[len];
				for (int i2 = 0; i2 < len; i2++) {
					chatFrameIds[i2] = buffer.readUShort();
				}

				for (int i2 = 0; i2 < len; i2++) {
					chatFrameIds[i2] += buffer.readUShort() << 16;
				}
			} else if (opcode == 13) {
				int var3 = buffer.readUnsignedByte();
				frameSounds = new int[var3];
				for (int var4 = 0; var4 < var3; ++var4)
				{
					frameSounds[var4] = buffer.read24Int();
				}
			} else if (opcode == 14) {
				skeletalId = buffer.readInt();
			} else if (opcode == 15) {
				int count = buffer.readUShort();
				skeletalsoundEffect = new int[count];
				skeletalsoundRange = new int[count];
				for (int index = 0; index < count; ++index) {
					skeletalsoundEffect[index] = buffer.readUShort();
					skeletalsoundRange[index] = buffer.readTriByte();
				}
			} else if (opcode == 16) {
				skeletalRangeBegin = buffer.readUShort();
				skeletalRangeEnd = buffer.readUShort();
			} else if (opcode == 17) {
				int count = buffer.readUnsignedByte();
				unknown = new int[count];
				for (int index = 0; index < count; ++index) {
					unknown[index] = buffer.readUnsignedByte();
				}
			} else if (opcode == 127) {
				// Hidden
			} else System.out.println("Error unrecognised seq config code: " + opcode);
		}
		if (frameCount == 0) {
			frameCount = 1;
			primaryFrames = new int[1];
			primaryFrames[0] = -1;
			secondaryFrames = new int[1];
			secondaryFrames[0] = -1;
			durations = new int[1];
			durations[0] = -1;
		}
		if (animatingPrecedence == -1)
			if (interleaveOrder != null)
				animatingPrecedence = 2;
			else
				animatingPrecedence = 0;
		if (priority == -1) {
			if (interleaveOrder != null) {
				priority = 2;
				return;
			}
			priority = 0;
		}
	}

	public AnimationDefinition() {
		loopOffset = -1;
		stretches = false;
		forcedPriority = 5;
		playerOffhand = -1;
		playerMainhand = -1;
		maximumLoops = 99;
		animatingPrecedence = -1;
		priority = -1;
		replayMode = 2;
	}

	public static AnimationDefinition anims[];
	public int id;
	public int frameCount;
	public int primaryFrames[];
	public int secondaryFrames[];
	public int frameSounds[];
	public int[] durations;
	public int loopOffset;
	public int interleaveOrder[];
	public boolean stretches;
	public int forcedPriority;
	public int playerOffhand;
	public int playerMainhand;
	public int maximumLoops;
	public int animatingPrecedence;
	public int priority;
	public int replayMode;

	public static void dump() {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter("./temp/animation_dump.txt"))) {
			for (int index = 0; index < anims.length; index++) {
				AnimationDefinition anim = anims[index];
				if (anim != null) {
					writer.write("\tcase " + index + ":");
					writer.newLine();
					writer.write("\t\tanim.anInt352 = " + anim.frameCount + ";");
					writer.newLine();
					writer.write("\t\tanim.anInt356 = " + anim.loopOffset + ";");
					writer.newLine();
					writer.write("\t\tanim.aBoolean358 = " + anim.stretches + ";");
					writer.newLine();
					writer.write("\t\tanim.anInt359 = " + anim.forcedPriority + ";");
					writer.newLine();
					writer.write("\t\tanim.anInt360 = " + anim.playerOffhand + ";");
					writer.newLine();
					writer.write("\t\tanim.anInt361 = " + anim.playerMainhand + ";");
					writer.newLine();
					writer.write("\t\tanim.anInt362 = " + anim.maximumLoops + ";");
					writer.newLine();
					writer.write("\t\tanim.anInt363 = " + anim.animatingPrecedence + ";");
					writer.newLine();
					writer.write("\t\tanim.anInt364 = " + anim.priority + ";");
					writer.newLine();
					writer.write("\t\tanim.anInt352 = " + anim.frameCount + ";");
					writer.newLine();
					writeArray(writer, "anIntArray353", anim.primaryFrames);
					writeArray(writer, "anIntArray354", anim.secondaryFrames);
					writeArray(writer, "frameLengths", anim.durations);
					writeArray(writer, "anIntArray357", anim.interleaveOrder);
					writeArray(writer, "class36Ids", anim.getClass36Ids());
					writer.write("\t\tbreak;");
					writer.newLine();
					writer.newLine();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private int[] getClass36Ids() {
		List<Integer> ids = Lists.newArrayList();
		for (int frameId : primaryFrames) {
			if (!ids.contains(Frame.getClass36Id(frameId))) {
				ids.add(Frame.getClass36Id(frameId));
			}
		}
		int[] idsArray = new int[ids.size()];
		for (int index = 0; index < idsArray.length; index++)
			idsArray[index] = ids.get(index);
		return idsArray;
	}

	private static void writeArray(BufferedWriter writer, String name, int[] array) throws IOException {
		writer.write("\t\tanim." + name + " = ");

		if (array == null) {
			writer.write("null;");
		} else {
			writer.write("new int[] {");
			for (int value : array) {
				writer.write(value + ", ");
			}
			writer.write("};");
		}

		writer.newLine();
	}

	public int chatFrameIds[];
	private int skeletalRangeBegin = -1;
	private int skeletalRangeEnd = -1;
	private int skeletalId = -1;
	private int[] skeletalsoundEffect;
	private int[] unknown;
	private int[] skeletalsoundRange;
}
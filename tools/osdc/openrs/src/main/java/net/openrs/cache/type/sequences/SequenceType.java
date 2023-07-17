/**
* Copyright (c) Kyle Fricilone
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package net.openrs.cache.type.sequences;

import java.io.DataOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

import net.openrs.cache.type.Type;
import net.openrs.util.ByteBufferUtils;

/**
 * @author Kyle Friz
 * @since Oct 18, 2015
 */
public class SequenceType implements Type {

	private final int id;
	private int[] anIntArray2118;
	private int walkingPrecedence = -1;
	private int[] frameIDs;
	private int[] frameLengths;
	private int[] anIntArray2126;
	private int frameStep = -1;
	private int[] interleaveLeave;
	private boolean stretches = false;
	private int forcedPriority = 5;
	private int leftHandItem = -1;
	private int maxLoops = 99;
	private int rightHandItem = -1;
	private int replayMode = 2;
	private int precedenceAnimating = -1;

	public SequenceType(int id) {
		this.id = id;
	}

	@Override
	public void decode(ByteBuffer buffer) {
		while (true) {
			int opcode = buffer.get() & 0xFF;
			if (opcode == 0) {
				break;
			} else if (opcode == 1) {
				int count = buffer.getShort() & 0xFFFF;
				this.frameLengths = new int[count];
				this.frameIDs = new int[count];

				for (int i = 0; i < count; ++i) {
					this.frameLengths[i] = buffer.getShort() & 0xFFFF;
				}

				for (int i = 0; i < count; ++i) {
					this.frameIDs[i] = buffer.getShort() & 0xFFFF;
				}

				for (int i = 0; i < count; ++i) {
					this.frameIDs[i] += (buffer.getShort() & 0xFFFF) << 16;
				}

			} else if (opcode == 2) {
				this.frameStep = buffer.getShort() & 0xFFFF;
			} else if (opcode == 3) {
				final int count = buffer.get() & 0xFF;
				this.interleaveLeave = new int[count + 1];

				for (int index = 0; index < count; ++index) {
					this.interleaveLeave[index] = buffer.get() & 0xFF;
				}

				this.interleaveLeave[count] = 9999999;
			} else if (opcode == 4) {
				this.stretches = true;
			} else if (opcode == 5) {
				this.forcedPriority = buffer.get() & 0xFF;
			} else if (opcode == 6) {
				this.leftHandItem = buffer.getShort() & 0xFFFF;
			} else if (opcode == 7) {
				this.rightHandItem = buffer.getShort() & 0xFFFF;
			} else if (opcode == 8) {
				this.maxLoops = buffer.get() & 0xFF;
			} else if (opcode == 9) {
				this.precedenceAnimating = buffer.get() & 0xFF;
			} else if (opcode == 10) {
				this.walkingPrecedence = buffer.get() & 0xFF;
			} else if (opcode == 11) {
				this.replayMode = buffer.get() & 0xFF;
			} else if (opcode == 12) {
				final int count = buffer.get() & 0xFF;
				this.anIntArray2118 = new int[count];

				for (int i = 0; i < count; ++i) {
					this.anIntArray2118[i] = buffer.getShort() & 0xFFFF;
				}

				for (int i = 0; i < count; ++i) {
					this.anIntArray2118[i] += (buffer.getShort() & 0xFFFF) << 16;
				}

			} else if (opcode == 13) {
				final int count = buffer.get() & 0xFF;
				this.anIntArray2126 = new int[count];

				for (int index = 0; index < count; ++index) {
					this.anIntArray2126[index] = ByteBufferUtils.get24Int(buffer);
				}

			}
		}
	}

	@Override
	public void encode(DataOutputStream dos) throws IOException {
		if (frameLengths != null && frameIDs != null) {
			dos.writeByte(1);
			dos.writeShort(frameLengths.length);

			for (int i = 0; i < frameLengths.length; i++) {
				dos.writeShort(frameLengths[i]);
			}

			for (int i = 0; i < frameIDs.length; i++) {
				dos.writeShort(frameIDs[i]);
			}

			for (int i = 0; i < frameIDs.length; i++) {
				dos.writeShort(frameIDs[i] >> 16);
			}

		}

		if (frameStep != -1) {
			dos.writeByte(2);
			dos.writeShort(frameStep);
		}

		if (interleaveLeave != null) {
			dos.writeByte(3);
			dos.writeByte(interleaveLeave.length - 1);

			for (int i = 0; i < interleaveLeave.length - 1; i++) {
				dos.writeByte(interleaveLeave[i]);
			}
		}

		if (stretches) {
			dos.writeByte(4);
		}

		if (forcedPriority != 5) {
			dos.writeByte(5);
			dos.writeByte(forcedPriority);
		}

		if (leftHandItem != -1) {
			dos.writeByte(6);
			dos.writeShort(leftHandItem);
		}

		if (rightHandItem != -1) {
			dos.writeByte(7);
			dos.writeShort(rightHandItem);
		}

		if (maxLoops != 99) {
			dos.writeByte(8);
			dos.writeByte(maxLoops);
		}

		if (precedenceAnimating != -1) {
			dos.writeByte(9);
			dos.writeByte(precedenceAnimating);
		}

		if (walkingPrecedence != -1) {
			dos.writeByte(10);
			dos.writeByte(walkingPrecedence);
		}

		if (replayMode != 2) {
			dos.writeByte(11);
			dos.writeByte(replayMode);
		}

		if (anIntArray2118 != null && anIntArray2118.length > 0) {
			dos.writeByte(12);
			dos.writeByte(anIntArray2118.length);

			for (int i = 0; i < anIntArray2118.length; i++) {
				dos.writeShort(anIntArray2118[i]);
			}

			for (int i = 0; i < anIntArray2118.length; i++) {
				dos.writeShort(anIntArray2118[i] >> 16);
			}
		}

		if (anIntArray2126 != null && anIntArray2126.length > 0) {
			dos.writeByte(13);
			dos.writeByte(anIntArray2126.length);

			for (int i = 0; i < anIntArray2126.length; i++) {
				dos.writeByte(anIntArray2126[i] >> 16);
				dos.writeByte(anIntArray2126[i] >> 8);
				dos.writeByte(anIntArray2126[i]);
			}
		}
	}

	@Override
	public int getID() {
		return id;
	}

	public int[] getAnIntArray2118() {
		return anIntArray2118;
	}

	public void setAnIntArray2118(int[] anIntArray2118) {
		this.anIntArray2118 = anIntArray2118;
	}

	public int getPriority() {
		return walkingPrecedence;
	}

	public void setPriority(int priority) {
		this.walkingPrecedence = priority;
	}

	public int[] getFrameIDs() {
		return frameIDs;
	}

	public void setFrameIDs(int[] frameIDs) {
		this.frameIDs = frameIDs;
	}

	public int[] getFrameLengths() {
		return frameLengths;
	}

	public void setFrameLengths(int[] frameLengths) {
		this.frameLengths = frameLengths;
	}

	public int[] getAnIntArray2126() {
		return anIntArray2126;
	}

	public void setAnIntArray2126(int[] anIntArray2126) {
		this.anIntArray2126 = anIntArray2126;
	}

	public int getFrameStep() {
		return frameStep;
	}

	public void setFrameStep(int frameStep) {
		this.frameStep = frameStep;
	}

	public int[] getInterleaveLeave() {
		return interleaveLeave;
	}

	public void setInterleaveLeave(int[] interleaveLeave) {
		this.interleaveLeave = interleaveLeave;
	}

	public boolean isStretches() {
		return stretches;
	}

	public void setStretches(boolean stretches) {
		this.stretches = stretches;
	}

	public int getForcedPriority() {
		return forcedPriority;
	}

	public void setForcedPriority(int forcedPriority) {
		this.forcedPriority = forcedPriority;
	}

	public int getLeftHandItem() {
		return leftHandItem;
	}

	public void setLeftHandItem(int leftHandItem) {
		this.leftHandItem = leftHandItem;
	}

	public int getMaxLoops() {
		return maxLoops;
	}

	public void setMaxLoops(int maxLoops) {
		this.maxLoops = maxLoops;
	}

	public int getRightHandItem() {
		return rightHandItem;
	}

	public void setRightHandItem(int rightHandItem) {
		this.rightHandItem = rightHandItem;
	}

	public int getReplayMode() {
		return replayMode;
	}

	public void setReplayMode(int replayMode) {
		this.replayMode = replayMode;
	}

	public int getPrecedenceAnimating() {
		return precedenceAnimating;
	}

	public void setPrecedenceAnimating(int precedenceAnimating) {
		this.precedenceAnimating = precedenceAnimating;
	}
}

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
package net.openrs.cache.type.overlays;

import java.io.DataOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

import net.openrs.cache.type.Type;
import net.openrs.util.ByteBufferUtils;

/**
 * @author Kyle Friz
 * 
 * @since Jun 13, 2015
 */
public class OverlayType implements Type {

	public final int id;
	public int rgb = 0;
	public int texture = -1;
	public int secondaryRgb = -1;
	public boolean hideUnderlay = true;

	public OverlayType(int id) {
		this.id = id;
	}

	@Override
	public void decode(ByteBuffer buffer) {
		while (true) {
			final int opcode = buffer.get() & 0xFF;

			if (opcode == 0) {
				break;
			} else if (opcode == 1) {
				rgb = ByteBufferUtils.get24Int(buffer);
			} else if (opcode == 2) {
				texture = buffer.get() & 0xFF;
			} else 	if (opcode == 5) {
				hideUnderlay = false;
			} else  if (opcode == 7) {
				secondaryRgb = ByteBufferUtils.get24Int(buffer);
			}
		}
	}

	@Override
	public void encode(DataOutputStream dos) throws IOException {
		if (rgb != 0) {
			dos.writeByte(1);
			dos.writeByte(rgb >> 16);
			dos.writeByte(rgb >> 8);
			dos.writeByte(rgb);
		}

		if (texture != -1) {
			dos.writeByte(2);
			dos.writeByte(texture);
		}

		if (!hideUnderlay) {
			dos.writeByte(5);
		}

		if (secondaryRgb != -1) {
			dos.writeByte(7);
			dos.writeByte(secondaryRgb >> 16);
			dos.writeByte(secondaryRgb >> 8);
			dos.writeByte(secondaryRgb);
		}

		dos.writeByte(0);
	}

	@Override
	public int getID() {
		return id;
	}

	public int getRgbColor() {
		return rgb;
	}

	public int getTexture() {
		return texture;
	}

	public int getSecondaryRgbColor() {
		return secondaryRgb;
	}

	public boolean isHideUnderlay() {
		return hideUnderlay;
	}

}

package net.openrs.util;

import java.io.IOException;
import java.nio.ByteBuffer;

public class InputStream extends java.io.InputStream
{
	private static final char[] CHARACTERS = new char[]
	{
		'\u20ac', '\u0000', '\u201a', '\u0192', '\u201e', '\u2026',
		'\u2020', '\u2021', '\u02c6', '\u2030', '\u0160', '\u2039',
		'\u0152', '\u0000', '\u017d', '\u0000', '\u0000', '\u2018',
		'\u2019', '\u201c', '\u201d', '\u2022', '\u2013', '\u2014',
		'\u02dc', '\u2122', '\u0161', '\u203a', '\u0153', '\u0000',
		'\u017e', '\u0178'
	};

	private final ByteBuffer buffer;

	public InputStream(byte[] buffer)
	{
		this.buffer = ByteBuffer.wrap(buffer);
	}

	public byte[] getArray()
	{
		assert buffer.hasArray();
		return buffer.array();
	}

	@Override
	public String toString()
	{
		return "InputStream{" + "buffer=" + buffer + '}';
	}

	public int read24BitInt()
	{
		return (this.readUnsignedByte() << 16) + (this.readUnsignedByte() << 8) + this.readUnsignedByte();
	}

	public void skip(int length)
	{
		int pos = buffer.position();
		pos += length;
		buffer.position(pos);
	}

	public void setOffset(int offset)
	{
		buffer.position(offset);
	}

	public int getOffset()
	{
		return buffer.position();
	}

	public int getLength()
	{
		return buffer.limit();
	}

	public int remaining()
	{
		return buffer.remaining();
	}

	public byte readByte()
	{
		return buffer.get();
	}

	public void readBytes(byte[] buffer, int off, int len)
	{
		this.buffer.get(buffer, off, len);
	}

	public void readBytes(byte[] buffer)
	{
		this.buffer.get(buffer);
	}

	public int readUnsignedByte()
	{
		return this.readByte() & 0xFF;
	}

	public int readUnsignedShort()
	{
		return buffer.getShort() & 0xFFFF;
	}

	public short readShort()
	{
		return buffer.getShort();
	}

	public int readInt()
	{
		return buffer.getInt();
	}

	public byte peek()
	{
		return buffer.get(buffer.position());
	}

	public int readBigSmart()
	{
		return peek() >= 0 ? (this.readUnsignedShort() & 0xFFFF) : (this.readInt() & Integer.MAX_VALUE);
	}

	public int readBigSmart2()
	{
		if (peek() < 0)
		{
			return readInt() & Integer.MAX_VALUE; // and off sign bit
		}
		int value = readUnsignedShort();
		return value == 32767 ? -1 : value;
	}

	public int readShortSmart()
	{
		int peek = this.peek() & 0xFF;
		return peek < 128 ? this.readUnsignedByte() - 64 : this.readUnsignedShort() - 0xc000;
	}

	public int readUnsignedShortSmart()
	{
		int peek = this.peek() & 0xFF;
		return peek < 128 ? this.readUnsignedByte() : this.readUnsignedShort() - 0x8000;
	}

	public String readString()
	{
		StringBuilder sb = new StringBuilder();

		for (;;)
		{
			int ch = this.readUnsignedByte();

			if (ch == 0)
			{
				break;
			}

			if (ch >= 128 && ch < 160)
			{
				char var7 = CHARACTERS[ch - 128];
				if (0 == var7)
				{
					var7 = '?';
				}

				ch = var7;
			}

			sb.append((char) ch);
		}
		return sb.toString();
	}

	public String readStringOrNull()
	{
		if (this.peek() != 0)
		{
			return readString();
		}
		else
		{
			this.readByte(); // discard
			return null;
		}
	}

	public int readVarInt()
	{
		byte var1 = this.readByte();

		int var2;
		for (var2 = 0; var1 < 0; var1 = this.readByte())
		{
			var2 = (var2 | var1 & 127) << 7;
		}

		return var2 | var1;
	}

	public byte[] getRemaining()
	{
		byte[] b = new byte[buffer.remaining()];
		buffer.get(b);
		return b;
	}

	@Override
	public int read() throws IOException
	{
		return this.readUnsignedByte();
	}
}

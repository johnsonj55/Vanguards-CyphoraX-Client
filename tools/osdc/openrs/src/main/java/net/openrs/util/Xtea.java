package net.openrs.util;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

public class Xtea
{
	private static final int GOLDEN_RATIO = 0x9E3779B9;

	private static final int ROUNDS = 32;

	private final int[] key;

	public Xtea(int[] key)
	{
		this.key = key;
	}

	public byte[] encrypt(byte[] data, int len)
	{
		ByteBuf buf = Unpooled.wrappedBuffer(data, 0, len);
		ByteBuf out = Unpooled.buffer(len);
		int numBlocks = len / 8;
		for (int block = 0; block < numBlocks; ++block)
		{
			int v0 = buf.readInt();
			int v1 = buf.readInt();
			int sum = 0;
			for (int i = 0; i < ROUNDS; ++i)
			{
				v0 += (((v1 << 4) ^ (v1 >>> 5)) + v1) ^ (sum + key[sum & 3]);
				sum += GOLDEN_RATIO;
				v1 += (((v0 << 4) ^ (v0 >>> 5)) + v0) ^ (sum + key[(sum >>> 11) & 3]);
			}
			out.writeInt(v0);
			out.writeInt(v1);
		}
		out.writeBytes(buf);
		return out.array();
	}

	public byte[] decrypt(byte[] data, int len)
	{
		ByteBuf buf = Unpooled.wrappedBuffer(data, 0, len);
		ByteBuf out = Unpooled.buffer(len);
		int numBlocks = len / 8;
		for (int block = 0; block < numBlocks; ++block)
		{
			int v0 = buf.readInt();
			int v1 = buf.readInt();
			int sum = GOLDEN_RATIO * ROUNDS;
			for (int i = 0; i < ROUNDS; ++i)
			{
				v1 -= (((v0 << 4) ^ (v0 >>> 5)) + v0) ^ (sum + key[(sum >>> 11) & 3]);
				sum -= GOLDEN_RATIO;
				v0 -= (((v1 << 4) ^ (v1 >>> 5)) + v1) ^ (sum + key[sum & 3]);
			}
			out.writeInt(v0);
			out.writeInt(v1);
		}
		out.writeBytes(buf);
		return out.array();
	}
}
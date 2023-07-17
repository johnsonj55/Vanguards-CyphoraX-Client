package net.openrs.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;

import org.apache.commons.compress.compressors.bzip2.BZip2CompressorInputStream;
import org.apache.commons.compress.compressors.bzip2.BZip2CompressorOutputStream;
import org.apache.commons.compress.utils.IOUtils;

public class BZip2
{

	private static final byte[] BZIP_HEADER = new byte[]
	{
		'B', 'Z', // magic
		'h',      // 'h' for Bzip2 ('H'uffman coding)
		'1'       // block size
	};

	public static byte[] compress(byte[] bytes) throws IOException
	{
		InputStream is = new ByteArrayInputStream(bytes);
		ByteArrayOutputStream bout = new ByteArrayOutputStream();
		try (OutputStream os = new BZip2CompressorOutputStream(bout, 1))
		{
			IOUtils.copy(is, os);
		}

		byte[] out = bout.toByteArray();

		assert BZIP_HEADER[0] == out[0];
		assert BZIP_HEADER[1] == out[1];
		assert BZIP_HEADER[2] == out[2];
		assert BZIP_HEADER[3] == out[3];

		return Arrays.copyOfRange(out, BZIP_HEADER.length, out.length); // remove header..
	}

	public static byte[] decompress(byte[] bytes, int len) throws IOException
	{
		byte[] data = new byte[len + BZIP_HEADER.length];

		// add header
		System.arraycopy(BZIP_HEADER, 0, data, 0, BZIP_HEADER.length);
		System.arraycopy(bytes, 0, data, BZIP_HEADER.length, len);

		ByteArrayOutputStream os = new ByteArrayOutputStream();

		try (InputStream is = new BZip2CompressorInputStream(new ByteArrayInputStream(data)))
		{
			IOUtils.copy(is, os);
		}

		return os.toByteArray();
	}
}
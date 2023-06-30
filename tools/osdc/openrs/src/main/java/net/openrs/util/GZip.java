package net.openrs.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

import org.apache.commons.compress.utils.IOUtils;

public class GZip
{
	
	public static byte[] compress(byte[] bytes) throws IOException
	{
		InputStream is = new ByteArrayInputStream(bytes);
		ByteArrayOutputStream bout = new ByteArrayOutputStream();

		try (OutputStream os = new GZIPOutputStream(bout))
		{
			IOUtils.copy(is, os);
		}
		
		return bout.toByteArray();
	}

	public static byte[] decompress(byte[] bytes, int len) throws IOException
	{
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		
		try (InputStream is = new GZIPInputStream(new ByteArrayInputStream(bytes, 0, len)))
		{
			IOUtils.copy(is, os);
		}

		return os.toByteArray();
	}
}
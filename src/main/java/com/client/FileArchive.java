package com.client;
import java.io.*;
import java.util.zip.*;

import com.client.sign.Signlink;

public class FileArchive {

	public FileArchive(byte[] b, String s) {
		try {
			// if (s.contains("2d"))
			// b = getBytesFromFile(new File("./data.dat"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		a(b);
	}

	public static byte[] getBytesFromFile(File file) throws IOException {
		InputStream is = null;
		try {
			is = new FileInputStream(file);
			long length = file.length();
			byte[] bytes = new byte[(int) length];

			int offset = 0;
			int numRead = 0;
			while (offset < bytes.length && (numRead = is.read(bytes, offset, bytes.length - offset)) >= 0) {
				offset += numRead;
			}

			if (offset < bytes.length) {
				throw new IOException("Could not completely read file " + file.getName());
			}

			return bytes;
		} finally {
			if (is != null) {
				is.close();
			}
		}
	}

	public void a(byte abyte0[]) {
		Buffer stream = new Buffer(abyte0);
		int fileSize = stream.read3Bytes();
		int fileBlock = stream.read3Bytes();
		if (fileBlock == 0) { // Read from gzip
			byte[] abyte1 = new byte[fileSize];
			byte[] abyte3 = new byte[fileSize];
			System.arraycopy(abyte0, 6, abyte1, 0, abyte0.length - 6);
			try {
				try (DataInputStream datainputstream = new DataInputStream(new GZIPInputStream(new ByteArrayInputStream(abyte1)))) {
					datainputstream.readFully(abyte3, 0, abyte3.length);
				}
			} catch (Exception exception) {
				exception.printStackTrace();
			}
			data = abyte3;
			stream = new Buffer(data);
			aBoolean732 = true;
		} else if (fileBlock != fileSize) { // Read from something else
			byte abyte1[] = new byte[fileSize];
			Class13.method225(abyte1, fileSize, abyte0, fileBlock, 6);
			data = abyte1;
			stream = new Buffer(data);
			aBoolean732 = true;
		} else { // Raw file
			data = abyte0;
			aBoolean732 = false;
		}
		dataSize = stream.readUShort();
		archiveNameHash = new int[dataSize];
		anIntArray729 = new int[dataSize];
		anIntArray730 = new int[dataSize];
		anIntArray731 = new int[dataSize];
		int k = stream.currentPosition + dataSize * 10;
		for (int l = 0; l < dataSize; l++) {
			archiveNameHash[l] = stream.readDWord();
			anIntArray729[l] = stream.read3Bytes();
			anIntArray730[l] = stream.read3Bytes();
			anIntArray731[l] = k;
			k += anIntArray730[l];
		}
	}

	public byte[] readFile(String s) {
		return getDataForName(s);
	}

	private byte[] getDataForName(String s) {
		byte abyte0[] = null; // was a parameter
		int nameHash = 0;
		s = s.toUpperCase();
		for (int j = 0; j < s.length(); j++)
			nameHash = (nameHash * 61 + s.charAt(j)) - 32;

		for (int k = 0; k < dataSize; k++)
			if (archiveNameHash[k] == nameHash) {
				if (abyte0 == null)
					abyte0 = new byte[anIntArray729[k]];
				if (!aBoolean732) {
					Class13.method225(abyte0, anIntArray729[k], data,
							anIntArray730[k], anIntArray731[k]);
				} else {
					System.arraycopy(data, anIntArray731[k], abyte0,
							0, anIntArray729[k]);

				}
				return abyte0;
			}

		return null;
	}

	public byte[] data;
	public int dataSize;
	public int[] archiveNameHash;
	public int[] anIntArray729;
	public int[] anIntArray730;
	public int[] anIntArray731;
	public boolean aBoolean732;
}

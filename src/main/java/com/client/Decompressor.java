package com.client;

import java.io.*;

// https://www.rune-server.ee/runescape-development/rs2-server/informative-threads/534604-explanation-simplification-runescape-cache.html
public class Decompressor {

	/**
	 * Size of an entry in any index file.
	 * An error contains the file size and the sector where this file begins.
	 */
	public static final int INDEX_SIZE = 6;

	/**
	 * Size of a data block inside that data (.dat) file
	 */
	public static final int DATA_BLOCK_SIZE = 512;

	/**
	 * Size of a data block header inside that data (.dat) file
	 */
	public static final int DATA_HEADER_SIZE = 8;

	/**
	 * Total size of a Sector {@link Decompressor#DATA_BLOCK_SIZE} plus {@link Decompressor#DATA_HEADER_SIZE}
	 */
	public static final int DATA_SIZE = DATA_HEADER_SIZE + DATA_BLOCK_SIZE;

	private static final byte[] buffer = new byte[520];
	private final RandomAccessFile dataFile;
	private final RandomAccessFile indexFile;
	private final int fileType;

	public Decompressor(RandomAccessFile dataFile, RandomAccessFile indexFile, int fileTye) {
		fileType = fileTye;
		this.dataFile = dataFile;
		this.indexFile = indexFile;
	}


	/**
	 * Read a file from the data file.
	 *
	 * First it reads the index file, which contains 6 bytes of information: the total file size and the
	 * sector id where this file begins. It then begins reading the data file in 520 byte sectors. The sectors
	 * contains 8 bytes of header data first (fileId, chunkId, sectorId, typeId) then 512 bytes of file data.
	 *
	 * @param fileId The file id.
	 * @return the file data.
	 */
	public synchronized byte[] read(int fileId) {
		try {
			seekTo(indexFile, fileId * INDEX_SIZE); // Seek index file to position of file data
			int read;
			for (int offset = 0; offset < INDEX_SIZE; offset += read) {
				read = indexFile.read(buffer, offset, 6 - offset);
				if (read == -1)
					return null;
			}
			int fileSize = ((buffer[0] & 0xff) << 16) + ((buffer[1] & 0xff) << 8) + (buffer[2] & 0xff);
			int sectorId = ((buffer[3] & 0xff) << 16) + ((buffer[4] & 0xff) << 8) + (buffer[5] & 0xff);
			if (sectorId <= 0 || (long) sectorId > dataFile.length() / DATA_SIZE)
				return null;
			byte[] fileData = new byte[fileSize];
			int readerIndex = 0;
			for (int chunk = 0; readerIndex < fileSize; chunk++) {
				if (sectorId == 0)
					return null;
				seekTo(dataFile, sectorId * DATA_SIZE); // Seek data file to data start position

				int remaining = fileSize - readerIndex;
				if (remaining > DATA_BLOCK_SIZE)
					remaining = DATA_BLOCK_SIZE;

				int offset = 0;
				for (; offset < remaining + DATA_HEADER_SIZE; offset += read) {
					read = dataFile.read(buffer, offset, (remaining + DATA_HEADER_SIZE) - offset);
					if (read == -1)
						return null;
				}

				// file id is the actual file id, model 1 would have 1 here
				int readFileId = ((buffer[0] & 0xff) << 8) + (buffer[1] & 0xff);

				// Chunk is a piece of the file (read from the 512 sectors)
				int readChunkId = ((buffer[2] & 0xff) << 8) + (buffer[3] & 0xff);

				// sector is the 520 byte blocks of data (512 + 6 for header)
				int readSectorId = ((buffer[4] & 0xff) << 16) + ((buffer[5] & 0xff) << 8) + (buffer[6] & 0xff);

				// Type is the type of file, 1=models, 4=maps, etc
				int readTypeId = buffer[7] & 0xff;

				if (readFileId != fileId || readChunkId != chunk || readTypeId != fileType)
					return null;
				if (readSectorId < 0 || (long) readSectorId > dataFile.length() / DATA_SIZE)
					return null;
				for (int dataReaderIndex = 0; dataReaderIndex < remaining; dataReaderIndex++)
					fileData[readerIndex++] = buffer[dataReaderIndex + 8];

				sectorId = readSectorId;
			}

			return fileData;
		} catch (IOException _ex) {
			_ex.printStackTrace();
			return null;
		}
	}

	public synchronized boolean write(int fileSize, byte[] data, int fileId) {
		boolean flag = write(true, fileId, fileSize, data); // Attempt to overwrite existing index
		if (!flag)
			flag = write(false, fileId, fileSize, data); // Existing index doesn't exist, add a new index
		return flag;
	}

	public synchronized boolean write(boolean overwrite, int fileId, int fileSize, byte[] data) {
		try {
			int firstSectorId;
			if (overwrite) {
				seekTo(indexFile, fileId * INDEX_SIZE);
				int read;
				for (int offset = 0; offset < INDEX_SIZE; offset += read) {
					read = indexFile.read(buffer, offset, INDEX_SIZE - offset);
					if (read == -1)
						return false;
				}
				firstSectorId = ((buffer[3] & 0xff) << 16) + ((buffer[4] & 0xff) << 8) + (buffer[5] & 0xff);
				if (firstSectorId <= 0 || (long) firstSectorId > dataFile.length() / DATA_SIZE)
					return false;
			} else {
				firstSectorId = (int) ((dataFile.length() + 519L) / DATA_SIZE); // Set sector id to the next free 520 block in the dat file
				if (firstSectorId == 0)
					firstSectorId = 1;
			}
			buffer[0] = (byte) (fileSize >> 16);
			buffer[1] = (byte) (fileSize >> 8);
			buffer[2] = (byte) fileSize;
			buffer[3] = (byte) (firstSectorId >> 16);
			buffer[4] = (byte) (firstSectorId >> 8);
			buffer[5] = (byte) firstSectorId;
			seekTo(indexFile, fileId * INDEX_SIZE);
			indexFile.write(buffer, 0, INDEX_SIZE);
			int j1 = 0;
			for (int chunkId = 0; j1 < fileSize; chunkId++) {
				int currentSectorId = 0;
				if (overwrite) {
					// Read stored data header
					seekTo(dataFile, firstSectorId * DATA_SIZE);
					int length;
					int read;
					for (length = 0; length < 8; length += read) {
						read = dataFile.read(buffer, length, DATA_HEADER_SIZE - length);
						if (read == -1)
							break;
					}
					if (length == DATA_HEADER_SIZE) {
						int storedFileId = ((buffer[0] & 0xff) << 8) + (buffer[1] & 0xff);
						int storedChunkId = ((buffer[2] & 0xff) << 8) + (buffer[3] & 0xff);
						currentSectorId = ((buffer[4] & 0xff) << 16) + ((buffer[5] & 0xff) << 8) + (buffer[6] & 0xff);
						int storedFileType = buffer[7] & 0xff;
						if (storedFileId != fileId || storedChunkId != chunkId || storedFileType != fileType)
							return false;
						if (currentSectorId < 0 || (long) currentSectorId > dataFile.length() / DATA_SIZE)
							return false;
					}
				}
				if (currentSectorId == 0) {
					overwrite = false;
					currentSectorId = (int) ((dataFile.length() + 519L) / DATA_SIZE); // Is it 519 because length starts 1 instead of 0?
					if (currentSectorId == 0)
						currentSectorId++;
					if (currentSectorId == firstSectorId)
						currentSectorId++;
				}
				if (fileSize - j1 <= DATA_BLOCK_SIZE)
					currentSectorId = 0;
				buffer[0] = (byte) (fileId >> 8);
				buffer[1] = (byte) fileId;
				buffer[2] = (byte) (chunkId >> 8);
				buffer[3] = (byte) chunkId;
				buffer[4] = (byte) (currentSectorId >> 16);
				buffer[5] = (byte) (currentSectorId >> 8);
				buffer[6] = (byte) currentSectorId;
				buffer[7] = (byte) fileType;
				seekTo(dataFile, firstSectorId * DATA_SIZE);
				dataFile.write(buffer, 0, 8);
				int k2 = fileSize - j1;
				if (k2 > 512)
					k2 = 512;
				dataFile.write(data, j1, k2);
				j1 += k2;
				firstSectorId = currentSectorId;
			}

			return true;
		} catch (IOException _ex) {
			_ex.printStackTrace();
			return false;
		}
	}

	private synchronized void seekTo(RandomAccessFile randomaccessfile, int j) {
		try {
			randomaccessfile.seek(j);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}

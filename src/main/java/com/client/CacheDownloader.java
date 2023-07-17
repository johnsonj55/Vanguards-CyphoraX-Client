package com.client;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Enumeration;
import java.util.Objects;
import java.util.Scanner;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

import com.client.definitions.server.ItemDef;
import com.client.sign.Signlink;
import com.google.common.base.Preconditions;
import lombok.extern.java.Log;

public class CacheDownloader {

	private static final java.util.logging.Logger log = java.util.logging.Logger.getLogger(CacheDownloader.class.getName());

	public static int cacheVersionRemote;
	public static int cacheVersionLocal;

	private Client client;

	private static final int BUFFER = 1024;

	private Path fileLocation;

	public CacheDownloader(Client client) {
		Objects.requireNonNull(Signlink.getCacheDirectory());
		this.client = client;
		fileLocation = Paths.get(Signlink.getCacheDirectory(), getArchivedName());
	}

	private int getLocalVersion() {
		try(BufferedReader fr = new BufferedReader(new FileReader(Signlink.getCacheDirectory() + File.separator + "version.dat"))){
			return Integer.parseInt(fr.readLine());
		} catch (Exception e) {
			return -1;
		}
	}
	
//	private int getRemoteVersion() {
//		try {
//			URL versionUrl = new URL(Configuration.VERSION_URL);
//			try(Scanner scanner = new Scanner(versionUrl.openStream())) {
//				return scanner.nextInt();
//			}
//		} catch (Exception e) {
//			return 0;
//		}
//	}

	public void writeVersion(int version) {
		File versionFile = new File(Signlink.getCacheDirectory() + File.separator + "version.dat");
		if(versionFile.exists())
			versionFile.delete();
		try(BufferedWriter br = new BufferedWriter(new FileWriter(versionFile))) {
			br.write(version + "");
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}

	public void deleteZip() {
		try {
			Files.deleteIfExists(fileLocation);
		} catch (IOException ex) {
			log.severe("Cannot delete cache zip file.");
		}
	}

	public CacheDownloader downloadCache() {
		if (Signlink.usingDevCache()) {
			System.out.println("Using local_cache, skipping cache update.");
			return null;
		}

		try {
			File location = new File(Signlink.getCacheDirectory());
			File version = new File(Signlink.getCacheDirectory() + "/version.dat");
			cacheVersionRemote = Configuration.CACHE_VERSION;
			if (!location.exists() || !version.exists()) {
				log.info("Cache does not exist, downloading.");
				update();
			} else {
				cacheVersionLocal = getLocalVersion();
				log.info("Cache version local=" + cacheVersionLocal + ", remote=" + cacheVersionRemote);
				if (cacheVersionRemote != cacheVersionLocal) {
					update();
				} else {
					return null;
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			//ClientWindow.popupMessage("Could not download the cache file.",
					//"The website might be down or experiencing interruptions.",
					//Signlink.getCacheDirectory());
		} catch (Exception e) {
			e.printStackTrace();
			//ClientWindow.popupMessage("An error occurred while installing the cache.",
					//"You may experience crashes or gameplay interruptions.",
					//"Try deleting the cache and restarting the client.",
					//Signlink.getCacheDirectory());
		}
		return null;
	}

	private void update() throws IOException {
		downloadFile(Configuration.CACHE_LINK, getArchivedName());
		unZip();
		writeVersion(cacheVersionRemote);
		deleteZip();
	}

	private void downloadFile(String adress, String localFileName) throws IOException {
		OutputStream out = null;
		URLConnection conn;
		InputStream in = null;

		try {
			URL url = new URL(adress);
			out = new BufferedOutputStream(new FileOutputStream(Signlink.getCacheDirectory() + "/" + localFileName));

			conn = url.openConnection();
			in = conn.getInputStream();

			byte[] data = new byte[BUFFER];

			int numRead;
			long numWritten = 0;
			int fileSize = conn.getContentLength();
			long startTime = System.currentTimeMillis();
	
			while ((numRead = in.read(data)) != -1) {
				out.write(data, 0, numRead);
				numWritten += numRead;

				int percentage = (int) (((double) numWritten / (double) fileSize) * 100D);
				long elapsedTime = System.currentTimeMillis() - startTime;
				int downloadSpeed = (int) ((numWritten / 1024) / (1 + (elapsedTime / 1000)));
				
				float speedInBytes = 1000f * numWritten / elapsedTime;
				int timeRemaining =  (int) ((fileSize - numWritten) / speedInBytes);

				client.drawLoadingText(percentage, Configuration.CLIENT_TITLE + " - Downloading Cache " + percentage + "%");
			}
		} finally {
			try {
				if (in != null) {
					in.close();
				}
				if (out != null) {
					out.close();
				}
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}
	}

	private String getArchivedName() {
		int lastSlashIndex = Configuration.CACHE_LINK.lastIndexOf('/');
		if (lastSlashIndex >= 0 && lastSlashIndex < Configuration.CACHE_LINK.length() - 1) {
			String u = Configuration.CACHE_LINK.substring(lastSlashIndex + 1);
			return u.replace("?dl=1", "");
		} else {
			System.err.println("error retrieving archived name.");
		}
		return "";
	}

	private void unZip() throws IOException {
		InputStream in = new BufferedInputStream(new FileInputStream(fileLocation.toString()));
		ZipInputStream zin = new ZipInputStream(in);
		ZipEntry e;
		int files = countRegularFiles(new ZipFile(fileLocation.toString()));

		int numWritten = 0;
		while ((e = zin.getNextEntry()) != null) {
			String fileName = e.getName();
			File newFile = new File(Signlink.getCacheDirectory() + File.separator + fileName);
			if (e.isDirectory()) {
				(new File(Signlink.getCacheDirectory() + e.getName())).mkdir();
			} else {
				int percentage = (int) (((double) numWritten++ / (double) files) * 100D);
				client.drawLoadingText(percentage, Configuration.CLIENT_TITLE + " - Installing Cache " + percentage + "%");
				if (e.getName().equals(fileLocation.toString())) {
					unzip(zin, fileLocation.toString());
					break;
				}
				File file = new File(newFile.getParent());
				if (!file.exists()) {
					Preconditions.checkState(file.mkdirs(), "Cannot create file.");
				}
				unzip(zin, Signlink.getCacheDirectory() + e.getName());
			}
		}
		in.close();
		zin.close();
	}

	private static int countRegularFiles(final ZipFile zipFile) {
		final Enumeration<? extends ZipEntry> entries = zipFile.entries();
		int numRegularFiles = 0;
		while (entries.hasMoreElements()) {
			if (! entries.nextElement().isDirectory()) {
				++numRegularFiles;
			}
		}
		return numRegularFiles;
	}

	private void unzip(ZipInputStream zin, String s) throws IOException {
		try (FileOutputStream out = new FileOutputStream(s)) {
			byte[] b = new byte[BUFFER];
			int len = 0;
			while ((len = zin.read(b)) != -1)
				out.write(b, 0, len);
		}
	}
	
}
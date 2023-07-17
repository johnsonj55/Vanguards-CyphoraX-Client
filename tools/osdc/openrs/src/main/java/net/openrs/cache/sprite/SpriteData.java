package net.openrs.cache.sprite;

import java.awt.image.BufferedImage;

public class SpriteData {
	
	private int fileId, frameId;
	
	public BufferedImage img;

	public int getFileId() {
		return fileId;
	}

	public int getFrameId() {
		return frameId;
	}

	public BufferedImage getImg() {
		return img;
	}

	public SpriteData(int fileId, int frameId, BufferedImage img) {
		super();
		this.fileId = fileId;
		this.frameId = frameId;
		this.img = img;
	}
	
	

}

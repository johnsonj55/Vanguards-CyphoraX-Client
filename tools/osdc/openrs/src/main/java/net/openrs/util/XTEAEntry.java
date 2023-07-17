package net.openrs.util;

public class XTEAEntry {
	private final int region;
	private final int[] keys;

	public XTEAEntry(int region, int[] keys) {
		this.region = region;
		this.keys = keys;
	}

	public int getRegion() {
		return region;
	}

	public int[] getKeys() {
		return keys;
	}
}

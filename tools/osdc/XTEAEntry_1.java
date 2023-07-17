package net.openrs.util;

public class XTEAEntry {
	private final int mapsquare;
	private final int[] key;

	public XTEAEntry(int region, int[] keys) {
		this.mapsquare = region;
		this.key = keys;
	}

	public int getRegion() {
		return mapsquare;
	}

	public int[] getKeys() {
		return key;
	}
}

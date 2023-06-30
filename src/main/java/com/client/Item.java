package com.client;

import com.client.definitions.ItemDefinition;
import net.runelite.api.Tile;
import net.runelite.api.events.ItemQuantityChanged;
import net.runelite.rs.api.RSTileItem;
// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

final class Item extends Renderable implements RSTileItem {

	@Override
	public final Model getRotatedModel() {
		ItemDefinition itemDef = ItemDefinition.lookup(ID);
		return itemDef.getModel(itemCount);
	}

	public Item() {
	}

	public int ID;
	public int x;
	public int y;
	public int itemCount;

	@Override
	public int getSpawnTime() {
		return 0;
	}

	@Override
	public int getId() {
		return ID;
	}

	@Override
	public void setId(int id) {
		ID = id;
	}

	@Override
	public int getQuantity() {
		return itemCount;
	}

	@Override
	public void setQuantity(int quantity) {
		itemCount = quantity;
	}

	@Override
	public int getX() {
		return x;
	}

	@Override
	public void setX(int x) {
		this.x = x;
	}

	@Override
	public int getY() {
		return y;
	}

	@Override
	public void setY(int y) {
		this.y = y;
	}

	@Override
	public Tile getTile() {
		if (x == -1 || y == -1) {
			return null;
		}

		Tile[][][] tiles = Client.instance.getScene().getTiles();
		return tiles[Client.instance.getPlane()][x][y];
	}

	public void quantityChanged(int quantity) {
		Client.instance.getLogger().debug("Item quantity changed: {} ({} -> {})", getId(), getQuantity(), quantity);

		ItemQuantityChanged itemQuantityChanged = new ItemQuantityChanged(this, getTile(), getQuantity(), quantity);
		Client.instance.getCallbacks().post(itemQuantityChanged);

	}


}

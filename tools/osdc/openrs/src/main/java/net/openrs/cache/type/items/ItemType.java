/**
* Copyright (c) Kyle Fricilone
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package net.openrs.cache.type.items;

import java.io.DataOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

import net.openrs.cache.type.Type;
import net.openrs.cache.util.ArrayUtils;
import net.openrs.util.BitUtils;
import net.openrs.util.ByteBufferUtils;

/**
 * @author Kyle Friz
 *
 * @since May 27, 2015
 */
public class ItemType implements Type {

	private static final String[] DEFAULT_INVENTORY_ACTIONS = new String[]{null, null, null, null, "Drop"};
	private static final String[] DEFAULT_GROUND_ACTIONS = new String[]{null, null, "Take", null, null};

	private int ambient;
    private int contrast;
	private int unnotedId = -1;
	private int notedId = -1;
	private short[] colorToReplace;
	private short[] colorToReplaceWith;
	private int price = 1;
	private int[] countCo;
	private int[] countObj;
	private int femaleHeadModel = -1;
	private int femaleHeadModel2 = -1;
	private int femaleModel = -1;
	private int femaleModel1 = -1;
	private int femaleModel2 = -1;
	private int femaleOffset;
	private final int id;
	private String[] inventoryActions = new String[]{null, null, null, null, "Drop"};
	private int inventoryModel;
	private int maleHeadModel = -1;
	private int maleHeadModel2 = -1;
	private int maleModel = -1;
	private int maleModel1 = -1;
	private int maleModel2 = -1;
	private int maleOffset;
	private boolean isMembers = false;
	private String name = "null";
	private int note = -1;
	private int notedTemplate = -1;
	private String[] groundActions = new String[]{null, null, "Take", null, null};
	private int resizeX = 128;
	private int resizeY = 128;
	private int resizeZ = 128;
	private int isStackable = 0;
	private boolean searchable;
	private int team;
	private short[] textureToReplace;
	private short[] textureToReplaceWith;
	private int xan2d = 0;
	private int offsetX2d = 0;
	private int yan2d = 0;
	private int offsetY2d = 0;
	private int zan2d = 0;
	private int zoom2d = 2000;
	private int placeHolderId = -1;
	private int placeHolderTemplate = -1;
	private int shiftClickIndex = -2;
	private Map<Integer, Object> params = null;
	
	public ItemType(int id) {
		this.id = id;
	}

	@Override
	public void decode(ByteBuffer buffer) {
		while (true) {
			int opcode = buffer.get() & 0xFF;

			if (opcode == 0) {
				break;
			}
			if (opcode == 1) {
				this.inventoryModel = buffer.getShort() & 0xFFFF;
			} else if (opcode == 2) {
				this.name = ByteBufferUtils.getString(buffer);
			} else if (opcode == 4) {
				this.zoom2d = buffer.getShort() & 0xFFFF;
			} else if (opcode == 5) {
				this.xan2d = buffer.getShort() & 0xFFFF;
			} else if (opcode == 6) {
				this.yan2d = buffer.getShort() & 0xFFFF;
			} else if (opcode == 7) {
				this.offsetX2d = buffer.getShort() & 0xFFFF;
				if (this.offsetX2d > 32767) {
					this.offsetX2d -= 65536;
				}
			} else if (opcode == 8) {
				this.offsetY2d = buffer.getShort() & 0xFFFF;
				if (this.offsetY2d > 32767) {
					this.offsetY2d -= 65536;
				}
			} else if (opcode == 11) {
				this.isStackable = 1;
			} else if (opcode == 12) {
				this.price = buffer.getInt();
			} else if (opcode == 16) {
				this.isMembers = true;
			} else if (opcode == 23) {
				this.maleModel = buffer.getShort() & 0xFFFF;
				this.maleOffset = buffer.get() & 0xFF;
			} else if (opcode == 24) {
				this.maleModel1 = buffer.getShort() & 0xFFFF;
			} else if (opcode == 25) {
				this.femaleModel = buffer.getShort() & 0xFFFF;
				this.femaleOffset = buffer.get() & 0xFF;
			} else if (opcode == 26) {
				this.femaleModel1 = buffer.getShort() & 0xFFFF;
			} else if (opcode >= 30 && opcode < 35) {
				this.groundActions[opcode - 30] = ByteBufferUtils.getString(buffer);
				if (this.groundActions[opcode - 30].equalsIgnoreCase("Hidden")) {
					this.groundActions[opcode - 30] = null;
				}
			} else if (opcode >= 35 && opcode < 40) {
				this.inventoryActions[opcode - 35] = ByteBufferUtils.getString(buffer);
			} else {
				int var3;
				int var4;
				if (opcode == 40) {
					var3 = buffer.get() & 0xFF;
					this.colorToReplace = new short[var3];
					this.colorToReplaceWith = new short[var3];

					for (var4 = 0; var4 < var3; ++var4) {
						this.colorToReplace[var4] = (short) (buffer.getShort() & 0xFFFF);
						this.colorToReplaceWith[var4] = (short) (buffer.getShort() & 0xFFFF);
					}
				} else if (opcode == 41) {
					var3 = buffer.get() & 0xFF;
					this.textureToReplace = new short[var3];
					this.textureToReplaceWith = new short[var3];

					for (var4 = 0; var4 < var3; ++var4) {
						this.textureToReplace[var4] = (short) (buffer.getShort() & 0xFFFF);
						this.textureToReplaceWith[var4] = (short) (buffer.getShort() & 0xFFFF);
					}
				} else if (opcode == 42) {
					this.shiftClickIndex = buffer.get();
				} else if (opcode == 65) {
					this.searchable = true;
				} else if (opcode == 78) {
					this.maleModel2 = buffer.getShort() & 0xFFFF;
				} else if (opcode == 79) {
					this.femaleModel2 = buffer.getShort() & 0xFFFF;
				} else if (opcode == 90) {
					this.maleHeadModel = buffer.getShort() & 0xFFFF;
				} else if (opcode == 91) {
					this.femaleHeadModel = buffer.getShort() & 0xFFFF;
				} else if (opcode == 92) {
					this.maleHeadModel2 = buffer.getShort() & 0xFFFF;
				} else if (opcode == 93) {
					this.femaleHeadModel2 = buffer.getShort() & 0xFFFF;
				} else if (opcode == 95) {
					this.zan2d = buffer.getShort() & 0xFFFF;
				} else if (opcode == 97) {
					this.note = buffer.getShort() & 0xFFFF;
				} else if (opcode == 98) {
					this.notedTemplate = buffer.getShort() & 0xFFFF;
				} else if (opcode >= 100 && opcode < 110) {
					if (this.countObj == null) {
						this.countObj = new int[10];
						this.countCo = new int[10];
					}

					this.countObj[opcode - 100] = buffer.getShort() & 0xFFFF;
					this.countCo[opcode - 100] = buffer.getShort() & 0xFFFF;
				} else if (opcode == 110) {
					this.resizeX = buffer.getShort() & 0xFFFF;
				} else if (opcode == 111) {
					this.resizeY = buffer.getShort() & 0xFFFF;
				} else if (opcode == 112) {
					this.resizeZ = buffer.getShort() & 0xFFFF;
				} else if (opcode == 113) {
					this.ambient = buffer.get();
				} else if (opcode == 114) {
					this.contrast = buffer.get();
				} else if (opcode == 115) {
					this.team = buffer.get() & 0xFF;
				} else if (opcode == 139) {
					this.unnotedId = buffer.getShort() & 0xFFFF;
				} else if (opcode == 140) {
					this.notedId = buffer.getShort() & 0xFFFF;
				} else if (opcode == 148) {
					this.placeHolderId = buffer.getShort() & 0xFFFF;
				} else if (opcode == 149) {
					this.placeHolderTemplate = buffer.getShort() & 0xFFFF;
				} else if (opcode == 249) {
					int length = buffer.get() & 0xFF;

					params = new HashMap<>(BitUtils.nextPowerOfTwo(length));
					for (int i = 0; i < length; i++) {
						boolean isString = (buffer.get() & 0xFF) == 1;
						int key = ByteBufferUtils.get24Int(buffer);
						Object value;

						if (isString) {
							value = ByteBufferUtils.getString(buffer);
						} else {
							value = buffer.getInt();
						}

						params.put(key, value);
					}
				}
			}
		}
	}

	@Override
	public void encode(DataOutputStream dos) throws IOException {
		if (inventoryModel != 0) {
			dos.writeByte(1);
			dos.writeShort(inventoryModel);
		}

		if (!name.equalsIgnoreCase("null")) {
			dos.writeByte(2);
			dos.write(ArrayUtils.toByteArray(name));
			dos.writeByte(10);
		}

		if (zoom2d != 2000) {
			dos.writeByte(4);
			dos.writeShort(zoom2d);
		}

		if (xan2d != 0) {
			dos.writeByte(5);
			dos.writeShort(xan2d);
		}

		if (yan2d != 0) {
			dos.writeByte(6);
			dos.writeShort(yan2d);
		}

		if (offsetX2d != 0) {
			dos.writeByte(7);
			dos.writeShort(offsetX2d);
		}

		if (offsetY2d != 0) {
			dos.writeByte(8);
			dos.writeShort(offsetY2d);
		}

		if (isStackable == 1) {
			dos.writeByte(11);
		}

		if (price != 1) {
			dos.writeByte(12);
			dos.writeInt(price);
		}

		if (isMembers) {
			dos.writeByte(16);
		}

		if (maleModel != -1 || maleOffset != 0) {
			dos.writeByte(23);
			dos.writeShort(maleModel);
			dos.writeByte(maleOffset);
		}

		if (maleModel1 != -1) {
			dos.writeByte(24);
			dos.writeShort(maleModel1);
		}

		if (femaleModel != -1 || femaleOffset != -1) {
			dos.writeByte(25);
			dos.writeShort(femaleModel);
			dos.writeByte(femaleOffset);
		}

		if (femaleModel1 != -1) {
			dos.writeByte(26);
			dos.writeShort(femaleModel1);
		}

		if (!ArrayUtils.arraysMatch(groundActions, DEFAULT_GROUND_ACTIONS)) {
			for (int i = 0; i < groundActions.length; i++) {
				if (groundActions[i] == null) {
					continue;
				}
				dos.writeByte(i + 30);
				dos.write(ArrayUtils.toByteArray(groundActions[i]));
				dos.writeByte(10);
			}
		}

		if (!ArrayUtils.arraysMatch(inventoryActions, DEFAULT_INVENTORY_ACTIONS)) {
			for (int i = 0; i < inventoryActions.length; i++) {
				if (inventoryActions[i] == null) {
					continue;
				}
				dos.writeByte(i + 35);
				dos.write(ArrayUtils.toByteArray(inventoryActions[i]));
				dos.writeByte(10);
			}
		}

		if (colorToReplace != null && colorToReplaceWith != null) {
			dos.writeByte(40);

			int len = colorToReplace.length;
			dos.writeByte(len);

			for (int i = 0; i < len; i++) {
				dos.writeShort(colorToReplaceWith[i]);
				dos.writeShort(colorToReplace[i]);
			}
		}

		if (textureToReplace != null && textureToReplaceWith != null) {
			dos.writeByte(41);
			int len = textureToReplace.length;
			dos.writeByte(len);

			for (int i = 0; i < len; i++) {
				dos.writeShort(textureToReplace[i]);
				dos.writeShort(textureToReplaceWith[i]);
			}
		}

		if (shiftClickIndex != -2) {
			dos.writeByte(42);
			dos.writeByte(shiftClickIndex);
		}

		if (searchable) {
			dos.writeByte(65);
		}

		if (maleModel2 != -1) {
			dos.writeByte(78);
			dos.writeShort(maleModel2);
		}

		if (femaleModel2 != -1) {
		    dos.writeByte(79);
		    dos.writeShort(femaleModel2);
        }

        if (maleHeadModel != -1) {
		    dos.writeByte(90);
		    dos.writeShort(maleHeadModel);
        }

        if (femaleHeadModel!= -1) {
		    dos.writeByte(91);
		    dos.writeShort(femaleHeadModel);
        }

        if (maleHeadModel2 != -1) {
		    dos.writeByte(92);
		    dos.writeShort(maleHeadModel2);
        }

        if (femaleHeadModel2 != -1) {
		    dos.writeByte(93);
		    dos.writeShort(femaleHeadModel2);
        }

        if (zan2d != 0) {
		    dos.writeByte(95);
		    dos.writeShort(zan2d);
        }

        if (note != -1) {
		    dos.writeByte(97);
		    dos.writeShort(note);
        }

        if (notedTemplate != -1) {
		    dos.writeByte(98);
		    dos.writeShort(notedTemplate);
        }

        if (countObj != null && countCo != null) {
		    for (int i = 0; i < countObj.length; i++) {
		    	dos.writeByte(100 + i);
		        dos.writeShort(countObj[i]);
		        dos.writeShort(countCo[i]);
            }
        }

        if (resizeX != 128) {
		    dos.writeByte(110);
		    dos.writeShort(resizeX);
        }

        if (resizeY != 128) {
		    dos.writeByte(111);
		    dos.writeShort(resizeY);
        }

        if (resizeZ != 128) {
		    dos.writeByte(112);
		    dos.writeShort(resizeZ);
        }

        if (ambient != 0) {
		    dos.writeByte(113);
		    dos.writeByte(ambient);
        }

        if (contrast != 0) {
		    dos.writeByte(114);
		    dos.writeByte(contrast / 5);
        }

        if (team != 0) {
		    dos.writeByte(115);
		    dos.writeByte(team);
        }

        if (unnotedId != -1) {
		    dos.writeByte(139);
		    dos.writeShort(unnotedId);
        }

        if (notedId != -1) {
		    dos.writeByte(140);
		    dos.writeShort(notedId);
        }

        if (placeHolderId != -1) {
		    dos.writeByte(148);
		    dos.writeShort(placeHolderId);
        }

        if (placeHolderTemplate != -1) {
		    dos.writeByte(149);
		    dos.writeShort(placeHolderTemplate);
        }

	}

	@Override
	public int getID() {
		return id;
	}

	public int getAmbient() {
		return ambient;
	}

	public void setAmbient(int ambient) {
		this.ambient = ambient;
	}

	public int getUnnotedId() {
		return unnotedId;
	}

	public void setUnnotedId(int unnotedId) {
		this.unnotedId = unnotedId;
	}

	public int getNotedId() {
		return notedId;
	}

	public void setNotedId(int notedId) {
		this.notedId = notedId;
	}

	public short[] getColorToReplace() {
		return colorToReplace;
	}

	public void setColorToReplace(short[] colorToReplace) {
		this.colorToReplace = colorToReplace;
	}

	public short[] getColorToReplaceWith() {
		return colorToReplaceWith;
	}

	public void setColorToReplaceWith(short[] colorToReplaceWith) {
		this.colorToReplaceWith = colorToReplaceWith;
	}

	public int getContrast() {
		return contrast;
	}

	public void setContrast(int contrast) {
		this.contrast = contrast;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int[] getStackAmounts() {
		return countCo;
	}

	public void setStackAmounts(int[] stackAmounts) {
		this.countCo = stackAmounts;
	}

	public int[] getStackIds() {
		return countObj;
	}

	public void setStackIds(int[] stackIds) {
		this.countObj = stackIds;
	}

	public int getFemaleHeadModel() {
		return femaleHeadModel;
	}

	public void setFemaleHeadModel(int femaleHeadModel) {
		this.femaleHeadModel = femaleHeadModel;
	}

	public int getFemaleHeadModel2() {
		return femaleHeadModel2;
	}

	public void setFemaleHeadModel2(int femaleHeadModel2) {
		this.femaleHeadModel2 = femaleHeadModel2;
	}

	public int getFemaleModel() {
		return femaleModel;
	}

	public void setFemaleModel(int femaleModel) {
		this.femaleModel = femaleModel;
	}

	public int getFemaleModel1() {
		return femaleModel1;
	}

	public void setFemaleModel1(int femaleModel1) {
		this.femaleModel1 = femaleModel1;
	}

	public int getFemaleModel2() {
		return femaleModel2;
	}

	public void setFemaleModel2(int femaleModel2) {
		this.femaleModel2 = femaleModel2;
	}

	public int getFemaleOffset() {
		return femaleOffset;
	}

	public void setFemaleOffset(int femaleOffset) {
		this.femaleOffset = femaleOffset;
	}

	public int getId() {
		return id;
	}

	public String[] getInventoryActions() {
		return inventoryActions;
	}

	public void setInventoryActions(String[] inventoryActions) {
		this.inventoryActions = inventoryActions;
	}

	public int getInventoryModel() {
		return inventoryModel;
	}

	public void setInventoryModel(int inventoryModel) {
		this.inventoryModel = inventoryModel;
	}

	public int getMaleHeadModel() {
		return maleHeadModel;
	}

	public void setMaleHeadModel(int maleHeadModel) {
		this.maleHeadModel = maleHeadModel;
	}

	public int getMaleHeadModel2() {
		return maleHeadModel2;
	}

	public void setMaleHeadModel2(int maleHeadModel2) {
		this.maleHeadModel2 = maleHeadModel2;
	}

	public int getMaleModel() {
		return maleModel;
	}

	public void setMaleModel(int maleModel) {
		this.maleModel = maleModel;
	}

	public int getMaleModel1() {
		return maleModel1;
	}

	public void setMaleModel1(int maleModel1) {
		this.maleModel1 = maleModel1;
	}

	public int getMaleModel2() {
		return maleModel2;
	}

	public void setMaleModel2(int maleModel2) {
		this.maleModel2 = maleModel2;
	}

	public int getMaleOffset() {
		return maleOffset;
	}

	public void setMaleOffset(int maleOffset) {
		this.maleOffset = maleOffset;
	}

	public boolean isMembers() {
		return isMembers;
	}

	public void setMembers(boolean members) {
		this.isMembers = members;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNote() {
		return note;
	}

	public void setNote(int note) {
		this.note = note;
	}

	public int getNotedTemplate() {
		return notedTemplate;
	}

	public void setNotedTemplate(int notedTemplate) {
		this.notedTemplate = notedTemplate;
	}

	public String[] getGroundActions() {
		return groundActions;
	}

	public void setGroundActions(String[] groundActions) {
		this.groundActions = groundActions;
	}

	public int getResizeX() {
		return resizeX;
	}

	public void setResizeX(int resizeX) {
		this.resizeX = resizeX;
	}

	public int getResizeY() {
		return resizeY;
	}

	public void setResizeY(int resizeY) {
		this.resizeY = resizeY;
	}

	public int getResizeZ() {
		return resizeZ;
	}

	public void setResizeZ(int resizeZ) {
		this.resizeZ = resizeZ;
	}

	public int getStackable() {
		return isStackable;
	}

	public void setStackable(int stackable) {
		this.isStackable = stackable;
	}

	public boolean isUnnoted() {
		return searchable;
	}

	public void setUnnoted(boolean unnoted) {
		this.searchable = unnoted;
	}

	public int getTeamId() {
		return team;
	}

	public void setTeamId(int teamId) {
		this.team = teamId;
	}

	public short[] getTextureToReplace() {
		return textureToReplace;
	}

	public void setTextureToReplace(short[] textureToReplace) {
		this.textureToReplace = textureToReplace;
	}

	public short[] getTextureToReplaceWith() {
		return textureToReplaceWith;
	}

	public void setTextureToReplaceWith(short[] textureToReplaceWith) {
		this.textureToReplaceWith = textureToReplaceWith;
	}

	public int getModelPitch() {
		return xan2d;
	}

	public void setModelPitch(int modelPitch) {
		this.xan2d = modelPitch;
	}

	public int getOffsetX() {
		return offsetX2d;
	}

	public void setOffsetX(int offsetX) {
		this.offsetX2d = offsetX;
	}

	public int getModelRoll() {
		return yan2d;
	}

	public void setModelRoll(int modelRoll) {
		this.yan2d = modelRoll;
	}

	public int getOffsetY() {
		return offsetY2d;
	}

	public void setOffsetY(int offsetY) {
		this.offsetY2d = offsetY;
	}

	public int getModelYaw() {
		return zan2d;
	}

	public void setModelYaw(int modelYaw) {
		this.zan2d = modelYaw;
	}

	public int getZoom() {
		return zoom2d;
	}

	public void setZoom(int zoom) {
		this.zoom2d = zoom;
	}

	public int getPlaceHolderId() {
		return placeHolderId;
	}

	public void setPlaceHolderId(int placeHolderId) {
		this.placeHolderId = placeHolderId;
	}

	public int getPlaceHolderTemplate() {
		return placeHolderTemplate;
	}

	public void setPlaceHolderTemplate(int placeHolderTemplate) {
		this.placeHolderTemplate = placeHolderTemplate;
	}

	public int getShiftClickIndex() {
		return shiftClickIndex;
	}

	public void setShiftClickIndex(int shiftClickIndex) {
		this.shiftClickIndex = shiftClickIndex;
	}

	public Map<Integer, Object> getParams() {
		return params;
	}

	public void setParams(Map<Integer, Object> params) {
		this.params = params;
	}
}

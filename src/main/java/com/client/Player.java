package com.client;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import com.client.definitions.AnimationDefinition;
import com.client.definitions.ItemDefinition;
import com.client.definitions.NpcDefinition;
import com.client.definitions.GraphicsDefinition;
import net.runelite.api.*;
import net.runelite.api.Point;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldArea;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.kit.KitType;
import net.runelite.rs.api.*;
import org.jetbrains.annotations.Nullable;

public final class Player extends Entity implements RSPlayer {

	@Override
	public Model getRotatedModel() {
		if (!visible)
			return null;
		Model model = method452();
		if (model == null)
			return null;
		super.height = model.modelBaseY;
		model.singleTile = true;
		if (aBoolean1699)
			return model;
		if (super.anInt1520 != -1 && super.anInt1521 != -1) {
			GraphicsDefinition spotAnim = GraphicsDefinition.cache[super.anInt1520];
			Model model_2 = spotAnim.getModel();
			if (model_2 != null) {
				Model model_3 = new Model(true, Frame.noAnimationInProgress(super.anInt1521), false, model_2);
				model_3.offsetBy(0, -super.anInt1524, 0);
				model_3.generateBones();
				model_3.animate(spotAnim.animationSequence.primaryFrames[super.anInt1521]);
				model_3.faceGroups = null;
				model_3.vertexGroups = null;
				if (spotAnim.resizeXY != 128 || spotAnim.resizeZ != 128)
					model_3.scale(spotAnim.resizeXY, spotAnim.resizeXY,
							spotAnim.resizeZ);
				// model_3.method479(64 + spotAnim.anInt413, 850 +
				// spotAnim.anInt414, -30, -50, -30, true);
				model_3.light(64 + spotAnim.modelBrightness,
						850 + spotAnim.modelShadow, -30, -50, -30, true);
				Model aclass30_sub2_sub4_sub6_1s[] = { model, model_3 };
				model = new Model(aclass30_sub2_sub4_sub6_1s);
			}
		}
		if (aModel_1714 != null) {
			if (Client.loopCycle >= anInt1708)
				aModel_1714 = null;
			if (Client.loopCycle >= anInt1707 && Client.loopCycle < anInt1708) {
				Model model_1 = aModel_1714;
				model_1.offsetBy(anInt1711 - super.x, anInt1712 - anInt1709,
						anInt1713 - super.y);
				if (super.getTurnDirection() == 512) {
					model_1.rotate90Degrees();
					model_1.rotate90Degrees();
					model_1.rotate90Degrees();
				} else if (super.getTurnDirection() == 1024) {
					model_1.rotate90Degrees();
					model_1.rotate90Degrees();
				} else if (super.getTurnDirection() == 1536)
					model_1.rotate90Degrees();
				Model aclass30_sub2_sub4_sub6s[] = { model, model_1 };
				model = new Model(aclass30_sub2_sub4_sub6s);
				if (super.getTurnDirection() == 512)
					model_1.rotate90Degrees();
				else if (super.getTurnDirection() == 1024) {
					model_1.rotate90Degrees();
					model_1.rotate90Degrees();
				} else if (super.getTurnDirection() == 1536) {
					model_1.rotate90Degrees();
					model_1.rotate90Degrees();
					model_1.rotate90Degrees();
				}
				model_1.offsetBy(super.x - anInt1711, anInt1709 - anInt1712,
						super.y - anInt1713);
			}
		}
		model.singleTile = true;
		return model;
	}
	public int usedItemID;
	public String title;
	public String titleColor;

	public void updatePlayer(Buffer stream) {
		stream.currentPosition = 0;
		myGender = stream.readUnsignedByte();
		title = stream.readString();
		titleColor = stream.readString();
		healthState = stream.readUnsignedByte();
		headIcon = stream.readUnsignedByte();
		skullIcon = stream.readUnsignedByte();
		npcDefinition = null;
		team = 0;
		for (int j = 0; j < 12; j++) {
			int k = stream.readUnsignedByte();
			if (k == 0) {
				equipment[j] = 0;
				continue;
			}
			int i1 = stream.readUnsignedByte();
			equipment[j] = (k << 8) + i1;
			if (j == 0 && equipment[0] == 65535) {
				npcDefinition = NpcDefinition.lookup(stream.readUShort());
				break;
			}
			if (j == 8) {
				Client.myHeadAndJaw[0] = equipment[j] - 256;
			}
			if (j == 11) {
				Client.myHeadAndJaw[1] = equipment[j] - 256;
			}
			if (equipment[j] >= 512 && equipment[j] - 512 < ItemDefinition.totalItems) {
				int l1 = ItemDefinition.lookup(equipment[j] - 512).team;
				if (l1 != 0)
					team = l1;
			}
		}

		for (int l = 0; l < 5; l++) {
			int j1 = stream.readUnsignedByte();
			if (j1 < 0 || j1 >= Client.anIntArrayArray1003[l].length)
				j1 = 0;
			appearanceColors[l] = j1;
		}

		super.idleAnimation = stream.readUShort();
		if (super.idleAnimation == 65535)
			super.idleAnimation = -1;
		super.standTurnAnimIndex = stream.readUShort();
		if (super.standTurnAnimIndex == 65535)
			super.standTurnAnimIndex = -1;
		super.walkAnimIndex = stream.readUShort();
		if (super.walkAnimIndex == 65535)
			super.walkAnimIndex = -1;
		super.turn180AnimIndex = stream.readUShort();
		if (super.turn180AnimIndex == 65535)
			super.turn180AnimIndex = -1;
		super.turn90CWAnimIndex = stream.readUShort();
		if (super.turn90CWAnimIndex == 65535)
			super.turn90CWAnimIndex = -1;
		super.turn90CCWAnimIndex = stream.readUShort();
		if (super.turn90CCWAnimIndex == 65535)
			super.turn90CCWAnimIndex = -1;
		super.runAnimIndex = stream.readUShort();
		if (super.runAnimIndex == 65535)
			super.runAnimIndex = -1;
		displayName = stream.readString();
		visible = stream.readUnsignedByte() == 0;
		combatLevel = stream.readUnsignedByte();
		rights = PlayerRights.readRightsFromPacket(stream).getRight();
		displayedRights = PlayerRights.getDisplayedRights(rights);
		skill = stream.readUShort();
		aLong1718 = 0L;
		for (int k1 = 0; k1 < 12; k1++) {
			aLong1718 <<= 4;
			if (equipment[k1] >= 256)
				aLong1718 += equipment[k1] - 256;
		}

		if (equipment[0] >= 256)
			aLong1718 += equipment[0] - 256 >> 4;
		if (equipment[1] >= 256)
			aLong1718 += equipment[1] - 256 >> 8;
		for (int i2 = 0; i2 < 5; i2++) {
			aLong1718 <<= 3;
			aLong1718 += appearanceColors[i2];
		}

		aLong1718 <<= 1;
		aLong1718 += myGender;
	}

	public Model method452() {
		if (npcDefinition != null) {
			int j = -1;
			if (super.emoteAnimation >= 0 && super.animationDelay == 0)
				j = AnimationDefinition.anims[super.emoteAnimation].primaryFrames[super.animFrameIndex];
			else if (super.anInt1517 >= 0)
				j = AnimationDefinition.anims[super.anInt1517].primaryFrames[super.anInt1518];
			Model model = npcDefinition.method164(-1, j, null);
			return model;
		}
		long l = aLong1718;
		int k = -1;
		int i1 = -1;
		int j1 = -1;
		int k1 = -1;
		if (super.emoteAnimation >= 0 && super.animationDelay == 0) {
			AnimationDefinition animation = AnimationDefinition.anims[super.emoteAnimation];
			k = animation.primaryFrames[super.animFrameIndex];
			if (super.anInt1517 >= 0 && super.anInt1517 != super.idleAnimation)
				i1 = AnimationDefinition.anims[super.anInt1517].primaryFrames[super.anInt1518];
			if (animation.playerOffhand >= 0) {
				j1 = animation.playerOffhand;
				l += j1 - equipment[5] << 40;
			}
			if (animation.playerMainhand >= 0) {
				k1 = animation.playerMainhand;
				l += k1 - equipment[3] << 48;
			}
		} else if (super.anInt1517 >= 0)
			k = AnimationDefinition.anims[super.anInt1517].primaryFrames[super.anInt1518];
		Model model_1 = (Model) mruNodes.get(l);
		if (model_1 == null) {
			boolean flag = false;
			for (int i2 = 0; i2 < 12; i2++) {
				int k2 = equipment[i2];
				if (k1 >= 0 && i2 == 3)
					k2 = k1;
				if (j1 >= 0 && i2 == 5)
					k2 = j1;
				if (k2 >= 256 && k2 < 512 && !IDK.cache[k2 - 256].method537())
					flag = true;
				if (k2 >= 512 && !ItemDefinition.lookup(k2 - 512).isEquippedModelCached(myGender))
					flag = true;
			}

			if (flag) {
				if (aLong1697 != -1L)
					model_1 = (Model) mruNodes.get(aLong1697);
				if (model_1 == null)
					return null;
			}
		}
		if (model_1 == null) {
			Model aclass30_sub2_sub4_sub6s[] = new Model[12];
			int j2 = 0;
			for (int l2 = 0; l2 < 12; l2++) {
				int i3 = equipment[l2];
				if (k1 >= 0 && l2 == 3)
					i3 = k1;
				if (j1 >= 0 && l2 == 5)
					i3 = j1;
				if (i3 >= 256 && i3 < 512) {
					Model model_3 = IDK.cache[i3 - 256].method538();
					if (model_3 != null)
						aclass30_sub2_sub4_sub6s[j2++] = model_3;
				}
				if (i3 >= 512) {
					Model model_4 = ItemDefinition.lookup(i3 - 512)
							.getEquippedModel(myGender);
					if (model_4 != null)
						aclass30_sub2_sub4_sub6s[j2++] = model_4;
				}
			}

			model_1 = new Model(j2, aclass30_sub2_sub4_sub6s);
			for (int j3 = 0; j3 < 5; j3++)
				if (appearanceColors[j3] != 0) {
					model_1.recolor(Client.anIntArrayArray1003[j3][0],
							Client.anIntArrayArray1003[j3][appearanceColors[j3]]);
					if (j3 == 1)
						model_1.recolor(Client.PLAYER_BODY_RECOLOURS[0],
								Client.PLAYER_BODY_RECOLOURS[appearanceColors[j3]]);
				}

			model_1.generateBones();
			 model_1.light(64, 850, -30, -50, -30, true);
			//model_1.method479(84, 1000, -90, -580, -90, true);
			mruNodes.put(model_1, l);
			aLong1697 = l;
		}
		if (aBoolean1699)
			return model_1;
		Model model_2 = Model.emptyModel;
		model_2.replaceModel(model_1, Frame.noAnimationInProgress(k) & Frame.noAnimationInProgress(i1));
		if (k != -1 && i1 != -1)
			model_2.animate2(AnimationDefinition.anims[super.emoteAnimation].interleaveOrder, i1, k);
		else if (k != -1)
			model_2.animate(k);
		model_2.calculateBoundsCylinder();
		model_2.faceGroups = null;
		model_2.vertexGroups = null;
		return model_2;
	}

	@Override
	public boolean isVisible() {
		return visible;
	}

	public int privelage;

	public boolean isAdminRights() {
		return hasRights(PlayerRights.ADMINISTRATOR)
				|| hasRights(PlayerRights.OWNER)
				|| hasRights(PlayerRights.GAME_DEVELOPER);
	}

	public boolean hasRightsOtherThan(PlayerRights playerRight) {
		return PlayerRights.hasRightsOtherThan(rights, playerRight);
	}

	public boolean hasRights(PlayerRights playerRights) {
		return PlayerRights.hasRights(rights, playerRights);
	}

	public boolean hasRightsLevel(int rightsId) {
		return PlayerRights.hasRightsLevel(rights, rightsId);
	}

	public boolean hasRightsBetween(int low, int high) {
		return PlayerRights.hasRightsBetween(rights, low, high);
	}

	public Model method453() {
		if (!visible)
			return null;
		if (npcDefinition != null)
			return npcDefinition.method160();
		boolean flag = false;
		for (int i = 0; i < 12; i++) {
			int j = equipment[i];
			if (j >= 256 && j < 512 && !IDK.cache[j - 256].headLoaded())
				flag = true;
			if (j >= 512 && !ItemDefinition.lookup(j - 512).isDialogueModelCached(myGender))
				flag = true;
		}

		if (flag)
			return null;
		Model aclass30_sub2_sub4_sub6s[] = new Model[12];
		int k = 0;
		for (int l = 0; l < 12; l++) {
			int i1 = equipment[l];
			if (i1 >= 256 && i1 < 512) {
				Model model_1 = IDK.cache[i1 - 256].headModel();
				if (model_1 != null)
					aclass30_sub2_sub4_sub6s[k++] = model_1;
			}
			if (i1 >= 512) {
				Model model_2 = ItemDefinition.lookup(i1 - 512).getChatEquipModel(myGender);
				if (model_2 != null)
					aclass30_sub2_sub4_sub6s[k++] = model_2;
			}
		}

		Model model = new Model(k, aclass30_sub2_sub4_sub6s);
		for (int j1 = 0; j1 < 5; j1++)
			if (appearanceColors[j1] != 0) {
				model.recolor(Client.anIntArrayArray1003[j1][0],
						Client.anIntArrayArray1003[j1][appearanceColors[j1]]);
				if (j1 == 1)
					model.recolor(Client.PLAYER_BODY_RECOLOURS[0],
							Client.PLAYER_BODY_RECOLOURS[appearanceColors[j1]]);
			}

		return model;
	}

	public Player() {
		aLong1697 = -1L;
		aBoolean1699 = false;
		appearanceColors = new int[5];
		visible = false;
		equipment = new int[12];
	}

	public boolean inFlowerPokerArea() {
		int x = getAbsoluteX();
		int y = getAbsoluteY();
		return x >= 3109 && y >= 3504 && x <= 3121 && y <= 3515;
	}

	public boolean inFlowerPokerChatProximity() {
		int x = getAbsoluteX();
		int y = getAbsoluteY();
		return x >= 3106 && y >= 3502 && x <= 3123 && y <= 3517;
	}
	
	public PlayerRights[] getRights() {
		return rights;
	}

	public List<PlayerRights> getDisplayedRights() {
		return displayedRights;
	}
	
	public int getHealthState() {
		return healthState;
	}

	public PlayerRights[] rights = new PlayerRights[] {PlayerRights.PLAYER};
	private List<PlayerRights> displayedRights = new ArrayList<>();
	private long aLong1697;
	public NpcDefinition npcDefinition;
	boolean aBoolean1699;
	public int[] appearanceColors;
	public int team;
	public int myGender;
	public String displayName;
	static ReferenceCache mruNodes = new ReferenceCache(260);
	public int combatLevel;
	public int headIcon;
	public int skullIcon;
	public int hintIcon;
	public int anInt1707;
	int anInt1708;
	int anInt1709;
	boolean visible;
	int anInt1711;
	int anInt1712;
	int anInt1713;
	Model aModel_1714;
	public int[] equipment;
	private long aLong1718;
	int anInt1719;
	int anInt1720;
	int anInt1721;
	int anInt1722;
	int skill;
	private int healthState;

	@Override
	public int getRSInteracting() {
		return 0;
	}

	@Override
	public String getOverheadText() {
		return "";
	}

	@Override
	public void setOverheadText(String overheadText) {

	}

	@Override
	public int getX() {
		return x;
	}

	@Override
	public int getY() {
		return y;
	}

	@Override
	public int[] getPathX() {
		return pathX;
	}

	@Override
	public int[] getPathY() {
		return pathY;
	}

	@Override
	public int getAnimation() {
		return emoteAnimation;
	}

	@Override
	public void setAnimation(int animation) {
		emoteAnimation = animation;
	}

	@Override
	public int getAnimationFrame() {
		return 0;
	}

	@Override
	public int getActionFrame() {
		return 0;
	}

	@Override
	public void setAnimationFrame(int frame) {
	}

	@Override
	public void setActionFrame(int frame) {
	}

	@Override
	public int getActionFrameCycle() {
		return 0;
	}

	@Override
	public int getGraphic() {
		return 0;
	}

	@Override
	public void setGraphic(int id) {

	}

	@Override
	public int getGraphicHeight()
	{
		return 0;
	}

	@Override
	public void setGraphicHeight(int height)
	{

	}


	@Override
	public int getSpotAnimFrame() {
		return 0;
	}

	@Override
	public void setSpotAnimFrame(int id) {
	}

	@Override
	public int getSpotAnimationFrameCycle() {
		return 0;
	}

	@Override
	public int getIdlePoseAnimation() {
		return 0;
	}

	@Override
	public void setIdlePoseAnimation(int animation) {
	}

	@Override
	public int getPoseAnimation() {
		return 0;
	}

	@Override
	public void setPoseAnimation(int animation) {

	}

	@Override
	public int getPoseFrame() {
		return 0;
	}

	@Override
	public void setPoseFrame(int frame) {
	}

	@Override
	public int getPoseFrameCycle() {
		return 0;
	}

	@Override
	public int getLogicalHeight() {
		return height;
	}

	@Override
	public int getOrientation() {
		return orientation;
	}

	@Override
	public int getCurrentOrientation() {
		return orientation;
	}

	@Override
	public RSIterableNodeDeque getHealthBars() {
		return null;
	}

	@Override
	public int[] getHitsplatValues() {
		return null;
	}

	@Override
	public int[] getHitsplatTypes() {
		return hitMarkTypes;
	}

	@Override
	public int[] getHitsplatCycles() {
		return hitsLoopCycle;
	}

	@Override
	public int getIdleRotateLeft() {
		return 0;
	}

	@Override
	public int getIdleRotateRight() {
		return 0;
	}

	@Override
	public int getWalkAnimation() {
		return 0;
	}

	@Override
	public int getWalkRotate180() {
		return 0;
	}

	@Override
	public int getWalkRotateLeft() {
		return 0;
	}

	@Override
	public int getWalkRotateRight() {
		return 0;
	}

	@Override
	public int getRunAnimation() {
		return 0;
	}

	@Override
	public void setDead(boolean dead) {
	}

	@Override
	public int getPathLength() {
		return 0;
	}

	@Override
	public int getOverheadCycle() {
		return 0;
	}

	@Override
	public void setOverheadCycle(int cycle) {
	}

	@Override
	public RSModel getModel() {
		return getRotatedModel();
	}

	@Override
	public RSNode getNext() {
		return null;
	}

	@Override
	public RSNode getPrevious() {
		return null;
	}

	@Override
	public void onUnlink() {
	}

	@Override
	public String getName() {
		return displayName;
	}

	@Override
	public Actor getInteracting() {
		int index = interactingEntity;
		if (index == -1 || index == 65535)
		{
			return null;
		}
		Client client = Client.instance;

		if (index < 32768)
		{
			NPC[] npcs = client.getCachedNPCs();
			return npcs[index];
		}

		index -= 32768;
		Player[] players = client.players;
		return players[index];
	}

	@Override
	public int getHealthRatio() {
		return Math.round(this.currentHealth / this.maxHealth);
	}

	@Override
	public int getHealthScale() {
		return currentHealth;
	}

	@Override
	public WorldPoint getWorldLocation() {
		return WorldPoint.fromLocal(Client.instance,
				this.getPathX()[0] * Perspective.LOCAL_TILE_SIZE + Perspective.LOCAL_TILE_SIZE / 2,
				this.getPathY()[0] * Perspective.LOCAL_TILE_SIZE + Perspective.LOCAL_TILE_SIZE / 2,
				Client.instance.getPlane());
	}

	@Override
	public LocalPoint getLocalLocation() {
		return new LocalPoint(this.x, this.y);
	}

	@Override
	public void setIdleRotateLeft(int animationID) {
	}

	@Override
	public void setIdleRotateRight(int animationID) {
	}

	@Override
	public void setWalkAnimation(int animationID) {
	}

	@Override
	public void setWalkRotateLeft(int animationID) {
	}

	@Override
	public void setWalkRotateRight(int animationID) {
	}

	@Override
	public void setWalkRotate180(int animationID) {
	}

	@Override
	public void setRunAnimation(int animationID) {
	}

	@Override
	public Polygon getCanvasTilePoly() {
		return Perspective.getCanvasTilePoly(Client.instance, this.getLocalLocation());
	}

	@Nullable
	@Override
	public Point getCanvasTextLocation(Graphics2D graphics, String text, int zOffset) {
		return Perspective.getCanvasTextLocation(Client.instance, (Graphics2D) Client.instance.getGameComponent().getGraphics(), getLocalLocation(), text, zOffset);
	}


	@Override
	public Point getCanvasImageLocation(BufferedImage image, int zOffset) {
		return Perspective.getCanvasImageLocation(Client.instance, getLocalLocation(), image, zOffset);
	}

	@Override
	public Point getCanvasSpriteLocation(SpritePixels sprite, int zOffset) {
		return null;
	}

	@Override
	public Point getMinimapLocation() {
		return Perspective.localToMinimap(Client.instance, getLocalLocation());
	}

	@Override
	public Shape getConvexHull() {
		RSModel model = getModel();
		if (model == null)
		{
			return null;
		}

		int tileHeight = Perspective.getTileHeight(Client.instance, new LocalPoint(getX(), getY()), Client.instance.getPlane());

		return model.getConvexHull(getX(), getY(), getOrientation(), tileHeight);
	}

	@Override
	public WorldArea getWorldArea() {
		return new WorldArea(getWorldLocation(), 1, 1);
	}

	@Override
	public boolean isDead() {
		return currentHealth <= 0;
	}

	@Override
	public boolean isMoving() {
		return false;
	}

	@Override
	public int getActionOpcode(int action)
	{
		return 0;
	}

	@Override
	public String[] getRawActions()
	{
		return new String[0];
	}

	@Override
	public void interact(int action)
	{

	}

	@Override
	public void interact(String action)
	{

	}

	@Override
	public void interact(int index, int opcode)
	{

	}

	@Override
	public void interact(int identifier, int opcode, int param0, int param1)
	{

	}

	@Override
	public long getTag()
	{
		return 0;
	}

	@Override
	public int getCombatLevelOverride()
	{
		return 0;
	}

	@Override
	public boolean instantTurn()
	{
		return false;
	}

	@Override
	public int getFacedDirection()
	{
		return 0;
	}

	@Override
	public int getAnimationDelay()
	{
		return 0;
	}

	@Override
	public int getAnimationFrameIndex()
	{
		return 0;
	}

	@Override
	public int exactMoveDeltaX1()
	{
		return 0;
	}

	@Override
	public int exactMoveDeltaX2()
	{
		return 0;
	}

	@Override
	public int exactMoveDeltaY1()
	{
		return 0;
	}

	@Override
	public int exactMoveDeltaY2()
	{
		return 0;
	}

	@Override
	public int exactMoveArrive1Cycle()
	{
		return 0;
	}

	@Override
	public int exactMoveArrive2Cycle()
	{
		return 0;
	}

	@Override
	public int exactMoveDirection()
	{
		return 0;
	}

	@Override
	public int recolourStartCycle()
	{
		return 0;
	}

	@Override
	public int recolourEndCycle()
	{
		return 0;
	}

	@Override
	public byte recolourHue()
	{
		return 0;
	}

	@Override
	public byte recolourSaturation()
	{
		return 0;
	}

	@Override
	public byte recolourLuminance()
	{
		return 0;
	}

	@Override
	public byte recolourAmount()
	{
		return 0;
	}

	@Override
	public int getGraphicStartCycle()
	{
		return 0;
	}

	@Override
	public boolean showPublicPlayerChat()
	{
		return false;
	}

	@Override
	public Polygon[] getPolygons()
	{
		RSModel model = getModel();

		if (model == null)
		{
			return null;
		}

		int[] x2d = new int[model.getVerticesCount()];
		int[] y2d = new int[model.getVerticesCount()];

		int localX = getX();
		int localY = getY();

		final int tileHeight = Perspective.getTileHeight(Client.instance, new LocalPoint(localX, localY), Client.instance.getPlane());

		Perspective.modelToCanvas(Client.instance, model.getVerticesCount(), localX, localY, tileHeight, getOrientation(), model.getVerticesX(), model.getVerticesZ(), model.getVerticesY(), x2d, y2d);
		ArrayList polys = new ArrayList(model.getFaceCount());

		int[] trianglesX = model.getFaceIndices1();
		int[] trianglesY = model.getFaceIndices2();
		int[] trianglesZ = model.getFaceIndices3();

		for (int triangle = 0; triangle < model.getFaceCount(); ++triangle)
		{
			int[] xx =
					{
							x2d[trianglesX[triangle]], x2d[trianglesY[triangle]], x2d[trianglesZ[triangle]]
					};

			int[] yy =
					{
							y2d[trianglesX[triangle]], y2d[trianglesY[triangle]], y2d[trianglesZ[triangle]]
					};

			polys.add(new Polygon(xx, yy, 3));
		}

		return (Polygon[]) polys.toArray(new Polygon[0]);
	}


	@Override
	public HeadIcon getOverheadIcon() {
		return null;
	}

	@Override
	public SkullIcon getSkullIcon() {
		return null;
	}

	@Override
	public RSUsername getRsName() {
		return null;
	}

	@Override
	public int getPlayerId() {
		return 0;
	}

	@Override
	public RSPlayerComposition getPlayerComposition() {
		return new RSPlayerComposition() {
			@Override
			public boolean isFemale() {
				return myGender == 1;
			}

			@Override
			public int[] getColors() {
				return appearanceColors;
			}

			@Override
			public int[] getEquipmentIds() {
				return equipment;
			}

			@Override
			public int getEquipmentId(KitType type) {
				return 0;
			}

			@Override
			public void setTransformedNpcId(int id) {

			}

			@Override
			public int getKitId(KitType type) {
				return equipment[type.getIndex()];
			}

			@Override
			public long getHash() {
				return 0;
			}

			@Override
			public void setHash() {
			}
		};
	}

	@Override
	public int getCombatLevel() {
		return combatLevel;
	}

	@Override
	public int getTotalLevel() {
		return 0;
	}

	@Override
	public int getTeam() {
		return team;
	}

	@Override
	public boolean isFriendsChatMember() {
		return false;
	}

	@Override
	public boolean isClanMember() {
		return false;
	}

	@Override
	public boolean isFriend() {
		return Client.instance.isFriended(displayName, true);
	}

	@Override
	public boolean isFriended() {
		return false;
	}

	@Override
	public int getRsOverheadIcon() {
		return headIcon;
	}

	@Override
	public int getRsSkullIcon() {
		return skullIcon;
	}

	@Override
	public int getRSSkillLevel() {
		return 0;
	}

	@Override
	public String[] getActions() {
		return null;
	}

	@Override
	public int getPoseAnimationFrame() {
		return 0;
	}

	@Override
	public void setPoseAnimationFrame(int frame) {

	}
}

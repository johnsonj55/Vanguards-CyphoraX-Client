package com.client;

import com.client.definitions.AnimationDefinition;
import com.client.definitions.NpcDefinition;
// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
import com.client.definitions.GraphicsDefinition;
import com.client.features.settings.Preferences;
import net.runelite.api.Actor;
import net.runelite.api.NPCComposition;
import net.runelite.api.Point;
import net.runelite.api.SpritePixels;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldArea;
import net.runelite.api.coords.WorldPoint;
import net.runelite.rs.api.*;
import org.jetbrains.annotations.Nullable;

import java.awt.*;
import java.awt.image.BufferedImage;

public final class Npc extends Entity implements RSNPC {

	private Model method450() {
		if (super.emoteAnimation >= 0 && super.animationDelay == 0) {
			int k = AnimationDefinition.anims[super.emoteAnimation].primaryFrames[super.animFrameIndex];
			int i1 = -1;
			if (super.anInt1517 >= 0 && super.anInt1517 != super.idleAnimation)
				i1 = AnimationDefinition.anims[super.anInt1517].primaryFrames[super.anInt1518];
			return desc.method164(i1, k,
					AnimationDefinition.anims[super.emoteAnimation].interleaveOrder);
		}
		int l = -1;
		if (super.anInt1517 >= 0)
			l = AnimationDefinition.anims[super.anInt1517].primaryFrames[super.anInt1518];
		return desc.method164(-1, l, null);
	}

	@Override
	public Model getRotatedModel() {
		if (desc == null)
			return null;
		Model model = method450();
		if (model == null)
			return null;
		super.height = model.modelBaseY;
		if (super.anInt1520 != -1 && super.anInt1521 != -1) {
			GraphicsDefinition spotAnim = GraphicsDefinition.cache[super.anInt1520];
			Model model_1 = spotAnim.getModel();
			if (model_1 != null) {
				int j = spotAnim.animationSequence.primaryFrames[super.anInt1521];
				Model model_2 = new Model(true, Frame.noAnimationInProgress(j), false, model_1);
				model_2.offsetBy(0, -super.anInt1524, 0);
				model_2.generateBones();
				model_2.animate(j);
				model_2.faceGroups = null;
				model_2.vertexGroups = null;
				if (spotAnim.resizeXY != 128 || spotAnim.resizeZ != 128)
					model_2.scale(spotAnim.resizeXY, spotAnim.resizeXY,
							spotAnim.resizeZ);
				model_2.light(64 + spotAnim.modelBrightness,
						850 + spotAnim.modelShadow, -30, -50, -30, true);
				Model aModel[] = { model, model_2 };
				model = new Model(aModel);
			}
		}
		if (desc.size == 1)
			model.singleTile = true;
		return model;
	}

	@Override
	public boolean isVisible() {
		return desc != null;
	}

	Npc() {
	}

	public boolean isShowMenuOnHover() {
		return npcPetType == 0 || npcPetType == 2 && !Preferences.getPreferences().hidePetOptions;
	}

	public int npcPetType;
	public NpcDefinition desc;

	@Override
	public int getCombatLevel() {
		return 0;
	}

	@Nullable
	@Override
	public NPCComposition getTransformedComposition() {
		return null;
	}


	@Override
	public int getId() {
		return 0;
	}

	@Nullable
	@Override
	public String getName() {
		return null;
	}

	@Override
	public Actor getInteracting() {
		return null;
	}

	@Override
	public int getHealthRatio() {
		return 0;
	}

	@Override
	public int getHealthScale() {
		return 0;
	}

	@Override
	public WorldPoint getWorldLocation() {
		return null;
	}

	@Override
	public LocalPoint getLocalLocation() {
		return null;
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
		return null;
	}

	@Nullable
	@Override
	public Point getCanvasTextLocation(Graphics2D graphics, String text, int zOffset) {
		return null;
	}

	@Override
	public Point getCanvasImageLocation(BufferedImage image, int zOffset) {
		return null;
	}

	@Override
	public Point getCanvasSpriteLocation(SpritePixels sprite, int zOffset) {
		return null;
	}

	@Override
	public Point getMinimapLocation() {
		return null;
	}

	@Override
	public Shape getConvexHull() {
		return null;
	}

	@Override
	public WorldArea getWorldArea() {
		return null;
	}

	@Override
	public boolean isDead() {
		return false;
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
	public boolean isHidden() {
		return false;
	}

	@Override
	public int getRSInteracting() {
		return 0;
	}

	@Override
	public String getOverheadText() {
		return null;
	}

	@Override
	public void setOverheadText(String overheadText) {

	}

	@Override
	public int getX() {
		return 0;
	}

	@Override
	public int getY() {
		return 0;
	}

	@Override
	public int[] getPathX() {
		return new int[0];
	}

	@Override
	public int[] getPathY() {
		return new int[0];
	}

	@Override
	public int getAnimation() {
		return 0;
	}

	@Override
	public void setAnimation(int animation) {

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
		return 0;
	}

	@Override
	public int getOrientation() {
		return 0;
	}

	@Override
	public int getCurrentOrientation() {
		return 0;
	}

	@Override
	public RSIterableNodeDeque getHealthBars() {
		return null;
	}

	@Override
	public int[] getHitsplatValues() {
		return new int[0];
	}

	@Override
	public int[] getHitsplatTypes() {
		return new int[0];
	}

	@Override
	public int[] getHitsplatCycles() {
		return new int[0];
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
	public int getPoseAnimationFrame() {
		return 0;
	}

	@Override
	public void setPoseAnimationFrame(int frame) {

	}

	@Override
	public RSNPCComposition getComposition() {
		return null;
	}

	@Override
	public int getIndex() {
		return 0;
	}

	@Override
	public void setIndex(int id) {

	}

	@Override
	public RSNode getNext() {
		return null;
	}

	@Override
	public long getHash() {
		return 0;
	}

	@Override
	public RSNode getPrevious() {
		return null;
	}

	@Override
	public void onUnlink() {

	}

	@Override
	public int getModelHeight() {
		return 0;
	}

	@Override
	public void setModelHeight(int modelHeight) {

	}

	@Override
	public RSModel getModel() {
		return null;
	}

	@Override
	public void draw(int orientation, int pitchSin, int pitchCos, int yawSin, int yawCos, int x, int y, int z, long hash) {

	}
}

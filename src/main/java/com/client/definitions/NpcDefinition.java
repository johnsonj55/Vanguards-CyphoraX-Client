package com.client.definitions;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.stream.IntStream;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.util.Arrays;
//
//import org.apache.commons.io.FileUtils;

import com.client.*;
import com.client.model.Npcs;
import com.client.utilities.FieldGenerator;
import com.client.utilities.TempWriter;
import net.runelite.api.HeadIcon;
import net.runelite.api.IterableHashTable;
import net.runelite.rs.api.RSIterableNodeHashTable;
import net.runelite.rs.api.RSNPCComposition;


public final class NpcDefinition implements RSNPCComposition {

    public static NpcDefinition lookup(int i) {
        for (int j = 0; j < 20; j++)
            if (cache[j].npcId == i)
                return cache[j];

        anInt56 = (anInt56 + 1) % 20;
        NpcDefinition entityDef = cache[anInt56] = new NpcDefinition();
        stream.currentPosition = streamIndices[i];
        entityDef.npcId = i;
        entityDef.readValues(stream);
		if (i == Npcs.BOB_BARTER_HERBS) {
			entityDef.actions = new String[] { "Talk-to", "Prices", "Decant", "Clean", null };
		}
		if (i == Npcs.ZAHUR)
			entityDef.actions[0] = "Trade";
		if (i == Npcs.JOSSIK) {
			entityDef.actions = new String[5];
			entityDef.actions[0] = "Talk-to";
			entityDef.actions[2] = "Trade";
		}
		if (i == 9460 || i == 1150 || i == 2912 || i == 2911 || i == 2910 || i == 6481
			|| i == 3500 || i == 9459 || i == 9457 || i == 9458) {
			// Setting combat to zero to npcs that can't be attacked
			entityDef.combatLevel = 0;
		}
		if (i == Npcs.PERDU) {
			entityDef.actions = new String[] { "Talk-to", null, "Reclaim-lost", null, null};
		}

		if (i == 1830) {//pet Shark
			entityDef.name = "Pet shark";
			entityDef.combatLevel = 0;
			entityDef.onMinimap = false;
			entityDef.actions = new String[5];
			entityDef.actions[0] = "Pick-up";
		}

		if (i == 4420) {//Tournament
			entityDef.actions = new String[5];
			entityDef.actions[0] = "Enter-tournament";
		}

		if (i == 1017) {//Lottery
			entityDef.name = "@yel@[Lottery]";
			entityDef.actions = new String[5];
			entityDef.actions[0] = "Talk-to";
			entityDef.actions[2] = "Enter-lottery";
			entityDef.actions[3] = "Check-pot";
			entityDef.actions[4] = "View-hiscores";
		}

		if (i == 3362) {//Daily tasks
			entityDef.name = "Daily task manager";
			entityDef.actions = new String[5];
			entityDef.actions[0] = "Talk-to";
			entityDef.actions[2] = "View rewards";
		}
		if (i == 3169) {//Daily tasks
			entityDef.name = "Aviansie";
			entityDef.actions = new String[5];
			entityDef.standingAnimation = 6952;
			entityDef.actions[0] = "Attack";
		}
		if (i == 5567) {//Death

			entityDef.actions = new String[5];
			entityDef.actions[0] = "Talk-to";
			entityDef.actions[2] = null;
		}

		if (i == 1101) {//Giant sea snake
			entityDef.name = "Powerful sea snake";
			entityDef.combatLevel = 650;
			entityDef.rotationSpeed = 64;
			entityDef.npcHeight = 250;
			entityDef.npcWidth = 250;
			//	entityDef.combatLevel = 0;
			entityDef.size = 6;
		}



		if (i == 3406) {//Mini solak
			entityDef.name = "Mini Solak";
			entityDef.combatLevel = 0;
			entityDef.models = new int[] { 50204 };
			entityDef.standingAnimation = 5893;
			entityDef.walkingAnimation = 5892;
			entityDef.onMinimap = false;
			entityDef.actions = new String[5];
			entityDef.actions[0] = "Pick-up";
			entityDef.rotationSpeed = 64;
			entityDef.npcWidth = 60;
			entityDef.npcHeight = 60;

		}

		if (i == 5000) {//revenant maledictus
			NpcDefinition k = lookup(11246);
			entityDef.name = "Mini Maledictus";
			entityDef.actions = new String[5];
			entityDef.actions[0] = "Pick-up";
			entityDef.models = new int[1];
			entityDef.models = k.models;
			entityDef.standingAnimation = k.standingAnimation;
			entityDef.walkingAnimation = k.walkingAnimation;
			entityDef.rotationSpeed = 64;
			entityDef.npcHeight = 40;
			entityDef.npcWidth = 40;
			entityDef.combatLevel = 0;
			entityDef.size = 1;
		}


		if (i == 11246) {//Enranged maledictus
			entityDef.name = "Enranged Revenant Maledictus";

		}

		if (i == 5001) {//revenant maledictus
			NpcDefinition k = lookup(11246);
			entityDef.name = "Revenant Maledictus";
			entityDef.actions = new String[5];
			entityDef.actions = new String[] { null, "Attack", null, null, null };
			entityDef.models = new int[1];
			entityDef.models = k.models;
			entityDef.standingAnimation = k.standingAnimation;
			entityDef.walkingAnimation = k.walkingAnimation;
			entityDef.rotationSpeed = 64;
			entityDef.npcHeight = 112;
			entityDef.npcWidth = 112;
			entityDef.combatLevel = 0;
			entityDef.size = 5;
		}


		if (i == 6005) {//normal minikratos
			NpcDefinition k = lookup(7668);
			entityDef.name = "Mini Kratos";
			entityDef.actions = new String[5];
			entityDef.actions = new String[] { null, "Attack", null, null, null };
			entityDef.models = new int[1];
			entityDef.models = k.models;
			entityDef.standingAnimation = k.standingAnimation;
			entityDef.walkingAnimation = k.walkingAnimation;
			entityDef.rotationSpeed = 64;
			entityDef.npcHeight = 90;
			entityDef.npcWidth = 90;
			entityDef.combatLevel = 0;
		}

		if (i == 6006) {
			entityDef.name = "Engraged mini kratos";
			entityDef.models = new int[] { 45500, 45501, 45502 };
			entityDef.actions = new String[5];
			entityDef.actions = new String[] { null, "Attack", null, null, null };
			entityDef.originalColors = null;
			entityDef.newColors = null;
			entityDef.standingAnimation = 7017;
			entityDef.walkingAnimation = 7016;
			entityDef.rotationSpeed = 64;
			entityDef.npcWidth = 90; //WIDTH
			entityDef.npcHeight = 90; // HEIGH
			entityDef.combatLevel = 0;
		}


		if (i == 6008) {
			entityDef.name = "Enranged kratos";
			entityDef.models = new int[] { 45500, 45501, 45502 };
			entityDef.actions = new String[5];
			entityDef.actions = new String[] { null, "Attack", null, null, null };
			entityDef.originalColors = null;
			entityDef.newColors = null;
			entityDef.standingAnimation = 7017;
			entityDef.walkingAnimation = 7016;
			entityDef.rotationSpeed = 64;
			entityDef.npcWidth = 320; //WIDTH
			entityDef.npcHeight = 320; // HEIGH
			entityDef.combatLevel = 785;
		}


		if (i == 6009) {//normal kratos
			NpcDefinition k = lookup(7668);
			entityDef.name = "Kratos";
			entityDef.actions = new String[5];
			entityDef.actions = new String[] { null, "Attack", null, null, null };
			entityDef.models = new int[1];
			entityDef.models = k.models;
			entityDef.standingAnimation = k.standingAnimation;
			entityDef.walkingAnimation = k.walkingAnimation;
			entityDef.rotationSpeed = 64;
			entityDef.npcHeight = 240;
			entityDef.npcWidth = 240;
			entityDef.combatLevel = 328;
		}



		if (i == 3097) {//Estate agent

			entityDef.actions = new String[5];
			entityDef.actions[0] = "Open";
			entityDef.actions[2] = "Teleport to house";
		}


		if (i == 6480) {//Galvek pet
			NpcDefinition dh = lookup(8095);
			entityDef.name = "Mini Galvek";
			entityDef.actions = new String[5];
			entityDef.actions[0] = "Pick-up";
			entityDef.models = new int[1];
			entityDef.models = dh.models;
			entityDef.standingAnimation = dh.standingAnimation;
			entityDef.walkingAnimation = dh.walkingAnimation;
			entityDef.npcHeight = 40;
			entityDef.npcWidth = 40;
			entityDef.combatLevel = 0;
		}




		if (i == 6479) {
			NpcDefinition dh = lookup(1673);
			entityDef.name = "Dharok pet";
			entityDef.actions = new String[5];
			entityDef.actions[0] = "Pick-up";
			entityDef.models = new int[1];
			entityDef.models = dh.models;
			entityDef.standingAnimation = dh.standingAnimation;
			entityDef.walkingAnimation = dh.walkingAnimation;
			entityDef.npcHeight = 80;
			entityDef.npcWidth = 80;
			entityDef.combatLevel = 0;
		}

		if (i == 6477) {
			entityDef.name = "Tarn Razorlor";
			entityDef.combatLevel = 500;
			entityDef.models = new int[] { 60322 };
			entityDef.standingAnimation = 5616;
			entityDef.walkingAnimation = 5615;
			entityDef.onMinimap = true;
			entityDef.actions = new String[5];
			entityDef.actions = new String[] { null, "Attack", null, null, null };
			entityDef.rotationSpeed = 64;
			entityDef.npcHeight = 220;
			entityDef.npcWidth = 220;
		}


		if (i == 3833) {
			entityDef.name = "The Nightmare";
			entityDef.combatLevel = 666;
			entityDef.models = new int[] {60959};
			entityDef.standingAnimation = 7191;
			entityDef.walkingAnimation = 7195;
			entityDef.actions = new String[5];
			entityDef.actions = new String[] { null, "Attack", null, null, null };
			entityDef.rotationSpeed = 64;
			entityDef.npcHeight = 180;
			entityDef.npcWidth = 180;
			entityDef.size = 3;
		}


		if (i == 3407) {
			entityDef.name = "Solak";
			entityDef.combatLevel = 546;
			entityDef.models = new int[] { 50204 };
			entityDef.standingAnimation = 5893;
			entityDef.walkingAnimation = 5892;
			entityDef.onMinimap = true;
			entityDef.actions = new String[5];
			entityDef.actions = new String[] { null, "Attack", null, null, null };;
			entityDef.rotationSpeed = 64;
			entityDef.size = 3;
			entityDef.npcWidth = 180;
			entityDef.npcHeight = 180;

		}

		if (i == 4804) { //lava dragon
			NpcDefinition lava = lookup(6593);
			entityDef.models = new int[4];
			entityDef.models = new int[]{28300, 28301, 28302, 17423};
			entityDef.originalColors = new int[]{40};
			entityDef.newColors = new int[]{59};
			entityDef.name = "Infernal dragon";
			entityDef.description = "It's dripping with infernal lava";
			entityDef.walkingAnimation = lava.walkingAnimation;
			entityDef.standingAnimation = lava.standingAnimation;
			entityDef.actions = new String[5];
			entityDef.actions[1] = "Attack";
			entityDef.onMinimap = true;
			entityDef.combatLevel = 313;
			entityDef.rotationSpeed = 64;
			entityDef.npcHeight = 120;
			entityDef.npcWidth = 120;
		}


		if (i == 7117) {
			entityDef.name = "Lms Store";
			entityDef.actions = new String[5];
			entityDef.actions[0] = "Open";
		}

		if (i == 8007) {
			entityDef.name = "Afk Store";
			entityDef.actions = new String[5];
			entityDef.actions[0] = "Open";
		}

		if (i == 6876) {
			entityDef.name = "Trivia Store";
			entityDef.actions = new String[5];
			entityDef.actions[0] = "Open";
		}

		if (i == 8184) {
			entityDef.name = "Theatre Of Blood Wizard";
			entityDef.actions = new String[5];
			entityDef.actions[0] = "Teleport";
		}
		if (i == 7599) {
			entityDef.name = "CyphoraX Guide";
		}
		if (i == 4305) {
			entityDef.name = "Drunken cannoneer";
			entityDef.actions = new String[5];
			entityDef.actions[0] = "Pickpocket";
		}
		if (i == 3247) {
			entityDef.name = "Wizard";
			entityDef.actions = new String[5];
			entityDef.actions[0] = "Teleport";
		}
		if (i == 6517) {
			entityDef.name = "Daily-reward wizard";
			entityDef.actions = new String[5];
			entityDef.actions[0] = "Talk-to";
			entityDef.actions[2] = "View rewards";
		}
		if (i == 3428 || i == 3429) {
			entityDef.name = "Elf warrior";
		}
		if (i == 5044) { // sanfew (decant)
			entityDef.actions = new String[5];
			entityDef.actions[0] = "Decant-potions";
		}
		if (i == 8026) {
			entityDef.combatLevel = 392;
		}
		if (i == 7913) {
			entityDef.combatLevel = 0;
			entityDef.name = "Ironman shop keeper";
			entityDef.description = "A shop specifically for iron men.";
		}
		if (i == 8906) {
			entityDef.combatLevel = 0;
			entityDef.name = "Santa's little elf";
			entityDef.description = "A helper sent from santa himself.";
			entityDef.actions = new String[] { "Talk-To", null, "Christmas Shop", "Return-Items", null };
		}
		if (i == 954) {
			entityDef.combatLevel = 0;
			entityDef.name = "Crystal Seed Trader";
			entityDef.description = "Use a seed on me to get a Crystal Bow.";

		}
		if (i == 6970) {
			entityDef.combatLevel = 0;
			entityDef.name = "Theif";
			entityDef.actions = new String[] { null, null, "Pickpocket",  null,  null };
		}
		if (i == 8761) {
			entityDef.combatLevel = 0;
			entityDef.actions = new String[] { "Talk-to", null, "Assignment", "Trade", "Rewards" };

		}
		if (i == 9400) {
			entityDef.name = "Ted O'bombr";
		}
		if (i == 8026 || i == 8027 || i == 8028) {
			entityDef.size = 9;
		}
		if (i == 7954) {
			entityDef.combatLevel = 0;
			entityDef.name = "Achievement Master";
			entityDef.actions = new String[] { "Trade", null, "Open Achievements", null, null, };

		}
		if (i == 5870) {
			entityDef.combatLevel = 0;
			entityDef.actions = new String[] { "Talk-to", null, "Assignment", "Trade", "Rewards" };

		}
		if (i == 3400) {
			entityDef.combatLevel = 0;
			entityDef.name = "Giveaway Manager";
			entityDef.actions = new String[] { "Open-manager", null, null, null, null };

		}
		if (i == 1013) {
			entityDef.combatLevel = 0;
			entityDef.name = "Gambler Shop";
			entityDef.description = "A shop specifically for gamblers.";
		}
		if (i == 308) {
			entityDef.combatLevel = 0;
			entityDef.name = "PKP Manager";
		}
		if (i == 13) {
			entityDef.combatLevel = 0;
			entityDef.name = "Referral Tutor";
			entityDef.description = "He manages referrals.";
		}
		if (i == 5293) {
			entityDef.combatLevel = 0;
			entityDef.name = "Elven Keeper";
		}
		if(i==3218 || i ==3217){
			entityDef.combatLevel = 0;
			entityDef.actions = new String[] { "Trade", null, null, null, null };
		}
		if(i==2897){
			entityDef.combatLevel = 0;
			entityDef.name = "Trading Post Manager";
			entityDef.actions = new String[] { "Open", null, "Collect", null, null };
		}
		if(i==1306){
			entityDef.combatLevel = 0;
			entityDef.actions = new String[] { "Make-over", null, null, null, null };
		}
		if(i==3257){
			entityDef.combatLevel = 0;
			entityDef.actions = new String[] { "Trade", null, null, null, null };
		}
		if(i==1011){
			entityDef.combatLevel = 0;
			entityDef.name = "Item Gambler";
			entityDef.actions = new String[] { "Info", null, "Gamble", null, null };
		}
		if(i==3248){
			entityDef.combatLevel = 0;
			entityDef.name = Configuration.CLIENT_TITLE + " Wizard";
			entityDef.actions = new String[] { "Teleport", null, "Previous Location", null, null };
		}
		if(i==1520){
			entityDef.combatLevel = 0;
			entityDef.actions = new String[] { "Small Net", null, "Harpoon", null, null };
		}
		if(i==8920){

			entityDef.actions = new String[] { null, "Attack", null, null, null };
		}
		if(i==8921){
			entityDef.name = "Crystal Whirlwind";
		}
		if(i==9120){
			entityDef.combatLevel = 0;
			entityDef.name = "Donator Shop";
			entityDef.actions = new String[] { "Trade", null, "Claim", null, null };
		}
		if(i == 2662){
			entityDef.combatLevel = 0;
			entityDef.name = "Tournament Manager";
			entityDef.actions = new String[] { "Open-Shop", null, null, null, null };
		}
		if(i==603){
			entityDef.combatLevel = 0;
			entityDef.name = "Captain Kraken";
			entityDef.actions = new String[] { "Talk-to", null, null, null, null };
		}
		if(i==7041){
			entityDef.combatLevel = 0;
			entityDef.name = "Ticket Exchange";
			entityDef.actions = new String[] { "Exchange", null, null, null, null };
		}
		if(i==3894){
			entityDef.combatLevel = 0;
			entityDef.name = "Sigmund The Merchant";
			entityDef.actions = new String[] { "Trade", null, null, null, null };
		}

		if (i==7413) {
			entityDef.name = "Max Dummy";
			entityDef.actions[0] = null;
		}
		if(i==9011){
			entityDef.combatLevel = 0;
			entityDef.name = "Vote Shop";
			entityDef.actions = new String[] { "Trade", null, "Claim", null, null };
		}
		if(i==1933){
			entityDef.combatLevel = 0;
			entityDef.name = "Mills";
			entityDef.actions = new String[] { "Trade", null, null, null, null };
		}
		if(i==8819){
			entityDef.combatLevel = 0;
			entityDef.name = "Boss point shop";
			entityDef.actions = new String[] { null, null, "Trade", null, null };
		}
		if(i==8688){
			entityDef.combatLevel = 0;
			entityDef.name = "Fat Tony";
			entityDef.actions = new String[] { "Trade", null, null, null, null };
		}
		if(i==7769){
			entityDef.combatLevel = 0;
			entityDef.name = "Shop Keeper";
			entityDef.actions = new String[] { "Trade", null, null, null, null };
		}
		if(i==6987){
			entityDef.combatLevel = 0;
			entityDef.name = "Man";
			entityDef.actions = new String[] { "Talk", null, "Pickpocket", null, null };
		}
		if(i==5730){
			entityDef.combatLevel = 0;
			entityDef.name = "Master Farmer";
			entityDef.actions = new String[] { "Pickpocket", null, "Trade", null, null };
		}
		if(i==1501){
			entityDef.combatLevel = 0;
			entityDef.name = "Hunter Store";
			entityDef.actions = new String[] { null, null, null, null, "Trade" };
		}
		if(i==2913){
			entityDef.combatLevel = 0;
			entityDef.name = "Fishing Store";
			entityDef.actions = new String[] { "Trade", null, null, null, null };
		}
		if(i==5809){
			entityDef.combatLevel = 0;
			entityDef.name = "Crafting and Tanner";
			entityDef.actions = new String[] { "Tan", null, "Trade", null, null };
		}
		if(i==555){
			entityDef.combatLevel = 0;
			entityDef.name = "Sell Me Store";
			entityDef.actions = new String[] { "Trade", null, null, null, null };
		}
		if(i==9168){
			entityDef.combatLevel = 0;
			entityDef.name = "Flex";
			entityDef.actions = new String[] { "Trade", null, null, null, null };
		}
		if(i==8208){
			entityDef.combatLevel = 0;
			entityDef.name = "Pet Collector";
			entityDef.actions = new String[] { "Talk-to", null, null, null, null };
		}
		if(i==8202){
			entityDef.actions = new String[] { "Talk-to", "Pick-Up", null, null, null };
		}
		if(i==4921){
			entityDef.combatLevel = 0;
			entityDef.name = "Supplies";
			entityDef.actions = new String[] { "Trade", null, null, null, null };
		}
		if (i == 5314) {
			entityDef.combatLevel = 0;
			entityDef.name = "Mystical Wizard";
			entityDef.actions = new String[] { "Teleport", "Previous Location", null, null, null };
			entityDef.description = "This wizard has the power to teleport you to many locations.";
		}
		if (i == 8781) {
			entityDef.name = "@red@Queen Latsyrc";
			entityDef.combatLevel = 982;
			entityDef.onMinimap = true;
			entityDef.actions = new String[5];
			entityDef.actions = new String[] { null, "Attack", null, null, null };
		}
		if(i==1577){
			entityDef.combatLevel = 0;
			entityDef.name = "Melee Shop";
			entityDef.combatLevel = 0;
			entityDef.actions = new String[] { "Trade", null, null, null, null };
		}
		if(i==1576){
			entityDef.combatLevel = 0;
			entityDef.name = "Range Shop";
			entityDef.combatLevel = 0;
			entityDef.actions = new String[] { "Trade", null, null, null, null };
		}
		if(i==1578){
			entityDef.combatLevel = 0;
			entityDef.name = "Mage Shop";
			entityDef.combatLevel = 0;
			entityDef.actions = new String[] { "Trade", null, null, null, null };
		}
		if (i == 8026) {
			entityDef.name = "Vorkath";
			// entityDef.combatLevel = 732;
			entityDef.models = new int[] { 35023 };
			entityDef.standingAnimation = 7946;
			entityDef.onMinimap = true;
			entityDef.actions = new String[5];
			entityDef.actions = new String[] { "Poke", null, null, null, null };
			entityDef.npcWidth = 100;
			entityDef.npcHeight = 100;
		}
		if (i == 7852 || i == 7853 || i == 7884) {//Dawn
			entityDef.standingAnimation = 7775;
			entityDef.walkingAnimation = 7775;
		}
		if (i == 5518) {
			entityDef.standingAnimation = 185;
		}
		if (i == 8019) {
			entityDef.standingAnimation = 185;
			entityDef.actions = new String[5];
			entityDef.actions[0] = "Talk-to";
			entityDef.actions[2] = "Trade";
		}
		if (i == 308) {
			entityDef.actions = new String[5];
			entityDef.actions[0] = "Talk-to";
			entityDef.actions[2] = "Trade";
			entityDef.actions[3] = "Disable Interface";
			entityDef.actions[4] = "Skull";
		}
		if (i == 6088) {
			entityDef.standingAnimation = 185;
			entityDef.actions = new String[5];
			entityDef.actions[0] = "Talk-to";
			entityDef.actions[2] = "Travel";
		}
		if (i == 1434 || i == 876 || i == 1612) {//gnome fix
			entityDef.standingAnimation = 185;
		}
		if (i == 7674 || i == 8009 || i == 388 || i == 8010) {

			entityDef.combatLevel = 0;
			entityDef.actions = new String[5];
			entityDef.actions = new String[] { "Talk-to", null, "Pick-Up", "Metamorphosis", null };
		}
		if (i == 8492 || i == 8493 || i == 8494 || i == 8495) {
			entityDef.combatLevel = 0;
			entityDef.actions = new String[5];
			entityDef.actions = new String[] { "Talk-to", null, "Pick-Up", "Metamorphosis", null };
		}
		if (i == 8737 || i == 8738 || i == 8009 || i == 7674) {
			entityDef.combatLevel = 0;
			entityDef.actions = new String[5];
			entityDef.actions = new String[] { "Talk-to", null, "Pick-Up", "Metamorphosis", null };
		}
		if (i == 326 || i == 327) {
			entityDef.combatLevel = 0;
			entityDef.npcWidth = 85;
			entityDef.npcHeight = 85;
			entityDef.name = "Vote Pet";
			entityDef.actions = new String[5];
			entityDef.actions = new String[] { "Talk-to", null, "Pick-Up", "Metamorphosis", null };
		}
		if (i >= 7354 && i <=7367) {
			entityDef.combatLevel = 0;
			entityDef.actions = new String[5];
			entityDef.actions = new String[] { "Talk-to", null, "Pick-Up", "Metamorphosis", null };
		}
		if (i == 5559 || i == 5560) {
			entityDef.actions = new String[5];
			entityDef.actions = new String[] { "Talk-to", null, "Pick-Up", "Metamorphosis", null };
		}
		if (i == 2149 || i == 2150 || i == 2151 || i == 2148) {
			entityDef.name = "Trading Clerk";
			entityDef.actions = new String[5];
			entityDef.actions = new String[] { "Bank", null, "Trading Post", null, null };
		}
		if (i == 6473) { //terror dog
			entityDef.combatLevel = 0;
			entityDef.npcWidth = 50; //WIDTH
			entityDef.npcHeight = 50; // HEIGH
		}
		if (i == 3510) { //outlast shop
			entityDef.name = "Trader";
			entityDef.combatLevel = 0;
			entityDef.onMinimap = true;
			entityDef.npcWidth = 150; //WIDTH
			entityDef.npcHeight = 150; // HEIGH
			entityDef.actions = new String[5];
			entityDef.actions = new String[] { "Open-Shop", null, null, null, null };
		}
		if (i == 488) { //rain cloud
			entityDef.combatLevel = 0;
			entityDef.size = 1;
			entityDef.onMinimap = true;
			entityDef.npcWidth = 150; //WIDTH
			entityDef.npcHeight = 150; // HEIGH
			entityDef.actions = new String[5];
			entityDef.actions = new String[] { "Talk-to", null, "Pick-Up", null, null };
		}
		if (i == 7668) { //voice of yama
			entityDef.name = "Kratos";
			entityDef.size = 2;
			entityDef.combatLevel = 0;
			entityDef.npcWidth = 90; //WIDTH
			entityDef.npcHeight = 90; // HEIGH
			entityDef.actions = new String[5];
			entityDef.actions = new String[] { "Talk-to", null, "Pick-Up", null, null };

		}
		if (i == 1377) {
			entityDef.name = "Ark";
			entityDef.size = 3;
			entityDef.combatLevel = 700;
			entityDef.npcWidth = 300; //WIDTH
			entityDef.npcHeight = 300; // HEIGH
			entityDef.actions[0] = null;


		}
		if (i == 2105) {
			entityDef.size = 4;
			entityDef.npcWidth = 600; //WIDTH
			entityDef.npcHeight = 600; // HEIGH
		}
		if (i == 2107) {
			entityDef.size = 4;
			entityDef.npcWidth = 600; //WIDTH
			entityDef.npcHeight = 600; // HEIGH
		}
		if (i == 2850) {
			entityDef.name = "GIM Tracker";
			entityDef.actions = new String[] { "Open", null, null, null, null };

		}
		if (i == 6119) { //weird monster
			entityDef.size = 1;
			entityDef.combatLevel = 0;
			entityDef.npcWidth = 30; //WIDTH
			entityDef.npcHeight = 30; // HEIGH
		}
		if (i == 763) { //roc

			entityDef.size = 1;
			entityDef.combatLevel = 0;
			entityDef.npcWidth = 30; //WIDTH
			entityDef.npcHeight = 30; // HEIGH
			entityDef.actions = new String[5];
			entityDef.actions = new String[] { "Talk-to", null, "Pick-Up", "Metamorphosis", null };


		}
		if (i == 762) { //foe small bird
			entityDef.size = 1;
			entityDef.combatLevel = 0;
			entityDef.actions = new String[5];
			entityDef.actions = new String[] { "Talk-to", null, "Pick-Up", "Metamorphosis", null };
		}
		if (i == 4987 || i == 6292 || i == 6354 ) { //chronzon
			entityDef.size = 1;
			entityDef.combatLevel = 0;
			entityDef.npcWidth = 45; //WIDTH
			entityDef.npcHeight = 45; // HEIGH
		}
		if (i == 8709) {
			entityDef.actions = new String[5];
			entityDef.actions = new String[] { "Talk-to", null, "Pick-Up", null, null };
			entityDef.name = "Corrupt Beast";
			entityDef.combatLevel = 0;
			entityDef.npcWidth = 60; //WIDTH
			entityDef.npcHeight = 60; // HEIGH
			entityDef.size = 1;
		}
		if (i == 7025) { //guard dog
			entityDef.actions = new String[5];
			entityDef.actions = new String[] { "Talk-to", null, "Pick-Up", null, null };
			entityDef.npcWidth = 85; //WIDTH
			entityDef.npcHeight = 85; // HEIGH
		}

		if (i == 6716) {//prayer
			entityDef.actions = new String[5];
			entityDef.actions = new String[] { "Talk-to", null, "Pick-Up", null, null };
			entityDef.npcWidth = 65; //WIDTH
			entityDef.npcHeight = 65; // HEIGH
			entityDef.combatLevel = 0;


		}
		if (i == 6723) {//healer
			entityDef.actions = new String[5];
			entityDef.actions = new String[] { "Talk-to", null, "Pick-Up", null, null };
			entityDef.npcWidth = 65; //WIDTH
			entityDef.npcHeight = 65; // HEIGH
			entityDef.combatLevel = 0;

		}
		if (i == 1088) {
			entityDef.name = "Seren";
			entityDef.models = new int[] { 38605 };
			entityDef.actions = new String[5];
			entityDef.actions = new String[] { "Talk-to", null, "Pick-Up", null, null };
			entityDef.npcWidth = 65; //WIDTH
			entityDef.npcHeight = 65; // HEIGH
			entityDef.originalColors = null;
			entityDef.newColors = null;
			entityDef.combatLevel = 0;
			entityDef.standingAnimation = 8372;
			entityDef.walkingAnimation = 8372;
			entityDef.models = new int[] { 38605 };

		}
		if (i == 1089) {
			entityDef.name = "Lil mimic";
			entityDef.models = new int[] { 37142 };
			entityDef.actions = new String[5];
			entityDef.actions = new String[] { "Talk-to", null, "Pick-Up", null, null };
			entityDef.npcWidth = 25; //WIDTH
			entityDef.npcHeight = 25; // HEIGH
			entityDef.originalColors = null;
			entityDef.newColors = null;
			entityDef.combatLevel = 0;
			entityDef.standingAnimation = 8307;
			entityDef.walkingAnimation = 8306;
			entityDef.models = new int[] { 37142 };

		}
		if (i == 2120) {
			entityDef.name = "Shadow Ranger";
			entityDef.models = new int[] { 29267 };
			entityDef.actions = new String[5];
			entityDef.actions = new String[] { "Talk-to", null, "Pick-Up", null, null };
			entityDef.npcWidth = 85; //WIDTH
			entityDef.npcHeight = 85; // HEIGH
			entityDef.originalColors = null;
			entityDef.newColors = null;
			entityDef.combatLevel = 0;
			entityDef.standingAnimation = 8526;
			entityDef.walkingAnimation = 8527;
			entityDef.models = new int[] { 29267 };

		}
		if (i == 2121) {
			entityDef.name = "Shadow Wizard";
			entityDef.models = new int[] { 29268 };
			entityDef.actions = new String[5];
			entityDef.actions = new String[] { "Talk-to", null, "Pick-Up", null, null };
			entityDef.npcWidth = 85; //WIDTH
			entityDef.npcHeight = 85; // HEIGH
			entityDef.originalColors = null;
			entityDef.newColors = null;
			entityDef.combatLevel = 0;
			entityDef.standingAnimation = 8526;
			entityDef.walkingAnimation = 8527;
			entityDef.models = new int[] { 29268 };
		}
		if (i == 2122) {
			entityDef.name = "Shadow Warrior";
			entityDef.models = new int[] { 29266 };
			entityDef.actions = new String[5];
			entityDef.actions = new String[] { "Talk-to", null, "Pick-Up", null, null };
			entityDef.npcWidth = 85; //WIDTH
			entityDef.npcHeight = 85; // HEIGH
			entityDef.originalColors = null;
			entityDef.newColors = null;
			entityDef.combatLevel = 0;
			entityDef.standingAnimation = 8526;
			entityDef.walkingAnimation = 8527;
			entityDef.models = new int[] { 29266 };
		}

		if (i == 7216 || i == 6473) {//green monkey and green dog
			entityDef.actions = new String[5];
			entityDef.combatLevel = 0;
			entityDef.actions = new String[] { "Talk-to", null, "Pick-Up", null, null };
		}
		if (i == 6723 || i == 6716 || i == 8709) {
			entityDef.actions = new String[5];
			entityDef.combatLevel = 0;
			entityDef.actions = new String[] { "Talk-to", null, "Pick-Up", null, null };
		}
		if (i == 3291) {//postie pete
			entityDef.actions = new String[5];
			entityDef.combatLevel = 0;
			entityDef.actions = new String[] { "Talk-to", null, "Pick-Up", null, null };
		}
		if (i == 5738) {//imp
			entityDef.actions = new String[5];
			entityDef.combatLevel = 0;
			entityDef.actions = new String[] { "Talk-to", null, "Pick-Up", null, null };

		}
		if (i == 5240) {//toucan
			entityDef.actions = new String[5];
			entityDef.combatLevel = 0;
			entityDef.actions = new String[] { "Talk-to", null, "Pick-Up", null, null };

		}
		if (i == 834) {
			entityDef.name = "King penguin";
			entityDef.actions = new String[5];
			entityDef.combatLevel = 0;
			entityDef.actions = new String[] { "Talk-to", null, "Pick-Up", null, null };

		}
		if (i == 1873) {//klik
			entityDef.actions = new String[5];
			entityDef.actions = new String[] { "Talk-to", null, "Pick-Up", null, null };
			entityDef.standingAnimation = 3345;
			entityDef.walkingAnimation = 3346;

		}
		//dark pets
		if (i == 2300) {
			entityDef.models = new int[1];
			entityDef.name = "Dark postie pete";
			entityDef.models = new int[] { 46600 };
			entityDef.actions = new String[5];
			entityDef.actions = new String[] { "Talk-to", null, "Pick-Up", null, null };
			entityDef.originalColors = null;
			entityDef.newColors = null;
			entityDef.combatLevel = 0;
			entityDef.standingAnimation = 3948;
			entityDef.walkingAnimation = 3947;
		}
		if (i == 2301) {
			entityDef.name = "Dark imp";
			entityDef.models = new int[] { 46700 };
			entityDef.actions = new String[5];
			entityDef.actions = new String[] { "Talk-to", null, "Pick-Up", null, null };
			entityDef.originalColors = null;
			entityDef.newColors = null;
			entityDef.combatLevel = 0;
			entityDef.standingAnimation = 171;
			entityDef.walkingAnimation = 168;
		}
		if (i == 2302) {
			entityDef.name = "Dark toucan";
			entityDef.models = new int[] { 46800, 46801 };
			entityDef.actions = new String[5];
			entityDef.actions = new String[] { "Talk-to", null, "Pick-Up", null, null };
			entityDef.originalColors = null;
			entityDef.newColors = null;
			entityDef.combatLevel = 0;
			entityDef.standingAnimation = 6772;
			entityDef.walkingAnimation = 6774;
		}
		if (i == 2303) {
			entityDef.name = "Dark king penguin";
			entityDef.models = new int[] { 46200 };
			entityDef.actions = new String[5];
			entityDef.actions = new String[] { "Talk-to", null, "Pick-Up", null, null };
			entityDef.originalColors = null;
			entityDef.newColors = null;
			entityDef.combatLevel = 0;
			entityDef.standingAnimation = 5668;
			entityDef.walkingAnimation = 5666;
		}
		if (i == 2304) {
			entityDef.name = "Dark k'klik";
			entityDef.models = new int[] { 46300, 46301, 46302 };
			entityDef.actions = new String[5];
			entityDef.actions = new String[] { "Talk-to", null, "Pick-Up", null, null };
			entityDef.originalColors = null;
			entityDef.newColors = null;
			entityDef.combatLevel = 0;
			entityDef.standingAnimation = 3346;
			entityDef.walkingAnimation = -1;
		}
		if (i == 2305) {
			entityDef.name = "Dark shadow warrior";
			entityDef.models = new int[] { 46100 };
			entityDef.actions = new String[5];
			entityDef.actions = new String[] { "Talk-to", null, "Pick-Up", null, null };
			entityDef.originalColors = null;
			entityDef.newColors = null;
			entityDef.combatLevel = 0;
			entityDef.standingAnimation = 8526;
			entityDef.walkingAnimation = 8527;
			entityDef.npcWidth = 85; //WIDTH
			entityDef.npcHeight = 85; // HEIGH
		}
		if (i == 2306) {
			entityDef.name = "Dark shadow archer";
			entityDef.models = new int[] { 56800 };
			entityDef.actions = new String[5];
			entityDef.actions = new String[] { "Talk-to", null, "Pick-Up", null, null };
			entityDef.originalColors = null;
			entityDef.newColors = null;
			entityDef.combatLevel = 0;
			entityDef.standingAnimation = 8526;
			entityDef.walkingAnimation = 8527;
			entityDef.npcWidth = 85; //WIDTH
			entityDef.npcHeight = 85; // HEIGH
		}
		if (i == 2307) {
			entityDef.name = "Dark shadow wizard";
			entityDef.models = new int[] { 45900 };
			entityDef.actions = new String[5];
			entityDef.actions = new String[] { "Talk-to", null, "Pick-Up", null, null };
			entityDef.originalColors = null;
			entityDef.newColors = null;
			entityDef.combatLevel = 0;
			entityDef.standingAnimation = 8526;
			entityDef.walkingAnimation = 8527;
			entityDef.npcWidth = 85; //WIDTH
			entityDef.npcHeight = 85; // HEIGH
		}
		if (i == 2308) {
			entityDef.name = "Dark healer death spawn";
			entityDef.models = new int[] { 46500, 46501, 46502, 46503, 46504, 46505, 46506,};
			entityDef.actions = new String[5];
			entityDef.actions = new String[] { "Talk-to", null, "Pick-Up", null, null };
			entityDef.originalColors = null;
			entityDef.newColors = null;
			entityDef.npcWidth = 65; //WIDTH
			entityDef.npcHeight = 65; // HEIGH
			entityDef.combatLevel = 0;
			entityDef.standingAnimation = 1539;
			entityDef.walkingAnimation = 1539;
		}
		if (i == 2309) {
			entityDef.name = "Dark holy death spawn";
			entityDef.models = new int[] { 46406, 46405, 46404, 46403, 46402, 46401, 46400 };
			entityDef.actions = new String[5];
			entityDef.actions = new String[] { "Talk-to", null, "Pick-Up", null, null };
			entityDef.originalColors = null;
			entityDef.newColors = null;
			entityDef.npcWidth = 65; //WIDTH
			entityDef.npcHeight = 65; // HEIGH
			entityDef.combatLevel = 0;
			entityDef.standingAnimation = 1539;
			entityDef.walkingAnimation = 1539;
		}
		if (i == 2310) {
			entityDef.name = "Dark seren";
			entityDef.models = new int[] { 46900 };
			entityDef.actions = new String[5];
			entityDef.actions = new String[] { "Talk-to", null, "Pick-Up", null, null };
			entityDef.originalColors = null;
			entityDef.newColors = null;
			entityDef.combatLevel = 0;
			entityDef.standingAnimation = 8372;
			entityDef.walkingAnimation = 8372;
			entityDef.npcWidth = 65; //WIDTH
			entityDef.npcHeight = 65; // HEIGH
		}
		if (i == 2311) {
			entityDef.name = "Dark corrupt beast";
			entityDef.models = new int[] { 45710 };
			entityDef.actions = new String[5];
			entityDef.actions = new String[] { "Talk-to", null, "Pick-Up", null, null };
			entityDef.originalColors = null;
			entityDef.newColors = null;
			entityDef.combatLevel = 0;
			entityDef.npcWidth = 60; //WIDTH
			entityDef.npcHeight = 60; // HEIGH
			entityDef.size = 1;
			entityDef.standingAnimation = 5616;
			entityDef.walkingAnimation = 5615;
		}
		if (i == 2312) {
			entityDef.name = "Dark roc";
			entityDef.models = new int[] { 45603, 45604 };
			entityDef.actions = new String[5];
			entityDef.actions = new String[] { "Talk-to", null, "Pick-Up", null, null };
			entityDef.originalColors = null;
			entityDef.newColors = null;
			entityDef.standingAnimation = 5021;
			entityDef.walkingAnimation = 5022;
			entityDef.size = 1;
			entityDef.combatLevel = 0;
			entityDef.npcWidth = 30; //WIDTH
			entityDef.npcHeight = 30; // HEIGH
		}

		if (i == 2318) {
			entityDef.name = "Dark roc";
			entityDef.models = new int[] { 45603, 45604 };
			entityDef.actions = new String[5];
			entityDef.actions = new String[] { "Talk-to", null, "Pick-Up", null, null };
			entityDef.newColors = new int[] { 57022, 48811, 2, 1029, 1032, 11, 12, 14, 16, 20, 22, 2 };
			entityDef.originalColors = new int[] { 677, 801, 43540, 43543, 43546, 43549, 43550, 43552, 43554, 43558,
				43560, 43575 };
			entityDef.standingAnimation = 5021;
			entityDef.walkingAnimation = 5022;
			entityDef.size = 1;
			entityDef.combatLevel = 0;
			entityDef.npcWidth = 30; //WIDTH
			entityDef.npcHeight = 30; // HEIGH
		}

		if (i == 2313) {
			entityDef.name = "Dark kratos";
			entityDef.models = new int[] { 45500, 45501, 45502 };
			entityDef.actions = new String[5];
			entityDef.actions = new String[] { "Talk-to", null, "Pick-Up", null, null };
			entityDef.originalColors = null;
			entityDef.newColors = null;
			entityDef.standingAnimation = 7017;
			entityDef.walkingAnimation = 7016;
			entityDef.size = 2;
			entityDef.combatLevel = 0;
			entityDef.npcWidth = 90; //WIDTH
			entityDef.npcHeight = 90; // HEIGH
		}
		if (i == 8027) {
			entityDef.name = "Vorkath";
			entityDef.combatLevel = 732;
			entityDef.models = new int[] { 35023 };
			entityDef.standingAnimation = 7950;
			entityDef.onMinimap = true;
			entityDef.actions = new String[5];
			entityDef.actions = new String[] { null, null, null, null, null };
			entityDef.npcWidth = 100;
			entityDef.npcHeight = 100;
		}
		if (i == 8028) {
			entityDef.name = "Vorkath";
			entityDef.combatLevel = 732;
			entityDef.models = new int[] { 35023 };
			entityDef.standingAnimation = 7948;
			entityDef.onMinimap = true;
			entityDef.actions = new String[5];
			entityDef.actions = new String[] { null, "Attack", null, null, null };
			entityDef.npcWidth = 100;
			entityDef.npcHeight = 100;
		}
		if(i==7144){
			entityDef.anInt75 = 0;
		}
		if(i==963){
			entityDef.anInt75 = 6;
		}
		if(i==7145){
			entityDef.anInt75 = 1;
		}
		if(i==7146){
			entityDef.anInt75 = 2;
		}
		if (entityDef.name != null && entityDef.name.toLowerCase().contains("chinchompa") && !entityDef.name.toLowerCase().contains("baby")) {
			entityDef.actions = new String[5];
		}
        return entityDef;
    }

    public static int totalAmount;

    public static void dump() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("./npc_defs.txt"))) {
            for (int i = 0; i < 70_000; i++) {
                try {
                    NpcDefinition def = NpcDefinition.lookup(i);
                    if (def != null) {
                        writer.write("Npc=" + i);
                        writer.newLine();
                        writer.write("Stand animation=" + def.standingAnimation);
                        writer.newLine();
                        writer.write("Walk animation=" + def.walkingAnimation);
                        writer.newLine();
                        writer.newLine();
                    }
                } catch (Exception e) {
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void unpackConfig(FileArchive streamLoader) {
        stream = new Buffer(streamLoader.readFile("npc.dat"));
        Buffer stream = new Buffer(streamLoader.readFile("npc.idx"));
        totalAmount = stream.readUShort();
        streamIndices = new int[totalAmount];
        int i = 2;
        for (int j = 0; j < totalAmount; j++) {
            streamIndices[j] = i;
            i += stream.readUShort();
        }

        cache = new NpcDefinition[20];
        for (int k = 0; k < 20; k++)
            cache[k] = new NpcDefinition();
        for (int index = 0; index < totalAmount; index++) {
            NpcDefinition ed = lookup(index);
            if (ed == null)
                continue;
            if (ed.name == null)
                continue;
        }
        if (Configuration.dumpDataLists) {
            NpcDefinitionDumper.dump();

            TempWriter writer2 = new TempWriter("npc_fields");
            FieldGenerator generator = new FieldGenerator(writer2::writeLine);
            IntStream.range(0, 100_000).forEach(id -> {
                try {
                    NpcDefinition definition = NpcDefinition.lookup(id);
                    generator.add(definition.name, id);
                } catch (Exception e) {
                }
            });
            writer2.close();
        }
    }

    /*
     * public void readValues(Stream stream) { do { int i =
     * stream.readUnsignedByte(); if (i == 0) return; if (i == 1) { int j =
     * stream.readUnsignedByte(); models = new int[j]; for (int j1 = 0; j1 < j;
     * j1++) models[j1] = stream.readUnsignedWord();
     *
     * } else if (i == 2) name = stream.readString(); else if (i == 3) description =
     * stream.readString(); else if (i == 12) squareLength =
     * stream.readSignedByte(); else if (i == 13) standAnim =
     * stream.readUnsignedWord(); else if (i == 14) walkAnim =
     * stream.readUnsignedWord(); else if (i == 17) { walkAnim =
     * stream.readUnsignedWord(); anInt58 = stream.readUnsignedWord(); anInt83 =
     * stream.readUnsignedWord(); anInt55 = stream.readUnsignedWord(); if (anInt58
     * == 65535) { anInt58 = -1; } if (anInt83 == 65535) { anInt83 = -1; } if
     * (anInt55 == 65535) { anInt55 = -1; } } else if (i >= 30 && i < 40) { if
     * (actions == null) actions = new String[5]; actions[i - 30] =
     * stream.readString(); if (actions[i - 30].equalsIgnoreCase("hidden"))
     * actions[i - 30] = null; } else if (i == 40) { int k =
     * stream.readUnsignedByte(); originalColors = new int[k]; newColors = new
     * int[k]; for (int k1 = 0; k1 < k; k1++) { originalColors[k1] =
     * stream.readUnsignedWord(); newColors[k1] = stream.readUnsignedWord(); }
     *
     * } else if (i == 60) { int l = stream.readUnsignedByte(); dialogueModels = new
     * int[l]; for (int l1 = 0; l1 < l; l1++) dialogueModels[l1] =
     * stream.readUnsignedWord();
     *
     * } else if (i == 90) stream.readUnsignedWord(); else if (i == 91)
     * stream.readUnsignedWord(); else if (i == 92) stream.readUnsignedWord(); else
     * if (i == 93) minimapDot = false; else if (i == 95) combatLevel =
     * stream.readUnsignedWord(); else if (i == 97) anInt91 =
     * stream.readUnsignedWord(); else if (i == 98) anInt86 =
     * stream.readUnsignedWord(); else if (i == 99) aBoolean93 = true; else if (i ==
     * 100) anInt85 = stream.readSignedByte(); else if (i == 101) anInt92 =
     * stream.readSignedByte() * 5; else if (i == 102) anInt75 =
     * stream.readUnsignedByte(); else if (i == 103) getDegreesToTurn =
     * stream.readUnsignedByte(); else if (i == 106) { anInt57 =
     * stream.readUnsignedWord(); if (anInt57 == 65535) anInt57 = -1; anInt59 =
     * stream.readUnsignedWord(); if (anInt59 == 65535) anInt59 = -1; int i1 =
     * stream.readUnsignedByte(); childrenIDs = new int[i1 + 1]; for (int i2 = 0; i2
     * <= i1; i2++) { childrenIDs[i2] = stream.readUnsignedWord(); if
     * (childrenIDs[i2] == 65535) childrenIDs[i2] = -1; }
     *
     * } else if (i == 107) aBoolean84 = false; } while (true); }
     */

    public int category;

    private void readValues(Buffer buffer) {
        while (true) {
            int opcode = buffer.readUnsignedByte();
            if (opcode == 0)
                return;
            if (opcode == 1) {
                int j = buffer.readUnsignedByte();
                models = new int[j];
                for (int j1 = 0; j1 < j; j1++)
                    models[j1] = buffer.readUShort();

            } else if (opcode == 2)
                name = buffer.readString();
            else if (opcode == 12)
                size = buffer.readSignedByte();
            else if (opcode == 13)
                standingAnimation = buffer.readUShort();
            else if (opcode == 14)
                walkingAnimation = buffer.readUShort();
            else if (opcode == 17) {
                walkingAnimation = buffer.readUShort();
                rotate180AnimIndex = buffer.readUShort();
                rotate90CWAnimIndex = buffer.readUShort();
                rotate90CCWAnimIndex = buffer.readUShort();
                if (rotate180AnimIndex == 65535) {
                    rotate180AnimIndex = -1;
                }
                if (rotate90CWAnimIndex == 65535) {
                    rotate90CWAnimIndex = -1;
                }
                if (rotate90CCWAnimIndex == 65535) {
                    rotate90CCWAnimIndex = -1;
                }
            } else if (opcode == 18) {
                category = buffer.readUShort();
            } else if (opcode >= 30 && opcode < 40) {
                if (actions == null)
                    actions = new String[10];
                actions[opcode - 30] = buffer.readString();
                if (actions[opcode - 30].equalsIgnoreCase("hidden"))
                    actions[opcode - 30] = null;
            } else if (opcode == 40) {
                int k = buffer.readUnsignedByte();
                originalColors = new int[k];
                newColors = new int[k];
                for (int k1 = 0; k1 < k; k1++) {
                    originalColors[k1] = buffer.readUShort();
                    newColors[k1] = buffer.readUShort();
                }
            } else if (opcode == 41) {
                int k = buffer.readUnsignedByte();
                originalTextures = new short[k];
                newTextures = new short[k];
                for (int k1 = 0; k1 < k; k1++) {
                    originalTextures[k1] = (short) buffer.readUShort();
                    newTextures[k1] = (short) buffer.readUShort();
                }

            } else if (opcode == 60) {
                int l = buffer.readUnsignedByte();
                chatheadModels = new int[l];
                for (int l1 = 0; l1 < l; l1++)
                    chatheadModels[l1] = buffer.readUShort();

            } else if (opcode == 93)
                onMinimap = false;
            else if (opcode == 95)
                combatLevel = buffer.readUShort();
            else if (opcode == 97)
                npcHeight = buffer.readUShort();
            else if (opcode == 98)
                npcWidth = buffer.readUShort();
            else if (opcode == 99)
                aBoolean93 = true;
            else if (opcode == 100)
                ambient = buffer.readSignedByte();
            else if (opcode == 101)
                contrast = buffer.readSignedByte();
            else if (opcode == 102)
                anInt75 = buffer.readUShort();
            else if (opcode == 103)
                rotationSpeed = buffer.readUShort();
            else if (opcode == 106 || opcode == 118) {
                varbitId = buffer.readUShort();
                if (varbitId == 65535)
                    varbitId = -1;
                varpIndex = buffer.readUShort();
                if (varpIndex == 65535)
                    varpIndex = -1;
                int var3 = -1;
                if (opcode == 118)
                    var3 = buffer.readUShort();
                int i1 = buffer.readUnsignedByte();
                configs = new int[i1 + 2];
                for (int i2 = 0; i2 <= i1; i2++) {
                    configs[i2] = buffer.readUShort();
                    if (configs[i2] == 65535)
                        configs[i2] = -1;
                }
                configs[i1 + 1] = var3;
            } else if (opcode == 107)
                clickable = false;
        }
    }

    public Model method160() {
        if (configs != null) {
            NpcDefinition entityDef = method161();
            if (entityDef == null)
                return null;
            else
                return entityDef.method160();
        }
        if (chatheadModels == null) {
            return null;
        }
        boolean flag1 = false;
        for (int i = 0; i < chatheadModels.length; i++)
            if (!Model.isCached(chatheadModels[i]))
                flag1 = true;

        if (flag1)
            return null;
        Model aclass30_sub2_sub4_sub6s[] = new Model[chatheadModels.length];
        for (int j = 0; j < chatheadModels.length; j++)
            aclass30_sub2_sub4_sub6s[j] = Model.getModel(chatheadModels[j]);

        Model model;
        if (aclass30_sub2_sub4_sub6s.length == 1)
            model = aclass30_sub2_sub4_sub6s[0];
        else
            model = new Model(aclass30_sub2_sub4_sub6s.length, aclass30_sub2_sub4_sub6s);

        if (originalColors != null)
            for (int k = 0; k < originalColors.length; k++)
                model.recolor(originalColors[k], newColors[k]);


        if (originalTextures != null)
            for (int k = 0; k < originalTextures.length; k++)
                model.retexture(originalTextures[k], newTextures[k]);

        return model;
    }

    public NpcDefinition method161() {
        int j = -1;
        if (varbitId != -1 && varbitId <= 2113) {
            VarBit varBit = VarBit.cache[varbitId];
            int k = varBit.anInt648;
            int l = varBit.anInt649;
            int i1 = varBit.anInt650;
            int j1 = Client.anIntArray1232[i1 - l];
            j = clientInstance.variousSettings[k] >> l & j1;
        } else if (varpIndex != -1)
            j = clientInstance.variousSettings[varpIndex];
        int var3;
        if (j >= 0 && j < configs.length)
            var3 = configs[j];
        else
            var3 = configs[configs.length - 1];
        return var3 == -1 ? null : lookup(var3);
    }

    public Model method164(int j, int k, int ai[]) {
        if (configs != null) {
            NpcDefinition entityDef = method161();
            if (entityDef == null)
                return null;
            else
                return entityDef.method164(j, k, ai);
        }
        Model model = (Model) mruNodes.get(npcId);
        if (model == null) {
            boolean flag = false;
            for (int i1 = 0; i1 < models.length; i1++)
                if (!Model.isCached(models[i1]))
                    flag = true;

            if (flag)
                return null;
            Model aclass30_sub2_sub4_sub6s[] = new Model[models.length];
            for (int j1 = 0; j1 < models.length; j1++)
                aclass30_sub2_sub4_sub6s[j1] = Model.getModel(models[j1]);

            if (aclass30_sub2_sub4_sub6s.length == 1)
                model = aclass30_sub2_sub4_sub6s[0];
            else
                model = new Model(aclass30_sub2_sub4_sub6s.length, aclass30_sub2_sub4_sub6s);
            if (originalColors != null) {
                for (int k1 = 0; k1 < originalColors.length; k1++)
                    model.recolor(originalColors[k1], newColors[k1]);

            }
            if (originalTextures != null) {
                for (int i1 = 0; i1 < originalTextures.length; i1++)
                    model.retexture(originalTextures[i1], newTextures[i1]);
            }
            model.generateBones();
            model.light(64 + ambient, 850 + contrast, -30, -50, -30, true);
            // model.method479(84 + anInt85, 1000 + anInt92, -90, -580, -90, true);
            mruNodes.put(model, npcId);
        }
        Model model_1 = Model.emptyModel;
        model_1.replaceModel(model, Frame.noAnimationInProgress(k) & Frame.noAnimationInProgress(j));
        if (k != -1 && j != -1)
            model_1.animate2(ai, j, k);
        else if (k != -1)
            model_1.animate(k);
        if (npcHeight != 128 || npcWidth != 128)
            model_1.scale(npcHeight, npcHeight, npcWidth);
        model_1.calculateBoundsCylinder();
        model_1.faceGroups = null;
        model_1.vertexGroups = null;
        if (size == 1)
            model_1.singleTile = true;
        return model_1;
    }

    private NpcDefinition() {
        rotate90CCWAnimIndex = -1;
        varbitId = walkingAnimation;
        rotate180AnimIndex = walkingAnimation;
        varpIndex = walkingAnimation;
        combatLevel = -1;
        anInt64 = 1834;
        walkingAnimation = -1;
        size = 1;
        anInt75 = -1;
        standingAnimation = -1;
        npcId = -1L;
        rotationSpeed = 32;
        rotate90CWAnimIndex = -1;
        clickable = true;
        npcWidth = 128;
        onMinimap = true;
        npcHeight = 128;
        aBoolean93 = false;
    }

    @Override
    public String toString() {
        return "NpcDefinition{" +
                "npcId=" + npcId +
                ", combatLevel=" + combatLevel +
                ", name='" + name + '\'' +
                ", actions=" + Arrays.toString(actions) +
                ", walkAnim=" + walkingAnimation +
                ", size=" + size +
                ", standAnim=" + standingAnimation +
                ", childrenIDs=" + Arrays.toString(configs) +
                ", models=" + Arrays.toString(models) +
                '}';
    }

    public static void nullLoader() {
        mruNodes = null;
        streamIndices = null;
        cache = null;
        stream = null;
    }

    public static void dumpList() {
        try {
            File file = new File("./temp/npc_list.txt");

            if (!file.exists()) {
                file.createNewFile();
            }

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                for (int i = 0; i < totalAmount; i++) {
                    NpcDefinition definition = lookup(i);
                    if (definition != null) {
                        writer.write("npc = " + i + "\t" + definition.name + "\t" + definition.combatLevel + "\t"
                                + definition.standingAnimation + "\t" + definition.walkingAnimation + "\t");
                        writer.newLine();
                    }
                }
            }

            System.out.println("Finished dumping npc definitions.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void dumpSizes() {
        try {
            File file = new File(System.getProperty("user.home") + "/Desktop/npcSizes 143.txt");

            if (!file.exists()) {
                file.createNewFile();
            }

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                for (int i = 0; i < totalAmount; i++) {
                    NpcDefinition definition = lookup(i);
                    if (definition != null) {
                        writer.write(i + "	" + definition.size);
                        writer.newLine();
                    }
                }
            }

            System.out.println("Finished dumping npc definitions.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int rotate90CCWAnimIndex;
    public static int anInt56;
    public int varbitId;
    public int rotate180AnimIndex;
    public int varpIndex;
    public static Buffer stream;
    public int combatLevel;
    public final int anInt64;
    public String name;
    public String actions[];
    public int walkingAnimation;
    public byte size;
    public int[] newColors;
    public static int[] streamIndices;
    public int[] chatheadModels;
    public int anInt75;
    public int[] originalColors;
    public short[] originalTextures, newTextures;
    public int standingAnimation;
    public long npcId;
    public int rotationSpeed;
    public static NpcDefinition[] cache;
    public static Client clientInstance;
    public int rotate90CWAnimIndex;
    public boolean clickable;
    public int ambient;
    public int npcWidth;
    public boolean onMinimap;
    public int configs[];
    public String description;
    public int npcHeight;
    public int contrast;
    public boolean aBoolean93;
    public int[] models;
    public static ReferenceCache mruNodes = new ReferenceCache(70);
    public int[] anIntArray76;

    @Override
    public HeadIcon getOverheadIcon() {
        return null;
    }

    @Override
    public int getIntValue(int paramID) {
        return 0;
    }

    @Override
    public void setValue(int paramID, int value) {

    }

    @Override
    public String getStringValue(int paramID) {
        return null;
    }

    @Override
    public void setValue(int paramID, String value) {

    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public int[] getModels() {
        return new int[0];
    }

    @Override
    public String[] getActions() {
        return new String[0];
    }

    @Override
    public boolean isClickable() {
        return false;
    }

    @Override
    public boolean isFollower() {
        return false;
    }

    @Override
    public boolean isInteractible() {
        return false;
    }

    @Override
    public boolean isMinimapVisible() {
        return false;
    }

    @Override
    public boolean isVisible() {
        return false;
    }

    @Override
    public int getId() {
        return 0;
    }

    @Override
    public int getCombatLevel() {
        return 0;
    }

    @Override
    public int[] getConfigs() {
        return new int[0];
    }

    @Override
    public RSNPCComposition transform() {
        return null;
    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public int getRsOverheadIcon() {
        return 0;
    }

    @Override
    public RSIterableNodeHashTable getParams() {
        return null;
    }

    @Override
    public void setParams(IterableHashTable params) {

    }

    @Override
    public void setParams(RSIterableNodeHashTable params) {

    }
}
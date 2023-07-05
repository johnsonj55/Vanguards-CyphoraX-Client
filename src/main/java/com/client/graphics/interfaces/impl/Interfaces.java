package com.client.graphics.interfaces.impl;

import com.client.*;
import com.client.graphics.interfaces.Configs;
import com.client.graphics.interfaces.MenuItem;
import com.client.graphics.interfaces.RSInterface;
import com.client.graphics.interfaces.builder.impl.*;
import com.client.graphics.interfaces.builder.impl.tasks.TaskInterface;
import com.client.graphics.interfaces.builder.impl.tob.TobFoodChest;
import com.client.graphics.interfaces.builder.impl.tob.TobPartyOverlay;
import com.client.graphics.interfaces.builder.impl.tob.TobRewardsInterface;
import com.client.graphics.interfaces.daily.DailyRewards;
import com.client.graphics.interfaces.dropdown.KeybindingMenu;
import com.client.graphics.interfaces.eventcalendar.EventCalendar;
import com.client.graphics.interfaces.settings.SettingsInterface;
import com.client.graphics.loaders.SpriteLoader1;

public final class Interfaces extends RSInterface {

	public static final int CLOSE_BUTTON_SMALL = 37302;
	public static final int CLOSE_BUTTON_SMALL_HOVER = 37303;
	public static final int SHOP_CONTAINER = 64016;

	public static TaskInterface taskInterface;

	private Interfaces() {}

	public static void loadInterfaces() {
		hiscores(defaultTextDrawingAreas);
		//ironmanLeaderboard(defaultTextDrawingAreas);//Fix in game then reopen
		upgradeInt(defaultTextDrawingAreas);
		wellOfGoodWill(defaultTextDrawingAreas);
		barrowsInterface(defaultTextDrawingAreas);//new barrows
		//npcDropTable(defaultTextDrawingAreas); // needs some work first cam
		crystalTele(defaultTextDrawingAreas);
		tournamentLobby(defaultTextDrawingAreas);
		pvpTab(defaultTextDrawingAreas);
	    achievementInterface(defaultTextDrawingAreas);
		playerProfiler(defaultTextDrawingAreas);
		profileTab(defaultTextDrawingAreas);
		myProfile(defaultTextDrawingAreas);
		staffTab(defaultTextDrawingAreas);
		creditsTab(defaultTextDrawingAreas);
		priceChecker(defaultTextDrawingAreas);
		newQuest(defaultTextDrawingAreas);
		raidsOverlay(defaultTextDrawingAreas);
		sigilSystem(defaultTextDrawingAreas);
		Nex.instance.load(defaultTextDrawingAreas);


 		fireofExchange(defaultTextDrawingAreas);
		wrathRune();
		new SettingsInterface().load(defaultTextDrawingAreas);
		mysteryBox(defaultTextDrawingAreas);
		shopWidget(defaultTextDrawingAreas);
		barrowsReward(defaultTextDrawingAreas);
		keybinding(defaultTextDrawingAreas);
		ancients(defaultTextDrawingAreas);
		helpDatabaseComponent(defaultTextDrawingAreas);
		helpComponent(defaultTextDrawingAreas);
		new Bank().bank(defaultTextDrawingAreas);
		bankPin(defaultTextDrawingAreas);
		clanChatTab(defaultTextDrawingAreas);
		clanChatSetup(defaultTextDrawingAreas);
		teleportInterface(defaultTextDrawingAreas);
	/*	teleportInterfaceJosh(defaultTextDrawingAreas);*/
		SettingsTabWidget.widget(defaultTextDrawingAreas);
		emoteTab();
		bountyHunterWidget(defaultTextDrawingAreas);
		godWars(defaultTextDrawingAreas);
		prayerBook(defaultTextDrawingAreas);
		equipmentScreen(defaultTextDrawingAreas);
		presetInterface(defaultTextDrawingAreas);
		equipmentTab(defaultTextDrawingAreas);
		itemsOnDeath(defaultTextDrawingAreas);
		Pestpanel(defaultTextDrawingAreas);
		Pestpanel2(defaultTextDrawingAreas);
		configureLunar(defaultTextDrawingAreas);
		achievements(defaultTextDrawingAreas);
		updateShopWidget(defaultTextDrawingAreas);
		initializeTitleWidget(defaultTextDrawingAreas);
		initializeCommandHelp();
		addPestControlRewardWidget(defaultTextDrawingAreas);
		addAntibotWidget(defaultTextDrawingAreas);
		addGodwarsWidget(defaultTextDrawingAreas);
		barrowsKillcount(defaultTextDrawingAreas);
		lootingBag(defaultTextDrawingAreas);
		lootingBagAdd(defaultTextDrawingAreas);
		runePouch(defaultTextDrawingAreas);
		quickPrayers(defaultTextDrawingAreas);
		listings(defaultTextDrawingAreas);
		tradingpost(defaultTextDrawingAreas);
		tradingSelect(defaultTextDrawingAreas);
		offer(defaultTextDrawingAreas);
		tradingSelected(defaultTextDrawingAreas);
		skotizo(defaultTextDrawingAreas);
		slayerOverlay(defaultTextDrawingAreas);
		prestigeInterface(defaultTextDrawingAreas);
		expLock(defaultTextDrawingAreas);
		skillTabWithHovers(defaultTextDrawingAreas);
		normals(defaultTextDrawingAreas);
		tournamentInterface(defaultTextDrawingAreas);
		tourneyJoinInterface(defaultTextDrawingAreas);
		collectionLog(defaultTextDrawingAreas);
		votePanel(defaultTextDrawingAreas);
		pollInterface(defaultTextDrawingAreas);
        pollResults(defaultTextDrawingAreas);
		SlayerRewards.initializeInterfaces(defaultTextDrawingAreas);
		new LootViewer().load(defaultTextDrawingAreas);

		taskInterface = new TaskInterface();
		taskInterface.actions.loadAchievements();
		taskInterface.build();

		//new QuestTab().load(defaultTextDrawingAreas);

		fixDefensiveAutocast();
		EventCalendar.getCalendar().load(defaultTextDrawingAreas);
		Nightmare.instance.load(defaultTextDrawingAreas);
		staffSpecialBar();
		Autocast.getSingleton().load();
		questInterface(defaultTextDrawingAreas);
		DailyRewards.get().load();
		StarterInterface.get().load();
		SpawnContainer.get().load();
		KillLog.get().load();
		WogwInterface.get().load();
		DonatorRewards.getInstance().load();
		NotificationTab.instance.build();
		cataTele(defaultTextDrawingAreas);
		groupInformation(defaultTextDrawingAreas);
		groupLeaderboard(defaultTextDrawingAreas);
		new MonsterDropViewer().OsDropViewer(defaultTextDrawingAreas);
		dropTable(defaultTextDrawingAreas);
		new TobPartyOverlay().build();
		new TobRewardsInterface().build();
		new TobFoodChest().build();
		new GroupIronmanBank().build();
		new PlayerPartyInterface().build();
		new WildWarning().build();
		new PerduLostPropertyShop().build();
		new LeaderboardInterface().build();
		new QuestInterface().build();
	}

	public static void questInterface(TextDrawingArea[] TDA) {
		RSInterface Interface = addInterface(8134);
		Interface.centerText = true;
		addSprite(8135, 0, "quest/questbg");
		addSprite(8136, 1, "quest/questbg");
		addText(8144, "Quest Name", 0x000000, true, false, 52, TDA, 3);//249 18
		addHover(8137, 3, 0, 8138, 0, "quest/close", 26,23, "Close");
		addHovered(8138, 1, "quest/close", 26, 23, 8139);
		setChildren(6, Interface);
		setBounds(8136, 18, 4, 0, Interface);
		setBounds(8135, 18, 62, 1, Interface);
		setBounds(8144, 260, 15, 2, Interface);
		setBounds(8140, 50, 86, 3, Interface);
		setBounds(8137, 452, 63, 4, Interface);
		setBounds(8138, 452, 63, 5, Interface);
		Interface = addInterface(8140);
		Interface.height = 217;
		Interface.width = 404;
		Interface.scrollMax = 218;
		setChildren(52 + 100, Interface);
		int Ypos = 18;
		int frameID = 0;
		for(int iD = 8145; iD <= 8195;iD++) {
			addText(iD, "j", 0x000080, true, false, 52, TDA, 1);
			setBounds(iD, 202, Ypos, frameID, Interface);
			frameID++;
			Ypos += 19;
			Ypos ++;
		}
		for(int iD = 21614; iD <= 21614 + 100;iD++) {
			addText(iD, "j", 0x000080, true, false, 52, TDA, 1);
			setBounds(iD, 202, Ypos, frameID, Interface);
			frameID++;
			Ypos += 19;
			Ypos ++;
		}
	}

	public static void staffSpecialBar() {
		RSInterface inter = get(328);
		RSInterface.expandChildren(1, inter);
		inter.child( inter.children.length - 1, 12323, 17, 201);
	}

	public static void fireofExchange(TextDrawingArea[] tda) {
		RSInterface inter = addInterface(33400);
		addSprite(33401, 0, "Interfaces/FireOfExchange/SPRITE");
		addText(33402, "Shard Exchange", tda, 2, 0xff9933, true, true);
		addHoverButton(33932, "Interfaces/HelpInterface/IMAGE", 2, 16, 16, "Close", -1, 33932, 3);
		addHoveredButton(33933, "Interfaces/HelpInterface/IMAGE", 3, 16, 16, 33933);
		addSprite(33406, 1, "Interfaces/FireOfExchange/SPRITE");
		addText(33407, "Shard Value:", tda, 2, 0xff9933, true, true);
		//addText(33408, "Total Exchange Points:", tda, 2, 0xff9933, true, true);
		addText(33409, "0", tda, 2, 0xff0000, true, true);
		//addText(33410, "00", tda, 2, 0xff0000, true, true);
		//addButton(33411, 1, "Interfaces/FireOfExchange/BUTTON", "Open Exchange Store");
		addButton(47003, 527, "Interfaces/MysteryBox/SPRITE", "Close");
		//addText(33412, "Exchange Store", tda, 2, 0xffffff, true, true);
		addButton(33413, 2, "Interfaces/FireOfExchange/ARROW", "Exchange Item");
		inter.totalChildren(14);
		setBounds(33401, 175, 77, 0, inter);
		setBounds(33402, 247, 92, 1, inter);
		setBounds(33932, 310, 91, 4, inter);
		setBounds(33933, 310, 91, 3, inter);
		setBounds(33406, 210, 142, 5, inter);
		setBounds(33407, 257, 185, 6, inter);
		//setBounds(33408, 332, 139, 7, inter);
		setBounds(33409, 260, 205, 8, inter);
		//setBounds(33410, 332, 159, 9, inter);
		//setBounds(33411, 261, 197, 10, inter);
		//setBounds(33412, 332, 206, 11, inter);
		addItemContainer(33403, 1, 1, 0, 0, false);
		setBounds(33403, 215, 142, 12, inter);
		setBounds(33413, 281, 146, 13, inter);


		inter = addInterface(33404);
		inter.totalChildren(1);
		addItemContainer(33405, 4, 7, 10, 4, true,
				"Offer");
		setBounds(33405, 16, 8, 0, inter);


	}

	public static void pollInterface(TextDrawingArea tda[]) {
		RSInterface rsi = addInterface(21406);
		RSInterface scroll = addInterface(21407);

        addText(21408, "Poll:\\nPoll Name Here", tda, 2, 0xFF9300, true, true);

		int childId = 21409;
		scroll.width = 165;
		scroll.height = 258;

		addText(childId++, "Time Left to Vote: 13 Hours", tda, 0, 0xFF9300, true, true);

		for(int i = 0; i < 5; i++) {
			addText(childId++, "" + (i + 1) + ")", tda, 0, 0xFF9300, true, true);
			addConfigButton(childId++, 618, 2, 4, "Interfaces/Ironman/IMAGE", 17, 17, "Select", 1, 1, 30 + i);
			addText(childId++, "Give bronze dagger\\na spec", tda, 0, 0xFF9300, false, true);
		}

		addHoverButton(childId++, "Interfaces/PollTab/BUTTON", 0, 150, 35, "Vote", -1, childId, 1);
		addHoveredButton(childId++, "Interfaces/PollTab/BUTTON", 1, 150, 35, childId++);
        addText(childId++, "Vote", tda, 2, 0xFF9300, true, true);

		scroll.totalChildren(childId - 21409 - 1);
		childId = 21409;
		int frame = 0;

		scroll.child(frame++, childId++, 80, 25);

		int startX = 15;
		int startY = 50;
		for(int i = 0; i < 5; i++) {
			scroll.child(frame++, childId++, startX, startY);
			scroll.child(frame++, childId++, startX + 10, startY - 2);
			scroll.child(frame++, childId++, startX + 35, startY);
			startY += 22;
		}

		scroll.child(frame++, childId++, 5, 165);
		scroll.child(frame++, childId++, 5, 165);
		childId++;
        scroll.child(frame++, childId++, 80, 174);

		rsi.totalChildren(2);
        rsi.child(0, 21407, 16, 0);
		rsi.child(1, 21408, 96, 10);
	}

	public static void pollResults(TextDrawingArea tda[]) {
        RSInterface rsi = addInterface(21429);

        int childId = 21430;
        addText(childId++, "Current Votes:", tda, 2, 0xFF9300, true, true);

        for(int i = 0; i < 5; i++) {
            addText(childId++, (i + 1) + ": 10 Votes", tda, 0, 0xFF9300, true, true);
        }

        for(int i = 0; i < 5; i++) {
            addText(childId++, "Answers", tda, 0, 0xFF9300, true, true);
        }

        rsi.totalChildren(childId - 21430);
        childId = 21430;
        int frame = 0;

        rsi.child(frame++, childId++, 96, 10);

        int startY = 35;
        for(int i = 0; i < 5; i++) {
            rsi.child(frame++, childId++, 96, startY);
            startY += 20;
        }

        startY = 150;
        for(int i = 0; i < 5; i++) {
            rsi.child(frame++, childId++, 96, startY);
            startY += 20;
        }
    }
	public static void fixDefensiveAutocast() {
		RSInterface rsi = interfaceCache[24111];
		rsi.anIntArray212 = new int[1];
		rsi.anIntArray212[0] = 1;
		rsi.anIntArray245 = new int[1];
		rsi.anIntArray245[0] = 1;
		rsi.scripts = new int[1][3];
		rsi.scripts[0][0] = 5;
		rsi.scripts[0][1] = Configs.AUTOCAST_DEFENCE_CONFIG;
		rsi.scripts[0][2] = 0;
		rsi.ignoreConfigClicking = true;
	}

	public static void mysteryBox(TextDrawingArea[] tda) {
		RSInterface iface = addInterface(47000);
		/* Base interface */
		//addSpriteLoader(47001, 1073);
		addSprite(47001, 1073, "Interfaces/MysteryBox/SPRITE");
		//addSprite(65001, 0, "Interfaces/Teleporting/Background");
		addText(47002, "Mystery Box", tda, 2, 0xFFA500, true, true);
		addButton(47003, 527, "Interfaces/MysteryBox/SPRITE", "Close");
		addButton(47004, 810, "Interfaces/MysteryBox/SPRITE", "Spin!");
		addText(47005, "@gre@Spin!", tda, 2, 0xFFA500, true, true);
		addSprite(47006, 530, "Interfaces/MysteryBox/SPRITE");
		addSprite(47007, 531, "Interfaces/MysteryBox/SPRITE");
		addText(47008, "Feeling lucky?", tda, 2, 0xFFA500, true, true);
		addText(47009, "Sacrifice your box for a chance at something rare!", tda, 1, 0xFFA500, true, true);
		addSprite(47010, 528, "Interfaces/MysteryBox/SPRITE");
		addSprite(47011, 533, "Interfaces/MysteryBox/SPRITE");


		setChildren(13, iface);
		setBounds(47001, 10, 10, 0, iface);
		setBounds(47002, 253, 13, 1, iface);
		setBounds(47003, 473, 14, 2, iface);
		setBounds(47004, 218, 256, 3, iface);
		setBounds(47005, 253, 263, 4, iface);
		setBounds(47006, 17, 185, 5, iface);
		setBounds(47007, 33, 65, 6, iface);
		setBounds(47008, 253, 78, 7, iface);
		setBounds(47009, 253, 108, 8, iface);
		// Boxes
		setBounds(47200, 10, 187, 9, iface);
		// Items
		setBounds(47100, 17, 192, 10, iface);
		// Item selector
		setBounds(47010, 252, 187, 11, iface);
		setBounds(47011, 10, 185, 12, iface);

		/* Boxes */
		RSInterface box = addInterface(47200);
		box.width = 480;
		setChildren(Client.BOXES64, box);
		// 64 boxes in each sprite
		int x = 0;
		for(int i=0; i<Client.BOXES64; i++){
			//addSpriteLoader(47201, 1076);
			addSprite(47201, 532, "Interfaces/MysteryBox/SPRITE");
			//addSprite(47201, 0, "");
			setBounds(47201, 0 + x, 0, i, box);
			x += 2880;
		}

		/* Items */
		RSInterface scroll = addInterface(47100);
		scroll.width = 474;
		addToItemGroup(47101, 1750, 1, 13, 10, false, null, null, null);
		setChildren(1, scroll);
		setBounds(47101, 0, 0, 0, scroll);
	}

	public static void wrathRune() {
		RSInterface rune = addTabInterface(28226);
		rune.totalChildren(1);
		addSprite(28228, 0, "Magic/wrath");
		setBounds(28228, 0, 0, 0, rune);
	}

	public static void normals(TextDrawingArea[] tda) {
		RSInterface p = addTabInterface(938);
		RSInterface rsinterface = interfaceCache[1151];
		RSInterface rsinterface2 = interfaceCache[12424];
		rsinterface2.height = 250;

			// earth wave
			rsinterface2.childX[36] = 96;
			rsinterface2.childY[36] = 168;
			
			// enfeeble
			rsinterface2.childX[46] = 120;
			rsinterface2.childY[46] = 168;
			
			// teleother lumbridge
			rsinterface2.childX[53] = 144;
			rsinterface2.childY[53] = 168;
			
			// fire wave
			rsinterface2.childX[37] = 1;
			rsinterface2.childY[37] = 192;
			
			// entangle
			rsinterface2.childX[50] = 23;
			rsinterface2.childY[50] = 192;
			
			// stun
			rsinterface2.childX[47] = 47;
			rsinterface2.childY[47] = 193;
			
			// charge
			rsinterface2.childX[41] = 71;
			rsinterface2.childY[41] = 192;
			
			// teleother falador
			rsinterface2.childX[54] = 120;
			rsinterface2.childY[54] = 192;
			
			// teleblock
			rsinterface2.childX[55] = 0;
			rsinterface2.childY[55] = 218;
			
			// lvl-6 enchant
			rsinterface2.childX[57] = 47;
			rsinterface2.childY[57] = 218;
			
			// teleother camelot
			rsinterface2.childX[56] = 71;
			rsinterface2.childY[56] = 218;

		rsinterface.childY[1] = 12;
		rsinterface.childX[1] = 14;
		addSpellSmall2_3(31674 + 975, 563, 566, 555, 554, 2, 2, 4, 5, 30012, 30015, 30004, 30003, 68, "Teleport to Kourend",
				"Teleports you to Kourend", tda, 10, 7, 5);
		addSpellLarge2(13674 + 975, 563, 560, 562, 1, 1, 1, 30012, 30009, 30011, 84, "Teleport to Bounty\\nTarget",
				"Teleports you near your Bounty\\nHunter Target", tda, 8, 7, 5);

		addSpellSmall2(22674 + 975, 565, 566, 564, 20, 20, 1, 30014, 30015, 30013, 92, "Lvl-7 Enchant",
				"For use on zenyte jewellery", tda, 12, 16, 2); // 16 spell useable on is for magic on inventory item
		
		addSpellSmaller(22644 + 975, 556, 21880, 7, 1, 30005, 28226, 80, "Wind Surge",
				"A very high level Air missile", tda, 0, 10, 2);
		
		addSpellSmall(22658 + 975, 555, 556, 21880, 10, 7, 1, 30004, 30005, 28226, 84, "Water Surge",
				"A very high level Water missile", tda, 2, 10, 2);
		
		addSpellSmall(22628 + 975, 557, 556, 21880, 10, 7, 1, 30006, 30005, 28226, 89, "Earth Surge",
				"A very high level Earth missile", tda, 4, 10, 2);
		
		addSpellSmall(22608 + 975, 554, 556, 21880, 10, 7, 1, 30003, 30005, 28226, 94, "Fire Surge",
				"A very high level Fire missile", tda, 6, 10, 2);
		
		setChildren(15, p);
		setBounds(31674 + 975, 84, 178, 0, p);
		setBounds(13674 + 975, 35, 228, 1, p);
		setBounds(22674 + 975, 132, 227, 2, p);
		setBounds(22644 + 975, 108, 202, 3, p);
		setBounds(22658 + 975, 156, 202, 4, p);
		setBounds(22628 + 975, 108, 227, 5, p);
		setBounds(22608 + 975, 156, 227, 6, p);
		setBounds(1151, 0, 0, 7, p);
		setBounds(22609 + 975, 5, 5, 8, p);
		setBounds(22629 + 975, 5, 5, 9, p);
		setBounds(22659 + 975, 5, 5, 10, p);
		setBounds(22645 + 975, 5, 5, 11, p);
		setBounds(31675 + 975, 5, 5, 12, p);
		setBounds(13675 + 975, 5, 5, 13, p);
		setBounds(22675 + 975, 5, 5, 14, p);
	}

	public static void closeButton(int id, int sprite2, int sprite1) {
		RSInterface tab = addInterface(id);
		tab.atActionType = 0;
		tab.type = 0;
		tab.sprite2 = Client.cacheSprite3[sprite2];
		tab.sprite1 = Client.cacheSprite3[sprite1];
		tab.width = tab.sprite1.myWidth;
		tab.height = tab.sprite2.myHeight;
		// tab.toggled = false;
		// tab.spriteOpacity = 255;d
	}

	public static void createSkillHover(int id, int x) {
		RSInterface hover = addInterface(id);
		hover.inventoryhover = true;
		hover.type = 8;
		hover.message = "TESTING!" + x;
		hover.contentType = x;
		hover.width = 60;
		hover.height = 32;
	}

	private static void skillTabWithHovers(TextDrawingArea[] tda) {
		int[] firstRow = { -1,

				/** First row (enx. index 9) **/
				14918, 14919, 14920, 14921, 14922, 14923, 14924, 14933

		};
		int[] secondRow = {

				/** Second row (enx. index 8) **/
				14926, 14927, 14928, 14929, 14930, 14931, 14932, 14925

		};
		int[] thirdRow = {

				/** Third row (enx. index 8) **/
				14934, 14935, 14936, 14937, 14938, 14939, 14940

		};

		RSInterface tab = addInterface(13917);
		tab.totalChildren(firstRow.length + secondRow.length + thirdRow.length);
		setBounds(3917, 0, 0, 0, tab);
		for (int i = 1; i < firstRow.length; i++) {
			createSkillHover(firstRow[i], 205 + i);
			setBounds(firstRow[i], 0, 2 + (32 * i) - 32, i, tab);
		}
		for (int i = 0; i < secondRow.length; i++) {
			createSkillHover(secondRow[i], 214 + i);
			setBounds(secondRow[i], 60, 2 + (32 * i), 9 + i, tab);
		}
		for (int i = 0; i < thirdRow.length; i++) {
			createSkillHover(thirdRow[i], 223 + i);
			setBounds(thirdRow[i], 120, 2 + (32 * i), 17 + i, tab);
		}
	}

	/**
	 * @author Grant_ | www.rune-server.ee/members/grant | 3/22/2020
	 */
	public static void votePanel(TextDrawingArea[] tda) {
		RSInterface widget = addInterface(24127);
		int childId = 24128;

		addSprite(childId++, 0, "Interfaces/VotePanel/BACKGROUND");
		addHoverButton(childId++, "Interfaces/CollectionLog/CLOSE", 0, 16, 16, "Close", -1, childId, 1);
		addHoveredButton(childId++, "Interfaces/CollectionLog/CLOSE", 1, 16, 16, childId++);

		addText(childId++, "Day Streak Points:", tda, 0, 0xFF9300, false, true);
		addText(childId++, "6", tda, 0, 0xFFFFFF, true, true);
		addText(childId++, "1", tda, 0, 0xFFFFFF, true, true);

		addText(childId++, "Vote Panel", tda, 2, 0xFF9300, true, true);

		addText(childId++, "", tda, 0, 0xFF9300, true, true);

		addText(childId++, "Current Day Streak: @whi@4", tda, 2, 0xFF9300, true, true);

		addSprites(childId++, "Interfaces/VotePanel/PIPE_UP", 0, 1, 2);
		addSprites(childId++, "Interfaces/VotePanel/PIPE_DOWN", 0, 1, 2);
		addSprites(childId++, "Interfaces/VotePanel/PIPE_UP", 0, 1, 2);
		addSprites(childId++, "Interfaces/VotePanel/PIPE_DOWN", 0, 1, 2);

		addSprites(childId++, "Interfaces/VotePanel/PENTA", 0, 1);
		addSprites(childId++, "Interfaces/VotePanel/PENTA", 0, 1);
		addSprites(childId++, "Interfaces/VotePanel/PENTA", 0, 1);
		addSprites(childId++, "Interfaces/VotePanel/PENTA", 0, 1);
		addSprites(childId++, "Interfaces/VotePanel/PENTA", 0, 1);

		//Top pentagon labels
		int[] days = {4, 8};
		String[] circleTexts = {"+3", "+5"};
		for(int i = 0; i < 2; i++) {
			addSprite(childId++, 0, "Interfaces/VotePanel/CIRCLE");
			addText(childId++, "@gre@Day " + days[i], tda, 0, 0xFF9300, true, true);
			addText(childId++, circleTexts[i], tda, 0, 0xFFFFFF, true, true);
		}

		//Bottom pentagon labels
		days = new int[]{2, 6};
		circleTexts = new String[]{"+2", "+4"};
		for(int i = 0; i < 2; i++) {
			addSprite(childId++, 0, "Interfaces/VotePanel/CIRCLE");
			addText(childId++, "@gre@Day " + days[i], tda, 0, 0xFF9300, true, true);
			addText(childId++, circleTexts[i], tda, 0, 0xFFFFFF, true, true);
		}

		//Custom last pentagon
		addText(childId++, "@gre@Day 10", tda, 0, 0xFFFFFF, true, true);
		addSprite(childId++, 1, "Interfaces/VotePanel/CIRCLE");
		addText(childId++, "+1", tda, 0, 0xFFFFFF, true, true);
		addSprite(childId++, 0, "Interfaces/VotePanel/BOX");
		addSprite(childId++, 1, "Interfaces/VotePanel/BOX");

		String[] buttonText = {"30 Min. Bonus XP", "10% DR Boost 1HR", "Vote Crystal", "Ultra M. Box"};
		int[] amounts = {2, 2, 1, 5};
		for(int i = 0; i < 4; i++) {
			addHoverButton(childId++, "Interfaces/VotePanel/BUTTON", 0, 139, 28, buttonText[i], -1, childId, 1);
			addHoveredButton(childId++, "Interfaces/VotePanel/BUTTON", 1, 139, 28, childId++);
			//System.out.println("ID: " + childId);
			addText(childId++, buttonText[i], tda, 0, 0xFF9933, true, true);
			addSprite(childId++, i == 3 ? 1 : 0, "Interfaces/VotePanel/CIRCLE");
			addText(childId++, amounts[i] + "", tda, 0, 0xFFFFFF, true, true);
		}

		addSprite(childId++, 2, "Interfaces/VotePanel/BOX");
		addText(childId++, "Point Store", tda, 0, 0xFF9933, true, true);

		addText(childId++, "Top 3 Weekly Voters:", tda, 2, 0xFF9300, true, true);

		String[] names = {"1. Billy [12]", "2. Grant [7]", "3. Noah [3]"};
		for(int i = 0; i < 3; i++) {
			addText(childId++, names[i], tda, 0, 0xFF9300, false, true);
			addText(childId++, "Prize:", tda, 0, 0xFF9300, false, true);
		}

		addHoverButton(childId++, "Interfaces/VotePanel/BUTTON", 2, 103, 26, "Claim Prize", -1, childId, 1);
		addHoveredButton(childId++, "Interfaces/VotePanel/BUTTON", 3, 103, 26, childId++);

		addText(childId++, "Claim Prize", tda, 2, 0xFF9300, true, true);
		addText(childId++, "Top 3 Voters reset in:\\n4 days, 3 hrs, 2 min", tda, 0, 0xFFFFFF, true, true);

		addToItemGroup(childId++, 1, 3, 0, 0, false);

		widget.totalChildren(childId - 24128 - 6);
		childId = 24128;
		int frame = 0;

		widget.child(frame++, childId++, 15, 30); //Background

		widget.child(frame++, childId++, 476, 39); //Close button
		widget.child(frame++, childId++, 476, 39);
		childId++;

		widget.child(frame++, childId++, 30, 42); //Day streak title
		widget.child(frame++, childId++, 139, 42); //Blue count
		widget.child(frame++, childId++, 160, 42); //Red count

		widget.child(frame++, childId++, 267, 40); //Title

		widget.child(frame++, childId++, 410, 42); //Vote Key

		widget.child(frame++, childId++, 163, 70); //Current Day streak

		int startX = 55;
		int startY = 125;
		for(int i = 0; i < 4; i++) {
			widget.child(frame++, childId++, startX, startY); //Pipe
			startX += 60;
			if (i == 1) {
				startX = 148;
			}
		}

		widget.child(frame++, childId++, 47, 164); //Pentagon
		widget.child(frame++, childId++, 95, 102); //Pentagon
		widget.child(frame++, childId++, 140, 164); //Pentagon
		widget.child(frame++, childId++, 185, 102); //Pentagon
		widget.child(frame++, childId++, 234, 164); //Pentagon

		startX = 115;
		startY = 89;
		//Top labels
		for(int i = 0; i < 2; i++) {
			widget.child(frame++, childId++, startX - 7, startY + 25);
			widget.child(frame++, childId++, startX, startY);
			widget.child(frame++, childId++, startX, startY + 28);

			startX += 90;
		}

		startX = 68;
		startY = 209;
		//Bottom labels
		for(int i = 0; i < 2; i++) {
			widget.child(frame++, childId++, startX - 8, startY - 32);
			widget.child(frame++, childId++, startX, startY);
			widget.child(frame++, childId++, startX, startY - 28);

			startX += 92;
		}

		//Custom last label
		widget.child(frame++, childId++, 254, 209);
		widget.child(frame++, childId++, 240, 173);
		widget.child(frame++, childId++, 247, 176);
		widget.child(frame++, childId++, 249, 184);
		widget.child(frame++, childId++, 255, 168);

		startX = 22;
		startY = 240;
		for(int i = 0; i < 4; i++) {
			widget.child(frame++, childId++, startX, startY);
			widget.child(frame++, childId++, startX, startY);
			childId++;

			widget.child(frame++, childId++, startX + 68, startY + 8);
			widget.child(frame++, childId++, startX + 117, startY + 4);
			widget.child(frame++, childId++, startX + 126, startY + 8);

			startX += 139;
			if (i == 1) {
				startX = 22;
				startY += 28;
			}
		}

		widget.child(frame++, childId++, 169, 272); //M box icon
		widget.child(frame++, childId++, 163, 227); //Point store text

		widget.child(frame++, childId++, 400, 70);
		startX = 314;
		startY = 103;
		for(int i = 0; i < 3; i++) {
			widget.child(frame++, childId++, startX, startY);
			widget.child(frame++, childId++, startX + 100, startY);
			startY += 30;
		}

		widget.child(frame++, childId++, 347, 209);
		widget.child(frame++, childId++, 347, 209);
		childId++;

		widget.child(frame++, childId++, 400, 215);
		widget.child(frame++, childId++, 400, 252);

		widget.child(frame++, childId++, 449, 93); //Items
	}

	/**
	 * @author Grant_ | www.rune-server.ee/members/grant_ | 10/7/19
	 * @param tda
	 */
	public static void collectionLog(TextDrawingArea[] tda) {
		//Config = 519
		RSInterface widget = addInterface(23110);
		int childId = 23111;

		addSprite(childId++, 0, "Interfaces/CollectionLog/BACKGROUND");

		addText(childId++, "Collection Log", tda, 2, 0xFF9300, true, true);

		addHoverButton(childId++, "Interfaces/CollectionLog/CLOSE", 0, 16, 16, "Close", -1, childId, 1);
		addHoveredButton(childId++, "Interfaces/CollectionLog/CLOSE", 1, 16, 16, childId++);

		addConfigButton(childId++, 618, 0, 1, "Interfaces/CollectionLog/TAB", 96, 20, "Select Bosses", 1, 1, 519);
		addText(childId++, "Bosses", tda, 1, 0xFF9300, true, true);

		addText(childId++, "Boss Name Here", tda, 2, 0xFF9300, false, true);
		addText(childId++, "Obtained: @red@10/11", tda, 0, 0xFF9300, false, true);
		addText(childId++, "Boss Name count: @whi@125", tda, 0, 0xFF9300, true, true);


		RSInterface tableView = addInterface(childId++);
		int scrollChildId = childId;
		int scrollFrame = 0;
		tableView.width = 187;
		tableView.height = 246;
		tableView.scrollMax = 550;
		tableView.totalChildren(50 * 2);

		int scrollX = 0;
		int scrollY = 0;
		for(int i = 0; i < 50; i++) {
			if (i % 2 == 0) {
				addConfigButton(scrollChildId, 23122, 0, 1, "Interfaces/CollectionLog/CELL", 187, 15, "Select Boss", 1, 1, 520 + i);
			} else {
				addConfigButton(scrollChildId, 23122, 2, 1, "Interfaces/CollectionLog/CELL", 187, 15, "Select Boss", 1, 1, 520 + i);
			}
			tableView.child(scrollFrame++, scrollChildId++, scrollX, scrollY);

			addText(scrollChildId, "Boss Name Here", tda, 1, 0xFF9300, false, true);
			tableView.child(scrollFrame++, scrollChildId++, scrollX + 4, scrollY);

			scrollY += 15;
		}

		widget.totalChildren(childId - 23111 - 1 + (8) + 2);
		childId = 23111;
		int frame = 0;

		widget.child(frame++, childId++, 9, 11);//Background
		widget.child(frame++, childId++, 257, 20);//Title

		widget.child(frame++, childId++, 482, 20);
		widget.child(frame++, childId++, 482, 20);
		childId++;

		widget.child(frame++, childId++, 19, 47);
		widget.child(frame++, childId++, 60, 50);

		widget.child(frame++, childId++, 230, 70);
		widget.child(frame++, childId++, 230, 94);
		widget.child(frame++, childId++, 433, 94);

		widget.child(frame++, childId++, 20, 68);

		//Had to add these on
		int nextChildId = scrollChildId;
		addConfigButton(nextChildId, 23111, 0, 1, "Interfaces/CollectionLog/TAB", 96, 20, "Select Wilderness", 1, 1, 571);
		widget.child(frame++, nextChildId++, 19 + 96, 47);
		addText(nextChildId, "Wilderness", tda, 1, 0xFF9300, true, true);
		widget.child(frame++, nextChildId++, 60 + 96, 50);

		addConfigButton(nextChildId, 23111, 0, 1, "Interfaces/CollectionLog/TAB", 96, 20, "Select Raids", 1, 1, 572);
		widget.child(frame++, nextChildId++, 19 + 96 + 96, 47);
		addText(nextChildId, "Raids", tda, 1, 0xFF9300, true, true);
		widget.child(frame++, nextChildId++, 60 + 96 + 96, 50);

		addConfigButton(nextChildId, 23111, 0, 1, "Interfaces/CollectionLog/TAB", 96, 20, "Select Minigames", 1, 1, 573);
		widget.child(frame++, nextChildId++, 19 + 96 + 96 + 96, 47);
		addText(nextChildId, "Minigames", tda, 1, 0xFF9300, true, true);
		widget.child(frame++, nextChildId++, 60 + 96 + 96 + 96, 50);

		addConfigButton(nextChildId, 23111, 0, 1, "Interfaces/CollectionLog/TAB", 96, 20, "Select Clue Scroll", 1, 1, 574);
		widget.child(frame++, nextChildId++, 19 + 96 + 96 + 96 + 96, 47);
		addText(nextChildId, "Other", tda, 1, 0xFF9300, true, true);
		widget.child(frame++, nextChildId++, 60 + 96 + 96 + 96 + 96, 50);

		int itemScrollId = nextChildId;
		RSInterface scroll = addInterface(itemScrollId);
		widget.child(frame++, itemScrollId++, 232, 114);
		int itemScrollFrame = 0;
		scroll.width = 250;
		scroll.height = 150;
		scroll.scrollMax = 1000;
		scroll.totalChildren(1);

		addToItemGroup(itemScrollId, 6, 33, 9, 6, false, null, null, null);
		scroll.child(itemScrollFrame++, itemScrollId++, 0, 0);

		int claimID = itemScrollId;
		RSInterface claim = addInterface(claimID);
		System.out.println(claimID);
		widget.child(frame++, claimID++, 223, 255);
		int itemClaimFrame = 0;
		claim.totalChildren(5);
		addSprite(claimID + 1, 0, "Interfaces/CollectionLog/box");
		addToItemGroup(claimID + 2, 6, 20, 5, 6, false, "", "", "");
		configHoverButtonNew(claimID+3, "Claim", "Interfaces/CollectionLog/claim", 0, 1, 0, 1, false);
		addText(claimID+4, "<img=28> Rewards for completing log:", tda, 0, 16750623, false, true);
		addText(claimID+5, "Claim", tda, 2, 16750623, true, true);

		claim.child(itemClaimFrame++, claimID+1, 2, 12);
		claim.child(itemClaimFrame++, claimID+2, 7, 21);
		claim.child(itemClaimFrame++, claimID+3, 200, 16);
		claim.child(itemClaimFrame++, claimID+4, 6, 1);
		claim.child(itemClaimFrame++, claimID+5, 236, 36);

	}
	
	/**
	 * @author Grant_ | www.rune-server.ee/members/grant_ | 10/6/19
	 * @param tda
	 */
	public static void tourneyJoinInterface(TextDrawingArea[] tda) {
		RSInterface widget = addInterface(270);
		int childId = 271;
		
		addSprite(childId++, 0, "Interfaces/Tourney/BACKGROUND");
		addText(childId++,
				"\\n" +
						"\\n" +
						"\\n" +
						"Warzone is a safe PvP tournament.\\n" +
				"\\n" +
				"Earn weapon and armour upgrades by killing targets. \\n" +
				"Once the 3 minute timer runs out, the fog damage will begin.\\n" +
				"Good luck!", tda, 2, 0xFF9300, true, true);
		
		addHoverButton(childId++, "Interfaces/Tourney/BUTTON", 0, 136, 32, "Fight", -1, childId, 1);
		addHoveredButton(childId++, "Interfaces/Tourney/BUTTON", 0, 135, 32, childId++);

		addHoverButton(childId++, "Interfaces/Tourney/BUTTON", 0, 136, 32, "Exit", -1, childId, 1);
		addHoveredButton(childId++, "Interfaces/Tourney/BUTTON", 0, 135, 32, childId++);
		
		addText(childId++, "Fight", tda, 2, 0x00FF00, true, true);
		addText(childId++, "Exit", tda, 2, 0xFF0000, true, true);
		
		widget.totalChildren(childId - 271 - 2);
		childId = 271;
		int frame = 0;
		
		widget.child(frame++, childId++, 11, 11);
		widget.child(frame++, childId++, 257, 100);
		
		widget.child(frame++, childId++, 100, 255);
		widget.child(frame++, childId++, 100, 255);
		childId++;
		
		widget.child(frame++, childId++, 285, 255);
		widget.child(frame++, childId++, 285, 255);
		childId++;
		
		widget.child(frame++, childId++, 167, 263);
		widget.child(frame++, childId++, 352, 263);
	}
	
	/**
	 * @author Grant_ | www.rune-server.ee/members/grant_ | 10/4/19
	 * @param tda
	 */
	public static void tournamentInterface(TextDrawingArea[] tda) {
		RSInterface widget = addInterface(264);
		int childId = 265;
		
		addText(childId++, "Warzone", tda, 2, 0xFFFFFF, true, true);
		addText(childId++, "Time Left: 5 min", tda, 1, 0xFFFFFF, true, true);
		addText(childId++, "Current Players", tda, 1, 0xFFFFFF, true, true);
		
		widget.totalChildren(childId - 265);
		childId = 265;
		int frame = 0;
		widget.child(frame++, childId++, 251, 5);
		widget.child(frame++, childId++, 251, 17);
		widget.child(frame++, childId++, 251, 29);
	}
	
	/**
	 * @author Grant_ | www.rune-server.ee/members/grant_ | 9/29/19
	 * @param tda
	 */
	public static void presetInterface(TextDrawingArea[] tda) {
		RSInterface widget = addInterface(21553);
		int childId = 21554;
		
		addSprite(childId++, 0, "Presets/BACKGROUND");
		
		for(int i = 0; i < 4; i++) {
			addConfigButton(childId++, 21553, 0, 1, "Presets/BUTTON", 118, 22, "Select Preset", 1, 1, 899 + i);
			addText(childId++, "Default " + i, tda, 1, 0xFF9300, false, true);
		}
		
		addText(childId++, "Pre-made Presets", tda, 1, 0xFFFFFF, true, true);
		addText(childId++, "Customs", tda, 1, 0xFFFFFF, true, true);
		addText(childId++, "Current Set", tda, 1, 0xFFFFFF, true, true);
		
		addHoverButton(childId++, "Presets/BUTTON", 2, 81, 28, "Load", -1, childId, 1);
		addHoveredButton(childId++, "Presets/BUTTON", 2, 81, 28, childId++);
		
		addHoverButton(childId++, "Presets/BUTTON", 2, 81, 28, "Save", -1, childId, 1);
		addHoveredButton(childId++, "Presets/BUTTON", 2, 81, 28, childId++);
		
		addText(childId++, "Load", tda, 2, 0xFF9300, true, true);
		addText(childId++, "Save", tda, 2, 0xFF9300, true, true);
		
		addText(childId++, Configuration.CLIENT_TITLE + " Presets", tda, 2, 0xFF9300, true, true);
		
		addHoverButton(childId++, "/Interfaces/Exp Lock/SPRITE", 1, 16, 16, "Close", -1, childId, 1);
		addHoveredButton(childId++, "/Interfaces/Exp Lock/SPRITE", 2, 16, 16, childId++);
		
		addToItemGroup(childId++, 4, 7, 6, 6, true, "Remove", null, null);
		
		/*
		 * Note: Using a modified childId to avoid overridden child members
		 */
		int overlayModificationChildId = 569;
		int overlayModificationConfig = 61;
		for(int i = 0; i < 11; i++) {
			addConfigButton(overlayModificationChildId++, 21553, 1, 0, "Presets/OVERLAY", 36, 36, new String[] {}, 1, overlayModificationConfig + i);
		}
		
		for(int i = 0; i < 11; i++) {
			addToItemGroup(childId++, 1, 1, 0, 0, true, "Remove", null, null);
		}
		
		RSInterface scroll = addInterface(childId++);
		int scrollChildId = childId;
		int scrollFrame = 0;
		scroll.width = 100;
		scroll.height = 140;
		scroll.scrollMax = 220;
		scroll.totalChildren(30);
		int scrollX = 0;
		int scrollY = 0;
		
		for(int i = 0; i < 10; i++) {
			addConfigButton(scrollChildId, 21553, 0, 1, "Presets/BUTTON", 118, 22, new String[] { "Delete Preset", "Select Preset" }, 1, 903 + i);
			scroll.child(scrollFrame++, scrollChildId++, scrollX, scrollY);
			
			addText(scrollChildId, "Preset Name " + i, tda, 1, 0xFF9300, false, true);
			scroll.child(scrollFrame++, scrollChildId++, scrollX + 1, scrollY + 3);
			
			scrollY += 22;
		}
		
		childId = scrollChildId;
		addHoverButton(childId++, "Presets/EDIT", 0, 14, 12, "Edit Preset Name", -1, childId, 1);
		addHoveredButton(childId++, "Presets/EDIT", 0, 14, 12, childId++);
		
		int additionChildId = 251;
		addHoverButton(additionChildId++, "Presets/BUTTON", 3, 35, 35, "Switch Spellbook", -1, additionChildId, 1);
		addHoveredButton(additionChildId++, "Presets/BUTTON", 3, 35, 35, additionChildId++);
		addSprites(additionChildId++, "Presets/BOOK", new int[]{0, 1, 2});
		
		widget.totalChildren(childId - 21554 + 4 + (11) + (3));
		
		overlayModificationChildId = 569;
		childId = 21554;
		int frame = 0;
		
		widget.child(frame++, childId++, 11, 11);
		
		int startX = 19;
		int startY = 61;
		for(int i = 0; i < 4; i++) {
			widget.child(frame++, childId++, startX, startY);
			
			widget.child(frame++, childId++, startX + 1, startY + 3);
			
			startY += 22;
		}
		
		widget.child(frame++, childId++, 75, 45);
		widget.child(frame++, childId++, 75, 151);
		widget.child(frame++, childId++, 228, 45);
		
		widget.child(frame++, childId++, 143, 278);
		widget.child(frame++, childId++, 143, 278);
		childId++;
		
		widget.child(frame++, childId++, 230, 278);
		widget.child(frame++, childId++, 230, 278);
		childId++;
		
		widget.child(frame++, childId++, 182, 284);
		widget.child(frame++, childId++, 270, 284);
		widget.child(frame++, childId++, 247, 21);
		
		widget.child(frame++, childId++, 474, 20);
		widget.child(frame++, childId++, 474, 20);
		childId++;
		
		widget.child(frame++, childId++, 326, 48);
		
		//Equipment Overlays
		widget.child(frame++, overlayModificationChildId++, 211, 68);
		widget.child(frame++, overlayModificationChildId++, 170, 107);
		widget.child(frame++, overlayModificationChildId++, 211, 107);
		widget.child(frame++, overlayModificationChildId++, 252, 107);
		widget.child(frame++, overlayModificationChildId++, 211, 146);
		widget.child(frame++, overlayModificationChildId++, 155, 146);
		widget.child(frame++, overlayModificationChildId++, 267, 146);
		widget.child(frame++, overlayModificationChildId++, 211, 186);
		widget.child(frame++, overlayModificationChildId++, 211, 226);
		widget.child(frame++, overlayModificationChildId++, 155, 226);
		widget.child(frame++, overlayModificationChildId++, 267, 226);
				
		//Equipment
		widget.child(frame++, childId++, 214, 70);
		widget.child(frame++, childId++, 172, 109);
		widget.child(frame++, childId++, 214, 109);
		widget.child(frame++, childId++, 255, 109);
		widget.child(frame++, childId++, 214, 148);
		widget.child(frame++, childId++, 158, 148);
		widget.child(frame++, childId++, 270, 148);
		widget.child(frame++, childId++, 214, 188);
		widget.child(frame++, childId++, 214, 228);
		widget.child(frame++, childId++, 158, 228);
		widget.child(frame++, childId++, 270, 228);
		
		widget.child(frame++, childId++, 19, 168);
		
		childId = scrollChildId;
		
		widget.child(frame++, childId++, 301, 46);
		widget.child(frame++, childId++, 301, 46);
		
		additionChildId = 251;
		//button
		widget.child(frame++, additionChildId++, 276, 64);
		widget.child(frame++, additionChildId++, 276, 64);
		additionChildId++;
		//icon
		widget.child(frame++, additionChildId++, 281, 70);
	}
	
	public static void equipmentScreen(TextDrawingArea[] wid) {
		RSInterface Interface = RSInterface.interfaceCache[1644];
		addButton(19144, 140, "Show Equipment Stats");
		removeSomething(19145);
		removeSomething(19146);
		removeSomething(19147);
		setBounds(19145, 40, 210, 24, Interface);
		setBounds(19146, 40, 210, 25, Interface);
		setBounds(19147, 40, 210, 26, Interface);
		RSInterface tab = addTabInterface(15106);
		addSprite3(15107, 116);

		addHoverButton_sprite_loader(15210, 142, 21, 21, "Close", 250, 15211, 3);
		addHoveredButton_sprite_loader(15211, 143, 21, 21, 15212);

		addText(15111, "Equip Your Character...", wid, 2, 0xFF9300, false, true);
		addText(15112, "Attack bonus", wid, 2, 0xFF9300, false, true);
		addText(15113, "Defence bonus", wid, 2, 0xFF9300, false, true);
		addText(15114, "Other bonuses", wid, 2, 0xFF9300, false, true);

		addText(21451, "Ranged Strength:", wid, 1, 0xFF9300, false, true);
		addText(21452, "Magic Damage:", wid, 1, 0xFF9300, false, true);
		addText(1686, "Melee Strength:", wid, 1, 0xFF9300, false, true);

		addText(16117, "0kg", wid, 1, 0xFF9300, false, true);

		for (int i = 1675; i <= 1684; i++) {
			textSize(i, wid, 1);
		}
		textSize(1686, wid, 1);
		textSize(1687, wid, 1);
		addChar(15125);
		tab.totalChildren(47);
		tab.child2(0, 15107, 5, 5);
		tab.child2(1, 15210, 477, 12);
		tab.child2(2, 15211, 477, 12);
		tab.child2(3, 15111, 15, 15);
		int Child = 4;
		int Y = 69;
		int xOff = 332;
		int xOff2 = 323;
		int yOff = 7;
		int yOff2 = 8;
		for (int i = 1675; i <= 1679; i++) {
			tab.child2(Child, i, 20 + xOff, Y - yOff2);
			Child++;
			Y += 14;
		}

		tab.child2(9, 1680, 20 + xOff, 161 - yOff2);
		tab.child2(10, 1681, 20 + xOff, 177 - yOff2);
		tab.child2(11, 1682, 20 + xOff, 192 - yOff2);
		tab.child2(12, 1683, 20 + xOff, 207 - yOff2);
		tab.child2(13, 1684, 20 + xOff, 221 - yOff2);
		tab.child2(14, 1686, 20 + xOff, 262 - yOff2);
		tab.child2(15, 15125, 192, 210);
		tab.child2(16, 15112, 16 + xOff, 55 - yOff2);
		tab.child2(18, 15113, 16 + xOff, 147 - yOff2);
		tab.child2(19, 15114, 16 + xOff, 248 - yOff2);
		tab.child2(20, 1645, 104 + 295 - xOff2, 149 - 52 + yOff);
		tab.child2(21, 1646, 399 - xOff2, 163 + yOff);
		tab.child2(22, 1647, 399 - xOff2, 163 + yOff);
		tab.child2(23, 1648, 399 - xOff2, 58 + 146 + yOff);
		tab.child2(24, 1649, 26 + 22 + 297 - xOff2 - 2, 110 - 44 + 118 - 13 + 5 + yOff);
		tab.child2(25, 1650, 321 - xOff2 + 22, 58 + 154 + yOff);
		tab.child2(26, 1651, 321 - xOff2 + 134, 58 + 118 + yOff);
		tab.child2(27, 1652, 321 - xOff2 + 134, 58 + 154 + yOff);
		tab.child2(28, 1653, 321 - xOff2 + 48, 58 + 81 + yOff);
		tab.child2(29, 1654, 321 - xOff2 + 107, 58 + 81 + yOff);
		tab.child2(30, 1655, 321 - xOff2 + 58, 58 + 42 + yOff);
		tab.child2(31, 1656, 321 - xOff2 + 112, 58 + 41 + yOff);
		tab.child2(32, 1657, 321 - xOff2 + 78, 58 + 4 + yOff);
		tab.child2(33, 1658, 321 - xOff2 + 37, 58 + 43 + yOff);
		tab.child2(34, 1659, 321 - xOff2 + 78, 58 + 43 + yOff);
		tab.child2(35, 1660, 321 - xOff2 + 119, 58 + 43 + yOff);
		tab.child2(36, 1661, 321 - xOff2 + 22, 58 + 82 + yOff);
		tab.child2(37, 1662, 321 - xOff2 + 78, 58 + 82 + yOff);
		tab.child2(38, 1663, 321 - xOff2 + 134, 58 + 82 + yOff);
		tab.child2(39, 1664, 321 - xOff2 + 78, 58 + 122 + yOff);
		tab.child2(40, 1665, 321 - xOff2 + 78, 58 + 162 + yOff);
		tab.child2(41, 1666, 321 - xOff2 + 22, 58 + 162 + yOff);
		tab.child2(42, 1667, 321 - xOff2 + 134, 58 + 162 + yOff);
		tab.child2(43, 1688, 50 + 297 - xOff2 - 2, 110 - 13 + 5 + yOff);

		// Maxhits

		tab.child2(44, 16117, 87, 283);

		for (int i = 1675; i <= 1684; i++) {
			RSInterface rsi = interfaceCache[i];
			rsi.textColor = 0xFF9300;
			rsi.centerText = false;
		}
		for (int i = 1686; i <= 1687; i++) {
			RSInterface rsi = interfaceCache[i];
			rsi.textColor = 0xFF9300;
			rsi.centerText = false;
		}

		tab.child2(44, 21451, 352, 270);
		tab.child2(45, 21452, 352, 286);
		tab.child2(17, 1687, 352, 302);
	}

	public static void expLock(TextDrawingArea[] tda) {
		RSInterface tab = addInterface(37500);
		String dir = "/Interfaces/Exp Lock/SPRITE";
		String dir2 = "/Interfaces/Prestige/PlayerStats/skills/IMG";
		addSprite(37501, 0, dir);
		addHoverButton(37502, dir, 1, 16, 16, "Close", -1, 37503, 1);
		addHoveredButton(37503, dir, 2, 16, 16, 37504);
		addText(37505, "Exp Lock Manager", tda, 2, 0xFFA500, true, true);
		int x = 150, y = 10;
		tab.totalChildren(5);
		tab.child(0, 37501, x, y);
		tab.child(1, 37502, 180 + x, 4 + y);
		tab.child(2, 37503, 180 + x, 4 + y);
		tab.child(3, 37505, 100 + x, 5 + y);
		tab.child(4, 37510, 10 + x, 30 + y);

		final String[] skillNames = { "Attack", "Defence", "Strength", "Hitpoints", "Ranged", "Prayer", "Magic" };

		RSInterface over = addInterface(37510);
		addSprite(37527, 5, dir);
		int xx = 0, yy = 0;
		over.totalChildren(42);
		for (int i = 0; i < 7; i++) {
			addButton(37511 + i, 3, dir, "Toggle @lre@" + skillNames[i]);
			addSprite(37519 + i, i, dir2);
			addText(37528 + i, Client.capitalize(skillNames[i]) + ":", tda, 0, 16748608, false, true);
			addText(37536 + i, "@gre@Unlocked", tda, 0, 16777215, false, true);
			addText(37544 + i, "@gre@99", tda, 0, 16777215, false, true);
			int[] g = centerSkillSprite(interfaceCache[37519 + i].sprite1);
			over.child(i, 37511 + i, xx, yy);
			over.child(i + 7, 37519 + i, xx + g[0], yy + g[1]);
			over.child(i + 14, 37527, xx + 32, yy + 7);
			over.child(i + 21, 37528 + i, xx + 35, yy + 10);
			over.child(i + 28, 37536 + i, xx + 125, yy + 10);
			over.child(i + 35, 37544 + i, xx + 90, yy + 10);
			xx += 117;
			if (xx == 117) {
				xx = 0;
				yy += 39;
			}
		}
	}

	public static void prestigeInterface(TextDrawingArea[] tda) {
		RSInterface tab = addInterface(37300);
		String dir = "/Interfaces/Prestige/SPRITE";
		String dir2 = "/Interfaces/Prestige/PlayerStats/skills/IMG";
		addSprite(37301, 0, dir);
		addHoverButton(37302, dir, 1, 16, 16, "Close", -1, 37303, 1);
		addHoveredButton(37303, dir, 2, 16, 16, 37304);
		get(37302).atActionType = 3;
		get(37303).atActionType = 3;

		addText(37305, "Prestige Manager", tda, 2, 0xFFA500, true, true);
		addSprite(37306, 6, dir);
		addText(37307, "Attack:", tda, 2, 0xFFA500, true, true);
		addText(37308, "Current Prestige: @whi@0", tda, 0, 16748608, false, true);
		addText(37309, "Reward: @whi@1000 Points", tda, 0, 16748608, false, true);
		addText(37390, "Can Prestige: @whi@...", tda, 0, 16748608, false, true);
		addHoverButton(37391, dir, 7, 80, 31, "Prestige selected skill", 0, 37392, 1);
		addHoveredButton(37392, dir, 8, 80, 31, 37393);
		addText(37394, "Prestige", tda, 2, 16777215, true, true);
		int x = 10, y = 10;
		tab.totalChildren(13);
		tab.child(0, 37301, x, y);
		tab.child(1, 37302, 463 + x, 4 + y);
		tab.child(2, 37303, 463 + x, 4 + y);
		tab.child(3, 37305, 243 + x, 5 + y);
		tab.child(4, 37310, 10 + x, 30 + y);
		tab.child(5, 37306, 258 + x, 222 + y);
		tab.child(6, 37307, 366 + x, 226 + y);
		tab.child(7, 37308, 263 + x, 242 + y);
		tab.child(8, 37309, 263 + x, 257 + y);
		tab.child(9, 37390, 263 + x, 273 + y);
		tab.child(10, 37391, 389 + x, 255 + y);
		tab.child(11, 37392, 389 + x, 255 + y);
		tab.child(12, 37394, 429 + x, 262 + y);

		final String[] skillNames = { "attack", "defence", "strength", "hitpoints", "ranged", "prayer", "magic",
				"cooking", "woodcutting", "fletching", "fishing", "firemaking", "crafting", "smithing", "mining",
				"herblore", "agility", "thieving", "slayer", "farming", "runecraft", "hunter", "-unused-", "-unused-",
				"-unused-" };

		RSInterface over = addInterface(37310);
		addSprite(37359, 5, dir);
		int xx = 0, yy = 0, line = 0;
		over.totalChildren(110);
		for (int i = 0; i < 22; i++) {
			addButton(37311 + i, 3, dir, "Select @lre@" + skillNames[i]);
			addSprite(37335 + i, i, dir2);
			addText(37360 + i, Client.capitalize(skillNames[i]), tda, 0, 16748608, false, true);
			addText(37400 + i, "0", tda, 0, 16777215, false, true);
			int[] g = centerSkillSprite(interfaceCache[37335 + i].sprite1);
			int bonusY = 0;
			if (xx == 0 || xx == 117)
				bonusY = 5 * line;
			over.child(i, 37311 + i, xx, yy + bonusY);
			over.child(i + 22, 37335 + i, xx + g[0], yy + g[1] + bonusY);
			over.child(i + 44, 37359, xx + 32, yy + 7 + bonusY);
			over.child(i + 66, 37360 + i, xx + 35, yy + 10 + bonusY);
			over.child(i + 88, 37400 + i, xx + 102, yy + 10 + bonusY);
			xx += 117;
			if (xx == 468) {
				xx = 0;
				yy += 39;
				line++;
			}
		}
	}

	public static int[] centerSkillSprite(Sprite s) {
		int x = 15, y = 15;
		x -= (s.myWidth / 2);
		y -= (s.myHeight / 2);
		return new int[] { x, y };
	}

	public static void slayerOverlay(TextDrawingArea[] tda) {
		RSInterface rsInterface = addInterface(35424);
		addText(35425, "Abyssal Demon: 5", tda, 1, 0xF7FE2E, true, true);
		setChildren(1, rsInterface);
		rsInterface.child(0, 35425,
				!Client.instance.isResized() ? 250 : (Client.canvasWidth - 300), 10); // Assignment
	}

	private static void skotizo(TextDrawingArea[] tda) {
		RSInterface tab = addInterface(29230);
		tab.totalChildren(5);
		addSprite(29231, 0, "Interfaces/Skotizo/SKOTIZOM");
		tab.child(0, 29231, 36, 141);
		addSprites(29232, "Interfaces/Skotizo/SKOTIZO", 3, 0);
		tab.child(1, 29232, 56, 128);
		addSprites(29233, "Interfaces/Skotizo/SKOTIZO", 3, 0);
		tab.child(2, 29233, 56, 193);
		addSprites(29234, "Interfaces/Skotizo/SKOTIZO", 3, 0);
		tab.child(3, 29234, 23, 160);
		addSprites(29235, "Interfaces/Skotizo/SKOTIZO", 3, 0);
		tab.child(4, 29235, 88, 160);
	}

	public static void tradingSelect(TextDrawingArea[] tda) {
		RSInterface Interface = addTabInterface(48599);
		RSInterface history = addTabInterface(48635);
		RSInterface offers = addTabInterface(48950);

		addSprite(48601, 7, "Trading/SPRITE");
		addHover(48602, 3, 0, 48603, 1, "Bank/BANK", 17, 17, "Close Window");
		addHovered(48603, 2, "Bank/BANK", 17, 17, 48604);

		addText(48605, "Trading Post", 0xff9933, true, true, -1, tda, 2);

		addText(48606, "Coffer", 0xff9933, true, true, -1, tda, 2);
		addHoverButton(48607, "Trading/SPRITE", 8, 143, 35, "Claim money", 0, 48608, 1);
		addHoveredButton(48608, "Trading/SPRITE", 9, 143, 35, 48609);
		addText(48610, "", 0xff9933, true, true, -1, tda, 0);

		addText(48611, "Search for...", 0xff9933, true, true, -1, tda, 2);
		addHoverButton(48612, "Trading/SPRITE", 10, 72, 32, "Search for a item", 0, 48613, 1);
		addHoveredButton(48613, "Trading/SPRITE", 11, 72, 32, 48614);

		addHoverButton(48615, "Trading/SPRITE", 10, 72, 32, "Search for a player", 0, 48616, 1);
		addHoveredButton(48616, "Trading/SPRITE", 11, 72, 32, 48617);

		addHoverButton(48618, "Trading/SPRITE", 10, 72, 32, "Recent offers", 0, 48619, 1);
		addHoveredButton(48619, "Trading/SPRITE", 11, 72, 32, 48620);

		addHoverButton(48621, "Trading/SPRITE", 12, 150, 35, "Click", 0, 48622, 1);
		addHoveredButton(48622, "Trading/SPRITE", 13, 150, 35, 48623);

		addText(48624, "History", 0xff9933, true, true, -1, tda, 2);
		addText(48625, "My Offers...", 0xff9933, true, true, -1, tda, 2);

		addText(48626, "Item", 0xff9933, true, true, -1, tda, 2);
		addText(48627, "Player", 0xff9933, true, true, -1, tda, 2);
		addText(48628, "Recent", 0xff9933, true, true, -1, tda, 2);
		addText(48629, "Cancel Listing", 0xff9933, true, true, -1, tda, 2);

		setChildren(25, Interface);

		setBounds(48601, 8, 10, 0, Interface); // Base
		setBounds(48602, 471, 18, 1, Interface); // Close
		setBounds(48603, 471, 18, 2, Interface);

		setBounds(48605, 262, 20, 3, Interface); // Title

		setBounds(48606, 40, 50, 4, Interface); // Coffer text
		setBounds(48607, 19, 68, 5, Interface); // Coffer Button
		setBounds(48608, 19, 68, 6, Interface);
		setBounds(48610, 75, 80, 7, Interface); // Amount in coffer

		setBounds(48611, 59, 250, 8, Interface); // Text search for...
		setBounds(48612, 19, 270, 9, Interface); // Item Button
		setBounds(48613, 19, 270, 10, Interface);

		setBounds(48615, 96, 270, 11, Interface); // Player Button
		setBounds(48616, 96, 270, 12, Interface);

		setBounds(48618, 173, 270, 13, Interface); // Recent Button
		setBounds(48619, 173, 270, 14, Interface);

		setBounds(48621, 293, 270, 15, Interface); // Long button
		setBounds(48622, 293, 270, 16, Interface);

		setBounds(48624, 42, 104, 17, Interface); // Text History
		setBounds(48625, 289, 50, 18, Interface); // TextMy offers

		setBounds(48626, 55, 279, 19, Interface); // Text Item
		setBounds(48627, 132, 279, 20, Interface); // Text Player
		setBounds(48628, 208, 279, 21, Interface); // Text Recent
		setBounds(48629, 367, 279, 22, Interface); // Text List

		setBounds(48635, 30, 128, 23, Interface); // Interface history
		setBounds(48950, 260, 75, 24, Interface); // Interface my offers

		setChildren(20, history);
		for (int i = 48636, y = 5, id = 0; i < 48656; i++) {
			addText(i, "", 0xff9933, true, true, -1, tda, 0);
			setBounds(i, 94, y, id, history);
			if (id == 1 || id == 3 || id == 5 || id == 7 || id == 9 || id == 11 || id == 13 || id == 15 || id == 17)
				y += 20;
			else
				y += 10;
			id++;
		}

		history.scrollMax = 300;
		history.width = 193;
		history.height = 116;

		addText(48951, "Select an item", 0xff9933, true, true, -1, tda, 2);
		addText(48952, "from your", 0xff9933, true, true, -1, tda, 2);
		addText(48953, "inventory.", 0xff9933, true, true, -1, tda, 2);

		setChildren(3, offers);

		setBounds(48951, 108, 66, 0, offers); // Name
		setBounds(48952, 108, 80, 1, offers); // Price
		setBounds(48953, 108, 94, 2, offers); // sold

		// offers.scrollMax = 300;
		offers.width = 203;
		offers.height = 181;
	}

	public static void tradingpost(TextDrawingArea[] tda) {
		RSInterface Interface = addTabInterface(48600);
		RSInterface history = addTabInterface(48635);
		RSInterface offers = addTabInterface(48786);

		addSprite(48601, 7, "Trading/SPRITE");
		addHover(48602, 3, 0, 48603, 1, "Bank/BANK", 17, 17, "Close Window");
		addHovered(48603, 2, "Bank/BANK", 17, 17, 48604);

		addText(48605, "Trading Post", 0xff9933, true, true, -1, tda, 2);

		addText(48606, "Coffer", 0xff9933, true, true, -1, tda, 2);
		addHoverButton(48607, "Trading/SPRITE", 8, 143, 35, "Claim money", 0, 48608, 1);
		addHoveredButton(48608, "Trading/SPRITE", 9, 143, 35, 48609);
		addText(48610, "Empty", 0xff9933, true, true, -1, tda, 0);

		addText(48611, "Search for...", 0xff9933, true, true, -1, tda, 2);
		addHoverButton(48612, "Trading/SPRITE", 10, 72, 32, "Search for a item", 0, 48613, 1);
		addHoveredButton(48613, "Trading/SPRITE", 11, 72, 32, 48614);

		addHoverButton(48615, "Trading/SPRITE", 10, 72, 32, "Search for a player", 0, 48616, 1);
		addHoveredButton(48616, "Trading/SPRITE", 11, 72, 32, 48617);

		addHoverButton(48618, "Trading/SPRITE", 10, 72, 32, "Recent offers", 0, 48619, 1);
		addHoveredButton(48619, "Trading/SPRITE", 11, 72, 32, 48620);

		addHoverButton(48621, "Trading/SPRITE", 12, 150, 35, "Click", 0, 48622, 1);
		addHoveredButton(48622, "Trading/SPRITE", 13, 150, 35, 48623);

		addText(48624, "History", 0xff9933, true, true, -1, tda, 2);
		addText(48625, "My Offers...", 0xff9933, true, true, -1, tda, 2);

		addText(48626, "Item", 0xff9933, true, true, -1, tda, 2);
		addText(48627, "Player", 0xff9933, true, true, -1, tda, 2);
		addText(48648, "Recent", 0xff9933, true, true, -1, tda, 2);
		addText(48630, "List item for sale", 0xff9933, true, true, -1, tda, 2);

		setChildren(25, Interface);

		setBounds(48601, 8, 10, 0, Interface); // Base
		setBounds(48602, 471, 18, 1, Interface); // Close
		setBounds(48603, 471, 18, 2, Interface);

		setBounds(48605, 262, 20, 3, Interface); // Title

		setBounds(48606, 40, 50, 4, Interface); // Coffer text
		setBounds(48607, 19, 68, 5, Interface); // Coffer Button
		setBounds(48608, 19, 68, 6, Interface);
		setBounds(48610, 75, 80, 7, Interface); // Amount in coffer

		setBounds(48611, 59, 250, 8, Interface); // Text search for...
		setBounds(48612, 19, 270, 9, Interface); // Item Button
		setBounds(48613, 19, 270, 10, Interface);

		setBounds(48615, 96, 270, 11, Interface); // Player Button
		setBounds(48616, 96, 270, 12, Interface);

		setBounds(48618, 173, 270, 13, Interface); // Recent Button
		setBounds(48619, 173, 270, 14, Interface);

		setBounds(48621, 293, 270, 15, Interface); // Long button
		setBounds(48622, 293, 270, 16, Interface);

		setBounds(48624, 42, 104, 17, Interface); // Text History
		setBounds(48625, 289, 50, 18, Interface); // TextMy offers

		setBounds(48626, 55, 279, 19, Interface); // Text Item
		setBounds(48627, 132, 279, 20, Interface); // Text Player
		setBounds(48628, 208, 279, 21, Interface); // Text Recent
		setBounds(48630, 367, 279, 22, Interface); // Text List

		setBounds(48635, 30, 128, 23, Interface); // Interface history
		setBounds(48786, 260, 75, 24, Interface); // Interface my offers

		setChildren(40, history);
		for (int i = 48636, y = 5, id = 0; i < 48676; i++) {
			addText(i, "", 0xff9933, true, true, -1, tda, 0);
			setBounds(i, 94, y, id, history);
			if (id == 1 || id == 3 || id == 5 || id == 7 || id == 9 || id == 11 || id == 13 || id == 15 || id == 17 || id == 19 || id == 21 || id == 23 || id == 25 || id == 27 || id == 29 || id == 31 || id == 33 || id == 35 || id == 37 || id == 39)
				y += 20;
			else
				y += 10;
			id++;
		}

		history.scrollMax = 5000;
		history.width = 193;
		history.height = 116;

		addListing(48847, false);
		addText(48788, "", 0xff9933, true, true, -1, tda, 0);
		addText(48789, "", 0xff9933, true, true, -1, tda, 0);
		addText(48790, "", 0xff9933, true, true, -1, tda, 0);

		addText(48792, "", 0xff9933, true, true, -1, tda, 0);
		addText(48793, "", 0xff9933, true, true, -1, tda, 0);
		addText(48794, "", 0xff9933, true, true, -1, tda, 0);

		addText(48796, "", 0xff9933, true, true, -1, tda, 0);
		addText(48797, "", 0xff9933, true, true, -1, tda, 0);
		addText(48798, "", 0xff9933, true, true, -1, tda, 0);

		addText(48800, "", 0xff9933, true, true, -1, tda, 0);
		addText(48801, "", 0xff9933, true, true, -1, tda, 0);
		addText(48802, "", 0xff9933, true, true, -1, tda, 0);

		addText(48804, "", 0xff9933, true, true, -1, tda, 0);
		addText(48805, "", 0xff9933, true, true, -1, tda, 0);
		addText(48806, "", 0xff9933, true, true, -1, tda, 0);

		addText(48808, "", 0xff9933, true, true, -1, tda, 0);
		addText(48809, "", 0xff9933, true, true, -1, tda, 0);
		addText(48810, "", 0xff9933, true, true, -1, tda, 0);

		addText(48812, "", 0xff9933, true, true, -1, tda, 0);
		addText(48813, "", 0xff9933, true, true, -1, tda, 0);
		addText(48814, "", 0xff9933, true, true, -1, tda, 0);

		addText(48816, "", 0xff9933, true, true, -1, tda, 0);
		addText(48817, "", 0xff9933, true, true, -1, tda, 0);
		addText(48818, "", 0xff9933, true, true, -1, tda, 0);

		addText(48820, "", 0xff9933, true, true, -1, tda, 0);
		addText(48821, "", 0xff9933, true, true, -1, tda, 0);
		addText(48822, "", 0xff9933, true, true, -1, tda, 0);

		addText(48824, "", 0xff9933, true, true, -1, tda, 0);
		addText(48825, "", 0xff9933, true, true, -1, tda, 0);
		addText(48826, "", 0xff9933, true, true, -1, tda, 0);

		addText(48828, "", 0xff9933, true, true, -1, tda, 0);
		addText(48829, "", 0xff9933, true, true, -1, tda, 0);
		addText(48830, "", 0xff9933, true, true, -1, tda, 0);

		addText(48832, "", 0xff9933, true, true, -1, tda, 0);
		addText(48833, "", 0xff9933, true, true, -1, tda, 0);
		addText(48834, "", 0xff9933, true, true, -1, tda, 0);

		addText(48836, "", 0xff9933, true, true, -1, tda, 0);
		addText(48837, "", 0xff9933, true, true, -1, tda, 0);
		addText(48838, "", 0xff9933, true, true, -1, tda, 0);

		addText(48840, "", 0xff9933, true, true, -1, tda, 0);
		addText(48841, "", 0xff9933, true, true, -1, tda, 0);
		addText(48842, "", 0xff9933, true, true, -1, tda, 0);

		addText(48844, "", 0xff9933, true, true, -1, tda, 0);
		addText(48845, "", 0xff9933, true, true, -1, tda, 0);
		addText(48846, "", 0xff9933, true, true, -1, tda, 0);

		setChildren(46, offers);

		setBounds(48788, 118, 10, 0, offers); // Name
		setBounds(48789, 51, 33, 1, offers); // Price
		setBounds(48790, 118, 23, 2, offers); // sold

		setBounds(48792, 118, 57, 3, offers); // Name y + 49
		setBounds(48793, 51, 80, 4, offers); // Price y + 48
		setBounds(48794, 118, 70, 5, offers); // sold y + 49

		setBounds(48796, 118, 104, 6, offers); // Name y + 49
		setBounds(48797, 51, 127, 7, offers); // Price y + 28
		setBounds(48798, 118, 117, 8, offers); // sold y + 49

		setBounds(48800, 118, 151, 9, offers); // Name y + 49
		setBounds(48801, 51, 174, 10, offers); // Price y + 28
		setBounds(48802, 118, 164, 11, offers); // sold y + 49

		setBounds(48804, 118, 198, 12, offers); // Name y + 49
		setBounds(48805, 51, 221, 13, offers); // Price y + 28
		setBounds(48806, 118, 211, 14, offers); // sold y + 49

		setBounds(48808, 118, 245, 15, offers); // Name y + 49
		setBounds(48809, 51, 268, 16, offers); // Price y + 48
		setBounds(48810, 118, 258, 17, offers); // sold y + 49

		setBounds(48812, 118, 292, 18, offers); // Name y + 49
		setBounds(48813, 51, 315, 19, offers); // Price y + 48
		setBounds(48814, 118, 305, 20, offers); // sold y + 49

		setBounds(48816, 118, 339, 21, offers); // Name y + 49
		setBounds(48817, 51, 362, 22, offers); // Price y + 48
		setBounds(48818, 118, 352, 23, offers); // sold y + 49

		setBounds(48820, 118, 386, 24, offers); // Name y + 49
		setBounds(48821, 51, 409, 25, offers); // Price y + 48
		setBounds(48822, 118, 399, 26, offers); // sold y + 49

		setBounds(48824, 118, 433, 27, offers); // Name y + 47
		setBounds(48825, 51, 456, 28, offers); // Price y + 47 fout
		setBounds(48826, 118, 446, 29, offers); // sold y + 47

		setBounds(48828, 118, 480, 30, offers); // Name y + 49
		setBounds(48829, 51, 503, 31, offers); // Price y + 48
		setBounds(48830, 118, 493, 32, offers); // sold y + 49

		setBounds(48832, 118, 527, 33, offers); // Name y + 49
		setBounds(48833, 51, 550, 34, offers); // Price y + 48
		setBounds(48834, 118, 540, 35, offers); // sold y + 49

		setBounds(48836, 118, 574, 36, offers); // Name y + 49
		setBounds(48837, 51, 597, 37, offers); // Price y + 48
		setBounds(48838, 118, 587, 38, offers); // sold y + 49

		setBounds(48840, 118, 621, 39, offers); // Name y + 49
		setBounds(48841, 51, 644, 40, offers); // Price y + 48
		setBounds(48842, 118, 634, 41, offers); // sold y + 49

		setBounds(48844, 118, 668, 42, offers); // Name y + 49
		setBounds(48845, 51, 691, 43, offers); // Price y + 48
		setBounds(48846, 118, 681, 44, offers); // sold y + 49

		setBounds(48847, 35, 2, 45, offers);

		offers.scrollMax = 710;
		offers.width = 203;
		offers.height = 181;
	}

	public static void offer(TextDrawingArea[] tda) {

		RSInterface rsi = addTabInterface(48500);
		addOffer(48501);
		rsi.totalChildren(1);
		rsi.child(0, 48501, 16, 8);
	}

	public static void addOffer(int index) {
		RSInterface rsi = interfaceCache[index] = new RSInterface();
		rsi.actions = new String[10];
		rsi.spritesX = new int[20];
		rsi.inventoryAmounts = new int[30];
		rsi.inventoryItemId = new int[30];
		rsi.spritesY = new int[20];

		rsi.children = new int[0];
		rsi.childX = new int[0];
		rsi.childY = new int[0];

		rsi.actions[0] = "Offer 1";
		rsi.actions[1] = "Offer 5";
		rsi.actions[2] = "Offer 10";
		rsi.actions[3] = "Offer All";
		rsi.actions[4] = "Offer X";
		rsi.centerText = true;
		rsi.aBoolean227 = false;
		rsi.aBoolean235 = false;
		rsi.usableItemInterface = false;
		rsi.isInventoryInterface = false;
		rsi.aBoolean259 = true;
		rsi.textShadow = false;
		rsi.invSpritePadX = 10;
		rsi.invSpritePadY = 4;
		rsi.height = 7;
		rsi.width = 4;
		rsi.parentID = 48501;
		rsi.id = 48500;
		rsi.type = 2;
	}

	public static void tradingSelected(TextDrawingArea[] tda) {
		RSInterface Interface = addTabInterface(48598);
		RSInterface history = addTabInterface(48635);
		RSInterface offers = addTabInterface(48960);

		addSprite(48601, 7, "Trading/SPRITE");
		addHover(48602, 3, 0, 48603, 1, "Bank/BANK", 17, 17, "Close Window");
		addHovered(48603, 2, "Bank/BANK", 17, 17, 48604);

		addText(48605, "Trading Post", 0xff9933, true, true, -1, tda, 2);

		addText(48606, "Coffer", 0xff9933, true, true, -1, tda, 2);
		addHoverButton(48607, "Trading/SPRITE", 8, 143, 35, "Claim money", 0, 48608, 1);
		addHoveredButton(48608, "Trading/SPRITE", 9, 143, 35, 48609);
		addText(48610, "Empty", 0xff9933, true, true, -1, tda, 0);

		addText(48611, "Search for...", 0xff9933, true, true, -1, tda, 2);
		addHoverButton(48612, "Trading/SPRITE", 10, 72, 32, "Search for a item", 0, 48613, 1);
		addHoveredButton(48613, "Trading/SPRITE", 11, 72, 32, 48614);

		addHoverButton(48615, "Trading/SPRITE", 10, 72, 32, "Search for a player", 0, 48616, 1);
		addHoveredButton(48616, "Trading/SPRITE", 11, 72, 32, 48617);

		addHoverButton(48618, "Trading/SPRITE", 10, 72, 32, "Recent offers", 0, 48619, 1);
		addHoveredButton(48619, "Trading/SPRITE", 11, 72, 32, 48620);

		addHoverButton(48621, "Trading/SPRITE", 12, 150, 35, "Click", 0, 48622, 1);
		addHoveredButton(48622, "Trading/SPRITE", 13, 150, 35, 48623);

		addText(48624, "History", 0xff9933, true, true, -1, tda, 2);
		addText(48625, "My Offers...", 0xff9933, true, true, -1, tda, 2);

		addText(48626, "Item", 0xff9933, true, true, -1, tda, 2);
		addText(48627, "Player", 0xff9933, true, true, -1, tda, 2);
		addText(48628, "Recent", 0xff9933, true, true, -1, tda, 2);
		addText(48629, "Cancel Listing", 0xff9933, true, true, -1, tda, 2);

		setChildren(25, Interface);

		setBounds(48601, 8, 10, 0, Interface); // Base
		setBounds(48602, 471, 18, 1, Interface); // Close
		setBounds(48603, 471, 18, 2, Interface);

		setBounds(48605, 262, 20, 3, Interface); // Title

		setBounds(48606, 40, 50, 4, Interface); // Coffer text
		setBounds(48607, 19, 68, 5, Interface); // Coffer Button
		setBounds(48608, 19, 68, 6, Interface);
		setBounds(48610, 75, 80, 7, Interface); // Amount in coffer

		setBounds(48611, 59, 250, 8, Interface); // Text search for...
		setBounds(48612, 19, 270, 9, Interface); // Item Button
		setBounds(48613, 19, 270, 10, Interface);

		setBounds(48615, 96, 270, 11, Interface); // Player Button
		setBounds(48616, 96, 270, 12, Interface);

		setBounds(48618, 173, 270, 13, Interface); // Recent Button
		setBounds(48619, 173, 270, 14, Interface);

		setBounds(48621, 293, 270, 15, Interface); // Long button
		setBounds(48622, 293, 270, 16, Interface);

		setBounds(48624, 42, 104, 17, Interface); // Text History
		setBounds(48625, 289, 50, 18, Interface); // TextMy offers

		setBounds(48626, 55, 279, 19, Interface); // Text Item
		setBounds(48627, 132, 279, 20, Interface); // Text Player
		setBounds(48628, 208, 279, 21, Interface); // Text Recent
		setBounds(48629, 367, 279, 22, Interface); // Text List

		setBounds(48635, 30, 128, 23, Interface); // Interface history
		setBounds(48960, 260, 75, 24, Interface); // Interface my offers

		setChildren(30, history);
		for (int i = 48636, y = 5, id = 0; i < 48666; i++) {
			addText(i, "", 0xff9933, true, true, -1, tda, 0);
			setBounds(i, 94, y, id, history);
			if (id == 1 || id == 3 || id == 5 || id == 7 || id == 9 || id == 11 || id == 13 || id == 15 || id == 17 ||
					id == 19 || id == 21 || id == 23 || id == 25 || id == 27)
				y += 20;
			else
				y += 10;
			id++;
		}

		history.scrollMax = 500;
		history.width = 193;
		history.height = 116;

		addSprite(48961, 14, "Trading/SPRITE");
		addItemOnInterface(48962);
		addText(48963, "", 0xff9933, true, true, -1, tda, 2);
		addText(48964, "", 0xff9933, true, true, -1, tda, 1);
		addText(48965, "", 0xff9933, true, true, -1, tda, 1);
		addText(48966, "", 0xff9933, true, true, -1, tda, 0); // Guide: 50M
		addText(48967, "", 0xff9933, true, true, -1, tda, 0); // Listed: 0

		addHoverButton(48968, "Trading/SPRITE", 10, 72, 32, "Set price", 0, 48969, 1);
		addHoveredButton(48969, "Trading/SPRITE", 11, 72, 32, 48970);

		// addHoverButton(48971, "Trading/SPRITE", 10, 72, 32, "Set quantity", 0, 48972,
		// 1);
		// addHoveredButton(48972, "Trading/SPRITE", 11, 72, 32, 48973);

		addHoverButton(48974, "Trading/SPRITE", 10, 72, 32, "Confirm offer", 0, 48975, 1);
		addHoveredButton(48975, "Trading/SPRITE", 11, 72, 32, 48976);

		addText(48977, "Set", 0xff9933, true, true, -1, tda, 2);
		addText(48978, "price", 0xff9933, true, true, -1, tda, 2);
		// addText(48979, "Set", 0xff9933, true, true, -1, tda, 2);
		// addText(48980, "quantity", 0xff9933, true, true, -1, tda, 2);
		addText(48981, "Confirm", 0xff9933, true, true, -1, tda, 2);

		setChildren(14, offers);

		setBounds(48961, 0, 0, 0, offers); // background
		setBounds(48962, 91, 11, 1, offers); // item
		setBounds(48963, 108, 50, 2, offers); // name
		setBounds(48964, 108, 70, 3, offers); // price ea
		setBounds(48965, 108, 85, 4, offers); // quantity
		setBounds(48966, 175, 5, 5, offers); // guide
		setBounds(48967, 175, 20, 6, offers); // listed

		setBounds(48968, 72, 105, 7, offers); // Set price button
		setBounds(48969, 72, 105, 8, offers);

		// setBounds(48971, 114, 105, 9, offers); //Set quantity button
		// setBounds(48972, 114, 105, 10, offers);

		setBounds(48974, 72, 142, 9, offers); // confirm button
		setBounds(48975, 72, 142, 10, offers);

		setBounds(48977, 107, 108, 11, offers); // set
		setBounds(48978, 107, 118, 12, offers); // price
		// setBounds(48979, 149, 108, 13, offers); //set
		// setBounds(48980, 149, 118, 14, offers); //quantity

		setBounds(48981, 107, 151, 13, offers); // confirm

		// offers.scrollMax = 300;
		offers.width = 219;
		offers.height = 181;
	}

	public static void addItemOnInterface(int i) {
		RSInterface rsinterface = interfaceCache[i] = new RSInterface();
		rsinterface.actions = new String[5];
		rsinterface.spritesX = new int[20];
		rsinterface.inventoryAmounts = new int[30];
		rsinterface.inventoryItemId = new int[30];
		rsinterface.spritesY = new int[20];
		rsinterface.children = new int[0];
		rsinterface.childX = new int[0];
		rsinterface.childY = new int[0];
		rsinterface.spritesY[0] = 0;
		// rsinterface.invStackSizes[0] = 0;
		for (int i2 = 0; i2 < 30; i2++)
			rsinterface.inventoryAmounts[i2] = 0;
		rsinterface.inventoryItemId[0] = 0;
		rsinterface.spritesX[0] = 0;
		rsinterface.actions[0] = "Cancel";
		rsinterface.centerText = false;
		rsinterface.aBoolean227 = false;
		rsinterface.aBoolean235 = false;
		rsinterface.usableItemInterface = false;
		rsinterface.isInventoryInterface = false;
		rsinterface.aBoolean259 = false;
		rsinterface.textShadow = false;
		rsinterface.width = 6;
		rsinterface.mOverInterToTrigger = -1;
		rsinterface.invSpritePadX = 24;
		rsinterface.parentID = i;
		rsinterface.invSpritePadY = 24;
		rsinterface.type = 2;
		rsinterface.height = 5;
	}

	public static void listings(TextDrawingArea[] tda) {
		
		RSInterface Interface = addTabInterface(48000);
		RSInterface main = addTabInterface(48020);

		setChildren(18, Interface);
		addSprite(48001, 0, "Trading/SPRITE");

		addHover(48002, 3, 0, 48003, 1, "Bank/BANK", 17, 17, "Close Window");
		addHovered(48003, 2, "Bank/BANK", 17, 17, 48004);
		addHoverButton(48005, "Trading/SPRITE", 1, 88, 30, "Go back", 0, 48006, 1);
		addHoveredButton(48006, "Trading/SPRITE", 2, 88, 30, 48007);
		addHoverButton(48008, "Trading/SPRITE", 10, 72, 35, "Prev Page", 0, 48009, 1);
		addHoveredButton(48009, "Trading/SPRITE", 11, 72, 35, 48010);
		addHoverButton(48011, "Trading/SPRITE", 10, 72, 35, "Next Page", 0, 48012, 1);
		addHoveredButton(48012, "Trading/SPRITE", 11, 72, 35, 48013); // 48045

		addText(48046, "Prev Page", 0xff9933, true, true, -1, tda, 1);
		addText(48047, "Next Page", 0xff9933, true, true, -1, tda, 1);

		addText(48014, "Quantity", tda, 0, 0xff981f, false, false);
		addText(48015, "Name", tda, 0, 0xff981f, false, false);
		addText(48016, "Price", tda, 0, 0xff981f, false, false);
		addText(48017, "Seller", tda, 0, 0xff981f, false, false);
		addText(48018, "Total Sold", tda, 0, 0xff981f, false, false);
		// addText(48019, "Title", tda, 2, 0xff981f, true, true);
		addText(48019, "Trading post", 0xff9933, true, true, -1, tda, 2); // 262, 20

		setBounds(48001, 9, 2, 0, Interface);
		setBounds(48002, 471, 12, 1, Interface); // Close
		setBounds(48003, 471, 12, 2, Interface);
		setBounds(48005, 19, 281, 3, Interface); // Go back
		setBounds(48006, 19, 281, 4, Interface);
		setBounds(48008, 331, 281, 5, Interface); // Modify
		setBounds(48009, 331, 281, 6, Interface);
		setBounds(48011, 413, 281, 7, Interface); // Refresh
		setBounds(48012, 413, 281, 8, Interface);

		setBounds(48014, 23, 42, 9, Interface); // Quantity
		setBounds(48015, 117, 42, 10, Interface); // Name
		setBounds(48016, 217, 42, 11, Interface); // Price
		setBounds(48017, 317, 42, 12, Interface); // Seller
		setBounds(48018, 414, 42, 13, Interface); // Total sold
		setBounds(48019, 262, 12, 14, Interface); // Titel
		setBounds(48020, 21, 50, 15, Interface); // Scroll

		setBounds(48046, 366, 288, 16, Interface); // Prev page
		setBounds(48047, 449, 288, 17, Interface); // Next Page

//		addListing(48021, true);
//		for (int i = 48022; i < 48046; i++) {
//			addText(i, "", tda, 0, 0xff981f, true, false);
//		}
		/*
		 * addItemOnInterface(28021); addText(28022, "Abyssal whip", tda, 0, 0xff981f,
		 * true, false); addText(28023, "100,000", tda, 0, 0xff981f, true, false);
		 * addText(28024, "Nighel", tda, 0, 0xff981f, true, false); addTextButton(28025,
		 * "Buy", "Buy", 0xFF981F, false, true, tda, 0, 400);
		 * 
		 * addItemOnInterface(28026); addText(28027, "Granite maul", tda, 0, 0xff981f,
		 * true, false); addText(28028, "10,000", tda, 0, 0xff981f, true, false);
		 * addText(28029, "Leroy the noob", tda, 0, 0xff981f, true, false);
		 * addTextButton(28030, "Buy", "Buy", 0xFF981F, false, true, tda, 0, 400);
		 */

		setChildren(1001, main);
		
		int childId = 26022;
		int frame = 0;
		
		addToItemGroup(childId, 1, 250, 0, 7, true, "Buy 1", "Buy 5", "Buy 10", "Buy All", "Buy X", "View History");
		setBounds(childId++, 5, 10, frame++, main); // Item
		
		for(int i = 0; i < 250; i++) {
			addText(childId, "", tda, 0, 0xff981f, true, false);
			setBounds(childId++, 109, 20 + (i * 39), frame++, main); // Name
			
			addText(childId, "", tda, 0, 0xff981f, true, false);
			setBounds(childId++, 210, 20 + (i * 39), frame++, main); // Amount
			
			addText(childId, "", tda, 0, 0xff981f, true, false);
			setBounds(childId++, 310, 20 + (i * 39), frame++, main); // Seller
			
			addText(childId, "", tda, 0, 0xff981f, true, false);
			setBounds(childId++, 418, 20 + (i * 39), frame++, main); // Buy
		}
		//System.out.println("CHILD:  + "  + childId);

//		setBounds(48021, 5, 10, 0, main); // Item
//
//		setBounds(48022, 109, 20, 1, main); // Name
//		setBounds(48023, 210, 20, 2, main); // Amount
//		setBounds(48024, 310, 20, 3, main); // Seller
//		setBounds(48025, 418, 20, 4, main); // Buy
//
//		setBounds(48026, 109, 59, 5, main); // Name
//		setBounds(48027, 210, 59, 6, main); // Amount
//		setBounds(48028, 310, 59, 7, main); // Seller
//		setBounds(48029, 418, 59, 8, main); // Buy
//
//		setBounds(48030, 109, 95, 9, main); // Name
//		setBounds(48031, 210, 95, 10, main); // Amount
//		setBounds(48032, 310, 95, 11, main); // Seller
//		setBounds(48033, 418, 95, 12, main); // Buy
//
//		setBounds(48034, 109, 131, 13, main); // Name
//		setBounds(48035, 210, 131, 14, main); // Amount
//		setBounds(48036, 310, 131, 15, main); // Seller
//		setBounds(48037, 418, 131, 16, main); // Buy
//
//		setBounds(48038, 109, 170, 17, main); // Name
//		setBounds(48039, 210, 170, 18, main); // Amount
//		setBounds(48040, 310, 170, 19, main); // Seller
//		setBounds(48041, 418, 170, 20, main); // Buy
//
//		setBounds(48042, 109, 204, 21, main); // Name
//		setBounds(48043, 210, 204, 22, main); // Amount
//		setBounds(48044, 310, 204, 23, main); // Seller
//		setBounds(48045, 418, 204, 24, main); // Buy

		main.width = 445;
		main.height = 227;
		main.scrollMax = 39 * 250;
	}

	public static void addListing(int index, boolean search) {
		RSInterface rsi = interfaceCache[index] = new RSInterface();
		rsi.actions = new String[10];
		rsi.spritesX = new int[20];
		rsi.inventoryAmounts = new int[30];
		rsi.inventoryItemId = new int[30];
		rsi.spritesY = new int[20];

		rsi.children = new int[0];
		rsi.childX = new int[0];
		rsi.childY = new int[0];
		if (!search)
			rsi.actions[0] = "Cancel";
		else {
			rsi.actions[0] = "Buy 1";
			rsi.actions[1] = "Buy 5";
			rsi.actions[2] = "Buy 10";
			rsi.actions[3] = "Buy All";
			rsi.actions[4] = "Buy X";
		}
		rsi.centerText = true;
		rsi.aBoolean227 = false;
		rsi.aBoolean235 = false;
		rsi.usableItemInterface = false;
		rsi.isInventoryInterface = false;
		rsi.aBoolean259 = true;
		rsi.textShadow = false; // 42, 82
		if (!search) {
			rsi.invSpritePadX = 0;
			rsi.invSpritePadY = 15;
		} else {
			rsi.invSpritePadX = 0;
			rsi.invSpritePadY = 5;
		}
		if (!search)
			rsi.height = 15;
		else
			rsi.height = 8;
		rsi.width = 1;
		rsi.parentID = index + 1;
		rsi.id = index;
		rsi.type = 2;
	}

//	public static void groundItemCustomizing(TextDrawingArea[] tda) {
//		RSInterface r = addInterface(37700);
//		addSprite(37701, 2, "Interfaces/GroundItems/IMAGE");// they got saved as jpgs, need 2 convert lol il plz do
//		addText(37702, "Ground items customizer", tda, 2, 0xFE9624, true, true);
//		addHoverButton(37703, "Interfaces/GroundItems/IMAGE", 0, 16, 16, "Close", -1, 37704, 3);
//		addHoveredButton(37704, "Interfaces/GroundItems/IMAGE", 1, 16, 16, 37705);
//		addButton(37706, 4, "Interfaces/GroundItems/IMAGE", "Choose color");
//		addText(37707, "Choose a color below!", tda, 2, 0xffffff, true, true);
//		addButton(37708, 3, "Interfaces/GroundItems/IMAGE", "Enter Item Name");
//		addText(37709, "Set Color To Item", tda, 0, 0xFE9624, true, true);
//		addButton(37710, 3, "Interfaces/GroundItems/IMAGE", "Enter Minimum Item Value");
//		addText(37711, "Enter Min. Value", tda, 0, 0xFE9624, true, true);
//		addButton(37712, 3, "Interfaces/GroundItems/IMAGE", "Reset All Item Colors");
//		addText(37713, "Reset All Colors", tda, 0, 0xFE9624, true, true);
//		r.totalChildren(12);
//		r.child(0, 37701, 130, 75);// opn skype need 2 send u some imgs
//		r.child(1, 37702, 245, 85);
//		r.child(2, 37703, 334, 85);
//		r.child(3, 37704, 334, 85);
//		r.child(4, 37706, 137, 215);
//		r.child(5, 37707, 240, 195);
//		r.child(6, 37708, 150, 120);
//		r.child(7, 37709, 192, 125);
//		r.child(8, 37710, 250, 120);
//		r.child(9, 37711, 292, 125);
//		r.child(10, 37712, 150, 150);
//		r.child(11, 37713, 192, 155);
//	}

	public static void helpDatabaseComponent(TextDrawingArea[] tda) {
		RSInterface widget = addInterface(59550);
		addSprite(59551, 8, "Interfaces/HelpInterface/IMAGE");
		addHoverButton(59552, "Interfaces/HelpInterface/IMAGE", 2, 16, 16, "Close", -1, 59553, 3);
		addHoveredButton(59553, "Interfaces/HelpInterface/IMAGE", 3, 16, 16, 59554);
		addText(59555, "Bug Database", tda, 2, 0xFF981F, true, true);
		addText(59556, "Username/Date", tda, 1, 0xFF981F, false, true);
		addText(59557, "Line2", tda, 1, 0xFF981F, true, true);
		addText(59558, "Line3", tda, 1, 0xFF981F, true, true);
		addText(59559, "Line4", tda, 1, 0xFF981F, true, true);
		addText(59560, "Line5", tda, 1, 0xFF981F, true, true);

		setChildren(10, widget);
		setBounds(59551, 0, 2, 0, widget);
		setBounds(59552, 375, 8, 1, widget);
		setBounds(59553, 375, 8, 2, widget);
		setBounds(59570, 120, 30, 3, widget);
		setBounds(59555, 256, 8, 4, widget);
		setBounds(59556, 20, 225, 5, widget);
		setBounds(59557, 256, 245, 6, widget);
		setBounds(59558, 256, 265, 7, widget);
		setBounds(59559, 256, 285, 8, widget);
		setBounds(59560, 256, 305, 9, widget);

		RSInterface scroll = addInterface(59570);
		scroll.scrollMax = 400;
		scroll.width = 255;
		scroll.height = 170;
		setChildren(60, scroll);

		int yPosition = 0;
		int index = 0;
		for (int i = 0; i < 80; i += 4) {
			addText(59573 + i, "", tda, 1, 0xFF981F, false, true);
			addButton(59574 + i, 10, "Interfaces/HelpInterface/IMAGE", 13, 10, "View Request", 1);
			addButton(59575 + i, 9, "Interfaces/HelpInterface/IMAGE", 16, 15, "Remove Request", 1);
			setBounds(59573 + i, 4, yPosition + 3, index++, scroll);
			setBounds(59574 + i, 225, yPosition + 5, index++, scroll);
			setBounds(59575 + i, 240, yPosition + 3, index++, scroll);
			yPosition += 20;
		}
	}

	private static void barrowsKillcount(TextDrawingArea[] tda) {
		RSInterface barrow = addInterface(27500);
		addText(27501, "Brothers", tda, 2, 0xFD851A, true, true);
		addText(27502, "Ahrim", tda, 0, 0xFD851A, true, true);
		addText(27503, "Dharok", tda, 0, 0xFD851A, true, true);
		addText(27504, "Guthan", tda, 0, 0xFD851A, true, true);
		addText(27505, "Karil", tda, 0, 0xFD851A, true, true);
		addText(27506, "Torag", tda, 0, 0xFD851A, true, true);
		addText(27507, "Verac", tda, 0, 0xFD851A, true, true);
		addText(27508, "Killcount", tda, 2, 0xFD851A, true, true);
		addText(27509, "0", tda, 0, 0xFD851A, true, true);
		setChildren(9, barrow);
		setBounds(27501, 470, 42, 0, barrow);
		for (int index = 1; index < 7; index++)
			setBounds(27501 + index, 470, 45 + index * 14, index, barrow);
		setBounds(27508, 470, 15, 7, barrow);
		setBounds(27509, 470, 30, 8, barrow);
	}

	public static void achievements(TextDrawingArea[] tda) {
		RSInterface rsi = addInterface(49000);
		addSprite(49001, 1, "Interfaces/Achievements/IMAGE");
		addHoverButton(49002, "Interfaces/Achievements/IMAGE", 15, 16, 16, "Close Window", -1, 49003, 3);
		addHoveredButton(49003, "Interfaces/Achievements/IMAGE", 16, 16, 16, 49004);
		addConfigButton(49005, 49000, 12, 20, "Interfaces/Achievements/IMAGE", 71, 29, "Tier Tier I", 1, 1, 800);
		addConfigButton(49006, 49000, 13, 20, "Interfaces/Achievements/IMAGE", 71, 29, "Tier Tier II", 1, 1, 801);
		addConfigButton(49007, 49000, 14, 20, "Interfaces/Achievements/IMAGE", 71, 29, "View Tier III", 1, 1, 802);
		addSprite(49014, 11, "Interfaces/Achievements/IMAGE");
		addText(49016, "1000", tda, 0, 0xff981f, true, true);
		addText(49017, "Tier I", tda, 0, 0xff981f, false, true);
		addText(49018, "Tier II", tda, 0, 0xff981f, false, true);
		addText(49019, "Tier III", tda, 0, 0xff981f, false, true);
		addText(49020, "100", tda, 0, 0xff981f, false, true);

		setChildren(14, rsi);
		setBounds(49001, 0, 0, 0, rsi);
		setBounds(49002, 490, 6, 1, rsi);
		setBounds(49003, 490, 6, 2, rsi);

		setBounds(49005, 15, 10, 3, rsi);
		setBounds(49006, 90, 10, 4, rsi);
		setBounds(49007, 165, 10, 5, rsi);

		setBounds(49014, 415, 14, 6, rsi);
		setBounds(49016, 443, 19, 7, rsi);
		setBounds(49017, 37, 19, 8, rsi);
		setBounds(49018, 111, 19, 9, rsi);
		setBounds(49019, 184, 19, 10, rsi);

		setBounds(49100, 3, 48, 11, rsi);
		setBounds(51100, 3, 48, 12, rsi);
		setBounds(53100, 3, 48, 13, rsi);

		RSInterface scroll = addInterface(49100);
		setChildren(800, scroll);
		scroll.scrollMax = 6502;
		scroll.height = 281;
		scroll.width = 486;
		int y = 0;
		for (int i = 0; i < 100; i++) {
			addSprite(49101 + i, 10, "Interfaces/Achievements/IMAGE");
			addSprite(49201 + i, 2, "Interfaces/Achievements/IMAGE");
			addSprite(49301 + i, 5, "Interfaces/Achievements/IMAGE");
			addText(49401 + i, "", tda, 2, 0xFFFFFF, true, true);
			addText(49501 + i, "", tda, 2, 0xFFFFFF, false, true);
			addText(49601 + i, "", tda, 2, 0x425619, false, true);
			addSprite(49701 + i, 6, "Interfaces/Achievements/IMAGE");
			addText(49801 + i, "0/1", tda, 1, 0xFFFFFF, true, true);
			setBounds(49101 + i, 1, y, i, scroll);
			setBounds(49201 + i, 8, y + 5, 100 + i, scroll);
			setBounds(49301 + i, 430, y + 12, 200 + i, scroll);
			setBounds(49401 + i, 448, y + 24, 300 + i, scroll);
			setBounds(49501 + i, 65, y + 9, 400 + i, scroll);
			setBounds(49601 + i, 65, y + 24, 500 + i, scroll);
			setBounds(49701 + i, 65, y + 41, 600 + i, scroll);
			setBounds(49801 + i, 160, y + 43, 700 + i, scroll);
			y += 65;
		}
		RSInterface tier2 = addInterface(51100);
		setChildren(800, tier2);
		tier2.scrollMax = 6502;
		tier2.height = 281;
		tier2.width = 486;
		y = 0;
		for (int i = 0; i < 100; i++) {
			addSprite(51101 + i, 10, "Interfaces/Achievements/IMAGE");
			addSprite(51201 + i, 3, "Interfaces/Achievements/IMAGE");
			addSprite(51301 + i, 5, "Interfaces/Achievements/IMAGE");
			addText(51401 + i, "", tda, 2, 0xFFFFFF, true, true);
			addText(51501 + i, "", tda, 2, 0xFFFFFF, false, true);
			addText(51601 + i, "", tda, 2, 0x425619, false, true);
			addSprite(51701 + i, 6, "Interfaces/Achievements/IMAGE");
			addText(51801 + i, "0/1", tda, 1, 0xFFFFFF, true, true);
			setBounds(51101 + i, 1, y, i, tier2);
			setBounds(51201 + i, 8, y + 5, 100 + i, tier2);
			setBounds(51301 + i, 430, y + 12, 200 + i, tier2);
			setBounds(51401 + i, 448, y + 24, 300 + i, tier2);
			setBounds(51501 + i, 65, y + 9, 400 + i, tier2);
			setBounds(51601 + i, 65, y + 24, 500 + i, tier2);
			setBounds(51701 + i, 65, y + 41, 600 + i, tier2);
			setBounds(51801 + i, 160, y + 43, 700 + i, tier2);
			y += 65;
		}
		RSInterface tier3 = addInterface(53100);
		setChildren(800, tier3);
		tier3.scrollMax = 6502;
		tier3.height = 281;
		tier3.width = 486;
		y = 0;
		for (int i = 0; i < 100; i++) {
			addSprite(53101 + i, 10, "Interfaces/Achievements/IMAGE");
			addSprite(53201 + i, 4, "Interfaces/Achievements/IMAGE");
			addSprite(53301 + i, 5, "Interfaces/Achievements/IMAGE");
			addText(53401 + i, "", tda, 2, 0xFFFFFF, true, true);
			addText(53501 + i, "", tda, 2, 0xFFFFFF, false, true);
			addText(53601 + i, "", tda, 2, 0x425619, false, true);
			addSprite(53701 + i, 6, "Interfaces/Achievements/IMAGE");
			addText(53801 + i, "0/1", tda, 1, 0xFFFFFF, true, true);
			setBounds(53101 + i, 1, y, i, tier3);
			setBounds(53201 + i, 8, y + 5, 100 + i, tier3);
			setBounds(53301 + i, 430, y + 12, 200 + i, tier3);
			setBounds(53401 + i, 448, y + 24, 300 + i, tier3);
			setBounds(53501 + i, 65, y + 9, 400 + i, tier3);
			setBounds(53601 + i, 65, y + 24, 500 + i, tier3);
			setBounds(53701 + i, 65, y + 41, 600 + i, tier3);
			setBounds(53801 + i, 160, y + 43, 700 + i, tier3);
			y += 65;
		}
	}

	private static final void addGodwarsWidget(TextDrawingArea[] tda) {
		RSInterface godwars = addInterface(16210);
		setChildren(12, godwars);
		addText(16211, "NPC Killcount", tda, 0, 0xFD851A, false, true);
		addText(16212, "Armadyl", tda, 0, 0xFD851A, false, true);
		addText(16213, "Bandos", tda, 0, 0xFD851A, false, true);
		addText(16214, "Saradomin", tda, 0, 0xFD851A, false, true);
		addText(16215, "Zamorak", tda, 0, 0xFD851A, false, true);
		addText(16216, "Ancient", tda, 0, 0xFD851A, false, true);
		addText(16217, "0", tda, 0, 0x66FFFF, false, true);
		addText(16218, "0", tda, 0, 0x66FFFF, false, true);
		addText(16219, "0", tda, 0, 0x66FFFF, false, true);
		addText(16220, "0", tda, 0, 0x66FFFF, false, true);
		addText(16221, "0", tda, 0, 0x66FFFF, false, true);
		setBounds(16211, 400, 20, 0, godwars);
		for (int index = 1; index <= 5; index++) {
			setBounds(16211 + index, 400, 20 + index * 13, index, godwars);
		}
		for (int index = 1; index <= 5; index++) {
			setBounds(16216 + index, 480, 20 + index * 13, index + 5, godwars);
		}
	}


	public static void addNpc(int ID, int npcId) {
		RSInterface petCanvas = interfaceCache[ID] = new RSInterface();
		petCanvas.id = ID;
		petCanvas.parentID = ID;
		petCanvas.type = 6;
		petCanvas.atActionType = 0;
		petCanvas.contentType = 3291;
		petCanvas.width = 135;
		petCanvas.height = 70;
		petCanvas.transparancy = 0;
		petCanvas.modelZoom = 2000;
		petCanvas.modelRotation1 = 150;
		petCanvas.modelRotation2 = 0;
		petCanvas.disabledAnimationId = -1;
		petCanvas.enabledAnimationId = -1;
		petCanvas.npcDisplay = npcId;
	}




	public static void teleportInterface(TextDrawingArea[] tda){

		//vars
		int interfaceId = 58000;
		int btnNormal = 1057;
		int btnHover = 1058;
		int orangeColor = 16750623;
		int totalChild = 0; // change if more children are added to tab
		String filePath = "interfaces/new_tele";

		RSInterface tab = addInterface(interfaceId);
		interfaceId++;

		addSprite(interfaceId, 1054, filePath);
		interfaceId++;
		totalChild++;
		//Title
		addText(interfaceId, "Cyphorax Teleports", tda, 3, orangeColor, true, true);
		interfaceId++;
		totalChild++;

		//Close
		addHoverButtonNew(interfaceId, 996, 16, 16, "Close", -1, 58004, filePath, 1);
		interfaceId++;
		totalChild++;
		addHoveredButtonNew(interfaceId, 997, 16, 16, filePath);
		interfaceId++;
		totalChild++;
		//Monsters button
		addHoverButtonNew(interfaceId, btnNormal, 85, 20, "Monsters", -1, 58006, filePath, 1);
		interfaceId++;
		totalChild++;
		addHoveredButtonNew(interfaceId, btnHover, 85, 20, filePath);
		interfaceId++;
		totalChild++;
		addSprite(interfaceId, 1069, filePath);
		interfaceId++;
		totalChild++;
		addText(interfaceId, "Monsters", tda, 1, orangeColor, true, true);
		interfaceId++;
		totalChild++;

		//Bosses button
		addHoverButtonNew(interfaceId, btnNormal, 85, 20, "Bosses", -1, 58010, filePath, 1);
		interfaceId++;
		totalChild++;
		addHoveredButtonNew(interfaceId, btnHover, 85, 20, filePath);
		interfaceId++;
		totalChild++;
		addSprite(interfaceId, 1066, filePath);
		interfaceId++;
		totalChild++;
		addText(interfaceId, "Bosses", tda, 1, orangeColor, true, true);
		interfaceId++;
		totalChild++;

		//Minigames button
		addHoverButtonNew(interfaceId, btnNormal, 85, 20, "Minigames", -1, 58014, filePath, 1);
		interfaceId++;
		totalChild++;
		addHoveredButtonNew(interfaceId, btnHover, 85, 20, filePath );
		interfaceId++;
		totalChild++;
		addSprite(interfaceId, 1065, filePath);
		interfaceId++;
		totalChild++;
		addText(interfaceId, "Minigames", tda, 1, orangeColor, true, true);
		interfaceId++;
		totalChild++;

		//Skilling button
		addHoverButtonNew(interfaceId, btnNormal, 85, 20, "Skilling", -1, 58018, filePath, 1);
		interfaceId++;
		totalChild++;
		addHoveredButtonNew(interfaceId, btnHover, 85, 20, filePath);
		interfaceId++;
		totalChild++;
		addSprite(interfaceId, 1068, filePath);
		interfaceId++;
		totalChild++;
		addText(interfaceId, "Skilling", tda, 1, orangeColor, true, true);
		interfaceId++;
		totalChild++;

		//Cities button
		addHoverButtonNew(interfaceId, btnNormal, 85, 20, "Cities", -1, 58022, filePath, 1 );
		interfaceId++;
		totalChild++;
		addHoveredButtonNew(interfaceId, btnHover, 85, 20, filePath);
		interfaceId++;
		totalChild++;
		addSprite(interfaceId, 1070, filePath);
		interfaceId++;
		totalChild++;
		addText(interfaceId, "Cities", tda, 1, orangeColor, true, true);
		interfaceId++;
		totalChild++;

		//Collection Log
		addSprite(interfaceId, 1071, filePath );
		interfaceId++;
		totalChild++;
		addText(interfaceId, "Collection Log", tda, 1, orangeColor, true, true);
		interfaceId++;
		totalChild++;

		//Rewards
		addSprite(interfaceId, 1067, filePath );
		interfaceId++;
		totalChild++;
		addText(interfaceId, "Rewards", tda, 1, orangeColor, true, true);
		interfaceId++;
		totalChild++;
		addHoverButtonNew(interfaceId, btnNormal, 85, 20, "Claim", -1, 58030, filePath, 1);
		interfaceId++;
		totalChild++;
		addHoveredButtonNew(interfaceId, btnHover, 85, 20, filePath);
		interfaceId++;
		totalChild++;
		addText(interfaceId, "Claim", tda, 1, orangeColor, true, true);
		interfaceId++;
		totalChild++;

		//Teleport Button
		addHoverButtonNew(interfaceId, 1055, 140, 29, "Teleport", -1, 58033, filePath, 1);
		interfaceId++;
		totalChild++;
		addHoveredButtonNew(interfaceId, 1056, 140, 29, filePath);
		interfaceId++;
		totalChild++;
		addText(interfaceId, "Teleport Now", tda, 2, orangeColor, true, true);
		interfaceId++;
		totalChild++;

		// Mutable interface elements
		addText(interfaceId, "", tda, 1, orangeColor, true, true );
		interfaceId++;
		totalChild++;

		addNpc(interfaceId, 1265);
		interfaceId++;
		totalChild++;

		//Left column
		//title
		addText(interfaceId, "", tda, 2, orangeColor, true, true);
		interfaceId++;
		totalChild++;

		//addToItemGroup(58046, 190, 83, 10, 5, false, new String[] {null, null, null, null, null});

		tab.totalChildren(38);
		tab.child(0, 58001, 7, 8);
		//Title
		tab.child(21, 58002, 250, 15);
		//Close
		tab.child(22, 58003, 465, 18);
		tab.child(23, 58004, 465, 18);
		//Monsters button
		tab.child(1, 58005, 25, 48);
		tab.child(2, 58006, 25, 48);
		tab.child(11, 58007, 30, 50);
		tab.child(12, 58008, 75, 50);
		//Bosses button
		tab.child(3, 58009, 115, 48);
		tab.child(4, 58010, 115, 48);
		tab.child(13, 58011, 120, 50);
		tab.child(14, 58012, 165, 50);
		//Minigames button
		tab.child(5, 58013, 205, 48);
		tab.child(6, 58014, 205, 48);
		tab.child(15, 58015, 210, 50);
		tab.child(16, 58016, 255, 50);
		//Skilling button
		tab.child(7, 58017, 295, 48);
		tab.child(8, 58018, 295, 48);
		tab.child(17, 58019, 300, 50);
		tab.child(18, 58020, 345, 50);
		//Cities button
		tab.child(9, 58021, 385, 48);
		tab.child(10, 58022, 385, 48);
		tab.child(19, 58023, 390, 50);
		tab.child(20, 58024, 435, 50);
		//Collection Log
		tab.child(24, 58025, 285, 115);
		tab.child(25, 58026, 345, 115);
		//Rewards
		tab.child(26, 58027, 145, 225);
		tab.child(27, 58028, 190, 227);
		tab.child(28, 58029, 385, 265);
		tab.child(29, 58030, 385, 265);
		tab.child(30, 58031, 427, 267);
		//Left column
		tab.child(31, 58200, 15, 105);
		tab.child(32, 58043, 68, 83);
		//Teleport Now
		tab.child(33, 58032, 138, 193);
		tab.child(34, 58033, 138, 193);
		tab.child(35, 58034, 205, 200);
		// Mutable interface elements
		tab.child(36, 58035, 305, 88);

		//NPC Model Interface
		tab.child(37, 58036, 140, 140);


		//Scroll Menu
		RSInterface teleportList = addInterface(58200);
		teleportList.width = 95; teleportList.height = 190; teleportList.scrollMax = 490;
//		setChildren(0, teleportList);
		// increase if more child elements are added to teleportList

		int teleportChild = 1;
		int y = 0;
		int teleportId = 58201;


		for (int i = 1; i < 40; i++) {
			addHoverButtonNew(teleportId, 1072, 100, 19, "Select", -1, teleportId + 1, filePath, 1);
			addHoveredButtonNew(teleportId + 1, 1073, 100, 19, filePath);
//			addText(teleportId + 3, "", orangeColor, true, true, 52, tda, 0);
			addText(teleportId + 3 , "", tda, 0, orangeColor, false, true);
			teleportList.child(teleportChild, teleportId, 0, y);
			teleportList.child(teleportChild + 1, teleportId + 1, 0, y);
			teleportList.child(teleportChild + 2, teleportId + 3, 5, y);
			teleportId += 4;
			teleportChild += 3;
			y += 19;

		}
		teleportList.totalChildren(teleportChild);
	}
//	private static void teleportInterface(TextDrawingArea[] textDrawingAreas) {
//
//		int interfaceId = 39700;//checkinterface
//		int child = 0;
//		RSInterface interfaces = RSInterface.addInterface(interfaceId);
//		interfaceId++;
//		RSInterface.setChildren(33, interfaces);
//		int xOffset = 80;
//		int yOffset = 40;
//
//		RSInterface.addSprite(interfaceId, 609, "Interfaces/Presets/SPRITE"); // Background.
//		RSInterface.setBounds(interfaceId, 9 + xOffset, 21 + yOffset, child, interfaces);
//		interfaceId++;
//		child++;
//
//		RSInterface.addText(interfaceId, "Teleports", textDrawingAreas, 2, 0xff981f, false);
//		RSInterface.setBounds(interfaceId, 150 + xOffset, 30 + yOffset, child, interfaces);
//		interfaceId++;
//		child++;
//
//		Object[][] teleportSelections = {
//				{"Monsters", 1616},
//				{"Bosses", 1617},
//				{"Wilderness", 1613},
//				{"Skilling", 1614},
//				{"Minigames", 1618},
//				{"Cities", 1615},
//				{"Donator", 1619},
//		};
//
//		int yExtra = -1, count = 0;
//		for (int index = 0; index < 7; index++) {
//			String name = (String) teleportSelections[index][0];
//			int buttonId = (int) teleportSelections[index][1];
//			RSInterface.addHoverButtonLatest("Interfaces/Presets/SPRITE",interfaceId, interfaceId + 1, interfaceId + 2, count % 2 == 0 ? 614 : 614,
//					610, 89, 26, "Choose");
//			count++;
//			RSInterface.addSprite(interfaceId, 612, "Interfaces/Presets/SPRITE");
//			RSInterface.setBounds(interfaceId, 16 + xOffset, 57 + yOffset + yExtra, child, interfaces);
//			child++;
//			RSInterface.setBounds(interfaceId + 1, 16 + xOffset, 56 + yOffset + yExtra, child, interfaces);
//			child++;
//			interfaceId += 3;
//			RSInterface.addClickableText(interfaceId, name,"Choose", textDrawingAreas, 1, 0xff981f, false,false,60, 16);
//			RSInterface.setBounds(interfaceId, 40 + xOffset, 61 + yOffset + yExtra, child, interfaces);
//			interfaceId++;
//			child++;
//			Sprite selectionIcon = new Sprite("Interfaces/teleport_interface/SPRITE " + buttonId);
//			RSInterface.addSprite(interfaceId, selectionIcon);
//			RSInterface.setBounds(interfaceId, 18 + xOffset - (selectionIcon.myWidth / 2) + 10,
//					59 + yOffset + yExtra - (selectionIcon.myHeight / 2) + 9, child, interfaces);
//			interfaceId++;
//			child++;
//			yExtra += 25;
//		}
//		yExtra = 0;
//		interfaceId+=5000;
//		//RSInterface.addHoverButtonLatest("Interfaces/Presets/SPRITE",interfaceId, interfaceId + 1, interfaceId + 2, 148, 149, 15, 15,
//		//		"Close Window");
//		RSInterface.setBounds(CLOSE_BUTTON_SMALL, 317 + xOffset, 30 + yOffset, child, interfaces);
//		RSInterface.setBounds(CLOSE_BUTTON_SMALL_HOVER, 317 + xOffset, 30 + yOffset, child + 1, interfaces);
//		child += 2;
//		interfaceId += 3;
//
//		RSInterface scrollTab1 = RSInterface.addInterface(interfaceId);
//		RSInterface.setBounds(interfaceId, 111 + xOffset, 56 + yOffset, child, interfaces); // scrollTab1
//		interfaceId++;
//		child++;
//
//		int teleportAmount = 41;
//		scrollTab1.width = 209;
//		scrollTab1.height = 174;
//		scrollTab1.scrollMax = 625;
//		scrollTab1.totalChildren(teleportAmount * 3);
//		int increaseY = 0, childNew = 0;
//		for (int i = 0; i < teleportAmount; i++) {
//
//			RSInterface.addHoverButtonLatest("Interfaces/Presets/SPRITE",interfaceId, interfaceId + 1, interfaceId + 2, count % 2 == 0 ? 613 : 967,
//					611, 224, 26, "Teleport");
//			count++;
//			scrollTab1.child(childNew, interfaceId, 0, increaseY);
//			childNew++;
//			scrollTab1.child(childNew, interfaceId + 1, 0, increaseY);
//			childNew++;
//			interfaceId += 3;
//
//			RSInterface.addText(interfaceId, ""+interfaceId, textDrawingAreas, 1, 0xff981f, true);
//			scrollTab1.child(childNew, interfaceId, 104, increaseY + 4);
//			increaseY += 25;
//			interfaceId++;
//			childNew++;
//		}
//
//		interfaces.setNewButtonClicking();
//		scrollTab1.setNewButtonClicking();
//	}



	/*private static void teleportInterfaceJosh(TextDrawingArea[] textDrawingAreas) {
		String dir = "Interfaces/Presets/SPRITE";
		int interfaceId = 44712;//checkinterface
		int child = 0;
		RSInterface interfaces = RSInterface.addInterface(interfaceId);
		interfaceId++;
		RSInterface.setChildren(33, interfaces);
		int xOffset = 20;
		int yOffset = 20;

		RSInterface.addSprite(interfaceId, 0, "Interfaces/teleinterface/background"); // Background.
		RSInterface.setBounds(interfaceId, 0, 0, child, interfaces);
		interfaceId++;
		child++;

		RSInterface.addText(interfaceId, "Teleports", textDrawingAreas, 2, 0xff981f, false);
		RSInterface.setBounds(interfaceId, 200 + xOffset, yOffset, child, interfaces);
		interfaceId++;
		child++;

		Object[][] teleportSelections = {
				{"Monsters", 1616},
				{"Bosses", 1617},
				{"Wilderness", 1613},
				{"Skilling", 1614},
				{"Minigames", 1618},
				{"Cities", 1615},
				{"Donator", 1619},
		};

		int yExtra = -1, count = 0;
		int xExtra = -1;
		for (int index = 0; index < 7; index++) {
			String name = (String) teleportSelections[index][0];
			int buttonId = (int) teleportSelections[index][1];
			RSInterface.addHoverButtonLatest("Interfaces/Presets/SPRITE",interfaceId, interfaceId + 1, interfaceId + 2, count % 2 == 0 ? 614 : 614,
					610, 89, 26, "Choose");
			newHoverButtonConfig(interfaceId, "Choose", 612, 614, dir, 1333, 1 + index);
			count++;
			//RSInterface.addSprite(interfaceId, 612, "Interfaces/Presets/SPRITE");
			//RSInterface.setBounds(interfaceId,  xOffset + xExtra, 57 + yOffset , child, interfaces);
			//child++;
			RSInterface.setBounds(interfaceId + 1,  xOffset + xExtra, 15 + yOffset, child, interfaces);
			child++;
			interfaceId += 3;
			RSInterface.addClickableText(interfaceId, name,"Choose", textDrawingAreas, 1, 0xff981f, false,false,60, 16);
			RSInterface.setBounds(interfaceId, 35 - 16 + xOffset + xExtra, 20 + yOffset *//*+ yExtra*//*, child, interfaces);
			interfaceId++;
			child++;
			Sprite selectionIcon = new Sprite("Interfaces/teleport_interface/SPRITE " + buttonId);
			RSInterface.addSprite(interfaceId, selectionIcon);
			RSInterface.setBounds(interfaceId, 18 + xOffset + xExtra - 15 - (selectionIcon.myWidth / 2) + 10,
					18 + yOffset - (selectionIcon.myHeight / 2) + 9, child, interfaces);
			interfaceId++;
			child++;
			yExtra += 25;
			xExtra += 80;
		}
		yExtra = 0;
		interfaceId+=5000;
		//RSInterface.addHoverButtonLatest("Interfaces/Presets/SPRITE",interfaceId, interfaceId + 1, interfaceId + 2, 148, 149, 15, 15,
		//		"Close Window");
		RSInterface.addHoverButtonLatest("Interfaces/Presets/SPRITE",interfaceId, interfaceId + 1, interfaceId + 2, 148, 149, 15, 15,
				"Close Window");
		//RSInterface.setBounds(CLOSE_BUTTON_SMALL, 317 + xOffset, 30 + yOffset, child, interfaces);
		//RSInterface.setBounds(CLOSE_BUTTON_SMALL_HOVER, 317 + xOffset, 30 + yOffset, child + 1, interfaces);
		newHoverButtonConfig(interfaceId, "Close Window", 149, 148, dir, 1333, 1);
		RSInterface.setBounds(interfaceId, 317 + xOffset, 30 + yOffset, child, interfaces);
		RSInterface.setBounds(interfaceId + 1, 317 + xOffset, 30 + yOffset, child + 1, interfaces);
		child += 2;
		interfaceId += 3;

		RSInterface scrollTab1 = RSInterface.addInterface(interfaceId);
		RSInterface.setBounds(interfaceId, 111 + xOffset, 56 + yOffset, child, interfaces); // scrollTab1
		interfaceId++;
		child++;

		int teleportAmount = 40;
		scrollTab1.width = 209;
		scrollTab1.height = 174;
		scrollTab1.scrollMax = 625;
		scrollTab1.totalChildren(teleportAmount * 3);
		int increaseY = 0, childNew = 0;
		for (int i = 0; i < teleportAmount; i++) {

			RSInterface.addHoverButtonLatest("Interfaces/Presets/SPRITE",interfaceId, interfaceId + 1, interfaceId + 2, count % 2 == 0 ? 613 : 967,
					611, 224, 26, "Teleport");
			newHoverButtonConfig(interfaceId, "Teleport", 611, 613, dir, 1333, 1);
			count++;
			scrollTab1.child(childNew, interfaceId, 0, increaseY);
			childNew++;
			scrollTab1.child(childNew, interfaceId + 1, 0, increaseY);
			childNew++;
			interfaceId += 3;

			RSInterface.addText(interfaceId, ""+interfaceId, textDrawingAreas, 1, 0xff981f, true);
			scrollTab1.child(childNew, interfaceId, 104, increaseY + 4);
			increaseY += 25;
			interfaceId++;
			childNew++;
		}

		interfaces.setNewButtonClicking();
		scrollTab1.setNewButtonClicking();
	}*/



	public static void keybindingDropdown(int id, int width, int defaultOption, String[] options, MenuItem menuItem,
			boolean inverted) {
		RSInterface widget = addInterface(id);
		widget.type = TYPE_KEYBINDS_DROPDOWN;
		widget.dropdown = new DropdownMenu(width, true, defaultOption, options, menuItem);
		widget.atActionType = AT_ACTION_TYPE_OPTION_DROPDOWN;
		widget.inverted = inverted;
	}

	public static void keybinding(TextDrawingArea[] tda) {
		RSInterface tab = addTabInterface(53000);

		addSettingsSprite(53001, 63);
		addText(53002, "Keybinding", tda, 2, 0xff8a1f, false, true);
		closeButton(53003, 83, 84);

		hoverButton(Keybinding.RESTORE_DEFAULT, "Restore Defaults", 80, 81, "Restore Defaults", rsFont, 0xff8a1f,
				0xff8a1f, true);

		addText(53005, "Esc closes current interface", tda, 1, 0xff8a1f, false, true);
		configButton(Keybinding.ESCAPE_CONFIG, "Select", 62, 61);

		tab.totalChildren(48);
		int childNum = 0;

		setBounds(53001, 5, 17, childNum++, tab);
		setBounds(53002, 221, 27, childNum++, tab);
		setBounds(39021, 479, 24, childNum++, tab);
		setBounds(Keybinding.RESTORE_DEFAULT, 343, 275, childNum++, tab);
		setBounds(53005, 59, 284, childNum++, tab);
		setBounds(Keybinding.ESCAPE_CONFIG, 35, 285, childNum++, tab);

		/* Tabs and dropdowns */

		int x = 31;
		int y = 63;
		childNum = 47;

		for (int i = 0; i < 14; i++, y += 43) {

			addSettingsSprite(53007 + 3 * i, 64 + i);
			configButton(53008 + 3 * i, "", 79, 78);

			boolean inverted = i == 3 || i == 4 || i == 8 || i == 9 || i == 13;
			keybindingDropdown(53009 + 3 * i, 86, 0, Keybinding.OPTIONS, new KeybindingMenu(), inverted);

			setBounds(Keybinding.MIN_FRAME - 2 + 3 * i, x + stoneOffset(64 + i, true), y + stoneOffset(64 + i, false),
					childNum--, tab);
			setBounds(Keybinding.MIN_FRAME - 1 + 3 * i, x, y, childNum--, tab);
			setBounds(Keybinding.MIN_FRAME + 3 * i, x + 39, y + 4, childNum--, tab);

			if (i == 4 || i == 9) {
				x += 160;
				y = 20;
			}
		}
	}

	public static int stoneOffset(int spriteId, boolean xOffset) {
		Sprite stone = Client.cacheSprite3[79];
		Sprite icon = Client.cacheSprite3[spriteId];

		if (xOffset) {
			return (stone.myWidth / 2) - icon.myWidth / 2;
		}
		return (stone.myHeight / 2) - icon.myHeight / 2;
	}

	public static void clanChatSetup(TextDrawingArea[] tda) {
		RSInterface rsi = addInterface(18300);
		rsi.totalChildren(12 + 15);
		int count = 0;
		/* Background */
		addSprite(18301, 1, "/Interfaces/Clan Chat/sprite");
		rsi.child(count++, 18301, 14, 18);
		/* Close button */
		addButton(18302, 0, "/Interfaces/Clan Chat/close", "Close");
		interfaceCache[18302].atActionType = 3;
		rsi.child(count++, 18302, 475, 26);
		/* Clan Setup title */
		addText(18303, "Clan Setup", tda, 2, 0xFF981F, true, true);
		rsi.child(count++, 18303, 256, 26);
		/* Setup buttons */
		String[] titles = { "Clan name:", "Who can enter chat?", "Who can talk on chat?", "Who can kick on chat?",
				"Who can ban on chat?" };
		String[] defaults = { "Chat Disabled", "Anyone", "Anyone", "Anyone", "Anyone" };
		String[] whoCan = { "Anyone", "Recruit", "Corporal", "Sergeant", "Lieutenant", "Captain", "General",
				"Only Me" };
		for (int index = 0, id = 18304, y = 50; index < titles.length; index++, id += 3, y += 40) {
			addButton(id, 2, "/Interfaces/Clan Chat/sprite", "");
			interfaceCache[id].atActionType = 0;
			if (index > 0) {
				interfaceCache[id].actions = whoCan;
			} else {
				interfaceCache[id].actions = new String[] { "Change title", "Delete clan" };
				;
			}
			addText(id + 1, titles[index], tda, 0, 0xFF981F, true, true);
			addText(id + 2, defaults[index], tda, 1, 0xFFFFFF, true, true);
			rsi.child(count++, id, 25, y);
			rsi.child(count++, id + 1, 100, y + 4);
			rsi.child(count++, id + 2, 100, y + 17);
		}
		/* Table */
		addSprite(18319, 5, "/Interfaces/Clan Chat/sprite");
		rsi.child(count++, 18319, 197, 70);
		/* Labels */
		int id = 18320;
		int y = 74;
		addText(id, "Ranked Members", tda, 2, 0xFF981F, false, true);
		rsi.child(count++, id++, 202, y);
		addText(id, "Banned Members", tda, 2, 0xFF981F, false, true);
		rsi.child(count++, id++, 339, y);
		/* Ranked members list */
		RSInterface list = addInterface(id++);
		int lines = 100;
		list.totalChildren(lines);
		String[] ranks = { "Demote", "Recruit", "Corporal", "Sergeant", "Lieutenant", "Captain", "General", "Owner" };
		list.childY[0] = 2;
		// System.out.println(id);
		for (int index = id; index < id + lines; index++) {
			addText(index, "", tda, 1, 0xffffff, false, true);
			interfaceCache[index].actions = ranks;
			list.children[index - id] = index;
			list.childX[index - id] = 2;
			list.childY[index - id] = (index - id > 0 ? list.childY[index - id - 1] + 14 : 0);
		}
		id += lines;
		list.width = 119;
		list.height = 210;
		list.scrollMax = 2000;
		rsi.child(count++, list.id, 199, 92);
		/* Banned members list */
		list = addInterface(id++);
		list.totalChildren(lines);
		list.childY[0] = 2;
		// System.out.println(id);
		for (int index = id; index < id + lines; index++) {
			if (index == 18470) {
				index++;
				id++;
			}
			addText(index, "", tda, 1, 0xffffff, false, true);
			interfaceCache[index].actions = new String[] { "Unban" };
			list.children[index - id] = index;
			list.childX[index - id] = 0;
			list.childY[index - id] = (index - id > 0 ? list.childY[index - id - 1] + 14 : 0);
		}
		id += lines;
		list.width = 119;
		list.height = 210;
		list.scrollMax = 2000;
		rsi.child(count++, list.id, 339, 92);
		/* Table info text */
		y = 47;
		addText(id, "You can manage both ranked and banned members here.", tda, 0, 0xFF981F, true, true);
		rsi.child(count++, id++, 337, y);
		addText(id, "Right click on a name to edit the member.", tda, 0, 0xFF981F, true, true);
		rsi.child(count++, id++, 337, y + 11);
		/* Add ranked member button */
		y = 75;
		addButton(id, 0, "/Interfaces/Clan Chat/plus", "Add ranked member");
		interfaceCache[id].atActionType = 5;
		rsi.child(count++, id++, 319, y);
		/* Add banned member button */
		addButton(id, 0, "/Interfaces/Clan Chat/plus", "Add banned member");
		interfaceCache[id].atActionType = 5;
		rsi.child(count++, id++, 459, y);

		/* Hovers */
		int[] clanSetup = { 18302, 18304, 18307, 18310, 18313, 18316, 18526, 18527 };
		String[] names = { "close", "sprite", "sprite", "sprite", "sprite", "sprite", "plus", "plus" };
		int[] ids = { 1, 3, 3, 3, 3, 3, 1, 1 };
		for (int index = 0; index < clanSetup.length; index++) {
			rsi = interfaceCache[clanSetup[index]];
			rsi.disabledHover = imageLoader(ids[index], "/Interfaces/Clan Chat/" + names[index]);
		}
	}

	public static void Pestpanel(TextDrawingArea[] tda) {
		RSInterface RSinterface = addTab(21119);

		addText(21120, "Next Departure:", 0xCCCBCB, false, true, 52, tda, 1);
		addText(21121, "Players Ready:", 0x5BD230, false, true, 52, tda, 1);
		addText(21122, "(Need 5 to 25 players)", 0xDED36A, false, true, 52, tda, 1);
		addText(21123, "Pest Points:", 0x99FFFF, false, true, 52, tda, 1);
		int last = 4;
		RSinterface.children = new int[last];
		RSinterface.childX = new int[last];
		RSinterface.childY = new int[last];

		setBounds(21120, 5, 5, 0, RSinterface);
		setBounds(21121, 5, 20, 1, RSinterface);
		setBounds(21122, 5, 35, 2, RSinterface);
		setBounds(21123, 5, 50, 3, RSinterface);

		RSInterface rsi = interfaceCache[6114] = new RSInterface();
		rsi.type = 4;
		rsi.width = 390;
		rsi.centerText = true;
	}

	public static void Pestpanel2(TextDrawingArea[] tda) {
		RSInterface RSinterface = addInterface(21100);
		addSprite(21101, 0, "Interfaces/Pest Control/PEST1");
		addSprite(21102, 1, "Interfaces/Pest Control/PEST1");
		addSprite(21103, 2, "Interfaces/Pest Control/PEST1");
		addSprite(21104, 3, "Interfaces/Pest Control/PEST1");
		addSprite(21105, 4, "Interfaces/Pest Control/PEST1");
		addSprite(21106, 5, "Interfaces/Pest Control/PEST1");
		addText(21107, "", 0xCC00CC, false, true, 52, tda, 1);
		addText(21108, "", 0x0000FF, false, true, 52, tda, 1);
		addText(21109, "", 0xFFFF44, false, true, 52, tda, 1);
		addText(21110, "", 0xCC0000, false, true, 52, tda, 1);
		addText(21111, "", 0x99FF33, false, true, 52, tda, 1);// w purp
		addText(21112, "", 0x99FF33, false, true, 52, tda, 1);// e blue
		addText(21113, "", 0x99FF33, false, true, 52, tda, 1);// se yel
		addText(21114, "", 0x99FF33, false, true, 52, tda, 1);// sw red
		addText(21115, "200", 0x99FF33, false, true, 52, tda, 1);// attacks
		addText(21116, "", 0x99FF33, false, true, 52, tda, 1);// knights hp
		addText(21117, "Time Remaining:", 0xFFFFFF, false, true, 52, tda, 0);
		addText(21118, "", 0xFFFFFF, false, true, 52, tda, 0);
		int last = 18;
		RSinterface.children = new int[last];
		RSinterface.childX = new int[last];
		RSinterface.childY = new int[last];
		setBounds(21101, 361, 27, 0, RSinterface);
		setBounds(21102, 396, 27, 1, RSinterface);
		setBounds(21103, 436, 27, 2, RSinterface);
		setBounds(21104, 474, 27, 3, RSinterface);
		setBounds(21105, 3, 21, 4, RSinterface);
		setBounds(21106, 3, 50, 5, RSinterface);
		setBounds(21107, 371, 60, 6, RSinterface);
		setBounds(21108, 409, 60, 7, RSinterface);
		setBounds(21109, 443, 60, 8, RSinterface);
		setBounds(21110, 479, 60, 9, RSinterface);
		setBounds(21111, 362, 14, 10, RSinterface);
		setBounds(21112, 398, 14, 11, RSinterface);
		setBounds(21113, 436, 14, 12, RSinterface);
		setBounds(21114, 475, 14, 13, RSinterface);
		setBounds(21115, 32, 32, 14, RSinterface);
		setBounds(21116, 32, 62, 15, RSinterface);
		setBounds(21117, 8, 88, 16, RSinterface);
		setBounds(21118, 87, 88, 17, RSinterface);
	}

	public static void godWars(TextDrawingArea[] tda) {
		RSInterface rsinterface = addTabInterface(16210);
		addText(16211, "NPC killcount", tda, 0, 0xff9040, true, true);
		addText(16212, "Armadyl kills", tda, 0, 0xff9040, true, true);
		addText(16213, "Bandos kills", tda, 0, 0xff9040, true, true);
		addText(16214, "Saradomin kills", tda, 0, 0xff9040, true, true);
		addText(16215, "Zamorak kills", tda, 0, 0xff9040, true, true);
		addText(16216, "Ancient kills", tda, 0, 0xff9040, true, true);
		addText(16217, "0", tda, 0, 0x66FFFF, true, true);// armadyl
		addText(16218, "0", tda, 0, 0x66FFFF, true, true);// bandos
		addText(16219, "0", tda, 0, 0x66FFFF, true, true);// saradomin
		addText(16220, "0", tda, 0, 0x66FFFF, true, true);// zamorak
		addText(16221, "0", tda, 0, 0x66FFFF, true, true);// ancient
		rsinterface.scrollMax = 0;
		rsinterface.children = new int[11];
		rsinterface.childX = new int[11];
		rsinterface.childY = new int[11];
		rsinterface.children[0] = 16211;
		rsinterface.childX[0] = -52 + 375 + 30;
		rsinterface.childY[0] = 7;
		rsinterface.children[1] = 16212;
		rsinterface.childX[1] = -52 + 375 + 30;
		rsinterface.childY[1] = 30;
		rsinterface.children[2] = 16213;
		rsinterface.childX[2] = -52 + 375 + 30;
		rsinterface.childY[2] = 44;
		rsinterface.children[3] = 16214;
		rsinterface.childX[3] = -52 + 375 + 30;
		rsinterface.childY[3] = 58;
		rsinterface.children[4] = 16215;
		rsinterface.childX[4] = -52 + 375 + 30;
		rsinterface.childY[4] = 73;
		rsinterface.children[5] = 16216;
		rsinterface.childX[5] = -52 + 460 + 60;
		rsinterface.childY[5] = 31;
		rsinterface.children[6] = 16217;
		rsinterface.childX[6] = -52 + 460 + 60;
		rsinterface.childY[6] = 45;
		rsinterface.children[7] = 16218;
		rsinterface.childX[7] = -52 + 460 + 60;
		rsinterface.childY[7] = 59;
		rsinterface.children[8] = 16219;
		rsinterface.childX[8] = -52 + 460 + 60;
		rsinterface.childY[8] = 74;
		rsinterface.children[9] = 16220;
		rsinterface.childX[9] = -52 + 460 + 60;
		rsinterface.childY[9] = 97;
		rsinterface.children[10] = 16221;
		rsinterface.childX[10] = -52 + 460 + 60;
		rsinterface.childY[10] = 104;
	}

	public static final int BEGIN_READING_PRAYER_INTERFACE = 6;// Amount of total custom prayers we've added
	public static final int CUSTOM_PRAYER_HOVERS = 3; // Amount of custom prayer hovers we've added

	public static final int TYPE_SPRITE = 5;

	public static void addPrayerHover(TextDrawingArea[] tda, int idx, int ID, String hover, int xOffset, int yOffset) {
		// Adding hover box
		RSInterface p = addTabInterface(ID);
		p.inventoryhover = true;
		p.parentID = 5608;
		p.type = 8;
		p.width = 40;
		p.height = 32;
		p.hoverText = p.message = hover;
		p.textDrawingAreas = tda[idx];
		p.hoverXOffset = xOffset;
		p.hoverYOffset = yOffset;
		p.regularHoverBox = true;
	}

	public static void prayerBook(TextDrawingArea[] tda) {
		RSInterface tab = addTabInterface(15608);
		tab.totalChildren(10);
		RSInterface prayerBook = interfaceCache[5608];

		// Switches the Chivalry & Piety positions.
		/** Chivalry **/
		int xMinus = 1;
		int minusX = 37;
		prayerBook.childX[50] = 41 - minusX;
		prayerBook.childY[50] = 195 - xMinus;
		prayerBook.childX[51] = 48 - minusX;
		prayerBook.childY[51] = 197 - xMinus;
		prayerBook.childX[63] = 41 - minusX;
		prayerBook.childY[63] = 200 - xMinus;

		/** Piety **/
		prayerBook.childX[52] = 41;
		prayerBook.childY[52] = 195 - xMinus;
		prayerBook.childX[53] = 43;
		prayerBook.childY[53] = 206 - xMinus;
		prayerBook.childX[64] = 48;
		prayerBook.childY[64] = 197 - xMinus;

		addPrayer(39401, 0, 708, 55, 26, "Preserve");
		addPrayer(39404, 0, 710, 74, 27, "Rigour");
		addPrayer(39407, 0, 712, 77, 28, "Augury");
		addPrayerHover(tda, 1, 39409,
				"Level 77\\nAugury\\nIncreases your Magic attack\\nby 25% and your defence by\\n25%", -110, -100);
		addPrayerHover(tda, 1, 39403, "Level 55\\nPreserve\\nBoosted stats last 20%\nlonger.", -135, -60);
		addPrayerHover(tda, 1, 39406,
				"Level 74\\nRigour\\nIncreases your Ranged attack\\nby 20% and damage by 23%,\\nand your defence by 25%",
				-70, -100);
		setBounds(39401, 152, 158 - xMinus, 0, tab);
		setBounds(39404, 78, 195 - xMinus, 1, tab);
		setBounds(39407, 115, 195 - xMinus, 2, tab);
		setBounds(39402, 154, 158 - xMinus, 3, tab);
		setBounds(39405, 81, 198 - xMinus, 4, tab);
		setBounds(39408, 118, 198 - xMinus, 5, tab);
		setBounds(5608, 0, 0 - xMinus, 6, tab);
		setBounds(39403, 154, 158 - xMinus, 7, tab);
		setBounds(39406, 84, 198 - xMinus, 8, tab);
		setBounds(39409, 120, 198 - xMinus, 9, tab);
	}

	public static void ancients(TextDrawingArea[] tda) {
		RSInterface p = addTabInterface(838);
		RSInterface rsinterface = interfaceCache[12855];
		// rsinterface.childX[6] = 10;
		rsinterface.childY[22] = 153;
		rsinterface.childX[22] = 18;
		rsinterface.childY[30] = 153;
		rsinterface.childX[30] = 65;
		rsinterface.childY[44] = 153; // ANNAKARL
		rsinterface.childX[44] = 112;
		rsinterface.childY[46] = 180; // GHORROCK
		rsinterface.childX[46] = 65;
		rsinterface.childY[7] = 181; // ICE BARRAGE
		rsinterface.childX[7] = 18;
		rsinterface.childY[15] = 153; // BLOOD BARRAGE
		rsinterface.childX[15] = 152;

		addSpellBig2(34674, 563, 560, 562, 10, 10, 10, 30009, 30009, 30011, 85, "Teleport to Target",
				"Teleports you near your Bounty\\nHunter Target", tda, 9, 7, 5);
		setChildren(3, p);
		setBounds(12855, 0, 0, 0, p);
		setBounds(34674, 150, 123, 1, p);
		setBounds(34675, 5, -5, 2, p);
	}

	public static void configureLunar(TextDrawingArea[] TDA) {
		constructLunar();
		homeTeleport();
		drawRune(30003, 1, "Fire");
		drawRune(30004, 2, "Water");
		drawRune(30005, 3, "Air");
		drawRune(30006, 4, "Earth");
		drawRune(30007, 5, "Mind");
		drawRune(30008, 6, "Body");
		drawRune(30009, 7, "Death");
		drawRune(30010, 8, "Nature");
		drawRune(30011, 9, "Chaos");
		drawRune(30012, 10, "Law");
		drawRune(30013, 11, "Cosmic");
		drawRune(30014, 12, "Blood");
		drawRune(30015, 13, "Soul");
		drawRune(30016, 14, "Astral");
		addLunar3RunesSmallBox(30017, 9075, 554, 555, 0, 4, 3, 30003, 30004, 64, "Bake Pie",
				"Bake pies without a stove", TDA, 0, 16, 2);
		addLunar2RunesSmallBox(30025, 9075, 557, 0, 7, 30006, 65, "Cure Plant", "Cure disease on farming patch", TDA, 1,
				4, 2);
		addLunar3RunesBigBox(30032, 9075, 564, 558, 0, 0, 0, 30013, 30007, 65, "Monster Examine",
				"Detect the combat statistics of a\\nmonster", TDA, 2, 2, 2);
		addLunar3RunesSmallBox(30040, 9075, 564, 556, 0, 0, 1, 30013, 30005, 66, "NPC Contact",
				"Speak with varied NPCs", TDA, 3, 0, 2);
		addLunar3RunesSmallBox(30048, 9075, 563, 557, 0, 0, 9, 30012, 30006, 67, "Cure Other", "Cure poisoned players",
				TDA, 4, 8, 2);
		addLunar3RunesSmallBox(30056, 9075, 555, 554, 0, 2, 0, 30004, 30003, 67, "Humidify",
				"fills certain vessels with water", TDA, 5, 0, 5);
		addLunar3RunesSmallBox(30064, 9075, 563, 557, 1, 0, 1, 30012, 30006, 68, "Moonclan Teleport",
				"Teleports you to moonclan island", TDA, 6, 0, 5);
		addLunar3RunesBigBox(30075, 9075, 563, 557, 1, 0, 3, 30012, 30006, 69, "Tele Groun Moonclan",
				"Teleports players to Moonclan\\nisland", TDA, 7, 0, 5);
		addLunar3RunesSmallBox(30083, 9075, 563, 557, 1, 0, 5, 30012, 30006, 70, "Ourania Teleport",
				"Teleports you to ourania rune altar", TDA, 8, 0, 5);
		addLunar3RunesSmallBox(30091, 9075, 564, 563, 1, 1, 0, 30013, 30012, 70, "Cure Me", "Cures Poison", TDA, 9, 0,
				5);
		addLunar2RunesSmallBox(30099, 9075, 557, 1, 1, 30006, 70, "Hunter Kit", "Get a kit of hunting gear", TDA, 10, 0,
				5);
		addLunar3RunesSmallBox(30106, 9075, 563, 555, 1, 0, 0, 30012, 30004, 71, "Waterbirth Teleport",
				"Teleports you to Waterbirth island", TDA, 11, 0, 5);
		addLunar3RunesBigBox(30114, 9075, 563, 555, 1, 0, 4, 30012, 30004, 72, "Tele Group Waterbirth",
				"Teleports players to Waterbirth\\nisland", TDA, 12, 0, 5);
		addLunar3RunesSmallBox(30122, 9075, 564, 563, 1, 1, 1, 30013, 30012, 73, "Cure Group",
				"Cures Poison on players", TDA, 13, 0, 5);
		addLunar3RunesBigBox(30130, 9075, 564, 559, 1, 1, 4, 30013, 30008, 74, "Stat Spy",
				"Cast on another player to see their\\nskill levels", TDA, 14, 8, 2);
		addLunar3RunesBigBox(30138, 9075, 563, 554, 1, 1, 2, 30012, 30003, 74, "Barbarian Teleport",
				"Teleports you to the Barbarian\\noutpost", TDA, 15, 0, 5);
		addLunar3RunesBigBox(30146, 9075, 563, 554, 1, 1, 5, 30012, 30003, 75, "Tele Group Barbarian",
				"Teleports players to the Barbarian\\noutpost", TDA, 16, 0, 5);
		addLunar3RunesSmallBox(30154, 9075, 554, 556, 1, 5, 9, 30003, 30005, 76, "Superglass Make",
				"Make glass without a furnace", TDA, 17, 16, 2);
		addLunar3RunesSmallBox(30162, 9075, 563, 555, 1, 1, 3, 30012, 30004, 77, "Khazard Teleport",
				"Teleports you to Port khazard", TDA, 18, 0, 5);
		addLunar3RunesSmallBox(30170, 9075, 563, 555, 1, 1, 7, 30012, 30004, 78, "Tele Group Khazard",
				"Teleports players to Port khazard", TDA, 19, 0, 5);
		addLunar3RunesBigBox(30178, 9075, 564, 559, 1, 0, 4, 30013, 30008, 78, "Dream",
				"Take a rest and restore hitpoints 3\\n times faster", TDA, 20, 0, 5);
		addLunar3RunesSmallBox(30186, 9075, 557, 555, 1, 9, 4, 30006, 30004, 79, "String Jewellery",
				"String amulets without wool", TDA, 21, 0, 5);
		addLunar3RunesLargeBox(30194, 9075, 557, 555, 1, 9, 9, 30006, 30004, 80, "Stat Restore Pot\\nShare",
				"Share a potion with up to 4 nearby\\nplayers", TDA, 22, 0, 5);
		addLunar3RunesSmallBox(30202, 9075, 554, 555, 1, 6, 6, 30003, 30004, 81, "Magic Imbue",
				"Combine runes without a talisman", TDA, 23, 0, 5);
		addLunar3RunesBigBox(30210, 9075, 561, 557, 2, 1, 14, 30010, 30006, 82, "Fertile Soil",
				"Fertilise a farming patch with super\\ncompost", TDA, 24, 4, 2);
		addLunar3RunesBigBox(30218, 9075, 557, 555, 2, 11, 9, 30006, 30004, 83, "Boost Potion Share",
				"Shares a potion with up to 4 nearby\\nplayers", TDA, 25, 0, 5);
		addLunar3RunesSmallBox(30226, 9075, 563, 555, 2, 2, 9, 30012, 30004, 84, "Fishing Guild Teleport",
				"Teleports you to the fishing guild", TDA, 26, 0, 5);
		addSpellBig2(30234, 563, 560, 562, 1, 1, 1, 30009, 30012, 30004, 84, "Teleport to Target",
				"Teleports you near your Bounty\\nHunter Target", TDA, 9, 7, 5);
		addLunar3RunesSmallBox(30242, 9075, 557, 561, 2, 14, 0, 30006, 30010, 85, "Plank Make", "Turn Logs into planks",
				TDA, 28, 16, 5);
		/******** Cut Off Limit **********/
		addLunar3RunesSmallBox(30250, 9075, 563, 555, 2, 2, 9, 30012, 30004, 86, "Catherby Teleport",
				"Teleports you to Catherby", TDA, 29, 0, 5);
		addLunar3RunesSmallBox(30258, 9075, 563, 555, 2, 2, 14, 30012, 30004, 87, "Tele Group Catherby",
				"Teleports players to Catherby", TDA, 30, 0, 5);
		addLunar3RunesSmallBox(30266, 9075, 563, 555, 2, 2, 7, 30012, 30004, 88, "Ice Plateau Teleport",
				"Teleports you to Ice Plateau", TDA, 31, 0, 5);
		addLunar3RunesBigBox(30274, 9075, 563, 555, 2, 2, 15, 30012, 30004, 89, "Tele Group Ice\\n Plateau",
				"\\nTeleports players to Ice Plateau", TDA, 32, 0, 5);
		addLunar3RunesBigBox(30282, 9075, 563, 561, 2, 1, 0, 30012, 30010, 90, "Energy Transfer",
				"Spend hitpoints and Energy to\\n give another player \\nhitpoints and run energy", TDA, 33, 8, 2);
		addLunar3RunesBigBox(30290, 9075, 563, 565, 2, 2, 0, 30012, 30014, 91, "Heal Other",
				"Transfer up to 75% of hitpoints\\n to another player", TDA, 34, 8, 2);
		addLunar3RunesBigBox(30298, 9075, 560, 557, 2, 1, 9, 30009, 30006, 92, "Vengeance Other",
				"Allows another player to rebound\\ndamage to an opponent", TDA, 35, 8, 2);
		addLunar3RunesSmallBox(30306, 9075, 560, 557, 3, 1, 9, 30009, 30006, 93, "Vengeance",
				"Rebound damage to an opponent", TDA, 36, 0, 5);
		addLunar3RunesBigBox(30314, 9075, 565, 563, 3, 2, 5, 30014, 30012, 94, "Heal Group",
				"Transfer up to 75% of hitpoints to a group", TDA, 37, 0, 5);
		addLunar3RunesBigBox(30322, 9075, 564, 563, 2, 1, 0, 30013, 30012, 95, "Spellbook Swap",
				"Change to another spellbook for 1\\nspell cast", TDA, 38, 0, 5);
	}

	public static void constructLunar() {
		RSInterface Interface = addInterface(29999);
		setChildren(80, Interface); // 71
		int[] Cid = { 30000, 30017, 30025, 30032, 30040, 30048, 30056, 30064, 30075, 30083, 30091, 30099, 30106, 30114,
				30122, 30130, 30138, 30146, 30154, 30162, 30170, 30178, 30186, 30194, 30202, 30210, 30218, 30226, 30234,
				30242, 30250, 30258, 30266, 30274, 30282, 30290, 30298, 30306, 30314, 30322, 30001, 30018, 30026, 30033,
				30041, 30049, 30057, 30065, 30076, 30084, 30092, 30100, 30107, 30115, 30123, 30131, 30139, 30147, 30155,
				30163, 30171, 30179, 30187, 30195, 30203, 30211, 30219, 30227, 30235, 30243, 30251, 30259, 30267, 30275,
				30283, 30291, 30299, 30307, 30315, 30323 };

		int[] xCord = { 11, 40, 71, 103, 135, 165, 8, 39, 71, 103, 135, 165, 12, 42, 71, 103, 135, 165, 14, 42, 71, 101,
				135, 168, 11, 42, 74, 103, 135, 164, 10, 42, 71, 103, 136, 165, 13, 42, 71, 104, 6, 5, 5, 5, 5, 5, 5, 5,
				5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5 };

		int[] yCord = { 9, 9, 12, 10, 12, 10, 39, 39, 39, 39, 39, 37, 68, 68, 68, 68, 68, 68, 97, 97, 97, 97, 98, 98,
				125, 124, 125, 125, 125, 126, 155, 155, 155, 155, 155, 155, 185, 185, 184, 184, 184, 176, 176, 163, 176,
				176, 176, 176, 163, 176, 176, 176, 176, 163, 176, 163, 163, 163, 176, 176, 176, 163, 176, 149, 176, 163,
				163, 176, 149, 176, 176, 176, 176, 176, 9, 9, 9, 9, 9, 9 };

		for (int i = 0; i < Cid.length; i++) {
			setBounds(Cid[i], xCord[i], yCord[i], i, Interface);
		}
	}

	public static void emoteTab() {
		RSInterface tab = addTabInterface(147);
		RSInterface scroll = addTabInterface(148);
		tab.totalChildren(1);
		tab.child(0, 148, 0, 1);
		addButton(168, 0, "Emotes/EMOTE", "Yes");
		addButton(169, 1, "Emotes/EMOTE", "No");
		addButton(164, 2, "Emotes/EMOTE", "Bow");
		addButton(165, 3, "Emotes/EMOTE", "Angry");
		addButton(162, 4, "Emotes/EMOTE", "Think");
		addButton(163, 5, "Emotes/EMOTE", "Wave");
		addButton(13370, 6, "Emotes/EMOTE", "Shrug");
		addButton(171, 7, "Emotes/EMOTE", "Cheer");
		addButton(167, 8, "Emotes/EMOTE", "Beckon");
		addButton(170, 9, "Emotes/EMOTE", "Laugh");
		addButton(13366, 10, "Emotes/EMOTE", "Jump for Joy");
		addButton(13368, 11, "Emotes/EMOTE", "Yawn");
		addButton(166, 12, "Emotes/EMOTE", "Dance");
		addButton(13363, 13, "Emotes/EMOTE", "Jig");
		addButton(13364, 14, "Emotes/EMOTE", "Spin");
		addButton(13365, 15, "Emotes/EMOTE", "Headbang");
		addButton(161, 16, "Emotes/EMOTE", "Cry");
		addButton(11100, 17, "Emotes/EMOTE", "Blow kiss");
		addButton(13362, 18, "Emotes/EMOTE", "Panic");
		addButton(13367, 19, "Emotes/EMOTE", "Raspberry");
		addButton(172, 20, "Emotes/EMOTE", "Clap");
		addButton(13369, 21, "Emotes/EMOTE", "Salute");
		addButton(13383, 22, "Emotes/EMOTE", "Goblin Bow");
		addButton(13384, 23, "Emotes/EMOTE", "Goblin Salute");
		addButton(667, 24, "Emotes/EMOTE", "Glass Box");
		addButton(6503, 25, "Emotes/EMOTE", "Climb Rope");
		addButton(6506, 26, "Emotes/EMOTE", "Lean On Air");
		addButton(666, 27, "Emotes/EMOTE", "Glass Wall");
		addButton(18464, 28, "Emotes/EMOTE", "Zombie Walk");
		addButton(18465, 29, "Emotes/EMOTE", "Zombie Dance");
		addButton(15166, 30, "Emotes/EMOTE", "Scared");
		addButton(18686, 31, "Emotes/EMOTE", "Rabbit Hop");
		addConfigButton(154, 147, 32, 33, "Emotes/EMOTE", 41, 47, "Skillcape Emote", 0, 1, 700);
		scroll.totalChildren(33);
		scroll.child(0, 168, 10, 7);
		scroll.child(1, 169, 54, 7);
		scroll.child(2, 164, 98, 14);
		scroll.child(3, 165, 137, 7);
		scroll.child(4, 162, 9, 56);
		scroll.child(5, 163, 48, 56);
		scroll.child(6, 13370, 95, 56);
		scroll.child(7, 171, 137, 56);
		scroll.child(8, 167, 7, 105);
		scroll.child(9, 170, 51, 105);
		scroll.child(10, 13366, 95, 104);
		scroll.child(11, 13368, 139, 105);
		scroll.child(12, 166, 6, 154);
		scroll.child(13, 13363, 50, 154);
		scroll.child(14, 13364, 90, 154);
		scroll.child(15, 13365, 135, 154);
		scroll.child(16, 161, 8, 204);
		scroll.child(17, 11100, 51, 203);
		scroll.child(18, 13362, 99, 204);
		scroll.child(19, 13367, 137, 203);
		scroll.child(20, 172, 10, 253);
		scroll.child(21, 13369, 53, 253);
		scroll.child(22, 13383, 88, 258);
		scroll.child(23, 13384, 138, 252);
		scroll.child(24, 667, 2, 303);
		scroll.child(25, 6503, 49, 302);
		scroll.child(26, 6506, 93, 302);
		scroll.child(27, 666, 137, 302);
		scroll.child(28, 18464, 9, 352);
		scroll.child(29, 18465, 50, 352);
		scroll.child(30, 15166, 94, 356);
		scroll.child(31, 18686, 141, 353);
		scroll.child(32, 154, 5, 401);
		scroll.width = 173;
		scroll.height = 258;
		scroll.scrollMax = 450;
	}

	public static void createInterface(int id) {
		RSInterface rsi = interfaceCache[id] = new RSInterface();
	}

	public static void addHoverButton_sprite_loader(int i, int spriteId, int width, int height, String text,
			int contentType, int hoverOver, int aT) {// hoverable
		// button
		RSInterface tab = addTabInterface(i);
		tab.id = i;
		tab.parentID = i;
		tab.type = 5;
		tab.atActionType = aT;
		tab.contentType = contentType;
		tab.opacity = 0;
		tab.hoverType = hoverOver;
		tab.sprite1 = Client.cacheSprite1[spriteId];
		tab.sprite2 = Client.cacheSprite1[spriteId];
		tab.width = width;
		tab.height = height;
		tab.tooltip = text;
	}

	public static void addHoveredButton_sprite_loader(int i, int spriteId, int w, int h, int IMAGEID) {// hoverable
		// button
		RSInterface tab = addTabInterface(i);
		tab.parentID = i;
		tab.id = i;
		tab.type = 0;
		tab.atActionType = 0;
		tab.width = w;
		tab.height = h;
		tab.isMouseoverTriggered = true;
		tab.opacity = 0;
		tab.hoverType = -1;
		tab.scrollMax = 0;
		addHoverImage_sprite_loader(IMAGEID, spriteId);
		tab.totalChildren(1);
		tab.child(0, IMAGEID, 0, 0);
	}

	public static void addSprite3(int childId, int spriteId) {
		RSInterface rsi = interfaceCache[childId] = new RSInterface();
		rsi.id = childId;
		rsi.parentID = childId;
		rsi.type = 5;
		rsi.atActionType = 0;
		rsi.contentType = 0;
		rsi.sprite1 = Client.cacheSprite3[spriteId];
		rsi.sprite2 = Client.cacheSprite3[spriteId];
		rsi.width = rsi.sprite1.myWidth;
		rsi.height = rsi.sprite2.myHeight - 2;
	}

	public static void addButton(int id, int sid, String tooltip) {
		RSInterface tab = interfaceCache[id] = new RSInterface();
		tab.id = id;
		tab.parentID = id;
		tab.type = 5;
		tab.atActionType = 1;
		tab.contentType = 0;
		tab.opacity = (byte) 0;
		tab.hoverType = 52;
		tab.sprite1 = Client.cacheSprite1[sid];// imageLoader(sid, spriteName);
		tab.sprite2 = Client.cacheSprite1[sid];// imageLoader(sid, spriteName);
		tab.width = tab.sprite1.myWidth;
		tab.height = tab.sprite1.myHeight;
		tab.tooltip = tooltip;
	}

	public static void addHoverImage_sprite_loader(int i, int spriteId) {
		RSInterface tab = addTabInterface(i);
		tab.id = i;
		tab.parentID = i;
		tab.type = 5;
		tab.atActionType = 0;
		tab.contentType = 0;
		tab.width = 512;
		tab.height = 334;
		tab.opacity = 0;
		tab.hoverType = 52;
		tab.sprite1 = Client.cacheSprite1[spriteId];
		tab.sprite2 = Client.cacheSprite1[spriteId];
	}

	public static void addHoverImage_sprite_loader3(int i, int spriteId) {
		RSInterface tab = addTabInterface(i);
		tab.id = i;
		tab.parentID = i;
		tab.type = 5;
		tab.atActionType = 0;
		tab.contentType = 0;
		tab.width = 512;
		tab.height = 334;
		tab.opacity = 0;
		tab.hoverType = 52;
		tab.sprite1 = Client.cacheSprite3[spriteId];
		tab.sprite2 = Client.cacheSprite3[spriteId];
	}

	public static void addHoveredButton_sprite_loader3(int i, int spriteId, int w, int h, int IMAGEID) {// hoverable
		// button
		RSInterface tab = addTabInterface(i);
		tab.parentID = i;
		tab.id = i;
		tab.type = 0;
		tab.atActionType = 0;
		tab.width = w;
		tab.height = h;
		tab.isMouseoverTriggered = true;
		tab.opacity = 0;
		tab.hoverType = -1;
		tab.scrollMax = 0;
		addHoverImage_sprite_loader3(IMAGEID, spriteId);
		tab.totalChildren(1);
		tab.child(0, IMAGEID, 0, 0);
	}

	public static void addHoverButton_sprite_loader3(int i, int spriteId, int width, int height, String text,
			int contentType, int hoverOver, int aT) {// hoverable
		// button
		RSInterface tab = addTabInterface(i);
		tab.id = i;
		tab.parentID = i;
		tab.type = 5;
		tab.atActionType = aT;
		tab.contentType = contentType;
		tab.opacity = 0;
		tab.hoverType = hoverOver;
		tab.sprite1 = Client.cacheSprite3[spriteId];
		tab.sprite2 = Client.cacheSprite3[spriteId];
		tab.width = width;
		tab.height = height;
		tab.tooltip = text;
	}

	public static void equipmentTab(TextDrawingArea[] wid) {
		RSInterface Interface = interfaceCache[1644];
		addSprite(15101, 0, "Interfaces/Equipment/bl");// cheap hax
		addSprite(15102, 1, "Interfaces/Equipment/bl");// cheap hax
		addSprite(15109, 2, "Interfaces/Equipment/bl");// cheap hax
		createInterface(21338);
		createInterface(21344);
		createInterface(21342);
		createInterface(21341);
		createInterface(21340);
		createInterface(15103);
		createInterface(15104);
		Interface.children[24] = 15102;
		Interface.childX[24] = 110;
		Interface.childY[24] = 205;
		Interface.children[25] = 15109;
		Interface.childX[25] = 39;
		Interface.childY[25] = 240;
		Interface.children[26] = 27650;
		Interface.childX[26] = 0;
		Interface.childY[26] = 0;
		Interface = addInterface(27650);
		
		addHoverButton(27651, "/Equipment/SPRITE", 6, 40, 40, "Price-checker", 550, 27652, 5);
		addHoveredButton(27652, "/Equipment/SPRITE", 7, 40, 40, 27658);
		
		addHoverButton(27653, "/Equipment/SPRITE", 8, 40, 40, "Show Equipment Stats", 550, 27655, 5);
		addHoveredButton(27655, "/Equipment/SPRITE", 9, 40, 40, 27665);

		addHoverButton(27654, "/Equipment/SPRITE", 10, 40, 40, "Show items kept on death", -1, 27657, 1);
		addHoveredButton(27657, "/Equipment/SPRITE", 11, 40, 40, 27666);
		
		addHoverButton(27660, "/Equipment/SPRITE", 12, 40, 40, "Call follower", -1, 27661, 1);
		addHoveredButton(27661, "/Equipment/SPRITE", 13, 40, 40, 27662);

		setChildren(8, Interface);
		setBounds(27651, 53, 205, 0, Interface);
		setBounds(27652, 53, 205, 1, Interface);
		setBounds(27653, 8, 205, 2, Interface);
		setBounds(27654, 98, 205, 3, Interface);
		setBounds(27655, 8, 205, 4, Interface);
		setBounds(27657, 98, 205, 5, Interface);

		setBounds(27660, 98 + 45, 205, 6, Interface);
		setBounds(27661, 98 + 45, 205, 7, Interface);
	}

	public static void itemsOnDeath(TextDrawingArea[] wid) {
		RSInterface rsinterface = addInterface(17100);
		addSprite(17101, new Sprite("Equipment/SPRITE 2"));

		addHover(17102, 3, 0, 10601, 1, "Interfaces/Equipment/SPRITE", 17, 17, "Close Window");
		addHovered(10601, 3, "Interfaces/Equipment/SPRITE", 17, 17, 10602);
		addText(17103, "Items Kept On Death", wid, 2, 0xff981f);
		addText(17104, "Items you will keep:", wid, 1, 0xff981f);
		addText(17105, "Items you will lose:", wid, 1, 0xff981f);
		addText(17106, "On unsafe death:", wid, 1, 0xff981f);
		addText(17107, "Max items kept on death:", wid, 1, 0xffcc33);
		addText(17108, "", wid, 1, 0xffcc33);
		rsinterface.scrollMax = 0;
		rsinterface.isMouseoverTriggered = false;
		rsinterface.children = new int[12];
		rsinterface.childX = new int[12];
		rsinterface.childY = new int[12];

		rsinterface.children[0] = 17101;
		rsinterface.childX[0] = 7;
		rsinterface.childY[0] = 8;
		rsinterface.children[1] = 17102;
		rsinterface.childX[1] = 480;
		rsinterface.childY[1] = 17;
		rsinterface.children[2] = 17103;
		rsinterface.childX[2] = 185;
		rsinterface.childY[2] = 18;
		rsinterface.children[3] = 17104;
		rsinterface.childX[3] = 22;
		rsinterface.childY[3] = 50;
		rsinterface.children[4] = 17105;
		rsinterface.childX[4] = 22;
		rsinterface.childY[4] = 110;
		rsinterface.children[5] = 17106;
		rsinterface.childX[5] = 347;
		rsinterface.childY[5] = 47;
		rsinterface.children[6] = 17107;
		rsinterface.childX[6] = 349;
		rsinterface.childY[6] = 270;
		rsinterface.children[7] = 17108;
		rsinterface.childX[7] = 398;
		rsinterface.childY[7] = 298;
		rsinterface.children[8] = 17115;
		rsinterface.childX[8] = 348;
		rsinterface.childY[8] = 64;
		rsinterface.children[9] = 10494;
		rsinterface.childX[9] = 26;
		rsinterface.childY[9] = 74;
		rsinterface.children[10] = 10600;
		rsinterface.childX[10] = 26;
		rsinterface.childY[10] = 133;
		rsinterface.children[11] = 10601;
		rsinterface.childX[11] = 480;
		rsinterface.childY[11] = 17;
		interfaceCache[10494].invSpritePadX = 8;
		interfaceCache[10600].invSpritePadX = 6;
		interfaceCache[10600].invSpritePadY = 6;
		itemsOnDeathDATA(wid);
	}

	public static void itemsOnDeathDATA(TextDrawingArea[] wid) {
		RSInterface rsinterface = addInterface(17115);

		rsinterface.parentID = 17115;
		rsinterface.id = 17115;
		rsinterface.type = 0;
		rsinterface.atActionType = 0;
		rsinterface.contentType = 0;
		rsinterface.width = 130;
		rsinterface.height = 197;
		rsinterface.aByte254 = 0;
		rsinterface.mOverInterToTrigger = -1;
		rsinterface.scrollMax = 199;
		rsinterface.totalChildren(1);
		addStringContainer(17109, 17115, Client.instance.newSmallFont,
				false, RSInterface.DEFAULT_TEXT_COLOR, true, 12, "testingy");
		rsinterface.child(0, 17109, 0, 16);

	}

	public static void clanChatTab(TextDrawingArea[] tda) {
		RSInterface tab = addTabInterface(18128);
		addHoverButton(18129, "/Clan Chat/SPRITE", 6, 72, 32, "Join Clan", 550, 18130, 5);
		addHoveredButton(18130, "/Clan Chat/SPRITE", 7, 72, 32, 18131);
		addHoverButton(18132, "/Clan Chat/SPRITE", 6, 72, 32, "Clan Setup", -1, 18133, 5);
		addHoveredButton(18133, "/Clan Chat/SPRITE", 7, 72, 32, 18134);
		addText(18135, "Join Clan", tda, 0, 0xff9b00, true, true);
		addText(18136, "Clan Setup", tda, 0, 0xff9b00, true, true);
		addSprite(18137, 37, "/Clan Chat/SPRITE");
		addText(18138, "Clan Chat", tda, 1, 0xff9b00, true, true);
		addText(18139, "Talking in: Not in clan", tda, 0, 0xff9b00, false, true);
		addText(18140, "Owner: None", tda, 0, 0xff9b00, false, true);
		addSprite(16126, 4, "/Clan Chat/SPRITE");
		tab.totalChildren(13);
		tab.child(0, 16126, 0, 221);
		tab.child(1, 16126, 0, 59);
		tab.child(2, 18137, 0, 62);
		tab.child(3, 18143, 0, 62);
		tab.child(4, 18129, 15, 226);
		tab.child(5, 18130, 15, 226);
		tab.child(6, 18132, 103, 226);
		tab.child(7, 18133, 103, 226);
		tab.child(8, 18135, 51, 237);
		tab.child(9, 18136, 139, 237);
		tab.child(10, 18138, 95, 1);
		tab.child(11, 18139, 10, 23);
		tab.child(12, 18140, 25, 38);
		/* Text area */
		RSInterface list = addTabInterface(18143);
		list.totalChildren(100);
		for (int i = 18144; i <= 18244; i++) {
			addText(i, "", tda, 0, 0xffffff, false, true);
		}
		for (int id = 18144, i = 0; id <= 18243 && i <= 99; id++, i++) {
			interfaceCache[id].actions = new String[] { "Edit Rank", "Kick", "Ban" };
			list.children[i] = id;
			list.childX[i] = 5;
			for (int id2 = 18144, i2 = 1; id2 <= 18243 && i2 <= 99; id2++, i2++) {
				list.childY[0] = 2;
				list.childY[i2] = list.childY[i2 - 1] + 14;
			}
		}
		list.height = 158;
		list.width = 174;
		list.scrollMax = 1405;
	}

	public static void cataTele(TextDrawingArea[] tda) {
		RSInterface inter = addInterface(33900);
		addSprite(33901, 0, "Interfaces/Prestige/SPRITE");
		addText(33902, "Catacombs Teleports", tda, 2, 0xff9933, true, true);
		addClickableText(33903, "1. Abyssal Demon", "Teleport", tda, 1, 0xff9933, false, true, 130);
		addClickableText(33904, "2. Ankou", "Teleport", tda, 1, 0xff9933, false, true, 130);
		addClickableText(33905, "3. Black Demons", "Teleport", tda, 1, 0xff9933, false, true, 130);
		addClickableText(33906, "4. Bronze Dragon", "Teleport", tda, 1, 0xff9933, false, true, 130);
		addClickableText(33907, "5. Brutal Black Dragon", "Teleport", tda, 1, 0xff9933, false, true, 130);
		addClickableText(33908, "6. Brutal Blue Dragon", "Teleport", tda, 1, 0xff9933, false, true, 130);
		addClickableText(33909, "7. Brutal Red Dragon", "Teleport", tda, 1, 0xff9933, false, true, 130);
		addClickableText(33910, "8. Cyclops", "Teleport", tda, 1, 0xff9933, false, true, 130);
		addClickableText(33911, "9. Dagannoth", "Teleport", tda, 1, 0xff9933, false, true, 130);
		addClickableText(33912, "10. Dust Devil", "Teleport", tda, 1, 0xff9933, false, true, 130);
		addClickableText(33913, "11. Deviant Spectre", "Teleport", tda, 1, 0xff9933, false, true, 130);
		addClickableText(33914, "12. Fire Giant", "Teleport", tda, 1, 0xff9933, false, true,130);
		addClickableText(33915, "13. Ghost", "Teleport", tda, 1, 0xff9933, false, true, 130);
		addClickableText(33916, "14. Greater Demon", "Teleport", tda, 1, 0xff9933, false, true, 130);
		addClickableText(33917, "15. Greater Nechryael", "Teleport", tda, 1, 0xff9933, false, true, 130);
		addClickableText(33918, "16. Hellhound", "Teleport", tda, 1, 0xff9933, false, true, 130);
		addClickableText(33919, "17. Hill Giant", "Teleport", tda, 1, 0xff9933, false, true, 130);
		addClickableText(33920, "18. Iron Dragon", "Teleport", tda, 1, 0xff9933, false, true, 130);
		addClickableText(33921, "19. King Sand Crab", "Teleport", tda, 1, 0xff9933, false, true, 130);
		addClickableText(33922, "20. Magic Axe", "Teleport", tda, 1, 0xff9933, false, true, 130);
		addClickableText(33923, "21. Moss Giant", "Teleport", tda, 1, 0xff9933, false, true, 130);
		addClickableText(33924, "22. Mutated Bloodveld", "Teleport", tda, 1, 0xff9933, false, true, 130);
		addClickableText(33925, "23. Possessed Pickaxe", "Teleport", tda, 1, 0xff9933, false, true, 130);
		addClickableText(33926, "24. Steel Dragon", "Teleport", tda, 1, 0xff9933, false, true, 130);
		addClickableText(33927, "25. Shade", "Teleport", tda, 1, 0xff9933, false, true, 130);
		addClickableText(33928, "26. Skeleton", "Teleport", tda, 1, 0xff9933, false, true, 130);
		addClickableText(33929, "27. Twisted Banshee", "Teleport", tda, 1, 0xff9933, false, true, 130);
		addClickableText(33930, "28. Warped Jelly", "Teleport", tda, 1, 0xff9933, false, true, 130);
		addClickableText(33931, "29. Dark Beast", "Teleport", tda, 1, 0xff9933, false, true, 130);
		addHoverButton(33932, "Interfaces/HelpInterface/IMAGE", 2, 16, 16, "Close", -1, 33932, 3);
		addHoveredButton(33933, "Interfaces/HelpInterface/IMAGE", 3, 16, 16, 33933);

		inter.totalChildren(34);
		setBounds(33901, 15, 15, 0, inter);
		setBounds(33902, 250, 19, 1, inter);
		setBounds(33903, 50, 50, 2, inter);
		setBounds(33904, 50, 70, 3, inter);
		setBounds(33905, 50, 90, 4, inter);
		setBounds(33906, 50, 110, 5, inter);
		setBounds(33907, 50, 130, 6, inter);
		setBounds(33908, 50, 150, 7, inter);
		setBounds(33909, 50, 170, 8, inter);
		setBounds(33910, 50, 190, 9, inter);
		setBounds(33911, 50, 210, 10, inter);
		setBounds(33912, 50, 230, 11, inter);
		setBounds(33913, 200, 50, 12, inter);
		setBounds(33914, 200, 70, 13, inter);
		setBounds(33915, 200, 90, 14, inter);
		setBounds(33916, 200, 110, 15, inter);
		setBounds(33917, 200, 130, 16, inter);
		setBounds(33918, 200, 150, 17, inter);
		setBounds(33919, 200, 170, 18, inter);
		setBounds(33920, 200, 190, 19, inter);
		setBounds(33921, 200, 210, 20, inter);
		setBounds(33922, 200, 230, 21, inter);
		setBounds(33923, 350, 50, 22, inter);
		setBounds(33924, 350, 70, 23, inter);
		setBounds(33925, 350, 90, 24, inter);
		setBounds(33926, 350, 110, 25, inter);
		setBounds(33927, 350, 130, 26, inter);
		setBounds(33928, 350, 150, 27, inter);
		setBounds(33929, 350, 170, 28, inter);
		setBounds(33930, 350, 190, 29, inter);
		setBounds(33931, 350, 210, 30, inter);
		setBounds(33932, 479, 18, 31, inter);
		setBounds(33933, 479, 18, 32, inter);
	}

	public static void groupLeaderboard(TextDrawingArea[] tda) {
		RSInterface inter = addInterface(39900);
		addSprite(39901, 0, "Interfaces/groupleaderboard/background");
		addText(39902, "$3000 GIM Contest Leaderboard", tda, 2, 0xff9933, true, true);
		addHoverButton(39903, "Interfaces/HelpInterface/IMAGE", 2, 16, 16, "Close", -1, 50639, 3);
		addHoveredButton(39904, "Interfaces/HelpInterface/IMAGE", 3, 16, 16, 50640);
		//1st Text Group, top left
		addText(39905, "Collection Log Entries", tda, 1, 0xff9933, true, true);
		addText(39906, "1. Team 1", tda, 0, 0xffffff, true, true);
		addText(39907, "2. Team 2", tda, 0, 0xffffff, true, true);
		addText(39908, "3. Team 3", tda, 0, 0xffffff, true, true);
		//2nd Text Group, top right
		addText(39909, "Pets in Bank", tda, 1, 0xff9933, true, true);
		addText(39910, "1. Team 1", tda, 0, 0xffffff, true, true);
		addText(39911, "2. Team 2", tda, 0, 0xffffff, true, true);
		addText(39912, "3. Team 3", tda, 0, 0xffffff, true, true);
		//3rd Text Group, bottom left
		addText(39913, "Earned Exchange Points", tda, 1, 0xff9933, true, true);
		addText(39914, "1. Team 1", tda, 0, 0xffffff, true, true);
		addText(39915, "2. Team 2", tda, 0, 0xffffff, true, true);
		addText(39916, "3. Team 3", tda, 0, 0xffffff, true, true);
		//4th Text Group, bottom right
		addText(39917, "ToB Completions", tda, 1, 0xff9933, true, true);
		addText(39918, "1. Team 1", tda, 0, 0xffffff, true, true);
		addText(39919, "2. Team 2", tda, 0, 0xffffff, true, true);
		addText(39920, "3. Team 3", tda, 0, 0xffffff, true, true);

		inter.totalChildren(20);
		//window and title
		setBounds(39901, 71, 46, 0, inter);
		setBounds(39902, 253, 55, 1, inter);
		//close
		setBounds(39903, 404, 55, 2, inter);
		setBounds(39904, 404, 55, 3, inter);
		//1st text group, top left
		setBounds(39905, 164, 100, 4, inter);
		setBounds(39906, 164, 120, 5, inter);
		setBounds(39907, 164, 140, 6, inter);
		setBounds(39908, 164, 160, 7, inter);
		//2nd Text Group, top right
		setBounds(39909, 340, 100, 8, inter);
		setBounds(39910, 340, 120, 9, inter);
		setBounds(39911, 340, 140, 10, inter);
		setBounds(39912, 340, 160, 11, inter);
		//3rd Text Group, bottom left
		setBounds(39913, 164, 190, 12, inter);
		setBounds(39914, 164, 210, 13, inter);
		setBounds(39915, 164, 230, 14, inter);
		setBounds(39916, 164, 250, 15, inter);
		//4th Text Group, bottom right
		setBounds(39917, 340, 190, 16, inter);
		setBounds(39918, 340, 210, 17, inter);
		setBounds(39919, 340, 230, 18, inter);
		setBounds(39920, 340, 250, 19, inter);
	}

	public static void groupInformation(TextDrawingArea[] tda) {
		RSInterface inter = addInterface(50635);
		addSprite(50636, 0,"Interfaces/groupinfo/background");
		addText(50637, "Group Information", tda, 2, 0xff9933, true, true);
		addHoverButton(50638, "Interfaces/HelpInterface/IMAGE", 2, 16, 16, "Close", -1, 50639, 3);
		addHoveredButton(50639, "Interfaces/HelpInterface/IMAGE", 3, 16, 16, 50640);
		inter.totalChildren(5);
		//window and title
		setBounds(50636, 140, 50, 0, inter);
		setBounds(50637, 263, 60, 1, inter);
		//close
		setBounds(50638, 359, 60, 2, inter);
		setBounds(50639, 359, 60, 3, inter);

		//scroll window
		setBounds(50641, 147, 85, 4, inter);

		RSInterface scroll = addInterface(50641);
		scroll.width = 214;
		scroll.height = 190;
		scroll.scrollMax = 230;
		setChildren(300, scroll);
		int rows = 8;
		for (int i = 0, n = 0; i < rows * 2; i += 2, n +=1) {
			//ROWS
			if (n % 2 == 0) {
				addSprite(50642 + i, 0, "Interfaces/groupinfo/rows");
			} else {
				addSprite(50642 + i, 1, "Interfaces/groupinfo/rows");
			}
			setBounds(50642 + i, 0, i / 2 * 24, i, scroll);
			//Type Text
			String[] Types = { "Total Level", "Total Xp", "GP Value", "Exchange Points", "Boss Points", "Slayer Points", "PK Points", "Vote Points"};
			String type = "Type";
			if (n < Types.length) {
				type = Types[n];
			}
			addText(50642 + i + 1, type, tda, 0, 0xFF981F, false, true);
			setBounds(50642 + i + 1, 10, 6 + (i / 2 * 24), i + 1, scroll);
			//Value Text
			addLeftText(50665 + i + 1, 0, 0xFFFFFF, "Value" + (1 + i / 2));
			setBounds(50665 + i + 1, 200, 6 + (i / 2 * 24), i + (rows * 2), scroll);
		}

	}

	public static void initializeTitleWidget(TextDrawingArea[] tda) {
		RSInterface widget = addInterface(53501);
		addSprite(53502, 0, "Interfaces/Titles/IMAGE");
		addSprite(53503, 6, "Interfaces/Titles/IMAGE");
		drawRoundedRectangle(53505, 200, 130, 0x000000, (byte) 30, true, true);
		addButton(53506, 1, "Interfaces/Titles/IMAGE", "Close", 3, 52);
		addButton(53508, 7, "Interfaces/Titles/IMAGE", "Ok");
		addText(53511, "Lorem ipsum dolor sit amet,\\n"
						+ "consectetur adipiscing elit,\\n"
						+ "sed do eiusmod tempor incididunt\\n"
						+ "ut labore et dolore magna aliqua.\\n"
						+ "fUt enim ad minim veniam, quis\\n"
						+ "nostrud exercitation ullamco \\n"
						+ "laboris nisi ut aliquip ex ea\\n" + "commodo consequat.",
				tda, 1, 0xFF981F, false, true);
		addText(53512, "Purchase", tda, 1, 0xFF981F, true, true);
		drawRoundedRectangle(53513, 140, 22, 0x000000, (byte) 30, true, true);
		addText(53514, "$", tda, 2, 0xFF981F, false, true);
		addText(53515, "45,000GP", tda, 1, 0xFF981F, false, true);
		addButton(53516, 9, "Interfaces/Titles/IMAGE", "Information");
		addSprites(53517, "Interfaces/Titles/IMAGE", 11, 12, 13);
		setChildren(15, widget);
		setBounds(53502, 56, 45, 0, widget);
		setBounds(53503, 250, 80, 1, widget);
		setBounds(53505, 223, 90, 2, widget);
		setBounds(53506, 435, 51, 3, widget);
		setBounds(53508, 277, 250, 4, widget);
		setBounds(53511, 230, 100, 5, widget);
		setBounds(53512, 320, 255, 6, widget);
		setBounds(53513, 250, 224, 7, widget);
		setBounds(53514, 255, 228, 8, widget);
		setBounds(53515, 268, 228, 9, widget);
		setBounds(53516, 418, 51, 10, widget);
		setBounds(53517, 370, 221, 11, widget);
		setBounds(53549, 61, 51, 12, widget);
		setBounds(53530, 0, 0, 13, widget);
		setBounds(53535, 0, 0, 14, widget);

		RSInterface scroll = addInterface(53549);
		scroll.width = 114;
		scroll.height = 230;
		scroll.scrollMax = 750;
		setChildren(70, scroll);

		for (int i = 0; i < 70; i += 2) {
			addClickableSprites(53550 + i, "View", "Interfaces/Titles/IMAGE",
					3, 4, 5, 14);
			addText(53550 + i + 1, "Entry " + (1 + i / 2), tda, 1, 0xFF981F,
					false, true);
			setBounds(53550 + i, 0, i / 2 * 22, i, scroll);
			setBounds(53550 + i + 1, 4, 3 + (i / 2 * 22), i + 1, scroll);
		}

		widget = addInterface(53530);
		setChildren(1, widget);
		addText(53531, "Selected Title", tda, 2, 0xFF981F, true, true);
		setBounds(53531, 320, 66, 0, widget);

		widget = addInterface(53535);
		setChildren(1, widget);
		addInputField(53536, 16, 0xFF981F, "Custom title", 120, 22, false,
				true, "[A-Za-z0-9 ]");
		setBounds(53536, 262, 58, 0, widget);
	}

	public static final void initializeCommandHelp() {
		for (int childId : interfaceCache[8143].children) {
			interfaceCache[childId].message = "";
		}
	}

	public static void updateShopWidget(TextDrawingArea[] tda) {
		RSInterface widget = interfaceCache[3824];
		int[] childrenId = new int[widget.children.length + 1];
		int[] childrenX = new int[widget.children.length + 1];
		int[] childrenY = new int[widget.children.length + 1];
		for (int i = 0; i < widget.children.length; i++) {
			childrenId[i] = widget.children[i];
			childrenX[i] = widget.childX[i];
			childrenY[i] = widget.childY[i];
		}
		setChildren(93, widget);

		for (int i = 0; i < widget.children.length; i++) {
			setBounds(childrenId[i], childrenX[i], childrenY[i], i, widget);
		}
		setBounds(28050, 0, 0, 92, widget);

		RSInterface subWidget = addInterface(28050);
		setChildren(2, subWidget);
		addSprite(28051, 2, "Interfaces/BountyHunter/IMAGE");
		addText(28052, "PKP:", tda, 1, 0xFFFF00, false, true);
		setBounds(28051, 20, 30, 0, subWidget);
		setBounds(28052, 48, 30, 1, subWidget);
	}

	public static void shopWidget(TextDrawingArea[] tda) {
		// Interface background
		RSInterface widget = addInterface(64000);
		setChildren(5, widget);
		addSprite(64001, 1, "Interfaces/Shop/IMAGE");
		addHoverButton(64002, "Interfaces/Shop/IMAGE", 2, 21, 21, "Close Window", 201, 64002, 5);
		addText(64003, "Tony's store", tda, 2, 0xFFA500, false, true);
		setBounds(64001, 10, 10, 0, widget);
		setBounds(64015, 20, 45, 1, widget);
		setBounds(64002, 485, 20, 2, widget);
		setBounds(64003, 200, 20, 3, widget);
		setBounds(64017, 0, 0, 4, widget);

		// Scroll
		RSInterface scroll = addInterface(64015);
		setChildren(1, scroll);
		scroll.height = 252;
		scroll.width = 465;
		scroll.scrollMax = 800;

		// Item container
		addToItemGroup(SHOP_CONTAINER, 10, 40, 14, 14, true, "Value", "Buy 1", "Buy 5", "Buy 10", "Buy X", null);
		setBounds(SHOP_CONTAINER, 8, 8, 0, scroll);
		interfaceCache[SHOP_CONTAINER].invAlwaysInfinity = false;

		// Bounty hunter widget
		RSInterface subWidget = addInterface(64017);
		setChildren(2, subWidget);
		addSprite(64018, 2, "Interfaces/BountyHunter/IMAGE");
		addText(64019, "PKP", tda, 1, 0xFFFF00, false, true);
		setBounds(64018, 20, 20, 0, subWidget);
		setBounds(64019, 48, 20, 1, subWidget);
	}

	public static void bountyHunterWidget(TextDrawingArea[] tda) {
		RSInterface widget = addInterface(28000);
		addTransparentSprite(28001, 1, "Interfaces/BountyHunter/IMAGE", 20);
		addText(28003, "Target:", tda, 0, 0xFFFF00, false, true);
		addText(28004, "Abnant", tda, 1, 0xFFFFFF, true, true);
		addText(28005, "Lvl 1-4, Cmb 70", tda, 0, 0xCC0000, true, true);
		addText(28006, "Wealth: V. Low", tda, 0, 0xFFFF00, true, true);
		setChildren(15, widget);
		setBounds(28001, 320, 15, 0, widget);
		setBounds(28003, 440, 18, 1, widget);
		setBounds(28004, 458, 31, 2, widget);
		setBounds(28005, 458, 47, 3, widget);
		setBounds(28006, 359, 47, 4, widget);

		/** TODO WIldy Skull **/
		setBounds(196, Client.instance.isResized() ? 600 : 420,
				Client.instance.isResized() ? 186 : 286, 5, widget);

		addText(250, "", tda, 1, 0xFFFF00, true, true);
		RSInterface skullWidget = RSInterface.interfaceCache[196];
		int[] backupX = skullWidget.childX;
		int[] backupY = skullWidget.childY;

		skullWidget.children = new int[3];
		skullWidget.childX = new int[3];
		skullWidget.childY = new int[3];

		skullWidget.totalChildren(3);
		skullWidget.child(0, 194, backupX[0], backupY[0]);
		skullWidget.child(1, 195, backupX[1], backupY[1]);
		skullWidget.child(2, 250, 29, 24);

		skullWidget.width *= 1.5;

		setBounds(28030, 345, 25, 6, widget);
		setBounds(28032, 345, 25, 7, widget);
		setBounds(28034, 345, 25, 8, widget);
		setBounds(28036, 345, 25, 9, widget);
		setBounds(28038, 345, 25, 10, widget);
		setBounds(28040, 345, 25, 11, widget);
		setBounds(28020, 0, 5, 12, widget);
		setBounds(28070, 0, 5, 13, widget);

		RSInterface sprite;
		int imageId = 2;
		for (int i = 0; i < 12; i += 2) {
			sprite = addInterface(28030 + i);
			addSprite(28031 + i, imageId++, "Interfaces/BountyHunter/IMAGE");
			setChildren(1, sprite);
			setBounds(28031 + i, 0, 0, 0, sprite);
		}

		RSInterface statistics = addInterface(28020);
		setChildren(9, statistics);
		addTransparentSprite(28021, 0, "Interfaces/BountyHunter/IMAGE", 20);
		addText(28022, "Current  Record", tda, 0, 0xFFFF00, false, true);
		addText(28023, "Rogue:", tda, 0, 0xFFFF00, false, true);
		addText(28024, "Hunter:", tda, 0, 0xFFFF00, false, true);
		addText(28025, "1", tda, 0, 0xFFFF00, true, true);
		addText(28026, "2", tda, 0, 0xFFFF00, true, true);
		addText(28027, "3", tda, 0, 0xFFFF00, true, true);
		addText(28028, "4", tda, 0, 0xFFFF00, true, true);
		addSprite(28029, 8, "Interfaces/BountyHunter/IMAGE");

		setBounds(28021, 340, 58, 0, statistics);
		setBounds(28022, 420, 60, 1, statistics);
		setBounds(28023, 375, 73, 2, statistics);
		setBounds(28024, 375, 87, 3, statistics);
		setBounds(28025, 440, 73, 4, statistics);
		setBounds(28026, 440, 87, 5, statistics);
		setBounds(28027, 481, 73, 6, statistics);
		setBounds(28028, 481, 87, 7, statistics);
		setBounds(28029, 347, 74, 8, statistics);

		RSInterface timerWidget = addInterface(28070);
		addTransparentSprite(28071, 10, "Interfaces/BountyHunter/IMAGE", 20);
		addText(28072, "0:59", tda, 0, 0xff9040, true, true);
		setChildren(2, timerWidget);
		setBounds(28071, 293, 10, 0, timerWidget);
		setBounds(28072, 307, 27, 1, timerWidget);
	}

	public static void helpComponent(TextDrawingArea[] tda) {
		RSInterface widget = addInterface(59525);
		addSprite(59526, 1, "Interfaces/HelpInterface/IMAGE");
		addInputField(59527, 200, 0xFF981F, "Describe the bug you've experienced. (200 characters max)", 430, 28, false,
				false, "[A-Za-z0-9 .,]");
		addText(59528, "Help Request", tda, 2, 0xFF981F, true, true);
		addText(59529,
				"You are only allowed to request help when you need it. Situations such as being stuck,\\n"
						+ "threatened by another player, problems with a donation, or experiencing a bug are all\\n"
						+ "viable uses of the help system. Improper use of this system may lead to punishment.",
				tda, 0, 0xFF981F, false, true);
		addHoverButton(59530, "Interfaces/HelpInterface/IMAGE", 2, 16, 16, "Close", -1, 59531, 3);
		addHoveredButton(59531, "Interfaces/HelpInterface/IMAGE", 3, 16, 16, 59532);
		setChildren(6, widget);
		setBounds(59526, 33, 106, 0, widget);
		setBounds(59527, 40, 192, 1, widget);
		setBounds(59528, 256, 113, 2, widget);
		setBounds(59529, 40, 135, 3, widget);
		setBounds(59530, 456, 112, 4, widget);
		setBounds(59531, 456, 112, 5, widget);
	}

	public static void barrowsReward(TextDrawingArea[] wid) {
		RSInterface tab = addInterface(64500);
		addSprite(64501, 0, "Interfaces/Bankpin/IMAGE");
		addHoverButton(64502, "Interfaces/Shop/IMAGE", 2, 21, 21, "Close Window", 201, 64502, 5);
		setChildren(3, tab);
		setBounds(64501, 256 - 140, 120, 0, tab);
		setBounds(64502, 374, 127, 1, tab);

		// Item container
		addToItemGroup(64503, 6, 2, 5, 5, false, "", "", "");
		setBounds(64503, 148, 155, 2, tab);
	}

	public static void bankPin(TextDrawingArea[] wid) {
		RSInterface tab = addInterface(59500);
		addSprite(59501, 0, "Interfaces/Bankpin/IMAGE");
		addText(59502, "Account Pin", wid, 2, 0xFF981F, true, true);
		addText(59503, "Enter your 4 digit code", wid, 1, 0xFF981F, true, true);
		addText(59504, "Enter your 4 digit code", wid, 1, 0xFF981F, true, true);
		addText(59505, "Enter your 4 digit code", wid, 1, 0xFF981F, true, true);
		addText(59506, "Press enter to submit", wid, 2, 0xFF981F, true, true);
		addInputField(59507, 8, 0xFF981F, "", 100, 24, true);
		addHoverButton(59508, "Interfaces/Bankpin/IMAGE", 1, 16, 16, "Close", 375, 59509, 3);
		addHoveredButton(59509, "Interfaces/Bankpin/IMAGE", 2, 16, 16, 59510);
		setChildren(9, tab);
		setBounds(59501, 256 - 140, 120, 0, tab);
		setBounds(59502, 256, 132, 1, tab);
		setBounds(59503, 256, 150, 2, tab);
		setBounds(59504, 256, 165, 3, tab);
		setBounds(59505, 256, 180, 4, tab);
		setBounds(59506, 256, 200, 5, tab);
		setBounds(59507, 256 - 50, 220, 6, tab);
		setBounds(59508, 374, 127, 7, tab);
		setBounds(59509, 374, 127, 8, tab);
	}



	public static void hiscores(TextDrawingArea[] wid) {
		RSInterface rsinterface = addInterface(46500);
		addSprite(46501, 292, "Interfaces/Hiscores/BACKGROUND");
		addText(46502, "Live Highscores", wid, 2, 0xff981f, true);
		addText(46508, "Player Name:", wid, 2, 0xff981f, true);
		addText(46509, "Kills:", wid, 2, 0xff981f, true);
		addText(46510, "Deaths:", wid, 2, 0xff981f, true);
		addText(46511, "KDR:", wid, 2, 0xff981f, true);
		addText(46512, "Killstreak:", wid, 2, 0xff981f, true);
		/*First Row*/
		addText(46513, "1) N/A", wid, 1, 0xff981f, false);
		addText(46514, "2) N/A", wid, 1, 0xff981f, false);
		addText(46515, "3) N/A", wid, 1, 0xff981f, false);
		addText(46516, "4) N/A", wid, 1, 0xff981f, false);
		addText(46517, "5) N/A", wid, 1, 0xff981f, false);
		addText(46518, "6) N/A", wid, 1, 0xff981f, false);
		addText(46519, "7) N/A", wid, 1, 0xff981f, false);
		addText(46520, "8) N/A", wid, 1, 0xff981f, false);
		addText(46521, "9) N/A", wid, 1, 0xff981f, false);
		addText(46522, "10) N/A", wid, 1, 0xff981f, false);
		/*Second Row*/
		addText(46523, "11", wid, 0, 0xff981f, true);
		addText(46524, "12", wid, 0, 0xff981f, true);
		addText(46525, "13", wid, 0, 0xff981f, true);
		addText(46526, "14", wid, 0, 0xff981f, true);
		addText(46527, "15", wid, 0, 0xff981f, true);
		addText(46528, "16", wid, 0, 0xff981f, true);
		addText(46529, "17", wid, 0, 0xff981f, true);
		addText(46530, "18", wid, 0, 0xff981f, true);
		addText(46531, "19", wid, 0, 0xff981f, true);
		addText(46532, "20", wid, 0, 0xff981f, true);
		/*Third Row*/
		addText(46533, "21", wid, 0, 0xff981f, true);
		addText(46534, "22", wid, 0, 0xff981f, true);
		addText(46535, "23", wid, 0, 0xff981f, true);
		addText(46536, "24", wid, 0, 0xff981f, true);
		addText(46537, "25", wid, 0, 0xff981f, true);
		addText(46538, "26", wid, 0, 0xff981f, true);
		addText(46539, "27", wid, 0, 0xff981f, true);
		addText(46540, "28", wid, 0, 0xff981f, true);
		addText(46541, "29", wid, 0, 0xff981f, true);
		addText(46542, "30", wid, 0, 0xff981f, true);
		/*Fourth Row*/
		addText(46543, "31", wid, 0, 0xff981f, true);
		addText(46544, "32", wid, 0, 0xff981f, true);
		addText(46545, "33", wid, 0, 0xff981f, true);
		addText(46546, "34", wid, 0, 0xff981f, true);
		addText(46547, "35", wid, 0, 0xff981f, true);
		addText(46548, "36", wid, 0, 0xff981f, true);
		addText(46549, "37", wid, 0, 0xff981f, true);
		addText(46550, "38", wid, 0, 0xff981f, true);
		addText(46551, "39", wid, 0, 0xff981f, true);
		addText(46552, "40", wid, 0, 0xff981f, true);
		/*Fith Row*/
		addText(46553, "41", wid, 0, 0xff981f, true);
		addText(46554, "42", wid, 0, 0xff981f, true);
		addText(46555, "43", wid, 0, 0xff981f, true);
		addText(46556, "44", wid, 0, 0xff981f, true);
		addText(46557, "45", wid, 0, 0xff981f, true);
		addText(46558, "46", wid, 0, 0xff981f, true);
		addText(46559, "47", wid, 0, 0xff981f, true);
		addText(46560, "48", wid, 0, 0xff981f, true);
		addText(46561, "49", wid, 0, 0xff981f, true);
		addText(46562, "", wid, 0, 0xff981f, true);
		addHoverButton(46563, "BankTab/BANK", 1, 15, 15, "Close Window", -1, 46564, 3);
		addHoveredButton(46564, "BankTab/BANK", 2, 15, 15, 46565);
		rsinterface.totalChildren(59);
		rsinterface.child(0, 46501, 12, 23);
		rsinterface.child(1, 46502, 255, 33);
		rsinterface.child(2, 46508, 89, 66);
		rsinterface.child(3, 46509, 202, 66);
		rsinterface.child(4, 46510, 281, 66);
		rsinterface.child(5, 46511, 355, 66);
		rsinterface.child(6, 46512, 440, 66);
		rsinterface.child(7, 46513, 25, 89);
		rsinterface.child(8, 46514, 25, 109);
		rsinterface.child(9, 46515, 25, 129);
		rsinterface.child(10, 46516, 25, 149);
		rsinterface.child(11, 46517, 25, 169);
		rsinterface.child(12, 46518, 25, 189);
		rsinterface.child(13, 46519, 25, 209);
		rsinterface.child(14, 46520, 25, 229);
		rsinterface.child(15, 46521, 25, 249);
		rsinterface.child(16, 46522, 25, 269);
		rsinterface.child(17, 46523, 200, 91);
		rsinterface.child(18, 46524, 200, 111);
		rsinterface.child(19, 46525, 200, 131);
		rsinterface.child(20, 46526, 200, 151);
		rsinterface.child(21, 46527, 200, 171);
		rsinterface.child(22, 46528, 200, 191);
		rsinterface.child(23, 46529, 200, 211);
		rsinterface.child(24, 46530, 200, 231);
		rsinterface.child(25, 46531, 200, 251);
		rsinterface.child(26, 46532, 200, 271);
		rsinterface.child(27, 46533, 280, 91);
		rsinterface.child(28, 46534, 280, 111);
		rsinterface.child(29, 46535, 280, 131);
		rsinterface.child(30, 46536, 280, 151);
		rsinterface.child(31, 46537, 280, 171);
		rsinterface.child(32, 46538, 280, 191);
		rsinterface.child(33, 46539, 280, 211);
		rsinterface.child(34, 46540, 280, 231);
		rsinterface.child(35, 46541, 280, 251);
		rsinterface.child(36, 46542, 280, 271);
		rsinterface.child(37, 46543, 355, 91);
		rsinterface.child(38, 46544, 355, 111);
		rsinterface.child(39, 46545, 355, 131);
		rsinterface.child(40, 46546, 355, 151);
		rsinterface.child(41, 46547, 355, 171);
		rsinterface.child(42, 46548, 355, 191);
		rsinterface.child(43, 46549, 355, 211);
		rsinterface.child(44, 46550, 355, 231);
		rsinterface.child(45, 46551, 355, 251);
		rsinterface.child(46, 46552, 355, 271);
		rsinterface.child(47, 46553, 438, 91);
		rsinterface.child(48, 46554, 438, 111);
		rsinterface.child(49, 46555, 438, 131);
		rsinterface.child(50, 46556, 438, 151);
		rsinterface.child(51, 46557, 438, 171);
		rsinterface.child(52, 46558, 438, 191);
		rsinterface.child(53, 46559, 438, 211);
		rsinterface.child(54, 46560, 438, 231);
		rsinterface.child(55, 46561, 438, 251);
		rsinterface.child(56, 46562, 438, 271);
		rsinterface.child(57, 46563, 470, 32);
		rsinterface.child(58, 46564, 470, 32);
	}


	public static void ironmanLeaderboard(TextDrawingArea[] tda) {
		RSInterface rsi = addInterface(62000);
		addSprite(62001, 1, "Interfaces/IronmanLeaderboard/IMAGE");
		addHoverButton(62002, "Interfaces/Achievements/IMAGE", 15, 16, 16, "Close Window", -1, 69003, 3);
		//configHoverButtonTest(62002, "Close Window", "Interfaces/PreloadingGear/IMAGE", 3, 4, 3, 4, false, new int[] {});
		addHoveredButton(62003, "Interfaces/Achievements/IMAGE", 16, 16, 16, 69004);
		addText(62005, "<img=23> Group Ironman Leaderboards", tda, 2, 0xff981f, false, true);
		addText(62006, "Top 10 Groups", tda, 2, 0xff981f, false, true);
		addText(62007, "Recent Groups", tda, 2, 0xff981f, false, true);
		addText(62008, "", tda, 0, 0xff981f, false, true);
		addText(62009, "", tda, 0, 0xff981f, false, true);
		addText(62010, "", tda, 0, 0xff981f, false, true);
		addText(62011, "", tda, 0, 0xff981f, false, true);
		addText(62012, "", tda, 0, 0xff981f, false, true);
		setChildren(12, rsi);
		setBounds(62001, 20, 24, 0, rsi);
		setBounds(62002, 478, 30, 1, rsi);
		setBounds(62003, 490, 6, 2, rsi);
		setBounds(62005, 190, 30, 3, rsi);
		setBounds(62006, 50, 57, 4, rsi);
		setBounds(62007, 50, 208, 5, rsi);
		setBounds(62008, 32, 230, 6, rsi);
		setBounds(62009, 32, 247, 7, rsi);
		setBounds(62010, 32, 264, 8, rsi);
		setBounds(62011, 32, 281, 9, rsi);
		setBounds(62012, 32, 298, 10, rsi);
		setBounds(62100, 19, 75, 11, rsi);

		RSInterface scroll = addInterface(62100);
		setChildren(90, scroll);
		scroll.scrollMax = 308;
		scroll.height = 124;
		scroll.width = 456;
		int y = 0;
		for(int i = 0; i < 10; i++) {
			addSprite(62101 + i, 2, "Interfaces/IronmanLeaderboard/IMAGE");
			addSprite(62201 + i, 2, "Interfaces/IronmanLeaderboard/IMAGE");
			addText(62301 + i, "", tda, 2, 0xff981f, true, true);
			addText(62401 + i, "Team Name", tda, 0, 0xff981f, false, true);
			addText(62901 + i, "Member names", tda, 0, 0xff981f, false, true);
			addText(62501 + i, "Avg. Combat:", tda, 0, 0xFFFF00, false, true);
			addText(62601 + i, "Status", tda, 0, 0x00FF00, false, true);
			addText(62701 + i, "Avg. Total Level:", tda, 0, 0x0080F0, false, true);
			addText(62801 + i, "Avg. Total XP:", tda, 0, 0x97CFFF, false, true);
			setBounds(62101 + i, 10, y, i, scroll);
			setBounds(62201 + i, 155, y, 10 + i, scroll);
			setBounds(62301 + i, 0, y, 20 + i, scroll); //unused.
		    setBounds(62401 + i, 10, y + 1, 30 + i, scroll);
			setBounds(62901 + i, 10, y + 15, 80 + i, scroll);
			setBounds(62501 + i, 190, y + 1, 40 + i, scroll);
			setBounds(62601 + i, 105, y + 1, 50 + i, scroll);
			setBounds(62701 + i, 310, y + 1, 60 + i, scroll);
			setBounds(62801 + i, 310, y + 15, 70 + i, scroll);
			y += 31;
		}
	}


	public static void upgradeInt(TextDrawingArea[] tda) {
		int interfaceId = 29000;
		int nameScrollId = 29020;
		int ingScrollId = 29080;
		RSInterface mode = addInterface(interfaceId);
		int index = 1;
		String dir = "Interfaces/Upgrade/sprite";
		addSprite(interfaceId + index++, 0, dir);
		configHoverButtonTest(interfaceId + index, "Close", dir, 1, 2, 2, 2, false, interfaceId + index++);

		addText(interfaceId + index++, "Item upgrade machine", tda, 2, 0xff9933, true, true);
		addText(interfaceId + index++, "", tda, 0, 0xff9933, true, true);
		addText(interfaceId + index++, "Items required:", tda, 1, 0xff9933, true, true);

		configHoverButtonTest(interfaceId + index, "Upgrade", dir, 3, 4, 4, 4, false, interfaceId + index++);
		addText(interfaceId + index++, "Upgrade", tda, 2, 0xff9933, true, true);

		addText(interfaceId + index++, "", tda, 1, 0xff9933, true, true);

		itemGroup(interfaceId + index++, 1, 1, 5, 3, true, true);

		configHoverButtonTest(29010, "View weaponry upgrades", dir, 5, 6, 6, 6, false, 29011, 29012);
		configHoverButtonTest(29011, "View armor upgrades", dir, 5, 6, 6, 6, false, 29010, 29012);
		configHoverButtonTest(29012, "View pet upgrades", dir, 5, 6, 6, 6, false, 29010, 29011);

		addText(29013, "Weaponry", tda, 0, 0xff9933, true, true);
		addText(29014, "Armour", tda, 0, 0xff9933, true, true);
		addText(29015, "Misc", tda, 0, 0xff9933, true, true);
		addText(29016, "Safe item:", tda, 1, 0xff9933, true, true);
		addSprite(29017, 7, dir);
		itemGroup(29018, 1, 1, 5, 3, true, true);

		index = 0;
		int x = 60; int y = 47;
		mode.totalChildren(20);
		mode.child(index++, interfaceId + index, x, y); //BACKGROUND
		mode.child(index++, interfaceId + index, x + 375, y + 9); //CLOSE BUTTON

		mode.child(index++, interfaceId + index, x + 196, y + 9); //HEAD TEXT
		mode.child(index++, interfaceId + index, x + 88, y + 58); //CURRECY COSTS TEXT
		mode.child(index++, interfaceId + index, x + 270, y + 41); //ITEMS REQUIRED TEXT

		mode.child(index++, interfaceId + index, x + 273, y + 208); //UPGRADE BUTTON
		mode.child(index++, interfaceId + index, x + 314, y + 210); //UPGRADE TEXT

		mode.child(index++, interfaceId + index, x + 283+34, y + 186); //SUCCESS RATE

		mode.child(index++, interfaceId + index, x + 210, y + 203); //PREVIEW UPGRADE ITEM

		mode.child(index++, interfaceId + index, x + 9, y + 40); //HOVERBUTTON
		mode.child(index++, interfaceId + index, x + 73, y + 40); //HOVERBUTTON
		mode.child(index++, interfaceId + index, x + 136, y + 40); //HOVERBUTTON

		mode.child(index++, interfaceId + index, x + 40, y + 44); //WEAPONRY
		mode.child(index++, interfaceId + index, x + 103, y + 44); //ARMOUR
		mode.child(index++, interfaceId + index, x + 167, y + 44); //PETS
		mode.child(index++, interfaceId + index, x + 283, y + 156); //safe item
		mode.child(index++, interfaceId + index, x + 283 + 34, y + 144); //Safe item container
		mode.child(index++, interfaceId + index, x + 283 + 41, y + 149); //item group safe item
		mode.child(index++, nameScrollId, x + 10, y + 66);

		mode.child(index++, ingScrollId, x + 208, y + 66);

		RSInterface nameScroll = addTabInterface(nameScrollId);
		int totalBoxes = 50;
		nameScroll.width = 172;
		nameScroll.height = 175;
		nameScroll.scrollMax = nameScroll.height + 1;

		nameScroll.totalChildren(totalBoxes);
		nameScrollId++;
		index = 0; x = 0; y = 0;
		for(int i = 0; i < totalBoxes; i++) {
			addClickableText(nameScrollId, "Item name", "View recipe", tda, 0, 0xff9933, false, true, 165);
			nameScroll.child(index++, nameScrollId++, x + 2, y + 2);
			y += 14;
		}
		nameScroll.scrollMax = y;

		RSInterface ingScroll = addTabInterface(ingScrollId);
		ingScroll.width = 167;
		ingScroll.height = 72;
		ingScroll.scrollMax = 120;

		ingScroll.totalChildren(1);
		ingScrollId++;
		index = 0; x = 0; y = 0;
		itemGroup(ingScrollId, 4, 2, 7, 3, true, true);
		ingScroll.child(index, ingScrollId, x + 4, y + 2);
	}


	public static void wellOfGoodWill(TextDrawingArea[] tda) {
		RSInterface wogw = addInterface(38000);
		addSprite(38001, 0, "Interfaces/WellOfGoodWill/IMAGE");
		addText(38002, "Well Of Goodwill", tda, 2, 0xFF981F, true, true);
		addText(38003, "50% Bonus Experience", tda, 2, 0xFF981F, false, true);
		addText(38004, "Bonus PC Points (x5)", tda, 2, 0xFF981F, false, true);
		addText(38005, "Droprate Boost (20%)", tda, 2, 0xFF981F, false, true);
		addClickableSprites(38006, "Toggle", "Interfaces/WellOfGoodWill/IMAGE", 5, 5, 6);
		addClickableSprites(38007, "Toggle", "Interfaces/WellOfGoodWill/IMAGE", 5, 5, 6);
		addClickableSprites(38008, "Toggle", "Interfaces/WellOfGoodWill/IMAGE", 5, 5, 6);
		//addClickableSprites(38019, "Toggle", "Interfaces/WellOfGoodWill/IMAGE", 5, 5, 6);
		configHoverButtonTest(38009, "Donate Coins", "Interfaces/WellOfGoodWill/SPRITE", 756, 757, 757, 757, false, 38009);
		configHoverButtonTest(38010, "Close Window", "Interfaces/WellOfGoodWill/IMAGE", 1, 2, 2, 2, false, 38010);
		addText(38011, "Add Gold", tda, 2, 0xFF981F, false, true);
		addText(38012, "", tda, 2, 0xFF981F, false, true);
		addClickableSprites(38013, "", "", 5, 5, 6);
		addSprite(38014, 8, "Interfaces/WellOfGoodWill/IMAGE");
		addText(38015, "Goal1", tda, 2, 0xcc6d00, false, true);
		addText(38016, "Goal2", tda, 2, 0xcc6d00, false, true);
		addText(38017, "Goal3", tda, 2, 0xcc6d00, false, true);
		//addText(38018, "", tda, 2, 0xcc6d00, false, true);
		//addText(38020, "", tda, 2, 0xFF981F, false, true);
		//addInputField(38019, 30, 0xFF981F, "Amount of coins", 134, 20, false, true, "[0-9]");

		setChildren(20, wogw);
		setBounds(38001, 5, 8, 0, wogw);
		setBounds(38002, 270, 25, 1, wogw);
		setBounds(38003, 185, 80, 2, wogw);
		setBounds(38004, 185, 110, 3, wogw);
		setBounds(38005, 185, 140, 4, wogw);
		setBounds(38006, 360, 80, 5, wogw);
		setBounds(38007, 360, 110, 6, wogw);
		setBounds(38008, 360, 140, 7, wogw);
		setBounds(38009, 249, 211, 9, wogw);
		setBounds(38010, 470, 25, 8, wogw);
		setBounds(38011, 261, 214, 10, wogw);
		setBounds(38012, 185, 170, 11, wogw);
		setBounds(38013, 360, 170, 12, wogw);
		setBounds(38014, 42, 64, 13, wogw);
		setBounds(38015, 385, 80, 14, wogw);
		setBounds(38016, 385, 110, 15, wogw);
		setBounds(38017, 385, 140, 16, wogw);
		//setBounds(38018, 385, 170, 17, wogw);
		//setBounds(38019, 360, 170, 18, wogw);
		//setBounds(38020, 185, 170, 19, wogw);

		/*RSInterface wogw = addInterface(38000);
		addSprite(38001, 0, "Interfaces/Wogw/IMAGE");
		addText(38002, "Well Of Goodwill", tda, 2, 0xFF981F, true, true);
		addText(38003, "Experience (x2)", tda, 2, 0xFF981F, true, true);
		addText(38004, "PC Points (+5)", tda, 2, 0xFF981F, true, true);
		addText(38005, "Drops (x2 rate)", tda, 2, 0xFF981F, true, true);
		addClickableSprites(38006, "Toggle", "Interfaces/Ironman/IMAGE", 2, 3, 4);
		addClickableSprites(38007, "Toggle", "Interfaces/Ironman/IMAGE", 2, 3, 4);
		addClickableSprites(38008, "Toggle", "Interfaces/Ironman/IMAGE", 2, 3, 4);
		addText(38009, "How much would you like to donate?", tda, 0, 0xFF981F, true, true);
		addHoverButton(38010, "Interfaces/Shop/IMAGE", 2, 21, 21, "Close Window", 201, 38010, 5);
		addInputField(38011, 120, 0xFF981F, "Amount of coins", 144, 20, false, false, "[0-9]");
		addText(38012, "10M/200M", tda, 0, 0xFF981F, true, true);
		addText(38013, "10M/200M", tda, 0, 0xFF981F, true, true);
		addText(38014, "10M/200M", tda, 0, 0xFF981F, true, true);
		setChildren(16, wogw);
		setBounds(38001, 256 - 120, 20, 0, wogw);
		setBounds(38002, 270, 30, 1, wogw);
		setBounds(38003, 290, 60, 2, wogw);
		setBounds(38004, 273, 90, 3, wogw);
		setBounds(38005, 260, 120, 4, wogw);
		setBounds(38006, 360, 60, 5, wogw);
		setBounds(38007, 360, 90, 6, wogw);
		setBounds(38008, 360, 120, 7, wogw);
		setBounds(38009, 260, 170, 8, wogw);
		setBounds(38010, 366, 26, 9, wogw);
		setBounds(38011, 190, 190, 10, wogw);
		setBounds(38012, 183, 63, 11, wogw);
		setBounds(38013, 183, 93, 12, wogw);
		setBounds(38014, 183, 123, 13, wogw);
		setBounds(38020, 0, 0, 14, wogw);
		setBounds(38030, 0, 0, 15, wogw);

		RSInterface confirmation = addInterface(38020);
		setChildren(6, confirmation);
		addSprite(38021, 0, "Interfaces/Wogw/IMAGE");
		addText(38022, "Are you sure you want to contribute\\n# gp?", tda, 2, 0xFF981F, false, true);
		addHoverButton(38023, "Interfaces/Ironman/IMAGE", 4, 21, 21, "Yes", 201, 38023, 5);
		addHoverButton(38025, "Interfaces/Ironman/IMAGE", 3, 21, 21, "No", 201, 38023, 5);
		addText(38024, "YES", tda, 0, 0xFF981F, false, true);
		addText(38026, "NO", tda, 0, 0xFF981F, false, true);
		setBounds(38021, 256 - 120, 20, 0, confirmation);
		setBounds(38022, 145, 82, 1, confirmation);
		setBounds(38023, 220, 152, 2, confirmation); // Yes button
		setBounds(38024, 220, 140, 3, confirmation); // Yes text
		setBounds(38025, 288, 152, 4, confirmation); // No button
		setBounds(38026, 290, 140, 5, confirmation); // No text

		RSInterface last = addInterface(38030);
		addSprite(38031, 1, "Interfaces/Wogw/IMAGE");
		addText(38032, "Recent Donators", tda, 2, 0xFF981F, false, true);
		addText(38033, "Limp donated 10.000.000 towards x2 experience", tda, 0, 0xFF981F, false, true);
		addText(38034, "Limp donated 10.000.000 towards +5 PC Points", tda, 0, 0xFF981F, false, true);
		addText(38035, "Limp donated 10.000.000 towards Double drops", tda, 0, 0xFF981F, false, true);
		addText(38036, "Limp donated 10.000.000 towards Double drops", tda, 0, 0xFF981F, false, true);
		addText(38037, "Limp donated 10.000.000 towards Double drops", tda, 0, 0xFF981F, false, true);
		setChildren(7, last);
		setBounds(38031, 3, 235, 0, last);
		setBounds(38032, 200, 240, 1, last);
		setBounds(38033, 140, 260, 2, last);
		setBounds(38034, 140, 272, 3, last);
		setBounds(38035, 140, 284, 4, last);
		setBounds(38036, 140, 296, 5, last);
		setBounds(38037, 140, 308, 6, last);*/
	}











	public static void barrowsInterface(TextDrawingArea[] tda) {
		RSInterface tab = RSInterface.addInterface(22045);

		tab.totalChildren(6);
		int y = 235;
		String[] text = {"Dharok", "Guthan", "Ahrim", "Torag", "Verac", "Karil"};
		for (int i = 0; i < 6; i++) {
			RSInterface.addText(22046 + i, text[i], 0xff0000, true, true, -1, tda, 1);
			tab.child(0 + i, 22046 + i, 470, y);
			y += 15;
		}
	}





	private static void npcDropTable(TextDrawingArea[] tda) {
		RSInterface tab = RSInterface.addInterface(29050);// 54500
		RSInterface.addSprite(29051, 962);// 54501
		RSInterface.addHoverButton(29052, 148, 16, 16, "Close", 250, 29053, 3);// 54502
		RSInterface.addHoveredButton(29053, 149, 16, 16, 29054);// 54503, 54504
		RSInterface.addText(29055, "Npc Droptable", tda, 2, 0xff9933, true, true);// 54505
		RSInterface.addText(29058, "Item:", tda, 1, 0xff9933, true, true);// 54508
		RSInterface.addText(29059, "Quantity:", tda, 1, 0xff9933, true, true);// 54509
		RSInterface.addText(29060, "Price:", tda, 1, 0xff9933, true, true);// 54510
		RSInterface.addText(29061, "Chance:", tda, 1, 0xff9933, true, true);// 54511

		int children = 0;
		RSInterface.setChildren(16, tab);
		RSInterface.setBounds(29051, 9, 5, children++, tab);
		RSInterface.setBounds(29052, 479, 12, children++, tab);
		RSInterface.setBounds(29053, 479, 12, children++, tab);
		RSInterface.setBounds(29055, 255, 12, children++, tab);
		RSInterface.setBounds(29058, 202, 38, children++, tab);
		RSInterface.setBounds(29059, 331, 38, children++, tab);
		RSInterface.setBounds(29060, 383, 38, children++, tab);
		RSInterface.setBounds(29061, 445, 38, children++, tab);
		RSInterface.setBounds(30500, 143, 56, children++, tab);
		RSInterface.setBounds(27700, 23, 89, children++, tab);

		RSInterface mainScroll = RSInterface.addTabInterface(30500);// 54550
		mainScroll.width = 594 - 261;
		mainScroll.height = 264;
		mainScroll.scrollMax = 600;

		int dropsAmount = 200;//100
		RSInterface.setChildren((dropsAmount * 6), mainScroll);
		int child = 0, y = 1, x = 0, sprite = 0;
		int start = 33300;
		for (int i = 0; i < dropsAmount * 6; i += 6) {
			int id = sprite % 2 == 0 ? 965 : 966;
			sprite++;
			RSInterface.addSprite(start + i, id);// 54552
			RSInterface.addText((start + (i + 1)), "", tda, 0, sprite % 2 == 0 ? 0xFFB83F : 0xFF981F,
					false, false);
			RSInterface.addText((start + (i + 2)), "", tda, 0, sprite % 2 == 0 ? 0xFFB83F : 0xFF981F,
					true, false);
			RSInterface.addText((start + (i + 3)), "", tda, 0, sprite % 2 == 0 ? 0xFFB83F : 0xFF981F,
					true, false);
			RSInterface.addText((start + (i + 4)), "", tda, 0, 0xFF981F, true, false);
			RSInterface.addToItemGroup((start + (i + 5)), 0, 1, 1, 24, 24, false, null, null, null,
					true, true);
			mainScroll.child(child++, start + i, x + 254 - 254, y);
			mainScroll.child(child++, (start + (i + 1)), x + 300 - 254, y + 10);
			mainScroll.child(child++, (start + (i + 2)), x + 440 - 254, y + 10);
			mainScroll.child(child++, (start + (i + 3)), x + 496 - 254, y + 10);
			mainScroll.child(child++, (start + (i + 4)), x + 555 - 254, y + 10);
			mainScroll.child(child++, (start + (i + 5)), x + 260 - 254, y + 0);
			y += 32;
		}

		RSInterface npcListScroll = RSInterface.addTabInterface(27700);// 54515
		npcListScroll.width = 100;
		npcListScroll.height = 231;
		npcListScroll.scrollMax = 300;
		int npcListMax = 249;//149
		RSInterface.setChildren(npcListMax, npcListScroll);
		int y2 = 0, child2 = 0;
		int interfaceId = 0;
		for (int i = 0; i < npcListMax * 2; i += 2) {
			RSInterface.addText((27701 + (i + 1)), "", tda, 0, Configuration.ORANGE, false, false,
					Configuration.WHITE, "Select", 99);
			RSInterface.textClicked((27701 + (i + 1)), 645, 1, 2);
			npcListScroll.child(child2++, (27701 + (i + 1)), 0, y2 + 3);
			interfaceId = (27701 + (i + 1));
			y2 += 18;
		}
		interfaceId = 30420;

		int yOffset = -57;
		RSInterface.addHoverButtonComplete(interfaceId, children, 19, 95 + yOffset, 999, 1000, 120,
				25, "Search an npc", tab, true);
		RSInterface.setSpriteClicked(interfaceId, 1001);
		children += 2;
		interfaceId += 3;

		RSInterface.addText(interfaceId, "Search an npc", tda, 0, Configuration.ORANGE, true);
		RSInterface.setBounds(interfaceId, 88, 102 + yOffset, children, tab);
		interfaceId++;
		children++;

		RSInterface.addHoverButtonComplete(interfaceId, children, 19, 120 + yOffset, 999, 1000, 120,
				25, "Search an item", tab, true);
		RSInterface.setSpriteClicked(interfaceId, 1001);
		children += 2;
		interfaceId += 3;

		RSInterface.addText(interfaceId, "Search an item", tda, 0, Configuration.ORANGE, true);
		RSInterface.setBounds(interfaceId, 88, 126 + yOffset, children, tab);
		interfaceId++;
		children++;
	}

	public static void crystalTele(TextDrawingArea[] tda) {
		RSInterface inter = addInterface(43900);
		addSprite(43901, 0, "Interfaces/Prestige/SPRITE");
		addText(43902, "Crystalline Teleports", tda, 2, 0xff9933, true, true);
		addClickableText(43903, "1. Crystalline Bat", "Teleport", tda, 1, 0xff9933, false, true, 130);
		addClickableText(43904, "2. Crystalline Bear", "Teleport", tda, 1, 0xff9933, false, true, 130);
		addClickableText(43905, "3. Crystalline Dark Beast", "Teleport", tda, 1, 0xff9933, false, true, 130);
		addClickableText(43906, "4. Crystalline Dragon", "Teleport", tda, 1, 0xff9933, false, true, 130);
		addClickableText(43907, "5. Crystalline Rat", "Teleport", tda, 1, 0xff9933, false, true, 130);
		addClickableText(43908, "6. Crystalline Scorpion", "Teleport", tda, 1, 0xff9933, false, true, 130);
		addClickableText(43909, "7. Crystalline Spider", "Teleport", tda, 1, 0xff9933, false, true, 130);
		addClickableText(43910, "8. Crystalline Unicorn", "Teleport", tda, 1, 0xff9933, false, true, 130);
		addClickableText(43911, "9. Crystalline Wolf", "Teleport", tda, 1, 0xff9933, false, true, 130);
		addClickableText(43912, "10. Crystalline Hunllef", "Teleport", tda, 1, 0xff9933, false, true, 130);
		addClickableText(43913, " ", "Teleport", tda, 1, 0xff9933, false, true, 130);
		addClickableText(43914, " ", "Teleport", tda, 1, 0xff9933, false, true,130);
		addClickableText(43915, " ", "Teleport", tda, 1, 0xff9933, false, true, 130);
		addClickableText(43916, " ", "Teleport", tda, 1, 0xff9933, false, true, 130);
		addClickableText(43917, " ", "Teleport", tda, 1, 0xff9933, false, true, 130);
		addClickableText(43918, " ", "Teleport", tda, 1, 0xff9933, false, true, 130);
		addClickableText(43919, " ", "Teleport", tda, 1, 0xff9933, false, true, 130);
		addClickableText(43920, " ", "Teleport", tda, 1, 0xff9933, false, true, 130);
		addClickableText(43921, " ", "Teleport", tda, 1, 0xff9933, false, true, 130);
		addClickableText(43922, " ", "Teleport", tda, 1, 0xff9933, false, true, 130);
		addClickableText(43923, " ", "Teleport", tda, 1, 0xff9933, false, true, 130);
		addClickableText(43924, " ", "Teleport", tda, 1, 0xff9933, false, true, 130);
		addClickableText(43925, " ", "Teleport", tda, 1, 0xff9933, false, true, 130);
		addClickableText(43926, " ", "Teleport", tda, 1, 0xff9933, false, true, 130);
		addClickableText(43927, " ", "Teleport", tda, 1, 0xff9933, false, true, 130);
		addClickableText(43928, " ", "Teleport", tda, 1, 0xff9933, false, true, 130);
		addClickableText(43929, " ", "Teleport", tda, 1, 0xff9933, false, true, 130);
		addClickableText(43930, " ", "Teleport", tda, 1, 0xff9933, false, true, 130);
		addClickableText(43931, " ", "Teleport", tda, 1, 0xff9933, false, true, 130);
		addHoverButton(43932, "Interfaces/HelpInterface/IMAGE", 2, 16, 16, "Close", -1, 43932, 3);
		addHoveredButton(43933, "Interfaces/HelpInterface/IMAGE", 3, 16, 16, 43933);

		inter.totalChildren(34);
		setBounds(43901, 15, 15, 0, inter);
		setBounds(43902, 250, 19, 1, inter);
		setBounds(43903, 50, 50, 2, inter);
		setBounds(43904, 50, 70, 3, inter);
		setBounds(43905, 50, 90, 4, inter);
		setBounds(43906, 50, 110, 5, inter);
		setBounds(43907, 50, 130, 6, inter);
		setBounds(43908, 50, 150, 7, inter);
		setBounds(43909, 50, 170, 8, inter);
		setBounds(43910, 50, 190, 9, inter);
		setBounds(43911, 50, 210, 10, inter);
		setBounds(43912, 50, 230, 11, inter);
		setBounds(43913, 200, 50, 12, inter);
		setBounds(43914, 200, 70, 13, inter);
		setBounds(43915, 200, 90, 14, inter);
		setBounds(43916, 200, 110, 15, inter);
		setBounds(43917, 200, 130, 16, inter);
		setBounds(43918, 200, 150, 17, inter);
		setBounds(43919, 200, 170, 18, inter);
		setBounds(43920, 200, 190, 19, inter);
		setBounds(43921, 200, 210, 20, inter);
		setBounds(43922, 200, 230, 21, inter);
		setBounds(43923, 350, 50, 22, inter);
		setBounds(43924, 350, 70, 23, inter);
		setBounds(43925, 350, 90, 24, inter);
		setBounds(43926, 350, 110, 25, inter);
		setBounds(43927, 350, 130, 26, inter);
		setBounds(43928, 350, 150, 27, inter);
		setBounds(43929, 350, 170, 28, inter);
		setBounds(43930, 350, 190, 29, inter);
		setBounds(43931, 350, 210, 30, inter);
		setBounds(43932, 479, 18, 31, inter);
		setBounds(43933, 479, 18, 32, inter);
	}

	private static void tournamentLobby(TextDrawingArea[] textDrawingAreas) {
		int interfaceId = 25980;
		RSInterface interfaces = RSInterface.addInterface(interfaceId);
		interfaceId++;
		RSInterface.setChildren(4, interfaces);
		int child = 0;
		int xOffset = 160;
		int yOffset = -21;


		addTransparentSprite(interfaceId, 724, "Interfaces/BountyHunter/IMAGE", 20);
		RSInterface.setBounds(interfaceId, 51 + xOffset, 24 + yOffset, child, interfaces);
		interfaceId++;
		child++;

		RSInterface.addText(interfaceId, "Lobby:", textDrawingAreas, 0, 0xff981f,
				false);
		RSInterface.setBounds(interfaceId, 57 + xOffset, 30 + yOffset, child, interfaces);
		interfaceId++;
		child++;

		RSInterface.addText(interfaceId, "Tournament:", textDrawingAreas, 0, 0xff981f,
				false);
		RSInterface.setBounds(interfaceId, 57 + xOffset, 44 + yOffset, child, interfaces);
		interfaceId++;
		child++;

		RSInterface.addText(interfaceId, "Next round in:", textDrawingAreas, 0,
				0xff981f, false);
		RSInterface.setBounds(interfaceId, 57 + xOffset, 58 + yOffset, child, interfaces);
		interfaceId++;
		child++;
	}

	public static void pvpTab(TextDrawingArea[] tda) {
		RSInterface pkerFeed = RSInterface.addTabInterface(17801);
		pkerFeed.totalChildren(10);
		int child = 0;
		for (int i = 17802, yPos = 3; i < 17812; i++, yPos += 20) {
			RSInterface.addText(i, "", tda, 1, 0xff9040, false, true);
			pkerFeed.children[child] = i;
			pkerFeed.childX[child] = 5;
			pkerFeed.childY[child] = yPos;
			child++;
		}
		pkerFeed.height = 90;
		pkerFeed.width = 174;
		pkerFeed.scrollMax = 230;

		/* Server feed */
		RSInterface serverFeed = RSInterface.addTabInterface(17813);
		serverFeed.totalChildren(10);
		child = 0;
		for (int i = 17814, yPos = 3; i < 17824; i++, yPos += 20) {
			RSInterface.addText(i, "", tda, 0, 0xff9040, false, true);
			serverFeed.children[child] = i;
			serverFeed.childX[child] = 5;
			serverFeed.childY[child] = yPos;
			child++;
		}
		serverFeed.height = 90;
		serverFeed.width = 174;
		serverFeed.scrollMax = 230;

		//The tab
		RSInterface tab = RSInterface.addTabInterface(17800);
		tab.totalChildren(7);

	//	RSInterface.addSprite(17827, 1418);
		addSprite(17827, 1418, "Interfaces/pvptab/IMAGE");
		addSprite(17828, 1418, "Interfaces/pvptab/IMAGE");
		//RSInterface.addSprite(17828, 1418);

		RSInterface.addText(17825, "@or1@Toplist - Best Online Pkers", tda, 2, 0xFFFFFF, false, true);
		RSInterface.addText(17826, "@or1@Feed", tda, 2, 0xFFFFFF, false, true);

		//RSInterface.addSprite(17830, 623);
		addSprite(17830, 623, "Interfaces/pvptab/");

		child = 0;

		tab.child(child++, 17830, 0, 0);
		tab.child(child++, 17827, 1, 30);
		tab.child(child++, 17828, 1, 163);

		tab.child(child++, 17801, 1, 32);
		tab.child(child++, 17825, 5, 12);
		tab.child(child++, 17813, 1, 165);
		tab.child(child++, 17826, 5, 146);
	}



	public static void achievementInterface(TextDrawingArea[] TDA) {
		RSInterface rsi = addTabInterface(35000);
		addSprite(35001, 517, "Interfaces/newachievements/IMAGE");
		addHoverButton(35002,"Interfaces/newachievements/IMAGE", 17, 15, 15, "Close", 250, 35003, 3);
		addHoveredButton(35003,"Interfaces/newachievements/IMAGE", 18, 15, 15, 35004);
		addText(35005, ""+Configuration.CLIENT_TITLE+" Achievements", TDA, 2, 0xF7AA25, true, true);
		addText(35006, "{ ACHIEVEMENT NAME }", TDA, 2, 0xBF7D0A, true, true);
		addText(35007, "Description:", TDA, 1, 0xF7AA25, false, true);
		addText(35008, "{ DESCRIPTION HERE }", TDA, 0, 0xD19732, false, true);
		addText(35009, "Difficulty:", TDA, 1, 0xF7AA25, false, true);
		addText(35010, "{ DIFFICULTY HERE }", TDA, 0, 0xD19732, false, true);
		addText(35011, "Progress:", TDA, 1, 0xF7AA25, false, true);
		addText(35012, "{ PROGRESS HERE }", TDA, 0, 0xD19732, false, true);
		addText(35013, "Reward:", TDA, 1, 0xF7AA25, false, true);
		addText(35014, "{ REWARD HERE }", TDA, 0, 0xD19732, false, true);
		addText(36000, "Other rewards:", TDA, 1, 0xff9040, false, true);
		addText(35015, "Completed: 3/10", TDA, 0, 0xBF7D0A, true, true);
		addText(35016, "Points: 12", TDA, 0, 0xBF7D0A, true, true);

		addItemContainer(36002, 2, 10, 0, 0, false);
		addHoverButton(35017,"Interfaces/newachievements/IMAGE", 513, 37, 25, "Easy", -1, 35018, 1);
		addHoveredButton(35018, "Interfaces/newachievements/IMAGE",514, 37, 25, 35019);
		addHoverButton(35020,"Interfaces/newachievements/IMAGE", 513, 37, 25, "Medium", -1, 35021, 1);
		addHoveredButton(35021,"Interfaces/newachievements/IMAGE", 514, 37, 25, 35022);
		addHoverButton(35023,"Interfaces/newachievements/IMAGE", 513, 37, 25, "Hard", -1, 35024, 1);
		addHoveredButton(35024,"Interfaces/newachievements/IMAGE", 514, 37, 25, 35025);
		addText(35026, "Easy", TDA, 0, 0xBF7D0A, true, true);
		addText(35027, "Med", TDA, 0, 0xBF7D0A, true, true);
		addText(35028, "Hard", TDA, 0, 0xBF7D0A, true, true);
		addConfigSpriteNew(35029,"Interfaces/newachievements/IMAGE", 518, 519, 0, 694);
		rsi.totalChildren(28);
		rsi.child(0, 35001, 14, 18);
		rsi.child(1, 35002, 467, 27);
		rsi.child(2, 35003, 470, 30);
		rsi.child(3, 35005, 270, 31);
		rsi.child(4, 35006, 340, 75);
		rsi.child(5, 35007, 200, 100);
		rsi.child(6, 35008, 210, 120);
		rsi.child(7, 35009, 200, 140);
		rsi.child(8, 35010, 210, 160);
		rsi.child(9, 35011, 200, 180);
		rsi.child(10, 35012, 210, 200);
		rsi.child(11, 35013, 200, 220);
		rsi.child(12, 35014, 210, 240);
		rsi.child(13, 35030, 22, 91);
		rsi.child(14, 35015, 260, 286);
		rsi.child(15, 35016, 420, 286);
		rsi.child(16, 35017, 40, 62);
		rsi.child(17, 35018, 40, 62);
		rsi.child(18, 35020, 83, 62);
		rsi.child(19, 35021, 83, 62);
		rsi.child(20, 35023, 125, 62);
		rsi.child(21, 35024, 125, 62);
		rsi.child(22, 35026, 57, 69);
		rsi.child(23, 35027, 101, 69);
		rsi.child(24, 35028, 142, 69);
		rsi.child(25, 35029, 463, 65);

		rsi.child(26, 36000, 380, 206);
		rsi.child(27, 36002, 408, 229);//365 229
		RSInterface scrollInterface = addTabInterface(35030);
		scrollInterface.scrollPosition = 0;
		scrollInterface.contentType = 0;
		scrollInterface.width = 138;
		scrollInterface.height = 218;
		scrollInterface.scrollMax = 500;
		int x = 7, y = 9;
		int amountOfLines = 50;
		scrollInterface.totalChildren(amountOfLines);
		for (int i = 0; i < amountOfLines; i++) {
			addHoverText(35031 + i, "", "View achievement", TDA, 0, 0xff0000, false, true, 168);
			scrollInterface.child(i, 35031 + i, x, y);
			y += 18;
		}
	}

	public static void playerProfiler(TextDrawingArea[] TDA) {
		RSInterface rsi = addInterface(41800);
		addSprite(41801, 359, "Interfaces/profileview/IMAGE");
		//addSprite(51801, 359);
		addText(41802, "Player Profiler", TDA, 2, 0xff981f, true, true);

		addHoverButton(41803,"Interfaces/newachievements/IMAGE", 17, 21, 21, "close", 250, 41804, 3);
		addHoveredButton(41804, "Interfaces/newachievements/IMAGE",18, 21, 21, 41805);
		addOtherChar(41806, 700);
		addText(41807, "</col>Name: @gre@rogue", TDA, 1, 0xff981f, true, true);
		addText(41808, "</col>Rank: @cr2@@gre@  Owner", TDA, 1, 0xff981f, true, true);
		addText(41809, "</col>Level: @gre@126", TDA, 1, 0xff981f, true, true);
		for (int i = 0; i < 21; i++) {
			addSprite(41810 + i, 324 + i, "Interfaces/profileview/IMAGE");
		}

		addHoverButton(41990,"Interfaces/profileview/IMAGE", 363, 30, 30, "Like", 0, 41991, 1);
		addHoveredButton(41991, "Interfaces/profileview/IMAGE",364, 30, 30, 41992);
		addHoverButton(41993,"Interfaces/profileview/IMAGE", 365, 30, 30, "dislike", 0, 41994, 1);
		addHoveredButton(41994, "Interfaces/profileview/IMAGE",366, 30, 30, 41995);

		rsi.totalChildren(55);//55
		rsi.child(8, 41880, 303, 49);
		RSInterface scrollInterface = addTabInterface(41880);
		scrollInterface.width = 170;
		scrollInterface.height = 267;
		scrollInterface.scrollMax = 450;
		setChildren(35, scrollInterface);
		int y = 0;
		for (int i = 0; i < 35; i++) {
			addHoverText(41881 + i, "" , "", TDA, 0, 0xff981f, true, true, 160, 0xff981f);
			setBounds(41881 + i, 0, y, i, scrollInterface);
			y += 20;
		}
		rsi.child(0, 41801, 10, 5);
		rsi.child(1, 41802, 255, 13);
		rsi.child(2, 41803, 478, 11);
		rsi.child(3, 41804, 478, 11);
		rsi.child(4, 41806, 35, 210);
		rsi.child(5, 41807, 105, 55);
		rsi.child(6, 41808, 105, 70);
		rsi.child(7, 41809, 105, 85);
		for (int i = 0; i < 20; i++) {
			rsi.child(9 + i, 41810 + i, 205 + (i / 10) * 36, 50 + (i % 10) * 25);
			addTooltipBoxNew(41832 + i, Skills.SKILL_NAMES[i].substring(0, 1).toUpperCase() + Skills.SKILL_NAMES[i].substring(1) + " level: 1/1\\nPrestige level: 1");
			interfaceCache[41832 + i].width = 25;
			interfaceCache[41832 + i].height = 25;
			rsi.child(30 + i, 41832 + i, 205 + (i / 10) * 36, 50 + (i % 10) * 25);
		}
		rsi.child(29, 41810 + 20, 222, 290);
		addTooltipBoxNew(41832 + 20, "Runecrafting level: 1/1\\nPrestige level: 1");
		interfaceCache[41832 + 20].width = 25;
		interfaceCache[41832 + 20].height = 25;
		rsi.child(50, 41832 + 20, 222, 290);
		rsi.child(51, 41990, 185, 10);
		rsi.child(52, 41991, 185, 10);
		rsi.child(53, 41993, 307, 10);
		rsi.child(54, 41994, 307, 10);
	}


	public static void profileTab(TextDrawingArea[] TDA) {
		RSInterface tab = addInterface(41500);
		addSprite(41501, 360, "Interfaces/profileview/IMAGE");
		addSprite(41502, 38, "Interfaces/profileview/IMAGE");

		addText(41503, "Player Profiler", TDA, 2, 0xF7AA25, true, true);

		addHoverButton(41504,"Interfaces/profileview/IMAGE", 44, 45, 45, "Search", 0, 41505, 1);
		addHoveredButton(41505, "Interfaces/profileview/IMAGE",45, 45, 45, 41506);

		addConfigButton(41507, 41500, 289, 290, "Interfaces/profileview/IMAGE", 14, 15, "Select", 1, 5, 1);
		addConfigButton(41508, 41500, 289, 290, "Interfaces/profileview/IMAGE", 14, 15, "Select", 2, 5, 1);


		addHoverText(41509, "Enable Privacy", "Enable", TDA, 0, 0xF7AA25, false, true, 60);
		addHoverText(41510, "Disable Privacy", "Disable", TDA, 0, 0xF7AA25, false, true, 60);
		addHoverButton(41511,"Interfaces/profileview/IMAGE", 36, 150, 35, "View my profile", 0, 41512, 1);
		addHoveredButton(41512, "Interfaces/profileview/IMAGE",37, 150, 35, 41513);




		addText(41514, "My Profile", TDA, 2, 0xF7AA25, true, true);
		addHoverButton(41515,"Interfaces/profileview/IMAGE", 36, 150, 35, "View profile leaderboards", 0, 41516, 1);
		addHoveredButton(41516, "Interfaces/profileview/IMAGE",37, 150, 35, 41517);


		addText(41518, "Leaderboards", TDA, 2, 0xF7AA25, true, true);
		addHoverButton(41519,"Interfaces/profileview/IMAGE", 362, 50, 20, "Settings", 0, 41520, 1);
		addHoveredButton(41520, "Interfaces/profileview/IMAGE",361, 50, 20, 41521);


		tab.totalChildren(18);
		tab.child(0, 41501, -4, 34);
		tab.child(1, 41502, -0, 34);
		tab.child(2, 41502, -0, 229);
		tab.child(3, 41503, 92, 9);
		tab.child(4, 41504, 0, 37);//37
		tab.child(5, 41505, 0, 37);//37
		tab.child(6, 41507, 50, 37);
		tab.child(7, 41508, 50, 56);
		tab.child(8, 41509, 70, 39);
		tab.child(9, 41510, 70, 58);
		tab.child(10, 41511, 20, 95);
		tab.child(11, 41512, 20, 95);
		tab.child(12, 41514, 92, 103);
		tab.child(13, 41515, 20, 155);
		tab.child(14, 41516, 20, 155);
		tab.child(15, 41518, 92, 163);
		tab.child(16, 41519, 1000, 1000);
		tab.child(17, 41520, 1000, 1000);
	}

	/**
	 * My Profile
	 * @param TDA
	 */
	public static void myProfile(TextDrawingArea[] TDA) {
		RSInterface tab = addInterface(41600);
		addSprite(41601, 359, "Interfaces/profileview/IMAGE");
		addText(41602, "My Profile", TDA, 2, 0xff981f, true, true);
		addHoverButton(41603,"Interfaces/newachievements/IMAGE", 17, 21, 21, "close", 250, 41604, 3);
		addHoveredButton(41604, "Interfaces/newachievements/IMAGE",18, 21, 21, 41605);
		addChar(41606, 700);//Adds the character to the interface
		addText(41607, "</col>Name: @gre@Rogue", TDA, 1, 0xff981f, true, true);
		addText(41608, "</col>Rank: @cr2@@gre@  Owner", TDA, 1, 0xff981f, true, true);
		addText(41609, "</col>Level: @gre@126", TDA, 1, 0xff981f, true, true);
		for (int i = 0; i < 21; i++) {
			addSprite(41610 + i, 324 + i, "Interfaces/profileview/IMAGE");
		}
		tab.totalChildren(51);
		tab.child(8, 41680, 303, 49);
		RSInterface scrollInterface = addTabInterface(41680);
		scrollInterface.width = 170;
		scrollInterface.height = 267;
		scrollInterface.scrollMax = 450;
		setChildren(35, scrollInterface);
		int y = 0;
		for (int i = 0; i < 35; i++) {
			addHoverText(41681 + i, "" , "", TDA, 0, 0xff981f, true, true, 160, 0xff981f);
			setBounds(41681 + i, 0, y, i, scrollInterface);
			y += 20;
		}
		tab.child(0, 41601, 10, 5);
		tab.child(1, 41602, 255, 13);
		tab.child(2, 41603, 478, 11);
		tab.child(3, 41604, 478, 11);
		tab.child(4, 41606, 35, 210);
		tab.child(5, 41607, 105, 55);
		tab.child(6, 41608, 105, 70);
		tab.child(7, 41609, 105, 85);
		for (int i = 0; i < 20; i++) {
			tab.child(9 + i, 41610 + i, 205 + (i / 10) * 36, 50 + (i % 10) * 25);
			addTooltipBoxNew(41632 + i, Skills.SKILL_NAMES[i].substring(0, 1).toUpperCase() + Skills.SKILL_NAMES[i].substring(1) + " level: 1/1\\nPrestige level: 1");
			interfaceCache[41632 + i].width = 25;
			interfaceCache[41632 + i].height = 25;
			tab.child(30 + i, 41632 + i, 205 + (i / 10) * 36, 50 + (i % 10) * 25);
		}
		tab.child(29, 41610 + 20, 222, 290);
		addTooltipBoxNew(41632 + 20, "Runecrafting level: 1/1\\nPrestige level: 1");
		interfaceCache[41632 + 20].width = 25;
		interfaceCache[41632 + 20].height = 25;
		tab.child(50, 41632 + 20, 222, 290);
	}


	public static void staffTab(TextDrawingArea[] TDA) {
		RSInterface tab = addInterface(43700);
		addSprite(43701, 360, "Interfaces/profileview/IMAGE");
		addSprite(43702, 38, "Interfaces/profileview/IMAGE");
		addText(43703, "Staff Tab", TDA, 2, 0xF7AA25, true, true);
		addText(43704, "You have access to all commands!", TDA, 0, 0xF7AA25, true, true);
		addText(43705, "</col>Rank: @red@<img=2> Owner", TDA, 0, 0xF7AA25, true, true);
		addHoverText(43706, "> Back to Quest Tab <", "Go back", TDA, 0, 0xF7AA25, true, true, 60);

		tab.totalChildren(8);
		tab.child(0, 43701, -4, 34);
		tab.child(1, 43702, -0, 34);
		tab.child(2, 43702, -0, 229);
		tab.child(3, 43703, 93, 4);
		tab.child(4, 43704, 93, 235);
		tab.child(5, 43710, 5, 36);
		tab.child(6, 43705, 93, 20);
		tab.child(7, 43706, 61, 247);

		String[] titles = {
				"Check bank user", "Kick user", "Mute user", "Unmute user", "Ban user",
				"Unban user", "Jail user", "Unjail user", "Move home user", "Copy user",
				"Ip ban user", "Get info user", "Demote user", "Give mod user", "Kill user",
				"Tele to user", "Tele to me user", "Check inventory user", "Random NPC user", "Refresh"
		};

		int amount = titles.length;

		RSInterface scrollInterface = addTabInterface(43710);
		scrollInterface.width = 170;
		scrollInterface.height = 192;
		scrollInterface.scrollMax = 665;
		setChildren(amount, scrollInterface);
		int y = 0;
		for (int i = 0; i < amount; i++) {
			addHoverText(43720 + i, titles[i] , "", TDA, 0, 0xff981f, true, true, 136, 25);
			setBounds(43720 + i, 15, y + 5, i, scrollInterface);
			y += 35;
		}

	}




	public static void creditsTab(TextDrawingArea[] TDA) {
		RSInterface tab = addInterface(44500);
		addSprite(44501, 38, "Interfaces/profileview/IMAGE");
		addText(44502, "CyphoraX special tab", 0xff9933, true, true, -1, TDA, 2);
		addSprite(44503, 55, "Interfaces/profileview/IMAGE");
		addText(44504, "Current Donation Tokens:", 0xff9933, true, true, -1, TDA, 0);
		addHoverText(44505, "Visit online store", "@red@Donate to CyphoraX!", TDA, 0, 0xF7AA25, true, true, 168);
		addSprite(44506, 56, "Interfaces/profileview/IMAGE");
		tab.totalChildren(9);
		tab.child(0, 44501, 0, 25);
		tab.child(1, 44502, 95, 5);
		tab.child(2, 44503, -5, 28);
		tab.child(3, 44504, 95, 35);
		tab.child(4, 44505, 12, 50);
		tab.child(5, 44506, 2, 79);
		tab.child(6, 44501, 0, 70);
		tab.child(7, 44501, 0, 254);
		tab.child(8, 44530, 5, 79);
		RSInterface scrollInterface = addTabInterface(44530);
		scrollInterface.parentID = 42500;
		scrollInterface.scrollPosition = 0;
		scrollInterface.atActionType = 0;
		scrollInterface.contentType = 0;
		scrollInterface.width = 169;
		scrollInterface.height = 167;
		scrollInterface.scrollMax = 600;//400
		int x = 7, y = 9;
		scrollInterface.totalChildren(35);
		for (int i = 0; i < 35; i++) {
			addHoverText(44531 + i, "", "Open shop", TDA, 0, 0xE3A724, true, true, 168, 25);//0xFFFFFF
			scrollInterface.child(i, 44531 + i, x, y);
			y += 18;
		}
	}


	public static void priceChecker(TextDrawingArea[] TDA) {
		RSInterface rsi = addInterface(45500);

		addSprite(45501, 243, "Interfaces/pricecheck/IMAGE");
		addItemContainer(45542, 7, 4, 35, 30, false,
				"Take 1", "Take 5", "Take 10","Take All", "Take X");

		addHoverButton(45502,"Interfaces/newachievements/IMAGE", 17, 21, 21, "close", -1, 45503, 3);//add sprite 17 to cache
		addHoveredButton(45503, "Interfaces/newachievements/IMAGE",18, 21, 21, 45504);//add sprite 18 to cache

		addHoverButton(45505,"Interfaces/pricecheck/IMAGE", 244, 36, 36, "Add all", -1, 45506, 1);//add sprite 244 to cache
		addHoveredButton(45506, "Interfaces/pricecheck/IMAGE",245, 36, 36, 45507);//add sprite 245 to cache

		addHoverButton(45578,"Interfaces/pricecheck/IMAGE", 246, 36, 36, "Withdraw all", -1, 45579, 1);//add sprite 246 to cache
		addHoveredButton(45579, "Interfaces/pricecheck/IMAGE",247, 36, 36, 45580);//add sprite 247 to cache

		addHoverButton(45508,"Interfaces/profileview/IMAGE", 44, 36, 36, "Search for item", -1, 45509, 1);
		addHoveredButton(45509, "Interfaces/profileview/IMAGE",45, 36, 36, 45510);

		addText(45511, "Price Checker", TDA, 2, 0xFF981F, true, true);
		addText(45512, "Total price:", TDA, 1, 0xFF981F, true, true);
		addText(45513, "115,424,152", TDA, 0, 0xffffff, true, true);
		addText(45550, "", TDA, 0, 0xffffff, true, true);
		addText(45551, "", TDA, 0, 0xffffff, true, true);
		addText(45552, "", TDA, 0, 0xffffff, true, true);
		addText(45553, "", TDA, 0, 0xffffff, true, true);
		addText(45554, "", TDA, 0, 0xffffff, true, true);
		addText(45555, "", TDA, 0, 0xffffff, true, true);
		addText(45556, "", TDA, 0, 0xffffff, true, true);
		addText(45557, "", TDA, 0, 0xffffff, true, true);
		addText(45558, "", TDA, 0, 0xffffff, true, true);
		addText(45559, "", TDA, 0, 0xffffff, true, true);
		addText(45560, "", TDA, 0, 0xffffff, true, true);
		addText(45561, "", TDA, 0, 0xffffff, true, true);
		addText(45562, "", TDA, 0, 0xffffff, true, true);
		addText(45563, "", TDA, 0, 0xffffff, true, true);
		addText(45564, "", TDA, 0, 0xffffff, true, true);
		addText(45565, "", TDA, 0, 0xffffff, true, true);
		addText(45566, "", TDA, 0, 0xffffff, true, true);
		addText(45567, "", TDA, 0, 0xffffff, true, true);
		addText(45568, "", TDA, 0, 0xffffff, true, true);
		addText(45569, "", TDA, 0, 0xffffff, true, true);
		addText(45570, "", TDA, 0, 0xffffff, true, true);
		addText(45571, "", TDA, 0, 0xffffff, true, true);
		addText(45572, "", TDA, 0, 0xffffff, true, true);
		addText(45573, "", TDA, 0, 0xffffff, true, true);
		addText(45574, "", TDA, 0, 0xffffff, true, true);
		addText(45575, "", TDA, 0, 0xffffff, true, true);
		addText(45576, "", TDA, 0, 0xffffff, true, true);
		addText(45577, "", TDA, 0, 0xffffff, true, true);
		rsi.totalChildren(41);
		rsi.child(0, 45501, 0, 0);
		rsi.child(1, 45502, 485, 7);
		rsi.child(2, 45503, 485, 7);
		rsi.child(3, 45505, 434, 290);
		rsi.child(4, 45506, 434, 290);
		rsi.child(5, 45508, 8, 290);
		rsi.child(6, 45509, 8, 290);
		rsi.child(7, 45511, 255, 10);
		rsi.child(8, 45512, 255, 290);
		rsi.child(9, 45513, 255, 310);
		rsi.child(10, 45542, 40, 45);
		rsi.child(11, 45550, 57, 80);
		rsi.child(12, 45551, 123, 80);
		rsi.child(13, 45552, 189, 80);
		rsi.child(14, 45553, 256, 80);
		rsi.child(15, 45554, 323, 80);
		rsi.child(16, 45555, 390, 80);
		rsi.child(17, 45556, 458, 80);
		rsi.child(18, 45557, 57, 142);
		rsi.child(19, 45558, 123, 142);
		rsi.child(20, 45559, 189, 142);
		rsi.child(21, 45560, 256, 142);
		rsi.child(22, 45561, 323, 142);
		rsi.child(23, 45562, 390, 142);
		rsi.child(24, 45563, 458, 142);
		rsi.child(25, 45564, 57, 204);
		rsi.child(26, 45565, 123, 204);
		rsi.child(27, 45566, 189, 204);
		rsi.child(28, 45567, 256, 204);
		rsi.child(29, 45568, 323, 204);
		rsi.child(30, 45569, 390, 204);
		rsi.child(31, 45570, 458, 204);
		rsi.child(32, 45571, 57, 266);
		rsi.child(33, 45572, 123, 266);
		rsi.child(34, 45573, 189, 266);
		rsi.child(35, 45574, 256, 266);
		rsi.child(36, 45575, 323, 266);
		rsi.child(37, 45576, 390, 266);
		rsi.child(38, 45577, 458, 266);
		rsi.child(39, 45578, 470, 290);
		rsi.child(40, 45579, 470, 290);
	}












	public static void addButton4(int id, int sid, String tooltip) {
		RSInterface tab = interfaceCache[id] = new RSInterface();
		tab.id = id;
		tab.parentID = id;
		tab.type = 5;
		tab.atActionType = 1;
		tab.contentType = 0;
		tab.spriteOpacity = (byte) 0;
		tab.hoverType = 52;
		tab.sprite1 = Client.cacheSprite4[sid];
		tab.sprite2 = Client.cacheSprite4[sid];
		tab.width = tab.sprite1.myWidth;
		tab.height = tab.sprite1.myHeight;
		tab.tooltip = tooltip;
	}

	public static void addSprite4(int childId, int spriteId) {
		RSInterface rsi = interfaceCache[childId] = new RSInterface();
		rsi.id = childId;
		rsi.parentID = childId;
		rsi.type = 5;
		rsi.atActionType = 0;
		rsi.contentType = 0;
		rsi.sprite1 = Client.cacheSprite4[spriteId];
		rsi.sprite2 = Client.cacheSprite4[spriteId];
		rsi.width = rsi.sprite1.myWidth;
		rsi.height = rsi.sprite2.myHeight - 2;
	}

	public static void newQuest(TextDrawingArea[] tda) {
		RSInterface tab = addTabInterface(46220);
		addHoverText(46221, "", "Visit our website", tda, 0, 0xff9b00, true, true, 150);
		addText(46222, "General information", tda, 2, 0xff9b00, false, true);

		addButton(46200, 86, "Interfaces/newquesttab/IMAGE", "View personal information");
		addButton(46471, 88, "Interfaces/newquesttab/IMAGE", "View achievements");
		addButton(46201, 158, "Interfaces/newquesttab/IMAGE", "View event information");

		addButton(46208, 323, "Interfaces/newquesttab/IMAGE", "Open the staff tab");


		addSprite(46029, 85, "Interfaces/newquesttab/IMAGE");
		addSprite(46224, 81, "Interfaces/newquesttab/IMAGE");
		addSprite(46223, 82, "Interfaces/newquesttab/IMAGE");
		addSprite(46025, 83, "Interfaces/newquesttab/IMAGE");

		addText(46405, "", tda, 2, 0xff9b00, true, true);
		tab.totalChildren(11);//10
		tab.child(0, 46221, 20, 247);
		tab.child(1, 46224, 3, 27+27);
		tab.child(2, 46223, 3, 24+27);
		tab.child(3, 55280, 3, 24+29);
		tab.child(4, 46200, 33, 2);
		tab.child(5, 46025, 3, 238);
		tab.child(6, 46029, 2, 2);
		tab.child(7, 46471, 33+31, 2);
		tab.child(8, 46222, 10, 31);
		tab.child(9, 46201, 33+31+31, 2);

		tab.child(10, 46208, 33+48+48, 2);

		RSInterface infoList = addTabInterface(55280);
		infoList.height = 188;
		infoList.width = 168;
		infoList.scrollMax = 289;//To make the scroll bar longer for more lines
		infoList.newScroller = false;

		addText(46406, "", tda, 2, 0xff9b00, false, true);
		addText(46407, "", tda, 0, 0xff9b00, false, true);
		addText(46408, "",  tda, 0, 0xff9b00, false, true);
		addText(46409, "", tda, 0, 0xff9b00, false, true);
		addText(46410, "",  tda, 0, 0xff9b00, false, true);
		addText(46411, "",  tda, 0, 0xff9b00, false, true);
		addText(46412, "", tda, 2, 0xff9b00, false, true);

		infoList.totalChildren(58);
		infoList.child(0, 46406, 7, 7);
		infoList.child(1, 46407, 7, 26);
		infoList.child(2, 46408, 7, 42);
		infoList.child(3, 46409, 7, 58);
		infoList.child(4, 46410, 7, 74);
		infoList.child(5, 46411, 7, 90);
		infoList.child(6, 46412, 8, 7);

		int x = 7, y = 11;
		infoList.totalChildren(37);
		for (int i = 0; i < 37; i++) {
			addHoverText(55225 + i, "", "Open", tda, 0, 0xE3A724, false, true, 150, 25);//0xFFFFFF
			infoList.child(i, 55225 + i, x, y);
			y += 12;
		}


		RSInterface quest = addTabInterface(46_520);
		try
		{
			addText(46_523, "Personal information", tda, 2, 0xff9b00, false, true);

			addButton(46471, 88, "Interfaces/newquesttab/IMAGE", "View achievements");//46471
			addButton(46026, 84, "Interfaces/newquesttab/IMAGE", "View general information");//46026


			addSprite(46467, 81, "Interfaces/newquesttab/IMAGE");
			addSprite(46_540, 87, "Interfaces/newquesttab/IMAGE");
			addSprite(46223, 82, "Interfaces/newquesttab/IMAGE");
			addSprite(46025, 83, "Interfaces/newquesttab/IMAGE");


			addText(46_522, "Total playtime:", tda, 0, 0xff9b00, true, true);

			quest.totalChildren(10);
			quest.child(0, 46467, 3, 27+27);
			quest.child(1, 46025, 3, 238);
			quest.child(2, 46471, 33+31, 2);//46471
			quest.child(3, 46223, 3, 51);
			quest.child(4, 46_522, 92, 247);
			quest.child(5, 47_921, 3, 24+29);
			quest.child(6, 46_540, 2, 2);
			quest.child(7, 46026, 2, 2);
			quest.child(8, 46_523, 10, 31);
			quest.child(9, 46201, 33+31+31, 2);

			RSInterface diaryList = addTabInterface(47_921);
			diaryList.height = 188;
			diaryList.width = 168;
			diaryList.scrollMax = 550;
			diaryList.newScroller = false;

			int amount = 60;//60

			diaryList.totalChildren(amount + 1);
			int Ypos2 = 11;
			int frameID2 = 1;
			for (int iD2 = 47_924; iD2 < 47_924+amount; iD2++) {
				addHoverText(iD2, "", "Click", tda,
						0, 16711680, false, true, 150);
				addText(47_990, "", tda, 2, 0xff9b00, false, true);
				diaryList.child(0, 47_990, 8, 8);
				diaryList.child(frameID2, iD2, 10, Ypos2);
				frameID2++;
				Ypos2 += 12;
				Ypos2++;
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		RSInterface achiev = addTabInterface(46_120);
		try
		{
			addText(47_523, "Achievement diaries", tda, 2, 0xff9b00, false, true);

			addButton(46200, 86, "Interfaces/newquesttab/IMAGE", "View personal information");///46200
			addButton(46026, 84, "Interfaces/newquesttab/IMAGE", "View general information");//46026

			addSprite(46467, 81, "Interfaces/newquesttab/IMAGE");
			addSprite(47_540, 89, "Interfaces/newquesttab/IMAGE");
			addSprite(46223, 82, "Interfaces/newquesttab/IMAGE");
			addSprite(46025, 83, "Interfaces/newquesttab/IMAGE");


			addText(46_522, "", tda, 0, 0xff9b00, true, true);

			achiev.totalChildren(10);
			achiev.child(0, 46467, 3, 27+27);
			achiev.child(1, 46025, 3, 238);
			achiev.child(2, 46200, 33, 2);//46200
			achiev.child(3, 46223, 3, 51);
			achiev.child(4, 46_522, 92, 247);
			achiev.child(5, 46_921, 3, 24+29);
			achiev.child(6, 47_540, 2, 2);
			achiev.child(7, 46026, 2, 2);//46026
			achiev.child(8, 47_523, 10, 31);
			achiev.child(9, 46201, 33+31+31, 2);

			RSInterface diaryList = addTabInterface(46_921);
			diaryList.height = 188;
			diaryList.width = 168;
			diaryList.scrollMax = 289;
			diaryList.newScroller = false;

			int amount = 60;

			diaryList.totalChildren(amount + 1);
			int Ypos2 = 11;
			int frameID2 = 1;
			for (int iD2 = 46_924; iD2 < 46_924+amount; iD2++) {
				addHoverText(iD2, "", "View", tda,
						0, 16711680, false, true, 150);
				addText(46_990, "", tda, 2, 0xff9b00, false, true);

				diaryList.child(0, 46_990, 8, 8);
				diaryList.child(frameID2, iD2, 10, Ypos2);
				frameID2++;
				Ypos2 += 12;
				Ypos2++;
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		RSInterface event = addTabInterface(46_820);
		try
		{
			addText(46_823, "Event information", tda, 2, 0xff9b00, false, true);

			addButton(46471, 88, "Interfaces/newquesttab/IMAGE", "View achievements");
			addButton(46200, 86, "Interfaces/newquesttab/IMAGE", "View personal information");
			addButton(46026, 84, "Interfaces/newquesttab/IMAGE", "View general information");

			addSprite(46467, 81, "Interfaces/newquesttab/IMAGE");
			addSprite(46494, 159, "Interfaces/newquesttab/IMAGE");
			addSprite(46223, 82, "Interfaces/newquesttab/IMAGE");
			addSprite(46025, 83, "Interfaces/newquesttab/IMAGE");


			addText(46_522, "", tda, 0, 0xff9b00, true, true);

			event.totalChildren(10);
			event.child(0, 46467, 3, 27+27);
			event.child(1, 46025, 3, 238);
			event.child(2, 46471, 33+31, 2);
			event.child(3, 46_522, 92, 247);
			event.child(4, 48_921, 3, 24+29);
			event.child(5, 46494, 2, 2);
			event.child(6, 46026, 2, 2);
			event.child(7, 46_223, 3, 24+27);
			event.child(8, 46200, 33, 2);
			event.child(9, 46823, 10, 31);

			RSInterface eventList = addTabInterface(48_921);
			eventList.height = 188;
			eventList.width = 168;
			eventList.scrollMax = 330;
			eventList.newScroller = false;

			int amount = 60;

			eventList.totalChildren(amount + 1);
			int Ypos2 = 11;
			int frameID2 = 1;
			for (int iD2 = 48_924; iD2 < 48_924+amount; iD2++) {
				addHoverText(iD2, "", "Click", tda,
						0, 16711680, false, true, 150);
				addText(48_990, "", tda, 2, 0xff9b00, false, true);
				eventList.child(0, 48_990, 8, 8);
				eventList.child(frameID2, iD2, 10, Ypos2);
				frameID2++;
				Ypos2 += 12;
				Ypos2++;
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}



	public static void raidsOverlay(TextDrawingArea[] TDA) {
		RSInterface rsi = addInterface(24000);

		int childId = 24001;

		addText(childId++, "Points: 0", 0xff9933, false, true, -1, TDA, 2);
		addText(childId++, "Party Size: 0", 0xff9933, false, true, -1, TDA, 2);
		addText(childId++, "Current Room: Start Room", 0xff9933, false, true, -1, TDA, 2);
		addText(childId++, "", 0xff9933, false, true, -1, TDA, 2);

		rsi.totalChildren(childId - 24001);

		childId = 24001;
		int frame = 0;

		rsi.child(frame++, childId++, 10, 285);//Background
		rsi.child(frame++, childId++, 10, 300);//Title
		rsi.child(frame++, childId++, 10, 315); //Bottom text 2
		rsi.child(frame++, childId, 10, 270); //Bottom text 2
	}



	public static void sigilSystem(TextDrawingArea[] tda) {
		int componentId = 60500;
		int mainIndex = 0, leftIndex = 0, rightIndex = 0;
		String dir = "Interfaces/SigilSystem/IMAGE";
		RSInterface widget = addInterface(componentId++);
		widget.totalChildren(6);//5

		addSprite(componentId, 0, dir);
		setBounds(componentId++, 11, 21, mainIndex++, widget);

		newHoveredButton(componentId, "Close", 4, 3, dir);
		setBounds(componentId++, 471, 28, mainIndex++, widget);

		addText(componentId, ""+Configuration.CLIENT_TITLE+" Advanced Perk System", tda, 2, 16750623, true, true);
		setBounds(componentId++, 254, 31, mainIndex++, widget);

		int leftContainerId = componentId++;
		int totalBoxes = 14;//14
		RSInterface leftContainer = addInterface(leftContainerId);
		leftContainer.totalChildren(4 * totalBoxes);
		leftContainer.height = 259;
		leftContainer.width = 162;
		leftContainer.scrollMax = totalBoxes * 19;//52

		for(int index = 0, y = 0; index < totalBoxes; index++, y += 52) {
			addPixels(componentId, 0x5D5140, 160, 50, 0, true);
			setBounds(componentId++, 1, 1 + y, leftIndex++, leftContainer);

			newHoverButtonConfig(componentId, "Open", 2, 1, dir, 1333, 1 + index);
			setBounds(componentId++, 2, 2 + y, leftIndex++, leftContainer);

			itemGroup(componentId, 1, 1, 0, 0, false, false);
			setBounds(componentId++, 10, 10 + y, leftIndex++, leftContainer);

			addText(componentId, "NAME OF SIGIL\\HERE", tda, 2, 16750623, true, true);
			setBounds(componentId++, 95, 11 + y, leftIndex++, leftContainer);
		}

		int rightContainerId = componentId++;
		RSInterface rightContainer = addInterface(rightContainerId);
		rightContainer.totalChildren(1);
		int totalRows = 15;//15
		rightContainer.height = 259;
		rightContainer.width = 276;
		rightContainer.scrollMax = totalRows * 42;
		int x = 7, y = 11;
		rightContainer.totalChildren(50);
		for (int i = 0; i < 50; i++) {
			addHoverText(60562 + i, "", "Unlock", tda, 0, 0xE3A724, false, true, 150, 25);//0xFFFFFF
			rightContainer.child(i, 60562 + i, x, y);
			y += 12;


		}
		//addHoverText(60500, "> Reset Perks <", "Reset", tda, 0, 0xF7AA25, true, true, 60);
		//setBounds(componentId++, 471, 28, mainIndex++, widget);

		setBounds(leftContainerId, 17, 56, mainIndex++, widget);
		setBounds(rightContainerId, 201, 56, mainIndex++, widget);
	}

	public static void addPixels(int id, int color, int width, int height, int alpha, boolean filled) {
		RSInterface rsi = addInterface(id);
		rsi.type = 3;
		rsi.aByte254 = (byte)alpha;
		rsi.textColor = color;
		rsi.anInt216 = color;
		rsi.secondaryColor = color;
		rsi.anInt239 = color;
		rsi.aBoolean227 = filled;
		rsi.width = width;
		rsi.height = height;
	}


	public static void newHoverButtonConfig(int id, String tooltip, int enabledSprite, int disabledSprite, String dir, int configId, int configFrame) {
		RSInterface tab = addInterface(id);
		tab.tooltip = tooltip;
		tab.atActionType = 1;
		tab.type = TYPE_HOVER;

		tab.anIntArray245 = new int[1];
		tab.anIntArray212 = new int[1];
		tab.anIntArray245[0] = 1;
		tab.anIntArray212[0] = configId;
		tab.valueIndexArray = new int[1][3];
		tab.valueIndexArray[0][0] = 5;
		tab.valueIndexArray[0][1] = configFrame;
		tab.valueIndexArray[0][2] = 0;

		tab.sprite1 = imageLoader(enabledSprite, dir);
		tab.sprite2 = imageLoader(disabledSprite, dir);
		tab.width = tab.sprite1.myWidth;
		tab.height = tab.sprite2.myHeight;
		tab.toggled = false;
		tab.spriteOpacity = 255;
	}


	public static void newHoveredButton(int id, String tooltip, int enabledSprite, int disabledSprite, String dir) {
		RSInterface tab = addInterface(id);
		tab.tooltip = tooltip;
		tab.atActionType = 1;
		tab.type = TYPE_HOVER;
		tab.sprite1 = imageLoader(enabledSprite, dir);
		tab.sprite2 = imageLoader(disabledSprite, dir);
		tab.width = tab.sprite1.myWidth;
		tab.height = tab.sprite2.myHeight;
		tab.toggled = false;
		tab.spriteOpacity = 255;
	}


}
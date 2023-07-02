package com.client;

import java.time.LocalDateTime;

public class Configuration {

	public static int frameWidth = 765;
	public static int frameHeight = 503;

	// set this to true for local host false for live vps server
	public static boolean LOCAL_HOST = false;// Change to false for live client.

	public static boolean DEBUG_MODE = false;

	/**
	 * Client version is a number that will tell the server whether
	 * the player has the most up-to-date client, otherwise they
	 * will receive an error on login to update their client.
	 */
	public static final int CLIENT_VERSION = 236;

	/**
	 * Cache version is written to the cache folder inside a version file.
	 * This is read on startup to tell if the cache is out of date or not.
	 */
	public static final int CACHE_VERSION = 8; // Change this up one when making cache updates.

	public static final String CACHE_LINK = "https://cyphorax.com/debunk/.yanillev2.zip";

	/**
	 * The server version. The cache path is append with a _v1/2/3 etc for the version number
	 * to prevent overwriting older version caches.
	 * This should only be changed when a new server is launched, otherwise change {@link Configuration#CLIENT_VERSION}.
	 */

	public static final int SERVER_VERSION = 3; //this is the current one src old here


	public static final String CLIENT_TITLE = "CyphoraX";
	public static final String WEBSITE = "https://cyphorax.com";
	public static final String DEDICATED_SERVER_ADDRESS = "127.0.0.1"; //158.69.62.205
	public static final String TEST_SERVER_ADDRESS = LOCAL_HOST ? "216.158.233.150" : "216.158.233.150";
	public static final int PORT = 43595;
	public static final int TEST_PORT = 43595;
	public static final int CACHE_FOLDER_VERSION = 1;
	public static final String CACHE_NAME = ".cyphorax";
	public static final String DEV_CACHE_NAME = "local_cache";
	public static final String CACHE_NAME_DEV = CACHE_NAME + "_dev";

	public static final String CUSTOM_ITEM_SPRITES_DIRECTORY = "item_sprites/";
	public static String CUSTOM_MAP_DIRECTORY = "./data/custom_maps/";
	public static String CUSTOM_MODEL_DIRECTORY = "./data/custom_models/";
	public static String CUSTOM_ANIMATION_DIRECTORY = "./data/custom_animations/";
	public static String EXTERNAL_CACHE_ARCHIVE = "/archive_data/";
	public static String INDEX_DATA_DIRECTORY = "/index_data/";

	public static boolean developerMode = false;
	public static boolean loadExternalCacheArchives = false; // Always true because I can't seem to pack them correctly
	public static boolean packIndexData = false;
	public static boolean dumpMaps = false;
	public static boolean dumpAnimationData = false;
	public static boolean dumpDataLists = false;
	public static boolean newFonts; // TODO text offsets (i.e. spacing between characters) are incorrect, needs automatic fix from kourend
	public static String cacheName = CACHE_NAME;
	public static String clientTitle = "";

	public static final LocalDateTime LAUNCH_TIME = LocalDateTime.now();
	public static final String ERROR_LOG_DIRECTORY = "error_logs/";
	public static String ERROR_LOG_FILE = ("error_log_"
		+ LAUNCH_TIME.getYear() + "_"
		+ LAUNCH_TIME.getMonth() + "_"
		+ LAUNCH_TIME.getDayOfMonth()
		+ ".txt").toLowerCase();

	/**
	 * Attack option priorities 0 -> Depends on combat level 1 -> Always right-click
	 * 2 -> Left-click where available 3 -> Hidden
	 */
	public static int playerAttackOptionPriority;
	public static int npcAttackOptionPriority = 2;

	public static final boolean DUMP_SPRITES = false;
	public static final boolean PRINT_EMPTY_INTERFACE_SECTIONS = false;

	public static boolean playerNames;

	/**
	 * Seasonal Events
	 */
	public static boolean HALLOWEEN;
	public static boolean CHRISTMAS;
	public static boolean CHRISTMAS_EVENT;
	public static boolean EASTER;

	public static boolean osbuddyGameframe;

	public static int xpPosition;
	public static boolean escapeCloseInterface;
	public static boolean alwaysLeftClickAttack;
	public static boolean hideCombatOverlay;


	public final static int YELLOW = 0xffff01;

	public final static int BLUE = 0x005aff;

	public final static int GOLD = 0xffc600;

	public final static int WHITE = 0xffffff;

	public final static int ORANGE = 0xff981f;

	public final static int BLACK = 0x000000;

	public final static int PALE_ORANGE = 0xc8aa64;

	public final static int RED = 0xfe3200;

	public final static int DARK_BLUE = 0x000080;

	public final static int GREEN = 0x09FF00;

	public final static int PALE_GREEN = 0x46b556;

	public static boolean enablePouch;
	public static boolean statusBars;
	public static boolean menuHovers;

}

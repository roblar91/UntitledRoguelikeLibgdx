package knc.rogue.util;

import java.util.logging.Level;

public final class Settings {
    public static final int TILE_WIDTH = 32;
    public static final int TILE_HEIGHT = 32;

    public static int WINDOW_WIDTH = 1600;
    public static int WINDOW_HEIGHT = 900;
    public static boolean FULLSCREEN = false;
    public static int CONSOLE_WIDTH = 40;
    public static int CONSOLE_HEIGHT = 10;
    public static float TILE_SCALE = 1f;
    public static float UI_SCALE = 1f;
    public static String TITLE = "Rogue";

    public static boolean BUMP_ATTACK = true;
    public static float BRIGHTNESS_BOOST = 1f;
    public static float BRIGHTNESS_MIN = 0.6f;
    public static Level LOG_LEVEL = Level.INFO;
}

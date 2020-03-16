package knc.rogue.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import knc.rogue.Rogue;
import knc.rogue.util.Settings;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

		config.title = Settings.TITLE;
		config.width = Settings.WINDOW_WIDTH;
		config.height = Settings.WINDOW_HEIGHT;

		new LwjglApplication(new Rogue(), config);
	}
}

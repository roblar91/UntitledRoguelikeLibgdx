package knc.rogue.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import knc.rogue.Rogue;
import knc.rogue.util.Settings;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

		config.title = Settings.TITLE;
		config.width = Settings.WIDTH;
		config.height = Settings.HEIGHT;

		new LwjglApplication(new Rogue(), config);
	}
}
package knc.rogue.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import knc.rogue.Rogue;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

		config.title = Rogue.TITLE;
		config.width = Rogue.WIDTH;
		config.height = Rogue.HEIGHT;

		new LwjglApplication(new Rogue(), config);
	}
}

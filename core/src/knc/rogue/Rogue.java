package knc.rogue;

import com.badlogic.gdx.Game;
import knc.rogue.screen.GameScreen;
import knc.rogue.util.Settings;

import java.util.logging.Handler;
import java.util.logging.Logger;

public class Rogue extends Game {
	@Override
	public void create () {
		Handler handler = new ColorConsoleHandler();
		handler.setLevel(Settings.LOG_LEVEL);
		Logger logger = Logger.getLogger("knc");
		logger.setUseParentHandlers(false);
		logger.setLevel(Settings.LOG_LEVEL);
		logger.addHandler(handler);

		setScreen(new GameScreen());
	}
}

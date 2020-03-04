package knc.rogue;

import com.badlogic.gdx.Game;
import knc.rogue.screen.GameScreen;

public class Rogue extends Game {
	public static final String TITLE = "Rogue";
	public static final int WIDTH = 1024;
	public static final int HEIGHT = 768;

	@Override
	public void create () {
		setScreen(new GameScreen());
	}
}

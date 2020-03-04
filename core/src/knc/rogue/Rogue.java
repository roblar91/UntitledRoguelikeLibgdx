package knc.rogue;

import com.badlogic.gdx.Game;
import knc.rogue.screen.GameScreen;

public class Rogue extends Game {
	@Override
	public void create () {
		setScreen(new GameScreen());
	}
}

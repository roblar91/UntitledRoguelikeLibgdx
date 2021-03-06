package knc.rogue.system;

import com.artemis.BaseSystem;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import knc.rogue.util.CompassDirection;

import java.util.logging.Logger;

public class KeyboardInputSystem extends BaseSystem {
    private final static Logger LOGGER = Logger.getLogger(KeyboardInputSystem.class.getName());
    private PlayerSystem playerSystem;
    private MovementSystem movementSystem;

    @Override
    protected void processSystem() {
        if(playerSystem.isPlayerTurn()) {
            if(Gdx.input.isKeyJustPressed(Input.Keys.NUMPAD_1)) {
                LOGGER.fine("KEYPRESS: NUMPAD_1");
                movementSystem.attemptMove(playerSystem.getPlayer(), CompassDirection.SOUTHWEST);
                playerSystem.setPlayerTurn(false);
            } else if(Gdx.input.isKeyJustPressed(Input.Keys.NUMPAD_2)) {
                LOGGER.fine("KEYPRESS: NUMPAD_2");
                movementSystem.attemptMove(playerSystem.getPlayer(), CompassDirection.SOUTH);
                playerSystem.setPlayerTurn(false);
            } else if(Gdx.input.isKeyJustPressed(Input.Keys.NUMPAD_3)) {
                LOGGER.fine("KEYPRESS: NUMPAD_3");
                movementSystem.attemptMove(playerSystem.getPlayer(), CompassDirection.SOUTHEAST);
                playerSystem.setPlayerTurn(false);
            } else if(Gdx.input.isKeyJustPressed(Input.Keys.NUMPAD_4)) {
                LOGGER.fine("KEYPRESS: NUMPAD_4");
                movementSystem.attemptMove(playerSystem.getPlayer(), CompassDirection.WEST);
                playerSystem.setPlayerTurn(false);
            } else if(Gdx.input.isKeyJustPressed(Input.Keys.NUMPAD_6)) {
                LOGGER.fine("KEYPRESS: NUMPAD_6");
                movementSystem.attemptMove(playerSystem.getPlayer(), CompassDirection.EAST);
                playerSystem.setPlayerTurn(false);
            } else if(Gdx.input.isKeyJustPressed(Input.Keys.NUMPAD_7)) {
                LOGGER.fine("KEYPRESS: NUMPAD_7");
                movementSystem.attemptMove(playerSystem.getPlayer(), CompassDirection.NORTHWEST);
                playerSystem.setPlayerTurn(false);
            } else if(Gdx.input.isKeyJustPressed(Input.Keys.NUMPAD_8)) {
                LOGGER.fine("KEYPRESS: NUMPAD_8");
                movementSystem.attemptMove(playerSystem.getPlayer(), CompassDirection.NORTH);
                playerSystem.setPlayerTurn(false);
            } else if(Gdx.input.isKeyJustPressed(Input.Keys.NUMPAD_9)) {
                LOGGER.fine("KEYPRESS: NUMPAD_9");
                movementSystem.attemptMove(playerSystem.getPlayer(), CompassDirection.NORTHEAST);
                playerSystem.setPlayerTurn(false);
            }
        }

        if(Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)) {
            LOGGER.fine("KEYPRESS: ESCAPE");
            Gdx.app.exit();
        }
    }
}

package knc.rogue.system;

import com.artemis.BaseSystem;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import knc.rogue.system.map.PlayerSystem;
import knc.rogue.util.CompassDirection;

public class KeyboardInputSystem extends BaseSystem {
    private PlayerSystem playerSystem;
    private MovementSystem movementSystem;

    @Override
    protected void processSystem() {
        if(Gdx.input.isKeyJustPressed(Input.Keys.NUMPAD_1)) {
            movementSystem.attemptMove(playerSystem.player, CompassDirection.SOUTHWEST);
        } else if(Gdx.input.isKeyJustPressed(Input.Keys.NUMPAD_2)) {
            movementSystem.attemptMove(playerSystem.player, CompassDirection.SOUTH);
        } else if(Gdx.input.isKeyJustPressed(Input.Keys.NUMPAD_3)) {
            movementSystem.attemptMove(playerSystem.player, CompassDirection.SOUTHEAST);
        } else if(Gdx.input.isKeyJustPressed(Input.Keys.NUMPAD_4)) {
            movementSystem.attemptMove(playerSystem.player, CompassDirection.WEST);
        } else if(Gdx.input.isKeyJustPressed(Input.Keys.NUMPAD_6)) {
            movementSystem.attemptMove(playerSystem.player, CompassDirection.EAST);
        } else if(Gdx.input.isKeyJustPressed(Input.Keys.NUMPAD_7)) {
            movementSystem.attemptMove(playerSystem.player, CompassDirection.NORTHWEST);
        } else if(Gdx.input.isKeyJustPressed(Input.Keys.NUMPAD_8)) {
            movementSystem.attemptMove(playerSystem.player, CompassDirection.NORTH);
        } else if(Gdx.input.isKeyJustPressed(Input.Keys.NUMPAD_9)) {
            movementSystem.attemptMove(playerSystem.player, CompassDirection.NORTHEAST);
        }
    }
}

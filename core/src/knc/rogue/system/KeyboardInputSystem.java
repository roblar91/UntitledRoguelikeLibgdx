package knc.rogue.system;

import com.artemis.BaseSystem;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import knc.rogue.command.MoveCommand;
import knc.rogue.system.map.PlayerSystem;
import knc.rogue.util.CompassDirection;

public class KeyboardInputSystem extends BaseSystem {
    CommandSystem commandSystem;
    PlayerSystem playerSystem;

    @Override
    protected void processSystem() {
        if(Gdx.input.isKeyJustPressed(Input.Keys.NUMPAD_1)) {
            commandSystem.queueCommand(new MoveCommand(playerSystem.player, CompassDirection.SOUTHWEST));
        } else if(Gdx.input.isKeyJustPressed(Input.Keys.NUMPAD_2)) {
            commandSystem.queueCommand(new MoveCommand(playerSystem.player, CompassDirection.SOUTH));
        } else if(Gdx.input.isKeyJustPressed(Input.Keys.NUMPAD_3)) {
            commandSystem.queueCommand(new MoveCommand(playerSystem.player, CompassDirection.SOUTHEAST));
        } else if(Gdx.input.isKeyJustPressed(Input.Keys.NUMPAD_4)) {
            commandSystem.queueCommand(new MoveCommand(playerSystem.player, CompassDirection.WEST));
        } else if(Gdx.input.isKeyJustPressed(Input.Keys.NUMPAD_6)) {
            commandSystem.queueCommand(new MoveCommand(playerSystem.player, CompassDirection.EAST));
        } else if(Gdx.input.isKeyJustPressed(Input.Keys.NUMPAD_7)) {
            commandSystem.queueCommand(new MoveCommand(playerSystem.player, CompassDirection.NORTHWEST));
        } else if(Gdx.input.isKeyJustPressed(Input.Keys.NUMPAD_8)) {
            commandSystem.queueCommand(new MoveCommand(playerSystem.player, CompassDirection.NORTH));
        } else if(Gdx.input.isKeyJustPressed(Input.Keys.NUMPAD_9)) {
            commandSystem.queueCommand(new MoveCommand(playerSystem.player, CompassDirection.NORTHEAST));
        }
    }
}

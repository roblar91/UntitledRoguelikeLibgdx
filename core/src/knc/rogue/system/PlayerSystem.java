package knc.rogue.system;

import com.artemis.E;
import com.badlogic.gdx.graphics.Color;
import knc.rogue.component.Character;
import knc.rogue.data.asset.PlayerAssets;
import knc.rogue.util.Formulae;
import net.mostlyoriginal.api.system.core.PassiveSystem;

import java.util.logging.Logger;

public class PlayerSystem extends PassiveSystem {
    private final static Logger LOGGER = Logger.getLogger(KeyboardInputSystem.class.getName());
    private E player;
    private boolean playerTurn = false;

    @Override
    protected void initialize() {
        super.initialize();

        if(player == null) {
            LOGGER.info("Creating player entity");
            player = E.E();
            player.player()
                  .cameraFollow()
                  .characterBehaviour(Character.Behaviour.PLAYER)
                  .alive()
                  .energy()
                  .name("Player", Color.BLUE)
                  .tileSprite(PlayerAssets.getHumanFemale())
                  .meleeAttack()
                  .constitution(10)
                  .strength(10)
                  .health(100)
                  .healthMaxHealth(Formulae.calculateMaxHealth(player))
                  .healthCurrentHealth(Formulae.calculateMaxHealth(player))
                  .sight(8)
                  .justMoved();
        }
    }

    public E getPlayer() {
        return player;
    }

    public boolean isPlayerTurn() {
        return playerTurn;
    }

    public void setPlayerTurn(boolean playerTurn) {
        this.playerTurn = playerTurn;
    }
}

package knc.rogue.system;

import com.artemis.E;
import com.badlogic.gdx.graphics.Color;
import knc.rogue.data.asset.PlayerAssets;
import knc.rogue.util.Formulae;
import net.mostlyoriginal.api.system.core.PassiveSystem;

import java.util.logging.Logger;

public class PlayerSystem extends PassiveSystem {
    private final static Logger LOGGER = Logger.getLogger(KeyboardInputSystem.class.getName());
    public E player;

    @Override
    protected void initialize() {
        super.initialize();

        if(player == null) {
            LOGGER.info("Creating player entity");
            player = E.E();
            player.player()
                  .cameraFollow()
                  .character()
                  .alive()
                  .name("Player", Color.BLUE)
                  .tileSprite(PlayerAssets.getHumanFemale())
                  .meleeAttack()
                  .baseHealth(100)
                  .baseConstitution(10)
                  .baseStrength(10)
                  .health(Formulae.calculateMaxHealth(player))
                  .sight(8)
                  .justMoved();
        }
    }
}

package knc.rogue.system;

import com.artemis.BaseSystem;
import com.artemis.E;
import knc.rogue.data.asset.PlayerAssets;
import knc.rogue.util.Formulae;

public class PlayerSystem extends BaseSystem {
    public E player;

    @Override
    protected void initialize() {
        super.initialize();

        if(player == null) {
            player = E.E();
            player.player()
                  .cameraFollow()
                  .character()
                  .name("Player")
                  .tileSprite(PlayerAssets.getHumanFemale())
                  .meleeAttack()
                  .baseHealth(100)
                  .baseConstitution(10)
                  .baseStrength(10)
                  .health(Formulae.calculateMaxHealth(player));
        }
    }

    @Override
    protected void processSystem() {
    }
}

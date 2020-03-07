package knc.rogue.system.map;

import com.artemis.BaseSystem;
import com.artemis.E;
import knc.rogue.data.asset.PlayerAssets;

public class PlayerSystem extends BaseSystem {
    public E player;

    @Override
    protected void initialize() {
        super.initialize();

        if(player == null) {
            player = E.E();
            player.player()
                  .solid()
                  .cameraFollow()
                  .character()
                  .tileSprite(PlayerAssets.getHumanFemale());
        }
    }

    @Override
    protected void processSystem() {
    }
}

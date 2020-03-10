package knc.rogue.data;

import com.artemis.E;
import knc.rogue.data.asset.StoneMapAsset;
import knc.rogue.system.KeyboardInputSystem;

import java.util.logging.Logger;

public final class TerrainFactory {
    private final static Logger LOGGER = Logger.getLogger(KeyboardInputSystem.class.getName());

    public static E createTerrain(SpawnType type,
                                  int posX,
                                  int posY,
                                  int areaId) {

        E e = E.E()
               .terrain()
               .position(posX, posY, areaId);

        switch(type) {
            case FLOOR_STONE:
                e.tileSprite(StoneMapAsset.getFloor());
                break;
            case WALL_STONE:
                e.tileSprite(StoneMapAsset.getWall())
                 .solid();
                break;
        }

        LOGGER.fine("Terrain created at position  " + e.getPosition().toString());
        return e;
    }
}

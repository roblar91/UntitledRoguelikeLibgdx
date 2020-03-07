package knc.rogue.data;

import com.artemis.E;
import knc.rogue.data.asset.StoneMapAsset;

public final class TerrainFactory {
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

        return e;
    }
}

package knc.rogue.data;

import com.artemis.E;
import knc.rogue.data.asset.StoneMapAsset;

public final class ObjectFactory {
    public static E createObject(SpawnType type,
                                  int posX,
                                  int posY,
                                  int areaId) {

        E e = E.E()
               .mapObject()
               .position(posX, posY, areaId);

        switch(type) {
            case ENTRANCE_ROCK:
                e.tileSprite(StoneMapAsset.getEntrance())
                 .entrance();
                break;
            case EXIT_ROCK:
                e.tileSprite(StoneMapAsset.getExit())
                 .exit();
                break;
        }

        return e;
    }
}

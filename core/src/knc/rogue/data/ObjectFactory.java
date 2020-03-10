package knc.rogue.data;

import com.artemis.E;
import knc.rogue.data.asset.StoneMapAsset;
import knc.rogue.system.KeyboardInputSystem;

import java.util.logging.Logger;

public final class ObjectFactory {
    private final static Logger LOGGER = Logger.getLogger(KeyboardInputSystem.class.getName());

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

        LOGGER.fine("Object created at position  " + e.getPosition().toString());
        return e;
    }
}

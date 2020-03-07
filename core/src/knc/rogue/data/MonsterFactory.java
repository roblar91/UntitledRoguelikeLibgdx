package knc.rogue.data;

import com.artemis.E;
import knc.rogue.data.asset.MonsterAssets;

public final class MonsterFactory {
    public static E createMonster(MonsterType type,
                                  int areaId,
                                  int posX,
                                  int posY) {

        E e = E.E()
               .position(posX, posY);

        switch(type) {
            case BAT:
                e.tileSprite(MonsterAssets.getBat());
                break;
        }

        return e;
    }
}

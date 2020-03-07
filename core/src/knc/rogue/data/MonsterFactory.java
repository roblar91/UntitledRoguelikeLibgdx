package knc.rogue.data;

import com.artemis.E;
import knc.rogue.data.asset.MonsterAssets;

public final class MonsterFactory {
    public static E createMonster(SpawnType type,
                                  int posX,
                                  int posY,
                                  int areaId) {

        E e = E.E()
               .position(posX, posY);

        switch(type) {
            case MONSTER_BAT:
                e.tileSprite(MonsterAssets.getBat());
                break;
        }

        return e;
    }
}

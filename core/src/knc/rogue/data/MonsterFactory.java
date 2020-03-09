package knc.rogue.data;

import com.artemis.E;
import knc.rogue.data.asset.MonsterAssets;
import knc.rogue.util.Formulae;

public final class MonsterFactory {
    public static E createMonster(SpawnType type,
                                  int posX,
                                  int posY,
                                  int areaId) {

        E e = E.E()
               .position(posX, posY, areaId)
               .character()
               .alive()
               .hostile();

        switch(type) {
            case MONSTER_BAT:
                e.tileSprite(MonsterAssets.getBat())
                 .name("Bat")
                 .meleeAttack()
                 .baseHealth(10)
                 .baseConstitution(1)
                 .baseStrength(1)
                 .health(Formulae.calculateMaxHealth(e));
                break;
        }

        return e;
    }
}

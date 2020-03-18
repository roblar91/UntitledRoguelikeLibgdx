package knc.rogue.data;

import com.artemis.E;
import com.badlogic.gdx.graphics.Color;
import knc.rogue.data.asset.MonsterAssets;
import knc.rogue.system.KeyboardInputSystem;
import knc.rogue.util.Formulae;

import java.util.logging.Logger;

public final class MonsterFactory {
    private final static Logger LOGGER = Logger.getLogger(KeyboardInputSystem.class.getName());

    public static E createMonster(SpawnType type,
                                  int posX,
                                  int posY,
                                  int areaId) {

        E e = E.E()
               .position(posX, posY, areaId)
               .character()
               .alive()
               .energy()
               .hostile()
               .justMoved();

        switch(type) {
            case MONSTER_BAT:
                e.tileSprite(MonsterAssets.getBat())
                 .name("Bat", Color.RED)
                 .meleeAttack()
                 .sight(6)
                 .strength(1)
                 .constitution(1)
                 .health(10)
                 .healthMaxHealth(Formulae.calculateMaxHealth(e))
                 .healthCurrentHealth(Formulae.calculateMaxHealth(e));
                break;
        }

        LOGGER.fine("Monster " + e.nameName() + " created at position  " + e.getPosition().toString());
        return e;
    }
}

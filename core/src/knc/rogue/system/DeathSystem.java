package knc.rogue.system;

import com.artemis.E;
import com.artemis.annotations.All;
import com.artemis.systems.IteratingSystem;
import knc.rogue.component.Alive;
import knc.rogue.component.Health;

@All({Alive.class, Health.class})
public class DeathSystem extends IteratingSystem {
    @Override
    protected void process(int entityId) {
        E e = E.E(entityId);

        if(e.healthCurrentHealth() <= 0) {
            e.removeAlive();
            e.removeCharacter();
            System.out.println(e.nameName() + " has died!");
        }
    }
}

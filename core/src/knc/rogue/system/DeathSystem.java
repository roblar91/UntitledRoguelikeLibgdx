package knc.rogue.system;

import com.artemis.E;
import com.artemis.annotations.All;
import com.artemis.systems.IteratingSystem;
import knc.rogue.component.Alive;
import knc.rogue.component.Health;

import java.util.logging.Logger;

@All({Alive.class, Health.class})
public class DeathSystem extends IteratingSystem {
    private final static Logger LOGGER = Logger.getLogger(KeyboardInputSystem.class.getName());

    @Override
    protected void process(int entityId) {
        E e = E.E(entityId);

        if(e.healthCurrentHealth() <= 0) {
            e.removeAlive();
            e.removeCharacter();
            LOGGER.info(e.nameName() + " has died");
        }
    }
}

package knc.rogue.system;

import com.artemis.Aspect;
import com.artemis.E;
import knc.rogue.command.MeleeAttackCommand;
import knc.rogue.command.MoveCommand;
import knc.rogue.component.Alive;
import knc.rogue.component.Hostile;
import knc.rogue.component.Position;
import knc.rogue.component.Solid;
import knc.rogue.util.CompassDirection;
import knc.rogue.util.Settings;
import net.mostlyoriginal.api.system.core.PassiveSystem;

import java.util.logging.Logger;

public class MovementSystem extends PassiveSystem {
    private final static Logger LOGGER = Logger.getLogger(KeyboardInputSystem.class.getName());
    private CommandSystem commandSystem;

    private Aspect.Builder solidAspect = Aspect.all(Solid.class, Position.class);
    private Aspect.Builder hostileAspect = Aspect.all(Hostile.class, Alive.class, Position.class);

    public void attemptMove(E actor, CompassDirection direction) {
        LOGGER.fine("[Entity " + actor.id() + "] Attempting move");

        int targetX = actor.positionX() + direction.dX;
        int targetY = actor.positionY() + direction.dY;

        if(checkTargetPositionForAspect(targetX, targetY, hostileAspect)) {
            LOGGER.fine("[Entity " + actor.id() +"] Hostile at destination");

            if(Settings.BUMP_ATTACK) {
                LOGGER.fine("[Entity " + actor.id() +"] BUMP_ATTACK=true: Issuing attack command");
                commandSystem.queueCommand(new MeleeAttackCommand(actor, getEntityWithAspectAtPosition(targetX, targetY, hostileAspect)));
            } else {
                LOGGER.info("[Entity " + actor.id() +"] BUMP_ATTACK=false: Destination occupied");
            }

            return;
        }

        if(!checkTargetPositionForAspect(targetX, targetY, solidAspect)) {
            LOGGER.fine("[Entity " + actor.id() +"] Issuing move command");
            commandSystem.queueCommand(new MoveCommand(actor, direction));
        } else {
            LOGGER.info("[Entity " + actor.id() +"] Solid at destination: Can not move");
        }
    }

    private boolean checkTargetPositionForAspect(int targetX, int targetY, Aspect.Builder aspect) {
        for(E e : E.withAspect(aspect)) {
            if(e.positionX() == targetX && e.positionY() == targetY) {
                return true;
            }
        }

        return false;
    }

    private E getEntityWithAspectAtPosition(int targetX, int targetY, Aspect.Builder aspect) {
        for(E e : E.withAspect(aspect)) {
            if(e.positionX() == targetX && e.positionY() == targetY) {
                return e;
            }
        }

        return null;
    }
}

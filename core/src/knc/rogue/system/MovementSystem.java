package knc.rogue.system;

import com.artemis.Aspect;
import com.artemis.BaseSystem;
import com.artemis.E;
import knc.rogue.command.MeleeAttackCommand;
import knc.rogue.command.MoveCommand;
import knc.rogue.component.Alive;
import knc.rogue.component.Hostile;
import knc.rogue.component.Position;
import knc.rogue.component.Solid;
import knc.rogue.util.CompassDirection;
import knc.rogue.util.Settings;

public class MovementSystem extends BaseSystem {
    private CommandSystem commandSystem;

    private Aspect.Builder solidAspect = Aspect.all(Solid.class, Position.class);
    private Aspect.Builder hostileAspect = Aspect.all(Hostile.class, Alive.class, Position.class);

    public void attemptMove(E actor, CompassDirection direction) {
        int targetX = actor.positionX() + direction.dX;
        int targetY = actor.positionY() + direction.dY;

        if(checkTargetPositionForAspect(targetX, targetY, hostileAspect)) {
            if(Settings.BUMP_ATTACK) {
                commandSystem.queueCommand(new MeleeAttackCommand(actor, getEntityWithAspectAtPosition(targetX, targetY, hostileAspect)));
            } else {
                System.out.println("Target occupied");
            }

            return;
        }

        if(!checkTargetPositionForAspect(targetX, targetY, solidAspect)) {
            commandSystem.queueCommand(new MoveCommand(actor, direction));
        } else {
            System.out.println("Path blocked");
        }
    }

    @Override
    protected void processSystem() {
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

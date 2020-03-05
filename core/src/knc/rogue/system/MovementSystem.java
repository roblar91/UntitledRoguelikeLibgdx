package knc.rogue.system;

import com.artemis.Aspect;
import com.artemis.BaseSystem;
import com.artemis.E;
import knc.rogue.command.MoveCommand;
import knc.rogue.component.Position;
import knc.rogue.component.Solid;
import knc.rogue.util.CompassDirection;

public class MovementSystem extends BaseSystem {
    private CommandSystem commandSystem;

    private Aspect.Builder solids = Aspect.all(Solid.class, Position.class);

    public void attemptMove(E actor, CompassDirection direction) {
        boolean collision = false;
        int targetX = actor.positionX() + direction.dX;
        int targetY = actor.positionY() + direction.dY;

        for(E e : E.withAspect(solids)) {
            if(e.positionX() == targetX && e.positionY() == targetY) {
                collision = true;
            }
        }

        if(!collision) {
            commandSystem.queueCommand(new MoveCommand(actor, direction));
        } else {
            System.out.println("Path blocked");
        }
    }

    @Override
    protected void processSystem() {
    }
}

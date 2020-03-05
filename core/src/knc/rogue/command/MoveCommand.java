package knc.rogue.command;

import com.artemis.E;
import knc.rogue.util.CompassDirection;

public class MoveCommand implements Command {
    private E actor;
    private CompassDirection direction;

    public MoveCommand(E actor, CompassDirection direction) {
        this.actor = actor;
        this.direction = direction;
    }

    @Override
    public void execute() {
        actor.position(actor.positionX() + direction.dX, actor.positionY() + direction.dY);
    }
}

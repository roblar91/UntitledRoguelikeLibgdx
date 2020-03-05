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
        int dX = 0;
        int dY = 0;

        switch(direction) {
            case NORTHWEST:
                dX = -1;
                dY = 1;
                break;
            case NORTH:
                dY = 1;
                break;
            case NORTHEAST:
                dX = 1;
                dY = 1;
                break;
            case EAST:
                dX = 1;
                break;
            case WEST:
                dX = -1;
                break;
            case SOUTHWEST:
                dX = -1;
                dY = -1;
                break;
            case SOUTH:
                dY = -1;
                break;
            case SOUTHEAST:
                dX = 1;
                dY = -1;
                break;
        }

        actor.position(actor.positionX() + dX, actor.positionY() + dY);
    }
}

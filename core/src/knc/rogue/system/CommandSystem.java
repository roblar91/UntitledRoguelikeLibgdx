package knc.rogue.system;

import com.artemis.BaseSystem;
import knc.rogue.command.Command;

import java.util.LinkedList;
import java.util.Queue;

public class CommandSystem extends BaseSystem {
    private Queue<Command> commands = new LinkedList<>();

    public void queueCommand(Command command) {
        commands.add(command);
    }

    @Override
    protected void processSystem() {
        while(!commands.isEmpty()) {
            commands.remove().execute();
        }
    }
}

package knc.rogue.system;

import com.artemis.E;
import com.artemis.annotations.One;
import com.artemis.systems.IteratingSystem;
import knc.rogue.component.JustMoved;

@One(JustMoved.class)
public class ComponentCleanupSystem extends IteratingSystem {
    @Override
    protected void process(int entityId) {
        E.E(entityId).justMoved(false);
    }
}

package knc.rogue.system;

import com.artemis.E;
import com.artemis.FluidIteratingSystem;
import com.artemis.annotations.One;
import knc.rogue.component.JustMoved;

@One(JustMoved.class)
public class ComponentCleanupSystem extends FluidIteratingSystem {
    @Override
    protected void process(E e) {
        e.justMoved(false);
    }
}

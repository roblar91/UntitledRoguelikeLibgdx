package knc.rogue.system;

import com.artemis.E;
import net.mostlyoriginal.api.system.core.PassiveSystem;

public class AISystem extends PassiveSystem {
    public void act(E e) {
        doNothing(e);
    }

    private void doNothing(E e) {
        e.energyAdd(-100);
    }
}

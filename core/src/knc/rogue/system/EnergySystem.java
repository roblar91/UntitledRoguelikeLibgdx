package knc.rogue.system;

import com.artemis.Aspect;
import com.artemis.E;
import knc.rogue.component.Alive;
import knc.rogue.component.Energy;
import net.mostlyoriginal.api.system.core.PassiveSystem;

public class EnergySystem extends PassiveSystem {
    private Aspect.Builder energyAspect = Aspect.all(Energy.class, Alive.class);

    public void giveEnergyToAll() {
        for(E e : E.withAspect(energyAspect)) {
            if(!e.energyIsFull()) {
                e.energyAdd(1);
            }
        }
    }

    public E getFullEnergyEntity() {
        for(E e : E.withAspect(energyAspect)) {
            if(e.energyIsFull()) {
                return e;
            }
        }

        return null;
    }
}

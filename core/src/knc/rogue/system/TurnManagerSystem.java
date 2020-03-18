package knc.rogue.system;

import com.artemis.Aspect;
import com.artemis.BaseSystem;
import com.artemis.E;
import knc.rogue.component.Alive;
import knc.rogue.component.Energy;

public class TurnManagerSystem extends BaseSystem {
    private EnergySystem energySystem;
    private AISystem aiSystem;
    private PlayerSystem playerSystem;

    private Aspect.Builder energyAspect = Aspect.all(Energy.class, Alive.class);

    @Override
    protected void processSystem() {
        while(!playerSystem.isPlayerTurn()) {
            E e = energySystem.getFullEnergyEntity();
            if(e == null) {
                energySystem.giveEnergyToAll();
            } else {
                if(e.hasPlayer()) {
                    playerSystem.setPlayerTurn(true);
                } else {
                    aiSystem.act(e);
                }
            }
        }
    }
}

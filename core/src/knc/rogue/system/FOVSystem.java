package knc.rogue.system;

import com.artemis.Aspect;
import com.artemis.E;
import com.artemis.FluidIteratingSystem;
import com.artemis.annotations.All;
import knc.rogue.component.*;
import squidpony.squidgrid.FOV;
import squidpony.squidgrid.Radius;

import java.util.logging.Logger;

@All({Alive.class, JustMoved.class, Sight.class, Position.class})
public class FOVSystem extends FluidIteratingSystem {
    private final static Logger LOGGER = Logger.getLogger(KeyboardInputSystem.class.getName());
    private GameStateSystem gameStateSystem;

    private Aspect.Builder solids = Aspect.all(Solid.class, Position.class);
    private double[][] resMap;

    @Override
    protected void process(E e) {
        if(gameStateSystem.getCurrentMap().mapEntityHasChanged()) {
            calculateResMap();
        }

        e.sightFovMap(new FOV(FOV.SHADOW).calculateFOV(resMap,
                                                       e.positionX(),
                                                       e.positionY(),
                                                       e.sightRange(),
                                                       Radius.SQUARE));
    }

    public boolean isVisible(E actor, E target) {
        return getVisibility(actor, target) > 0;
    }

    public double getVisibility(E actor, E target) {
        return actor.sightFovMap()[target.positionX()][target.positionY()];
    }

    private void calculateResMap() {
        LOGGER.info("Calculating new resMap for area " + gameStateSystem.getCurrentMap().id());

        gameStateSystem.getCurrentMap().mapEntityHasChanged(false);

        resMap = new double[gameStateSystem.getCurrentMap().mapEntityColumns()][gameStateSystem.getCurrentMap().mapEntityRows()];
        for(E solid : E.withAspect(solids)) {
            resMap[solid.positionX()][solid.positionY()] = '#';
        }
    }
}

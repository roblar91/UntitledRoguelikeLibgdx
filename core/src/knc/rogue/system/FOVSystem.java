package knc.rogue.system;

import com.artemis.Aspect;
import com.artemis.E;
import com.artemis.FluidIteratingSystem;
import com.artemis.annotations.All;
import knc.rogue.component.*;
import squidpony.squidgrid.FOV;
import squidpony.squidgrid.Radius;

@All({Alive.class, JustMoved.class, Sight.class, Position.class})
public class FOVSystem extends FluidIteratingSystem {
    private Aspect.Builder solids = Aspect.all(Solid.class, Position.class);

    @Override
    protected void process(E e) {
        E mapEntity = E.withComponent(MapEntity.class).get(0);
        double[][] resMap = new double[mapEntity.mapEntityColumns()][mapEntity.mapEntityRows()];

        for(E solid : E.withAspect(solids)) {
            resMap[solid.positionX()][solid.positionY()] = '#';
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
}

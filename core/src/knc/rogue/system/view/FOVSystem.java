package knc.rogue.system.view;

import com.artemis.Aspect;
import com.artemis.E;
import com.artemis.FluidIteratingSystem;
import com.artemis.annotations.All;
import knc.rogue.component.*;
import squidpony.squidgrid.FOV;
import squidpony.squidgrid.Radius;

@All({Player.class, JustMoved.class, Sight.class})
public class FOVSystem extends FluidIteratingSystem {
    private Aspect.Builder solids = Aspect.all(Solid.class, Position.class);
    private FOV fov = new FOV(FOV.SHADOW);;

    public double[][] fovMap;

    @Override
    protected void process(E e) {
        E mapEntity = E.withComponent(MapEntity.class).get(0);
        double[][] resMap = new double[mapEntity.mapEntityColumns()][mapEntity.mapEntityRows()];

        for(E solid : E.withAspect(solids)) {
            resMap[solid.positionX()][solid.positionY()] = '#';
        }

        fovMap = fov.calculateFOV(resMap, e.positionX(), e.positionY(), e.sightRange(), Radius.SQUARE);
    }
}

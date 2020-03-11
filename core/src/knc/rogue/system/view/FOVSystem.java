package knc.rogue.system.view;

import com.artemis.Aspect;
import com.artemis.E;
import com.artemis.annotations.All;
import com.artemis.systems.IteratingSystem;
import knc.rogue.component.*;
import squidpony.squidgrid.FOV;
import squidpony.squidgrid.Radius;

@All({Player.class, JustMoved.class, Sight.class})
public class FOVSystem extends IteratingSystem {
    private Aspect.Builder solids = Aspect.all(Solid.class, Position.class);
    private FOV fov = new FOV(FOV.SHADOW);;

    public double[][] fovMap;

    @Override
    protected void process(int entityId) {
        calculateFov(E.E(entityId));
    }

    private void calculateFov(E player) {
        E mapEntity = E.withComponent(MapEntity.class).get(0);
        double[][] resMap = new double[mapEntity.mapEntityColumns()][mapEntity.mapEntityRows()];

        for(E solid : E.withAspect(solids)) {
            resMap[solid.positionX()][solid.positionY()] = '#';
        }

        fovMap = fov.calculateFOV(resMap, player.positionX(), player.positionY(), player.sightRange(), Radius.SQUARE);
    }
}

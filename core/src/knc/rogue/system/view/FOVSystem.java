package knc.rogue.system.view;

import com.artemis.Aspect;
import com.artemis.E;
import com.artemis.annotations.All;
import com.artemis.systems.IteratingSystem;
import knc.rogue.component.*;
import knc.rogue.system.PlayerSystem;
import squidpony.squidgrid.FOV;

@All({Player.class, JustMoved.class})
public class FOVSystem extends IteratingSystem {
    private PlayerSystem playerSystem;

    private Aspect.Builder solids = Aspect.all(Solid.class, Position.class);
    private FOV fov = new FOV(FOV.SHADOW);;

    public double[][] fovMap;

    @Override
    protected void initialize() {
        super.initialize();

        calculateFov();
    }

    @Override
    protected void process(int entityId) {
        calculateFov();
    }

    private void calculateFov() {
        E mapEntity = E.withComponent(MapEntity.class).get(0);
        double[][] resMap = new double[mapEntity.mapEntityColumns()][mapEntity.mapEntityRows()];

        for(E solid : E.withAspect(solids)) {
            resMap[solid.positionX()][solid.positionY()] = '#';
        }

        fovMap = fov.calculateFOV(resMap, playerSystem.player.positionX(), playerSystem.player.positionY(), 10);
    }
}

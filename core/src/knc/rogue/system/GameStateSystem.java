package knc.rogue.system;

import com.artemis.Aspect;
import com.artemis.BaseSystem;
import com.artemis.E;
import knc.rogue.component.Entrance;
import knc.rogue.system.map.MapGenerationSystem;
import knc.rogue.system.map.PlayerSystem;

public class GameStateSystem extends BaseSystem {
    private MapGenerationSystem mapGenerationSystem;
    private PlayerSystem playerSystem;

    private E currentMap;

    @Override
    protected void initialize() {
        super.initialize();

        currentMap = mapGenerationSystem.generateMap(1);
        positionPlayerAtEntrance();
    }

    @Override
    protected void processSystem() {
    }

    private void positionPlayerAtEntrance() {
        E.withAspect(Aspect.all(Entrance.class)).forEach(e -> {
            if(e.getPosition().areaId == currentMap.id()) {
                playerSystem.player.position(e.positionX(), e.positionY());
            }
        });
    }
}

package knc.rogue.system;

import com.artemis.Aspect;
import com.artemis.BaseSystem;
import com.artemis.E;
import knc.rogue.component.Entrance;
import knc.rogue.component.MapEntity.MapType;
import knc.rogue.system.map.MapGenerationSystem;
import net.mostlyoriginal.api.system.core.PassiveSystem;

import java.util.logging.Logger;

public class GameStateSystem extends PassiveSystem {
    private final static Logger LOGGER = Logger.getLogger(KeyboardInputSystem.class.getName());
    private MapGenerationSystem mapGenerationSystem;
    private PlayerSystem playerSystem;

    private E currentMap;

    @Override
    protected void initialize() {
        super.initialize();

        currentMap = mapGenerationSystem.generateMap(MapType.FOREST_1);
        positionPlayerAtEntrance();
    }

    private void positionPlayerAtEntrance() {
        LOGGER.info("Positioning player at entrance");

        E.withAspect(Aspect.all(Entrance.class)).forEach(e -> {
            if(e.getPosition().areaId == currentMap.id()) {
                playerSystem.getPlayer().position(e.positionX(), e.positionY());
            }
        });
    }
}

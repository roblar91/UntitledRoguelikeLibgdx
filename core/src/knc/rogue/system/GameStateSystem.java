package knc.rogue.system;

import com.artemis.BaseSystem;
import knc.rogue.system.map.MapGenerationSystem;

public class GameStateSystem extends BaseSystem {
    private MapGenerationSystem mapGenerationSystem;

    private int depth = 1;

    @Override
    protected void initialize() {
        super.initialize();

        mapGenerationSystem.generateMap(1);
    }

    @Override
    protected void processSystem() {
    }
}

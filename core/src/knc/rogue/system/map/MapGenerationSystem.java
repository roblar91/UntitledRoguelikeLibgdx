package knc.rogue.system.map;

import com.artemis.BaseSystem;

public class MapGenerationSystem extends BaseSystem {
    @Override
    protected void processSystem() {
    }

    public void generateMap(int depth) {
        new RandomWalkMap().generateMap(1, MapTheme.STONE_SIMPLE);
    }
}

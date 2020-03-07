package knc.rogue.system.map;

import com.artemis.BaseSystem;
import com.artemis.E;

public class MapGenerationSystem extends BaseSystem {
    @Override
    protected void processSystem() {
    }

    public E generateMap(int depth) {
        return new RandomWalkMapGenerator().generateMap(1, MapTheme.STONE_SIMPLE);
    }
}

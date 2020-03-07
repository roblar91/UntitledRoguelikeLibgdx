package knc.rogue.system.map;

import com.artemis.BaseSystem;
import com.artemis.E;
import knc.rogue.component.MapEntity.MapType;

public class MapGenerationSystem extends BaseSystem {
    @Override
    protected void processSystem() {
    }

    public E generateMap(MapType mapType) {
        return new RandomWalkMapGenerator().generateMap(mapType);
    }
}

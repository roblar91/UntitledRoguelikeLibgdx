package knc.rogue.system.map;

import com.artemis.E;
import knc.rogue.component.MapEntity.MapType;
import net.mostlyoriginal.api.system.core.PassiveSystem;

public class MapGenerationSystem extends PassiveSystem {
    @Override
    protected void processSystem() {
    }

    public E generateMap(MapType mapType) {
        return new RandomWalkMapGenerator().generateMap(mapType);
    }
}

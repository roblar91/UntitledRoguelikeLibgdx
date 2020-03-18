package knc.rogue.system.map;

import com.artemis.E;
import knc.rogue.component.MapEntity.MapType;
import knc.rogue.data.MonsterFactory;
import knc.rogue.data.ObjectFactory;
import knc.rogue.data.SpawnType;
import knc.rogue.data.TerrainFactory;
import squidpony.squidmath.RNG;

import java.util.List;
import java.util.Queue;

public abstract class MapGenerator {
    protected RNG rng = new RNG();
    protected MapGenerator() {}

    public E generateMap(MapType mapType) {
        List<List<Queue<SpawnType>>> blueprint = createBlueprint();

        E e = E.E().mapEntity(mapType, blueprint.size(), blueprint.get(0).size());
        populateMap(e.id(), blueprint);

        return e;
    }

    private void populateMap(int areaId, List<List<Queue<SpawnType>>> blueprint) {
        for(int x = 0; x < blueprint.size(); x++) {
            for(int y = 0; y < blueprint.get(0).size(); y++) {
                while(!blueprint.get(x).get(y).isEmpty()) {
                    SpawnType spawnType = blueprint.get(x).get(y).remove();

                    switch(spawnType.getCategory()) {
                        case TERRAIN:
                            TerrainFactory.createTerrain(spawnType, x, y, areaId);
                            break;
                        case OBJECT:
                            ObjectFactory.createObject(spawnType, x, y, areaId);
                            break;
                        case MONSTER:
                            MonsterFactory.createMonster(spawnType, x, y, areaId);
                            break;
                    }
                }
            }
        }
    }

    protected abstract List<List<Queue<SpawnType>>> createBlueprint();
}

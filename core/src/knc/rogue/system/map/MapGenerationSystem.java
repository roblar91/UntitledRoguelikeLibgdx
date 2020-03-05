package knc.rogue.system.map;

import com.artemis.BaseSystem;

public class MapGenerationSystem extends BaseSystem {
    private PlayerSystem playerSystem;

    @Override
    protected void processSystem() {
    }

    public void generateMap(int depth) {
        Map map = new RandomWalkMap().generateMap(1, MapTheme.STONE_SIMPLE);

        playerSystem.player.position(map.entranceX, map.entranceY);
    }
}

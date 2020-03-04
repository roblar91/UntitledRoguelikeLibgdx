package knc.rogue.system.map;

import com.artemis.BaseSystem;
import com.artemis.E;
import knc.rogue.util.AssetLoader;
import knc.rogue.util.Settings;

public class MapGenerationSystem extends BaseSystem {
    @Override
    protected void processSystem() {
    }

    public void generateMap(int depth) {
        createWall(0, 0);
        createWall(0, 1);
        createWall(0, 2);
        createWall(1, 0);
        createFloor(1, 1);
        createWall(1, 2);
        createWall(2, 0);
        createFloor(2, 1);
        createFloor(2, 2);
    }

    private void createWall(int posX, int posY) {
        E.E()
         .tileSprite(AssetLoader.getWallBrickGray())
         .terrain()
         .solid()
         .position(posX, posY);
    }

    private void createFloor(int posX, int posY) {
        E.E()
         .tileSprite(AssetLoader.getFloorPebbleBrown())
         .terrain()
         .position(posX, posY);
    }
}

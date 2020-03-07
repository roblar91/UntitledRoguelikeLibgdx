package knc.rogue.system.map;

import com.artemis.E;
import com.badlogic.gdx.graphics.Texture;
import knc.rogue.data.asset.MapAssets;
import knc.rogue.data.asset.StoneMapAsset;

import java.util.Random;

public abstract class MapGenerator {
    protected Random rng = new Random();
    protected E e;
    protected int depth;
    protected MapTheme theme;
    protected MapTerrainType[][] terrainBlueprint;
    protected MapAssets assets;

    protected MapGenerator() {}

    public E generateMap(int depth, MapTheme theme) {
        this.e = E.E();
        this.depth = depth;
        this.theme = theme;

        terrainBlueprint = createTerrainBlueprint();
        assets = createAssets();

        createTiles();
        createObjects();

        return e.mapEntity(depth);
    }

    private MapAssets createAssets() {
        switch(theme) {
            case STONE_SIMPLE:
            default:
                return new StoneMapAsset();
        }
    }

    private void createTiles() {
        for(int x = 0; x < terrainBlueprint.length; x++) {
            for(int y = 0; y < terrainBlueprint[0].length; y++) {
                switch(terrainBlueprint[x][y]) {
                    case NONE:
                        break;
                    case WALL:
                        createWall(assets.getWall(), x, y);
                        break;
                    case FLOOR:
                        createFloor(assets.getFloor(), x, y);
                        break;
                    case ENTRANCE:
                        createFloor(assets.getFloor(), x, y);
                        createEntrance(assets.getEntrance(), x, y);
                        break;
                    case EXIT:
                        createFloor(assets.getFloor(), x, y);
                        createExit(assets.getExit(), x, y);
                        break;
                }
            }
        }
    }

    private void createObjects() {

    }

    private void createWall(Texture texture, int posX, int posY) {
        E.E()
         .tileSprite(texture)
         .terrain()
         .solid()
         .position(posX, posY, e.id());
    }

    private void createFloor(Texture texture, int posX, int posY) {
        E.E()
         .tileSprite(texture)
         .terrain()
         .position(posX, posY, e.id());
    }

    private void createEntrance(Texture texture, int posX, int posY) {
        E.E()
         .tileSprite(texture)
         .mapObject()
         .position(posX, posY, e.id())
         .entrance();
    }

    private void createExit(Texture texture, int posX, int posY) {
        E.E()
         .tileSprite(texture)
         .mapObject()
         .position(posX, posY, e.id())
         .exit();
    }

    protected abstract MapTerrainType[][] createTerrainBlueprint();
    protected abstract MapObjectType[][] createObjectBlueprint();
}

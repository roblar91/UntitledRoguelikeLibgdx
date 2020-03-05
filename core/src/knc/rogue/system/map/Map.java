package knc.rogue.system.map;

import com.artemis.E;
import com.badlogic.gdx.graphics.Texture;
import knc.rogue.asset.MapAssets;
import knc.rogue.asset.StoneMapAsset;

import java.util.Random;

public abstract class Map {
    protected Random rng = new Random();

    public void generateMap(int depth, MapTheme theme) {
        MapTileType[][] blueprint = createBlueprint(depth);
        MapAssets assets = createAssets(theme);
        createTiles(blueprint, assets);
    }

    private MapAssets createAssets(MapTheme theme) {
        if(theme == MapTheme.STONE_SIMPLE) {
            return new StoneMapAsset();
        }

        return null;
    }

    private void createTiles(MapTileType[][] blueprint, MapAssets assets) {
        for(int x = 0; x < blueprint.length; x++) {
            for(int y = 0; y < blueprint[0].length; y++) {
                switch(blueprint[x][y]) {
                    case NONE:
                        break;
                    case WALL:
                        createWall(assets.getWall(), x, y);
                        break;
                    case FLOOR:
                        createFloor(assets.getFloor(), x, y);
                        break;
                    case ENTRANCE:
                        createEntrance(assets.getEntrance(), x, y);
                        break;
                    case EXIT:
                        createExit(assets.getExit(), x, y);
                        break;
                }
            }
        }
    }

    private void createWall(Texture texture, int posX, int posY) {
        E.E()
         .tileSprite(texture)
         .terrain()
         .solid()
         .position(posX, posY);
    }

    private void createFloor(Texture texture, int posX, int posY) {
        E.E()
         .tileSprite(texture)
         .terrain()
         .position(posX, posY);
    }

    private void createEntrance(Texture texture, int posX, int posY) {
        E.E()
         .tileSprite(texture)
         .terrain()
         .position(posX, posY)
         .entrance();
    }

    private void createExit(Texture texture, int posX, int posY) {
        E.E()
         .tileSprite(texture)
         .terrain()
         .position(posX, posY)
         .exit();
    }

    protected abstract MapTileType[][] createBlueprint(int depth);
}

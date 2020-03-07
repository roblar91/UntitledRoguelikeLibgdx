package knc.rogue.system.map;

public class RandomWalkMapGenerator extends MapGenerator {
    @Override
    protected MapTerrainType[][] createTerrainBlueprint() {
        int sizeX = rng.nextInt(25) + 50;
        int sizeY = rng.nextInt(50) + 70;
        int openSpace = 0;
        int openSpaceTarget = (sizeX * sizeY) * (rng.nextInt(20) + 20) / 100;

        // Initialize all tiles to walls
        MapTerrainType[][] blueprint = new MapTerrainType[sizeX][sizeY];
        for(int x=0; x<sizeX; x++) {
            for(int y=0; y<sizeY; y++) {
                blueprint[x][y] = MapTerrainType.NONE;
            }
        }

        // Make paths
        int currentX = rng.nextInt(sizeX-2) + 1;
        int currentY = rng.nextInt(sizeY-2) + 1;
        blueprint[currentX][currentY] = MapTerrainType.ENTRANCE;

        while(openSpace < openSpaceTarget) {
            if(blueprint[currentX][currentY] == MapTerrainType.NONE) {
                blueprint[currentX][currentY] = MapTerrainType.FLOOR;
                openSpace++;
                if(openSpace == openSpaceTarget){
                    blueprint[currentX][currentY] = MapTerrainType.EXIT;
                }
            }

            int direction = rng.nextInt(4);
            switch(direction) {
                case 0:
                    if(currentX > 1)
                        currentX--;
                    break;
                case 1:
                    if(currentX < sizeX - 2)
                        currentX++;
                    break;
                case 2:
                    if(currentY > 1)
                        currentY--;
                    break;
                case 3:
                    if(currentY < sizeY -2)
                        currentY++;
                    break;
            }
        }

        for(int x=0; x<sizeX; x++) {
            for(int y=0; y<sizeY; y++) {
                if(blueprint[x][y] == MapTerrainType.FLOOR
                   || blueprint[x][y] == MapTerrainType.ENTRANCE
                   || blueprint[x][y] == MapTerrainType.EXIT)
                    addWallsAdjacentToGround(blueprint, x, y);
            }
        }

        return blueprint;
    }

    private void addWallsAdjacentToGround(MapTerrainType[][] blueprint, int x, int y) {
        checkWall(blueprint, x-1, y-1);
        checkWall(blueprint, x-1, y);
        checkWall(blueprint, x-1, y+1);
        checkWall(blueprint, x, y-1);
        checkWall(blueprint, x, y);
        checkWall(blueprint, x, y+1);
        checkWall(blueprint, x+1, y-1);
        checkWall(blueprint, x+1, y);
        checkWall(blueprint, x+1, y+1);
    }

    private void checkWall(MapTerrainType[][] blueprint, int x, int y) {
        if(blueprint[x][y] == MapTerrainType.NONE) {
            blueprint[x][y] = MapTerrainType.WALL;
        }
    }

    @Override
    protected MapObjectType[][] createObjectBlueprint() {
        return new MapObjectType[0][];
    }
}

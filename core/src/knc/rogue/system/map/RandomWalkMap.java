package knc.rogue.system.map;

public class RandomWalkMap extends Map {
    @Override
    protected MapTileType[][] createBlueprint(int depth) {
        int sizeX = rng.nextInt(25) + 50;
        int sizeY = rng.nextInt(50) + 70;
        int openSpace = 0;
        int openSpaceTarget = (sizeX * sizeY) * (rng.nextInt(20) + 20) / 100;

        // Initialize all tiles to walls
        MapTileType[][] blueprint = new MapTileType[sizeX][sizeY];
        for(int x=0; x<sizeX; x++) {
            for(int y=0; y<sizeY; y++) {
                blueprint[x][y] = MapTileType.NONE;
            }
        }

        // Make paths
        int currentX = rng.nextInt(sizeX-2) + 1;
        int currentY = rng.nextInt(sizeY-2) + 1;
        blueprint[currentX][currentY] = MapTileType.ENTRANCE;

        while(openSpace < openSpaceTarget) {
            if(blueprint[currentX][currentY] == MapTileType.NONE) {
                blueprint[currentX][currentY] = MapTileType.FLOOR;
                openSpace++;
                if(openSpace == openSpaceTarget){
                    blueprint[currentX][currentY] = MapTileType.EXIT;
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
                if(blueprint[x][y] == MapTileType.FLOOR
                   || blueprint[x][y] == MapTileType.ENTRANCE
                   || blueprint[x][y] == MapTileType.EXIT)
                    addWallsAdjacentToGround(blueprint, x, y);
            }
        }

        return blueprint;
    }

    private void addWallsAdjacentToGround(MapTileType[][] blueprint, int x, int y) {
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

    private void checkWall(MapTileType[][] blueprint, int x, int y) {
        if(blueprint[x][y] == MapTileType.NONE) {
            blueprint[x][y] = MapTileType.WALL;
        }
    }
}

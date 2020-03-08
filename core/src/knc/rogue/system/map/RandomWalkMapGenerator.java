package knc.rogue.system.map;

import knc.rogue.data.SpawnType;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RandomWalkMapGenerator extends MapGenerator {
    @Override
    protected List<List<Queue<SpawnType>>> createBlueprint() {
        int sizeX = rng.nextInt(25) + 50;
        int sizeY = rng.nextInt(50) + 70;
        int openSpace = 0;
        int openSpaceTarget = (sizeX * sizeY) * (rng.nextInt(20) + 20) / 100;

        // Initialize all tiles
        List<List<Queue<SpawnType>>> blueprint = new ArrayList<>(sizeX);

        for(int x=0; x<sizeX; x++) {
            blueprint.add(new ArrayList<>(sizeY));

            for(int y=0; y<sizeY; y++) {
                blueprint.get(x).add(new LinkedList<>());
            }
        }

        // Make paths
        int currentX = rng.nextInt(sizeX-2) + 1;
        int currentY = rng.nextInt(sizeY-2) + 1;
        blueprint.get(currentX).get(currentY).add(SpawnType.ENTRANCE_ROCK);
        blueprint.get(currentX).get(currentY).add(SpawnType.FLOOR_STONE);

        while(openSpace < openSpaceTarget) {
            if(blueprint.get(currentX).get(currentY).isEmpty()) {
                blueprint.get(currentX).get(currentY).add(SpawnType.FLOOR_STONE);
                openSpace++;
                if(openSpace == openSpaceTarget){
                    blueprint.get(currentX).get(currentY).add(SpawnType.EXIT_ROCK);
                    blueprint.get(currentX).get(currentY).add(SpawnType.FLOOR_STONE);
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
                if(blueprint.get(x).get(y).contains(SpawnType.FLOOR_STONE)
                   || blueprint.get(x).get(y).contains(SpawnType.ENTRANCE_ROCK)
                   || blueprint.get(x).get(y).contains(SpawnType.EXIT_ROCK))
                    addWallsAdjacentToGround(blueprint, x, y);
            }
        }

        // Spawn some bats for testing purpose
        for(int i = 0; i < 20; i++) {
            spawnBat(blueprint);
        }

        return blueprint;
    }

    private void addWallsAdjacentToGround(List<List<Queue<SpawnType>>> blueprint, int x, int y) {
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

    private void checkWall(List<List<Queue<SpawnType>>> blueprint, int x, int y) {
        if(blueprint.get(x).get(y).isEmpty()) {
            blueprint.get(x).get(y).add(SpawnType.WALL_STONE);
        }
    }

    private void spawnBat(List<List<Queue<SpawnType>>> blueprint) {
        for(int i = 0; i < 100; i++) {
            int x = rng.nextInt(blueprint.size());
            int y = rng.nextInt(blueprint.get(0).size());

            if(blueprint.get(x).get(y).contains(SpawnType.FLOOR_STONE)) {
                blueprint.get(x).get(y).add(SpawnType.MONSTER_BAT);
                break;
            }
        }
    }
}

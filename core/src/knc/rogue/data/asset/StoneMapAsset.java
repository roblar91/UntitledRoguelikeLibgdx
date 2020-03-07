package knc.rogue.data.asset;

import com.badlogic.gdx.graphics.Texture;

import java.util.Random;

public class StoneMapAsset extends MapAssets {
    private Random rng = new Random();

    @Override
    public Texture getFloor() {
        if(floor == null) {
            floor = new Texture[]{
                    new Texture("environment/floor/pebble_brown0.png"),
                    new Texture("environment/floor/pebble_brown1.png"),
                    new Texture("environment/floor/pebble_brown2.png"),
                    new Texture("environment/floor/pebble_brown3.png"),
                    new Texture("environment/floor/pebble_brown4.png"),
                    new Texture("environment/floor/pebble_brown5.png"),
                    new Texture("environment/floor/pebble_brown6.png"),
                    new Texture("environment/floor/pebble_brown7.png"),
                    new Texture("environment/floor/pebble_brown8.png")};
        }

        return floor[rng.nextInt(floor.length)];
    }

    @Override
    public Texture getWall() {
        if(wall == null) {
            wall = new Texture[]{
                    new Texture("environment/wall/brick_gray0.png"),
                    new Texture("environment/wall/brick_gray1.png"),
                    new Texture("environment/wall/brick_gray2.png"),
                    new Texture("environment/wall/brick_gray3.png")};
        }

        return wall[rng.nextInt(wall.length)];
    }

    @Override
    public Texture getEntrance() {
        if(entrance == null) {
            entrance = new Texture("environment/transition/rock_stairs_up.png");
        }

        return entrance;
    }

    @Override
    public Texture getExit() {
        if(exit == null) {
            exit = new Texture("environment/transition/rock_stairs_down.png");
        }

        return exit;
    }
}

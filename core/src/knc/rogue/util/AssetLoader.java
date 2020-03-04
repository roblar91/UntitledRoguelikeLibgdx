package knc.rogue.util;

import com.badlogic.gdx.graphics.Texture;

import java.util.Random;

public final class AssetLoader {
    private static Random rng = new Random();

    private static Texture[] floorPebbleBrown;
    private static Texture[] wallBrickGray;

    public static Texture getFloorPebbleBrown() {
        if(floorPebbleBrown == null) {
            floorPebbleBrown = new Texture[]{
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

        return floorPebbleBrown[rng.nextInt(floorPebbleBrown.length)];
    }

    public static Texture getWallBrickGray() {
        if(wallBrickGray == null) {
            wallBrickGray = new Texture[]{
                    new Texture("environment/wall/brick_gray0.png"),
                    new Texture("environment/wall/brick_gray1.png"),
                    new Texture("environment/wall/brick_gray2.png"),
                    new Texture("environment/wall/brick_gray3.png")};
        }

        return wallBrickGray[rng.nextInt(wallBrickGray.length)];
    }
}

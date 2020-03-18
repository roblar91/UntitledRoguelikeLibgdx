package knc.rogue.data.asset;

import com.badlogic.gdx.graphics.Texture;
import squidpony.squidmath.RNG;

public class StoneMapAsset {
    private static RNG rng = new RNG();
    private static Texture[] floor;
    private static Texture[] wall;
    private static Texture entrance;
    private static Texture exit;

    public static Texture getFloor() {
        if(floor == null) {
            floor = new Texture[]{
                    new Texture("sprites/dungeon/floor/pebble_brown_0_new.png"),
                    new Texture("sprites/dungeon/floor/pebble_brown_1_new.png"),
                    new Texture("sprites/dungeon/floor/pebble_brown_2_new.png"),
                    new Texture("sprites/dungeon/floor/pebble_brown_3_new.png"),
                    new Texture("sprites/dungeon/floor/pebble_brown_4_new.png"),
                    new Texture("sprites/dungeon/floor/pebble_brown_5_new.png"),
                    new Texture("sprites/dungeon/floor/pebble_brown_6_new.png"),
                    new Texture("sprites/dungeon/floor/pebble_brown_7_new.png"),
                    new Texture("sprites/dungeon/floor/pebble_brown_8_new.png")};
        }

        return rng.getRandomElement(floor);
    }

    public static Texture getWall() {
        if(wall == null) {
            wall = new Texture[]{
                    new Texture("sprites/dungeon/wall/brick_gray_0.png"),
                    new Texture("sprites/dungeon/wall/brick_gray_1.png"),
                    new Texture("sprites/dungeon/wall/brick_gray_2.png"),
                    new Texture("sprites/dungeon/wall/brick_gray_3.png")};
        }

        return rng.getRandomElement(wall);
    }

    public static Texture getEntrance() {
        if(entrance == null) {
            entrance = new Texture("sprites/dungeon/gateways/stone_stairs_up.png");
        }

        return entrance;
    }

    public static Texture getExit() {
        if(exit == null) {
            exit = new Texture("sprites/dungeon/gateways/stone_stairs_down.png");
        }

        return exit;
    }
}

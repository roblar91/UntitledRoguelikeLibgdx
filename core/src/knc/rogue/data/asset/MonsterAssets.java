package knc.rogue.data.asset;

import com.badlogic.gdx.graphics.Texture;

public final class MonsterAssets {
    private static Texture bat;

    public static Texture getBat() {
        if(bat == null) {
            bat = new Texture("sprites/monster/animals/bat.png");
        }

        return bat;
    }
}

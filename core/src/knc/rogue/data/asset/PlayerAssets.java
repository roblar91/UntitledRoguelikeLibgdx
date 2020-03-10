package knc.rogue.data.asset;

import com.badlogic.gdx.graphics.Texture;

public final class PlayerAssets {
    private static Texture humanFemale;

    public static Texture getHumanFemale() {
        if(humanFemale == null) {
            humanFemale = new Texture("sprites/player/base/human_female.png");
        }

        return humanFemale;
    }
}

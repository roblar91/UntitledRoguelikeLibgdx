package knc.rogue.asset;

import com.badlogic.gdx.graphics.Texture;

public class PlayerAssets {
    private Texture humanFemale;

    public Texture getHumanFemale() {
        if(humanFemale == null) {
            humanFemale = new Texture("character/player/human_f.png");
        }

        return humanFemale;
    }
}

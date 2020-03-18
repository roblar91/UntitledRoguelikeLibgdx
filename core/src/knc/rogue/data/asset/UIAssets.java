package knc.rogue.data.asset;

import com.badlogic.gdx.graphics.Texture;

public class UIAssets {
    private static Texture healthIcon;
    private static Texture staminaIcon;
    private static Texture manaIcon;

    public static Texture getHealthIcon() {
        if(healthIcon == null) {
            healthIcon = new Texture("sprites/custom/health.png");
        }

        return healthIcon;
    }

    public static Texture getStaminaIcon() {
        if(staminaIcon == null) {
            staminaIcon = new Texture("sprites/custom/stamina.png");
        }

        return staminaIcon;
    }

    public static Texture getManaIcon() {
        if(manaIcon == null) {
            manaIcon = new Texture("sprites/custom/mana.png");
        }

        return manaIcon;
    }
}

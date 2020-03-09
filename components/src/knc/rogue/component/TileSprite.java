package knc.rogue.component;

import com.artemis.Component;
import com.badlogic.gdx.graphics.Texture;

public class TileSprite extends Component {
    public Texture texture;
    public float scale;

    public void set(Texture texture, float scale) {
        this.texture = texture;
        this.scale = scale;
    }

    public void set(Texture texture) {
        set(texture, 1f);
    }
}

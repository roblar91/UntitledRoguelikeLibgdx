package knc.rogue.component;

import com.artemis.Component;
import com.badlogic.gdx.graphics.Texture;

public class TileSprite extends Component {
    public Texture texture;
    public int width;
    public int height;

    public void set(Texture texture) {
        this.texture = texture;
    }
}

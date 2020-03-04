package knc.rogue.component;

import com.artemis.Component;
import com.badlogic.gdx.graphics.Texture;

public class Sprite extends Component {
    public Texture texture;
    public int width;
    public int height;

    public void set(Texture texture, int width, int height) {
        this.texture = texture;
        this.width = width;
        this.height = height;
    }

    public void set(Texture texture) {
        set(texture, texture.getWidth(), texture.getHeight());
    }
}

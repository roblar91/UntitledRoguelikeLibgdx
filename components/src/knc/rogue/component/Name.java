package knc.rogue.component;

import com.artemis.Component;
import com.badlogic.gdx.graphics.Color;

public class Name extends Component {
    public String name;
    public Color color;

    public void set(String name, Color color) {
        this.name = name;
        this.color = color;
    }

    public void set(String name) {
        set(name, Color.WHITE);
    }
}

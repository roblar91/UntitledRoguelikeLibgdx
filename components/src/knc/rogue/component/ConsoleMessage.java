package knc.rogue.component;

import com.artemis.Component;
import com.badlogic.gdx.graphics.Color;
import squidpony.panel.IColoredString;

public class ConsoleMessage extends Component {
    public IColoredString<Color> message;

    public void set(IColoredString<Color> message) {
        this.message = message;
    }

    public void set(String message) {
        this.message = new IColoredString.Impl<>(message, Color.WHITE);
    }
}

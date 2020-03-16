package knc.rogue.system;

import com.artemis.E;
import com.artemis.FluidIteratingSystem;
import com.artemis.annotations.All;
import com.badlogic.gdx.graphics.Color;
import knc.rogue.component.Alive;
import knc.rogue.component.Health;
import squidpony.panel.IColoredString;

import java.util.logging.Logger;

@All({Alive.class, Health.class})
public class DeathSystem extends FluidIteratingSystem {
    private final static Logger LOGGER = Logger.getLogger(KeyboardInputSystem.class.getName());

    @Override
    protected void process(E e) {
        if(e.healthCurrentHealth() <= 0) {
            e.removeAlive();

            IColoredString<Color> message = new IColoredString.Impl<>();
            message.append(e.nameName(), e.nameColor());
            message.append(" has died!");
            E.E().consoleMessage(message);

            LOGGER.info(e.toString() + " " + e.nameName() +  " has died");
        }
    }
}

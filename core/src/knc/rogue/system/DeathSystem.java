package knc.rogue.system;

import com.artemis.E;
import com.artemis.annotations.All;
import com.artemis.systems.IteratingSystem;
import com.badlogic.gdx.graphics.Color;
import knc.rogue.component.Alive;
import knc.rogue.component.Health;
import knc.rogue.system.view.render.UIRenderSystem;
import squidpony.panel.IColoredString;

import java.util.logging.Logger;

@All({Alive.class, Health.class})
public class DeathSystem extends IteratingSystem {
    private final static Logger LOGGER = Logger.getLogger(KeyboardInputSystem.class.getName());

    @Override
    protected void process(int entityId) {
        E e = E.E(entityId);

        if(e.healthCurrentHealth() <= 0) {
            e.removeAlive();

            IColoredString<Color> string = new IColoredString.Impl<>();
            string.append(e.nameName(), e.nameColor());
            string.append(" has died!");
            UIRenderSystem.printToConsole(string);

            LOGGER.info(e.toString() + " " + e.nameName() +  " has died");
        }
    }
}

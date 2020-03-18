package knc.rogue.system;

import com.artemis.E;
import com.artemis.FluidIteratingSystem;
import com.artemis.annotations.All;
import com.artemis.annotations.Exclude;
import com.artemis.annotations.One;
import com.badlogic.gdx.graphics.Color;
import knc.rogue.component.*;
import knc.rogue.component.Character;
import knc.rogue.system.view.ui.ConsoleSystem;
import squidpony.panel.IColoredString;

import java.util.logging.Logger;

@All(Position.class)
@One({Character.class, Terrain.class, Item.class, MapObject.class})
@Exclude(Player.class)
public class SeenSystem extends FluidIteratingSystem {
    private final static Logger LOGGER = Logger.getLogger(KeyboardInputSystem.class.getName());
    private FOVSystem fovSystem;
    private ConsoleSystem consoleSystem;
    private PlayerSystem playerSystem;

    @Override
    protected void process(E e) {
        if(!e.hasSeen() && fovSystem.isVisible(playerSystem.getPlayer(), e)) {
            e.seen();
            LOGGER.finer("[Entity " + e.id() +"] " + e.nameName() +  " seen");

            if(e.hasCharacter()) {
                IColoredString<Color> message = new IColoredString.Impl<>();
                message.append(e.nameName(), e.nameColor());
                message.append(" has come into view!");
                E.E().consoleMessage(message);
            }
        }
    }
}

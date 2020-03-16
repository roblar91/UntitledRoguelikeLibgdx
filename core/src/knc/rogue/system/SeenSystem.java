package knc.rogue.system;

import com.artemis.E;
import com.artemis.annotations.All;
import com.artemis.annotations.Exclude;
import com.artemis.annotations.One;
import com.artemis.systems.IteratingSystem;
import com.badlogic.gdx.graphics.Color;
import knc.rogue.component.Character;
import knc.rogue.component.Player;
import knc.rogue.component.Position;
import knc.rogue.system.view.FOVSystem;
import knc.rogue.system.view.ui.ConsoleSystem;
import squidpony.panel.IColoredString;

@All(Position.class)
@One(Character.class)
@Exclude(Player.class)
public class SeenSystem extends IteratingSystem {
    private FOVSystem fovSystem;
    private ConsoleSystem consoleSystem;

    @Override
    protected void process(int entityId) {
        E e = E.E(entityId);

        if(!e.hasSeen() && fovSystem.fovMap[e.positionX()][e.positionY()] > 0) {
            e.seen();

            if(e.hasCharacter()) {
                IColoredString<Color> message = new IColoredString.Impl<>();
                message.append(e.nameName(), e.nameColor());
                message.append(" has come into view!");
                E.E().consoleMessage(message);
            }
        }
    }
}

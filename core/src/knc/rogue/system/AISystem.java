package knc.rogue.system;

import com.artemis.E;
import com.badlogic.gdx.graphics.Color;
import knc.rogue.component.Character;
import net.mostlyoriginal.api.system.core.PassiveSystem;
import squidpony.panel.IColoredString;

public class AISystem extends PassiveSystem {
    private FOVSystem fovSystem;
    private PlayerSystem playerSystem;

    public void act(E e) {
        if(e.hasSight() && fovSystem.isVisible(e, playerSystem.getPlayer())) {
            aggro(e);
        } else {
            doNothing(e);
        }
    }

    private void doNothing(E e) {
        e.energyAdd(-100);
    }

    private void aggro(E e) {
        if(e.characterBehaviour() != Character.Behaviour.AGGRESSIVE) {
            e.characterBehaviour(Character.Behaviour.AGGRESSIVE);
            IColoredString<Color> message = new IColoredString.Impl<>();
            message.append(e.nameName(), e.nameColor());
            message.append(" has spotted ");
            message.append(playerSystem.getPlayer().nameName(), playerSystem.getPlayer().nameColor());
            message.append("!");
            E.E().consoleMessage(message);
        }

        e.energyAdd(-100);
    }
}

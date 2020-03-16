package knc.rogue.command;

import com.artemis.E;
import com.badlogic.gdx.graphics.Color;
import knc.rogue.util.Formulae;
import squidpony.panel.IColoredString;

public class MeleeAttackCommand implements Command {
    private E actor;
    private E target;

    public MeleeAttackCommand(E actor, E target) {
        this.actor = actor;
        this.target = target;
    }

    @Override
    public void execute() {
        int damage = Formulae.calculateMeleeDamage(actor);
        target.healthCurrentHealth(target.healthCurrentHealth() - damage);


        IColoredString<Color> message = new IColoredString.Impl<>();
        message.append(actor.nameName(), actor.nameColor());
        message.append(" attacks ");
        message.append(target.nameName(), target.nameColor());
        message.append(" for ");
        message.append(String.valueOf(damage), Color.RED);
        message.append(" damage");
        E.E().consoleMessage(message);
    }
}

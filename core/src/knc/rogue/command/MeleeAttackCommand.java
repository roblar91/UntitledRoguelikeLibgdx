package knc.rogue.command;

import com.artemis.E;
import com.badlogic.gdx.graphics.Color;
import knc.rogue.system.view.render.UIRenderSystem;
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


        IColoredString<Color> string = new IColoredString.Impl<>();
        string.append(actor.nameName(), actor.nameColor());
        string.append(" attacks ");
        string.append(target.nameName(), target.nameColor());
        string.append(" for ");
        string.append(String.valueOf(damage), Color.RED);
        string.append(" damage");
        UIRenderSystem.printToConsole(string);
    }
}

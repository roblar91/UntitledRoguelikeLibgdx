package knc.rogue.command;

import com.artemis.E;
import knc.rogue.util.Formulae;

public class MeleeAttackCommand implements Command {
    private E actor;
    private E target;

    public MeleeAttackCommand(E actor, E target) {
        this.actor = actor;
        this.target = target;
    }

    @Override
    public void execute() {
        target.healthCurrentHealth(target.healthCurrentHealth() - Formulae.calculateMeleeDamage(actor));
    }
}

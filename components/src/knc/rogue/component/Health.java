package knc.rogue.component;

import com.artemis.Component;

public class Health extends Component {
    private int base;
    public int bonus;
    public int maxHealth;
    public int currentHealth;

    public int getTotal() {
        return base + bonus;
    }

    public int getBase() {
        return base;
    }

    public void set(int base) {
        this.base = base;
        this.maxHealth = base;
        this.currentHealth = base;
    }
}

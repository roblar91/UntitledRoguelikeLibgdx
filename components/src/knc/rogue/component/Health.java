package knc.rogue.component;

import com.artemis.Component;

public class Health extends Component {
    public int maxHealth;
    public int currentHealth;

    public void set(int maxHealth) {
        this.maxHealth = maxHealth;
        this.currentHealth = maxHealth;
    }
}

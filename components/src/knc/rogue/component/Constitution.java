package knc.rogue.component;

import com.artemis.Component;

public class Constitution extends Component {
    private int allocated = 0;
    private int base;
    public int bonus;

    public int getTotal() {
        return base + bonus;
    }

    public int getBase() {
        return base;
    }

    public void allocate() {
        allocated++;
        base++;
    }

    public void set(int base) {
        this.base = base;
    }
}

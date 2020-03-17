package knc.rogue.component;

import com.artemis.Component;

public class Energy extends Component {
    public int current = 0;

    public void add(int amount) {
        current += amount;
    }

    public boolean isFull() {
        return current >= 0;
    }
}

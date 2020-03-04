package knc.rogue.component;

import com.artemis.Component;

public class Position extends Component {
    public int x;
    public int y;

    public void set(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

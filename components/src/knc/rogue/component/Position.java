package knc.rogue.component;

import com.artemis.Component;

public class Position extends Component {
    public int x;
    public int y;
    public int areaId = -1;

    public void set(int x, int y, int areaId) {
        set(x, y);
        this.areaId = areaId;
    }

    public void set(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "(x, y, area) = (" + x + ", " + y + ", " + areaId + ")";
    }
}

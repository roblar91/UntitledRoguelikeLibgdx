package knc.rogue.component;

import com.artemis.Component;

public class Sight extends Component {
    public int range;
    public double[][] fovMap;

    public void set(int range) {
        this.range = range;
    }
}

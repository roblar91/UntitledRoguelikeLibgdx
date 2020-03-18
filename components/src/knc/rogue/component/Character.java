package knc.rogue.component;

import com.artemis.Component;

public class Character extends Component {
    public Behaviour behaviour = Behaviour.IDLE;

    public enum Behaviour {
        PLAYER,
        IDLE,
        AGGRESSIVE;
    }
}

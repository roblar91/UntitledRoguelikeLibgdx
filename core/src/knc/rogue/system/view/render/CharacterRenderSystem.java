package knc.rogue.system.view.render;

import com.artemis.E;
import com.artemis.annotations.All;
import knc.rogue.component.Alive;
import knc.rogue.component.Character;
import knc.rogue.component.Position;
import knc.rogue.component.TileSprite;

@All({Character.class, TileSprite.class, Position.class, Alive.class})
public class CharacterRenderSystem extends RenderSystem {
    @Override
    protected void process(E e) {
        float brightness = calculateBrightness(e, false);
        if(brightness > 0f) {
            drawEntity(e, brightness);
        }
    }
}

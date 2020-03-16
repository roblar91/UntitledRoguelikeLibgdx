package knc.rogue.system.view.render;

import com.artemis.E;
import com.artemis.annotations.All;
import knc.rogue.component.Item;
import knc.rogue.component.Position;
import knc.rogue.component.TileSprite;

@All({Item.class, TileSprite.class, Position.class})
public class ItemRenderSystem extends RenderSystem {
    @Override
    protected void process(E e) {
        float brightness = calculateBrightness(e, true);
        drawEntity(e, brightness);
    }
}

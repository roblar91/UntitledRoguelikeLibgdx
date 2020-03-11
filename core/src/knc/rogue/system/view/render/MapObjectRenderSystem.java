package knc.rogue.system.view.render;

import com.artemis.E;
import com.artemis.annotations.All;
import knc.rogue.component.MapObject;
import knc.rogue.component.Position;
import knc.rogue.component.TileSprite;

@All({MapObject.class, TileSprite.class, Position.class})
public class MapObjectRenderSystem extends RenderSystem {
    @Override
    protected void process(int entityId) {
        E e = E.E(entityId);

        float brightness = calculateBrightness(e, true);
        drawEntity(e, brightness);
    }
}


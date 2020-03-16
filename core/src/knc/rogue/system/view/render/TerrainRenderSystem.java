package knc.rogue.system.view.render;

import com.artemis.E;
import com.artemis.annotations.All;
import knc.rogue.component.Position;
import knc.rogue.component.Terrain;
import knc.rogue.component.TileSprite;

@All({Terrain.class, TileSprite.class, Position.class})
public class TerrainRenderSystem extends RenderSystem {
    @Override
    protected void process(E e) {
        float brightness = calculateBrightness(e, true);
        drawEntity(e, brightness);
    }
}

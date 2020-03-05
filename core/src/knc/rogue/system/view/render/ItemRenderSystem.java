package knc.rogue.system.view.render;

import com.artemis.annotations.All;
import com.artemis.systems.IteratingSystem;
import knc.rogue.component.Item;
import knc.rogue.component.Position;
import knc.rogue.component.TileSprite;

@All({Item.class, TileSprite.class, Position.class})
public class ItemRenderSystem extends IteratingSystem {
    private RenderSystem renderSystem;

    @Override
    protected void process(int entityId) {
        renderSystem.drawTile(entityId);
    }

    @Override
    protected void begin() {
        super.begin();

        renderSystem.batch.begin();
    }

    @Override
    protected void end() {
        super.end();

        renderSystem.batch.end();
    }
}

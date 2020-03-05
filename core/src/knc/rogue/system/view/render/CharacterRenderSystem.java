package knc.rogue.system.view.render;

import com.artemis.annotations.All;
import knc.rogue.component.Character;
import knc.rogue.component.Position;
import knc.rogue.component.TileSprite;

@All({Character.class, TileSprite.class, Position.class})
public class CharacterRenderSystem extends RenderSystem {
    @Override
    protected void process(int entityId) {
        drawTile(entityId);
    }
}

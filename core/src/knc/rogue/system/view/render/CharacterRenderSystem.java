package knc.rogue.system.view.render;

import com.artemis.E;
import com.artemis.annotations.All;
import knc.rogue.component.Character;
import knc.rogue.component.Position;
import knc.rogue.component.TileSprite;
import knc.rogue.util.Settings;

@All({Character.class, TileSprite.class, Position.class})
public class CharacterRenderSystem extends RenderSystem {
    @Override
    protected void process(int entityId) {
        E e = E.E(entityId);

        float brightness = (float) fovSystem.fovMap[e.positionX()][e.positionY()];
        if(brightness > 0) {
            brightness += Settings.BRIGHTNESS_BOOST;
        }

        if(brightness > 0) {
            drawTile(e, brightness);
        }
    }
}

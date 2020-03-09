package knc.rogue.system.view.render;

import com.artemis.E;
import com.artemis.annotations.All;
import knc.rogue.component.MapObject;
import knc.rogue.component.Position;
import knc.rogue.component.TileSprite;
import knc.rogue.util.Settings;

@All({MapObject.class, TileSprite.class, Position.class})
public class MapObjectRenderSystem extends RenderSystem {
    @Override
    protected void process(int entityId) {
        E e = E.E(entityId);

        float brightness = (float) fovSystem.fovMap[e.positionX()][e.positionY()];

        if(brightness > 0f) {
            e.terrainSeen(true);
            brightness += Settings.BRIGHTNESS_BOOST;
        }

        if(e.terrainSeen()) {
            brightness = Math.max(Settings.BRIGHTNESS_MIN, brightness);
        }

        drawTile(e, brightness);
    }
}


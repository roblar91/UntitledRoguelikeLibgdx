package knc.rogue.system.view;

import com.artemis.E;
import com.artemis.annotations.All;
import com.artemis.systems.IteratingSystem;
import knc.rogue.component.CameraFollow;
import knc.rogue.component.Position;
import knc.rogue.component.TileSprite;
import knc.rogue.util.Settings;

@All({CameraFollow.class, Position.class, TileSprite.class})
public class CameraSpriteFollowSystem extends IteratingSystem {
    private CameraSystem cameraSystem;

    @Override
    protected void process(int entityId) {
        E e = E.E(entityId);
        cameraSystem.getCamera().position.x = e.positionX() * Settings.TILE_WIDTH + e.tileSpriteWidth() / 2;
        cameraSystem.getCamera().position.y = e.positionY() * Settings.TILE_HEIGHT + e.tileSpriteHeight() / 2;
        cameraSystem.getCamera().update();
    }
}

package knc.rogue.system.view.camera;

import com.artemis.E;
import com.artemis.FluidIteratingSystem;
import com.artemis.annotations.All;
import knc.rogue.component.CameraFollow;
import knc.rogue.component.Position;
import knc.rogue.component.TileSprite;
import knc.rogue.util.Settings;

@All({CameraFollow.class, Position.class, TileSprite.class})
public class CameraSpriteFollowSystem extends FluidIteratingSystem {
    private CameraSystem cameraSystem;

    @Override
    protected void process(E e) {
        cameraSystem.getCamera().position.x = e.positionX() * Settings.TILE_WIDTH * Settings.TILE_SCALE + Settings.TILE_WIDTH * Settings.TILE_SCALE / 2;
        cameraSystem.getCamera().position.y = e.positionY() * Settings.TILE_HEIGHT * Settings.TILE_SCALE + Settings.TILE_HEIGHT * Settings.TILE_SCALE / 2;
        cameraSystem.getCamera().update();
    }
}

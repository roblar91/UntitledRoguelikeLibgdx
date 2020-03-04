package knc.rogue.system;

import com.artemis.E;
import com.artemis.annotations.All;
import com.artemis.systems.IteratingSystem;
import knc.rogue.component.CameraFollow;
import knc.rogue.component.Position;
import knc.rogue.component.Sprite;

@All({CameraFollow.class, Position.class, Sprite.class})
public class CameraSpriteFollowSystem extends IteratingSystem {
    private CameraSystem cameraSystem;

    @Override
    protected void process(int entityId) {
        E e = E.E(entityId);
        cameraSystem.getCamera().position.x = e.positionX() + e.spriteWidth() / 2;
        cameraSystem.getCamera().position.y = e.positionY() + e.spriteHeight() / 2;
        cameraSystem.getCamera().update();
    }
}

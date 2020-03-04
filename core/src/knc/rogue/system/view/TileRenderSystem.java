package knc.rogue.system.view;

import com.artemis.E;
import com.artemis.annotations.All;
import com.artemis.systems.IteratingSystem;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import knc.rogue.component.Position;
import knc.rogue.component.Sprite;
import knc.rogue.util.Settings;

@All({Sprite.class, Position.class})
public class TileRenderSystem extends IteratingSystem {
    private CameraSystem cameraSystem;

    private SpriteBatch batch;

    @Override
    protected void initialize() {
        super.initialize();

        batch = new SpriteBatch();
    }

    @Override
    protected void begin() {
        super.begin();

        batch.setProjectionMatrix(cameraSystem.getCamera().combined);
        batch.begin();
    }

    @Override
    protected void process(int entityId) {
        batch.draw(E.E(entityId).getSprite().texture,
                   E.E(entityId).getPosition().x * Settings.TILE_WIDTH,
                   E.E(entityId).getPosition().y * Settings.TILE_HEIGHT);
    }

    @Override
    protected void end() {
        super.end();

        batch.end();
    }

    @Override
    protected void dispose() {
        super.dispose();

        batch.dispose();
    }
}

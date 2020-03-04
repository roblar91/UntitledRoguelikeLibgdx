package knc.rogue.system.view;

import com.artemis.E;
import com.artemis.annotations.All;
import com.artemis.systems.IteratingSystem;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import knc.rogue.component.Position;
import knc.rogue.component.TileSprite;
import knc.rogue.util.Settings;

@All({TileSprite.class, Position.class})
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
        E e = E.E(entityId);

        batch.draw(e.getTileSprite().texture,
                   e.getPosition().x * Settings.TILE_WIDTH,
                   e.getPosition().y * Settings.TILE_HEIGHT,
                   Settings.TILE_WIDTH,
                   Settings.TILE_HEIGHT);
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

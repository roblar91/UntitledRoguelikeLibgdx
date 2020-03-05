package knc.rogue.system.view.render;

import com.artemis.BaseSystem;
import com.artemis.E;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import knc.rogue.system.view.CameraSystem;
import knc.rogue.util.Settings;

public class RenderSystem extends BaseSystem {
    private CameraSystem cameraSystem;

    public SpriteBatch batch;

    public void drawTile(int entityId) {
        E e = E.E(entityId);
        batch.draw(e.getTileSprite().texture,
                   e.getPosition().x * Settings.TILE_WIDTH,
                   e.getPosition().y * Settings.TILE_HEIGHT,
                   Settings.TILE_WIDTH,
                   Settings.TILE_HEIGHT);
    }

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
    protected void processSystem() {
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

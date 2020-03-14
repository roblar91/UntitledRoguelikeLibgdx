package knc.rogue.system.view.render;

import com.artemis.E;
import com.artemis.systems.IteratingSystem;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import knc.rogue.system.view.camera.CameraSystem;
import knc.rogue.system.view.FOVSystem;
import knc.rogue.util.Settings;

public abstract class RenderSystem extends IteratingSystem {
    protected CameraSystem cameraSystem;
    protected SpriteBatch batch;
    protected FOVSystem fovSystem;

    protected void drawEntity(E e, float brightness) {
        batch.setColor(brightness, brightness, brightness, 1f);
        batch.draw(e.getTileSprite().texture,
                   e.getPosition().x * Settings.TILE_WIDTH * Settings.TILE_SCALE,
                   e.getPosition().y * Settings.TILE_HEIGHT * Settings.TILE_SCALE,
                   Settings.TILE_WIDTH * Settings.TILE_SCALE,
                   Settings.TILE_HEIGHT * Settings.TILE_SCALE);
    }

    protected float calculateBrightness(E e, boolean useMinimumBrightnessSetting) {
        float brightness = (float) fovSystem.fovMap[e.positionX()][e.positionY()];

        if(brightness > 0f) {
            e.seen();
            brightness += Settings.BRIGHTNESS_BOOST;
        }

        if(useMinimumBrightnessSetting && e.hasSeen()) {
            brightness = Math.max(Settings.BRIGHTNESS_MIN, brightness);
        }

        return brightness;
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
    protected void end() {
        super.end();

        batch.end();
    }

    @Override
    protected void dispose() {
        super.dispose();

        batch.dispose();
    }

    @Override
    protected abstract void process(int entityId);
}

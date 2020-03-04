package knc.rogue.system.view;

import com.artemis.BaseSystem;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class CameraSystem extends BaseSystem {
    private OrthographicCamera camera = new OrthographicCamera();

    public CameraSystem() {
        resize();
    }

    public OrthographicCamera getCamera() {
        return camera;
    }

    public void resize() {
        camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        camera.update();
    }

    @Override
    protected void processSystem() {
    }
}

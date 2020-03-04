package knc.rogue.system;

import com.artemis.BaseSystem;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class CameraSystem extends BaseSystem {
    private OrthographicCamera camera;

    public CameraSystem(float width, float height) {
        camera = new OrthographicCamera();
        camera.setToOrtho(false, width, height);
        camera.update();
    }

    public OrthographicCamera getCamera() {
        return camera;
    }

    @Override
    protected void processSystem() {
    }
}

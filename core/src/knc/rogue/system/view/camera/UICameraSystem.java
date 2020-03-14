package knc.rogue.system.view.camera;

import com.artemis.BaseSystem;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class UICameraSystem extends BaseSystem {
    private OrthographicCamera camera = new OrthographicCamera();

    @Override
    protected void initialize() {
        super.initialize();

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

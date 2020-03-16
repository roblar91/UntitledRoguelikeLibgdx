package knc.rogue.system.view.camera;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import net.mostlyoriginal.api.system.core.PassiveSystem;

public class CameraSystem extends PassiveSystem {
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
}

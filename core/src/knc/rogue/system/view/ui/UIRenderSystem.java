package knc.rogue.system.view.ui;

import com.artemis.BaseSystem;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class UIRenderSystem extends BaseSystem {
    private ConsoleSystem consoleSystem;

    private Stage stage = new Stage();
    private ShapeRenderer shapeRenderer = new ShapeRenderer();
//    private HealthBar healthBar = new HealthBar();

    @Override
    protected void initialize() {
        super.initialize();

        stage.addActor(consoleSystem.getConsole());
    }

    @Override
    protected void processSystem() {
        stage.draw();
    }
}

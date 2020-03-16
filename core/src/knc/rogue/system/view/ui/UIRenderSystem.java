package knc.rogue.system.view.ui;

import com.artemis.BaseSystem;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.VerticalGroup;
import com.badlogic.gdx.utils.Align;

public class UIRenderSystem extends BaseSystem {
    private ConsoleSystem consoleSystem;

    private Stage stage = new Stage();
    private VerticalGroup upperLeft = new VerticalGroup();
    private ShapeRenderer shapeRenderer = new ShapeRenderer();
    private Bar healthBar = new Bar(shapeRenderer, 200, 20, 3, Color.DARK_GRAY, Color.RED);
    private Bar staminaBar = new Bar(shapeRenderer, 200, 20, 3, Color.DARK_GRAY, Color.YELLOW);
    private Bar manaBar = new Bar(shapeRenderer, 200, 20, 3, Color.DARK_GRAY, Color.BLUE);

    @Override
    protected void initialize() {
        super.initialize();

        upperLeft.align(Align.topLeft);
        upperLeft.addActor(healthBar);
        upperLeft.addActor(staminaBar);
        upperLeft.addActor(manaBar);

        stage.addActor(consoleSystem.getConsole());
        stage.addActor(upperLeft);

        resize();
    }

    @Override
    protected void processSystem() {
        stage.draw();
    }

    public void resize() {
        ((OrthographicCamera) stage.getCamera()).setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        upperLeft.setPosition(0, Gdx.graphics.getHeight());
        consoleSystem.getConsole().setPosition(0, 0);
    }
}

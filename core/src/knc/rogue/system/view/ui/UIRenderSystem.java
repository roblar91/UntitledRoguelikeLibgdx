package knc.rogue.system.view.ui;

import com.artemis.BaseSystem;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.VerticalGroup;
import com.badlogic.gdx.utils.Align;
import knc.rogue.system.PlayerSystem;
import squidpony.squidgrid.gui.gdx.SColor;

public class UIRenderSystem extends BaseSystem {
    private ConsoleSystem consoleSystem;
    private PlayerSystem playerSystem;

    private Stage stage = new Stage();
    private VerticalGroup upperLeft = new VerticalGroup();
    private ShapeRenderer shapeRenderer = new ShapeRenderer();
    private Bar healthBar = new Bar(shapeRenderer, 200, 25, 3, SColor.CW_GRAY_BLACK, SColor.CW_RICH_RED);
    private Bar staminaBar = new Bar(shapeRenderer, 200, 25, 3, SColor.CW_GRAY_BLACK, SColor.SELECTIVE_YELLOW);
    private Bar manaBar = new Bar(shapeRenderer, 200, 25, 3, SColor.CW_GRAY_BLACK, SColor.AURORA_ROYAL_BLUE);

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
        healthBar.setText(playerSystem.player.healthCurrentHealth() + "/" + playerSystem.player.healthMaxHealth());
        stage.draw();
    }

    public void resize() {
        ((OrthographicCamera) stage.getCamera()).setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        upperLeft.setPosition(0, Gdx.graphics.getHeight());
        upperLeft.validate();

        healthBar.reposition();
        staminaBar.reposition();
        manaBar.reposition();

        consoleSystem.getConsole().setPosition(0, 0);
    }
}

package knc.rogue.system.view.ui;

import com.artemis.BaseSystem;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.HorizontalGroup;
import com.badlogic.gdx.scenes.scene2d.ui.VerticalGroup;
import knc.rogue.data.asset.UIAssets;
import knc.rogue.system.PlayerSystem;
import squidpony.squidgrid.gui.gdx.SColor;

public class UIRenderSystem extends BaseSystem {
    private ConsoleSystem consoleSystem;
    private PlayerSystem playerSystem;

    private final Color BACKGROUND_COLOR = SColor.CW_GRAY_BLACK;
    private final Color HEALTH_COLOR = SColor.CW_RICH_RED;
    private final Color STAMINA_COLOR = SColor.SELECTIVE_YELLOW;
    private final Color MANA_COLOR = SColor.AURORA_ROYAL_BLUE;


    private Stage stage = new Stage();
    private VerticalGroup upperLeft = new VerticalGroup();
    private ShapeRenderer shapeRenderer = new ShapeRenderer();
    private Icon healthIcon = new Icon(UIAssets.getHealthIcon(), shapeRenderer, BACKGROUND_COLOR);
    private Icon staminaIcon = new Icon(UIAssets.getStaminaIcon(), shapeRenderer, BACKGROUND_COLOR);
    private Icon manaIcon = new Icon(UIAssets.getManaIcon(), shapeRenderer, BACKGROUND_COLOR);
    private Bar healthBar = new Bar(shapeRenderer, 200, 25, 3, BACKGROUND_COLOR, HEALTH_COLOR);
    private Bar staminaBar = new Bar(shapeRenderer, 200, 25, 3, BACKGROUND_COLOR, STAMINA_COLOR);
    private Bar manaBar = new Bar(shapeRenderer, 200, 25, 3, BACKGROUND_COLOR, MANA_COLOR);

    @Override
    protected void initialize() {
        super.initialize();

        upperLeft.left();
        upperLeft.columnLeft();

        HorizontalGroup health = new HorizontalGroup();
        health.addActor(healthIcon);
        health.addActor(healthBar);
        upperLeft.addActor(health);

        HorizontalGroup stamina = new HorizontalGroup();
        stamina.addActor(staminaIcon);
        stamina.addActor(staminaBar);
        upperLeft.addActor(stamina);

        HorizontalGroup mana = new HorizontalGroup();
        mana.addActor(manaIcon);
        mana.addActor(manaBar);
        upperLeft.addActor(mana);

        stage.addActor(consoleSystem.getConsole());
        stage.addActor(upperLeft);

        resize();
    }

    @Override
    protected void processSystem() {
        healthBar.setText(playerSystem.getPlayer().healthCurrentHealth() + "/" + playerSystem.getPlayer().healthMaxHealth());
        stage.draw();
    }

    public void resize() {
        ((OrthographicCamera) stage.getCamera()).setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        upperLeft.setPosition(0, Gdx.graphics.getHeight());
        upperLeft.validate();

        healthIcon.reposition();
        healthBar.reposition();
        staminaIcon.reposition();
        staminaBar.reposition();
        manaIcon.reposition();
        manaBar.reposition();

        consoleSystem.getConsole().setPosition(0, 0);
    }
}

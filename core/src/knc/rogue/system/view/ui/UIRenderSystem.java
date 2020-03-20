package knc.rogue.system.view.ui;

import com.artemis.BaseSystem;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import knc.rogue.data.asset.UIAssets;
import knc.rogue.system.PlayerSystem;
import knc.rogue.util.Settings;
import squidpony.squidgrid.gui.gdx.SColor;

public class UIRenderSystem extends BaseSystem {
    private ConsoleSystem consoleSystem;
    private PlayerSystem playerSystem;

    private final Color BAR_BACKGROUND_COLOR = SColor.DARK_BLUE_LAPIS_LAZULI;
    private final Color HEALTH_COLOR = SColor.CW_RICH_RED;
    private final Color STAMINA_COLOR = SColor.SELECTIVE_YELLOW;
    private final Color MANA_COLOR = SColor.AURORA_ROYAL_BLUE;

    private Table rootTable = new Table();

    private Stage stage = new Stage();
    private ShapeRenderer shapeRenderer = new ShapeRenderer();
    private Icon healthIcon = new Icon(UIAssets.getHealthIcon());
    private Icon staminaIcon = new Icon(UIAssets.getStaminaIcon());
    private Icon manaIcon = new Icon(UIAssets.getManaIcon());
    private Bar healthBar = new Bar(shapeRenderer, 200, 10, 1, BAR_BACKGROUND_COLOR, HEALTH_COLOR);
    private Bar staminaBar = new Bar(shapeRenderer, 200, 10, 1, BAR_BACKGROUND_COLOR, STAMINA_COLOR);
    private Bar manaBar = new Bar(shapeRenderer, 200, 10, 1, BAR_BACKGROUND_COLOR, MANA_COLOR);

    @Override
    protected void initialize() {
        super.initialize();

        stage.addActor(rootTable);
        rootTable.top().left();
        rootTable.defaults().center().left();

        rootTable.add(healthIcon).pad(2);
        rootTable.add(healthBar).expandX();
        rootTable.row();
        rootTable.add(staminaIcon).pad(2);
        rootTable.add(staminaBar).expandX();
        rootTable.row();
        rootTable.add(manaIcon).pad(2);
        rootTable.add(manaBar).expandX();
        rootTable.row();
        rootTable.add(consoleSystem.getConsole()).expandY().bottom().colspan(3);

        resize();
    }

    @Override
    protected void processSystem() {
        updateText();
        stage.draw();
    }

    public void resize() {
        ((OrthographicCamera) stage.getCamera()).setToOrtho(false, Gdx.graphics.getWidth() / Settings.UI_SCALE, Gdx.graphics.getHeight() / Settings.UI_SCALE);

        rootTable.setWidth(stage.getCamera().viewportWidth);
        rootTable.setHeight(stage.getCamera().viewportHeight);
        rootTable.validate();
        healthBar.reposition();
        staminaBar.reposition();
        manaBar.reposition();
    }

    private void updateText() {
//        healthLabel.setText(playerSystem.getPlayer().healthCurrentHealth() + "/" + playerSystem.getPlayer().healthMaxHealth());
//        staminaLabel.setText("Stamina");
//        manaLabel.setText("Mana");
    }
}

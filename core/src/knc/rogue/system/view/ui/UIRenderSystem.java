package knc.rogue.system.view.ui;

import com.artemis.BaseSystem;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.utils.Align;
import knc.rogue.data.asset.UIAssets;
import knc.rogue.system.PlayerSystem;
import knc.rogue.util.Settings;
import squidpony.squidgrid.gui.gdx.DefaultResources;
import squidpony.squidgrid.gui.gdx.SColor;

public class UIRenderSystem extends BaseSystem {
    private ConsoleSystem consoleSystem;
    private PlayerSystem playerSystem;

    private final Color BACKGROUND_COLOR = SColor.CW_GRAY_BLACK;
    private final Color HEALTH_COLOR = SColor.CW_RICH_RED;
    private final Color STAMINA_COLOR = SColor.SELECTIVE_YELLOW;
    private final Color MANA_COLOR = SColor.AURORA_ROYAL_BLUE;

    private Table rootTable = new Table();

    private Stage stage = new Stage();
    private ShapeRenderer shapeRenderer = new ShapeRenderer();
    private Icon healthIcon = new Icon(UIAssets.getHealthIcon(), shapeRenderer, BACKGROUND_COLOR);
    private Icon staminaIcon = new Icon(UIAssets.getStaminaIcon(), shapeRenderer, BACKGROUND_COLOR);
    private Icon manaIcon = new Icon(UIAssets.getManaIcon(), shapeRenderer, BACKGROUND_COLOR);
    private Bar healthBar = new Bar(shapeRenderer, 200, 25, 3, BACKGROUND_COLOR, HEALTH_COLOR);
    private Bar staminaBar = new Bar(shapeRenderer, 200, 25, 3, BACKGROUND_COLOR, STAMINA_COLOR);
    private Bar manaBar = new Bar(shapeRenderer, 200, 25, 3, BACKGROUND_COLOR, MANA_COLOR);
    private Label healthLabel;
    private Label staminaLabel;
    private Label manaLabel;

    @Override
    protected void initialize() {
        super.initialize();

        Label.LabelStyle style = new Label.LabelStyle(DefaultResources.getCrispLeanFont().resetSize(8, 16).font(), Color.WHITE);

        healthLabel = new Label("", style);
        healthLabel.setAlignment(Align.bottom);

        staminaLabel = new Label("", style);
        staminaLabel.setAlignment(Align.bottom);

        manaLabel = new Label("", style);
        manaLabel.setAlignment(Align.bottom);

        stage.addActor(rootTable);
        rootTable.setFillParent(true);
        rootTable.defaults().top().left();
        rootTable.top().left();

        rootTable.add(healthIcon);
        rootTable.stack(healthBar, healthLabel).height(healthBar.getHeight()).expandX();
        rootTable.row();
        rootTable.add(staminaIcon);
        rootTable.stack(staminaBar, staminaLabel).height(staminaBar.getHeight()).expandX();
        rootTable.row();
        rootTable.add(manaIcon);
        rootTable.stack(manaBar, manaLabel).height(manaBar.getHeight()).expandX();
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

        rootTable.validate();
        healthIcon.reposition();
        healthBar.reposition();
        staminaIcon.reposition();
        staminaBar.reposition();
        manaIcon.reposition();
        manaBar.reposition();
    }

    private void updateText() {
        healthLabel.setText(playerSystem.getPlayer().healthCurrentHealth() + "/" + playerSystem.getPlayer().healthMaxHealth());
        staminaLabel.setText("Stamina");
        manaLabel.setText("Mana");
    }
}

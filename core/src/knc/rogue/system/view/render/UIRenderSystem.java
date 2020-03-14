package knc.rogue.system.view.render;

import com.artemis.BaseSystem;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import knc.rogue.system.view.camera.UICameraSystem;
import squidpony.panel.IColoredString;
import squidpony.squidgrid.gui.gdx.DefaultResources;
import squidpony.squidgrid.gui.gdx.SquidMessageBox;

public class UIRenderSystem extends BaseSystem {
    private UICameraSystem uiCameraSystem;
    private static SquidMessageBox messageBox = new SquidMessageBox(40, 10);
    private SpriteBatch uiBatch = new SpriteBatch();

    @Override
    protected void initialize() {
        super.initialize();

        messageBox.setFont(DefaultResources.getCrispLeanFont());
        messageBox.fillBackground(new Color(0.08f, 0.08f, 0.08f, 1f));
    }

    @Override
    protected void begin() {
        super.begin();

        uiBatch.setProjectionMatrix(uiCameraSystem.getCamera().combined);
        uiBatch.begin();
    }

    @Override
    protected void processSystem() {
        messageBox.draw(uiBatch, 1f);
    }

    @Override
    protected void end() {
        super.end();

        uiBatch.end();
    }

    public static void printToConsole(String string) {
        messageBox.appendWrappingMessage(string);
    }

    public static void printToConsole(IColoredString<Color> string) {
        messageBox.appendWrappingMessage(string);
    }
}

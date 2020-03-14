package knc.rogue.system.view.render;

import com.artemis.BaseSystem;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import squidpony.panel.IColoredString;
import squidpony.squidgrid.gui.gdx.SquidMessageBox;

public class UIRenderSystem extends BaseSystem {
    private static SquidMessageBox messageBox = new SquidMessageBox(40, 10);
    private OrthographicCamera camera = new OrthographicCamera();
    private SpriteBatch uiBatch = new SpriteBatch();

    @Override
    protected void initialize() {
        super.initialize();

        resizeCamera();
        messageBox.fillBackground(new Color(0.08f, 0.08f, 0.08f, 1f));
    }

    @Override
    protected void begin() {
        super.begin();

        uiBatch.setProjectionMatrix(camera.combined);
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

    public void resizeCamera() {
        camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        camera.update();
    }

    public static void printToConsole(IColoredString<Color> string) {
        messageBox.appendWrappingMessage(string);
    }
}

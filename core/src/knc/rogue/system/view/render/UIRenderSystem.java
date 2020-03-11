package knc.rogue.system.view.render;

import com.artemis.BaseSystem;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import squidpony.squidgrid.gui.gdx.SquidMessageBox;

public class UIRenderSystem extends BaseSystem {
    SquidMessageBox messageBox = new SquidMessageBox(20, 10);
    SpriteBatch uiBatch = new SpriteBatch();

    @Override
    protected void begin() {
        super.begin();

        uiBatch.begin();
    }

    @Override
    protected void processSystem() {
        messageBox.appendMessage("Hello friend");
        messageBox.draw(uiBatch, 1f);
    }

    @Override
    protected void end() {
        super.end();

        uiBatch.end();
    }
}

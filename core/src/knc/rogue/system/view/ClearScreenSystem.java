package knc.rogue.system.view;

import com.artemis.BaseSystem;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;

public class ClearScreenSystem extends BaseSystem {
    private Color color;

    public ClearScreenSystem(Color color) {
        this.color = color;
    }

    @Override
    protected void processSystem() {
        Gdx.gl.glClearColor(color.r, color.g, color.b, color.a);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }
}

package knc.rogue.system.view.ui;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;

public class HealthBar {
    private Rectangle container = new Rectangle(0, 500, 200, 40);
    private Rectangle inner = new Rectangle(5, 505, 190, 30);

    public void draw(ShapeRenderer renderer) {
        renderer.begin(ShapeRenderer.ShapeType.Filled);
        renderer.setColor(Color.BLUE);
        renderer.rect(0, 500, 200, 40);
        renderer.setColor(Color.RED);
        renderer.rect(5, 505, 190, 30);
        renderer.end();
    }
}

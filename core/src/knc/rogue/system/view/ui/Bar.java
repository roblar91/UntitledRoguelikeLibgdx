package knc.rogue.system.view.ui;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Bar extends Actor {
    private ShapeRenderer shapeRenderer;
    private int outerThickness;
    private Color outerColor;
    private Color innerColor;
    private Vector2 stageCoordinates;

    public Bar(ShapeRenderer shapeRenderer,
               int width,
               int height,
               int outerThickness,
               Color outerColor,
               Color innerColor) {
        this.shapeRenderer = shapeRenderer;
        this.outerThickness = outerThickness;
        this.outerColor = outerColor;
        this.innerColor = innerColor;

        setWidth(width);
        setHeight(height);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.end();
        stageCoordinates = getParent().localToStageCoordinates(new Vector2(getX(), getY()));

        shapeRenderer.setProjectionMatrix(batch.getProjectionMatrix());
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);

        shapeRenderer.setColor(outerColor);
        shapeRenderer.rect(stageCoordinates.x,
                           stageCoordinates.y,
                           getWidth(),
                           getHeight());

        shapeRenderer.setColor(innerColor);
        shapeRenderer.rect(stageCoordinates.x + outerThickness,
                           stageCoordinates.y + outerThickness,
                           getWidth() - outerThickness * 2,
                           getHeight() - outerThickness * 2);

        shapeRenderer.end();
        batch.begin();
    }
}

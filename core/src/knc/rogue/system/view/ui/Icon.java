package knc.rogue.system.view.ui;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Icon extends Actor {
    private Texture texture;
    private ShapeRenderer shapeRenderer;
    private Color backgroundColor;
    private Vector2 stageCoordinates;

    public Icon(Texture texture, ShapeRenderer shapeRenderer, Color backgroundColor) {
        this.texture = texture;
        this.shapeRenderer = shapeRenderer;
        this.backgroundColor = backgroundColor;

        setWidth(texture.getWidth());
        setHeight(texture.getHeight());
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.end();

        shapeRenderer.setProjectionMatrix(batch.getProjectionMatrix());
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(backgroundColor);
        shapeRenderer.rect(stageCoordinates.x, stageCoordinates.y, getWidth(), getHeight());
        shapeRenderer.end();

        batch.begin();
        batch.setColor(Color.WHITE);
        batch.draw(texture, getX(), getY());
    }

    public void reposition() {
        stageCoordinates = getParent().localToStageCoordinates(new Vector2(getX(), getY()));
    }
}

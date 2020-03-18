package knc.rogue.system.view.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import squidpony.squidgrid.gui.gdx.DefaultResources;
import squidpony.squidgrid.gui.gdx.TextCellFactory;

public class Bar extends Actor {
    private ShapeRenderer shapeRenderer;
    private int outerThickness;
    private Color outerColor;
    private Color innerColor;
    private Color innerColorSecondary;
    private Vector2 stageCoordinates;
    private TextCellFactory textCellFactory;
    private String text;

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

        innerColorSecondary = innerColor.cpy();
        innerColorSecondary.mul(0.2f);

        textCellFactory = DefaultResources.getCrispLeanFont();
        textCellFactory.resetSize(8, 16);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.end();
        shapeRenderer.setProjectionMatrix(batch.getProjectionMatrix());
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);

        shapeRenderer.setColor(outerColor);
        shapeRenderer.rect(stageCoordinates.x,
                           stageCoordinates.y,
                           getWidth(),
                           getHeight());

        shapeRenderer.rect(stageCoordinates.x + outerThickness,
                           stageCoordinates.y + outerThickness,
                           getWidth() - outerThickness * 2,
                           getHeight() - outerThickness * 2,
                           innerColorSecondary,
                           innerColorSecondary,
                           innerColor,
                           innerColor);

        shapeRenderer.end();
        batch.begin();

        if(text != null) {
            textCellFactory.draw(batch,
                                 text,
                                 Color.WHITE,
                                 stageCoordinates.x + getWidth() / 2,
                                 textCellFactory.height() / 2 + getHeight() / 2);
        }
    }

    public void reposition() {
        stageCoordinates = getParent().localToStageCoordinates(new Vector2(getX(), getY()));
    }

    public void setText(String text) {
        this.text = text;
    }
}

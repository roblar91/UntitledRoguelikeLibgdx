package knc.rogue.screen;

import com.artemis.E;
import com.artemis.SuperMapper;
import com.artemis.World;
import com.artemis.WorldConfigurationBuilder;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import knc.rogue.system.CameraSpriteFollowSystem;
import knc.rogue.system.CameraSystem;
import knc.rogue.system.ClearScreenSystem;
import knc.rogue.system.RenderSystem;

public class GameScreen implements Screen {
    private World world;

    private World createWorld() {
        WorldConfigurationBuilder builder = new WorldConfigurationBuilder()
                .alwaysDelayComponentRemoval(true)
                .with(new SuperMapper(),
                      new ClearScreenSystem(Color.RED),
                      new CameraSystem(Gdx.graphics.getWidth(), Gdx.graphics.getHeight()),
                      new CameraSpriteFollowSystem(),
                      new RenderSystem());
        return new World(builder.build());
    }

    @Override
    public void show() {
        if(world == null) {
            world = createWorld();

            E.E()
                    .sprite(new Texture("badlogic.jpg"))
                    .position(50, 50)
                    .cameraFollow();
        }
    }

    @Override
    public void render(float delta) {
        world.setDelta(delta);
        world.process();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}

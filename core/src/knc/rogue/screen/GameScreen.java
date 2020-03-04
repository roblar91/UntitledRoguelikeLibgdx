package knc.rogue.screen;

import com.artemis.SuperMapper;
import com.artemis.World;
import com.artemis.WorldConfigurationBuilder;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import knc.rogue.system.GameStateSystem;
import knc.rogue.system.map.MapGenerationSystem;
import knc.rogue.system.view.CameraSpriteFollowSystem;
import knc.rogue.system.view.CameraSystem;
import knc.rogue.system.view.ClearScreenSystem;
import knc.rogue.system.view.TileRenderSystem;

public class GameScreen implements Screen {
    private World world;

    private World createWorld() {
        WorldConfigurationBuilder builder = new WorldConfigurationBuilder()
                .alwaysDelayComponentRemoval(true)
                .with(new SuperMapper(),
                      new MapGenerationSystem(),
                      new GameStateSystem(),
                      new ClearScreenSystem(Color.RED),
                      new CameraSystem(),
                      new CameraSpriteFollowSystem(),
                      new TileRenderSystem()
                );

        return new World(builder.build());
    }

    @Override
    public void show() {
        if(world == null) {
            world = createWorld();
        }
    }

    @Override
    public void render(float delta) {
        world.setDelta(delta);
        world.process();
    }

    @Override
    public void resize(int width, int height) {
        world.getSystem(CameraSystem.class).resize();
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

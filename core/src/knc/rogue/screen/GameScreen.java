package knc.rogue.screen;

import com.artemis.SuperMapper;
import com.artemis.World;
import com.artemis.WorldConfigurationBuilder;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import knc.rogue.system.GameStateSystem;
import knc.rogue.system.map.MapGenerationSystem;
import knc.rogue.system.map.PlayerSystem;
import knc.rogue.system.view.*;
import knc.rogue.system.view.render.CharacterRenderSystem;
import knc.rogue.system.view.render.RenderSystem;
import knc.rogue.system.view.render.TerrainRenderSystem;

public class GameScreen implements Screen {
    private World world;

    private World createWorld() {
        WorldConfigurationBuilder builder = new WorldConfigurationBuilder()
                .alwaysDelayComponentRemoval(true)
                .with(new SuperMapper(),
                      new PlayerSystem(),
                      new MapGenerationSystem(),
                      new GameStateSystem(),
                      new ClearScreenSystem(Color.BLACK),
                      new RenderSystem(),
                      new TerrainRenderSystem(),
                      new CharacterRenderSystem(),
                      new CameraSystem(),
                      new CameraSpriteFollowSystem()
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

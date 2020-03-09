package knc.rogue.screen;

import com.artemis.SuperMapper;
import com.artemis.World;
import com.artemis.WorldConfigurationBuilder;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import knc.rogue.system.*;
import knc.rogue.system.map.MapGenerationSystem;
import knc.rogue.system.view.*;
import knc.rogue.system.view.render.*;

public class GameScreen implements Screen {
    private World world;

    private World createWorld() {
        WorldConfigurationBuilder builder = new WorldConfigurationBuilder()
                .with(new SuperMapper(),
                      new KeyboardInputSystem(),
                      new MovementSystem(),
                      new PlayerSystem(),
                      new MapGenerationSystem(),
                      new GameStateSystem(),
                      new CommandSystem(),
                      new DeathSystem(),

                      // Rendering
                      new FOVSystem(),
                      new CameraSystem(),
                      new CameraSpriteFollowSystem(),
                      new ClearScreenSystem(Color.BLACK),
                      new TerrainRenderSystem(),
                      new MapObjectRenderSystem(),
                      new ItemRenderSystem(),
                      new CharacterRenderSystem(),
                      new ComponentCleanupSystem()
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

package knc.rogue.screen;

import com.artemis.SuperMapper;
import com.artemis.World;
import com.artemis.WorldConfigurationBuilder;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import knc.rogue.system.*;
import knc.rogue.system.map.MapGenerationSystem;
import knc.rogue.system.view.*;
import knc.rogue.system.view.camera.CameraSpriteFollowSystem;
import knc.rogue.system.view.camera.CameraSystem;
import knc.rogue.system.view.render.*;
import knc.rogue.system.view.ui.ConsoleSystem;
import knc.rogue.system.view.ui.UIRenderSystem;

import java.util.logging.Logger;

public class GameScreen implements Screen {
    private final static Logger LOGGER = Logger.getLogger(KeyboardInputSystem.class.getName());
    private World world;

    private World createWorld() {
        LOGGER.info("Creating world");

        WorldConfigurationBuilder builder = new WorldConfigurationBuilder()
                .with(new SuperMapper(),
                      new ConsoleSystem(),
                      new KeyboardInputSystem(),
                      new MovementSystem(),
                      new PlayerSystem(),
                      new MapGenerationSystem(),
                      new GameStateSystem(),
                      new CommandSystem(),
                      new DeathSystem(),
                      new FOVSystem(),
                      new SeenSystem(),

                      // Rendering
                      new CameraSystem(),
                      new CameraSpriteFollowSystem(),
                      new ClearScreenSystem(Color.BLACK),
                      new TerrainRenderSystem(),
                      new MapObjectRenderSystem(),
                      new ItemRenderSystem(),
                      new CharacterRenderSystem(),
                      new UIRenderSystem(),

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

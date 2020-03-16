package knc.rogue.system.view.ui;

import com.artemis.E;
import com.artemis.FluidIteratingSystem;
import com.artemis.annotations.All;
import com.badlogic.gdx.graphics.Color;
import knc.rogue.component.ConsoleMessage;
import knc.rogue.util.Settings;
import squidpony.panel.IColoredString;
import squidpony.squidgrid.gui.gdx.DefaultResources;
import squidpony.squidgrid.gui.gdx.SquidMessageBox;

@All(ConsoleMessage.class)
public class ConsoleSystem extends FluidIteratingSystem {
    private SquidMessageBox console;

    @Override
    protected void initialize() {
        super.initialize();

        console = new SquidMessageBox(Settings.CONSOLE_WIDTH, Settings.CONSOLE_HEIGHT);
        console.setFont(DefaultResources.getCrispLeanFont());
        console.fillBackground(new Color(0.08f, 0.08f, 0.08f, 1f));

        IColoredString<Color> message = new IColoredString.Impl<>();
        message.append("Welcome!");
        print(message);
    }

    @Override
    protected void process(E e) {
        print(e.consoleMessageMessage());
        e.deleteFromWorld();
    }

    public SquidMessageBox getConsole() {
        return console;
    }

    private void print(IColoredString<Color> message) {
        console.appendWrappingMessage(message);
    }
}

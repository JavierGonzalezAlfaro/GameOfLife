package gameoflife;

import gameoflife.control.commands.ColorCommand;
import gameoflife.control.commands.PlayCommand;
import gameoflife.control.commands.GliderCommand;
import gameoflife.control.commands.RandomCommand;
import gameoflife.control.commands.ResetCommand;
import gameoflife.control.commands.OptionsCommand;
import gameoflife.control.commands.FastCommand;
import gameoflife.control.commands.SlowCommand;
import gameoflife.control.commands.StartCommand;
import gameoflife.control.Command;
import gameoflife.control.commands.DimensionCommand;
import gameoflife.control.commands.ExitCommand;
import gameoflife.control.commands.LoadCommand;
import gameoflife.control.commands.MuteCommand;
import gameoflife.control.commands.OKCommand;
import gameoflife.control.commands.SaveCommand;
import gameoflife.control.commands.SongCommand;
import gameoflife.ui.ActionListenerFactory;
import gameoflife.ui.MatrixDialog;
import gameoflife.ui.swing.SwingMatrixDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class Application {

    private Map<String, Command> commands;
    private ActionListenerFactory factory;

    public static void main(String[] args) {
        new Application().execute();
    }

    private void execute() {
        factory = createActionListenerFactory();
        createCommands();
        MatrixDialog dialog = new SwingMatrixDialog(factory);
        dialog.execute();
    }

    private void createCommands() {
        commands = new HashMap<>();
        commands.put("exit", new ExitCommand());
        commands.put("start", new StartCommand(factory));
        commands.put("dimension", new DimensionCommand());
        commands.put("ok", new OKCommand(factory));
        commands.put("slow", new SlowCommand());
        commands.put("play", new PlayCommand());
        commands.put("fast", new FastCommand());
        commands.put("options", new OptionsCommand(factory));
        commands.put("random", new RandomCommand());
        commands.put("reset", new ResetCommand());
        commands.put("glider", new GliderCommand());
        commands.put("color", new ColorCommand());
        commands.put("song", new SongCommand());
        commands.put("mute", new MuteCommand());
        commands.put("save", new SaveCommand());
        commands.put("load", new LoadCommand());
    }

    private ActionListenerFactory createActionListenerFactory() {
        return new ActionListenerFactory() {
            @Override
            public ActionListener create(final String name) {
                return new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        commands.get(name).execute();
                    }
                };
            }
        };
    }
}
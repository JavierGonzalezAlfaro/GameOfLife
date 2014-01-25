package gameoflife.control.commands;

import gameoflife.control.Command;
import gameoflife.ui.swing.SwingMatrixOptions;
import gameoflife.ui.swing.SwingMatrixViewer;

public class RandomCommand implements Command {

    @Override
    public void execute() {
        SwingMatrixOptions.getLoader().loadRandom(SwingMatrixViewer.getMatrix());
    }
}

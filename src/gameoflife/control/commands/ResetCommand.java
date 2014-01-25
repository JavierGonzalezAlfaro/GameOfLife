package gameoflife.control.commands;

import gameoflife.control.Command;
import gameoflife.ui.swing.SwingMatrixOptions;
import gameoflife.ui.swing.SwingMatrixViewer;

public class ResetCommand implements Command {

    @Override
    public void execute() {
        SwingMatrixOptions.getLoader().loadBlank(SwingMatrixViewer.getMatrix());
    }
}

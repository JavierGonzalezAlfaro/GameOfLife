package gameoflife.control.commands;

import gameoflife.control.Command;
import gameoflife.model.Matrix;
import gameoflife.ui.ActionListenerFactory;
import gameoflife.ui.swing.SwingMatrixOptions;
import gameoflife.ui.swing.SwingMatrixViewer;

public class OptionsCommand implements Command {

    private ActionListenerFactory factory;
    private Matrix matrix;

    public OptionsCommand(ActionListenerFactory factory) {
        this.factory = factory;
        this.matrix = SwingMatrixViewer.getMatrix();
    }

    @Override
    public void execute() {
        SwingMatrixOptions options = new SwingMatrixOptions(factory, matrix);
        options.execute();
    }
}

package gameoflife.control.commands;

import gameoflife.control.Command;
import gameoflife.persistance.file.FileMatrixLoader;
import gameoflife.ui.swing.SwingMatrixViewer;

public class LoadCommand implements Command {

    @Override
    public void execute() {
        FileMatrixLoader loader = new FileMatrixLoader();
        loader.load(SwingMatrixViewer.getMatrix(), "state1");
    }
}

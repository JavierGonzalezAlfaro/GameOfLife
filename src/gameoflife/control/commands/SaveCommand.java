package gameoflife.control.commands;

import gameoflife.control.Command;
import gameoflife.persistance.file.FileMatrixStorer;
import gameoflife.ui.swing.SwingMatrixViewer;

public class SaveCommand implements Command {

    @Override
    public void execute() {
        FileMatrixStorer storer = new FileMatrixStorer();
        storer.store(SwingMatrixViewer.getMatrix(), "state1");
    }
}

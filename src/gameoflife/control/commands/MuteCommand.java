package gameoflife.control.commands;

import gameoflife.control.Command;
import gameoflife.ui.swing.SwingMatrixDialog;

public class MuteCommand implements Command {

    @Override
    public void execute() {
        if (SwingMatrixDialog.getSound().isActive()) {
            SwingMatrixDialog.getSound().pause();
        } else {
            SwingMatrixDialog.getSound().play();
        }
    }
}

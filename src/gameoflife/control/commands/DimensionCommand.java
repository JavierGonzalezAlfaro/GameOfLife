package gameoflife.control.commands;

import gameoflife.control.Command;
import gameoflife.ui.swing.SwingMatrixDialog;

public class DimensionCommand implements Command {

    @Override
    public void execute() {
        SwingMatrixDialog.setSize(StartCommand.getCombobox().getSelectedItem().toString());
    }
}

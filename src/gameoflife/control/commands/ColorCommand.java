package gameoflife.control.commands;

import gameoflife.control.Command;
import gameoflife.ui.swing.SwingMatrixOptions;
import gameoflife.ui.swing.SwingMatrixViewer;
import java.awt.Color;

public class ColorCommand implements Command {

    @Override
    public void execute() {
        String selection = SwingMatrixOptions.getColorBox().getSelectedItem().toString();
        if (selection.equals(SwingMatrixOptions.getColores()[1])) {
            SwingMatrixViewer.setColor(new Color(0, 255, 0));
        }
        if (selection.equals(SwingMatrixOptions.getColores()[2])) {
            SwingMatrixViewer.setColor(new Color(255, 0, 0));
        }
        if (selection.equals(SwingMatrixOptions.getColores()[3])) {
            SwingMatrixViewer.setColor(new Color(0, 0, 255));
        }
        if (selection.equals(SwingMatrixOptions.getColores()[4])) {
            SwingMatrixViewer.setColor(new Color(0, 0, 0));
        }
    }
}
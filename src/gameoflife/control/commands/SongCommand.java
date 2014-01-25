package gameoflife.control.commands;

import gameoflife.control.Command;
import gameoflife.ui.swing.SwingMatrixDialog;
import gameoflife.ui.swing.SwingMatrixOptions;

public class SongCommand implements Command {

    @Override
    public void execute() {
        String soundPath = SwingMatrixDialog.getSound().getSoundPath();
        String selected = SwingMatrixOptions.getSoundBox().getSelectedItem().toString();
        if (selected.equals(SwingMatrixOptions.getSongs()[1])) {
            soundPath = "Sound\\FF7.wav";
        }
        if (selected.equals(SwingMatrixOptions.getSongs()[2])) {
            soundPath = "Sound\\PkmOp.wav";
        }
        if (selected.equals(SwingMatrixOptions.getSongs()[3])) {
            soundPath = "Sound\\PkmCenter.wav";
        }
        if (selected.equals(SwingMatrixOptions.getSongs()[4])) {
            soundPath = "Sound\\PkmPT.wav";
        }
        if (selected.equals(SwingMatrixOptions.getSongs()[5])) {
            soundPath = "Sound\\PkmBicicle.wav";
        }
        if (selected.equals(SwingMatrixOptions.getSongs()[6])) {
            soundPath = "Sound\\PkmLa.wav";
        }
        SwingMatrixDialog.getSound().changeSound(soundPath);
        SwingMatrixDialog.getSound().loop();
    }
}
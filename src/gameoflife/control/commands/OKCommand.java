package gameoflife.control.commands;

import gameoflife.control.Command;
import gameoflife.model.Matrix;
import gameoflife.model.Sound;
import gameoflife.persistance.MatrixLoader;
import gameoflife.persistance.swing.SwingMatrixLoader;
import gameoflife.ui.ActionListenerFactory;
import gameoflife.ui.MatrixViewer;
import gameoflife.ui.swing.SwingMatrixDialog;
import gameoflife.ui.swing.SwingMatrixViewer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class OKCommand implements Command {

    private static Matrix matrix;
    private ActionListenerFactory factory;
    private static int delay;
    private static Timer timer;

    public OKCommand(ActionListenerFactory factory) {
        this.factory = factory;
        this.delay = 120;
    }

    public static int getDelay() {
        return delay;
    }

    public static void setDelay(int delay) {
        OKCommand.delay = delay;
    }

    public static Timer getTimer() {
        return timer;
    }

    @Override
    public void execute() {
        Sound buttonSound = new Sound("Sound\\LockIn.wav");
        buttonSound.play();
        StartCommand.getFrame().dispose();
        MatrixLoader loader = new SwingMatrixLoader();
        matrix = createMatrix(loader);
        SwingMatrixDialog.getFrame().dispose();
        MatrixViewer viewer = new SwingMatrixViewer(matrix, factory);
        play(viewer);
    }

    private Matrix createMatrix(MatrixLoader loader) {
        if ("Small".equals(SwingMatrixDialog.getSize())) {
            matrix = loader.load(10, 30);
        } else if ("Medium".equals(SwingMatrixDialog.getSize())) {
            matrix = loader.load(30, 50);
        } else {
            matrix = loader.load(50, 70);
        }
        return matrix;
    }

    private void play(final MatrixViewer viewer) {
        timer = new Timer(delay, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewer.show();
            }
        });
        timer.start();
    }
}

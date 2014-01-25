package gameoflife.ui.swing;

import gameoflife.model.Matrix;
import gameoflife.persistance.swing.SwingMatrixLoader;
import gameoflife.ui.ActionListenerFactory;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class SwingMatrixOptions {

    private static JComboBox colorBox;
    private static JComboBox soundBox;
    private static String[] colores = {"Seleccione un Color", "GREEN", "RED", "BLUE", "BLACK"};
    private static String[] songs = {"Seleccione una Cancion", "Final Fantasy", "Pokemon Opening", "Pokemon Center", "Pokemon Palette", "Pokemon Cycling", "Pokemon Lavender"};
    private static SwingMatrixLoader loader = new SwingMatrixLoader();
    private ActionListenerFactory factory;

    public SwingMatrixOptions(ActionListenerFactory factory, Matrix matrix) {
        this.factory = factory;
    }

    public static SwingMatrixLoader getLoader() {
        return loader;
    }

    public static JComboBox getColorBox() {
        return colorBox;
    }

    public static JComboBox getSoundBox() {
        return soundBox;
    }

    public static String[] getColores() {
        return colores;
    }

    public static String[] getSongs() {
        return songs;
    }

    public void execute() {
        JFrame frame = new JFrame();
        frame.setTitle("Options");
        frame.add(createPanel());
        frame.setMinimumSize(new Dimension(200, 200));
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setAlwaysOnTop(true);
    }

    private JPanel createPanel() {
        JPanel panel = new JPanel();
        panel.add(createRandomButton());
        panel.add(createResetButton());
        panel.add(createGliderButton());
        panel.add(createExitButton());
        panel.add(createColorBox());
        panel.add(createSongBox());
        panel.add(createMuteButton());
        return panel;
    }

    private JButton createRandomButton() {
        JButton button = new JButton("Random");
        button.addActionListener(factory.create("random"));
        return button;
    }

    private JButton createResetButton() {
        JButton button = new JButton("Reset");
        button.addActionListener(factory.create("reset"));
        return button;
    }

    private JButton createGliderButton() {
        JButton button = new JButton("Glider");
        button.addActionListener(factory.create("glider"));
        return button;
    }

    private JButton createExitButton() {
        JButton button = new JButton("Exit");
        button.addActionListener(factory.create("exit"));
        return button;
    }

    private JComboBox createColorBox() {
        colorBox = new JComboBox(colores);
        colorBox.addActionListener(factory.create("color"));
        return colorBox;
    }

    private JComboBox createSongBox() {
        soundBox = new JComboBox(songs);
        soundBox.addActionListener(factory.create("song"));
        return soundBox;
    }

    private JButton createMuteButton() {
        JButton button = new JButton("Mute");
        button.addActionListener(factory.create("mute"));
        return button;
    }
}

package gameoflife.ui.swing;

import gameoflife.model.Sound;
import gameoflife.ui.ActionListenerFactory;
import gameoflife.ui.MatrixDialog;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SwingMatrixDialog implements MatrixDialog {

    private static Sound sound;
    private static String size;
    private ActionListenerFactory factory;
    private static JFrame dialogFrame;

    public SwingMatrixDialog(ActionListenerFactory factory) {
        this.factory = factory;
        this.size = "Small";
        this.sound = new Sound("Sound\\FF7.wav");
        this.dialogFrame = new JFrame();
    }

    public static JFrame getFrame() {
        return dialogFrame;
    }

    public static Sound getSound() {
        return sound;
    }

    public static String getSize() {
        return size;
    }

    public static void setSize(String size) {
        SwingMatrixDialog.size = size;
    }

    @Override
    public void execute() {
        sound.loop();
        createFrame();
    }

    private void createFrame() {
        dialogFrame.add(createPanel(dialogFrame));
        dialogFrame.setMinimumSize(new Dimension(480, 300));
        dialogFrame.setLocationRelativeTo(null);
        dialogFrame.setVisible(true);
        dialogFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private JPanel createPanel(JFrame frame) {
        Panel panel = new Panel();
        panel.setBackgroundImage(new ImageIcon("Image\\Fondo.jpg").getImage());
        panel.add(Box.createVerticalGlue());
        panel.add(createLabel());
        panel.add(Box.createVerticalGlue());
        panel.add(Box.createVerticalGlue());
        panel.add(createStartButton(frame));
        panel.add(Box.createVerticalGlue());
        panel.add(createExitButton());
        panel.add(Box.createVerticalGlue());
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        return panel;
    }

    private JLabel createLabel() {
        JLabel label = new JLabel("EL JUEGO DE LA VIDA");
        label.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        label.setFont(new Font(label.getFont().getFontName(), label.getFont().getStyle(), 30));
        return label;
    }

    private JButton createStartButton(final JFrame frame) {
        JButton button = new JButton("Start");
        button.setAlignmentX(JButton.CENTER_ALIGNMENT);
        button.setToolTipText("Start the simulation");
        button.addActionListener(factory.create("start"));
        return button;
    }

    private JButton createExitButton() {
        JButton button = new JButton("Exit");
        button.setAlignmentX(JButton.CENTER_ALIGNMENT);
        button.setToolTipText("Leave the simulation");
        button.addActionListener(factory.create("exit"));
        return button;
    }
}
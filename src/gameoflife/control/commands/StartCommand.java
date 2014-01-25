package gameoflife.control.commands;

import gameoflife.control.Command;
import gameoflife.ui.ActionListenerFactory;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class StartCommand implements Command {

    private ActionListenerFactory factory;
    private String size;
    private static JComboBox combobox;
    private static JFrame frame;

    public StartCommand(ActionListenerFactory factory) {
        this.factory = factory;
    }

    public static JComboBox getCombobox() {
        return combobox;
    }

    public static JFrame getFrame() {
        return frame;
    }

    @Override
    public void execute() {
        frame = new JFrame();
        frame.add(createOptionPanel(frame));
        frame.setMinimumSize(new Dimension(250, 150));
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private JPanel createOptionPanel(JFrame frame) {
        JPanel panel = new JPanel();
        panel.add(createOptionLabel());
        panel.add(createComboBox());
        panel.add(createOKButton(frame));
        return panel;
    }

    private JComboBox createComboBox() {
        String[] dimensiones = {"Small", "Medium", "Big"};
        combobox = new JComboBox(dimensiones);
        combobox.addActionListener(factory.create("dimension"));
        return combobox;
    }

    private JLabel createOptionLabel() {
        JLabel label = new JLabel("Select a dimension");
        return label;
    }

    private JButton createOKButton(final JFrame frame) {
        JButton button = new JButton("OK");
        button.addActionListener(factory.create("ok"));
        return button;
    }
}

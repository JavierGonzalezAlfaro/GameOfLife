package gameoflife.ui.swing;

import gameoflife.model.Matrix;
import gameoflife.ui.ActionListenerFactory;
import gameoflife.ui.MatrixViewer;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class SwingMatrixViewer implements MatrixViewer {

    private static Matrix matrix;
    private JButton[][] jMatrix;
    private static Color color;
    private JFrame frame;
    private ActionListenerFactory factory;

    public SwingMatrixViewer(Matrix matrix, ActionListenerFactory factory) {
        frame = new JFrame();
        this.factory = factory;
        this.matrix = matrix;
        this.color = Color.BLACK;
        this.jMatrix = new JButton[matrix.getHeigth()][matrix.getWidth()];
        frame.setTitle("Game Of Life");
        frame.add(createPanel(), BorderLayout.SOUTH);
        frame.add(createJMenuBar(), BorderLayout.NORTH);
        if (matrix.getWidth() == 70) {
            frame.setSize(1070, 860);
        } else if (matrix.getWidth() == 50) {
            frame.setSize(770, 560);
        } else {
            frame.setSize(470, 260);
        }
        createJMatrix();
        frame.add(createMatrixPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
    }

    public static void setColor(Color color) {
        SwingMatrixViewer.color = color;
    }

    public static Matrix getMatrix() {
        return matrix;
    }

    public static void setMatrix(Matrix matrix) {
        SwingMatrixViewer.matrix = matrix;
    }

    @Override
    public void show() {
        frame.setVisible(true);
        matrix.checkStatus();
        matrix.changeStatus();
        changeJStatus();
    }

    private JButton createSlowButton() {
        JButton button = new JButton();
        button.setIcon(new ImageIcon("Image\\slower.png"));
        button.addActionListener(factory.create("slow"));
        return button;
    }

    private JButton createPlayButton() {
        JButton button = new JButton();
        button.setIcon(new ImageIcon("Image\\pp.png"));
        button.addActionListener(factory.create("play"));
        return button;
    }

    private JButton createFastButton() {
        JButton button = new JButton();
        button.setIcon(new ImageIcon("Image\\faster.png"));
        button.addActionListener(factory.create("fast"));
        return button;
    }

    private JButton createOptionButton() {
        JButton button = new JButton("Options");
        button.addActionListener(factory.create("options"));
        return button;
    }

    private JPanel createPanel() {
        JPanel panel = new JPanel();
        panel.add(createSlowButton());
        panel.add(createPlayButton());
        panel.add(createFastButton());
        panel.add(createOptionButton());
        return panel;
    }

    private JPanel createMatrixPanel() {
        JPanel panel = new JPanel();
        for (int i = 0; i < jMatrix.length; i++) {
            for (int j = 0; j < jMatrix[0].length; j++) {
                panel.add(jMatrix[i][j]);
            }
        }
        panel.setMaximumSize(new Dimension(620, 610));
        return panel;
    }

    private JButton[][] createJMatrix() {
        for (int i = 0; i < jMatrix.length; i++) {
            for (int j = 0; j < jMatrix[0].length; j++) {
                final int ii = i, jj = j;
                final JButton button = new JButton();
                if (matrix.getMatrix()[i][j].getState()) {
                    button.setBackground(color);
                } else {
                    button.setBackground(Color.WHITE);
                }
                button.setPreferredSize(new Dimension(10, 10));
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        button.setBackground(button.getBackground() != Color.WHITE ? Color.WHITE : color);
                        matrix.setCell(ii, jj, matrix.getCell(ii, jj).getState() ? false : true);
                    }
                });
                jMatrix[i][j] = button;
            }
        }
        return jMatrix;
    }

    private void changeJStatus() {
        for (int i = 0; i < jMatrix.length; i++) {
            for (int j = 0; j < jMatrix[0].length; j++) {
                if (matrix.getCell(i, j).getState()) {
                    jMatrix[i][j].setBackground(color);
                } else {
                    jMatrix[i][j].setBackground(Color.WHITE);
                }
            }
        }
    }

    private JMenuBar createJMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Options");
        JMenuItem save = new JMenuItem("Save");
        save.addActionListener(factory.create("save"));
        JMenuItem load = new JMenuItem("Load");
        load.addActionListener(factory.create("load"));
        menu.add(save);
        menu.add(load);
        menuBar.add(menu);
        return menuBar;
    }
}
package MemoryGame;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Collections;

public class MemoryGame extends JFrame {
    final int COLUMNS = 4;
    final int ROWS = 3;
    ArrayList<JButton> buttonList = new ArrayList<JButton>();
    ArrayList<Color> colorsList = new ArrayList<Color>();

    int match = 0;
    JButton initialSelection;

    public MemoryGame() {
        super("Memory Game");
        setLookAndFeel();

        GridLayout gridLayout = new GridLayout(ROWS, COLUMNS);

        for (int i = 0; i < ROWS * COLUMNS; i++) {
            JButton button = new JButton();
            button.addActionListener(this::ButtonClicked);
            buttonList.add(button);
            add(button);
        }
        InitColorsList();
        setLayout(gridLayout);
        setSize(900, 900);
        setLocation(500, 0);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    void setLookAndFeel() {
        try {
            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            // If Nimbus is not available, you can set the GUI to another look and feel.
        }
    }

    private void ButtonClicked(ActionEvent actionEvent) {
        JButton button = (JButton) actionEvent.getSource();

        int index = buttonList.indexOf(button);
        Color color = colorsList.get(index);
        button.setBackground(color);

        if (initialSelection == null) {
            // then we know this is the first button click
            initialSelection = button;
            // button.setEnabled(false);
        } else {
            if (initialSelection.getBackground().equals(button.getBackground())) {
                // let user know of match
                // button.setEnabled(false);
                match++;
            } else {
                // let user know there wasnt a match
                JOptionPane.showMessageDialog(this, "the colors dont match");

                // reset the buttons
                button.setEnabled(true);
                button.setBackground(null);
                initialSelection.setEnabled(true);
                initialSelection.setBackground(null);

            }

            // reset the first selection to null
            initialSelection = null;

        }

    }

    private void InitColorsList() {
        Collections.addAll(colorsList, Color.CYAN, Color.CYAN, Color.MAGENTA, Color.MAGENTA, Color.PINK, Color.PINK,
                Color.BLACK, Color.BLACK, Color.ORANGE, Color.ORANGE, Color.YELLOW, Color.YELLOW);
        Collections.shuffle(colorsList);
    }
}
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class TicTacToe extends TestJFrame {

    ArrayList<JButton> buttons = new ArrayList<JButton>();
    String currentPlayer;

    JMenuBar menuBar;
    JMenu menu;
    JMenuItem menuItem;

    public TicTacToe() {
        super();

        panel.setLayout(new GridLayout(3, 3));
        Font font = new Font("SansSerif", Font.BOLD, 70);

        for (int i = 0; i < 9; i++) {
            JButton button = new JButton();
            button.addActionListener(e -> ButtonClicked(e));
            button.setFont(font);
            // button.setText("" + i);
            panel.add(button);
            buttons.add(button);
        }

        setContentPane(panel);
    }

    private void ButtonClicked(ActionEvent e) {
        SwitchPlayer();
        JButton button = (JButton) e.getSource();
        button.setText(currentPlayer);
        button.setEnabled(false);

        if (currentPlayer == "x") {
            button.setBackground(Color.MAGENTA);
        } else {
            button.setBackground(new Color(100, 32, 200));
        }

        if (WeHaveAWinner()) {
            JOptionPane.showMessageDialog(null, currentPlayer + " has won!");

            for (int i = 0; i < 9; i++) {
                buttons.get(i).setEnabled(false);
            }
        }
    }

    private void SwitchPlayer() {
        if (currentPlayer == "x") {
            currentPlayer = "o";
        } else {
            currentPlayer = "x";
        }
    }

    private boolean WeHaveAWinner() {
        if (buttons.get(0).getText().equals(currentPlayer) &&
                buttons.get(1).getText().equals(currentPlayer) &&
                buttons.get(2).getText().equals(currentPlayer)) {
            return true;
        }

        if (buttons.get(3).getText().equals(currentPlayer) &&
                buttons.get(4).getText().equals(currentPlayer) &&
                buttons.get(5).getText().equals(currentPlayer)) {
            return true;
        }

        if (buttons.get(6).getText().equals(currentPlayer) &&
                buttons.get(7).getText().equals(currentPlayer) &&
                buttons.get(8).getText().equals(currentPlayer)) {
            return true;
        }

        if (buttons.get(0).getText().equals(currentPlayer) &&
                buttons.get(3).getText().equals(currentPlayer) &&
                buttons.get(6).getText().equals(currentPlayer)) {
            return true;
        }

        if (buttons.get(1).getText().equals(currentPlayer) &&
                buttons.get(4).getText().equals(currentPlayer) &&
                buttons.get(7).getText().equals(currentPlayer)) {
            return true;
        }

        if (buttons.get(2).getText().equals(currentPlayer) &&
                buttons.get(5).getText().equals(currentPlayer) &&
                buttons.get(8).getText().equals(currentPlayer)) {
            return true;
        }

        if (buttons.get(0).getText().equals(currentPlayer) &&
                buttons.get(4).getText().equals(currentPlayer) &&
                buttons.get(8).getText().equals(currentPlayer)) {
            return true;
        }

        if (buttons.get(2).getText().equals(currentPlayer) &&
                buttons.get(4).getText().equals(currentPlayer) &&
                buttons.get(6).getText().equals(currentPlayer)) {
            return true;
        }

        return false;
    }
}

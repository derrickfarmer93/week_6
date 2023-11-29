import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class TestJFrame extends JFrame {
    JPanel panel;

    public TestJFrame() {
        super("TicTacToe Game");

        JMenuBar menuBar = new JMenuBar();
        // create a JMenu
        JMenu menu = new JMenu("GameOptions");
        // add JMenu to JMenuBar
        menuBar.add(menu);

        // Create a Menu Option

        panel = new JPanel();
        setContentPane(panel);

        setLocation(0, 0);
        setSize(500, 600);
        setVisible(true);
    }

}

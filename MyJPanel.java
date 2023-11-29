import java.awt.*;
import javax.swing.*;

public class MyJPanel extends JPanel {
    JButton okButton = new JButton("Ok");
    JButton cancelButton = new JButton("Cancel");

    public MyJPanel() {
        super();
        setLayout(new BorderLayout());
        okButton.addActionListener(new MyOkButtonHandler());
        cancelButton.addActionListener(e -> System.exit(0));
        add(okButton, BorderLayout.CENTER);
        add(cancelButton, BorderLayout.SOUTH);
    }

    @Override
    protected void paintComponent(Graphics g) {
        // TODD Auto-Generated method stub
        super.paintComponent(g);
        g.drawString("Hello World", 20, 30);
    }
}

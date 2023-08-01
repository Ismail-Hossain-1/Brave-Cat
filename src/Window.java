
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Window extends JFrame {
    JFrame refrm;

    JPanel panRe;

    public Window() {
        refrm = new JFrame("Rever game ");
        panRe = new JPanel();
        panRe.setSize(500, 500);
        // Reverpenal.setBackground(Color.bl
        panRe.setVisible(true);
        panRe.setBackground(Color.black);

        refrm.add(panRe);
        refrm.setSize(500, 500);
        // Reverpenal.setBackground(Color.black);
        refrm.setVisible(true);
        refrm.setLocationRelativeTo(null);
        refrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /* ReverMan.add(Reverpenal); */
        /* ReverMan.setSize(450,450); */
        /* ReverMan.setVisible(true); */
    }
}

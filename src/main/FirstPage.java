package main;

import static main.Game.*;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class FirstPage {

    JLabel button, bg = new JLabel();
    JFrame first;
    ImageIcon bag = new ImageIcon("Brave-Cat/src/main/First/First Page.png");
    ImageIcon btn = new ImageIcon("Brave-Cat/src/main/First/Button.png");

    public FirstPage() {
        game = false;
        bg.setIcon(bag);
        first = new JFrame();
        // first.setLayout(null);

        button = new JLabel(btn);
        // button.setLocation((screeenWidth/2)-40, (screenHeight/2)-40);
        button.setBounds(260, 230, btn.getIconWidth(), btn.getIconHeight());
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                game = true;
                new Game.GameWindow();
                first.dispose();
            }
        });
        first.setIconImage(new ImageIcon("Brave-Cat/src/main/Char/Front.png").getImage());
        first.setPreferredSize(new Dimension(screeenWidth, screenHeight));

        first.add(button);
        first.add(bg);

        first.pack();
        first.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        first.setLocationRelativeTo(null);
        first.setVisible(true);

    }

}

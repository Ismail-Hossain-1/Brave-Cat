
package main;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Game {

    public static ImageIcon image = new ImageIcon("Brave-Cat/src/main/Char/Front.png");
    static final int screeenWidth = 768, screenHeight = 620;
    public static JLabel cat, plank, river;
    public static JFrame frame;

    public static boolean game;

    public static void main(String[] args) {
        new FirstPage();
    }

    public static class GameWindow {

        public GameWindow() {
            frame = new JFrame();

            cat = new JLabel();
            cat.setBounds(0, 0, 52, 52);

            frame.add(cat);

            cat.setIcon(image);
            frame.addKeyListener(new Keys());

            frame.setPreferredSize(new Dimension(screeenWidth, screenHeight));

            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.getContentPane().setBackground(Color.BLACK);

            frame.setLayout(null);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);

        }
    }
}

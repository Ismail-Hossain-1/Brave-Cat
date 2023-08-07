package main;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Game {



   public static ImageIcon image= new ImageIcon("Brave-Cat/src/main/Char/Front.png");
   static final int screeenWidth= 768, screenHeight = 620;
   public static JLabel cat, plank, river;
    public static JFrame frame;

    public static boolean game;

    public static void main(String[] args) {

       new FirstPage();
    }
  public static class GameWindow{

      public  GameWindow(){
            frame = new JFrame();
            frame.setIconImage(image.getImage());
            frame.setTitle("Brave Cat");


            cat = new JLabel();
            cat.setBounds(0, 0, 52, 52);
           // cat.setLocation(0, 0);


            frame.add(cat);

            frame.setLayout(null);
            cat.setIcon(image);
            frame.addKeyListener(new Keys());


            frame.setPreferredSize(new Dimension(screeenWidth, screenHeight));


            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.getContentPane().setBackground(Color.BLACK);

            frame.pack();


            frame.setLocationRelativeTo(null);
            frame.setVisible(true);

        }
    }
}

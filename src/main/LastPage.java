package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static main.Game.*;

public class LastPage {

    JLabel exit, background;
    ImageIcon Exit = new ImageIcon("Brave-Cat/src/main/LastPage/Exit.png");
    ImageIcon bg= new ImageIcon("Brave-Cat/src/main/LastPage/Last Page.png");
  //  ImageIcon Replay= new ImageIcon("DraftGame/src/main/LastPage/Replay.png");

    JFrame last;
    public LastPage(){
       last= new JFrame("Brave Cat");

       background = new JLabel();
       background.setBounds(0, 0, bg.getIconWidth(), bg.getIconHeight());
       background.setIcon(bg);

         exit= new JLabel();
         //replay= new JLabel();

         exit.setIcon(Exit);
        // replay.setIcon(Replay);
        last.setLayout(null);
        last.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        last.setIconImage(new ImageIcon("Brave-Cat/src/main/Char/Front.png").getImage());
        last.setPreferredSize(new Dimension(screeenWidth, screenHeight));

        exit.setBounds(250, 230, Exit.getIconWidth(), Exit.getIconHeight());
        exit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

               // new Game.GameWindow();
                last.dispose();
            }
        });

        last.add(exit);
        last.add(background);
        last.pack();
        last.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        last.setLocationRelativeTo(null);
        last.setVisible(true);

     }

}

package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import static main.Game.*;

public class Keys implements KeyListener, Runnable {


  public  static boolean run, left, right, up, down=true, space, game=true;
   static ImageIcon Front, Back, Left, Right, Plank,River,  L, R, B, F;
    String direction="up";
    static int playerSpeed =3, plankX=0, plankY=290;
    Keys(){

        getImage();

        new Thread(this).start();

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

   private int code, x, y;
    int upS = 0, downS = 0;
    @Override
    public void keyPressed(KeyEvent e) {
         code = e.getKeyCode();
          x= Game.cat.getX();
          y=Game.cat.getY();
      //  System.out.println(code);

        if(code ==32) {

                space = true;

                if (direction=="up") {

                    if(y-200<0){
                        cat.setLocation(x, 0);
                    }
                    else
                        cat.setLocation(x, y - 200);

                }


                if (direction=="down") {

                    if(y+300>screenHeight){
                        cat.setLocation(x, screenHeight-90);
                    }
                    else
                        cat.setLocation(x, y + 200);
            }
        }
        switch (code) {
            case 37:
                if(x-playerSpeed<0) cat.setLocation(0, y);
                else {
                    cat.setLocation(x - playerSpeed, y);
                }
                cat.setIcon(L);
                left = true;
                break;
            case 39:
                if(x+playerSpeed>screeenWidth-52) cat.setLocation(screeenWidth-56, y);
                else {
                    cat.setLocation(x + playerSpeed, y);
                }
                cat.setIcon(R);
                right = true;
                break;
            case 38:
                if(y-playerSpeed<0) cat.setLocation(x, 0);
                else {
                    Game.cat.setLocation(x, y - playerSpeed);
                }
                Game.cat.setIcon(B);
                up = true;
                break;
            case 40:
                if(y+playerSpeed+90>screenHeight) cat.setLocation(x, screenHeight-90);
                else {
                    Game.cat.setLocation(x, y + playerSpeed);
                }
                Game.cat.setIcon(F);
                down =true;
                break;

        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

        int code = e.getKeyCode();
        if(code == 37){
            Game.cat.setIcon(Left);
            direction ="left";
            left=false;
        }
        if(code == 39){
            Game.cat.setIcon(Right);
            direction="right";
            right=false;
        }
        if(code == 38){
            Game.cat.setIcon(Back);
            direction="up";
            up=false;
        }
        if(code == 40){
            Game.cat.setIcon(Front);
            direction="down";
            down = false;
        }
        if(code==32) {

            space = false;
        }
    }

    @Override
    public void run() {
        plank =new JLabel();
        river = new JLabel();
        river.setBounds(0, 0,screeenWidth,screenHeight);
        river.setBorder(BorderFactory.createMatteBorder(10, 0, 10, 0,new Color(194, 178, 128)));
        river.setIcon(River);


        update();
        //checkCollision();

    }
    public void update() {

        plank.setIcon(Plank);



        while(game) {


            plankX+=2;
            plank.setBounds(plankX, plankY, Plank.getIconWidth(), Plank.getIconHeight());
            frame.add(plank);
            frame.add(river);
            if(plankX>screeenWidth) plankX=0;


            try {
                checkCollision();
                Thread.sleep(20);

            } catch (InterruptedException e) {}



        }

    }
    public void checkCollision(){
        int catX=cat.getX(), catY= cat.getY();
        int plankX1=plank.getX(), plankY1=plank.getY();
        int plankX2=plank.getX()+Plank.getIconWidth(), plankY2=plank.getY()+ Plank.getIconHeight();
      //  System.out.println("CATY "+catY+"plankY1 "+plankY1+" CatX "+ (catX)+" Plankx1 "+(plankX1+52));
        if( catY>85 && ((catY+52)<520) ){
            if((catY+32<plankY1 || catY+32>plankY2) || (catX+20<=plankX1 || catX>=plankX2) ||(catY+52>355)) {
                System.out.println(" CatY+32 "+ (catY+32)+" PlankY1 "+(plankY1));
                game = false;
            }
            if((catY+32>plankY1 || catY+32<plankY2) || (catX+20>=plankX1 || catX<=plankX2)) {
                 cat.setLocation(plankX+30, catY);
            }

        }

//        else{
//
//            game=false;
//        }

    }

    public void getImage(){
        Front = new ImageIcon("src/main/Char/Front.png");
        Back = new ImageIcon("src/main/Char/Back.png");
        Left = new ImageIcon("src/main/Char/Left.png");
        Right = new ImageIcon("src/main/Char/Right.png");
        Plank = new ImageIcon("src/main/Char/Plank.png");
        River = new ImageIcon("src/main/Char/Background.png");
        L = new ImageIcon("src/main/gifs/L.gif");
        R = new ImageIcon("src/main/gifs/R.gif");
        F = new ImageIcon("src/main/gifs/F.gif");
        B = new ImageIcon("src/main/gifs/B.gif");

    }


}

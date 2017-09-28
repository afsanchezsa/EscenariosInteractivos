/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javafx.scene.shape.Shape;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel  implements ActionListener {

    private final int INITIAL_X = -40;
    private final int INITIAL_Y = -40;
    private final int DELAY = 25;
    private int  xref=5;

    private Timer timer;
    private int x, y;

    public Board() {
        initBoard();
    }

    private void initBoard() {
        setBackground(Color.WHITE);
       addKeyListener(new TAdapter());
       setFocusable(true);
        x = INITIAL_X;
        y = INITIAL_Y;
        //Fires one or more ActionEvents at specified intervals.
        timer = new Timer(DELAY, this);
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
       for(int i=0;i<(122*8);i+=122){
    g.drawRect(i,300,112,68);
    
    } 
         for(int i=0;i<(22*56);i+=22){
    
      g.drawImage(loadImage("blue_background.png"),i,0,this);
    } 
      
          for(int i=0;i<(22*56);i+=122){
    
      g.drawImage(loadImage("ground_loop.png"),i,700,this);
      g.drawImage(loadImage("ground_single.png"),i+122,700,this);
    }  
           g.setColor(Color.blue);
        g.fillRect(xref,40,50,20);
        //  g.drawOval(Circle.getx().Circle.getY(),)
        
    }
public Image loadImage(String imageName){
    ImageIcon ii=new ImageIcon(imageName);
    Image image=ii.getImage();
    return image;
    
    }


   private class TAdapter extends KeyAdapter{
        private Object circle;
        @Override
   public void keyReleased(KeyEvent e){
   //circle.keyReleased(e);
 int key=e.getKeyCode();
 if(key==KeyEvent.VK_SPACE){
     System.out.println("vk_space");//
 
 }
   
   }
        @Override
   public void keyPressed(KeyEvent e){
   int key=e.getKeyCode();
       if(key==KeyEvent.VK_SPACE){
     System.out.println("vk_space");//
 
 }
   
   }
   }
    @Override
    public void actionPerformed(ActionEvent e) {
        x += 1;
        y += 1;
       repaint();
    }
}
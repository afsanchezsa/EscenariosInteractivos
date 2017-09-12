/*
PLANTILLA BASE PARA CREACION DE ESCENARIOS.
 */
package Ejercicio0;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel implements ActionListener {
    private int xref=5;
    private int xref2=1500;
    private final int DELAY=25;
    private int xGato;
    private int numImagen;
private Timer timer;
public Board(){
timer=new Timer(this.DELAY,this);//que lanze el evento action listener sobre esta clase cada 25 milisegundos
timer.start();
this.xGato=0;
this.numImagen=0;
        

}
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
       /* g.setColor(Color.red);
        g.drawLine(0, 0, 100, 100);
        dibujarEscenario(g);
        g.setColor(Color.BLUE);
        //g.fillRect(10, 10, 30, 30);
        g.drawString("Puntaje", 50, 50);
        
        int x[]={15,15,20};
        int y[]={20,5,20};
        g.drawPolygon(x, y, 3);
        */
        //----------
        Image fondo=loadImage("fondo.png");
        g.drawImage(fondo,0,0,this);
          g.setColor(Color.blue);
        g.fillRect(xref,40,50,20);
        Rectangle carro=new Rectangle(xref,40,50,20);
        
        int xPoints[]={xref+10,xref+15,xref+40,xref+45};
        int yPoints[]={40,20,20,40};
        g.drawPolygon(xPoints, yPoints, 4);
       
       // g.fillRect(xref2,40,50,20);
        g.fillOval(xref2, 40, 20, 20);
        Rectangle oval=new Rectangle(xref2,40,20,20);
        
        g.setColor(Color.black);
        g.fillOval(xref, 60, 15, 15);
        g.fillOval(xref+30, 60, 15, 15);
        
        g.drawRect(xref,20,60,60);
        
        g.drawRect(xref2-10,40,40,30);
        Image gato=loadImage("cats.gif");
        
        g.drawImage(gato,this.xGato, 100, (this.xGato+132),(100+80) , (this.numImagen*132), 0, ((this.numImagen*132)+132), 80, this);
         g.drawImage(gato,50, 200, (20+264),(100+256) , 264, 0, 396, 80, this);
        
        if(carro.intersects(oval)){
        //this.timer.stop();
        }
        
    }

    private void dibujarEscenario(Graphics g) {
        /*Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.RED);
        //the first two parameters are the position (x,y) and after comes the width and the height
        g2d.fillOval(0, 0, 30, 30);
        g2d.drawOval(0, 50, 30, 30);
               
        g2d.fillRect(50, 0, 30, 30); 
        g2d.drawRect(50, 50, 30, 30);
        
        g2d.drawString("Puntaje del Juego", 100, 100);
        */
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       xref+=1;
       xref2-=1;
       xGato++;
       
       if(this.numImagen==6){
       this.numImagen=0;
       }else{
       this.numImagen++;
       }
       repaint();
    }
    
    public Image loadImage(String imageName){
    ImageIcon ii=new ImageIcon(imageName);
    Image image=ii.getImage();
    return image;
    
    }
}
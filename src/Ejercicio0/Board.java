/*
PLANTILLA BASE PARA CREACION DE ESCENARIOS.
 */
package Ejercicio0;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel implements ActionListener {
    private int xref=5;
    private int xref2=1500;
    private final int DELAY=25;
private Timer timer;
public Board(){
timer=new Timer(this.DELAY,this);//que lanze el evento action listener sobre esta clase cada 25 milisegundos
timer.start();


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
         
        g.drawRect(xref,40,50,20);
        int xPoints[]={xref+10,xref+15,xref+40,xref+45};
        int yPoints[]={40,20,20,40};
        g.drawPolygon(xPoints, yPoints, 4);
        g.drawRect(xref2,40,50,20);
        
        
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
       repaint();
    }
}
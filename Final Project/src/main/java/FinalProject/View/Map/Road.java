/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinalProject.View.Map;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Richard
 */
public class Road extends JPanel{
    JPanel panel;
    String type;
    
    public Road(String type){
        this.type = type;
        this.setBorder(new EmptyBorder(0, -1, 0, -1));
    }
       
    public void paintComponent(Graphics g)     
    {
        super.paintComponent(g);
        switch(type){
                case "Blank":
                    g.setColor(Color.WHITE);
                    g.fillRect(0, 0, this.getWidth(), this.getHeight());
                    break;
                
                case "Vertical":
                    g.setColor(Color.BLACK);
                    g.fillRect(5, 0, this.getWidth()-10, this.getHeight());
                    g.setColor(Color.WHITE);
                    g.drawLine(this.getWidth()/2, 0, this.getWidth()/2, this.getHeight());
                    break;
                
                case "Intersection":
                    g.setColor(Color.BLACK);
                    g.fillRect(0, 0, this.getWidth(), this.getHeight());
                    g.setColor(Color.WHITE);                    
                    g.drawLine(0, 0, this.getWidth(), 0);
                    g.drawLine(0, 0, 0, this.getHeight());
                    g.drawLine(this.getWidth(), 0, this.getWidth(), this.getHeight());
                    g.drawLine(0, this.getHeight(), this.getWidth(), this.getHeight());
                    break;
                
                case "Horizontal":
                    g.setColor(Color.BLACK);
                    g.fillRect(0, 0, this.getWidth(), this.getHeight());
                    g.setColor(Color.WHITE);
                    g.drawLine(0, this.getHeight()/2, this.getWidth(), this.getHeight()/2);
                    break;
                
                default:
                    g.setColor(Color.WHITE);
        }           
    }

}

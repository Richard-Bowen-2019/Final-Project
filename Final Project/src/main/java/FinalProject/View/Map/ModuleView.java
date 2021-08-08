/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinalProject.View.Map;

import FinalProject.View.Vehicles.VehicleViewInterface;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

/**
 *
 * @author Richard
 */
public class ModuleView extends JPanel{
    int modulex;
    int moduley;
    ArrayList<VehicleViewInterface> vehicles;
    int currentMove;
    
    public ModuleView(int x,int y)
    {
        
        this.vehicles = new ArrayList<>();
        this. modulex = x;
        this.moduley = y;
       
    }
    
    public void addVehicle(VehicleViewInterface view, int[] position)
    {
        view.setX(position[0]);
        view.setY(position[1]);
        vehicles.add(view);
        repaint();
    }
        
    @Override
    public void paintComponent(Graphics g) 
    {
        super.paintComponent(g);
        setBackground(Color.WHITE);
        g.setColor(Color.BLACK);
        g.fillRect(0,this.getHeight()/3, this.getWidth(), this.getHeight()/3);
        g.fillRect(this.getWidth()/3,0, this.getWidth()/3, this.getHeight());
        g.setColor(Color.WHITE);
        g.drawLine(0, 0, this.getWidth(), 0);
        g.drawLine(0, 0, 0, this.getHeight());
        g.drawLine(this.getWidth(), 0, this.getWidth(), this.getHeight());
        g.drawLine(0, this.getHeight(), this.getWidth(), this.getHeight());
        for(int i = 0;i<this.getWidth()/3;i = i + 15)
        {
            g.drawLine(i + 3 , this.getHeight()/2, i + 10, this.getHeight()/2);
        }
        for(int i = this.getWidth()*2/3;i<this.getWidth();i = i + 15)
        {
            g.drawLine(i + 3 , this.getHeight()/2, i + 10, this.getHeight()/2);
        }
        g.drawLine(0 , this.getHeight()/3, this.getWidth(), this.getHeight()/3);
        g.drawLine(0 , this.getHeight()*2/3, this.getWidth(), this.getHeight()*2/3);
        for(int i = 0;i<this.getHeight()/3-10;i = i + 15)
        {
            g.drawLine(this.getWidth()/2,i + 3 ,this.getWidth()/2 , i + 10);
        }
        for(int i = this.getHeight()*2/3;i<this.getHeight();i = i + 15)
        {
            g.drawLine(this.getWidth()/2,i + 3 ,this.getWidth()/2 , i + 10);
        }
        g.drawLine(this.getWidth()/3,0, this.getWidth()/3, this.getHeight());
        g.drawLine(this.getWidth()*2/3,0, this.getWidth()*2/3, this.getHeight());
       
        g.setColor(Color.BLACK);
        g.drawLine(this.getWidth()/3, 0, this.getWidth()*2/3, 0);
        g.drawLine(this.getWidth()/3, this.getHeight(), this.getWidth()*2/3, this.getHeight());
        g.drawLine(0,this.getHeight()/3, 0, this.getHeight()*2/3);
        g.drawLine(this.getWidth(),this.getHeight()/3, this.getWidth(), this.getHeight()*2/3);
        if(vehicles.size()!=0)
        {
            for(VehicleViewInterface vvi : vehicles)
            {
                vvi.paintComponent(g);
            }
        }
    }
    
    public void move(VehicleViewInterface vvi, int[] move)
    {
        vvi.setX(vvi.getX() + move[0]);
        vvi.setY(vvi.getY() + move[1]);
        repaint();
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinalProject.View.Map;

import FinalProject.Resources.GlobalVariables;
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
    int moduleHeight;
    int moduleWidth;
    int widthNumber;
    int heightNumber;
    ArrayList<VehicleViewInterface> vehicles;
    int currentMove;
    
    public void addVehicle(VehicleViewInterface view, double[] startingPosition)
    {
        view.setX((int)startingPosition[0]);
        view.setY((int)startingPosition[1]);
        vehicles.add(view);
        repaint();
    }
    
    public void removeVehicle(VehicleViewInterface view)
    {
        vehicles.remove(view);
        repaint();
    }
    
    public ModuleView()
    {
        this.moduleHeight = GlobalVariables.getModuleHeights();
        this.moduleWidth = GlobalVariables.getModuleWidths();
        this.heightNumber = GlobalVariables.getVerticalModules();
        this.widthNumber = GlobalVariables.getHorizontalModules();
        vehicles = new ArrayList<>();
    }
    
    @Override
    public void paintComponent(Graphics g) 
    {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        //horizontal roads
        for(int i = 0;i<heightNumber;i++)
        {
            g.fillRect(0,this.moduleHeight/3 + this.moduleHeight*i, this.getWidth(), this.moduleHeight/3);
        }
        //Vertical roads
        for(int i = 0;i<widthNumber;i++)
        {
            g.fillRect(this.moduleWidth/3 + this.moduleWidth*i,0,this.moduleWidth/3,this.getHeight());
        }
        //Horizontal lines
        g.setColor(Color.WHITE);
        for(int i = 0;i<heightNumber;i++)
        {
            g.drawLine(0, this.moduleHeight/3+ this.moduleHeight*i, this.getWidth(), this.moduleHeight/3+ this.moduleHeight*i);
            g.drawLine(0, this.moduleHeight*2/3 + this.moduleHeight*i, this.getWidth(), this.moduleHeight*2/3 + this.moduleHeight*i);
        }
        //Vertical lines
        for(int i = 0;i<30;i++)
        {
            g.drawLine(this.moduleWidth/3+this.moduleWidth*i, 0, this.moduleWidth/3+this.moduleWidth*i, this.getHeight());
            g.drawLine(this.moduleWidth*2/3+this.moduleWidth*i, 0, this.moduleWidth*2/3+this.moduleWidth*i, this.getHeight());
        }
        
        //Horizontal roadlines
        for(int k=0;k<heightNumber;k++)
        {
            for(int j = 0;j<widthNumber*3;j++)
            {
               if((j-1)%3!=0)
               {
                    for(int i = this.getWidth()*j/30;i<this.getWidth()*(j+1)/30;i=i+15)
                    {
                        g.drawLine(i + 3,this.moduleHeight/2 + this.moduleHeight*k,i + 8,this.moduleHeight/2 + this.moduleHeight*k);
                    }
               }   
            }
        }
        
        
        //Vertical roadlines
        for(int k = 0;k<widthNumber;k++)
        {
            for(int j = 0;j<heightNumber*3;j++)
            {
               if((j-1)%3!=0)
               {
                    for(int i = this.getHeight()*j/18+4*j;i<this.getHeight()*(j+1)/18+4*j;i=i+15)
                    {
                        g.drawLine(this.moduleWidth/2 + this.moduleWidth*k,i + 3,this.moduleWidth/2 + this.moduleWidth*k,i+8);
                    }
               }   
            }
        }
        
        for(VehicleViewInterface vvi : vehicles)
        {
            vvi.paintComponent(g);
        }
        
    }
    
    public ArrayList<VehicleViewInterface> getVehicles() 
    {
        return vehicles;
    }
    
    public void move(VehicleViewInterface vvi, double[] move)
    {
        vvi.setX(vvi.getX() + (int) move[0]);
        vvi.setY(vvi.getY() + (int) move[1]);
        repaint();
    }
}

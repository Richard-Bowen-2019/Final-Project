/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinalProject.View.Map;

import FinalProject.GlobalVariables;
import FinalProject.View.Vehicles.VehicleView;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import FinalProject.View.Vehicles.VehicleViewInterface;

/**
 *
 * @author Richard
 */
public class HorizontalRoadView extends JPanel implements RoadViewInterface{
    String label;
    ArrayList<VehicleViewInterface> vehicles;
    
    public HorizontalRoadView()
    {
        this.vehicles = new ArrayList<>();
    }
    
    
    
    public void addVehicle(VehicleViewInterface view)
    {
        vehicles.add(view);
        repaint();
    }
    
    @Override
    public void paintComponent(Graphics g)     
    {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        g.setColor(Color.WHITE);                    
        g.drawLine(0, 0, this.getWidth(), 0);
        g.drawLine(0, 0, 0, this.getHeight());
        g.drawLine(this.getWidth(), 0, this.getWidth(), this.getHeight());
        g.drawLine(0, this.getHeight(), this.getWidth(), this.getHeight());
        for(int i = 0;i<this.getWidth();i = i + 15)
        {
            g.drawLine(i + 3 , this.getHeight()/2, i + 10, this.getHeight()/2);
        }
       if(vehicles.size()!=0)
        {
            for(VehicleViewInterface vvi : vehicles)
            {
                vvi.paintMe(g);
            }
        }
    }
    
    @Override
    public void stepLeft() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void stepRight() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void stepUp(VehicleViewInterface vvi)
    {
        vvi.setY(vvi.getY()+ GlobalVariables.getModuleHeights()/10);
        repaint();
    }

    @Override
    public void stepDown(VehicleViewInterface vvi) {
        vvi.setY(vvi.getY()- GlobalVariables.getModuleHeights()/10);
        repaint();}

    @Override
    public void step(int[] position) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}

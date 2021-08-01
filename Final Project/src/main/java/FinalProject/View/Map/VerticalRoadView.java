/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinalProject.View.Map;

import FinalProject.GlobalVariables;
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
public class VerticalRoadView extends JPanel implements RoadViewInterface{
    ArrayList<VehicleViewInterface> vehicles;
    
    public VerticalRoadView(){
        this.vehicles = new ArrayList<>();
        this.setBorder(new EmptyBorder(10, 10, 10, 10));
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        g.setColor(Color.WHITE);                    
        g.drawLine(0, 0, this.getWidth(), 0);
        g.drawLine(0, 0, 0, this.getHeight());
        g.drawLine(this.getWidth(), 0, this.getWidth(), this.getHeight());
        g.drawLine(0, this.getHeight(), this.getWidth(), this.getHeight());
        for(int i = 0;i<this.getHeight();i=i+15)
        {
            g.drawLine(this.getWidth()/2, i + 3, this.getWidth()/2, i + 10 );
        }
        if(vehicles.size()!=0)
        {
            for(VehicleViewInterface vvi : vehicles)
            {
                System.out.println("paintvehicle");
                vvi.paintMe(g);
            }
        }
    }
    @Override
    public void addVehicle(VehicleViewInterface view) 
    {
        vehicles.add(view);
        repaint();
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
    public void step(int[] position) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void stepUp(VehicleViewInterface view) {
        view.setX(view.getX()+ GlobalVariables.getModuleWidths()/10);
        repaint();
    }

    @Override
    public void stepDown(VehicleViewInterface view) 
    {
        view.setX(view.getX()+ GlobalVariables.getModuleWidths()/10);
        repaint();
    }


    
}

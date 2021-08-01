/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinalProject.View.Map;

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
public class Blank extends JPanel implements RoadViewInterface{
    
    ArrayList<VehicleViewInterface> vehicles;
    
    public Blank()
    {
        this.vehicles = new ArrayList<>();
        this.setBorder(new EmptyBorder(0, -1, 0, -1));
    }

    @Override
    public void addVehicle(VehicleViewInterface view) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
    @Override
    public void paintComponent(Graphics g)     
    {
        super.paintComponent(g);
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        g.setColor(Color.WHITE);                    
        g.drawLine(0, 0, this.getWidth(), 0);
        g.drawLine(0, 0, 0, this.getHeight());
        g.drawLine(this.getWidth(), 0, this.getWidth(), this.getHeight());
        g.drawLine(0, this.getHeight(), this.getWidth(), this.getHeight());
    }

    @Override
    public void step(int[] position) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    public void stepUp(VehicleViewInterface vvi) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void stepDown(VehicleViewInterface vvi) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}


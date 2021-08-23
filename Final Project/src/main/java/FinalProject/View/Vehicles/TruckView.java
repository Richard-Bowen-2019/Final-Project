/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinalProject.View.Vehicles;

import FinalProject.Model.Map.RoadModel;
import java.awt.Graphics;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Richard
 */
public class TruckView extends VehicleView implements VehicleViewInterface{
    String[] imageList = {"\\truck1.png","\\truck2.png"};

    public TruckView(String direction) throws IOException    
    {
            images = new ArrayList<>();
            addImages(imageList);
            this.vehicleImage = getVehicle(direction);
    }
    
    @Override
    public void paintComponent(Graphics g) 
    {
        g.drawImage(vehicleImage,x,y,null);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinalProject.View.Vehicles;


import java.awt.Graphics;
import java.io.IOException;
import java.util.ArrayList;


/**
 *
 * @author Richard
 */
public class CarView extends VehicleView implements VehicleViewInterface
{
    String[] imageList = {"\\Car1.png","\\Car2.png","\\Car3.png","\\Car4.png", "\\taxi1.png"};
    
    public CarView(String direction) throws IOException
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


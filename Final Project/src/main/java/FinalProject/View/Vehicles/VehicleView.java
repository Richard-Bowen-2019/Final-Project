/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinalProject.View.Vehicles;

import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.util.ArrayList;

/**
 *
 * @author Richard
 */
public abstract class VehicleView implements VehicleViewInterface {
    protected ImageObserver observer;
    protected ArrayList<BufferedImage> vehicles;
    int x;
    int y;
    String path = "C:\\Users\\Richard.Richard-PC\\Documents\\NetBeansProjects\\SoftwareEngineering\\Final Project\\src\\main\\java\\FinalProject\\View\\images\\Car1.png";
   
    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    
    public int getY() {
        return y;
}
    
}


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinalProject.View.Vehicles;

import FinalProject.Resources.GlobalVariables;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author Richard
 */
public abstract class VehicleView implements VehicleViewInterface {
    protected ImageObserver observer;
    protected ArrayList<BufferedImage> vehicles;
    int x;
    int y;
    String path = new File("src\\main\\java\\FinalProject\\Resources\\Images").getAbsolutePath();
    ArrayList<String> images;
    BufferedImage vehicleImageOriginal;
    BufferedImage vehicleImage;
    int width = GlobalVariables.getModuleWidths();
    int height = GlobalVariables.getModuleHeights();
    
    protected BufferedImage getVehicle(String direction) throws IOException 
    {
        File file = new File(images.get(randomVehicle()));
        vehicleImageOriginal = ImageIO.read(file);
        vehicleImage = ImageIO.read(file);
        vehicleDirection(direction);
        vehicleImage = resizeImage();
        return vehicleImage;
    }
    
    public VehicleViewInterface realign(String direction)
    {
        this.vehicleImage = vehicleImageOriginal;
        this.vehicleDirection(direction);
        try 
        {
            vehicleImage = resizeImage();
        } catch (IOException ex) 
        {
            Logger.getLogger(VehicleView.class.getName()).log(Level.SEVERE, null, ex);
        }
        return this;
    }
    
    protected void vehicleDirection(String direction)
    {
        switch(direction)
        {
            case "North":
                vehicleImage = rotate(180);
                this.x = width/7;
                this.y = 0;
                break;
            case "East":
                vehicleImage = rotate(270);
                this.x = width/7;
                this.y = height/7;
                break;
            case "West":
                vehicleImage = rotate(90);
                this.x = 0;
                this.y = -height/48;
                break;
            default:
                this.x = -1;
                this.y = 100;
                break;        
        }
    }
    
    protected BufferedImage rotate(int degrees)
    {
        double rotation = Math.toRadians (degrees);
        double X = vehicleImage.getWidth() / 2;
        double Y = vehicleImage.getHeight() / 2;
        AffineTransform transform = AffineTransform.getRotateInstance(rotation, X, Y);
        AffineTransformOp op = new AffineTransformOp(transform, AffineTransformOp.TYPE_BILINEAR);
        return op.filter(vehicleImage, null);    
    }
    
    protected BufferedImage resizeImage() throws IOException 
    {
        int newX = width/5;
        int newY = height/5;
        Image scaledCarImage = vehicleImage.getScaledInstance(newX, newY, Image.SCALE_DEFAULT);
        BufferedImage newCarImage = new BufferedImage(newX, newY, BufferedImage.TYPE_INT_ARGB);
        newCarImage.getGraphics().drawImage(scaledCarImage, 0, 0, null);
        return newCarImage;
    }
    
    protected void addImages(String[] imageList)
    {
        for(String s : imageList)
        {
            images.add(path.concat(s));
        }
    }
    
    private int randomVehicle()
    {
        return (int)(Math.random()*images.size());
    }
    
    public void setX(int newX) {
        this.x = newX;
    }

    public void setY(int newY) {
        this.y = newY;
    }

    public int getX() {
        return this.x;
    }

    
    public int getY() {
        return this.y;
}
    
}


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinalProject.View.Vehicles;

import FinalProject.GlobalVariables;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import javax.imageio.ImageIO;

/**
 *
 * @author Richard
 */
public class CarView extends VehicleView implements VehicleViewInterface
{
    ArrayList<String> images;
    BufferedImage carImage;
    int width = GlobalVariables.getModuleWidths();
    int height = GlobalVariables.getModuleHeights();
            
    public CarView(String direction) throws IOException
    {
        images = new ArrayList<>();
        addImages();
        
        getCar(direction);
    }
    
    private void getCar(String direction) throws IOException 
    {
        File file = new File(path);
        carImage = ImageIO.read(file);
        switch(direction)
        {
            case "North":
                carImage = rotate(180);
                this.x = width/7;
                this.y = 0;
                break;
            case "East":
                carImage = rotate(270);
                this.x = width;
                this.y = height/7;
                break;
            case "West":
                carImage = rotate(90);
                this.x = 0;
                this.y = -height/48;
                break;
            default:
                this.x = -1;
                this.y = height/10;
                break;        
                
        }
        carImage = resizeImage();
    }
    
    private BufferedImage rotate(int degrees)
    {
        double rotation = Math.toRadians (degrees);
        double X = carImage.getWidth() / 2;
        double Y = carImage.getHeight() / 2;
        AffineTransform transform = AffineTransform.getRotateInstance(rotation, X, Y);
        AffineTransformOp op = new AffineTransformOp(transform, AffineTransformOp.TYPE_BILINEAR);
        return op.filter(carImage, null);    
    }
    
    private BufferedImage resizeImage() throws IOException 
    {
        int newX = width/5;
        int newY = height/5;
        Image scaledCarImage = carImage.getScaledInstance(newX, newY, Image.SCALE_DEFAULT);
        BufferedImage newCarImage = new BufferedImage(newX, newY, BufferedImage.TYPE_INT_ARGB);
        newCarImage.getGraphics().drawImage(scaledCarImage, 0, 0, null);
        return newCarImage;
    }
    
    private void addImages()
    {
        images.add("c:images/Car1.png");
        images.add("images/Car2.png");
        images.add("images/Car3.png");
        images.add("images/Car4.png");
    }
    
    private int randomCar()
    {
        return (int)(Math.random()*images.size());
    }
    
    @Override
    public void paintMe(Graphics g)
    {
        System.out.println(x + ":" + y);
        g.drawImage(carImage,x,y,null);
    }

}


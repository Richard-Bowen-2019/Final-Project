/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinalProject.Resources;

import FinalProject.Model.Map.TrafficMapModel;
import FinalProject.Model.Vehicles.VehicleModel;
import FinalProject.View.Map.TrafficMapView;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 *
 * @author Richard
 */
public class GV {
    static final int seedRate = 5;
    static final int horizontalModules = 10;
    static final int verticalModules = 6;
    private TrafficMapModel model;
    private TrafficMapView view;

    private GV()
    {
         
    }
    
    public static int getSeedRate() 
    {
        return seedRate;
    }
    
    public static Dimension getScreenSize(){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        return screenSize;
    }
    
    public static int getHorizontalModules() {
        return horizontalModules;
    }

    public static int getVerticalModules() {
        return verticalModules;
    }
    
    public static int getModuleWidths() {
        return getScreenSize().width/getHorizontalModules();
    }
    
     public static int getModuleHeights() {
        return getScreenSize().height/getVerticalModules();
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinalProject;

import FinalProject.Controller.MainController;
import FinalProject.Model.Map.TrafficMapModel;
import FinalProject.Resources.GV;
import FinalProject.View.Map.TrafficMapView;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Richard
 */
public class Main {
    static MainController controller;
    static TrafficMapModel mapModel;
    static TrafficMapView mapView;
    static TrafficMapModel traffic;
    
    public static void main(String[] args) throws InterruptedException  
    {
        mapModel = TrafficMapModel.getMapInstance();
        mapView = TrafficMapView.getInstance();
        TimeUnit.SECONDS.sleep(2);
        ControllerThread cThread = new ControllerThread();
        cThread.start();
    }
    
    private static class ControllerThread extends Thread 
    {
        public void run()
        {
            try 
            {
                controller.getControllerInstance();
            } 
            catch (InterruptedException ex) 
            {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}


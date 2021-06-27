/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinalProject;

import FinalProject.Controller.SimulationClock;
import FinalProject.Model.Map.Routes.Routeloader;
import FinalProject.Model.Map.TrafficMapModel;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Richard
 */
public class StartSimulation{ 
    public StartSimulation() throws InterruptedException
    {
        ModelThread mthread = new ModelThread();
        mthread.start();
        ClockThread cthread = new ClockThread();
        cthread.start();
        //RouteThread rthread = new RouteThread();
        //rthread.start();
    }

    class ClockThread extends Thread{
        SimulationClock clockStart;
        @Override
        public void run() {
            try {
                clockStart = SimulationClock.getClockInstance();
            } catch (InterruptedException ex) {
                Logger.getLogger(ClockThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }    
    
    class ModelThread extends Thread{
        TrafficMapModel model;
        @Override
        public void run() {
            try {
                model = TrafficMapModel.getMapInstance();
            } catch (InterruptedException ex) {
                Logger.getLogger(ModelThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }    
    class RouteThread extends Thread{
        Routeloader loader;
        @Override
        public void run() {
            try {
                loader = Routeloader.getRouteInstance();
            } catch (InterruptedException ex) {
                Logger.getLogger(RouteThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
    
    

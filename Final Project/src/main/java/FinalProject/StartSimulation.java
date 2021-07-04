/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinalProject;

import FinalProject.Controller.SimulationClock;

import FinalProject.Model.Map.TrafficMapModel;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Richard
 */
public class StartSimulation{
    SimulationClock clockStart;
    TrafficMapModel model;
    
    public StartSimulation() throws InterruptedException
    {
        ModelThread mthread = new ModelThread();
        mthread.start();
        TimeUnit.SECONDS.sleep(5);    
        ClockThread cthread = new ClockThread();
        cthread.start();
    }

    class ClockThread extends Thread{
        
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
        
        @Override
        public void run() {
            try {
                model = TrafficMapModel.getMapInstance();
            } catch (InterruptedException ex) {
                Logger.getLogger(ModelThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }    
   
}
    
    

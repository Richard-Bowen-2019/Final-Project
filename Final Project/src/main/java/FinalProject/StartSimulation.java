/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinalProject;

import FinalProject.Controller.SimulationClock;

import FinalProject.Model.Map.TrafficMapModel;
import FinalProject.View.Map.TrafficMapView;
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
    TrafficMapView map;
    
    public StartSimulation() throws InterruptedException
    {
        model = TrafficMapModel.getMapInstance();
        map = new TrafficMapView();
        TimeUnit.SECONDS.sleep(5);    
        clockStart = SimulationClock.getClockInstance();
    }
}
    
    

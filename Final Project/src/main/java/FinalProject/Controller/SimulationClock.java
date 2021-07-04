/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinalProject.Controller;


import FinalProject.Controller.Vehicle.VehicleController;
import FinalProject.Model.Map.TrafficMapModel;
import java.awt.List;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;





/**
 *
 * @author Richard
 */
public class SimulationClock {
    private static SimulationClock clock;
    
    int n=0;
   
    private SimulationClock() throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
        
        VehicleController controller = new VehicleController();
        controller.seedVehicle(1);
        
    }
    
    public static SimulationClock getClockInstance() throws InterruptedException {
        if(clock==null)
        {
            clock = new SimulationClock();
        }
        return clock;
    }
    
   
   } 	
    



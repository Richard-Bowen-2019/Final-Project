/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinalProject.Controller.Vehicle;

import FinalProject.Model.Map.TrafficMapModel;
import java.util.Random;

/**
 *
 * @author Richard
 */
public class VehicleController {
    private int seedRate;
    TrafficMapModel tmp;
    
    public VehicleController(){
        seedRate = 1;
    }
    
    public void setSeedRate(int seedRate) throws InterruptedException {
        this.seedRate = seedRate;
        this.tmp = TrafficMapModel.getMapInstance();
    }

    public int getSeedRate() {
        return seedRate;
    }
    
    public void seedVehicle(){
        int startPoint = randomNode(0,tmp.getEntryNodes().size()-1);
        int endPoint = randomNode(0,tmp.getExitNodes().size()-1);
    }
    
    public int randomNode(int start,int end)
    {
    int r = start + (int)Math.random()*(end-start+1);
    return r;
    }
    
}

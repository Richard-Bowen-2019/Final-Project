




/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinalProject.Model.Vehicles;

import FinalProject.Controller.Vehicle.CarController;
import FinalProject.Controller.Vehicle.MapController;
import FinalProject.Controller.Vehicle.TruckController;
import FinalProject.Controller.Vehicle.VehicleController;
import FinalProject.Model.Map.VertexModel;
import FinalProject.View.Vehicles.CarView;
import java.util.List;

/**
 *
 * @author Richard
 */
public class TruckModel extends VehicleModel{
    
    public TruckModel(List<VertexModel> route) throws InterruptedException
    {
        this.size = 3;
        controller = new VehicleController(new TruckController(route, this));
        
    }
}

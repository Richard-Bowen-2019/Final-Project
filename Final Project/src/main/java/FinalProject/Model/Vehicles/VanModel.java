


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinalProject.Model.Vehicles;


import FinalProject.Controller.Vehicle.VanController;
import FinalProject.Controller.Vehicle.VehicleController;
import FinalProject.Model.Map.VertexModel;
import FinalProject.View.Vehicles.VanView;
import java.util.List;
/**
 *
 * @author Richard
 */
public class VanModel extends VehicleModel{
    
    public VanModel(List<VertexModel> route) throws InterruptedException
    {
        this.vehicleNumber = vehicleNumber++;
        this.size = 1;
        controller = new VehicleController(new VanController(route, this));
        //view = new VanView();
        this.size = 2;
    }

    
    
    
    
}

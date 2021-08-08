/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinalProject.Controller.VehicleController.VehicleControllers;

import FinalProject.Controller.iController;
import FinalProject.Model.Map.VertexModel;
import FinalProject.Model.Vehicles.CarModel;
import FinalProject.View.Vehicles.EmergencyVehicleView;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author Richard
 */
public class EmergencyVehicleModelController extends VehicleModelController implements iController{

    
    public EmergencyVehicleModelController(List<VertexModel> route) throws IOException, InterruptedException
    {
        this.route = route;
        this.currentVehicle = new CarModel();
        this.vehicleViewController = new EmergencyVehicleViewController(route.get(0),route.get(1));
        setUpFirst();
    }
   
    @Override
    public void EmergencyVehicle() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinalProject.Controller.VehicleController.VehicleControllers;

import FinalProject.Model.Map.VertexModel;
import FinalProject.Model.Vehicles.EmergencyVehicleModel;
import FinalProject.View.Vehicles.CarView;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author Richard
 */
public class EmergencyVehicleModelController extends VehicleController implements ControllerInterface{

    public EmergencyVehicleModelController(List<VertexModel> route) throws IOException, InterruptedException
    {
        super();
        this.route = route;
        this.vehicleModel = new EmergencyVehicleModel();
        this.vehicleViewInterface = new CarView(route.get(0).getLabel());
        setUpFirst();
    }
   
    @Override
    public void EmergencyVehicle() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

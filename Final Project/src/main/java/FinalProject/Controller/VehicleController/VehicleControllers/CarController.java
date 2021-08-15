/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinalProject.Controller.VehicleController.VehicleControllers;

import FinalProject.Model.Map.VertexModel;
import FinalProject.Model.Vehicles.CarModel;
import FinalProject.View.Vehicles.CarView;
import java.io.IOException;
import java.util.List;



/**
 *
 * @author Richard
 */
public class CarController extends VehicleController implements ControllerInterface {
    
    public CarController(List<VertexModel> route)throws InterruptedException, IOException
    {
        super();
        this.route = route;
        this.vehicleModel = new CarModel();
        this.vehicleViewInterface = new CarView(route.get(0).getLabel());
        setUpFirst();
    }

    @Override
    public void EmergencyVehicle() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

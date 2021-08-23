/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinalProject.Controller.VehicleController.VehicleControllers;

import FinalProject.Model.Map.VertexModel;
import FinalProject.Model.Vehicles.TruckModel;
import FinalProject.View.Vehicles.TruckView;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author Richard
 */
public class TruckModelController extends VehicleController implements ControllerInterface{
    
    public TruckModelController(List<VertexModel> route)throws InterruptedException, IOException
    {
        super();
        this.route = route;
        this.vehicleModel = new TruckModel();
        this.vehicleViewInterface = new TruckView(route.get(0).getLabel());
        setUpFirst();
    }

    @Override
    public void EmergencyVehicle() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

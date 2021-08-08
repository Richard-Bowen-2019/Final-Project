/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinalProject.Controller.VehicleController.VehicleControllers;

import FinalProject.Controller.iController;
import FinalProject.Controller.MainController;
import FinalProject.Model.Map.RoadModel;
import FinalProject.Model.Map.VertexModel;
import FinalProject.Model.Vehicles.TruckModel;
import FinalProject.Model.Vehicles.VehicleModel;
import FinalProject.View.Vehicles.TruckView;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author Richard
 */
public class TruckModelController extends VehicleModelController implements iController{
    
    public TruckModelController(List<VertexModel> route)throws InterruptedException, IOException
    {
        this.route = route;
        this.currentVehicle = new TruckModel();
        this.vehicleViewController = new TruckViewController(route.get(0),route.get(1));
        this.setUpFirst();
    }

    @Override
    public void EmergencyVehicle() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

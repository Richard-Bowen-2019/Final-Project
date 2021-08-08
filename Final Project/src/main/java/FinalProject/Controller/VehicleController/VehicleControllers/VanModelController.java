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
import FinalProject.Model.Vehicles.VanModel;
import FinalProject.Model.Vehicles.VehicleModel;
import FinalProject.View.Vehicles.VanView;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author Richard
 */
public class VanModelController extends VehicleModelController implements iController{
    
    public VanModelController(List<VertexModel> route)throws InterruptedException, IOException
    {
        this.route = route;
        this.currentVehicle = new VanModel();
        this.vehicleViewController = new VanViewController(route.get(0),route.get(1));
        setUpFirst();
    }

    @Override
    public void EmergencyVehicle() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

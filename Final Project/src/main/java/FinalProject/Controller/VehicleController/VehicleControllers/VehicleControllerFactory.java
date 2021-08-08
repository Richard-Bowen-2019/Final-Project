/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinalProject.Controller.VehicleController.VehicleControllers;

import FinalProject.Model.Map.VertexModel;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

/**
 *
 * @author Richard
 */
public class VehicleControllerFactory {
    
    
    public VehicleModelController getVehicle(int r, List<VertexModel> route) throws InterruptedException, IOException, URISyntaxException
    {
        switch(r)
        {
                case 1:
                    return new CarController(route);
                case 2:
                    return new VanModelController(route);
                case 3:
                    return new TruckModelController(route);
                case 4:
                    return new EmergencyVehicleModelController(route);
                default:
                    return null;
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinalProject.Model.Vehicles;


import FinalProject.Controller.Vehicle.MapController;
import FinalProject.Controller.Vehicle.CarController;
import FinalProject.Controller.Vehicle.VehicleController;
import FinalProject.Controller.iController;
import FinalProject.Model.Map.VertexModel;
import FinalProject.View.Vehicles.CarView;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

/**
 *
 * @author Richard
 */

public class CarModel extends VehicleModel {
    
    public CarModel(List<VertexModel> route) throws InterruptedException, IOException, URISyntaxException 
    {
        this.size = 1;
        this.view = new CarView(route.get(0).getLabel());
        this.controller = new VehicleController(new CarController(route, this));
        
    }

    

    
    
    
    
    
    
    
}

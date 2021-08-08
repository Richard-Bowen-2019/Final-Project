/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinalProject.Controller.VehicleController.VehicleControllers;

import FinalProject.Controller.iController;
import FinalProject.Model.Map.VertexModel;
import FinalProject.View.Vehicles.CarView;
import FinalProject.View.Vehicles.VehicleViewInterface;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author Richard
 */
public class CarViewController extends VehicleViewController implements iController {
    
    public CarViewController() throws IOException, InterruptedException
    {
        super();
        this.vehicleView = new CarView(currentVertex.getLabel());
    }
}
}

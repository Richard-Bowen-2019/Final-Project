/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinalProject.Controller.Vehicle;

import FinalProject.Controller.iController;
import FinalProject.Model.Map.VertexModel;
import FinalProject.Model.Vehicles.VehicleModel;
import java.util.List;

/**
 *
 * @author Richard
 */
public class VanController extends aVehicle implements iController{
    
    public VanController(List<VertexModel> route, VehicleModel current)throws InterruptedException
    {
        this.route = route;
        this.currentVehicle = current;
    }

    public void seedVehicle(List<VertexModel> aStar) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void move() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

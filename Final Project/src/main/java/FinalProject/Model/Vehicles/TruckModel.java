




/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinalProject.Model.Vehicles;


import FinalProject.Controller.VehicleController.VehicleControllers.TruckModelController;
import FinalProject.Model.Map.VertexModel;
import FinalProject.Resources.GV;
import java.util.List;

/**
 *
 * @author Richard
 */
public class TruckModel extends VehicleModel{
    
    public TruckModel() 
    {
        this.size = 3;
        this.speed = GV.getModuleHeights()/30;
    }
}

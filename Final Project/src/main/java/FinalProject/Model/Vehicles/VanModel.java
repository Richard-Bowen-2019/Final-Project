


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinalProject.Model.Vehicles;


import FinalProject.Controller.VehicleController.VehicleControllers.VanModelController;
import FinalProject.Model.Map.VertexModel;
import FinalProject.Resources.GV;
import FinalProject.View.Vehicles.VanView;
import java.util.List;
/**
 *
 * @author Richard
 */
public class VanModel extends VehicleModel{
    
    public VanModel() 
    {
        this.size = 2;
        this.speed = GV.getModuleHeights()/30;
    }

    
    
    
    
}

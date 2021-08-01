/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinalProject.Controller.Vehicle;

import FinalProject.Controller.Controller;
import FinalProject.Controller.iController;
import FinalProject.Model.Map.RoadModel;
import FinalProject.Model.Map.VertexModel;
import FinalProject.Model.Vehicles.VehicleModel;
import java.util.Iterator;
import java.util.List;


/**
 *
 * @author Richard
 */
public class VehicleController   
{
    private iController controller;
    
    public VehicleController(iController controller)
    {
         this.controller = controller;
    }
   
    public void moveVehicle()
    {
        controller.move();
    }
}

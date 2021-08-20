


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinalProject.Model.Vehicles;


import FinalProject.Resources.GlobalVariables;
/**
 *
 * @author Richard
 */
public class VanModel extends VehicleModel{
    
    public VanModel() 
    {
        this.size = 2;
        this.speed = GlobalVariables.getModuleHeights()/30;
    }

    
    
    
    
}

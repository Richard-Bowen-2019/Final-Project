/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinalProject.Model.Vehicles;

import FinalProject.Model.Map.VertexModel;
import java.util.List;

/**
 *
 * @author Richard
 */
public class VehicleFactory {
    
    
    public VehicleModel getVehicle(int r, List<VertexModel> route) throws InterruptedException
    {
        switch(r)
        {
                case 1:
                    return new CarModel(route);
                case 2:
                    return new VanModel(route);
                case 3:
                    return new TruckModel(route);
                default:
                    return null;
        }
    }
}

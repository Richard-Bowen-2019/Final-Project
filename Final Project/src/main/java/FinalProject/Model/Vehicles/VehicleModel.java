/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinalProject.Model.Vehicles;

import FinalProject.Controller.Controller;
import FinalProject.Controller.Vehicle.MapController;
import FinalProject.Controller.Vehicle.VehicleController;
import FinalProject.Controller.iController;
import FinalProject.Model.Map.VertexModel;
import FinalProject.View.Vehicles.VehicleView;
import java.util.List;
import FinalProject.View.Vehicles.VehicleViewInterface;

/**
 *
 * @author Richard
 */
public abstract class VehicleModel {
    protected int size;
    protected VehicleViewInterface view;
    protected VehicleController controller;
    protected int vehicleNumber;
    
    public VehicleViewInterface getView() 
    {
        return view;
    }
    
    public VehicleController getController() 
    {
        return controller;
    }
    
    public int getVehicleNumber() {
        return vehicleNumber;
    }
    
    public int getSize() {
        return size;
    }
 }


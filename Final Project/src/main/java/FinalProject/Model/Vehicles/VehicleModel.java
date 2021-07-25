/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinalProject.Model.Vehicles;

import FinalProject.Controller.Controller;
import FinalProject.Controller.Map.MapController;
import FinalProject.Controller.Vehicle.VehicleController;
import FinalProject.Controller.iController;
import FinalProject.Model.Map.VertexModel;
import FinalProject.View.Vehicles.VehicleView;
import java.util.List;

/**
 *
 * @author Richard
 */
public abstract class VehicleModel {
    protected int size;
    protected VehicleView view;
    protected VehicleController controller;
    protected MapController mController;
    
    public VehicleView getView() 
    {
        return view;
    }
    
    public VehicleController getController() 
    {
        return controller;
    }
    
    public void setSize(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }
 }


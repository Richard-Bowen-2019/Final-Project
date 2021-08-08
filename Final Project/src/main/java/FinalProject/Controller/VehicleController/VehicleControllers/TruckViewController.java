/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinalProject.Controller.VehicleController.VehicleControllers;

import FinalProject.Controller.iController;
import FinalProject.Model.Map.VertexModel;
import FinalProject.View.Vehicles.CarView;
import FinalProject.View.Vehicles.TruckView;
import java.io.IOException;

/**
 *
 * @author Richard
 */
public class TruckViewController extends VehicleViewController implements iController{
    public TruckViewController(VertexModel current, VertexModel next) throws IOException, InterruptedException
    {
        super();
        this.currentVertex = current;
        this.nextVertex = next;
        this.vehicleView = new TruckView(current.getLabel());
        this.initialPosition = positions.get(current.getLabel() +"-"+ current.getType());
        vehicleView.setX(initialPosition[0]);
        vehicleView.setX(initialPosition[1]);
        this.moduleView = mapView.getModule(currentVertex.getPosition());
    }
}

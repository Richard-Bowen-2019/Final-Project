/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinalProject.Controller.Vehicle;

import FinalProject.Controller.Controller;
import FinalProject.Model.Map.RoadModel;
import FinalProject.Model.Map.TrafficMapModel;
import FinalProject.Model.Map.VertexModel;
import FinalProject.Model.Vehicles.VehicleModel;
import FinalProject.View.Map.RoadViewInterface;
import FinalProject.View.Map.TrafficMapView;
import FinalProject.View.Vehicles.VehicleViewInterface;
import java.util.List;

/**
 *
 * @author Richard
 */
public abstract class aVehicle {
    
    RoadViewInterface rvi;
    VehicleViewInterface vehicleView;
    TrafficMapView mapView;
    TrafficMapModel model;
    
    int currentSlot;
    int currentSlotSize;
    RoadModel currentRoad;
    VertexModel currentVertex;
    VertexModel nextVertex;
    
    
    int previousSlot;
    int previousSlotSize;
    RoadModel previousRoad;
    
    int nextSlot;
    int nextSlotSize;
    RoadModel nextRoad;
    
    int vehicleNumber;
    List<VertexModel> route;
    VehicleModel currentVehicle;
    Controller mainController;

}

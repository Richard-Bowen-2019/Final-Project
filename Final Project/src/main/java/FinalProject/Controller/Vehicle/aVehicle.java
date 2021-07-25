/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinalProject.Controller.Vehicle;

import FinalProject.Controller.Controller;
import FinalProject.Controller.Map.MapController;
import FinalProject.Model.Map.RoadModel;
import FinalProject.Model.Map.VertexModel;
import FinalProject.Model.Vehicles.VehicleModel;
import java.util.List;

/**
 *
 * @author Richard
 */
public abstract class aVehicle {
    int currentSlot;
    int currentSlotSize;
    RoadModel currentRoad;
    VertexModel currentVertex;
    VertexModel nextVertex;
    List<VertexModel> route;
    VehicleModel currentVehicle;
    Controller mainController;
    MapController controller;
}

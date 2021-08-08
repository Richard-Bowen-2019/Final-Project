/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinalProject.Controller.VehicleController.VehicleControllers;

import FinalProject.Controller.MainController;
import FinalProject.Model.Map.RoadModel;
import FinalProject.Model.Map.TrafficMapModel;
import FinalProject.Model.Map.VertexModel;
import FinalProject.Model.Vehicles.VehicleModel;
import FinalProject.View.Map.ModuleView;
import FinalProject.View.Map.TrafficMapView;
import java.util.List;

/**
 *
 * @author Richard
 */
public class VehicleModelController {
    // Controllers
    MainController mainController;
    VehicleViewController vehicleViewController;
    
    //Model and view
    TrafficMapModel mapModel;
    TrafficMapView mapView;
    ModuleView moduleView;
    VehicleModel currentVehicle;
    
    // position variables
    int currentSlot;
    VertexModel currentVertex;
    VertexModel nextVertex;
    List<VertexModel> route;
    RoadModel currentRoad;
    int currentSlotSize;

    
    public VehicleModelController() throws InterruptedException
    {
        this.mainController = MainController.getControllerInstance();
        this.mapModel = TrafficMapModel.getMapInstance();
        this.mapView = TrafficMapView.getInstance();
    }
    
    public void setUpFirst()
    {
        this.currentSlot = 0;
        this.currentVertex = route.get(0);
        this.currentRoad = currentVertex.getIn();
        this.currentSlotSize = currentRoad.getSlotSize();
        this.moduleView = mapView.getModule(mapModel.getModulePositionFromVertexModel(currentVertex));
    }
    
    public void setUpNext()
    {
        if(route.size()>1)
        {
            this.currentSlot = 0;
            this.nextVertex = route.get(1);
            this.currentRoad = currentVertex.getRoad(currentVertex, nextVertex);
            this.currentSlotSize = currentRoad.getSlotSize();
            this.moduleView = mapView.getModule(mapModel.getModulePositionFromVertexModel(currentVertex));
        }
        route.remove(currentVertex);
        this.currentVertex = nextVertex;
    }
    
    public void setUpLast()
    {
        
        currentSlot = 0;
        this.currentRoad = currentVertex.getOut();
        this.currentSlotSize = currentRoad.getSlotSize();
        route.remove(currentVertex);
        this.moduleView = mapView.getModule(mapModel.getModulePositionFromVertexModel(currentVertex));
    }
    
    public void move() 
    {
        if(!mainController.vehicleListEmpty())
        {
            if(currentSlot<currentSlotSize)
            {
                if(currentSlot==0)
                {
                    currentRoad.occupySlot(0,currentVehicle);
                    currentSlot++;
                    vehicleViewController.moveView();
                }
                else
                {
                    currentRoad.occupySlot(currentSlot, currentVehicle);
                    currentRoad.vacateSlot(currentSlot-1);
                    currentSlot++;
                    vehicleViewController.moveView();
                }
            }
            else
            {
                if(route.size()==1)
                {
                    setUpLast();
                }
                else if (route.size()==0)
                {
                    
                    mainController.removeVehicle(currentVehicle);
                }
                else
                {
                    setUpNext();
                }
            }
            currentVertex.printVertex();
            System.out.println("Current position: "+ currentSlot);
        }
        else
        {
            System.out.println("No Current vehicles");
        }
    }

}

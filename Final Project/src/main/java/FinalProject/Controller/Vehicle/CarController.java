/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinalProject.Controller.Vehicle;

import FinalProject.Controller.Controller;
import FinalProject.Controller.iController;
import FinalProject.Model.Map.IntersectionModel;
import FinalProject.Model.Map.TrafficMapModel;
import FinalProject.Model.Map.VertexModel;
import FinalProject.Model.Vehicles.VehicleModel;
import FinalProject.View.Map.ModuleView;
import FinalProject.View.Map.RoadViewInterface;
import FinalProject.View.Map.TrafficMapView;
import java.util.List;

/**
 *
 * @author Richard
 */
public class CarController extends aVehicle implements iController {
    MapController controller;
    IntersectionModel module;
    ModuleView view;
   
    public CarController(List<VertexModel> route, VehicleModel current)throws InterruptedException
    {
        model=TrafficMapModel.getMapInstance();
        mapView = TrafficMapView.getInstance();
        this.route = route;
        this.currentVehicle = current;
        this.mainController = Controller.getControllerInstance();
        setUpFirst();
    }
    
    public void setUpFirst()
    {
        this.currentSlot = 0;
        this.currentVertex = route.get(0);
        this.currentRoad = currentVertex.getIn();
        this.currentSlotSize = currentRoad.getSlotSize();
        this.view = mapView.getModule(model.getModulePositionFromVertexModel(currentVertex));
        this.rvi = view.getRoad(currentVertex.getLabel());
        this.rvi.addVehicle(currentVehicle.getView());
    }
    
    public void setUpNext()
    {
        if(route.size()>1)
        {
            currentSlot = 0;
            this.nextVertex = route.get(1);
            this.currentRoad = currentVertex.getRoad(currentVertex, nextVertex);
            this.currentSlotSize = currentRoad.getSlotSize();
        }
        route.remove(currentVertex);
        currentVertex = nextVertex;
    }
    
    public void setUpLast()
    {
        currentSlot = 0;
        this.currentRoad = currentVertex.getOut();
        this.currentSlotSize = currentRoad.getSlotSize();
        route.remove(currentVertex);
    }
    
   
    @Override
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
                    controller.moveView();
                }
                else
                {
                    currentRoad.occupySlot(currentSlot, currentVehicle);
                    currentRoad.vacateSlot(currentSlot-1);
                    currentSlot++;
                    controller.moveView();
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
            System.out.print("Car Number: " + vehicleNumber);
            currentRoad.printEdge();
            System.out.println("   Slot: " + currentSlot);
        }
        else
        {
            System.out.println("No Current vehicles");
        }
    }

    
    
}

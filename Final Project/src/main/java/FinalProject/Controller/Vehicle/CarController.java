/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinalProject.Controller.Vehicle;

import FinalProject.Controller.Controller;
import FinalProject.Controller.Map.MapController;
import FinalProject.Controller.iController;
import FinalProject.Model.Map.VertexModel;
import FinalProject.Model.Vehicles.VehicleModel;
import java.util.List;

/**
 *
 * @author Richard
 */
public class CarController extends aVehicle implements iController {
    
    public CarController(List<VertexModel> route, VehicleModel current)throws InterruptedException
    {
        this.route = route;
        this.currentVehicle = current;
        this.mainController = new Controller();
        controller = new MapController(route);
        setUpFirst();
    }
    
    public void setUpFirst()
    {
        this.currentSlot = 0;
        this.currentVertex = route.get(0);
        this.currentRoad = currentVertex.getIn();
        this.currentSlotSize = currentRoad.getSlotSize();
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
        if(mainController.vehicleListEmpty())
        {
            if(currentSlot<currentSlotSize)
            {
                if(currentSlot==0)
                {
                    currentRoad.occupySlot(0,currentVehicle);
                    currentSlot++;
                }
                else
                {
                    currentRoad.occupySlot(currentSlot, currentVehicle);
                    currentRoad.vacateSlot(currentSlot-1);
                    currentSlot++;
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
            System.out.print("Vehicle Number: " + " ");
            currentRoad.printEdge();
            System.out.println("Slot: " + currentSlot);
        }
        else
        {
            System.out.println("No Current vehicles");
        }
    }

    
    
}

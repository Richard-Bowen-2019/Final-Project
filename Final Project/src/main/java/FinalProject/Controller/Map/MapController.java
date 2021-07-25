/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinalProject.Controller.Map;

import FinalProject.Controller.Controller;
import FinalProject.Controller.Vehicle.aVehicle;
import FinalProject.Controller.iController;
import FinalProject.Model.Map.VertexModel;
import java.util.List;


/**
 *
 * @author Richard
 */
public class MapController extends aVehicle implements iController
{
    public MapController(List<VertexModel> route)
    {
        //this.route = route;
        //this.currentVehicle = current;
        //this.mainController = new Controller();
    }

    @Override
    public void move() 
    {
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

    
    
  
}

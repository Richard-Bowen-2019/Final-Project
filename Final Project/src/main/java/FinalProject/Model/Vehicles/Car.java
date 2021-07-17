/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinalProject.Model.Vehicles;

import FinalProject.Controller.Map.RoutePlanner;
import FinalProject.Model.Map.Edge;
import FinalProject.Model.Map.Intersection;
import FinalProject.Model.Map.Node;
import java.util.LinkedList;

/**
 *
 * @author Richard
 */
public class Car extends Vehicle implements iVehicle{
    int size;
    int currentSlot;
    int currentSlotSize;
    Edge currentRoad;
    Node currentVertex;
    LinkedList<Node> route;
    RoutePlanner planner;
    
    public Car(LinkedList<Node> route) {
        super(route);
        this.Size = 2;
    }
    
    public void setUpFirst()
    {
        if(route.size()<2)
        {
            System.out.println("Route finished");
        }
        else
        {
        this.currentSlot = 0;
        this.currentVertex = route.getFirst();
        this.currentRoad = currentVertex.getIn();
        this.currentSlotSize = currentRoad.getSlotSize();
        }
    }
    
    public void setUpNext()
    {
        route.remove(currentVertex);
        if(route.size()!=0)
        {
            currentSlot = 0;
            this.currentVertex = route.getFirst();
            this.currentRoad = currentVertex.getRoad(currentVertex, route.get(1));
            this.currentSlotSize = currentRoad.getSlotSize();
        }
    }
    
    public void setUpLast()
    {
            currentSlot = 0;
            this.currentVertex = route.getFirst();
            this.currentRoad = currentVertex.getRoad(currentVertex, null);
            this.currentSlotSize = currentRoad.getSlotSize();
            route.remove(currentVertex);
    }
        
    @Override
    public void setSize(int n) {
        this.size = n;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void move() {
        if(currentSlot<currentSlotSize)
        {
            if(currentSlot==0){
                currentRoad.occupySlot(currentSlot);
                currentSlot++;
            }
            else
            {
                currentRoad.occupySlot(currentSlot);
                currentRoad.vacateSlot(currentSlot-1);
                currentSlot++;
            }
        }
        else
        {
            if(route.peek().getParent()==null)
            {
                System.out.println("last");
                setUpLast();
            }    
            else if(route.poll()==null)
            {
                    System.out.println("poll");
                    System.out.println("Finished");
            }
            else
            {
                    System.out.println("next");
                    setUpNext();
            }
            
        }
        if(currentRoad.getSource()!=null)
        {
            System.out.print("     Current position: Edge " + currentRoad.getSource().getLabel());
            System.out.print("-"+currentRoad.getSource().getType()+ " to ");
        }
        if(currentRoad.getDestination()!=null)
        {
        System.out.print(currentRoad.getDestination().getLabel()+"-");
        System.out.println(currentRoad.getDestination().getType()+":" + currentSlot);
        }
    }
    
    @Override
    public void startPosition(Edge r) {
        route.getFirst().getInRoads().get(0).occupySlot(1);
        
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinalProject.Controller.Vehicle;

import FinalProject.Controller.Map.RoutePlanner;
import FinalProject.Model.Map.Edge;
import FinalProject.Model.Map.TrafficMapModel;
import FinalProject.Model.Map.Node;
import FinalProject.Model.Vehicles.Car;
import FinalProject.Model.Vehicles.Vehicle;
import FinalProject.Model.Vehicles.iVehicle;
import static java.lang.Math.sqrt;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 *
 * @author Richard
 */
public class VehicleController 
{
private int seedRate;
TrafficMapModel tmp;
ArrayList<iVehicle> vehicles = new ArrayList<>();
RoutePlanner planner = new RoutePlanner();    
public VehicleController() throws InterruptedException
{
    seedRate = 1;
    tmp = TrafficMapModel.getMapInstance();
}

public void seedVehicle()
{
    Node start = startPoint();
    Node end = endPoint();
    LinkedList<Node> aStar = planner.aStar(start, end);
    for(int i=0;i<seedRate;i++)
    {
        iVehicle newVehicle = new Car(aStar);
        vehicles.add(newVehicle);
        //navigate(aStar);
    }
}

public int randomNode(int start,int end)
{
    int r = start + (int)(Math.random()*(end-start+1));
    return r;
}

public Node startPoint()
{
    
    int startPoint = randomNode(0,tmp.getEntryNodes().size()-1);
    return tmp.getEntryNodes().get(startPoint);
}

public Node endPoint()
{
    int endPoint = randomNode(0,tmp.getExitNodes().size()-1);
    return tmp.getExitNodes().get(endPoint);
}

public void navigate(List<Node> bestRoute)
{
    System.out.println("Navigate");
}
public void update()
    {
        int number = 1;
        for(iVehicle v: vehicles)
        {
            System.out.print("Car: " + number + " Moving. ");
            v.move();
            number++;
        }
    }
public void printList(List<Node> avm)
{
    for(Node vm:avm)
    {
        System.out.println("Vertex" + vm.getLabel() +" , "+vm.getType() + "Module: " + vm.getXandY()[0] + ":" + vm.getXandY()[1]);
    }
}
 }

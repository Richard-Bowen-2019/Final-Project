/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinalProject.Controller.Vehicle;

import FinalProject.Model.Map.Road;
import FinalProject.Model.Map.TrafficMapModel;
import FinalProject.Model.Map.IntersectionVertex;
import FinalProject.Model.Vehicles.Vehicle;
import static java.lang.Math.sqrt;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;

/**
 *
 * @author Richard
 */
public class VehicleController 
{
private int seedRate;
TrafficMapModel tmp;
ArrayList<Vehicle> vehicles = new ArrayList<>();
    
public VehicleController() throws InterruptedException
{
    seedRate = 1;
    tmp = TrafficMapModel.getMapInstance();
}

public void seedVehicle(int seedRate)
{
    IntersectionVertex start = startPoint();
    IntersectionVertex end = endPoint();
    List<IntersectionVertex> aStar = routeVehicle(start,end);
    printList(aStar);
    /*for(int i=0;i<seedRate;i++)
    {
        //Vehicle newVehicle = new Vehicle(tmp.getModule(start,start);
        //vehicles.add(newVehicle);
        //printList(aStar);
        //navigate(aStar);
    }*/
}

public int randomNode(int start,int end)
{
    int r = start + (int)(Math.random()*(end-start+1));
    return r;
}

public IntersectionVertex startPoint()
{
    
    int startPoint = randomNode(0,tmp.getEntryNodes().size()-1);
    return tmp.getEntryNodes().get(startPoint);
}

public IntersectionVertex endPoint()
{
    int endPoint = randomNode(0,tmp.getExitNodes().size()-1);
    return tmp.getExitNodes().get(endPoint);
}

public void navigate(List<IntersectionVertex> bestRoute)
{
    
}

public void printList(List<IntersectionVertex> avm)
{
    for(IntersectionVertex vm:avm)
    {
        System.out.println("Vertex" + vm.getLabel()+" , "+vm.getType() + "Module: "+ vm.getModuleNumber());
    }
}

public List<IntersectionVertex> routeVehicle(IntersectionVertex start, IntersectionVertex end)
{   
    System.out.println("Start Label: "+start.getLabel() + ", Type: "+start.getType()+", Module: " + start.getModuleNumber());
    System.out.println("End Label: "+end.getLabel() + ", Type: "+end.getType()+", Module: " + end.getModuleNumber());
    return aStar(start,end);
        
}
   
public List<IntersectionVertex> constructPath(IntersectionVertex endPoint)
{
        LinkedList<IntersectionVertex> bestRoute = new LinkedList<>();

        while(endPoint.getParent() != null)
        {
            bestRoute.add(endPoint);
            endPoint = endPoint.getParent();
        }
        bestRoute.add(endPoint);
        Collections.reverse(bestRoute);
        return bestRoute;
    }
    
    public void setSeedRate(int rate) 
    {
        this.seedRate = rate;
    }
    
    public int getSeedRate() 
    {
        return seedRate;
    }
    
    public List<IntersectionVertex> aStar (IntersectionVertex start, IntersectionVertex end)
    {
        PriorityQueue<IntersectionVertex> visited = new PriorityQueue<>();
        PriorityQueue<IntersectionVertex> notVisited = new PriorityQueue<>();

        start.f = start.g + heuristic(start, end);
        notVisited.add(start);
        
        while(!notVisited.isEmpty())
        {
            //check first element
            IntersectionVertex source = notVisited.peek();
            //source.printVertex();
            if(source == end)
            {
                System.out.println("OnlyRoute triggered");
                return constructPath(end);
            }

            for(Road edge : source.getEdges())
            {
                if(edge.getDestination()!=null)
                {
                    IntersectionVertex nextVM = edge.getDestination();
                    //nextVM.printVertex();
                    double totalWeight = source.g + edge.getWeighting();
                
                    //if the vertex is not in either set
                    if(!notVisited.contains(nextVM) && !visited.contains(nextVM))
                    {
                        nextVM.setParent(source);
                        nextVM.g = totalWeight;
                        nextVM.f = nextVM.g + heuristic(start, end);
                        notVisited.add(nextVM);
                    } 
                    else 
                    {
                        if(totalWeight < nextVM.g)
                        {
                            nextVM.setParent(source);
                            nextVM.g = totalWeight;
                            nextVM.f = nextVM.g + heuristic(start, end);
                            if(visited.contains(nextVM))
                            {
                                visited.remove(nextVM);
                                notVisited.add(nextVM);
                            }
                        }
                    }
                }
            }
            notVisited.remove(source);
            visited.add(source);
        }
        return constructPath(end);
    }

    private double heuristic(IntersectionVertex start,IntersectionVertex end)
    {
        int[] startPosition = new int[2];
        int[] endPosition = new int[2];
        startPosition = tmp.getPosition(start);
        endPosition = tmp.getPosition(end);
        return sqrt((endPosition[0] - startPosition[0])^2 + (endPosition[1] - startPosition[1])^2);
    }
 }

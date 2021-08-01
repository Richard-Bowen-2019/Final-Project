/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinalProject.Controller.Vehicle;

import FinalProject.Model.Map.RoadModel;
import FinalProject.Model.Map.TrafficMapModel;
import FinalProject.Model.Map.VertexModel;
import static java.lang.Math.sqrt;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;


/**
 *
 * @author Richard
 */
public class RoutePlanner 
{

TrafficMapModel tmp;

    
public RoutePlanner() throws InterruptedException
{
    tmp = TrafficMapModel.getMapInstance();
}

public LinkedList<VertexModel> getRoute()
{
    //tmp.resetMap();
    VertexModel start = startPoint();
    //System.out.println("Start: "+ start.getLabel() + " - "+start.getType() + " " + start.getModuleNumber());
    VertexModel end = endPoint();
    //System.out.println("End: "+ end.getLabel() + " - " + end.getType() + " " + end.getModuleNumber());
    LinkedList<VertexModel> aStar = aStar(start,end);
    //printList(aStar);
    return aStar;
}

public int randomNode(int start,int end)
{
    int r = start + (int)(Math.random()*(end-start+1));
    return r;
}

public VertexModel startPoint()
{
    int startPoint = randomNode(0,tmp.getEntryNodes().size()-1);
    return tmp.getEntryNodes().get(startPoint);
}

public VertexModel endPoint()
{
    int endPoint = randomNode(0,tmp.getExitNodes().size()-1);
    return tmp.getExitNodes().get(endPoint);
}

public void printList(List<VertexModel> avm)
{
    for(VertexModel vm:avm)
    {
        //System.out.println("Vertex: " + vm.getLabel()+" , "+vm.getType() + " , Module: "+ vm.getModuleNumber());
    }
}
   
public LinkedList<VertexModel> createRoute(VertexModel start, VertexModel endPoint)
{
        LinkedList<VertexModel> bestRoute = new LinkedList<>();
        while(endPoint.getParent() != null)
        {
            bestRoute.add(endPoint);
            endPoint = endPoint.getParent();
        }
        bestRoute.add(start);
        Collections.reverse(bestRoute);
        return bestRoute;
        
    }
    
    public LinkedList<VertexModel> aStar (VertexModel start, VertexModel end)
    {
        PriorityQueue<VertexModel> closed = new PriorityQueue<>();
        PriorityQueue<VertexModel> open = new PriorityQueue<>();
        System.out.print("Start and end points");
        start.printVertex();
        end.printVertex();
        System.out.println();
        start.setTotalCost(heuristic(start,end));
        start.setRemainingCost(0);
        
        open.add(start);

        while(open.peek()!=end)
        {
            VertexModel currentVertex = open.peek();
            closed.add(currentVertex);
            
            for(RoadModel rd : currentVertex.getEdges())
            {
                if(!(rd.getSource()==null||rd.getDestination()==null))
                {
                    VertexModel nextVertex = rd.getDestination();
                    nextVertex.setRemainingCost(currentVertex.getRemainingCost() + rd.getWeighting());
                    nextVertex.setTotalCost(nextVertex.getRemainingCost() + heuristic(nextVertex,end));
                    
                    if(!open.contains(nextVertex) && !closed.contains(nextVertex))
                    {
                        nextVertex.setParent(currentVertex);
                        open.add(nextVertex);
                    }
                    else 
                    {
                        if(nextVertex.getTotalCost() < currentVertex.getTotalCost())
                        {
                            nextVertex.setParent(currentVertex);
                            if(closed.contains(nextVertex))
                            {
                                closed.remove(nextVertex);
                                open.add(nextVertex);
                            }
                        }
                    }
                }
            }
            open.remove(currentVertex);
            closed.add(currentVertex);
        }
        
        return createRoute(start, end);
    }

    public double heuristic(VertexModel start,VertexModel end)
    {
        int[] startPosition = new int[2];
        int[] endPosition = new int[2];
        startPosition = start.getXandY();
        endPosition = end.getXandY();
        int xLength = endPosition[0] - startPosition[0];
        int yLength = endPosition[1] - startPosition[1];
        return sqrt(Math.pow(xLength,2) + Math.pow(yLength,2));
    }
 }

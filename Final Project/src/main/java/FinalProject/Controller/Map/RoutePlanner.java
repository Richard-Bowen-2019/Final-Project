/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinalProject.Controller.Map;

import FinalProject.Model.Map.Edge;
import FinalProject.Model.Map.TrafficMapModel;
import FinalProject.Model.Map.Node;
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

public LinkedList<Node> getRoute()
{
    //tmp.resetMap();
    Node start = startPoint();
    //System.out.println("Start: "+ start.getLabel() + " - "+start.getType() + " " + start.getModuleNumber());
    Node end = endPoint();
    //System.out.println("End: "+ end.getLabel() + " - " + end.getType() + " " + end.getModuleNumber());
    LinkedList<Node> aStar = aStar(start,end);
    //printList(aStar);
    return aStar;
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

public void printList(List<Node> avm)
{
    for(Node vm:avm)
    {
        //System.out.println("Vertex: " + vm.getLabel()+" , "+vm.getType() + " , Module: "+ vm.getModuleNumber());
    }
}
   
public LinkedList<Node> createRoute(Node start, Node endPoint)
{
        LinkedList<Node> bestRoute = new LinkedList<>();
        while(endPoint.getParent() != null)
        {
            bestRoute.add(endPoint);
            endPoint = endPoint.getParent();
        }
        bestRoute.add(start);
        Collections.reverse(bestRoute);
        return bestRoute;
        
    }
    
    public LinkedList<Node> aStar (Node start, Node end)
    {
        PriorityQueue<Node> closed = new PriorityQueue<>();
        PriorityQueue<Node> open = new PriorityQueue<>();
        
        start.totalCost = start.remainingCost + heuristic(start,end);
        
        open.add(start);

        while(!open.isEmpty())
        {
            Node currentVertex = open.peek();
            System.out.println("Current Vertex");
            currentVertex.printVertex();
            if(currentVertex == end)
            {
                return createRoute(start,end);
            }
            
                for(Edge rd : currentVertex.getEdges())
                {
                    Node nextVertex = rd.getDestination();
                    System.out.println("Next Vertex");
                    nextVertex.printVertex();
                    double totalCost = currentVertex.remainingCost + rd.getWeighting();

                    if(nextVertex!=null)
                    {
                        if(!open.contains(nextVertex) && !closed.contains(nextVertex))
                        {
                                nextVertex.setParent(currentVertex);
                                nextVertex.remainingCost = totalCost;
                                nextVertex.totalCost = nextVertex.remainingCost + heuristic(nextVertex, end);
                                open.add(nextVertex);
                        } 
                        else 
                        {
                            if(totalCost < nextVertex.remainingCost)
                            {
                                nextVertex.setParent(currentVertex);
                                nextVertex.remainingCost = totalCost;
                                nextVertex.totalCost = nextVertex.remainingCost + heuristic(nextVertex, end);

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

    public double heuristic(Node start,Node end)
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

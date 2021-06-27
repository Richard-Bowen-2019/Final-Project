/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinalProject.Model.Map.Routes;

import FinalProject.Model.Map.Edge;
import FinalProject.Model.Map.TrafficMapModel;
import FinalProject.Model.Map.VertexModel;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author Richard
 */
public class Routeloader {
    private static Routeloader route;
    private ArrayList<LinkedList<VertexModel>> routes;
    TrafficMapModel model;
    private Routeloader() throws InterruptedException
    {
        this.model = TrafficMapModel.getMapInstance();
        this.routes = getRoutes();
    }
    
    public static Routeloader getRouteInstance() throws InterruptedException
    {
        if(route==null)
        {
            route = new Routeloader();
        }
        return route;
    }
    
    public ArrayList<LinkedList<VertexModel>> VertexRoutes(VertexModel start, VertexModel end)
    {
        ArrayList<LinkedList<VertexModel>> routes = new ArrayList<>();
        
        
        return routes;
        
    }
    
    public Tree AllRoutes (VertexModel start)
    {
        Tree allRoutes = new Tree(start);
        
            
            }
            
        
        
        
        return singles;
    }
    
    
    public ArrayList<LinkedList<VertexModel>> getRoutes()
    {
        ArrayList<LinkedList<VertexModel>> routes = new ArrayList<>();
        VertexModel vmStart = model.getEntryNodes().get(0).getDestination();
        VertexModel vmEnd = model.getExitNodes().get(0).getDestination();
        vmStart.setVisited();
        LinkedList<VertexModel> singleRoute = new LinkedList<VertexModel>();
        VertexModel current = vm;
        System.out.println(vm.getEdges().size());
        
                
        routes.add(singleRoute);
        
        //printList(singleRoute);
        //model.getExitNodes();
        return routes;
    }
    
    public void printList(LinkedList<VertexModel> list)
    {
        for(VertexModel vm:list)
        {
            System.out.println("Label:" + vm.getLabel()+": Direction" + vm.getType());
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinalProject.Model.Map;

import FinalProject.Controller.SimulationClock;
import FinalProject.Model.Map.Routes.Routeloader;
import java.util.ArrayList;

/**
 *
 * @author Richard
 */
public class TrafficMapModel {

    private static TrafficMapModel mapInstance =null;
    private ArrayList<ArrayList<Module>> map= new ArrayList<>();
    private ArrayList<Edge> entryNodes = new ArrayList<>();
    private ArrayList<Edge> exitNodes = new ArrayList<>();        
  
            
    private TrafficMapModel() throws InterruptedException {
        
        createMap();
        connectMap();
        createEntryAndExitNodes();
    }
    public static TrafficMapModel getMapInstance() throws InterruptedException {
        
        if (mapInstance == null) 
        {
            mapInstance = new TrafficMapModel();
        }
       return mapInstance;
    }
    
    
    int width = 5;
    int height = 3;
    
    private void createMap()
    {
        int count = 1;
        for(int i = 0;i<height;i++)
        {
            ArrayList<Module> temp = new ArrayList<>();
            for(int j = 0;j<width;j++)
            {
                temp.add(new Module(String.valueOf(count)));
                count++;
            }
            map.add(temp);
        }
    }       

    private void connectMap()
    {
        for(int i = 0;i<map.size();i++)
        {
            for(int j=0;j<map.get(i).size()-1;j++)
            {
                
                //add horizontal edges 
                VertexModel source = map.get(i).get(j).getVertex("East", "Out");
                VertexModel destination = map.get(i).get(j+1).getVertex("West","In");
                destination.addEdge(new Edge(source,destination));
                source.increaseConnections();
                destination.increaseConnections();
                
                source = map.get(i).get(j+1).getVertex("West","Out");
                destination = map.get(i).get(j).getVertex("East","In");
                destination.addEdge(new Edge(source,destination));
                source.increaseConnections();
                destination.increaseConnections();
            }
        }
        for(int i = 0;i<map.size()-1;i++)
        {
            for(int j=0;j<map.get(i).size();j++)
            {
                //add vertical edges
                VertexModel source = map.get(i).get(j).getVertex("South", "Out");
                VertexModel destination = map.get(i+1).get(j).getVertex("North","In");
                Edge soni = new Edge(source,destination);
                destination.addEdge(soni);
                source.increaseConnections();
                destination.increaseConnections();
                                
                source = map.get(i+1).get(j).getVertex("North","Out");
                destination = map.get(i).get(j).getVertex("South","In");
                Edge nosi = new Edge(source,destination);
                destination.addEdge(nosi);
                source.increaseConnections();
                destination.increaseConnections();
            }
        }
    }
    public void updateMapStatus()
    {
        System.out.println("Map updated");
    }
    
    private void createEntryAndExitNodes()
    {
        for(ArrayList<Module> list : map)
        {
            for(Module m:list)
            {
                for(VertexModel vm: m.getvertices())
                {
                    if(vm.getConnections()<4)
                    {
                        if(vm.getType()=="In")
                        {
                        Edge e = new Edge(null,vm);
                        vm.addEdge(e);
                        entryNodes.add(e);
                        }
                        else 
                        {
                        Edge e = new Edge(null,vm);
                        vm.addEdge(e);
                        exitNodes.add(e);
                        }
                    }        
                }
            }
        }
    }
    
    public void updateMapModel()
    {
        System.out.println("Model update");
    }
    
    public void printModel()
    {
        for(ArrayList<Module> list : map)
        {
            for(Module m:list)
            {
                System.out.println("Module:"+m.getLabel());
                for(VertexModel vm: m.getvertices())
                {
                    vm.printVertex();
                }
                
            }        
        }
    }
    
    
    
    
    public ArrayList<Edge> getEntryNodes() {
        return entryNodes;
    }

    public ArrayList<Edge> getExitNodes() {
        return exitNodes;
    }
    
    public ArrayList<ArrayList<Module>> getMap(){
            return map;
    }
}

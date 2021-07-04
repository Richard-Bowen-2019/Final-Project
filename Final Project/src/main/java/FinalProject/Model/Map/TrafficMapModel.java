/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinalProject.Model.Map;

import FinalProject.Controller.Map.MapController;
import FinalProject.Controller.SimulationClock;
import java.util.ArrayList;

/**
 *
 * @author Richard
 */
public class TrafficMapModel {

    private static TrafficMapModel mapInstance =null;
    private ArrayList<ArrayList<Intersection>> map= new ArrayList<>();
    private ArrayList<IntersectionVertex> entryNodes = new ArrayList<>();
    private ArrayList<IntersectionVertex> exitNodes = new ArrayList<>();        
    MapController controller = new MapController();
            
    private TrafficMapModel() throws InterruptedException 
    {
        createMap();
        connectMap();
        createEntryAndExitNodes();
        assignRandomWeights();
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
            ArrayList<Intersection> temp = new ArrayList<>();
            for(int j = 0;j<width;j++)
            {
                temp.add(new Intersection(String.valueOf(count)));
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
                IntersectionVertex source = map.get(i).get(j).getVertex("East", "Out");
                IntersectionVertex destination = map.get(i).get(j+1).getVertex("West","In");
                source.addEdge(new Road(source,destination));
                source.increaseConnections();
                destination.increaseConnections();
              
                source = map.get(i).get(j+1).getVertex("West", "In");
                destination = map.get(i).get(j+1).getVertex("East","Out");
                source.addEdge(new Road(source,destination));
                source.increaseConnections();
                destination.increaseConnections();
            }
        }
        for(int i = 0;i<map.size()-1;i++)
        {
            for(int j=0;j<map.get(i).size();j++)
            {
                //add vertical edges
                IntersectionVertex source = map.get(i).get(j).getVertex("South", "Out");
                IntersectionVertex destination = map.get(i+1).get(j).getVertex("North","In");
                source.addEdge(new Road(source,destination));
                source.increaseConnections();
                destination.increaseConnections();
                
                source = map.get(i+1).get(j).getVertex("North", "Out");
                destination = map.get(i).get(j).getVertex("South","In");
                source.addEdge(new Road(source,destination));
                source.increaseConnections();
                destination.increaseConnections();
            }
        }
    }
    public void updateMapStatus()
    {
        System.out.println("Map updated");
    }
    
    public void assignRandomWeights()
    {
        for(ArrayList<Intersection> am:map)
        {
            for(Intersection m : am)
            {
                for(IntersectionVertex vm : m.getvertices())
                {
                    for(Road e : vm.getEdges())
                    {
                            int rand = 1 + (int)(Math.random()*10);
                            e.setWeighting(rand);
                    }
                }
                    
            }
        }
    }
    
    private void createEntryAndExitNodes() throws InterruptedException
    {
        //Horizontal 
        for(int i = 0;i<map.get(0).size();i++)
        {
            IntersectionVertex vmIn = map.get(0).get(i).getVertex("North", "In");
            vmIn.addEdge(new Road(null,vmIn));
            entryNodes.add(vmIn);
            IntersectionVertex vmOut = map.get(0).get(i).getVertex("North", "Out");
            vmOut.addEdge(new Road(vmOut,null));
            exitNodes.add(vmOut);
        }
        
        for(int i = 0;i<map.get(map.size()-1).size();i++)
        {
            IntersectionVertex vmIn = map.get(map.size()-1).get(i).getVertex("South", "In");
            vmIn.addEdge(new Road(null,vmIn));
            entryNodes.add(vmIn);
            IntersectionVertex vmOut = map.get(map.size()-1).get(i).getVertex("South", "Out");
            vmOut.addEdge(new Road(vmOut,null));
            exitNodes.add(vmOut);
        }
        //vertical
        for(int i = 0;i<map.size();i++)
        {
            IntersectionVertex vmIn = map.get(i).get(0).getVertex("West", "In");
            vmIn.addEdge(new Road(null,vmIn));
            entryNodes.add(vmIn);
            IntersectionVertex vmOut = map.get(i).get(0).getVertex("West", "Out");
            vmOut.addEdge(new Road(vmOut,null));
            exitNodes.add(vmOut);
        }
        
        for(int i = 0;i<map.size();i++)
        {
            IntersectionVertex vmIn = map.get(i).get(map.get(i).size()-1).getVertex("East", "In");
            vmIn.addEdge(new Road(null,vmIn));
            entryNodes.add(vmIn);
            IntersectionVertex vmOut = map.get(i).get(map.get(i).size()-1).getVertex("East", "Out");
            vmOut.addEdge(new Road(vmOut,null));
            exitNodes.add(vmOut);
        }
        
        
    }
    
    public void printModel()
    {
        for(ArrayList<Intersection> list : map)
        {
            for(Intersection m:list)
            {
                System.out.println("Module:"+ m.getLabel());
                for(IntersectionVertex vm: m.getvertices())
                {
                    vm.printVertex();
                }
                
            }        
        }
    }
    
    public void printEntryNodes()
    {
        System.out.println(entryNodes.size());
        for(IntersectionVertex vm:entryNodes)
        {
            vm.printVertex();
        }
    }
    
    public int[] getPosition(IntersectionVertex vm)
    {
        int[] position = new int[2];
        for(int i = 0; i < map.size();i++)
        {
            for(int j = 0;j<map.get(i).size();j++)
            {
                if(map.get(i).get(j).containsVertex(vm))
                {
                    position[0] = i;
                    position[1] = j;
                }   
            }
        }
        return position; 
    }
    
    public ArrayList<IntersectionVertex> getEntryNodes() {
        return entryNodes;
    }

    public ArrayList<IntersectionVertex> getExitNodes() {
        return exitNodes;
    }
    
    public ArrayList<ArrayList<Intersection>> getMap(){
            return map;
    }
    
    public Intersection getModule(IntersectionVertex vm)
    {
        int[] position = getPosition(vm); 
        return map.get(position[0]).get(position[1]);
    }
    
    public void printList(ArrayList<IntersectionVertex> vm)
    {
        for (IntersectionVertex v: vm)
        {
            v.printVertex();
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinalProject.Model.Map;

import FinalProject.Resources.GV;
import java.util.ArrayList;

/**
 *
 * @author Richard
 */
public class TrafficMapModel {

    private static TrafficMapModel mapInstance =null;
    private ArrayList<ArrayList<IntersectionModel>> map= new ArrayList<>();
    private ArrayList<VertexModel> entryNodes = new ArrayList<>();
    private ArrayList<VertexModel> exitNodes = new ArrayList<>();        
    
    private TrafficMapModel() throws InterruptedException 
    {
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
    
    int width = GV.getHorizontalModules();
    int height = GV.getVerticalModules();
    
    private void createMap()
    {
       
        for(int i = 0;i<height;i++)
        {
            ArrayList<IntersectionModel> temp = new ArrayList<>();
            for(int j = 0;j<width;j++)
            {
                int[] position = {j,i};
                temp.add(new IntersectionModel(position));
                
            }
            map.add(temp);
        }
    }       
    
    //This method resets the parent of all nodes to null after a route has been planned.
    public void resetMap()
    {
        for(ArrayList<IntersectionModel> alis : mapInstance.getMap())
        {
            for(IntersectionModel is : alis)
            {
                for(VertexModel isv : is.getvertices())
                {
                    if(isv.getParent()!=null)
                    {
                    isv.setParent(null);
                    }
                }
            }
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
                source.addEdge(new RoadModel(source,destination));
                
                source = map.get(i).get(j+1).getVertex("West", "Out");
                destination = map.get(i).get(j).getVertex("East","In");
                source.addEdge(new RoadModel(source,destination));
                
            }
        }
        for(int i = 0;i<map.size()-1;i++)
        {
            for(int j=0;j<map.get(i).size();j++)
            {
                //add vertical edges
                VertexModel source = map.get(i).get(j).getVertex("South", "Out");
                VertexModel destination = map.get(i+1).get(j).getVertex("North","In");
                source.addEdge(new RoadModel(source,destination));
                
                
                source = map.get(i+1).get(j).getVertex("North", "Out");
                destination = map.get(i).get(j).getVertex("South","In");
                source.addEdge(new RoadModel(source,destination));
                
            }
        }
    }
    
    private void createEntryAndExitNodes() throws InterruptedException
    {
        //Horizontal 
        for(int i = 0;i<map.get(0).size();i++)
        {
            VertexModel vmIn = map.get(0).get(i).getVertex("North", "In");
            vmIn.addEdge(new RoadModel(null,vmIn));
            entryNodes.add(vmIn);
            VertexModel vmOut = map.get(0).get(i).getVertex("North", "Out");
            vmOut.addEdge(new RoadModel(vmOut,null));
            exitNodes.add(vmOut);
        }
        
        for(int i = 0;i<map.get(map.size()-1).size();i++)
        {
            VertexModel vmIn = map.get(map.size()-1).get(i).getVertex("South", "In");
            vmIn.addEdge(new RoadModel(null,vmIn));
            entryNodes.add(vmIn);
            VertexModel vmOut = map.get(map.size()-1).get(i).getVertex("South", "Out");
            vmOut.addEdge(new RoadModel(vmOut,null));
            exitNodes.add(vmOut);
        }
        //vertical
        for(int i = 0;i<map.size();i++)
        {
            VertexModel vmIn = map.get(i).get(0).getVertex("West", "In");
            vmIn.addEdge(new RoadModel(null,vmIn));
            entryNodes.add(vmIn);
            VertexModel vmOut = map.get(i).get(0).getVertex("West", "Out");
            vmOut.addEdge(new RoadModel(vmOut,null));
            exitNodes.add(vmOut);
        }
        
        for(int i = 0;i<map.size();i++)
        {
            VertexModel vmIn = map.get(i).get(map.get(i).size()-1).getVertex("East", "In");
            vmIn.addEdge(new RoadModel(null,vmIn));
            entryNodes.add(vmIn);
            VertexModel vmOut = map.get(i).get(map.get(i).size()-1).getVertex("East", "Out");
            vmOut.addEdge(new RoadModel(vmOut,null));
            exitNodes.add(vmOut);
        }
        
        
    }
    
    public void printModel()
    {
        int count = 1;
        for(ArrayList<IntersectionModel> list : map)
        {
            for(IntersectionModel m : list)
            {
                System.out.println("Module" + count);
                count++;
                for(VertexModel vm: m.getvertices())
                {
                    System.out.print("   ");
                    vm.printVertex();
                }
                
            }        
        }
    }
    
    public void printEntryNodes()
    {
        System.out.println(entryNodes.size());
        for(VertexModel vm:entryNodes)
        {
            vm.printVertex();
        }
    }
    
    public int[] getModulePositionFromVertexModel(VertexModel vm)
    {
        int[] position = new int[2];
        for(int i = 0; i < map.size();i++)
        {
            for(int j = 0;j<map.get(i).size();j++)
            {
                if(map.get(i).get(j).containsVertex(vm))
                {
                    position[0] = j;
                    position[1] = i;
                }   
            }
        }
        return position; 
    }
    
    public IntersectionModel getModuleByPosition(int[] position)
    {
        return map.get(position[0]).get(position[1]);
    }
    
    public ArrayList<VertexModel> getEntryNodes() {
        return entryNodes;
    }

    public ArrayList<VertexModel> getExitNodes() {
        return exitNodes;
    }
    
    public ArrayList<ArrayList<IntersectionModel>> getMap(){
            return map;
    }
    
    public IntersectionModel getModuleFromVertex(VertexModel vm)
    {
        int[] position = getModulePositionFromVertexModel(vm); 
        return map.get(position[0]).get(position[1]);
    }
    
    public void printList(ArrayList<VertexModel> vm)
    {
        for (VertexModel v: vm)
        {
            v.printVertex();
        }
    }
}

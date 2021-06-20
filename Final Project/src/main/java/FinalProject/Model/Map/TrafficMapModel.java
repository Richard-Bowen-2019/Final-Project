/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinalProject.Model.Map;

import java.awt.List;
import java.util.ArrayList;

/**
 *
 * @author Richard
 */
public class TrafficMapModel {
    private static ArrayList<ArrayList<Module>> map;
    private static ArrayList<VertexModel> entryNodes;
    private static ArrayList<VertexModel> exitNodes;
    
    int width = 5;
    int height = 3;
    
    private TrafficMapModel()
    {
        createMap();
        connectMap();
        entryNodes = new ArrayList<>();
        exitNodes = new ArrayList<>();
        createEntryAndExitNodes();
        printEntryandExitNodes();
        }
    
    public static ArrayList<ArrayList<Module>> getMapInstance()
    {
        if(map==null)
        {
            map = new ArrayList<ArrayList<Module>>();
            new TrafficMapModel();
            return map;
        }
        return map; 
    }
    
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
        for(int i = 0;i<height-1;i++)
        {
            for(int j=0;j<width-1;j++)
            {
                //add horizontal edges 
                VertexModel source = map.get(i).get(j).getVertex("East", "Out");
                VertexModel destination = map.get(i).get(j+1).getVertex("West","In");
                source.addEdge(new Edge(source,destination));
                source.increaseConnections();
                destination.increaseConnections();
                
                source = map.get(i).get(j+1).getVertex("West","Out");
                destination = map.get(i).get(j).getVertex("East","In");
                source.addEdge(new Edge(source,destination));
                source.increaseConnections();
                destination.increaseConnections();


                //add vertical edges
                source = map.get(i).get(j).getVertex("South", "Out");
                destination = map.get(i+1).get(j).getVertex("North","In");
                source.addEdge(new Edge(source,destination));
                source.increaseConnections();
                destination.increaseConnections();
                
                source = map.get(i).get(j+1).getVertex("North","Out");
                destination = map.get(i).get(j).getVertex("South","In");
                source.addEdge(new Edge(source,destination));
                source.increaseConnections();
                destination.increaseConnections();
            }
           
           
    }
    }
    
    
    private void createEntryAndExitNodes()
    {
        for(ArrayList<Module> list : map)
        {
            for(Module m : list)
            {
                ArrayList<VertexModel> freeNodes = m.getEntryNodes();
                for(VertexModel vm: freeNodes)
                {
                    if(vm.getType()=="In")
                    {
                        entryNodes.add(vm);
                    }
                    else if(vm.getType()=="Out")
                    {
                        exitNodes.add(vm);
                    }
                    else
                    {
                        System.out.println("Error: Vertex with no In or Out type defined");
                    }
                }
            }
        }
    }
    
    public void printEntryandExitNodes()
    {
        System.out.println("Entry Nodes");
        for(VertexModel vm: entryNodes)
        {
            vm.printVertex();
        }
        System.out.println("Exit Nodes");
        for(VertexModel vm: exitNodes)
        {
            vm.printVertex();
        }
    }
}

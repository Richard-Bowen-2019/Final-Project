/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinalProject.Model.Map;

import java.util.ArrayList;

/**
 *
 * @author Richard
 */
public class VertexModel {
    ArrayList<Edge> edges = new ArrayList<>();
    String type;
    String label;
    int connections;
    boolean visited;
    
    VertexModel(String label, String type) {
        this.label = label;
        this.type = type;
        this.connections = 0;
        visited = false;
    }
    
    public void setVisited()
    {
        this.visited = true;
    }
    
    public boolean getVisited()
    {
        return visited;
    }
    
    public void setNotVisited()
    {
        this.visited = false;
    }
        
    
    public String getType()
    {
        return type;
    }
    
    public String getLabel()
    {
        return label;
    }
    
    public void addEdge(Edge edge){
        this.edges.add(edge);
    }
    
    public ArrayList<Edge> getEdges(){
        return edges;
    }
    
    public void increaseConnections(){
        connections++;
    }
    
    public int getConnections()
    {
        return connections;
    }
    
    public void printVertex()
    {
        System.out.println("Label: " + label);
        System.out.println("Type: " + type);
        System.out.println("Connections: " + connections);
        /*for(Edge e : edges)
        {
            e.printEdge();
        }*/
    }
    
    
}


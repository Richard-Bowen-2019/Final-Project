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
public class Vertex {
    ArrayList<Edge> edges = new ArrayList<>();
    String type;
    String label;
    Vertex(String label, String type) {
        this.label = label;
        this.type = type;
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
    
    
}


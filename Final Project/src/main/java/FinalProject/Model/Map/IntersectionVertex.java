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
public class IntersectionVertex implements Comparable<IntersectionVertex>{
    private ArrayList<Road> edges = new ArrayList<>();
    String type;
    String label;
    String module;
    int connections;
    private IntersectionVertex parent=null;
    boolean visited;
    public double f = Double.MAX_VALUE;
    public double g = Double.MAX_VALUE;
    
    public IntersectionVertex(String label, String type, String module) {
        this.label = label;
        this.type = type;
        this.connections = 0;
        this.module = module;
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
        if(type==null)
        {
            return "None";
        }
        else
        {
        return type;
        }
    }
    
    public String getLabel()
    {
        if(label!=null)
        {
            return label;
        }
        else 
        {
            return "None";
        }
    }
    
    public void setModule(String label) {
        module = label;
    }
    
    public String getModuleNumber() {
        if(module==null)
        {
            return "None";
        }
        else
        {
        return module;
        }
    }
    
    public void addEdge(Road edge){
        this.edges.add(edge);
    }
    
    public ArrayList<Road> getEdges(){
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
        System.out.println("Vertex");
        System.out.println("Label: " + label+", Type: " + type+", Module: " + module);
        System.out.println("Edges");
        for(Road e : edges)
        {
            e.printEdge();
        }
        System.out.println();
    }
    
    public boolean containsIn()
    {
        for(Road e: edges)
        {
            if(e.getSource()==null)
            {
                return true;
            }
        }
        return false;
    }
    
    public Road getOut()
    {
        for(Road e: this.getEdges())
        {
            if(e.getDestination()==null)
            {
                return e;
            }
        }
        return null;
    }
    
    public void setParent(IntersectionVertex parent)
    {
        this.parent=parent;
    }
    
    public IntersectionVertex getParent()
    {
        return parent;
    }

    @Override
    public int compareTo(IntersectionVertex o) {
         return Double.compare(this.f, o.f);
    }
}


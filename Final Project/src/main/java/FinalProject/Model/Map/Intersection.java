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
public class Intersection {
    ArrayList<IntersectionVertex> vertices = new ArrayList<>();
    String[] direction = {"North", "South", "East", "West"};    
    String[] type = {"In","Out"};
    String label;
    
    
    
    public Intersection(String label){
        createVertices(label);
        createEdges();
        this.label=label;
        
    }    
    
    private void createVertices(String label)
    {
        
        for(int i=0;i<direction.length;i++)
        {
            for(int j = 0;j<type.length;j++)
            {
                IntersectionVertex vertex = new IntersectionVertex(direction[i],type[j],label);
                vertices.add(vertex);
            }
        }
        
    }
    
    public ArrayList<IntersectionVertex> getvertices()
    {
        return vertices;
    }
    
    public IntersectionVertex getVertex(String label,String type)
    {
        IntersectionVertex vertex = null;
        for(IntersectionVertex i : vertices)
        {
            if(i.getLabel()==label&&i.getType()==type)
            {
                vertex = i;
            }
        }
        return vertex;    
    }
    
    private void createEdges()
    {
        for(int i = 0;i<direction.length;i++)
        {
            IntersectionVertex source = getVertex(direction[i],"In");
            for(IntersectionVertex v : vertices)
            {
                if(v.getType()=="Out"&&v.getLabel()!=direction[i])
                {
                    source.addEdge(new Road(source,v));
                    source.increaseConnections();
                    v.increaseConnections();
                }
            }
        
        }
        
    }
    public String getLabel()
    {
        return label;
    }
    
    public boolean containsVertex(IntersectionVertex v)
    {
        return vertices.contains(v);
    }
    
    public void printVerticesAndEdges()
    {
        for(IntersectionVertex v: vertices)
        {
            System.out.println("Vertex: " + v.getLabel()+ " - " + v.getType());
            System.out.println(v.getConnections());
        }            
    }
    
    
    
}

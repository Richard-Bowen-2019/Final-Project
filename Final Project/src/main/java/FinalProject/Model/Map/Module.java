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
public class Module {
    ArrayList<VertexModel> vertices = new ArrayList<>();
    String[] direction = {"North", "South", "East", "West"};    
    String[] type = {"In","Out"};
    String label;
    
    
    
    public Module(String label){
        createVertices();
        createEdges();
        this.label=label;
    }    
    
    private void createVertices()
    {
        
        for(int i=0;i<direction.length;i++)
        {
            for(int j = 0;j<type.length;j++)
            {
                VertexModel vertex = new VertexModel(direction[i],type[j],this.getLabel());
                vertices.add(vertex);
            }
        }
        
    }
    
    public ArrayList<VertexModel> getvertices()
    {
        return vertices;
    }
    
    public VertexModel getVertex(String label,String type)
    {
        VertexModel vertex = null;
        for(VertexModel i : vertices)
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
            VertexModel source = getVertex(direction[i],"In");
            for(VertexModel v : vertices)
            {
                if(v.getType()=="Out"&&v.getLabel()!=direction[i])
                {
                    source.addEdge(new Edge(source,v));
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
    
    
    public void printVerticesAndEdges()
    {
        for(VertexModel v: vertices)
        {
            System.out.println("Vertex: " + v.getLabel()+ " - " + v.getType());
            System.out.println(v.getConnections());
        }            
    }
    
    
    
}

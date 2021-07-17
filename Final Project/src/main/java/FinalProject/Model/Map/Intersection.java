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
    
    ArrayList<Node> vertices = new ArrayList<>();
    String[] direction = {"North", "South", "East", "West"};    
    String[] type = {"In","Out"};
    int [] intersectionPosition;
    
    public Intersection(int[] position)
    {
        this.intersectionPosition = position;
        createVertices();
        createEdges();
    }    
    
    public void createVertices()
    {
        for(int i=0;i<direction.length;i++)
        {
            for(int j = 0;j<type.length;j++)
            {
                Node vertex = new Node(direction[i],type[j],intersectionPosition);
                vertices.add(vertex);
            }
        }
        
    }
    
    public ArrayList<Node> getvertices()
    {
        return vertices;
    }
    
    public Node getVertex(String label,String type)
    {
        Node vertex = null;
        for(Node i : vertices)
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
            Node source = getVertex(direction[i],"In");
            for(Node v : vertices)
            {
                if(v.getType()=="Out"&&v.getLabel()!=direction[i])
                {
                    source.addEdge(new Edge(source,v));
                }
            }
        
        }
        
    }
    
    
    public boolean containsVertex(Node v)
    {
        return vertices.contains(v);
    }
    
    public void printVerticesAndEdges()
    {
        for(Node v: vertices)
        {
            //System.out.println("Vertex: " + v.getLabel()+ " - " + v.getType());
            //System.out.println(v.getConnections());
        }            
    }
    
    
    
}

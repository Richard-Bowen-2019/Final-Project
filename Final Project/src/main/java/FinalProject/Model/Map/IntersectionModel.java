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
public class IntersectionModel {
    
    ArrayList<VertexModel> vertices = new ArrayList<>();
    String[] direction = {"North", "South", "East", "West"};    
    String[] type = {"In","Out"};
    int [] intersectionPosition;
  
    /**
    * Constructor of the IntersectionModel class. 
    *
    * @param  position   the position of the module within which the intersection presides
    * @return            None
    */
    public IntersectionModel(int[] position)
    {
        this.intersectionPosition = position;
        createVertices();
        createInternalEdges();
        
    }    
    
    /**
    * Create the 8 vertices of the intersection and add them to the vertices arraylist 
    *
    * @param     None
    * @return    None
    */
    //
    private void createVertices()
    {
        for(int i=0;i<direction.length;i++)
        {
            for(int j = 0;j<type.length;j++)
            {
                VertexModel vertex = new VertexModel(direction[i],type[j],intersectionPosition);
                vertices.add(vertex);
            }
        }
        
    }
    
    /**
    * Getter for the vertices arraylist 
    *
    * @param     None
    * @return    the arraylist vertices located in this class
    */
    //
    public ArrayList<VertexModel> getvertices()
    {
        return vertices;
    }
    
    /**
    * Getter for a specific vertexModel based on its label and type 
    *
    * @param     Label which is the direction of the vertex 
    *            Type which is whether this vertex goes into our out of intersection   
    * @return    the arraylist vertices located in this class
    */
    //
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
    
    /**
    * Creates the internal edges of the intersection representing the centre of the intersection 
    * This cycles through all vertices that flow into the IntersectionModel and
    * find all of the vertices that flow out and create a connecting Road.
    * 
    * @param     None   
    * @return    None
    */
    //
    private void createInternalEdges()
    {
        for(int i = 0;i<direction.length;i++)
        {
            VertexModel source = getVertex(direction[i],"In");
            for(VertexModel v : vertices)
            {
                if(v.getType()=="Out"&&v.getLabel()!=direction[i])
                {
                    source.addEdge(new RoadModel(source,v,"Intersection"));
                }
            }
        }
    }
    
    /**
    * Checks whether the intersection contains a specific vertex
    * 
    * @param     VertexModel object relating to check for   
    * @return    true if the intersection contains the vertex, false if not
    */
    //
    public boolean containsVertex(VertexModel v)
    {
        return vertices.contains(v);
    }
    
    /**
    * Prints the vertices and edges of the intersection.
    * 
    * @param     None  
    * @return    None
    */
    //
    public void printVerticesAndEdges()
    {
        for(VertexModel v: vertices)
        {
            //System.out.println("Vertex: " + v.getLabel()+ " - " + v.getType());
            //System.out.println(v.getConnections());
        }            
    }
    
    
    
}

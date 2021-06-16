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
    ArrayList<Vertex> vertices = new ArrayList<>();
    String[] direction = {"North", "South", "east", "West"};    
    String[] type = {"In","Out"};

    
    int xPosition;
    int yPosition;
    
    public Module(int x, int y){
        createVertices();
        addEdges();
        this.xPosition = x;
        this.yPosition = y;
    }    
    
    public void createVertices()
    {
        for(int i=0;i<direction.length;i++)
        {
            for(int j = 0;j<type.length;j++)
            {
                Vertex vertex = new Vertex(type[j],direction[i]);
                vertices.add(vertex);
            }
        }       
    }
    
    private Vertex getVertex(String label,String type)
    {
        Vertex vertex = null;
        for(Vertex i : vertices)
        {
            if(i.getLabel()==label&&i.getType()==type)
            {
                vertex = i;
            }
        }
        return vertex;    
    }
    
    private void addEdges()
    {
        for(int i = 0;i<direction.length;i++)
        {
            Vertex source = getVertex(direction[i],"In");
        
            for(Vertex v : vertices)
            {
                if(v.getLabel()!=direction[i]||v.getType()!="In")
                {
                    Edge edge = new Edge(source,v);
                    v.addEdge(edge);
                }    
            }
        }
    }
    
    public void printVerticesAndEdges()
    {
         
    }            
    
    public int getx() {
        return xPosition;
    }

    public int gety() {
        return yPosition;
    }
    
}

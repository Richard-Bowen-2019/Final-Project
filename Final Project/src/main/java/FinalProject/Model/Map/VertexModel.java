/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinalProject.Model.Map;

import FinalProject.GlobalVariables;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Richard
 */
public class VertexModel implements Comparable<VertexModel>{
    private ArrayList<RoadModel> edges = new ArrayList<>();
    private String type;
    private String label;
    private int[] position;

    
    private int x = 0;
    private int y = 0;
    private HashMap<String,int[]> vertices = new HashMap<>();
    private VertexModel parent=null;
    public double totalCost = 0;
    public double remainingCost = 0;

    
    public VertexModel(String label, String type, int[] position) 
    {
        this.label = label;
        this.type = type;
        this.position = position;
        setXandY();
    }
    
    private void setXandY()
    {
        int[] northIn = {7,4};
        int[] northOut = {5,4};
        int[] eastIn = {8,7};
        int[] eastOut = {8,5};
        int[] southIn = {5,8};
        int[] southOut = {7,8};
        int[] westIn = {4,5};
        int[] westOut = {4,7};
        vertices.put("North-In",northIn);
        vertices.put("North-Out",northOut);
        vertices.put("East-In",eastIn);
        vertices.put("East-Out",eastOut);
        vertices.put("South-In",southIn);
        vertices.put("South-Out",southOut);
        vertices.put("West-In",westIn);
        vertices.put("West-Out",westOut);
        String key = this.label + "-" + this.getType();
        this.x = vertices.get(key)[0] + position[0]*12;
        this.y = vertices.get(key)[1] + position[1]*12;
    }
    
    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public void setRemainingCost(double remainingCost) {
        this.remainingCost = remainingCost;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public double getRemainingCost() {
        return remainingCost;
    }
    
    public int[] getXandY() {
        int[] xy = {this.x,this.y};
        return xy;
    }
    
    public List<RoadModel> getInRoads()
    {
        ArrayList<RoadModel> roads = new ArrayList<>();
        for(RoadModel e :edges)
        {
            if(e.getSource()==null)
            {
                roads.add(e);
            }
        }
        return roads;
    }
    
    public List<RoadModel> getOutRoads()
    {
        ArrayList<RoadModel> roads = new ArrayList<>();
        for(RoadModel e :edges)
        {
            if(e.getDestination()==null)
            {
                roads.add(e);
            }
        }
        return roads;
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
    
    public void addEdge(RoadModel edge){
        this.edges.add(edge);
    }
    
    public ArrayList<RoadModel> getEdges(){
        return edges;
    }
    
    public int[] getPosition() {
        return position;
    }
    
    public void printVertex()
    {
        System.out.println("Node: " + label + ", Type: " + type + ", Module: " + position[0]+":" + position[1]);
        /*for(RoadModel e : edges)
        {
            System.out.print("     ");
            e.printEdge();
        }
        System.out.println();*/
    }
    
    public RoadModel getIn()
    {
        for(RoadModel r : edges)
        {
            if(r.getSource()==null)
            {
                return r;
            }
        }
        return null;
    }
    
    public RoadModel getOut()
    {
        for(RoadModel r : edges)
        {
            if(r.getSource()!=null)
            {
                return r;
            }
        }
        return null;
    }
    
    
    public boolean containsIn()
    {
        for(RoadModel e: edges)
        {
            if(e.getSource()==null)
            {
                return true;
            }
        }
        return false;
    }
    
    public RoadModel getRoad(VertexModel source,VertexModel destination) {
        for(RoadModel e: this.getEdges())
        {
            if(e.getSource()==source && e.getDestination()==destination)
            {
                return e;
            }
        }
        return null;
    }
    
    public void setParent(VertexModel parent)
    {
        this.parent=parent;
    }
    
    public VertexModel getParent()
    {
        return parent;
    }

    @Override
    public int compareTo(VertexModel o) {
         return Double.compare(this.totalCost, o.totalCost);
    }

}


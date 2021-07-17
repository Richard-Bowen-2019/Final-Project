/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinalProject.Model.Map;

import FinalProject.GlobalVariables;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Richard
 */
public class Node implements Comparable<Node>{
    private ArrayList<Edge> edges = new ArrayList<>();
    String type;
    String label;
    int[] position;
    int x = 0;
    int y = 0;
    
    HashMap<String,int[]> vertices = new HashMap<>();
    private Node parent=null;
    public double totalCost = 0;
    public double remainingCost = 0;
    
    public Node(String label, String type, int[] position) 
    {
        this.label = label;
        this.type = type;
        this.position = position;
        setXandY();
    }
    
    public void setXandY()
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
    
    public int[] getXandY() {
        int[] xy = {this.x,this.y};
        return xy;
    }
    
    public ArrayList<Edge> getInRoads()
    {
        ArrayList<Edge> roads = new ArrayList<>();
        for(Edge e :edges)
        {
            if(e.getSource()==null)
            {
                roads.add(e);
            }
        }
        return roads;
    }
    
    public ArrayList<Edge> getOutRoads()
    {
        ArrayList<Edge> roads = new ArrayList<>();
        for(Edge e :edges)
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
    
    public void addEdge(Edge edge){
        this.edges.add(edge);
    }
    
    public ArrayList<Edge> getEdges(){
        return edges;
    }
    
    public void printVertex()
    {
        System.out.println("Node: " + label + ", Type: " + type + ", Module: " + position[0]+":" + position[1]);
        /*for(Edge e : edges)
        {
            System.out.print("     ");
            e.printEdge();
        }
        System.out.println();*/
    }
    
    public Edge getIn()
    {
        for(Edge r : edges)
        {
            if(r.getSource()==null)
            {
                return r;
            }
        }
        return null;
    }
    
    public Edge getOut()
    {
        for(Edge r : edges)
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
        for(Edge e: edges)
        {
            if(e.getSource()==null)
            {
                return true;
            }
        }
        return false;
    }
    
    public Edge getRoad(Node source,Node destination) {
        for(Edge e: this.getEdges())
        {
            if(e.getSource()==source && e.getDestination()==destination)
            {
                return e;
            }
        }
        return null;
    }
    
    public void setParent(Node parent)
    {
        this.parent=parent;
    }
    
    public Node getParent()
    {
        return parent;
    }

    @Override
    public int compareTo(Node o) {
         return Double.compare(this.totalCost, o.totalCost);
    }

}


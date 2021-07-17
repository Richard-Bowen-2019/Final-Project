/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinalProject.Model.Map;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 *
 * @author Richard
 */
public class Edge {
    int weighting;
    int[] slots;
    Node source;
    Node destination;
    
    public Edge(Node source,Node destination)
    {
        this.weighting = 0;
        
        if(source==null||destination==null||(source.getType()=="Out"||destination.getType()=="In"))
        {
            slots = new int[10];
            initiateSlots(10);
        }
        else
        {
            slots = new int[2];
            initiateSlots(2);
        }
        this.source = source;
        this.destination = destination;
    }
    
    public Node getSource() {
        return source;
    }
    
    public int getSlot(int s)
    {
        return slots[s];
    }
    
    public void vacateSlot(int slot)
    {
        slots[slot]=0;
    }

    public void occupySlot(int slot)
    {
           slots[slot]=1;
           weighting++;
    }
    
    public int getSlotSize()
    {
        return slots.length;
    }
    
    private void initiateSlots(int n){
        for(int i = 0;i<n;i++)
        {
            slots[i]=0;
        }
    }
    
    
    
    public Node getDestination(){
        return destination;
    }
    
    public void increaseWeighting()
    {
        weighting++;
    }

    public void setWeighting(int w)
    {
        weighting = w;
    }
    
    public int getWeighting()
    {
      return weighting;
    }
    
    public boolean nullCheck(Node vm)
    {
        try
        {
            vm.getLabel();
            vm.getType();
            return true;
        }
        catch(NullPointerException e)
        {
            return false;
        }
    }
    
    
    
    public void printEdge()
    {
        
        
        if(this.source!=null)
        {
            System.out.print("Source Edge: " + this.source.getLabel());
            System.out.print("-" + this.source.getType());
            System.out.print("-Module " + source.position[0] + ":" + source.position[1]);
            
        }
        else 
        {
            System.out.print("Source Edge: None");
        }
        if(this.destination!=null)
        {
            System.out.print(" to Destination Edge: " + this.destination.getLabel());
            System.out.print("-" + this.destination.getType());
            System.out.println("-Module  " + destination.position[0] + ":" + destination.position[1]);
        }
        else 
        {
            System.out.print(" to Destination: None");
            
        }
        
    }
            
}

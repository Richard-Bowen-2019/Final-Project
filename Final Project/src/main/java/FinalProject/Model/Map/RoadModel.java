/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinalProject.Model.Map;

import FinalProject.Model.Vehicles.VehicleModel;
import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 *
 * @author Richard
 */
public class RoadModel {
    int weighting;
    VehicleModel[] vehicles;
    VertexModel source;
    VertexModel destination;
    
    public RoadModel(VertexModel source,VertexModel destination)
    {
        this.weighting = 0;
        
        if(source==null||destination==null||(source.getType()=="Out"||destination.getType()=="In"))
        {
            vehicles = new VehicleModel[10];
            initiateSlots(10);
        }
        else
        {
            vehicles = new VehicleModel[2];
            initiateSlots(2);
        }
        this.source = source;
        this.destination = destination;
    }
    
    public VertexModel getSource() {
        return source;
    }
    
    public int getSlot(VehicleModel vhl)
    {
        int temp = 15;
        for(int i = 0;i<vehicles.length;i++)
        {
            if(vehicles[i]==vhl)
            {
                return i;
            }
        }
        return temp;
    }
    
    public void vacateSlot(int slot)
    {
        vehicles[slot]=null;
    }

    public void occupySlot(int i, VehicleModel v)
    {
           vehicles[i]=v;
           weighting++;
    }
    
    public int getSlotSize()
    {
        return vehicles.length;
    }
    
    private void initiateSlots(int n){
        for(int i = 0;i<n;i++)
        {
            vehicles[i]=null;
        }
    }
    
    public VertexModel getDestination(){
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
    
    public boolean nullCheck(VertexModel vm)
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
            System.out.print("Source Edge: None                   ");
        }
        if(this.destination!=null)
        {
            System.out.print(" to Destination Edge: " + this.destination.getLabel());
            System.out.print("-" + this.destination.getType());
            System.out.print("-Module  " + destination.position[0] + ":" + destination.position[1]);
        }
        else 
        {
            System.out.print(" to Destination: None                  ");
            
        }
        
    }
            
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinalProject.Model.Map;

import FinalProject.Controller.VehicleController.VehicleControllers.ControllerInterface;
import FinalProject.Model.Vehicles.VehicleModel;
import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 *
 * @author Richard
 */
public class RoadModel {
    private int weighting;
    private VehicleModel[] vehicles;
    private VertexModel source;
    private VertexModel destination;
    private String type;
    ControllerInterface controller;
    /**
    * Constructor of the RoadModel class
    * 
    * @param     Source and destination vertices as well as the type of Road   
    * @return    None
    */
    //
    public RoadModel(VertexModel source,VertexModel destination, String type)
    {
        this.type = type;
        this.weighting = 0;
        if(type=="Connecting"||type=="Exit"||type=="Entry")
        {
            initiateSlots(5);
        }
        else
        {
            initiateSlots(2);
        }
        this.source = source;
        this.destination = destination;
    }
    
    /**
    * Getter for the road source
    * 
    * @param     None   
    * @return    A vertex model object corresponding the source property.
    */
    //
    public VertexModel getSource() {
        return source;
    }
    
    /**
    * Getter for the specific slot occupied by a specific vehicle
    * 
    * @param     VehicleModel The vehicle for which the slot is required  
    * @return    int position of the slot occupied by the vehicle 
    */
    //
    public int getSlot(VehicleModel vehicle)
    {
        int temp = 0;
        for(int i = 0;i<vehicles.length;i++)
        {
            if(vehicles[i]==vehicle)
            {
                return i;
            }
        }
        return temp;
    }
    
    /**
    * method to return a slot to the null state
    * 
    * @param     int The slot number that needs vacating  
    * @return    None 
    */
    //
    public void vacateSlot(int slot)
    {
        vehicles[slot]=null;
    }

    /**
    * Method to assign a slot with a vehicle Object
    * 
    * @param     int The slot number that needs occupying
    *            VehicleModel the vehicle to be assigned to that slot
    * @return    None 
    */
    //
    public void occupySlot(int i, VehicleModel v)
    {
        vehicles[i]=v;
    }
    
    /**
    * Method to assign a slot with a vehicle Object
    * 
    * @param     int The slot number that needs occupying
    *            VehicleModel the vehicle to be assigned to that slot
    * @return    None 
    */
    //
    public boolean checkSlot(int i)
    {
        return vehicles[i]==null;
    }
    
    
    
    public int getSlotSize()
    {
        return vehicles.length;
    }
    
    private void initiateSlots(int n){
        vehicles = new VehicleModel[n];
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

    public void decreaseWeighting()
    {
        weighting--;
    }
    
    public int getWeighting()
    {
      return weighting;
    }
    
    public void printEdge()
    {
        if(this.source!=null)
        {
            System.out.print("Source Edge: " + this.source.getLabel());
            System.out.print("-" + this.source.getType());
            System.out.print("-Module " + source.getPosition()[0] + ":" + source.getPosition()[1]);
        }
        else 
        {
            System.out.print("Source Edge: None                   ");
        }
        if(this.destination!=null)
        {
            System.out.print("to Destination Edge: " + this.destination.getLabel());
            System.out.print("-" + this.destination.getType());
            System.out.print("-Module  " + destination.getPosition()[0] + ":" + destination.getPosition()[1]);
        }
        else 
        {
            System.out.print("to Destination: None                  ");
            
        }
        
    }
    
    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
    
}

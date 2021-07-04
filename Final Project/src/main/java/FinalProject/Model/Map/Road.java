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
public class Road {
    int weighting;
    ArrayList<Integer> slots = new ArrayList<>();
    IntersectionVertex source;

    public IntersectionVertex getSource() {
        return source;
    }
    IntersectionVertex destination;
    public Road(IntersectionVertex source,IntersectionVertex destination){
        this.weighting = 0;
        initiateSlots();
        this.source = source;
        this.destination = destination;
    }
    
    public void occupySlot(int slot){
        if(slot<=10)
        {
           slots.add(slot, 1);
           increaseWeighting();
        }
    }
    private void initiateSlots(){
        for(int i = 0;i<10;i++)
        {
            slots.add(0);
        }
    }
    
    public IntersectionVertex getDestination(){
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
    
    public boolean nullCheck(IntersectionVertex vm)
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
        
        System.out.print("Weighting: " + this.weighting);
        if(nullCheck(this.source))
        {
            System.out.print(" ,Source label: " + this.source.getLabel());
            System.out.print(" ,Source type: " + this.source.getType());
        }
        else 
        {
            System.out.print(" ,Source label: None");
            System.out.print(" ,Source type: None");
        }
        if(nullCheck(this.destination))
        {
            System.out.print(" ,Destination label: " + this.destination.getLabel());
            System.out.print(" ,Destination type: " + this.destination.getType());
            System.out.println(", Destination Module: " + this.destination.getModuleNumber());
        }
        else 
        {
            System.out.print(" ,Destination label: None");
            System.out.print(" ,Destination type: None");
        }
      
    }
            
}

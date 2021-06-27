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
public class Edge {
    int weighting;
    ArrayList<Integer> slots = new ArrayList<>();
    VertexModel source;

    public VertexModel getSource() {
        return source;
    }
    VertexModel destination;
    public Edge(VertexModel source,VertexModel destination){
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
    
    public VertexModel getDestination(){
        return destination;
    }
    
    public void increaseWeighting()
    {
        weighting++;
    }

    public int getWeighting()
    {
        return this.weighting;
    }
    
    public void printEdge()
    {
        System.out.println("Weighting: " + this.weighting);
        System.out.println("Source label: " + this.source.getLabel());
        System.out.println("Source type: " + this.source.getType());
        System.out.println("Destination label: " + this.destination.getLabel());
        System.out.println("Destination type: " + this.destination.getType());
        /*for(int i =0;i<slots.size();i++)
        {
            System.out.println("Slot "+ i + ": " + slots.get(i));
        }
        */
    }
            
}

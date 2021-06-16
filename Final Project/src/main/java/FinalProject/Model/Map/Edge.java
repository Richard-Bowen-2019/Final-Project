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
    Vertex source;
    Vertex destination;
    public Edge(Vertex source,Vertex destination){
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
    
    private void increaseWeighting()
    {
        weighting++;
    }

}

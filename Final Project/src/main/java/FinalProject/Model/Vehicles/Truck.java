/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinalProject.Model.Vehicles;

import FinalProject.Model.Map.Edge;
import FinalProject.Model.Map.Intersection;
import FinalProject.Model.Map.Node;
import java.util.LinkedList;

/**
 *
 * @author Richard
 */
public class Truck extends Vehicle{

    public Truck(LinkedList<Node> route) {
        super(route);
        this.Size = 3;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinalProject.Model.Vehicles;

import FinalProject.Model.Map.Edge;
import FinalProject.Model.Map.Node;
import static java.lang.Integer.max;
import java.util.concurrent.ThreadLocalRandom;
import FinalProject.Model.Map.Intersection;
import java.util.LinkedList;
/**
 *
 * @author Richard
 */
public class Vehicle {
    int Size;
    LinkedList<Node> route;
    
    public void setSize(int size) {
        this.Size = size;
    }

    public int getSize() {
        return Size;
    }
    
    public Vehicle(LinkedList<Node> route)
    {
        Size = 0;
        vehicleFactory(1 + (int)(Math.random() * 4),route);
    }
    
    public Vehicle vehicleFactory(int r,LinkedList<Node> route)
    {
        Vehicle v;
        switch(r){
                case 1:
                    v = new Car(route);
                    break;
                case 2:
                    v = new Van(route);
                    break;
                case 3:
                    v = new Truck(route);
                    break;
                default:
                    v = null;
                    break;
        }
        return v;
    }
    
}


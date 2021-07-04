/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinalProject.Model.Vehicles;

import FinalProject.Model.Map.Road;
import FinalProject.Model.Map.IntersectionVertex;
import static java.lang.Integer.max;
import java.util.concurrent.ThreadLocalRandom;
import FinalProject.Model.Map.Intersection;
/**
 *
 * @author Richard
 */
public class Vehicle {
    int Size;
    Intersection module;
    IntersectionVertex model;
    Road edge;
    
    public void setSize(int size) {
        this.Size = size;
    }

    public int getSize() {
        return Size;
    }
    
    public Vehicle(Intersection module,IntersectionVertex model, Road edge)
    {
        Size = 0;
        vehicleFactory(1 + (int)(Math.random() * 4));
        this.module = module;
        this.model = model;
        this.edge = edge;
    }
    
    public Vehicle vehicleFactory(int r)
    {
        Vehicle v;
        switch(r){
                case 1:
                    v = new Car(module,model,edge);
                    break;
                case 2:
                    v = new Van(module,model,edge);
                    break;
                case 3:
                    v = new Truck(module,model,edge);
                    break;
                default:
                    v = null;
                    break;
        }
        return v;
    }
    
}


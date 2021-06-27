/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinalProject.Model.Vehicles;

import static java.lang.Integer.max;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author Richard
 */
public class Vehicle {
    int Size;

    public void setSize(int size) {
        this.Size = size;
    }

    public int getSize() {
        return Size;
    }
    
    public Vehicle()
    {
        Size = 0;
        vehicleFactory(ThreadLocalRandom.current().nextInt(1, 4));
    }
    
    public Vehicle vehicleFactory(int r)
    {
        Vehicle v;
        switch(r){
                case 1:
                    v = new Car();
                    break;
                case 2:
                    v = new Van();
                    break;
                case 3:
                    v = new Truck();
                    break;
                default:
                    v = new Vehicle();
                    break;
        }
        return v;
    }
    
}


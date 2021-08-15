/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinalProject.Model.Vehicles;

import FinalProject.View.Vehicles.VehicleViewInterface;

/**
 *
 * @author Richard
 */
public abstract class VehicleModel {
    protected int size;
    protected int speed;
    
    public int getSize() {
        return size;
    }
    
    public int getSpeed() {
        return speed;
    }
    
    public void setSize(int vehicleSize) {
        this.size = vehicleSize;
    }
    
    public void getSpeed(int vehicleSpeed) {
        this.speed= vehicleSpeed;
    }
 }


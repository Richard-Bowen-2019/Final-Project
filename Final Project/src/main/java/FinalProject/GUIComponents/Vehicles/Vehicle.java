/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinalProject.GUIComponents.Vehicles;

/**
 *
 * @author Richard
 */
public class Vehicle {
    int position;

    public void setPosition(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }
    
    public Vehicle(int position)
    {
        this.position = position;
    }
    
}


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinalProject.View.Map;

import java.awt.Graphics;
import javax.swing.JPanel;
import FinalProject.View.Vehicles.VehicleViewInterface;

/**
 *
 * @author Richard
 */
public interface RoadViewInterface {
    
    void addVehicle(VehicleViewInterface view);
    void stepLeft();
    void stepRight();
    void stepUp(VehicleViewInterface view);
    void stepDown(VehicleViewInterface view);
    void step(int[] position);
    
}

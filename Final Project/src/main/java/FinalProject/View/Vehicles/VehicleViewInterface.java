/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinalProject.View.Vehicles;

import FinalProject.Model.Map.RoadModel;
import FinalProject.View.Map.ModuleView;
import java.awt.Graphics;

/**
 *
 * @author Richard
 */
public interface VehicleViewInterface {
    void paintComponent(Graphics g);
    public int getX();
    void setX(int x);
    public int getY();
    void setY(int x);
    VehicleViewInterface realign(String direction);
}

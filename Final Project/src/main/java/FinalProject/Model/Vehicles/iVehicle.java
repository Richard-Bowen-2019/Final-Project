/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinalProject.Model.Vehicles;

import FinalProject.Model.Map.Node;
import FinalProject.Model.Map.Edge;
import java.util.LinkedList;

/**
 *
 * @author Richard
 */
public interface iVehicle {
   void setSize(int n);
   int getSize();
   void startPosition(Edge r);
   void move();   
}

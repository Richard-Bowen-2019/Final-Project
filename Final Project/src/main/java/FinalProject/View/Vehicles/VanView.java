/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinalProject.View.Vehicles;

import java.awt.Graphics;

/**
 *
 * @author Richard
 */
public class VanView extends VehicleView implements VehicleViewInterface{
    public VanView()
    {
        super();
    }

    @Override
    public void paintMe(Graphics g) {
        System.out.println("paintv");
        g.drawRect(0, 0, 100, 200);
        //g.drawImage(images,x,y,null);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinalProject.View.Map;

import FinalProject.GlobalVariables;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Richard
 */
public class ModuleView extends JPanel{
    int xCoord;
    int yCoord;

    
    
    public ModuleView(int x, int y){
        this.xCoord = x;
        this.yCoord =y;
        this.setLayout(new GridLayout(3,3));  
        this.setSize(GlobalVariables.getModuleWidths(),GlobalVariables.getModuleHeights());
        this.setBorder(new EmptyBorder(0, -1, 0, -1));
        JPanel b1 = new RoadView("Blank");  
        JPanel b2= new RoadView("Vertical");  
        JPanel b3= new RoadView("Blank");  
        JPanel b4= new RoadView("Horizontal");  
        JPanel b5= new RoadView("Intersection");  
        JPanel b6= new RoadView("Horizontal");  
        JPanel b7= new RoadView("Blank");  
        JPanel b8= new RoadView("Vertical");  
        JPanel b9= new RoadView("Blank");  

        this.add(b1);
        this.add(b2);
        this.add(b3);
        this.add(b4);
        this.add(b5);  
        this.add(b6);
        this.add(b7);
        this.add(b8);
        this.add(b9);  
       
    }
    
    public int getxCoord() {
        return xCoord;
    }

    public int getyCoord() {
        return yCoord;
    }
}

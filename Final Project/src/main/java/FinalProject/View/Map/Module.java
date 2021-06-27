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
public class Module extends JPanel{
    
    
    public Module(){
    
    this.setLayout(new GridLayout(3,3));  
    this.setSize(150, 150);
    this.setBorder(new EmptyBorder(0, -1, 0, -1));
    JPanel b1 = new Road("Blank");  
    JPanel b2= new Road("Vertical");  
    JPanel b3= new Road("Blank");  
    JPanel b4= new Road("Horizontal");  
    JPanel b5= new Road("Intersection");  
    JPanel b6= new Road("Horizontal");  
    JPanel b7= new Road("Blank");  
    JPanel b8= new Road("Vertical");  
    JPanel b9= new Road("Blank");  
    
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
}

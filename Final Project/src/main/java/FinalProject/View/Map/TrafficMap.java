/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinalProject.View.Map;

import FinalProject.GUIDimensions;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JFrame;


/**
 *
 * @author Richard
 */
public class TrafficMap {
    JFrame frame;  
  
    public TrafficMap(){
        frame = new JFrame();
        frame.setBackground(Color.WHITE);
      
               
        
        
        
        
        for(int i = 0;i<50;i++)
        {
        frame.add(new Module());
        }
        
        GridLayout gl = new GridLayout(5,10);
        frame.setLayout(gl);
        gl.setVgap(-2);
        //setting grid layout of 3 rows and 3 columns  

        frame.setSize(GUIDimensions.getScreenSize());
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
       
        frame.setVisible(true);
    }
}

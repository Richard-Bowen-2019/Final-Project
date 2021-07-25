/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinalProject.View.Map;

import FinalProject.GlobalVariables;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JFrame;


/**
 *
 * @author Richard
 */
public class TrafficMapView {
    JFrame frame;  
    ArrayList<ArrayList<ModuleView>> mapGUI;
    public TrafficMapView(){
        frame = new JFrame();
        frame.setBackground(Color.WHITE);
        for(int i = 0;i<GlobalVariables.getVerticalModules();i++)
        {
            for(int j = 0;j<GlobalVariables.getHorizontalModules();j++)
            {
                frame.add(new ModuleView(i,j));
            }
        }
        
        GridLayout gl = new GridLayout(GlobalVariables.getVerticalModules(),GlobalVariables.getHorizontalModules());
        frame.setLayout(gl);
        gl.setVgap(-2);
        frame.setSize(GlobalVariables.getScreenSize());
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

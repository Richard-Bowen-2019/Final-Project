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
import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JPanel;


/**
 *
 * @author Richard
 */
public class TrafficMapView {
    private static TrafficMapView viewInstance = null;
    JFrame frame;  
    ArrayList<ArrayList<ModuleView>> mapGUI = new ArrayList<>();
    
    
    private TrafficMapView(){
        frame = new JFrame();
        frame.setBackground(Color.WHITE);
        GridLayout gl = new GridLayout(GlobalVariables.getVerticalModules(),GlobalVariables.getHorizontalModules());
        gl.setVgap(-2);
        
        for(int i = 0;i<GlobalVariables.getVerticalModules();i++)
        {
            ArrayList<ModuleView> view = new ArrayList<>();
            for(int j = 0;j<GlobalVariables.getHorizontalModules();j++)
            {
                ModuleView newModule = new ModuleView(i,j);
                frame.add(newModule);
                view.add(newModule);
            }
            mapGUI.add(view);
        }
        frame.setLayout(gl);
        frame.setSize(GlobalVariables.getScreenSize());
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    
    public static TrafficMapView getInstance()
    {
        if(viewInstance==null)
        {
            viewInstance = new TrafficMapView();
        }
        return viewInstance;
    }
    
    public ArrayList<ArrayList<ModuleView>> getGUIMap()
    {
        return mapGUI;
    }
    
    public void printGUI()
    {
        for(ArrayList<ModuleView> al : mapGUI)
        {
            for(ModuleView m : al)
            {
                System.out.println(m);
            }
        }
    }
    
    public ModuleView getModule(int[] position)
    {
       
        return mapGUI.get(position[1]).get(position[0]);
    }
}

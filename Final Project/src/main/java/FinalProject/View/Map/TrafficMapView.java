/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinalProject.View.Map;

import FinalProject.Resources.GlobalVariables;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

/**
 *
 * @author Richard
 */
public class TrafficMapView extends JFrame implements ActionListener{
    private static TrafficMapView viewInstance = null;
    
    ModuleView module;
    JMenuBar menuBar;
    JMenuItem adjustSeedRate;
    JMenuItem adjustSpeed;
    JMenuItem adjustMapSize;
    
    private TrafficMapView(){
        this.setBackground(Color.WHITE);
        this.setLayout(new BorderLayout());
        createMenuBar();
        this.setJMenuBar(menuBar);
        module = new ModuleView();
        this.add(module);
        this.setSize(GlobalVariables.getScreenSize());
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    
    public void emergencyProtocol()
    {
        module.setBackground(Color.red);
        this.setBackground(Color.yellow);
    }
    
    public static TrafficMapView getInstance()
    {
        if(viewInstance==null)
        {
            viewInstance = new TrafficMapView();
        }
        return viewInstance;
    }
    
    private void createMenuBar()
    {
            menuBar = new JMenuBar();
            JMenu menu = new JMenu("Adjust simulation parameters");
            adjustSeedRate = new JMenuItem("Adjust Seeding rate");
            adjustSeedRate.addActionListener(this);
            adjustSpeed = new JMenuItem("Adjust Simulation Speed");
            adjustSpeed.addActionListener(this);
            adjustMapSize = new JMenuItem("Adjust Map Size");
            adjustMapSize.addActionListener(this);
            menu.add(adjustSeedRate);
            menu.add(adjustSpeed);
            menu.add(adjustMapSize);
            menuBar.add(menu);
    }
     
   
    public ModuleView getModule()
    {
        return module;
    }

    public boolean stringInteger(String s)
    {
        try
        {
            Integer.parseInt(s);
        }
        catch (Exception e)
        {
            return false;
        }
        return true;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String name;
        if(e.getSource()==adjustSeedRate)
        {
            name = JOptionPane.showInputDialog(this,
                        "Please enter a new Seed Rate", null);
            if(stringInteger(name))
            {
                 GlobalVariables.setSeedRate(Integer.parseInt(name));
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Please enter an Integer value","Test",
                JOptionPane.WARNING_MESSAGE);
            }
           
        }
        if(e.getSource()==adjustSpeed)
        {
            name = JOptionPane.showInputDialog(this,
                        "Please enter a new Speed", null);
            if(stringInteger(name))
            {
                 GlobalVariables.setSpeed(Integer.parseInt(name));
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Please enter an Integer value","Test",
                JOptionPane.WARNING_MESSAGE);
            }
        }
        else
        {
            name = "";
        }
    }
}

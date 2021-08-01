/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinalProject.View.Map;

import FinalProject.GlobalVariables;
import FinalProject.Model.Map.TrafficMapModel;
import java.awt.GridLayout;
import java.util.HashMap;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Richard
 */
public class ModuleView extends JPanel{
    int xCoord;
    int yCoord;
    TrafficMapModel model;
    RoadViewInterface north = new VerticalRoadView();
    RoadViewInterface west = new HorizontalRoadView();
    RoadViewInterface intersection = new IntersectionRoadView();
    RoadViewInterface east = new HorizontalRoadView();
    RoadViewInterface south = new VerticalRoadView();
    
    HashMap<String,RoadViewInterface> roads = new HashMap<>();
    
    public ModuleView(int x, int y){
        addJPanels();
        addRoads();
        this.xCoord = x;
        this.yCoord =y;
        this.setLayout(new GridLayout(3,3));  
        this.setBorder(new EmptyBorder(-2, -2,-2, -2));
    }
    
    private void addJPanels()
    {
        this.add(new Blank());
        this.add((JPanel)north);
        this.add(new Blank());
        this.add((JPanel)west);
        this.add((JPanel)intersection);
        this.add((JPanel)east);
        this.add(new Blank());
        this.add((JPanel)south);
        this.add(new Blank());
    }
    
    private void addRoads()
    {
        
        roads.put("North",north);
        roads.put("West",west);
        roads.put("Intersection",intersection);
        roads.put("East",east);
        roads.put("South",south);
    }
    
    public RoadViewInterface getRoad(String road)
    {
        return roads.get(road);
    }
    
    public int getxCoord() {
        return xCoord;
    }

    public int getyCoord() {
        return yCoord;
    }    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinalProject.Controller;

import FinalProject.Controller.Map.RoutePlanner;
import FinalProject.Model.Map.VertexModel;
import FinalProject.Model.Map.TrafficMapModel;
import FinalProject.Model.Vehicles.VehicleModel;
import FinalProject.Model.Vehicles.VehicleFactory;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 *
 * @author Richard
 */
public class Controller {
    TrafficMapModel tmp;
    protected RoutePlanner planner = new RoutePlanner();
    public List<VehicleModel> vehicles = new CopyOnWriteArrayList<>();
    List<VertexModel> aStar;
    
    public Controller() throws InterruptedException
    {
        tmp = TrafficMapModel.getMapInstance();
    }
    
    public void update()
    {
        Iterator<VehicleModel> it = vehicles.iterator(); 
        
        while (it.hasNext()) 
        {
            it.next().getController().moveVehicle();
        }
    }
    
    public void createNewVehicle() throws InterruptedException
    {
        VehicleModel newVehicle;
        VehicleFactory factory = new VehicleFactory();
        newVehicle = factory.getVehicle(1, getRoute());
        vehicles.add(newVehicle);
    }
    
    public List<VertexModel> getRoute()
    {
        VertexModel start = startPoint();
        VertexModel end = endPoint();
        aStar = planner.aStar(start, end);
        return aStar;
    }
    
    public boolean vehicleListEmpty()
    {
        return vehicles.size()==0;
    }

    public int vehicleListSize()
    {
        return vehicles.size();
    }
    
    public void removeVehicle(VehicleModel v)
    {
        vehicles.remove(v);
    }

    public int randomNumber()
    {
        return (int)(Math.random()*3);
    }  
    
    public int randomNode(int start,int end)
    {
        int r = start + (int)(Math.random()*(end-start+1));
        return r;
    }

    public VertexModel startPoint()
    {

        int startPoint = randomNode(0,tmp.getEntryNodes().size()-1);
        return tmp.getEntryNodes().get(startPoint);
    }

    public VertexModel endPoint()
    {
        int endPoint = randomNode(0,tmp.getExitNodes().size()-1);
        return tmp.getExitNodes().get(endPoint);
    }
}

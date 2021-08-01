/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinalProject.Controller;

import FinalProject.Controller.Vehicle.RoutePlanner;
import FinalProject.Model.Map.VertexModel;
import FinalProject.Model.Map.TrafficMapModel;
import FinalProject.Model.Vehicles.VehicleModel;
import FinalProject.Model.Vehicles.VehicleFactory;
import FinalProject.View.Map.TrafficMapView;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 *
 * @author Richard
 */
public class Controller {
    private static Controller mainController = null;
    TrafficMapModel mapModel;
    TrafficMapView mapView;
    protected RoutePlanner planner = new RoutePlanner();
    public List<VehicleModel> vehicles = new CopyOnWriteArrayList<>();
    
    private Controller() throws InterruptedException 
    {
        mapModel = TrafficMapModel.getMapInstance();
        mapView = TrafficMapView.getInstance();
    }
    
    public static Controller getControllerInstance() throws InterruptedException
    {
        if(mainController==null)
        {
            mainController = new Controller();
        }
        return mainController;
    }
    
    public void update()
    {
        /*Iterator<VehicleModel> it = vehicles.iterator(); 
        
        while (it.hasNext()) 
        {
            it.next().getController().moveVehicle();
        }*/
    }
    
    public void createNewVehicle() throws InterruptedException, IOException, URISyntaxException
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
        List<VertexModel> aStar = planner.aStar(start, end);
        return aStar;
    }
    
    public boolean vehicleListEmpty()
    {
        return vehicles.isEmpty();
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

        int startPoint = randomNode(0,mapModel.getEntryNodes().size()-1);
        return mapModel.getEntryNodes().get(startPoint);
    }

    public VertexModel endPoint()
    {
        int endPoint = randomNode(0,mapModel.getExitNodes().size()-1);
        return mapModel.getExitNodes().get(endPoint);
    }
}

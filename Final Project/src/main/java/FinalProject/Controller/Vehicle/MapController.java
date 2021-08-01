/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinalProject.Controller.Vehicle;

import FinalProject.Controller.Controller;
import FinalProject.Controller.Vehicle.aVehicle;
import FinalProject.Controller.iController;
import FinalProject.GlobalVariables;
import FinalProject.Model.Map.TrafficMapModel;
import FinalProject.Model.Map.VertexModel;
import FinalProject.Model.Vehicles.VehicleModel;
import FinalProject.View.Map.HorizontalRoadView;
import FinalProject.View.Map.RoadViewInterface;
import FinalProject.View.Map.TrafficMapView;
import FinalProject.View.Vehicles.VehicleViewInterface;
import java.util.List;


/**
 *
 * @author Richard
 */
public class MapController extends aVehicle implements iController
{
    private MapController controller = null;
    
    private MapController(List<VertexModel> route, VehicleModel current) throws InterruptedException
    {
        mapView = TrafficMapView.getInstance();
        this.rvi = mapView.getModule(currentVertex.getPosition()).getRoad(currentVertex.getLabel());
        this.vehicleView = currentVehicle.getView();
    }

    public MapController getMapInstance(List<VertexModel> route, VehicleModel current) throws InterruptedException
    {
        if(controller ==null)
        {
            controller = new MapController(route, current);
        }
        return controller;
    }
    
     
    
    
    public void moveView() 
    {
        switch(currentRoad.getSource().getLabel())
        {
                case "West":
                    if(currentRoad.getSource().getType()=="Out")
                    {
                        rvi.stepLeft();
                        break;
                    }
                    else
                    {
                        rvi.stepRight();
                        break;
                    }
                case "East":
                    if(currentRoad.getSource().getType()=="Out")
                    {
                        rvi.stepRight();
                        break;
                    }
                    else
                    {
                        rvi.stepLeft();
                        break;
                    }
                case "North":
                    if(currentRoad.getSource().getType()=="Out")
                    {
                        rvi.stepUp(vehicleView);
                        break;
                    }
                    else
                    {
                        rvi.stepDown(vehicleView);
                        break;
                    }
                case "South":
                    if(currentRoad.getSource().getType()=="Out")
                    {
                        rvi.stepDown(vehicleView);
                        break;
                    }
                    else
                    {
                        rvi.stepUp(vehicleView);
                        break;
                    }
        
                default:
                    break;
        }
        switch(currentRoad.getDestination().getLabel())
        {
                case "West":
                    if(currentRoad.getSource().getType()=="Out")
                    {
                        rvi.stepLeft();
                    }
                    break;
                case "East":
                    if(currentRoad.getSource().getType()=="Out")
                    {
                        rvi.stepRight();
                    }
                    break;
                case "North":
                    if(currentRoad.getSource().getType()=="Out")
                    {
                        rvi.stepUp(vehicleView);
                    }
                    break;
                case "South":
                    if(currentRoad.getSource().getType()=="Out")
                    {
                        rvi.stepDown(vehicleView);
                    }
                    break;
                default:
                    break;
        }
            
    }

    @Override
    public void move() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}


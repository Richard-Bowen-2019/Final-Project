/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinalProject.Controller.VehicleController.VehicleControllers;

import FinalProject.Controller.MainController;
import FinalProject.Model.Map.RoadModel;
import FinalProject.Model.Map.TrafficMapModel;
import FinalProject.Model.Map.VertexModel;
import FinalProject.Model.Vehicles.VehicleModel;
import FinalProject.Resources.GV;
import FinalProject.View.Map.ModuleView;
import FinalProject.View.Map.TrafficMapView;
import FinalProject.View.Vehicles.VehicleView;
import FinalProject.View.Vehicles.VehicleViewInterface;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Richard
 */
public class VehicleController {
    // Controllers
    MainController mainController;
    
    //Model and view
    TrafficMapModel mapModel;
    TrafficMapView mapView;
    VehicleModel vehicleModel;
    ModuleView moduleView;
    VehicleViewInterface vehicleViewInterface;
    
    //Global variables
    int moduleHeight;
    int moduleWidth;
    
    // position variables
    int currentSlot;
    VertexModel currentVertex;
    VertexModel nextVertex;
    List<VertexModel> route;
    RoadModel currentRoad;
    int currentSlotSize;
    HashMap<String,int[]> viewStartingPositions;
    int currentMove = 0;
    HashMap<String, int[]> moves;
    int secondPosition = 1;
    
    public VehicleController() throws InterruptedException
    {
        this.mainController = MainController.getControllerInstance();
        this.mapModel = TrafficMapModel.getMapInstance();
        this.mapView = TrafficMapView.getInstance();
        moduleHeight = GV.getModuleHeights();
        moduleWidth = GV.getModuleWidths();
        createViewPositions();
        setMoves();
    }
    
    public void setUpFirst()
    {
        this.currentSlot = 0;
        this.currentVertex = route.get(0);
        this.currentRoad = currentVertex.getIn();
        this.currentSlotSize = currentRoad.getSlotSize();
        this.moduleView = mapView.getModule(mapModel.getModulePositionFromVertexModel(currentVertex));
        int[] startingPosition = viewStartingPositions.get(currentVertex.getLabel()+"-"+currentVertex.getType());
        moduleView.addVehicle(vehicleViewInterface, startingPosition);
        currentRoad.increaseWeighting();
    }
    
    public void setUpNext()
    {
        if(secondPosition==2)
        {
            this.currentSlot = 0;
            this.nextVertex = route.get(1);
            this.currentRoad = currentVertex.getRoad(currentVertex, nextVertex);
            this.currentSlotSize = currentRoad.getSlotSize();
        }
        else
        {
            route.remove(currentVertex);
            currentVertex=route.get(0);
            if(route.size()>1)
            {
                this.currentSlot = 0;
                this.nextVertex = route.get(1);
                this.currentRoad = currentVertex.getRoad(currentVertex, nextVertex);
                this.currentSlotSize = currentRoad.getSlotSize();
            }
        }
    }
    
    
    public void setUpLast()
    {
        currentSlot = 0;
        this.currentRoad = currentVertex.getOut();
        this.currentSlotSize = currentRoad.getSlotSize();
        route.remove(currentVertex);
    }
    
    public void move() 
    {
        if(!mainController.vehicleListEmpty())
        {
            if(currentSlot<currentSlotSize)
            {
                if(currentSlot==0)
                {
                    currentRoad.occupySlot(0,vehicleModel);
                    currentSlot++;
                    moduleView.move(vehicleViewInterface, movePosition());
                }
                else
                {
                    currentRoad.occupySlot(currentSlot,vehicleModel);
                    currentRoad.vacateSlot(currentSlot-1);
                    currentSlot++;
                    if(currentRoad.getType()=="Connecting"&&currentSlot==5)
                    {
                        moduleView.removeVehicle(vehicleViewInterface);
                        this.moduleView = mapView.getModule(mapModel.getModulePositionFromVertexModel(nextVertex));
                        int[] startingPosition = viewStartingPositions.get(nextVertex.getLabel()+"-"+nextVertex.getType());
                        moduleView.addVehicle(vehicleViewInterface, startingPosition);
                    }
                    moduleView.move(vehicleViewInterface, movePosition());
                }
            }
            else
            {
                if(route.size()==1)
                {
                    setUpLast();
                }
                else if (route.size()==0)
                {
                    mainController.removeVehicle(vehicleModel);
                }
                else
                {
                    secondPosition++;
                    setUpNext();
                }
            }
            currentVertex.printVertex();
            System.out.println("Current position: "+ currentSlot);
        }
        else
        {
            System.out.println("No Current vehicles");
        }
    }

    
    
    private void createViewPositions()
    {
        viewStartingPositions = new HashMap<>();
        int moduleWidth = GV.getModuleWidths();
        int moduleHeight = GV.getModuleHeights();
        int[] northIn = {moduleWidth*125/256,-moduleHeight*5/64};
        int[] northOut = {0,0};
        int[] westIn = {-moduleWidth*5/16,moduleHeight*3/11};
        int[] westOut = {0,0};
        int[] southIn = {moduleWidth*5/16,moduleHeight*55/60};
        int[] southOut = {0,0};
        int[] eastIn = {moduleWidth*15/16,moduleHeight*51/110};
        int[] eastOut = {0,0};
        viewStartingPositions.put("North-In",northIn);
        viewStartingPositions.put("North-Out",northOut);
        viewStartingPositions.put("East-In",eastIn);
        viewStartingPositions.put("East-Out",eastOut);
        viewStartingPositions.put("South-In",southIn);
        viewStartingPositions.put("South-Out",southOut);
        viewStartingPositions.put("West-In",westIn);
        viewStartingPositions.put("West-Out",westOut);
    }
    
    public int[] movePosition()
    {
        int[] move = new int[2];
        String moveTypeCurrent = currentVertex.getLabel()+"-"+currentVertex.getType();
        System.out.println("Current road Type: " + currentRoad.getType());
        if(currentRoad.getType()=="Entry"||currentRoad.getType()=="Exit")
        {
            move = moves.get(moveTypeCurrent);
        }
        else if(currentRoad.getType()=="Intersection")
        {
            String moveTypeNext = nextVertex.getLabel()+"-"+nextVertex.getType();
            move[0] = (nextVertex.getVertex(moveTypeNext)[0] - currentVertex.getVertex(moveTypeCurrent)[0])*3;
            move[1] = (nextVertex.getVertex(moveTypeNext)[1] - currentVertex.getVertex(moveTypeCurrent)[1])*3;
        }
        else
        {
            move = moves.get(moveTypeCurrent);
            for(int i : move)
            {
                i = i*-1; 
            }
        }
        return move;
    }
    
    public void setMoves()
    {
        moves = new HashMap<>();
        int moduleWidth = GV.getModuleWidths();
        int moduleHeight = GV.getModuleHeights();
              
        int[] northIn = {0,moduleHeight*4/72};
        int[] westIn = {moduleWidth*4/72,0};
        int[] southIn = {0,-moduleHeight*4/72};
        int[] eastIn = {-moduleWidth*4/72,0};
        int[] northOut = {0,-moduleHeight*4/72};
        int[] westOut = {-moduleWidth*4/72,0};
        int[] southOut = {0,moduleHeight*4/72};
        int[] eastOut = {moduleWidth*4/72,0};
        
        moves.put("North-In",northIn);
        moves.put("North-Out",northOut);
        moves.put("East-In",eastIn);
        moves.put("East-Out",eastOut);
        moves.put("South-In",southIn);
        moves.put("South-Out",southOut);
        moves.put("West-In", westIn);
        moves.put("West-Out",westOut);
    }
}

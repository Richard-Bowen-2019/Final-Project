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
import FinalProject.Resources.GlobalVariables;
import FinalProject.View.Map.ModuleView;
import FinalProject.View.Map.TrafficMapView;
import FinalProject.View.Vehicles.VehicleViewInterface;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Richard Bowen
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
    String type;

    
    
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
    HashMap<String,double[]> viewPositions;
    int currentMove = 0;
    HashMap<String, double[]> moves;
    int secondPosition = 1;
    
    /**
    * Constructor of the vehicle controller class, this sets up the views,the 
 models, the move parameters for the vehicle view and the starting startPosition
 of the vehicles
    * 
    * 
    * @param     None
    * @return    None
    */
    //
    public VehicleController() throws InterruptedException
    {
        this.mainController = MainController.getControllerInstance();
        this.mapModel = TrafficMapModel.getMapInstance();
        this.mapView = TrafficMapView.getInstance();
        moduleHeight = GlobalVariables.getModuleHeights();
        moduleWidth = GlobalVariables.getModuleWidths();
        setMoves();
        this.moduleView = mapView.getModule();
    }
    
    /**
    * This methods sets the entry road behaviour. As the route is composed of
    * vertexModel rather than nodes, the first one needs to be set up to start
    * from the null position VertexMOdel.
    * 
    * @param     None
    * @return    None
    */
    //
    public void setUpFirst()
    {
        this.currentSlot = 0;
        this.currentVertex = route.get(0);
        this.currentRoad = currentVertex.getIn();
        this.currentSlotSize = currentRoad.getSlotSize();
        createVehicleViewStartingPositions();
        double[] startingPosition = getStartingPositions(currentVertex.getLabel()+"-"+currentVertex.getType());
        moduleView.addVehicle(vehicleViewInterface, startingPosition);
        currentRoad.increaseWeighting();
    }
    
    /**
    * This methods sets up all of the next roads adding and removing Vertexmodel
    * from the model
    * 
    * @param     None
    * @return    None
    */
    //
    public void setUpNext()
    {
        if(secondPosition==2)
        {
            currentRoad.decreaseWeighting();
            this.currentSlot = 0;
            this.nextVertex = route.get(1);
            this.currentRoad = currentVertex.getRoad(currentVertex, nextVertex);
            this.currentSlotSize = currentRoad.getSlotSize();
            currentRoad.increaseWeighting();
        }
        else
        {
            currentRoad.decreaseWeighting();
            route.remove(currentVertex);
            currentVertex=route.get(0);
            if(route.size()>1)
            {
                this.currentSlot = 0;
                this.nextVertex = route.get(1);
                this.currentRoad = currentVertex.getRoad(currentVertex, nextVertex);
                this.currentSlotSize = currentRoad.getSlotSize();
                currentRoad.increaseWeighting();
            }
        }
    }
    
    /**
    * This methods sets the exit road behaviour. This sets up the road to the
    * exit null vertex.
    * 
    * @param     None
    * @return    None
    */
    //
    public void setUpLast()
    {
        currentRoad.increaseWeighting();
        currentSlot = 0;
        this.currentRoad = currentVertex.getOut();
        this.currentSlotSize = currentRoad.getSlotSize();
        route.remove(currentVertex);
    }
    
    /**
    * This is the main method of the controller, it is responsible for
    * moving traffic through the model as well as on the graphical interface
    * 
    * @param     None
    * @return    None
    */
    //
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
                    currentRoad.decreaseWeighting();
                    moduleView.removeVehicle(vehicleViewInterface);
                    
                }
                else
                {
                    secondPosition++;
                    setUpNext();
                }
            }
        }
        else
        {
            System.out.println("No Current vehicles");
        }
    }
    
    /**
    * This method offsets the starting position based on where the starting 
    * position on the map is
    * 
    * @param     None
    * @return    int offset starting position
    */
    //
    public double[] getStartingPositions(String start)
    {
        int[] modulePosition = currentVertex.getPosition();
        double[] startPosition = viewPositions.get(start);
        startPosition[0] = startPosition[0] + modulePosition[0]*moduleWidth;
        startPosition[1] = startPosition[1] + modulePosition[1]*moduleWidth;
        return startPosition;
    }
    
    /**
    * This creates the HashMap of starting startPosition for vehicles
    * 
    * @param     None
    * @return    None
    */
    //
    private void createVehicleViewStartingPositions()
    {
        viewPositions = new HashMap<>();
        moduleWidth = GlobalVariables.getModuleWidths();
        moduleHeight = GlobalVariables.getModuleHeights();
        double[] northIn = {moduleWidth/2,0};
        double[] westIn = {-moduleWidth/9,moduleHeight*3.5/11};
        double[] southIn = {moduleWidth*7/24,-moduleHeight*5/18};
        double[] eastIn = {moduleWidth,moduleHeight*47/110};
        viewPositions.put("North-In",northIn);
        viewPositions.put("East-In",eastIn);
        viewPositions.put("South-In",southIn);
        viewPositions.put("West-In",westIn);
    }
    
    /**
    * This methods sets the move behaviour. it dictates the cartesian coordinates
    * that the view should be moved to next with reference to the current position
    * 
    * @param     None
    * @return    int[] of the move the vehicle should make
    */
    //
    public double[] movePosition()
    {
        double[] move = new double[2];
        String moveTypeCurrent = currentVertex.getLabel()+"-"+currentVertex.getType();
        if(currentRoad.getType()=="Entry"||currentRoad.getType()=="Exit")
        {
            move = moves.get(moveTypeCurrent);
        }
        else if(currentRoad.getType()=="Intersection")
        {
            String moveTypeNext = nextVertex.getLabel()+"-"+nextVertex.getType();
            move[0] = (nextVertex.getVertex(moveTypeNext)[0] - currentVertex.getVertex(moveTypeCurrent)[0])*5;
            move[1] = (nextVertex.getVertex(moveTypeNext)[1] - currentVertex.getVertex(moveTypeCurrent)[1])*5;
        }
        else
        {
            move = moves.get(moveTypeCurrent);
            for(double i : move)
            {
                i = i*-1; 
            }
        }
        return move;
    }
    
    /**
    * This methods creates the hashmap of the moves that a vehicles make
    * based on its current Vertex
    * 
    * @param     None
    * @return    int[] of the move the vehicle should make
    */
    //
    public void setMoves()
    {
        moves = new HashMap<>();
        double verticalMove = (int) Math.round(GlobalVariables.getModuleHeights()/13);
        double horizontalMove = (int) Math.round(GlobalVariables.getModuleWidths()/13);
        
        double[] northIn = {0,verticalMove};
        double[] northOut = {0,-verticalMove};
        double[] southIn = {0,-verticalMove};
        double[] southOut = {0,verticalMove};
        
        double[] eastIn = {-horizontalMove,0};
        double[] westOut = {-horizontalMove,0};
        double[] eastOut = {horizontalMove,0};
        double[] westIn = {horizontalMove,0};
        
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

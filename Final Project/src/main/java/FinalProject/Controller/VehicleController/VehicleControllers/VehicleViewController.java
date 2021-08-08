/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinalProject.Controller.VehicleController.VehicleControllers;

import FinalProject.Controller.VehicleController.VehicleControllers.VehicleModelController;
import FinalProject.Controller.iController;

import FinalProject.Resources.GV;

import java.util.HashMap;



/**
 *
 * @author Richard
 */
public class VehicleViewController extends VehicleModelController implements iController{
    
    public VehicleViewController() throws InterruptedException
    {
        positions = new HashMap<>();
        createHashPositions();
    }
    
    private void createHashPositions()
    {
        int moduleWidth = GV.getModuleWidths();
        int moduleHeight = GV.getModuleHeights();
        System.out.println(moduleHeight);
        System.out.println(moduleWidth);        
        int[] northIn = {125,-20};
        int[] northOut = {0,0};
        int[] westIn = {-100,moduleHeight*3/11};
        int[] westOut = {0,0};
        int[] southIn = {80,-100};
        int[] southOut = {0,0};
        int[] eastIn = {0,moduleHeight*47/110};
        int[] eastOut = {0,0};
        positions.put("North-In",northIn);
        positions.put("North-Out",northOut);
        positions.put("East-In",eastIn);
        positions.put("East-Out",eastOut);
        positions.put("South-In",southIn);
        positions.put("South-Out",southOut);
        positions.put("West-In",westIn);
        positions.put("West-Out",westOut);
    }
    
    public void moveView()
    {
        int[] move;
        if(this.currentMove<11)
        {
            move = navigateFirst();
        }
        else if(this.currentMove > 13)
        {
            move = navigateLast();
        }
        else
        {
            System.out.println("Intersection");
            move = navigateIntersection();
        }
        if(currentMove==22)
        {
            currentMove = 0;
        }
        moduleView.move(vehicleView, move);
        currentMove++;
    }
    
    public int[] navigateFirst()
    {
        int[] move = new int[2];
        switch(currentVertex.getLabel())
        {
            case "North":
                move[0]= 0;
                move[1] = 6;
                break;
            case "South":
                move[0]= 0;
                move[1] = -6;
                break;
            case "East":
                move[0]= -6;
                move[1] = 0;
                break;
            case "West":
                move[0]= 6;
                move[1] = 0;
                break;
            default:
                break;
        }
       
        return move;
    }    
        
    public int[] navigateIntersection()
    {
        int[] move = new int[2];
        switch(currentVertex.getLabel())
        {
            case "North":
                switch(nextVertex.getLabel())
                {
                    case "South":
                        System.out.println("hit");
                        move[0] = 0;
                        move[1] = 6;
                        break;
                    case "East":
                        move[0] = 4;
                        move[1] = 4;
                        break;
                    case "West":
                        move[0] = -4;
                        move[1] = 4;
                        break;
                    default:
                        break;
                }
                break;
            case "South":
                switch(nextVertex.getLabel())
                {
                    case "North":
                        move[0] = 0;
                        move[1] = -10;
                        break;
                    case "East":
                        move[0] = 10;
                        move[1] = -10;
                        break;
                    case "West":
                        move[0] = -10;
                        move[1] = -10;
                        break;
                    default:
                        break;
                }
                break;
            case "East":
                switch(nextVertex.getLabel())
                {
                    case "North":
                        move[0] = -10;
                        move[1] = -10;
                        break;
                    case "South":
                        move[0] = -10;
                        move[1] = 10;
                        break;
                    case "West":
                        move[0] = -10;
                        move[1] = 0;
                        break;
                    default:
                        break;
                }
                break;
            case "West":
                switch(nextVertex.getLabel())
                {
                    case "North":
                        move[0] = 10;
                        move[1] = -10;
                        break;
                    case "East":
                        move[0] = 10;
                        move[1] = 0;
                        break;
                    case "South":
                        move[0] = 10;
                        move[1] = 10;
                        break;
                    default:
                        break;    
                }
                break;
            default:
                break;
        }
        System.out.println(move[0] + "-"+move[1]);
        
        return move;
    }
        
    public int[] navigateLast()
    {
        int[] move = new int[2];
        switch(nextVertex.getLabel())
        {
            case "North":
                move[0]= 0;
                move[1] = 10;
                break;
            case "South":
                move[0]= 0;
                move[1] = 6;
                break;
            case "East":
                move[0]= 5;
                move[1] = 0;
                break;
            case "West":
                move[0]= -5;
                move[1] = 0;
                break;
            default:
                break;
        }
        return move;
    }
        
    @Override
    public void EmergencyVehicle() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void move() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

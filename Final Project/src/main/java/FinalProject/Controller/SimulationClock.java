/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinalProject.Controller;


import FinalProject.Controller.Vehicle.VehicleController;
import FinalProject.Model.Map.TrafficMapModel;
import java.awt.List;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;





/**
 *
 * @author Richard
 */
public class SimulationClock {
   private static SimulationClock clock = null;
    boolean running;
    int n=0;
    Timer timer;
    int counter = 0;
    VehicleController controller;
   
    private SimulationClock() throws InterruptedException {
        
        start();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                // System.out.println("TimerTask executing counter is: " + counter);
                
            }
        };

        //create thread to print counter value
        Thread t = new Thread(new Runnable() 
        {
            @Override
            public void run() 
            {
                try {
                    createNewVehicle();
                } catch (InterruptedException ex) {
                    Logger.getLogger(SimulationClock.class.getName()).log(Level.SEVERE, null, ex);
                }
                while(true) 
                {
                    try 
                    {
                        if(counter%10==0||controller==null)
                        {
                            createNewVehicle();
                        }
                        else
                        {
                            update();
                        }
                        Thread.sleep(1000);
                    } 
                    catch (InterruptedException ex) 
                    {
                        ex.printStackTrace();
                    }
                    counter++;
                }
            }
        });

        timer = new Timer();
        timer.scheduleAtFixedRate(timerTask, 30, 3000);//start timer in 30ms to increment  counter
        
        
        t.start();//start thread to display counter
    }
    
    public static SimulationClock getClockInstance() throws InterruptedException {
        if(clock==null)
        {
            clock = new SimulationClock();
        }
        return clock;
    }
    public void createNewVehicle() throws InterruptedException
    {
        if(controller==null)
        {
            controller = new VehicleController();
        }
        else
        {
            controller.seedVehicle();
        }
    }
    
    public void update()
    {
        controller.update();
    }
    
    public void start()
    {
        running = true;
    }
   
    public boolean isRunning()
    {
        return running;
    }
   
   } 	
    



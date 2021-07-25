/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinalProject.Controller;


import FinalProject.GlobalVariables;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Richard
 */
public class SimulationClock {
   private static SimulationClock clock = null;
    boolean running;
    Timer timer;
    Controller controller;
    int counter = 0;
    
    private SimulationClock() throws InterruptedException 
    {
        
        start();
        int seedRate = GlobalVariables.getSeedRate();
        controller = new Controller();
        TimerTask timerTask = new TimerTask() 
        {
            @Override
            public void run() {
                // System.out.println("TimerTask executing counter is: " + counter);
            }
        };

        Thread t = new Thread(new Runnable() 
        {
            @Override
            public void run() 
            {
                try 
                {
                    while(true) 
                    {
                    
                        if(counter%seedRate==0)
                        {
                            controller.createNewVehicle();
                        }
                        else
                        {
                            controller.update();
                        }
                        Thread.sleep(1000);
                        counter++; 
                    }    
                } 
                catch (InterruptedException ex) 
                {
                    Logger.getLogger(SimulationClock.class.getName()).log(Level.SEVERE, null, ex);
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
    
    public void start()
    {
        running = true;
    }
   
    public boolean isRunning()
    {
        return running;
    }
   
   } 	
    



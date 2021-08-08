/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinalProject.Controller;

import FinalProject.Controller.VehicleController.VehicleControllers.VehicleModelController;
import FinalProject.Model.Map.VertexModel;
import FinalProject.Model.Map.TrafficMapModel;
import FinalProject.Model.Vehicles.VehicleModel;
import FinalProject.Controller.VehicleController.VehicleControllers.VehicleControllerFactory;
import FinalProject.Resources.GV;
import FinalProject.View.Map.TrafficMapView;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Richard
 */
public class MainController {
    private static MainController controller = null;
    TrafficMapModel mapModel;
    TrafficMapView mapView;
    private AStarRoute planner;
    private List<VehicleModelController> masterVehicleList;
    int counter;
    Timer timer;
    
    private MainController() throws InterruptedException 
    {
        mapModel = TrafficMapModel.getMapInstance();
        mapView = TrafficMapView.getInstance();
        planner = new AStarRoute();
        masterVehicleList = new CopyOnWriteArrayList<>();
        int seedRate = GV.getSeedRate();
        
        
        TimerTask timerTask = new TimerTask() 
        {
            @Override
            public void run() 
            {
                System.out.println();
            }
        };
        
        Thread t = new Thread(new Runnable() 
        {
            @Override
            public void run() 
            {
                boolean run = true;
                try 
                {
                    while(true) 
                    {
                    
                        if(counter%seedRate==0&&run)
                        {
                            createNewVehicle();
                            run=false;
                        }
                        else
                        {
                            update();
                        }
                        Thread.sleep(1000);
                        counter++; 
                    }    
                } 
                catch (InterruptedException | IOException | URISyntaxException ex) 
                {
                    Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
                    Thread.currentThread().interrupt();
                }
            }
        });
        timer = new Timer();
        timer.scheduleAtFixedRate(timerTask, 30, 3000);
        t.start();
    }
    
    public static MainController getControllerInstance() throws InterruptedException
    {
        if(controller==null)
        {
            controller = new MainController();
        }
        return controller;
    }
    
    private void update()
    {
        Iterator<VehicleModelController> it = masterVehicleList.iterator(); 
        
        while (it.hasNext()) 
        {
            it.next().move();
        }
    }
    
    private void createNewVehicle() throws InterruptedException, IOException, URISyntaxException
    {
        VehicleModelController newVehicle;
        VehicleControllerFactory factory = new VehicleControllerFactory();
        newVehicle = factory.getVehicle(1, getRoute());
        masterVehicleList.add(newVehicle);
    }
    
    private List<VertexModel> getRoute()
    {
        VertexModel start = mapModel.getMap().get(0).get(0).getVertex("North", "In");
        VertexModel end = mapModel.getMap().get(5).get(9).getVertex("South", "Out");
        //VertexModel start = newEntryorExitPoint("Entry");
        //VertexModel end = newEntryorExitPoint("Exit");
        List<VertexModel> aStar = planner.aStar(start, end);
        return aStar;
    }
    
    public boolean vehicleListEmpty()
    {
        return masterVehicleList.isEmpty();
    }

    public int vehicleListSize()
    {
        return masterVehicleList.size();
    }
    
    public void removeVehicle(VehicleModel v)
    {
        masterVehicleList.remove(v);
    }

    private int RandomVehicle()
    {
        int r = new Random().nextInt(4);
        return r;
    }
    
    private int randomNode(int start,int end)
    {
        int r = new Random().nextInt(end-start+1);
        return r;
    }

    private VertexModel newEntryorExitPoint(String type)
    {
        if(type=="Entry")
        {
            return mapModel.getEntryNodes().get(randomNode(0,mapModel.getEntryNodes().size()-1));
        }
        else
        {
            return mapModel.getExitNodes().get(randomNode(0,mapModel.getEntryNodes().size()-1));
        }
    }
}
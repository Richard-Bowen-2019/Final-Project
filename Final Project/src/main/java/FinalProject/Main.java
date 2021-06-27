/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinalProject;



import FinalProject.Model.Map.Module;
import FinalProject.Model.Map.TrafficMapModel;
import static java.lang.Math.log;
import static java.rmi.server.LogStream.log;
import java.util.ArrayList;
import java.util.logging.LogManager;
import java.util.logging.Logger;


/**
 *
 * @author Richard
 */
public class Main {

    TrafficMapModel traffic;
    
    public static void main(String[] args) throws InterruptedException  {
        new StartSimulation();
    }
        
    
        

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinalProject.Controller.Vehicle;

import FinalProject.Controller.AStarRoute;
import FinalProject.Model.Map.RoadModel;
import FinalProject.Model.Map.IntersectionModel;
import FinalProject.Model.Map.VertexModel;
import FinalProject.Model.Map.TrafficMapModel;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Richard
 */
public class RoutePlannerTest {
     
   TrafficMapModel model;
   AStarRoute instance;
   public RoutePlannerTest() throws InterruptedException {
        model = TrafficMapModel.getMapInstance();
        instance = new AStarRoute();
    }
    
    

    
    /**
     * Test of aStar method, of class AStarRoute for one route.
     */
    
    @Test
    public void testAStar() {
        //System.out.println("aStar");
        VertexModel start = model.getMap().get(0).get(0).getVertex("North", "In");
        VertexModel end = model.getMap().get(0).get(4).getVertex("North", "Out");
        LinkedList<VertexModel> expResult = new LinkedList();
        VertexModel node1 = model.getMap().get(0).get(0).getVertex("East", "Out");
        VertexModel node2 = model.getMap().get(0).get(1).getVertex("West", "In");
        VertexModel node3 = model.getMap().get(0).get(1).getVertex("East", "Out");
        VertexModel node4 = model.getMap().get(0).get(2).getVertex("West", "In");
        VertexModel node5 = model.getMap().get(0).get(2).getVertex("East", "Out");
        VertexModel node6 = model.getMap().get(0).get(3).getVertex("West", "In");
        VertexModel node7 = model.getMap().get(0).get(3).getVertex("East", "Out");
        VertexModel node8 = model.getMap().get(0).get(4).getVertex("West", "In");
        expResult.addFirst(end);
        expResult.addFirst(node8);
        expResult.addFirst(node7);
        expResult.addFirst(node6);
        expResult.addFirst(node5);
        expResult.addFirst(node4);
        expResult.addFirst(node3);
        expResult.addFirst(node2);
        expResult.addFirst(node1);
        expResult.addFirst(start);
        LinkedList<VertexModel> result = instance.aStar(start, end);
        boolean equal = true;
        if(result.size()!=expResult.size())
        {
            equal = false;
        }
        else
        {
            for(int i = 0;i<result.size();i++)
            {
                if(result.get(i)!=expResult.get(i))
                {
                    equal = false;
                }
            }
            
        }
        assertTrue(equal);
    }
    
    /**
     * Test of aStar method, of class AStarRoute for second route.
     */
    @Test
    public void testAStar2() {
        VertexModel start = model.getMap().get(0).get(2).getVertex("North", "In");
        VertexModel end = model.getMap().get(1).get(0).getVertex("West", "Out");
        LinkedList<VertexModel> expResult = new LinkedList();
        VertexModel node1 = model.getMap().get(0).get(2).getVertex("West", "Out");
        VertexModel node2 = model.getMap().get(0).get(1).getVertex("East", "In");
        VertexModel node3 = model.getMap().get(0).get(1).getVertex("West", "Out");
        VertexModel node4 = model.getMap().get(0).get(0).getVertex("East", "In");
        VertexModel node5 = model.getMap().get(0).get(0).getVertex("South", "Out");
        VertexModel node6 = model.getMap().get(1).get(0).getVertex("North", "In");
        expResult.addFirst(end);
        expResult.addFirst(node6);
        expResult.addFirst(node5);
        expResult.addFirst(node4);
        expResult.addFirst(node3);
        expResult.addFirst(node2);
        expResult.addFirst(node1);
        expResult.addFirst(start);
        LinkedList<VertexModel> result = instance.aStar(start, end);
        boolean equal = true;
        if(result.size()!=expResult.size())
        {
            equal = false;
        }
        else
        {
            for(int i = 0;i<result.size();i++)
            {
                
                if(result.get(i)!=expResult.get(i))
                {
                    equal = false;
                }
            }
            
        }
        assertTrue(equal);
    }
    
    /**
     * Test of aStar method, of class AStarRoute for third route.
     */
    @Test
    public void testAStar3() {
        System.out.println("aStar3");
        VertexModel start = model.getMap().get(0).get(4).getVertex("North", "In");
        VertexModel end = model.getMap().get(0).get(3).getVertex("North", "Out");
        LinkedList<VertexModel> expResult = new LinkedList();
        VertexModel node1 = model.getMap().get(0).get(4).getVertex("West", "Out");
        VertexModel node2 = model.getMap().get(0).get(3).getVertex("East", "In");
        expResult.addFirst(end);
        expResult.addFirst(node2);
        expResult.addFirst(node1);
        expResult.addFirst(start);
        LinkedList<VertexModel> result = instance.aStar(start, end);
       
        boolean equal = true;
        if(result.size()!=expResult.size())
        {
            equal = false;
        }
        else
        {
            for(int i = 0;i<result.size();i++)
            {
                System.out.println("Result:"+ result.get(i).getLabel()+"-"+result.get(i).getType());
                System.out.println("ExpResult:"+ expResult.get(i).getLabel()+"-"+expResult.get(i).getType());
                if(result.get(i)!=expResult.get(i))
                {
                    
                    equal = false;
                }
            }
            
        }
        assertTrue(equal);
    }
    
    
    /**
     * Test of Heuristic method, of class AStarRoute.
     */
    @Test
    public void testHeuristic() {
        //System.out.println("Heuristic");
        VertexModel start = model.getMap().get(0).get(2).getVertex("North", "In");
        VertexModel end = model.getMap().get(1).get(0).getVertex("West", "Out");
        double expResult = 30.887; 
        double result = instance.heuristic(start, end);
        assertEquals(expResult,result,0.01);
        VertexModel start1 = model.getMap().get(2).get(4).getVertex("East", "In");
        VertexModel end1 = model.getMap().get(0).get(0).getVertex("North", "Out");
        expResult = 57.706; 
        result = instance.heuristic(start1, end1);
        assertEquals(expResult,result,0.01);
        VertexModel start2 = model.getMap().get(1).get(1).getVertex("East", "In");
        VertexModel end2 = model.getMap().get(2).get(4).getVertex("North","Out");
        expResult = 34.205; 
        result = instance.heuristic(start2, end2);
        assertEquals(expResult,result,0.01);
        
        
        
        
    }

}

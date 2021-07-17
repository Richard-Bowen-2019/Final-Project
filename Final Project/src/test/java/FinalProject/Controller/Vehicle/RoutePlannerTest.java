/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinalProject.Controller.Vehicle;

import FinalProject.Controller.Map.RoutePlanner;
import FinalProject.Model.Map.Edge;
import FinalProject.Model.Map.Intersection;
import FinalProject.Model.Map.Node;
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
    RoutePlanner instance;
    public RoutePlannerTest() throws InterruptedException {
        model = TrafficMapModel.getMapInstance();
        instance = new RoutePlanner();
    }
    
    

    
    /**
     * Test of aStar method, of class RoutePlanner for one route.
     */
    
    @Test
    public void testAStar() {
        //System.out.println("aStar");
        Node start = model.getMap().get(0).get(0).getVertex("North", "In");
        Node end = model.getMap().get(0).get(4).getVertex("North", "Out");
        LinkedList<Node> expResult = new LinkedList();
        Node node1 = model.getMap().get(0).get(0).getVertex("East", "Out");
        Node node2 = model.getMap().get(0).get(1).getVertex("West", "In");
        Node node3 = model.getMap().get(0).get(1).getVertex("East", "Out");
        Node node4 = model.getMap().get(0).get(2).getVertex("West", "In");
        Node node5 = model.getMap().get(0).get(2).getVertex("East", "Out");
        Node node6 = model.getMap().get(0).get(3).getVertex("West", "In");
        Node node7 = model.getMap().get(0).get(3).getVertex("East", "Out");
        Node node8 = model.getMap().get(0).get(4).getVertex("West", "In");
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
        LinkedList<Node> result = instance.aStar(start, end);
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
     * Test of aStar method, of class RoutePlanner for second route.
     */
    @Test
    public void testAStar2() {
        //System.out.println("aStar2");
        Node start = model.getMap().get(0).get(2).getVertex("North", "In");
        //System.out.println("Start:"+ start.getLabel()+"-"+start.getType());
        Node end = model.getMap().get(1).get(0).getVertex("West", "Out");
        //System.out.println("End:"+ end.getLabel()+"-"+end.getType());
        LinkedList<Node> expResult = new LinkedList();
        Node node1 = model.getMap().get(0).get(2).getVertex("North", "In");
        /*for(Edge e : node1.getEdges())
        {
            System.out.println(e.getSource()+"-"+e.getDestination() + "-" + node1.getModuleNumber());
        }*/
        Node node2 = model.getMap().get(0).get(2).getVertex("West", "Out");
        Node node3 = model.getMap().get(0).get(1).getVertex("East", "In");
        Node node4 = model.getMap().get(0).get(1).getVertex("South", "Out");
        Node node5 = model.getMap().get(1).get(1).getVertex("North", "In");
        Node node6 = model.getMap().get(1).get(1).getVertex("West", "Out");
        Node node7 = model.getMap().get(1).get(0).getVertex("East", "In");
        Node node8 = model.getMap().get(1).get(0).getVertex("West", "Out");
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
        LinkedList<Node> result = instance.aStar(start, end);
        boolean equal = true;
        //System.out.println(result.size());
        //System.out.println(expResult.size());
        if(result.size()==expResult.size())
        {
            equal = false;
        }
        else
        {
            for(int i = 0;i<result.size();i++)
            {
                //System.out.println("Result:"+ result.get(i).getLabel()+"-"+result.get(i).getType());
                //System.out.println("ExpResult:"+ expResult.get(i).getLabel()+"-"+expResult.get(i).getType());
                if(result.get(i)!=expResult.get(i))
                {
                    
                    equal = false;
                }
            }
            
        }
        assertTrue(equal);
    }
    
    /**
     * Test of aStar method, of class RoutePlanner for third route.
     */
    @Test
    public void testAStar3() {
        System.out.println("aStar3");
        Node start = model.getMap().get(0).get(4).getVertex("North", "In");
        System.out.println("Start:"+ start.getLabel()+"-"+start.getType());
        Node end = model.getMap().get(0).get(3).getVertex("North", "Out");
        System.out.println("End:"+ end.getLabel()+"-"+end.getType());
        LinkedList<Node> expResult = new LinkedList();
        Node node1 = model.getMap().get(0).get(4).getVertex("East", "Out");
        Node node2 = model.getMap().get(0).get(3).getVertex("West", "In");
        expResult.addFirst(end);
        expResult.addFirst(node2);
        expResult.addFirst(node1);
        expResult.addFirst(start);
        LinkedList<Node> result = instance.aStar(start, end);
        /*for(Node m : result)
        {
            m.printVertex();
        }*/
        boolean equal = true;
        if(result.size()==expResult.size())
        {
            equal = false;
        }
        else
        {
            for(int i = 0;i<result.size();i++)
            {
                //System.out.println("Result:"+ result.get(i).getLabel()+"-"+result.get(i).getType());
                //System.out.println("ExpResult:"+ expResult.get(i).getLabel()+"-"+expResult.get(i).getType());
                if(result.get(i)!=expResult.get(i))
                {
                    
                    equal = false;
                }
            }
            
        }
        assertTrue(equal);
    }
    
    
    /**
     * Test of Heuristic method, of class RoutePlanner.
     */
    @Test
    public void testHeuristic() {
        //System.out.println("Heuristic");
        Node start = model.getMap().get(0).get(2).getVertex("North", "In");
        Node end = model.getMap().get(1).get(0).getVertex("West", "Out");
        double expResult = 30.887; 
        double result = instance.heuristic(start, end);
        assertEquals(expResult,result,0.01);
        Node start1 = model.getMap().get(2).get(4).getVertex("East", "In");
        Node end1 = model.getMap().get(0).get(0).getVertex("North", "Out");
        expResult = 57.706; 
        result = instance.heuristic(start1, end1);
        assertEquals(expResult,result,0.01);
        Node start2 = model.getMap().get(1).get(1).getVertex("East", "In");
        Node end2 = model.getMap().get(2).get(4).getVertex("North","Out");
        expResult = 34.205; 
        result = instance.heuristic(start2, end2);
        assertEquals(expResult,result,0.01);
        
        
        
        
    }

}

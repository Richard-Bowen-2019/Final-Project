/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinalProject.Model.Map;

import FinalProject.Controller.Map.RoutePlanner;
import java.util.ArrayList;
import java.util.Collections;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Richard
 */
public class TrafficMapModelTest {
    TrafficMapModel model;
    RoutePlanner planner;
    public TrafficMapModelTest() throws InterruptedException {
        model = TrafficMapModel.getMapInstance();
        planner = new RoutePlanner();
    }
    
    /**
     * Test of the created 
     * map of class TrafficMapModel.
     */
    @Test
    public void testMap() {
        Intersection intersection1 = model.getMap().get(0).get(0);
        Node node1 = intersection1.getVertex("North", "In");
        Node node2 = intersection1.getVertex("North", "Out");
        Node node3 = intersection1.getVertex("South", "Out");
        Node node5 = intersection1.getVertex("South", "In");
        Node node6 = intersection1.getVertex("East", "Out");
        Node node7 = intersection1.getVertex("East", "In");
        Node node8 = intersection1.getVertex("West", "Out");
        Node node9 = intersection1.getVertex("West", "In");
        
        assertTrue(node1.containsIn());
        assertFalse(node2.containsIn());
        assertTrue(node9.containsIn());
        assertTrue(node1.getRoad(null, node1)!=null);
        
    
    }
    
    
    /**
     * Test of resetMap method, of class TrafficMapModel.
     */
    @Test
    public void testResetMap() {
        planner.getRoute();
        model.resetMap();
        boolean reset = true;
        for(ArrayList<Intersection> alis : model.getMap())
        {
            for(Intersection is : alis)
            {
                for(Node isv : is.getvertices())
                {
                    if(isv.getParent()!=null)
                    {
                        reset = false;
                    }
                }
            }
        }
        assertTrue(reset);
    }

    /**
     * Test of getRoad method, of class IntersectionVertex.
     */
    @Test
    public void testgetXandY() {
        //System.out.println("getXandY");
        Node testNode = model.getMap().get(0).get(0).getVertex("South","In");
        int[] expResult = {5,8};
        int[] result = testNode.getXandY();
        Assert.assertArrayEquals(expResult,result);
        testNode = model.getMap().get(2).get(3).getVertex("South", "In");
        int[] expResult2 = {41,32};
        int[] result2 = testNode.getXandY();
        Assert.assertArrayEquals(expResult2,result2);
        testNode = model.getMap().get(1).get(4).getVertex("South", "In");
        int[] expResult3 = {53,20};
        int[] result3 = testNode.getXandY();
        Assert.assertArrayEquals(expResult3,result3);
        testNode = model.getMap().get(0).get(2).getVertex("South", "In");
        int[] expResult4 = {29,8};
        int[] result4 = testNode.getXandY();
        Assert.assertArrayEquals(expResult4,result4);
    
    }
    
    
    /**
     * Test of getPosition method, of class TrafficMapModel.
     */
    @Test
    public void testGetPosition() {
        //System.out.println("getPosition");
        Node vm = model.getMap().get(0).get(0).getVertex("North","In");
        int[] expResult = {0,0};
        int[] result = model.getPosition(vm);
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of getEntryNodes method, of class TrafficMapModel.
     */
    @Test
    public void testGetEntryNodes() {
        //System.out.println("getEntryNodes");
        ArrayList<Node> expResult = new ArrayList<>();
        expResult.add(model.getMap().get(0).get(0).getVertex("West", "In"));
        expResult.add(model.getMap().get(0).get(0).getVertex("North", "In"));
        expResult.add(model.getMap().get(0).get(1).getVertex("North", "In"));
        expResult.add(model.getMap().get(0).get(2).getVertex("North", "In"));
        expResult.add(model.getMap().get(0).get(3).getVertex("North", "In"));
        expResult.add(model.getMap().get(0).get(4).getVertex("East", "In"));
        expResult.add(model.getMap().get(0).get(4).getVertex("North", "In"));
        expResult.add(model.getMap().get(1).get(0).getVertex("West", "In"));
        expResult.add(model.getMap().get(1).get(4).getVertex("East", "In"));
        expResult.add(model.getMap().get(2).get(0).getVertex("West", "In"));
        expResult.add(model.getMap().get(2).get(0).getVertex("South", "In"));
        expResult.add(model.getMap().get(2).get(1).getVertex("South", "In"));
        expResult.add(model.getMap().get(2).get(2).getVertex("South", "In"));
        expResult.add(model.getMap().get(2).get(3).getVertex("South", "In"));
        expResult.add(model.getMap().get(2).get(4).getVertex("South", "In"));
        expResult.add(model.getMap().get(2).get(4).getVertex("East", "In"));
        ArrayList<Node> result = model.getEntryNodes();
        boolean equal = true;
        for(Node m : result)
        {
            if(!expResult.contains(m))
            {
                equal = false;
            }
        }
        assertTrue(true);
    }

    /**
     * Test of getExitNodes method, of class TrafficMapModel.
     */
    @Test
    public void testGetExitNodes() {
        //System.out.println("getExitNodes");
        ArrayList<Node> expResult = new ArrayList<>();
        expResult.add(model.getMap().get(0).get(0).getVertex("West", "Out"));
        expResult.add(model.getMap().get(0).get(0).getVertex("North", "Out"));
        expResult.add(model.getMap().get(0).get(1).getVertex("North", "Out"));
        expResult.add(model.getMap().get(0).get(2).getVertex("North", "Out"));
        expResult.add(model.getMap().get(0).get(3).getVertex("North", "Out"));
        expResult.add(model.getMap().get(0).get(4).getVertex("East", "Out"));
        expResult.add(model.getMap().get(0).get(4).getVertex("North", "Out"));
        expResult.add(model.getMap().get(1).get(0).getVertex("West", "Out"));
        expResult.add(model.getMap().get(1).get(4).getVertex("East", "Out"));
        expResult.add(model.getMap().get(2).get(0).getVertex("West", "Out"));
        expResult.add(model.getMap().get(2).get(0).getVertex("South", "Out"));
        expResult.add(model.getMap().get(2).get(1).getVertex("South", "Out"));
        expResult.add(model.getMap().get(2).get(2).getVertex("South", "Out"));
        expResult.add(model.getMap().get(2).get(3).getVertex("South", "Out"));
        expResult.add(model.getMap().get(2).get(4).getVertex("South", "Out"));
        expResult.add(model.getMap().get(2).get(4).getVertex("East", "Out"));
        ArrayList<Node> result = model.getExitNodes();
        boolean equal = true;
        for(Node m : result)
        {
            if(!expResult.contains(m))
            {
                equal = false;
            }
        }
        assertTrue(equal);
    }

    /**
     * Test of getModule method, of class TrafficMapModel.
     */
    @Test
    public void testGetModule() {
        //System.out.println("getModule");
        Node vm = model.getMap().get(0).get(0).getVertex("West", "Out");
        Intersection expResult = model.getMap().get(0).get(0);
        Intersection result = model.getModule(vm);
        assertEquals(expResult, result);
    }
}

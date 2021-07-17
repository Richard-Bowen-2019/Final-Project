/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinalProject.Model.Map;

import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Richard
 */
public class NodeTest {
    int[] module = {0,0};
    Node source = new Node("North","In",module);
    Node destination1 = new Node("South","Out",module);
    Edge testEdge1 = new Edge(source,destination1);
    Node destination2 = new Node("West","Out",module);
    Edge testEdge2 = new Edge(source,destination2);
    Edge testEdge3 = new Edge(source,null);
    Edge testEdge4 = new Edge(null, destination1);
    
    public NodeTest() {
    source.addEdge(testEdge1);
    source.addEdge(testEdge2);
    source.addEdge(testEdge3);
    source.addEdge(testEdge4);
    }
    
    /**
     * Test of getInRoads method, of class IntersectionVertex.
     */
    @Test
    public void testGetInRoads() {
        //System.out.println("getInRoads");
        ArrayList<Edge> expResult = new ArrayList<>();
        expResult.add(testEdge4);
        ArrayList<Edge> result = source.getInRoads();
        assertEquals(expResult, result);
    }

    /**
     * Test of getOutRoads method, of class IntersectionVertex.
     */
    @Test
    public void testGetOutRoads() {
        //System.out.println("getOutRoads");
        ArrayList<Edge> expResult = new ArrayList<>();
        expResult.add(testEdge3);
        ArrayList<Edge> result = source.getOutRoads();
        assertEquals(expResult, result);
    }

    /**
     * Test of getType method, of class IntersectionVertex.
     */
    @Test
    public void testGetType() {
        //System.out.println("getType");
        String expResult = "In";
        String result = source.getType();
        assertEquals(expResult, result);
    }

    /**
     * Test of getLabel method, of class IntersectionVertex.
     */
    @Test
    public void testGetLabel() {
        //System.out.println("getLabel");
        String expResult = "North";
        String result = source.getLabel();
        assertEquals(expResult, result);
    }

    

    

    /**
     * Test of addEdge method, of class IntersectionVertex.
     */
    @Test
    public void testAddEdge() {
        //System.out.println("addEdge");
        //testEdge1.printEdge();
        source.addEdge(testEdge1);
        assertEquals(source.getEdges().size(),5);
    }

    /**
     * Test of getEdges method, of class IntersectionVertex.
     */
    @Test
    public void testGetEdges() {
        ArrayList<Edge> expResult = new ArrayList<>();
        expResult.add(testEdge1);
        expResult.add(testEdge2);
        expResult.add(testEdge3);
        expResult.add(testEdge4);
        ArrayList<Edge> result = source.getEdges();
        assertEquals(expResult, result);
    }

    
    /**
     * Test of containsIn method, of class IntersectionVertex.
     */
    @Test
    public void testContainsIn() {
        //System.out.println("containsIn");
        boolean expResult = true;
        boolean result = source.containsIn();
        assertEquals(expResult, result);
    }

    /**
     * Test of getRoad method, of class IntersectionVertex.
     */
    @Test
    public void testGetRoad() {
        //System.out.println("getRoad");
        Edge expResult = testEdge1;
        Edge result = source.getRoad(source, destination1);
        assertEquals(expResult, result);
        
    }

    

    
    /**
     * Test of setParent method, of class IntersectionVertex.
     */
    @Test
    public void testSetParent() {
        //System.out.println("setParent");
        source.setParent(destination1);
        Node result = source.getParent();
        assertEquals(destination1,result);
    }
}

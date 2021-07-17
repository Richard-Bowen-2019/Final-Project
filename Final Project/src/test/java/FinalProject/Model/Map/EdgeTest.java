/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinalProject.Model.Map;

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
public class EdgeTest {
    int[] start = {0,0};
    int[] end = {0,1};
    int[] end2 = {1,0};
    Node source = new Node("North","In",start);
    Node destination = new Node("South","Out",end);
    Edge testEdge = new Edge(source,destination);
    Node source2 = new Node("South","Out",start);
    Node destination2 = new Node("North","In",end);
    Edge testEdge2 = new Edge(source2,destination2);
    Node source3 = null;
    Node destination3 = new Node("North","In",end2);
    Edge testEdge3 = new Edge(source3,destination3);
            
    @After
    public void tearDown() {
        //testEdge.printEdge();
        testEdge = new Edge(source, destination);
    }

    /**
     * Test of occupySlot method, of class Edge.
     */
    @Test
    public void testOccupySlot() {
        //System.out.println("occupySlot");
        int slot = 0;
        testEdge.occupySlot(slot);
        assertEquals(testEdge.weighting,1);
        assertEquals(testEdge.slots[slot],1);
        slot = 3;
        testEdge2.occupySlot(slot);
        assertEquals(testEdge2.weighting,1);
        assertEquals(testEdge2.slots[slot],1);
        slot = 5;
        testEdge3.occupySlot(slot);
        assertEquals(testEdge3.weighting,1);
        assertEquals(testEdge3.slots[slot],1);
    }

    /**
     * Test of increaseWeighting method, of class Edge.
     */
    @Test
    public void testIncreaseWeighting() {
        //System.out.println("increaseWeighting");
        testEdge.increaseWeighting();
        Assert.assertEquals(testEdge.weighting,1);
        testEdge.increaseWeighting();
        Assert.assertEquals(testEdge.weighting,2);
    }

    
    
}

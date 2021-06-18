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
    Vertex source = new Vertex("North","In");
    Vertex destination = new Vertex("South","Out");
    Edge testEdge = new Edge(source,destination);
    
    public EdgeTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
        testEdge.printEdge();
        testEdge = new Edge(source, destination);
    }

    /**
     * Test of occupySlot method, of class Edge.
     */
    @Test
    public void testOccupySlot() {
        System.out.println("occupySlot");
        int slot = 0;
        testEdge.occupySlot(slot);
        assertEquals(testEdge.weighting,1);
        assertEquals(testEdge.slots.get(slot).intValue(),1);
        slot = 3;
        testEdge.occupySlot(slot);
        assertEquals(testEdge.weighting,2);
        assertEquals(testEdge.slots.get(slot).intValue(),1);
        slot = 5;
        testEdge.occupySlot(slot);
        assertEquals(testEdge.weighting,3);
        assertEquals(testEdge.slots.get(slot).intValue(),1);
    }

    /**
     * Test of increaseWeighting method, of class Edge.
     */
    @Test
    public void testIncreaseWeighting() {
        System.out.println("increaseWeighting");
        testEdge.increaseWeighting();
        Assert.assertEquals(testEdge.weighting,1);
        testEdge.increaseWeighting();
        Assert.assertEquals(testEdge.weighting,2);
    }

    
    
}

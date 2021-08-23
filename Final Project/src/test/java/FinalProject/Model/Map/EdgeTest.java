/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinalProject.Model.Map;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;


/**
 *
 * @author Richard
 */
public class EdgeTest 
{
    int[] start = {0,0};
    int[] end = {0,1};
    int[] end2 = {1,0};
    VertexModel source = new VertexModel("North","In",start);
    VertexModel destination = new VertexModel("South","Out",end);
    RoadModel testEdge = new RoadModel(source,destination,"Intersection");
    VertexModel source2 = new VertexModel("South","Out",start);
    VertexModel destination2 = new VertexModel("North","In",end);
    RoadModel testEdge2 = new RoadModel(source2,destination2,"Connecting");
    VertexModel source3 = null;
    VertexModel destination3 = new VertexModel("North","In",end2);
    RoadModel testEdge3 = new RoadModel(source3,destination3,"Entry");
            
    @After
    public void tearDown() {
        //testEdge.printEdge();
        testEdge = new RoadModel(source, destination,"Intersection");
    }

    
    /**
     * Test of occupySlot method, of class RoadModel.
     */
    /*@Test
    public void testOccupySlot() {
        //System.out.println("occupySlot");
        int slot = 0;
        VehicleModel vehicle = new CarModel();
        testEdge.occupySlot(slot, vehicle);
        assertEquals(testEdge.vehicles[slot],1);
        slot = 3;
        testEdge2.occupySlot(slot,vehicle);
        
        assertEquals(testEdge2.vehicles[slot],1);
        slot = 4;
        testEdge3.occupySlot(slot,vehicle);
        
        assertEquals(testEdge3.vehicles[slot],1);
    }
    */
    
    /**
     * Test of increaseWeighting method, of class RoadModel.
     */
    @Test
    public void testIncreaseWeighting() {
        //System.out.println("increaseWeighting");
        testEdge.increaseWeighting();
        Assert.assertEquals(testEdge.getWeighting(),1);
        testEdge.increaseWeighting();
        Assert.assertEquals(testEdge.getWeighting(),2);
    }
}

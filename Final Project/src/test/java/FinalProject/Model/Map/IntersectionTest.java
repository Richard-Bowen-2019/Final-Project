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
public class IntersectionTest {
    
    TrafficMapModel model;
    
    public IntersectionTest() throws InterruptedException {
        model = TrafficMapModel.getMapInstance();
    }
    
    /**
     * Test of getvertices method, of class IntersectionModel.
     */
    @Test
    public void testGetvertices() {
        //System.out.println("getvertices");
        IntersectionModel instance = model.getMap().get(0).get(0);
        ArrayList<VertexModel> expResult = instance.vertices;
        ArrayList<VertexModel> result = instance.getvertices();
        assertEquals(expResult, result);
    }

    /**
     * Test of getVertex method, of class IntersectionModel.
     */
    @Test
    public void testGetVertex() {
        //System.out.println("getVertex");
        IntersectionModel instance = model.getMap().get(0).get(0);
        String label = "North";
        String type = "In";
        VertexModel expResult = null;
        for(VertexModel v: instance.getvertices())
        {
            if(v.getLabel()==label&&v.getType()==type)
            {
                expResult = v;
            }
        }
        VertexModel result = model.getMap().get(0).get(0).getVertex(label, type);
        assertEquals(expResult, result);
    }

    /**
     * Test of getLabel method, of class IntersectionModel.
     */
    @Test
    public void testGetLabel() {
        //System.out.println("getLabel");
        String expResult = "North";
        String result = model.getMap().get(0).get(0).getVertex("North", "In").getLabel();
        assertEquals(expResult, result);
    }

    /**
     * Test of containsVertex method, of class IntersectionModel.
     */
    @Test
    public void testContainsVertex() {
        //System.out.println("containsVertex");
        VertexModel v = model.getMap().get(0).get(0).getVertex("North", "In");
        //v.printVertex();
        boolean expResult = true;
        boolean result = model.getMap().get(0).get(0).containsVertex(v);
        assertEquals(expResult, result);
        
    }
}

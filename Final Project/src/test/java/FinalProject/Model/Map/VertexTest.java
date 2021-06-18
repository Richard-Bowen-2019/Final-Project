/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinalProject.Model.Map;

import java.util.ArrayList;
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
public class VertexTest {
    Vertex source = new Vertex("North","In");
    Vertex destination1 = new Vertex("South","Out");
    Edge testEdge1 = new Edge(source,destination1);
    Vertex destination2 = new Vertex("West","Out");
    Edge testEdge2 = new Edge(source,destination2);
    
    
    public VertexTest() {
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
        source.printVertex();
    }

    /**
     * Test of getType method, of class Vertex.
     */
    @Test
    public void testGetType() {
        System.out.println("getType");
        String expResult = "In";
        String result = source.getType();
        assertEquals(expResult, result);
        }

    /**
     * Test of getLabel method, of class Vertex.
     */
    @Test
    public void testGetLabel() {
        System.out.println("getLabel");
        String expResult = "North";
        String result = source.getLabel();
        assertEquals(expResult, result);
        }

    /**
     * Test of addEdge method, of class Vertex.
     */
    @Test
    public void testAddEdge() {
        System.out.println("addEdge");
        source.addEdge(testEdge1);
        assertEquals(source.edges.size(),1);
    }

    /**
     * Test of getEdges method, of class Vertex.
     */
    @Test
    public void testGetEdges() {
        source.addEdge(testEdge1);
        source.addEdge(testEdge2);
        ArrayList<Edge> expResult = new ArrayList<>();
        expResult.add(testEdge1);
        expResult.add(testEdge2);
        ArrayList<Edge> result = source.getEdges();
        assertEquals(expResult, result);
        
    }
    
}

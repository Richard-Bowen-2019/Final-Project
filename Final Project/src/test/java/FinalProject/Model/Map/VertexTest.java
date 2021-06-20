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
    VertexModel source = new VertexModel("North","In");
    VertexModel destination1 = new VertexModel("South","Out");
    Edge testEdge1 = new Edge(source,destination1);
    VertexModel destination2 = new VertexModel("West","Out");
    Edge testEdge2 = new Edge(source,destination2);
    
    
    public VertexTest() {
    if(testEdge1==null||testEdge2==null);
    {
        System.out.println("No edges");
    }
    testEdge1.printEdge();
    testEdge1.printEdge();
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
        testEdge1.printEdge();
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
        source.printVertex();
        ArrayList<Edge> expResult = new ArrayList<>();
        expResult.add(testEdge1);
        expResult.add(testEdge2);
        ArrayList<Edge> result = source.getEdges();
        assertEquals(expResult, result);
        
    }
    
}

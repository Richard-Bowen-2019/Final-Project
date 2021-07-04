/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinalProject.Model.Map.Routes;

import FinalProject.Model.Map.IntersectionVertex;
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
public class RouteloaderTest {
    
    public RouteloaderTest() {
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
     * Test of getRouteInstance method, of class Routeloader.
     */
    @Test
    public void testGetRouteInstance() throws Exception {
        System.out.println("getRouteInstance");
        Routeloader expResult = null;
        Routeloader result = Routeloader.getRouteInstance();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of constructPath method, of class Routeloader.
     */
    @Test
    public void testConstructPath() {
        System.out.println("constructPath");
        Routeloader instance = null;
        instance.constructPath();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of aStar method, of class Routeloader.
     */
    @Test
    public void testAStar() {
        System.out.println("aStar");
        IntersectionVertex start = null;
        IntersectionVertex end = null;
        Routeloader instance = null;
        IntersectionVertex expResult = null;
        IntersectionVertex result = instance.aStar(start, end);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}

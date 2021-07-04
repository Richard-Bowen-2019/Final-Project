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
public class TreeTest {
    IntersectionVertex root = new IntersectionVertex("Root","Root","Root");
    IntersectionVertex child = new IntersectionVertex("Child","Child","Child");
    public TreeTest() {
    
    }
    
    
    /**
     * Test of addChildrenNode method, of class Tree.
     */
    @Test
    public void testAddChildrenNode() {
        System.out.println("addChildrenNode");
        IntersectionVertex root = null;
        IntersectionVertex child = null;
        VertexTree instance = null;
        instance.addChildrenNode(root, child);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addChild method, of class Tree.
     */
    @Test
    public void testAddChild() {
        System.out.println("addChild");
        IntersectionVertex child = null;
        VertexTree instance = null;
        VertexTree expResult = null;
        VertexTree result = instance.addChild(child);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHead method, of class Tree.
     */
    @Test
    public void testGetHead() {
        System.out.println("getHead");
        VertexTree instance = null;
        IntersectionVertex expResult = null;
        IntersectionVertex result = instance.getHead();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTree method, of class Tree.
     */
    @Test
    public void testGetTree() {
        System.out.println("getTree");
        VertexTree tree = null;
        VertexTree instance = null;
        VertexTree expResult = null;
        VertexTree result = instance.getTree(tree);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}

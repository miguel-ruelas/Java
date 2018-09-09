/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author adminx
 */
public class HumanPlayerTest {
    
    public HumanPlayerTest() {
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
     * Test of move method, of class HumanPlayer.
     */
    @Test
    public void testMove() {
        System.out.println("move");
        int pileSize = 90;
        HumanPlayer instance = new HumanPlayer("Bob");
        int expResult = 0;
        int result = instance.move(pileSize);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getName method, of class HumanPlayer.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        HumanPlayer instance = new HumanPlayer("Bob");
        String expResult = "Bob";
        String result = instance.getName();
        System.out.println(result);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMarbles method, of class HumanPlayer.
     */
    @Test
    public void testGetMarbles() {
        System.out.println("getMarbles");
        HumanPlayer instance = new HumanPlayer("Bob");
        int expResult = 0;
        int result = instance.getMarbles();
        System.out.println(result);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}

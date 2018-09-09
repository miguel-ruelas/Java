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
public class StupidComputerPlayerTest {
    
    public StupidComputerPlayerTest() {
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
     * Test of move method, of class StupidComputerPlayer.
     */
    @Test
    public void testMove() {
        System.out.println("move");
        int pileSize = 100;
        StupidComputerPlayer instance = new StupidComputerPlayer("Dumb1");
        int expResult = 0;
        int result = instance.move(pileSize);
        System.out.println("move");
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getName method, of class StupidComputerPlayer.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        StupidComputerPlayer instance = new StupidComputerPlayer("Dumb1");
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMarbles method, of class StupidComputerPlayer.
     */
    @Test
    public void testGetMarbles() {
        System.out.println("getMarbles");
        StupidComputerPlayer instance = new StupidComputerPlayer("Dumb1");
        int expResult = 0;
        int result = instance.getMarbles();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}

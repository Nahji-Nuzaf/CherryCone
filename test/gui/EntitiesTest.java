/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package gui;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author HP
 */
public class EntitiesTest {
    
    public EntitiesTest() {
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
     * Test of setGRN method, of class Entities.
     */
    @Test
    public void testSetGRN() {
        System.out.println("setGRN");
        supplierGRN grn = null;
        Entities instance = new Entities();
        instance.setGRN(grn);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setPOSDash method, of class Entities.
     */
    @Test
    public void testSetPOSDash() {
        System.out.println("setPOSDash");
        POSDashboard posdashboard = null;
        Entities instance = new Entities();
        instance.setPOSDash(posdashboard);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of switchToTab method, of class Entities.
     */
    @Test
    public void testSwitchToTab() {
        System.out.println("switchToTab");
        int index = 0;
        Entities instance = new Entities();
        instance.switchToTab(index);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of switchToCus method, of class Entities.
     */
    @Test
    public void testSwitchToCus() {
        System.out.println("switchToCus");
        int index = 0;
        Entities instance = new Entities();
        instance.switchToCus(index);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}

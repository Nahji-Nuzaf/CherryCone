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
public class AssetsTest {
    
    public AssetsTest() {
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
     * Test of setGrn method, of class Assets.
     */
    @Test
    public void testSetGrn() {
        System.out.println("setGrn");
        supplierGRN grn = null;
        Assets instance = new Assets();
        instance.setGrn(grn);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of switchToTab method, of class Assets.
     */
    @Test
    public void testSwitchToTab() {
        System.out.println("switchToTab");
        int index = 0;
        Assets instance = new Assets();
        instance.switchToTab(index);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}

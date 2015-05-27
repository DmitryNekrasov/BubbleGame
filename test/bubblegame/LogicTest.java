/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bubblegame;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ScanNorOne
 */
public class LogicTest {
    
    public LogicTest() {
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
     * Test of generateRandom method, of class Logic.
     */
    @Test
    public void testGenerateRandom() {
        System.out.println("generateRandom");
        Logic logic = Logic.getInstance();
        int n = 3;
        boolean expResult = true;
        boolean result = true;
        boolean[] f = new boolean[3];
        for (int i = 0; i < 100; i++) {
            int rand = logic.generateRandom(n);
            result = result && rand >= 0 && rand <= 3;
            if (result) {
                f[rand] = true;
            }
        }
        result = result && f[0] && f[1] && f[2];
        assertEquals(expResult, result);
    }
    
    /**
     * Test of getCountRow method, of class Logic.
     */
    @Test
    public void testGetCountRow() {
        System.out.println("getCountRow");
        Logic logic = Logic.getInstance();
        int expResult = 1;
        int result = logic.getCountRow();
        assertEquals(expResult, result);
    }
    
}

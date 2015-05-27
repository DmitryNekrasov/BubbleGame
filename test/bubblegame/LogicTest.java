/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bubblegame;

import java.awt.Point;
import java.util.Arrays;
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
    
    private Logic logic;
    
    public LogicTest() {
        logic = Logic.getInstance();
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
        int expResult = 15;
        int result = logic.getCountRow();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of getCountColumn method, of class Logic.
     */
    @Test
    public void testGetCountColumn() {
        System.out.println("getCountColumn");
        int expResult = 10;
        int result = logic.getCountColumn();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of getFieldCell method, of class Logic.
     */
    @Test
    public void testGetFieldCell() {
        System.out.println("getFieldCell");
        
        for (int i = 0; i < logic.getCountRow(); i++)
            for (int j = 0; j < logic.getCountColumn(); j++)
                logic.setFieldCell(i, j, 0);
        
        int i = 0, j = 0;
        int expResult = 0;
        int result = logic.getFieldCell(i, j);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of initField method, of class Logic.
     */
    @Test 
    public void testInitField() {
        System.out.println("initField");
        logic.initField();
        boolean expResult = true;
        boolean result = true;
        boolean[] f = new boolean[3];
        for (int i = 0; i < logic.getCountRow(); i++)
            for (int j = 0; j < logic.getCountColumn(); j++)
                f[logic.getFieldCell(i, j)] = true;
        result = result && f[0] && f[1] && f[2];
        assertEquals(expResult, result);
    }
    
    /**
     * Test of screenPointToField method, of class Logic.
     */
    @Test
    public void testScreenPointToField() {
        System.out.println("screenPointToField");
        Point point = new Point(138, 376);
        Point expResult = new Point(4, 12);
        Point result = logic.screenPointToField(point, 30);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of dfs method, of class Logic.
     */
    @Test
    public void testDfs() {
        System.out.println("dfs");
        
        for (int i = 0; i < logic.getCountRow(); i++)
            for (int j = 0; j < logic.getCountColumn(); j++)
                logic.setFieldCell(i, j, 0);
        
        for (int i = 1; i <= 5; i++)
            for (int j = 1; j <= 3; j++)
                logic.setFieldCell(i, j, 1);
        logic.outField();
        
        int[][] a = new int[15][10];
        for (int i = 1; i <= 5; i++)
            for (int j = 1; j <= 3; j++)
                a[i][j] = -1;
        
        logic.dfs(3, 3, 1);
        
        boolean expResult = true;
        boolean result = true;
        
        for (int i = 0; i < logic.getCountRow(); i++)
            for (int j = 0; j < logic.getCountColumn(); j++)
                if (logic.getFieldCell(i, j) != a[i][j])
                    result = false;
        
        assertEquals(expResult, result);
    }
    
    /**
     * Test of shiftTopToBottom method, of class Logic.
     */
    @Test
    public void testShiftTopToBottom() {
        System.out.println("shiftTopToBottom");
        
        for (int i = 0; i < logic.getCountRow(); i++)
            for (int j = 0; j < logic.getCountColumn(); j++)
                logic.setFieldCell(i, j, 0);
        
        for (int i = 3; i <= 5; i++)
            for (int j = 5; j <= 7; j++)
                logic.setFieldCell(i, j, -1);
        logic.setFieldCell(2, 6, -1);
        logic.setFieldCell(2, 7, -1);
        logic.setFieldCell(1, 7, -1);
        logic.outField();
        
        int[][] a = new int[15][10];
        for (int i = 0; i <= 2; i++)
            for (int j = 5; j <= 7; j++)
                a[i][j] = -1;
        a[3][6] = -1;
        a[3][7] = -1;
        a[4][7] = -1;
        
        logic.shiftTopToBottom();
        
        boolean expResult = true;
        boolean result = true;
        
        for (int i = 0; i < logic.getCountRow(); i++)
            for (int j = 0; j < logic.getCountColumn(); j++)
                if (logic.getFieldCell(i, j) != a[i][j])
                    result = false;
        
        assertEquals(expResult, result);
    }
    
    /**
     * Test of shiftRightToLeft method, of class Logic.
     */
    @Test
    public void testShiftRightToLeft() {
        System.out.println("shiftRightToLeft");
        
        for (int i = 0; i < logic.getCountRow(); i++)
            for (int j = 0; j < logic.getCountColumn(); j++)
                logic.setFieldCell(i, j, -1);
        
        for (int i = 0; i <= 14; i++)
            for (int j = 0; j <= 2; j++)
                logic.setFieldCell(i, j, 0);
        for (int i = 6; i <= 14; i++)
            for (int j = 5; j <= 6; j++)
                logic.setFieldCell(i, j, 0);
        for (int i = 3; i <= 14; i++)
            logic.setFieldCell(i, 9, 0);
        logic.outField();
        
        int[][] a = new int[15][10];
        for (int i = 0; i < 15; i++)
            Arrays.fill(a[i], -1);
        
        for (int i = 0; i <= 14; i++)
            for (int j = 0; j <= 2; j++)
                a[i][j] = 0;
        for (int i = 6; i <= 14; i++)
            for (int j = 3; j <= 4; j++)
                a[i][j] = 0;
        for (int i = 3; i <= 14; i++)
            a[i][5] = 0;
        
        logic.shiftRightToLeft();
        
        boolean expResult = true;
        boolean result = true;
        
        for (int i = 0; i < logic.getCountRow(); i++)
            for (int j = 0; j < logic.getCountColumn(); j++)
                if (logic.getFieldCell(i, j) != a[i][j])
                    result = false;
        
        assertEquals(expResult, result);
    }
    
    /**
     * Test of validation method, of class Logic.
     */
    @Test
    public void testValidation() {
        System.out.println("validation");
        
        for (int i = 0; i < logic.getCountRow(); i++)
            for (int j = 0; j < logic.getCountColumn(); j++)
                logic.setFieldCell(i, j, -1);
        logic.setFieldCell(14, 0, 0);
        logic.setFieldCell(14, 1, 0);
        
        boolean expResult = true;
        boolean result = logic.validation(14, 0);
        
        assertEquals(expResult, result);
    }
    
    /**
     * Test of checkEndGame method, of class Logic.
     */
    @Test
    public void testCheckEndGame() {
        System.out.println("checkEndGame");
        
        for (int i = 0; i < logic.getCountRow(); i++)
            for (int j = 0; j < logic.getCountColumn(); j++)
                logic.setFieldCell(i, j, -1);
        logic.setFieldCell(14, 0, 0);
        logic.setFieldCell(14, 1, 1);
        
        boolean expResult = true;
        boolean result = logic.checkEndGame();
        
        assertEquals(expResult, result);
    }
}

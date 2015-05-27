/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bubblegame;

import java.util.Random;

/**
 *
 * @author ScanNorOne
 */
public class Logic {
    
    private static Logic instance;
    
    final private int countBubble = 3;
    final private int redBubble = 0, greenBubble = 1, blueBubble = 2;
    final private int countRow = 15, countColumn = 10;
    
    private Random random;
    public int[][] field;
    
    private Logic() {
        field = new int[countRow][countColumn];
        random = new Random();
    }
    
    public static Logic getInstance() {
        if (instance == null) {
            instance = new Logic();
        }
        return instance;
    }
    
    public int generateRandom(int n) {
        return 5;
    }
    
}

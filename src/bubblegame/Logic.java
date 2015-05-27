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
    private int[][] field;
    
    private Logic() {
        random = new Random();
        field = new int[countRow][countColumn];
    }
    
    public static Logic getInstance() {
        if (instance == null) {
            instance = new Logic();
        }
        return instance;
    }
    
    public int getCountRow() {
        return countRow;
    }
    
    public int getCountColumn() {
        return countColumn;
    }
    
    public int getFieldCell(int i, int j) {
        return field[i][j];
    }
    
    public void initField() {
        for (int i = 0; i < countRow; i++)
            for (int j = 0; j < countColumn; j++)
                field[i][j] = generateRandom(countBubble);
    }
    
    public void outField() {
        for (int i = 0; i < countRow; i++) {
            for (int j = 0; j < countColumn; j++)
                System.out.print(field[i][j] + " ");
            System.out.println();
        }
    }
    
    public int generateRandom(int n) {
        return Math.abs(random.nextInt()) % n;
    }
    
}

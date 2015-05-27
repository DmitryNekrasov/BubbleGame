/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bubblegame;

import java.awt.Point;
import java.util.Random;

/**
 *
 * @author ScanNorOne
 */
public class Logic {
    
    private static Logic instance;
    
    final private int countBubble = 3;
    final public static int redBubble = 0, greenBubble = 1, blueBubble = 2;
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
    
    public void setFieldCell(int i, int j, int val) {
        field[i][j] = val;
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
    
    public Point screenPointToField(Point screenPoint, int bubbleSize) {
        return new Point(screenPoint.x / bubbleSize, screenPoint.y / bubbleSize);
    }
    
    public void processing(Point screenPoint, int bubbleSize) {
        Point fieldPoint = screenPointToField(screenPoint, bubbleSize);
        int j = fieldPoint.x;
        int i = fieldPoint.y;
        dfs(i, j, field[i][j]);
    }
    
    public void dfs(int x, int y, int colorCode) {
        if (field[x][y] != colorCode || field[x][y] == -1)
            return;
        field[x][y] = -1;
        if (x > 0)
            dfs(x - 1, y, colorCode);
        if (x < countRow - 1)
            dfs(x + 1, y, colorCode);
        if (y > 0)
            dfs(x, y - 1, colorCode);
        if (y < countColumn - 1)
            dfs(x, y + 1, colorCode);
    }
    
    public void shiftTopToBottom() {
        
    }
}

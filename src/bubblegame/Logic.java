/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bubblegame;

/**
 *
 * @author ScanNorOne
 */
public class Logic {
    
    private static Logic instance;
    
    final private int redBubble = 1, greenBubble = 2, blueBubble = 3;
    final private int countRow = 15, countColumn = 10;
    
    public int[][] field;
    
    private Logic() {
        field = new int[countRow][countColumn];
    }
    
    public static Logic getInstance() {
        if (instance == null) {
            instance = new Logic();
        }
        return instance;
    }
    
}

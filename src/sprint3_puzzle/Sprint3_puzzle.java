/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sprint3_puzzle;

/**
 *
 * @author work
 */
public class Sprint3_puzzle {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //JFramePuzzles jFramePuzzle = new JFramePuzzles();

        /*
        jFramePuzzle.setVisible(true);
        jFramePuzzle.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        jFramePuzzle.setLocationRelativeTo(null);
        jFramePuzzle.setResizable(false);
        */
        
        //PuzzleTile puzzleTile = new PuzzleTile();
        
        SlidingPuzzles myGame = new SlidingPuzzles();
        myGame.go();
        
    }
    
}

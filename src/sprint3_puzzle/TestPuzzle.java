/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sprint3_puzzle;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author work
 */
public final class TestPuzzle extends JFrame {
    
    JFrame frame = new JFrame();
    JPanel panel = new JPanel();
    
    ArrayList<JButton> buttonList = new ArrayList();
    int maxTiles = 16;

    
    TestPuzzle()
    {
        panel.setLayout(new GridLayout(0,4));
        frame.add(panel);

        for (int x = 0; x < maxTiles; x++)
        {
            JButton button = new JButton();
            buttonList.add(button);
            panel.add(button);
        }
        
        generatePuzzleTiles();
        
        frame.pack();
        frame.setSize(400, 400);
        frame.setLocation(1000, 500);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    public void generatePuzzleTiles()
    {
        Integer[] randoms = new Integer[maxTiles];
        
        for (int x = 0; x < maxTiles; x++)
            randoms[x] = x+1;
       
        Collections.shuffle(Arrays.asList(randoms));
       
        for(int i = 0; i < maxTiles-1; i++) 
            buttonList.get(i).setText("" + randoms[i]);
    }
}

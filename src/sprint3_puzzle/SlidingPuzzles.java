/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sprint3_puzzle;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author work
 */
public class SlidingPuzzles extends JPanel implements MouseListener  
{
    JFrame jFrame;
    ArrayList<PuzzleTile> puzzleList = new ArrayList<>();
    PuzzleTile[] puzzleTile;

    public SlidingPuzzles() 
    {
        initComponents();
    }
    
    public void initiate()
    {
        jFrame = new JFrame("sprint3_puzzle");
        jFrame.setLayout(new GridLayout(4,4)); //4x4 grid
        puzzleTile = new PuzzleTile[16]; //16 bitar
        
        generatePuzzleTiles();
        randomPuzzles();
        packFrame();    
    }
    
    public void packFrame()
    {
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setSize(400,400);
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
    }
    
    public void generatePuzzleTiles()
    {
        //skapa bitarna och lägg i array, för senare randomiza
        for(int i=0; i < 16; i++)
            puzzleList.add(new PuzzleTile(i));
    }
    
    public void randomPuzzles()
    {
        //denna loop för lägga bitarna random
        for(int i=0; i < 16; i++)
        {
            int rand = (int)(Math.random() * puzzleList.size() - 1);
            
            puzzleTile[i] = puzzleList.get(rand); 
            puzzleTile[i].addMouseListener(this);
            
            jFrame.getContentPane().add(puzzleTile[i]); // add it to the frame
            puzzleList.remove(rand);
        }
    }
    
    @Override
    public void mouseEntered(MouseEvent e)
    {
        if(e.getComponent().getBackground()!= Color.WHITE)
            e.getComponent().setBackground(Color.GRAY);
            // if the color of the tile is not white, turn the color of it to gray when the mouse button enter a tile.
    }
    
    /**
    * This method could change the color of the tile to dark gray when the mouse button exit a tile.
    * @param e the mouseevent when occurs
    */
    @Override
    public void mouseExited(MouseEvent e)
    {
        if(e.getComponent().getBackground()!= Color.WHITE)
            e.getComponent().setBackground(Color.darkGray);
            // if the color of the tile is not white, turn the color of it to garkgray when the mouse button exit a tile.
    }
    
    /**
    * This method could make the tile move to the blank when the player click a tile which is around the blank. It also
    * checks whether the player has finished the game and asks the player whether to play again or exit.
    * @param e the mouseevent when occurs
    */
    @Override
    public void mouseClicked(MouseEvent e)
    {
        int whiteTile = 0, choice = 0;
        int userX = e.getComponent().getX();
        int userY = e.getComponent().getY();
        
        boolean done = true;
        
        //get the empty tile aka whiteTile
        for (int x = 0; x < 16; x++)
            if (puzzleTile[x].getBackground() == Color.WHITE)
                whiteTile = x;
        
        int whiteX = puzzleTile[whiteTile].getX(); // get the x coordinate of the white tile’s origin.
        int whiteY = puzzleTile[whiteTile].getY(); // get the y coordinate of the white tile’s origin.

        if ((Math.abs(userX-whiteX) < 140 && Math.abs(userX - whiteX) > 1 && userY == whiteY) ||
                (Math.abs(userY-whiteY) < 140 && Math.abs(userY - whiteY) > 1 && userX == whiteX))
        {
            // if the tile which player has just clicked around the white tile.
            e.getComponent().setBackground(Color.WHITE); // set the background color of the tile which player has clicked to white.
            puzzleTile[whiteTile].setNumber(((PuzzleTile)e.getComponent()).getNumber());
            
            // put a number on the white tile. This number is just the number on the tile which player has clisked.
            puzzleTile[whiteTile].setBackground(Color.darkGray); // change the white tile’s color to darkgray.
        } // just finished the ‘move’ of the tile.

        for(int x=0; x < 16; x++ )
        {
            // check whether the order of the tile is: blank, 1, 2, 3, 4, 5, 6, 7, 8.
            if (puzzleTile[x].getBackground() == Color.WHITE)
            {
                continue;
            }
            if (!puzzleTile[x].getNumber().equals("" + x))
            {
                done = false;
                break;
            }
        } // check whether the game is over.
        
        if (done == true)
        {
            // if the game is over.
            choice = JOptionPane.showConfirmDialog (null, "Would you like to play again?", "You have won!!", JOptionPane.YES_NO_CANCEL_OPTION);
            
            // generate a window with 3 buttons: yes, no, cancel.
            if (choice == JOptionPane.YES_OPTION){
            // if the player clicks yes button.
            jFrame.setVisible(false); // make the current frame invisible.
            SlidingPuzzle myGame = new SlidingPuzzle();
            myGame.go();
            // make a new frame just as the former one.
            }
            if (choice == JOptionPane.NO_OPTION)
            {
                // if the player clicks no button.
                System.exit(0); // exit the program.
            }
        } 
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    public void mousePressed(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}

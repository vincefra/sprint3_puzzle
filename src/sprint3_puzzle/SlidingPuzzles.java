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
public class SlidingPuzzles extends JPanel implements MouseListener  {

    JFrame myFrame;
    ArrayList<PuzzleTile> myList = new ArrayList<>();
    PuzzleTile[] square;
    
    
    public SlidingPuzzles() {
        initComponents();
    }
    
    public void go()
    {
        myFrame = new JFrame("Numeric Sliding Puzzle");
        square = new PuzzleTile[16];
        myFrame.setLayout(new GridLayout(4,4)); //set the frame to be 3×3.
        
        for(int i=0; i < 16; i++)
        {
            PuzzleTile aTile = new PuzzleTile(i);
            myList.add(aTile);
            // generate 9 puzzletiles and add them to an ArrayList. 
        }
        
        for(int i=0; i < 16; i++)
        {
            int index= (int)(Math.random()*myList.size()-1);
            square[i] = myList.get(index); 
            // randomly get a puzzletile from the ArrayList and add it to an array called square.
            square[i].addMouseListener(this); // add mouselistener to it.
            myFrame.getContentPane().add(square[i]); // add it to the frame.
            myList.remove(index); // remove the puzzletile we have just got from the ArrayList.so that next time we won’t get it any more from the ArrayList.
            // this for loop make the puzzletile randomly displayed on the frame.
        }
        
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setSize(400,400);
        myFrame.setLocationRelativeTo(null);
        myFrame.setVisible(true);
    }
    
    @Override
    public void mouseEntered(MouseEvent e)
    {
        if(e.getComponent().getBackground()!= Color.WHITE)
        {
            e.getComponent().setBackground(Color.GRAY);
            // if the color of the tile is not white, turn the color of it to gray when the mouse button enter a tile.
        }
    }
    
    /**
    * This method could change the color of the tile to dark gray when the mouse button exit a tile.
    * @param e the mouseevent when occurs
    */
    @Override
    public void mouseExited(MouseEvent e)
    {
        if(e.getComponent().getBackground()!= Color.WHITE)
        {
            e.getComponent().setBackground(Color.darkGray);
            // if the color of the tile is not white, turn the color of it to garkgray when the mouse button exit a tile.
        }
    }
    
    /**
    * This method could make the tile move to the blank when the player click a tile which is around the blank. It also
    * checks whether the player has finished the game and asks the player whether to play again or exit.
    * @param e the mouseevent when occurs
    */
    @Override
    public void mouseClicked(MouseEvent e)
    {
        int num = 0, choice = 0;
        boolean done = true;
        int x = e.getComponent().getX(); // get the x coordinate of the tile’s origin which player has clicked.
        int y = e.getComponent().getY(); // get the y coordinate of the tile’s origin which player has clicked.

        for(int i=0; i < 16; i++ )
        {
            if (square[i].getBackground()==Color.WHITE)
            {
                num = i;
            }
        } // this for loop get the white tile in the array called square.
        
        int x2 = square[num].getX(); // get the x coordinate of the white tile’s origin.
        int y2 = square[num].getY(); // get the y coordinate of the white tile’s origin.

        if((Math.abs(x-x2) < 140 && Math.abs(x-x2) > 1 && y==y2) || (Math.abs(y-y2) < 140 && Math.abs(y-y2) > 1 && x == x2))
        {
            // if the tile which player has just clicked around the white tile.
            e.getComponent().setBackground(Color.WHITE); // set the background color of the tile which player has clicked to white.
            square[num].setNumber(((PuzzleTile)e.getComponent()).getNumber());
            
            // put a number on the white tile. This number is just the number on the tile which player has clisked.
            square[num].setBackground(Color.darkGray); // change the white tile’s color to darkgray.
        } // just finished the ‘move’ of the tile.

        for(int i=0; i < 16; i++ )
        {
            // check whether the order of the tile is: blank, 1, 2, 3, 4, 5, 6, 7, 8.
            if (square[i].getBackground() == Color.WHITE)
            {
                continue;
            }
            if (!square[i].getNumber().equals("" + i))
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
            myFrame.setVisible(false); // make the current frame invisible.
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

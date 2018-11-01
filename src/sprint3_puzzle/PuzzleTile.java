/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sprint3_puzzle;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

/**
 *
 * @author work
 */
public class PuzzleTile extends JPanel {
    
    private String tileNumber;  //the number that will display on the tile.
    
    /**
    * This constructor takes in the number you would like
    * displayed on this panel and saves it as the String
    * instance variable tileNumber. It also determines whether the puzzletile wouid be paint in 
    * white color or dark gray. 
    *
    * @param number The number to paint on the panel.
    */
    
    public PuzzleTile(int number) 
    {
        super();
        
        if (number == 0) 
            this.setBackground(Color.white);
        else 
            this.setBackground(Color.darkGray);
        
        this.tileNumber = "" + number;
    }
    
    /**
    * This is the paintComponent method that is called by the system. it first paint the background color.
    * Then it determine the format of the world on the puzzletile. Finally, it draw the tilenumber on it and set the 
    * string in center. Also, it set the border.
    * @param g the graphics on the panel. 
    */
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g); // paint the background color.
        g.setColor(Color.white); // set the color of the string on the tile.
        
        Font myFont = new Font("Arial", Font.BOLD, 30);
        g.setFont(myFont); // set the font of the string on the tile.
        
        FontMetrics a = g.getFontMetrics();
        
        int heigh = a.getHeight();
        int wid = a.stringWidth(tileNumber);
        
        g.drawString(tileNumber,(getWidth()-wid)/2,(getHeight()/2+heigh/2)); // set the string in the center of the tile.
        this.setBorder(BorderFactory.createLineBorder(Color.white)); // set the border.
    }
    
    /**
    * This method return the number on the puzzletile.
    * @return String the number on the puzzletile
    */
   
    public String getNumber()
    {
        return this.tileNumber;
    }

    public void setNumber(String s)
    {
        this.tileNumber = s;
    }
}

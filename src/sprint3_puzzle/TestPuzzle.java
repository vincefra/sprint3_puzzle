package sprint3_puzzle;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public final class TestPuzzle extends JFrame implements ActionListener 
{
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
            button.addActionListener(this);
            buttonList.add(button);
            panel.add(button);
        }
        
        buttonList.get(15).setText("");
        
        JButton newgame = new JButton("New game");
        panel.add(newgame);
        newgame.addActionListener(this);
        
        JButton finished = new JButton("Win");
        panel.add(finished);
        finished.addActionListener(this);
        
        generatePuzzleTiles();
        
        frame.pack();
        frame.setSize(400, 400);
        frame.setLocation(1000, 500);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    public void generatePuzzleTiles()
    {
        Integer[] randoms = new Integer[maxTiles-1];
        
        for (int x = 0; x < maxTiles-1; x++)
            randoms[x] = x+1;
        
        //shuffla våran randomlista
        Collections.shuffle(Arrays.asList(randoms));
       
        //sätt text på knapparna med vår randomlista, dock kvarstår knapparns ordning i buttonList
        for(int i = 0; i < maxTiles-1; i++) 
            buttonList.get(i).setText("" + randoms[i]);
    }
    
    public int getButtonPosition(String number)
    {
        for(int i = 0; i < maxTiles; i++) 
            if (buttonList.get(i).getText().equalsIgnoreCase(number))
                return i;
        
        return 0;
    }
    
    public JButton getButton(String number)
    {
        for(int i = 0; i < maxTiles; i++) 
            if (buttonList.get(i).getText().equalsIgnoreCase(number))
                return buttonList.get(i);
        
        return null;
    }
    
    public int getButtonWhitePosition()
    {
       for(int i = 0; i < maxTiles; i++) 
            if (buttonList.get(i).getText().equalsIgnoreCase(""))
                return i;
        
        return 0;
    }
    
    public void checkFinished(boolean test)
    {
        if (test)
        {
            for(int i = 0; i < maxTiles-1; i++)
                buttonList.get(i).setText("" + (i+1));
        }
        
        for(int i = 0; i < maxTiles-1; i++) 
            if (!buttonList.get(i).getText().equalsIgnoreCase("" + (i+1)))
                return;
 
        int choice = JOptionPane.showConfirmDialog (null, "Would you like to play again?", "Congrats my dear fellow, you have won!", JOptionPane.YES_NO_CANCEL_OPTION);

        if (choice == JOptionPane.YES_OPTION)
            generatePuzzleTiles();
        else if (choice == JOptionPane.NO_OPTION)
            System.exit(0);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getActionCommand().equalsIgnoreCase("New game"))
        {
            generatePuzzleTiles();
            return;
        }
        else if (e.getActionCommand().equalsIgnoreCase("Win"))
        {
            checkFinished(true);
            return;
        }
        
        //vi får fram knappens position genom att kolla igenom vilken knapp som har följande siffra
        int currentButtonPosition = getButtonPosition(e.getActionCommand());
        int currentWhitePosition = getButtonWhitePosition();
        JButton currentButton = getButton(e.getActionCommand());

        String temp;
        
        /*
            0 kan flytta till 1,4
            1 kan flytta till 0,5,2
            2 kan flytta till 1,6,3
            3 kan flytta till 2,7
            4 kan flytta till 0,5,8
            5 kan flytta till 1,4,9,6
            6 kan flytta till 2,5,7,10
            7 kan flytta till 3,6,11
            8 kan flytta till 4,9,12
            9 kan flytta till 5,8,10,13
            10 kan flytta till 6,9,11,14
            11 kan flytta till 7,10,15
            12 kan flytta till 8,13
            13 kan flytta till 12,9,14
            14 kan flytta till 13,10,15
            15 kan flytta till 14,11
        */
        
        switch (currentButtonPosition)
        {
            case 0:
            {
                if (getButtonWhitePosition() == 1 || getButtonWhitePosition() == 4)
                {
                    temp = buttonList.get(currentButtonPosition).getText();
                    currentButton.setText("");
                    buttonList.get(currentWhitePosition).setText(temp);
                }
                break;
            }
            
            case 1:
            {
                if (getButtonWhitePosition() == 0 || getButtonWhitePosition() == 5 || getButtonWhitePosition() == 2)
                {
                    temp = buttonList.get(currentButtonPosition).getText();
                    currentButton.setText("");
                    buttonList.get(currentWhitePosition).setText(temp);
                }
                break;
            }
            
            case 2:
            {
                if (getButtonWhitePosition() == 1 || getButtonWhitePosition() == 6 || getButtonWhitePosition() == 3)
                {
                    temp = buttonList.get(currentButtonPosition).getText();
                    currentButton.setText("");
                    buttonList.get(currentWhitePosition).setText(temp);
                }
                break;
            }
            case 3:
            {
                if (getButtonWhitePosition() == 2 || getButtonWhitePosition() == 7)
                {
                    temp = buttonList.get(currentButtonPosition).getText();
                    currentButton.setText("");
                    buttonList.get(currentWhitePosition).setText(temp);
                }
                break;
            }
            case 4:
            {
                if (getButtonWhitePosition() == 0 || getButtonWhitePosition() == 5 || getButtonWhitePosition() == 8)
                {
                    temp = buttonList.get(currentButtonPosition).getText();
                    currentButton.setText("");
                    buttonList.get(currentWhitePosition).setText(temp);
                }
                break;
            }
            case 5:
            {
                if (getButtonWhitePosition() == 1 || getButtonWhitePosition() == 4 || getButtonWhitePosition() == 9 || getButtonWhitePosition() == 6)
                {
                    temp = buttonList.get(currentButtonPosition).getText();
                    currentButton.setText("");
                    buttonList.get(currentWhitePosition).setText(temp);
                }
                break;
            }
            case 6:
            {
                if (getButtonWhitePosition() == 2 || getButtonWhitePosition() == 5 || getButtonWhitePosition() == 7 || getButtonWhitePosition() == 10)
                {
                    temp = buttonList.get(currentButtonPosition).getText();
                    currentButton.setText("");
                    buttonList.get(currentWhitePosition).setText(temp);
                }
                break;
            }
            case 7:
            {
                if (getButtonWhitePosition() == 3 || getButtonWhitePosition() == 6 || getButtonWhitePosition() == 11)
                {
                    temp = buttonList.get(currentButtonPosition).getText();
                    currentButton.setText("");
                    buttonList.get(currentWhitePosition).setText(temp);
                }
                break;
            }
            case 8:
            {
                if (getButtonWhitePosition() == 4 || getButtonWhitePosition() == 9 || getButtonWhitePosition() == 12)
                {
                    temp = buttonList.get(currentButtonPosition).getText();
                    currentButton.setText("");
                    buttonList.get(currentWhitePosition).setText(temp);
                }
                break;
            }
            
            case 9:
            {
                if (getButtonWhitePosition() == 5 || getButtonWhitePosition() == 8 || getButtonWhitePosition() == 10 || getButtonWhitePosition() == 13)
                {
                    temp = buttonList.get(currentButtonPosition).getText();
                    currentButton.setText("");
                    buttonList.get(currentWhitePosition).setText(temp);
                }
                break;
            }
            
            case 10:
            {
                if (getButtonWhitePosition() == 6 || getButtonWhitePosition() == 9 || getButtonWhitePosition() == 11 || getButtonWhitePosition() == 14)
                {
                    temp = buttonList.get(currentButtonPosition).getText();
                    currentButton.setText("");
                    buttonList.get(currentWhitePosition).setText(temp);
                }
                break;
            }
            
            case 11:
            {
                if (getButtonWhitePosition() == 7 || getButtonWhitePosition() == 10 || getButtonWhitePosition() == 15)
                {
                    temp = buttonList.get(currentButtonPosition).getText();
                    currentButton.setText("");
                    buttonList.get(currentWhitePosition).setText(temp);
                }
                break;
            }
            
            case 12:
            {
                if (getButtonWhitePosition() == 8 || getButtonWhitePosition() == 13)
                {
                    temp = buttonList.get(currentButtonPosition).getText();
                    currentButton.setText("");
                    buttonList.get(currentWhitePosition).setText(temp);
                }
                break;
            }
            
            case 13:
            {
                if (getButtonWhitePosition() == 12 || getButtonWhitePosition() == 9 || getButtonWhitePosition() == 14)
                {
                    temp = buttonList.get(currentButtonPosition).getText();
                    currentButton.setText("");
                    buttonList.get(currentWhitePosition).setText(temp);
                }
                break;
            }
            
            case 14:
            {
                if (getButtonWhitePosition() == 13 || getButtonWhitePosition() == 10 || getButtonWhitePosition() == 15)
                {
                    temp = buttonList.get(currentButtonPosition).getText();
                    currentButton.setText("");
                    buttonList.get(currentWhitePosition).setText(temp);
                }
                break;
            }
            
            case 15:
            {
                if (getButtonWhitePosition() == 14 || getButtonWhitePosition() == 11)
                {
                    temp = buttonList.get(currentButtonPosition).getText();
                    currentButton.setText("");
                    buttonList.get(currentWhitePosition).setText(temp);
                }
                break;
            }
        }
    }
}

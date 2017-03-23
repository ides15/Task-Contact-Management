/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 *
 * @author reesmcdevitt
 */
public class MainView extends JFrame
{
    private MainViewPanel mVPanel;
    
    
    MainView() 
    {
        super("Manager");
        mVPanel = new MainViewPanel();
        
        
        setSize(500,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(mVPanel);
    }
}

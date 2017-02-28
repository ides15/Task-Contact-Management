/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author reesmcdevitt
 */
public class UserLoginPanel extends JPanel
{
    private JButton login;
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JTextField usernameField;
    private JTextField passwordField;
    
    UserLoginPanel()
    {
        login = new JButton("Login");
        usernameLabel = new JLabel("Username: ");
        passwordLabel = new JLabel("Password: ");
        usernameField = new JTextField();
        passwordField = new JTextField();
        
        //TODO Add GUI Stuff with location 
        
    }
}

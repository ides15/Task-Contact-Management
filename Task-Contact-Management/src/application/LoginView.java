package application;

import javax.swing.JFrame;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author reesmcdevitt
 */
public class LoginView extends JFrame
{
    private LoginModel navModel;
    private LoginViewPanel loginViewPanel;
    
    LoginView(LoginModel navModel) 
    {
        super("Manager");
        this.navModel = navModel;
        
        setSize(500,600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        
        loginViewPanel = new LoginViewPanel();
        add(loginViewPanel);
    }
}

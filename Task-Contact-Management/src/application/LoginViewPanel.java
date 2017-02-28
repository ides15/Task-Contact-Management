/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.awt.BorderLayout;
import javax.swing.JPanel;

/**
 *
 * @author reesmcdevitt
 */
public class LoginViewPanel extends JPanel
{
    private LoginMenu loginMenu;
    private UserLoginPanel userLogin;
    
    LoginViewPanel()
    {
        super();
        setLayout(new BorderLayout());
        
        loginMenu = new LoginMenu();
        userLogin = new UserLoginPanel();
        
        //add(loginMenu, BorderLayout.NORTH);
        //add(userLogin, BorderLayout.CENTER);
    }
}

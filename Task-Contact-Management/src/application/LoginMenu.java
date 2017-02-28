/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author reesmcdevitt
 */
public class LoginMenu extends JPanel
{
    private JButton userLoginButton;
    private JButton newUserButton;
    
    LoginMenu()
    {
        super();
        
        userLoginButton = new JButton("Login");
        newUserButton = new JButton("New User");
        
        add(userLoginButton);
        add(newUserButton);
        
    }

    public JButton getUserLoginButton() {
        return userLoginButton;
    }

    public void setUserLoginButton(JButton userLoginButton) {
        this.userLoginButton = userLoginButton;
    }

    public JButton getNewUserButton() {
        return newUserButton;
    }

    public void setNewUserButton(JButton newUserButton) {
        this.newUserButton = newUserButton;
    }
}

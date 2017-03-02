/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author reesmcdevitt
 */
public class LoginCntl 
{
    private LoginModel loginModel;
    private LoginView loginView;
    
    private LoginViewPanel loginViewPanel;
    
    private UserLoginPanel userLoginPanel;
    private NewUserLoginPanel newUserLoginPanel;
    
    LoginCntl(LoginModel loginModel, LoginView loginView)
    {        
        this.loginModel = loginModel;
        this.loginView = loginView;
        
        userLoginPanel = new UserLoginPanel();
        newUserLoginPanel = new NewUserLoginPanel();
        
        loginView.addUserSubmitButtonListener(new UserSubmitButtonListener());
        loginView.addNewUserButtonListener(new NewUserButtonListener());
    }
    
    class UserSubmitButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e) 
        {                        
            userLoginPanel.getUserSubmitButton().addActionListener(new UserSubmitButtonListener());
            // no idea how this works tbh
        }
    
    }
    
    class NewUserButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e) 
        {
            System.out.println("new user button pressed");
//            loginView.switchToNewUser(newUserLoginPanel);
        }
    
    }
    
    class BackButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e) 
        {
//            loginView.switchToUserLogin(userLoginPanel);
            
            System.out.println("Back button pressed");
        }
    
    }
    
    class NewUserSubmitButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e) 
        {
            System.out.println("New User Submit button pressed");
        }
    
    }
}

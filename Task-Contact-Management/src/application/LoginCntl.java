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
    
    private UserLoginPanel userLoginPanel;
    private NewUserLoginPanel newUserLoginPanel;
    
    
    LoginCntl(LoginModel loginModel, LoginView loginView)
    {
        this.loginModel = loginModel;
        this.loginView = loginView;
        
        newUserLoginPanel = new NewUserLoginPanel();
        
//        loginView.addUserLoginPanelListener(new UserLoginButtonListener());
//        loginView.addNewUserPanelListener(new NewUserButtonListener());
                
    }
    
    class UserLoginButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e) 
        {
            loginView.switchToUserLogin(userLoginPanel);
            
            // HERE: Connects Panels 
        }
    
    }
    
    class NewUserButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e) 
        {
            
            loginView.switchToNewUser(newUserLoginPanel);
            
        }
    
    }
    
    class BackButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e) 
        {
            loginView.switchToUserLogin(userLoginPanel);
            
            // HERE: Connects Panels 
        }
    
    }
    
    class SubmitButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e) 
        {
            
            
            // HERE: Reads the inputs from the user
        }
    
    }
}

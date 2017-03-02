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
    private Database db;
    
    private LoginModel loginModel;
    private LoginView loginView;
    
    private UserLoginPanel userLoginPanel;
    private NewUserLoginPanel newUserLoginPanel;
    
    LoginCntl(LoginModel loginModel, LoginView loginView)
    {
        db = new Database("tcm.db");
        db.connectToDatabase();
        
        this.loginModel = loginModel;
        this.loginView = loginView;
        
        userLoginPanel = new UserLoginPanel();
//        newUserLoginPanel = new NewUserLoginPanel();
        
        loginView.addUserSubmitButtonListener(new UserSubmitButtonListener());
        loginView.addNewUserButtonListener(new NewUserButtonListener());
    }
    
    class UserSubmitButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e) 
        {
//            loginView.switchToUserLogin(userLoginPanel);
            
            System.out.println("Submit button pressed");
            
            String username = userLoginPanel.getUsernameTextField().getText();
            String password = userLoginPanel.getPasswordTextField().getText();
            
            db.authenticate("User", username, password);
        }
    
    }
    
    class NewUserButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e) 
        {
//            loginView.switchToNewUser(newUserLoginPanel);
            
            System.out.println("New User button pressed");
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


package application;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author reesmcdevitt
 */
public class LoginCntl 
{
    private Database loginModel;
    private LoginView loginView;
    
    private LoginViewPanel loginViewPanel;
    
    private UserLoginPanel userLoginPanel;
    private NewUserLoginPanel newUserLoginPanel;
    
    private String username;
    private String password;
    
    private NavView navView;
    private NavModel navModel;
    private NavCntl navCntl;
    
//    private int userID;
    
   
    
    LoginCntl(Database loginModel, LoginView loginView)
    {   

        this.loginModel = loginModel;
        this.loginView = loginView;
        
        loginView.setVisible(true);
        
        userLoginPanel = new UserLoginPanel();
        newUserLoginPanel = new NewUserLoginPanel();
        
        navModel = new NavModel();
        navView = new NavView(navModel);
        navCntl = new NavCntl(navModel, navView);
        
       
        
        loginView.getLoginViewPanel().getUserLoginPanel().getFailedLoginLabel().setVisible(false);
        loginView.addUserSubmitButtonListener(new UserLoginButtonListener());
        loginView.addNewUserButtonListener(new NewUserButtonListener());
        loginView.addBackButtonListener(new BackButtonListener());
        
        
        //Need Everything here for multiple switches not sure why
        newUserLoginPanel.getBackButton().addActionListener(new BackButtonListener());
        userLoginPanel.getNewUserButton().addActionListener(new NewUserButtonListener());
        newUserLoginPanel.getNewUserSubmitButton().addActionListener(new NewUserSubmitButtonListener());
        
        userLoginPanel.getUserSubmitButton().addActionListener(new UserLoginButtonListener());
    }

    /**
     * @return the userID
     */
  
    
    class UserLoginButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)      
        {
            username = loginView.getLoginViewPanel().getUserLoginPanel().getUsernameTextField().getText();
            password = loginView.getLoginViewPanel().getUserLoginPanel().getPasswordTextField().getText();

            int[] authenticated = loginModel.authenticate("User", username, password);
            
            //Logic for new Windows or Error
            if(authenticated[0] == 1)
            {
                navView.setVisible(true);
                loginView.setVisible(false);
                navCntl.setUserID(authenticated[1]);
                System.out.println("LoginCntl: " + authenticated[1]);
                System.out.println("NavCntl: " + navCntl.getUserID());
                navCntl.getTaskCntl().setUserID(authenticated[1]);
                navCntl.getTaskCntl().getTaskView().getModel().setDataVector(navCntl.getTaskCntl().getTaskModel().getTaskInfo(authenticated[1]), navCntl.getTaskCntl().getTaskView().getColNames());
                navCntl.getTaskCntl().getTaskView().getTaskTable().setModel(navCntl.getTaskCntl().getTaskView().getModel());
                
                System.out.println("TaskCntl: " + navCntl.getTaskCntl().getUserID());
            }
            else
            {
                System.out.println("Failed Login");
                loginView.getLoginViewPanel().getUserLoginPanel().getFailedLoginLabel().setVisible(true);
            }
 
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
        }
    
    }
    
    class NewUserSubmitButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e) 
        {
            newUserLoginPanel.getNewUserSubmitButton().addActionListener(new NewUserSubmitButtonListener());
        }
    } 
}

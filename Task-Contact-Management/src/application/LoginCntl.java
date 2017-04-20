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
    
    private NavViewPanel navPanel;
    private NavView navView;
    private NavModel navModel;
    private NavCntl navCntl;
    
    private String[] searchNames = null;
    
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

    public void setTaskTable(int userID)
    {
        navCntl.getTaskCntl().getTaskView().getModel()
                .setDataVector(navCntl.getTaskCntl().getTaskModel()
                        .getTaskInfo(userID), navCntl.getTaskCntl().getTaskView().getColNames());
                        
        navCntl.getTaskCntl().getTaskView().getTaskTable()
                .setModel(navCntl.getTaskCntl().getTaskView().getModel());
    }
    
    public void setContactTable(int userID)
    {
        navCntl.getContactCntl().getContactView().getModel()
                .setDataVector(navCntl.getContactCntl().getContactModel()
                        .getContactInfo(userID), navCntl.getContactCntl().getContactView().getColNames());
        
        navCntl.getContactCntl().getContactView().getContactTable()
                .setModel(navCntl.getContactCntl().getContactView().getModel());
    }
    
    public void setMainTable(int userID)
    {
        Object[][] noTasks = new Object[1][1];
        noTasks[0][0] = "No Tasks";
        
        
        if(navCntl.getMainView().getMainModel().getTaskDate(userID, navCntl.getMainView().getDate()).length != 0)
        {
            navCntl.getMainView().getModel().setDataVector(navCntl.getMainView()
                    .getMainModel().getTaskDate(userID, navCntl.getMainView().getDate()), 
                    navCntl.getMainView().getColNames()); 

            navCntl.getMainView().getTaskTable().setModel(navCntl.getMainView().getModel());
        }
        else
        {
            navCntl.getMainView().getModel().setDataVector(noTasks, 
                    navCntl.getMainView().getColNames()); 

            navCntl.getMainView().getTaskTable().setModel(navCntl.getMainView().getModel());
        }
    }
    
    public void setSearch(int userID)
    {
        searchNames = navCntl.getMainView().getMainModel().getTaskNames(userID);
        
        for (String searchName : searchNames) {
            navCntl.getMainView().getSearchBar().addItem(searchName);
        }
    }
    
    public void setWelcome(int userID)
    {
       navView.getSplash().getWelcomeLabel().setText("Welcome " + loginModel.getUserFirstName(userID) + " to your Task and Contact Manager");
    }
    
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
                
                loginModel.setCurrentUserId(authenticated[1]);
                navCntl.getTaskCntl().getTaskModel().setCurrentUserId(loginModel.getCurrentUserId());
                navCntl.getContactCntl().getContactModel().setCurrentUserId(loginModel.getCurrentUserId());
                navCntl.getMainView().getMainModel().setCurrentUserId(loginModel.getCurrentUserId());
                

                // ^^^ this passes the user id in login model to the user id in the task model
                // they are referencing two different instances of database so the user id
                // isn't transferring between the two automatically
                
                setTaskTable(loginModel.getCurrentUserId());
                setContactTable(loginModel.getCurrentUserId());
                setMainTable(loginModel.getCurrentUserId());
                setSearch(loginModel.getCurrentUserId());
                setWelcome(loginModel.getCurrentUserId());
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

package application;

import java.awt.event.ActionListener;
import javax.swing.JFrame;

/*

 */
public class LoginView extends JFrame
{
    private LoginModel loginModel;
    private LoginViewPanel loginViewPanel;
    UserLoginPanel userLoginPanel;
    NewUserPanel newUserPanel;
    
    LoginView(LoginModel loginModel) 
    {
        super("Manager");
        this.loginModel = loginModel;
        
        setSize(400,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
 
        loginViewPanel = new LoginViewPanel();
        add(loginViewPanel); 
    }
    
    //Meathods to switch panels
    public void switchToUserLogin(UserLoginPanel userLoginPanel)
    {
        loginViewPanel.removeNewUserPanel();
        loginViewPanel.addUserLoginPanel(userLoginPanel);
    }
    
    public void switchToNewUser(NewUserPanel newUserPanel)
    {
        loginViewPanel.removeUserLoginPanel();
        loginViewPanel.addNewUserPanel(newUserPanel);
    }
    
    //ActionListener Meathods
    public void addUserLoginPanelListener(ActionListener al)
    {
        loginViewPanel.getUserLoginPanel().getLoginButton().addActionListener(al);
    }
    public void addNewUserPanelListener(ActionListener al)
    {
        loginViewPanel.getUserLoginPanel().getnewUserButton().addActionListener(al);
    }
  
    
}

package application;

import java.awt.event.ActionListener;
import javax.swing.JFrame;

/*

 */
public class LoginView extends JFrame
{
    private LoginModel loginModel;
    private LoginViewPanel loginViewPanel;
    
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
        loginViewPanel.removeNewUserLoginPanel();
        loginViewPanel.addUserLoginPanel(userLoginPanel);
    }
    
    public void switchToNewUser(NewUserLoginPanel newUserLoginPanel)
    {
        loginViewPanel.removeUserLoginPanel();
        loginViewPanel.addNewUserPanel(newUserLoginPanel);
    }
    
    //ActionListener Meathods
    public void addUserSubmitButtonListener(ActionListener al)
    {
        loginViewPanel.getUserLoginPanel().getUserSubmitButton().addActionListener(al);
    }
    
    public void addNewUserButtonListener(ActionListener al)
    {
        loginViewPanel.getUserLoginPanel().getNewUserButton().addActionListener(al);
    }
    public void addBackButtonListener(ActionListener al)
    {
        loginViewPanel.getNewUserLoginPanel().getBackButton().addActionListener(al);
    }
    
}

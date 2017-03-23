package application;

import java.awt.event.ActionListener;
import javax.swing.JFrame;

/*

 */
public class LoginView extends JFrame
{
    private Database loginModel;
    private LoginViewPanel loginViewPanel;
    
    LoginView(Database loginModel) 
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
        loginViewPanel.removePanel(loginViewPanel.newUserLoginPanel);
        loginViewPanel.addPanel(loginViewPanel.userLoginPanel);
    }
    
    public void switchToNewUser(NewUserLoginPanel newUserLoginPanel)
    {
        loginViewPanel.removePanel(loginViewPanel.userLoginPanel);
        loginViewPanel.addPanel(loginViewPanel.newUserLoginPanel);
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

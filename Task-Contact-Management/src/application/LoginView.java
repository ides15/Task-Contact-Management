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
        getLoginViewPanel().removePanel(getLoginViewPanel().newUserLoginPanel);
        getLoginViewPanel().addPanel(getLoginViewPanel().getUserLoginPanel());
    }
    
    public void switchToNewUser(NewUserLoginPanel newUserLoginPanel)
    {
        getLoginViewPanel().removePanel(getLoginViewPanel().getUserLoginPanel());
        getLoginViewPanel().addPanel(getLoginViewPanel().newUserLoginPanel);
    }
    
    //ActionListener Meathods
    public void addUserSubmitButtonListener(ActionListener al)
    {
        getLoginViewPanel().getUserLoginPanel().getUserSubmitButton().addActionListener(al);
    }
    
    public void addNewUserButtonListener(ActionListener al)
    {
        getLoginViewPanel().getUserLoginPanel().getNewUserButton().addActionListener(al);
    }
    public void addBackButtonListener(ActionListener al)
    {
        getLoginViewPanel().getNewUserLoginPanel().getBackButton().addActionListener(al);
    }

    /**
     * @return the loginViewPanel
     */
    public LoginViewPanel getLoginViewPanel() {
        return loginViewPanel;
    }
    
    
}

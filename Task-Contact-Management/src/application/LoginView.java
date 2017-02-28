package application;

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
}

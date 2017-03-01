/*

 */
package application;

import java.awt.BorderLayout;
import javax.swing.JPanel;


public class LoginViewPanel extends JPanel
{

    private UserLoginPanel userLoginPanel;
    private NewUserPanel newUserPanel;
    
    LoginViewPanel()
    {
        super();
        setLayout(new BorderLayout());
        

        userLoginPanel = new UserLoginPanel();
       
        

       add(userLoginPanel, BorderLayout.CENTER);
      
    }
    
    // User Login meathods to adds and remove panel
    public void addUserLoginPanel(UserLoginPanel userLogin)
    {
        this.userLoginPanel = userLogin;
        add(userLogin, BorderLayout.CENTER);
        revalidate();
        repaint();
    }
    
    public void removeUserLoginPanel()
    {
        if(this.userLoginPanel != null)
        {
            remove(this.userLoginPanel);
        }
    }
    
    // New User meathods to adds and remove panel
    public void addNewUserPanel(NewUserPanel newUser)
    {
        this.newUserPanel = newUser;
        add(newUser, BorderLayout.CENTER);
        revalidate();
        repaint();
    }
    
    public void removeNewUserPanel()
    {
        if(this.newUserPanel != null)
        {
            remove(this.newUserPanel);
        }
    }
    
    public UserLoginPanel getUserLoginPanel()
    {
        return userLoginPanel;
    }
    
    public NewUserPanel getNewUserPanel()
    {
        return newUserPanel;
    }
  
}

/*

 */
package application;

import javax.swing.JPanel;

public class LoginViewPanel extends JPanel
{
    public UserLoginPanel userLoginPanel;
    private NewUserLoginPanel newUserLoginPanel;
    
    LoginViewPanel()
    {
        super();

        userLoginPanel = new UserLoginPanel();
        newUserLoginPanel = new NewUserLoginPanel();
        
        add(userLoginPanel);
    }
    
    // User Login meathods to adds and remove panel
    public void addUserLoginPanel(UserLoginPanel userLoginPanel)
    {
        this.userLoginPanel = userLoginPanel;
        add(userLoginPanel);
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
    public void addNewUserPanel(NewUserLoginPanel newUserLoginPanel)
    {
        this.newUserLoginPanel = newUserLoginPanel;
        add(newUserLoginPanel);
        revalidate();
        repaint();
    }
    
    public void removeNewUserLoginPanel()
    {
        if(this.newUserLoginPanel != null)
        {
            remove(this.newUserLoginPanel);
        }
    }
    
    public UserLoginPanel getUserLoginPanel()
    {
        return userLoginPanel;
    }
    
    public NewUserLoginPanel getNewUserLoginPanel()
    {
        return newUserLoginPanel;
    }
  
}

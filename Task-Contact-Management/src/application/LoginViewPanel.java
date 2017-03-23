/*

 */
package application;

import javax.swing.JPanel;

public class LoginViewPanel extends JPanel
{
    private UserLoginPanel userLoginPanel;
    public NewUserLoginPanel newUserLoginPanel;
    
    LoginViewPanel()
    {
        super();

        userLoginPanel = new UserLoginPanel();
        newUserLoginPanel = new NewUserLoginPanel();
        
        add(userLoginPanel);
    }
    
    public void removePanel(JPanel panel) {
        if(panel != null) remove(panel);
    }
    
    public void addPanel(JPanel panel) {
        if (panel == this.getUserLoginPanel()) panel = this.getUserLoginPanel();
        if (panel == this.newUserLoginPanel) panel = this.newUserLoginPanel;
        
        add(panel);
        revalidate();
        repaint();
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

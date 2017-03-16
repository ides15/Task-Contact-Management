/*

 */
package application;

import javax.swing.JPanel;

public class LoginViewPanel extends JPanel
{
    public UserLoginPanel userLoginPanel;
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
        if (panel == this.userLoginPanel) panel = this.userLoginPanel;
        if (panel == this.newUserLoginPanel) panel = this.newUserLoginPanel;
        
        add(panel);
        revalidate();
        repaint();
    }
    
    // User Login meathods to adds and remove panel
//    public void addUserLoginPanel(UserLoginPanel userLoginPanel)
//    {
//        this.userLoginPanel = userLoginPanel;
//        add(userLoginPanel);
//        revalidate();
//        repaint();
//    }
    
    // New User meathods to adds and remove panel
//    public void addNewUserPanel(NewUserLoginPanel newUserLoginPanel)
//    {
//        this.newUserLoginPanel = newUserLoginPanel;
//        add(newUserLoginPanel);
//        revalidate();
//        repaint();
//    }
    
    public UserLoginPanel getUserLoginPanel()
    {
        return userLoginPanel;
    }
    
    public NewUserLoginPanel getNewUserLoginPanel()
    {
        return newUserLoginPanel;
    }
  
}

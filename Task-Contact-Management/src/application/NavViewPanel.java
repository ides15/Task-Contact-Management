package application;


import javax.swing.JButton;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author glennlin
 */
public class NavViewPanel extends JPanel
{
    private JButton mainButton;
    private JButton contactButton;
    private JButton taskButton;
    private JButton settingsButton;
    private JButton logoffButton;
    
    NavViewPanel()
    {
        super();
        
        mainButton = new JButton("Main");
        contactButton = new JButton("Contacts");
        taskButton = new JButton("Tasks");
        settingsButton = new JButton("Settings");
        logoffButton = new JButton("Logoff");
        
        add(mainButton);
        add(contactButton);
        add(taskButton);
        add(settingsButton);
        add(logoffButton);
    }
    
    


    public JButton getContactButton() {
        return contactButton;
    }

    public void setContactButton(JButton ContactButton) {
        this.contactButton = ContactButton;
    }

    public JButton getTaskButton() {
        return taskButton;
    }

    public void setTaskButton(JButton TaskButton) {
        this.taskButton = TaskButton;
    }

    public JButton getSettingsButton() {
        return settingsButton;
    }

    public void setSettingsButton(JButton SettingButton) {
        this.settingsButton = SettingButton;
    }

    public JButton getMainButton() {
        return mainButton;
    }

    public void setMainButton(JButton MainButton) {
        this.mainButton = MainButton;
    }
    
    public JButton getLogoffButton() {
        return logoffButton;
    }
    
    public void setLogoffButton(JButton LogoffButton) {
        this.logoffButton = LogoffButton;
    }
    
}

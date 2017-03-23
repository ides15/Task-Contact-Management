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
    private JButton MainButton;
    private JButton ContactButton;
    private JButton TaskButton;
    private JButton SettingsButton;
    
    NavViewPanel()
    {
        super();
        
        MainButton = new JButton("Main");
        ContactButton = new JButton("Contacts");
        TaskButton = new JButton("Tasks");
        SettingsButton = new JButton("Settings");
        
        add(MainButton);
        add(ContactButton);
        add(TaskButton);
        add(SettingsButton);
    }
    
    


    public JButton getContactButton() {
        return ContactButton;
    }

    public void setContactButton(JButton ContactButton) {
        this.ContactButton = ContactButton;
    }

    public JButton getTaskButton() {
        return TaskButton;
    }

    public void setTaskButton(JButton TaskButton) {
        this.TaskButton = TaskButton;
    }

    public JButton getSettingsButton() {
        return SettingsButton;
    }

    public void setSettingsButton(JButton SettingButton) {
        this.SettingsButton = SettingButton;
    }

    public JButton getMainButton() {
        return MainButton;
    }

    public void setMainButton(JButton MainButton) {
        this.MainButton = MainButton;
    }
    
    
    
}

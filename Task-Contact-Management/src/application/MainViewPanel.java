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
public class MainViewPanel extends JPanel{
    private JButton ContactButton;
    private JButton TaskButton;
    private JButton SettingButton;
    
    MainViewPanel()
    {
        super();
        
        ContactButton = new JButton("Contacts");
        TaskButton = new JButton("Tasks");
        SettingButton = new JButton("Settings");
        
        add(ContactButton);
        add(TaskButton);
        add(SettingButton);
    }

    /**
     * @return the ContactButton
     */
    public JButton getContactButton() {
        return ContactButton;
    }

    /**
     * @param ContactButton the ContactButton to set
     */
    public void setContactButton(JButton ContactButton) {
        this.ContactButton = ContactButton;
    }

    /**
     * @return the TaskButton
     */
    public JButton getTaskButton() {
        return TaskButton;
    }

    /**
     * @param TaskButton the TaskButton to set
     */
    public void setTaskButton(JButton TaskButton) {
        this.TaskButton = TaskButton;
    }

    /**
     * @return the SettingButton
     */
    public JButton getSettingButton() {
        return SettingButton;
    }

    /**
     * @param SettingButton the SettingButton to set
     */
    public void setSettingButton(JButton SettingButton) {
        this.SettingButton = SettingButton;
    }
    
    
    
}

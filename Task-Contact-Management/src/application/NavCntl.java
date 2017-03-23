/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author reesmcdevitt
 */
public class NavCntl {
    
    private NavModel navModel;
    private NavView navView;
    
    private MainView mainView;
    private ContactView conView;
    private TaskView taskView;
    private SettingsView setView;
    
    
    NavCntl(NavModel navModel, NavView navView)
    {
        this.navModel = navModel;
        this.navView = navView;
        
        mainView = new MainView();
        conView = new ContactView();
        taskView = new TaskView();
        setView = new SettingsView();
        
        navView.addMainButtonListener(new MainButtonListener());
        navView.addContactButtonListener(new ContactButtonListener());
        navView.addTaskButtonListener(new TaskButtonListener());
        navView.addSettingsButtonListener(new SettingsButtonListener());
    }
    
     class MainButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e) 
        {
            navView.switchToMainPanel(mainView);
        }
    }
     
     class ContactButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e) 
        {
            navView.switchToContactPanel(conView);
        }
    }
     
     class TaskButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e) 
        {
            navView.switchToTaskPanel(taskView);
        }
    }
     
     class SettingsButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e) 
        {
           navView.switchToSettingsPanel(setView);
        }
    }
    
}

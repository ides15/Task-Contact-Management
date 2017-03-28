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
    private SettingsView setView;
    
    private Database taskModel;
    private TaskView taskView;
    private TaskCntl taskCntl;
    
    ContactView ContactView;
    ContactCntl ContactCntl;
    Database ContactModel;
    
    NavCntl(NavModel navModel, NavView navView)
    {
        this.navModel = navModel;
        this.navView = navView;
        
        mainView = new MainView();
        setView = new SettingsView();
        
        taskModel = new Database("tcm.db");
        taskView = new TaskView(taskModel);
        taskCntl = new TaskCntl(taskModel, taskView);
        
        ContactModel = new Database("tcm.db");
        ContactView = new ContactView(ContactModel);
        ContactCntl = new ContactCntl(ContactModel, ContactView);
        
        
        
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
            navView.switchToContactPanel(ContactView);
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

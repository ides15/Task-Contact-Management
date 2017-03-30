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
 * @author glennlin
 */
public class ContactCntl {
    ContactView contactView;
    Database contactModel;
    AddContact addContact;
    private MainView mainView;
    private ContactView conView;
    private TaskView taskView;
    private SettingsView setView;
     
     ContactCntl(Database contactModel, ContactView contactView)
    {
        this.contactModel = contactModel;
        this.contactView = contactView;
        
        
        addContact = new AddContact();
        addContact.setVisible(false);
        
        
        
        contactView.addAddButtonListener(new addButtonListener());
        contactView.addDeleteButtonListener(new deleteButtonListener());
        contactView.addUpdateButtonListener(new updateButtonListener());
      
        
    }
      class addButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e) 
        {
            addContact.setVisible(true);
        }
    }
     
     class deleteButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e) 
        {
            
        }
    }
     
     class updateButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e) 
        {
           
        }
    }
}

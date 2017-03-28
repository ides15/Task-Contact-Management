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
    ContactView ContactView;
    Database ContactModel;
    addContact addContact;
    private MainView mainView;
    private ContactView conView;
    private TaskView taskView;
    private SettingsView setView;
     
     ContactCntl(Database ContactModel, ContactView ContactView)
    {
        this.ContactModel = ContactModel;
        this.ContactView = ContactView;
        
        
        addContact = new addContact();
        addContact.setVisible(false);
        
        
        
        ContactView.addAddButtonListener(new addButtonListener());
        ContactView.addDeleteButtonListener(new deleteButtonListener());
        ContactView.addUpdateButtonListener(new updateButtonListener());
      
        
    }
      class addButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e) 
        {
            addContact.setVisible(true);
            System.out.println("test");
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

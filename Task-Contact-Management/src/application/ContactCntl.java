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
    addContact addContact;
    
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String address;
    
    private Object[][] table;
     
     ContactCntl(Database contactModel, ContactView contactView)
    {
        this.contactModel = contactModel;
        this.contactView = contactView;
        
        
        addContact = new addContact();
        addContact.setVisible(false);
        
        
        
        contactView.addAddButtonListener(new addButtonListener());
        contactView.addDeleteButtonListener(new deleteButtonListener());
        contactView.addUpdateButtonListener(new updateButtonListener());
        contactView.getAddContact().addAddContactButtonListener(new AddContactButtonListener()); 
      
        
    }
     class AddContactButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e) 
        {
          firstName = contactView.getAddContact().getFirstNameField().getText();
          lastName = contactView.getAddContact().getLastNameField().getText();
          phoneNumber = contactView.getAddContact().getPhoneField().getText();
          email = contactView.getAddContact().getEmailField().getText();
          address = contactView.getAddContact().getAddressField().getText() + " ," + contactView.getAddContact().getCityField().getText() + " ," + contactView.getAddContact().getStateField().getText() + " ," + contactView.getAddContact().getZipField().getText();
          
          if(firstName.equals("") || lastName.equals(""))
          {
              System.out.println("Error Adding Contact");
          }
          else
          {
              contactModel.addContact(firstName, lastName, phoneNumber, email, address);
              contactView.getAddContact().setVisible(false);
              contactView.getModel().setDataVector(contactModel.getContactInfo(), contactView.getColNames()); 
              contactView.getContactTable().setModel(contactView.getModel());
          }          
        }
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

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
    private ContactView contactView;
    private Database contactModel;
    //addContact addContact;
    
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
        
        
//        addContact = new addContact();
//        addContact.setVisible(false);
        
        
        
        contactView.addAddButtonListener(new addButtonListener());
        contactView.addDeleteButtonListener(new deleteButtonListener());
        contactView.getAddContact().addAddContactButtonListener(new AddContactButtonListener()); 
      
        
    }

    /**
     * @return the contactView
     */
    public ContactView getContactView() {
        return contactView;
    }

    /**
     * @param contactView the contactView to set
     */
    public void setContactView(ContactView contactView) {
        this.contactView = contactView;
    }

    /**
     * @return the contactModel
     */
    public Database getContactModel() {
        return contactModel;
    }

    /**
     * @param contactModel the contactModel to set
     */
    public void setContactModel(Database contactModel) {
        this.contactModel = contactModel;
    }
     class AddContactButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e) 
        {
            firstName = getContactView().getAddContact().getFirstNameField().getText();
            lastName = getContactView().getAddContact().getLastNameField().getText();
            phoneNumber = getContactView().getAddContact().getPhoneField().getText();
            email = getContactView().getAddContact().getEmailField().getText();
            address = getContactView().getAddContact().getAddressField().getText()
                    + " ," + getContactView().getAddContact().getCityField().getText()
                    + " ," + getContactView().getAddContact().getStateField().getText()
                    + " ," + getContactView().getAddContact().getZipField().getText();
          
            if(firstName.equals("") || lastName.equals(""))
            {
                System.out.println("Error Adding Contact");
            }
            else
            {
                getContactModel().addContact(firstName, lastName, phoneNumber, email, address);
                getContactView().getAddContact().setVisible(false);
                getContactView().getModel().setDataVector(getContactModel().getContactInfo(getContactModel().getCurrentUserId()), getContactView().getColNames());
                getContactView().getContactTable().setModel(getContactView().getModel());
            }          
        }
    }
     
      class addButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e) 
        {
            getContactView().getAddContact().setVisible(true);
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

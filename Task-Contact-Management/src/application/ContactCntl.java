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
    
    private Object[][] table;
     
    ContactCntl(Database contactModel, ContactView contactView)
    {
        this.contactModel = contactModel;
        this.contactView = contactView;
        
        contactView.addAddButtonListener(new addButtonListener());
        contactView.addDeleteButtonListener(new deleteButtonListener());
        contactView.addUpdateButtonListener(new updateButtonListener());
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
    
    public void updateTable() {
        getContactView().getModel().setDataVector(getContactModel()
                .getContactInfo(getContactModel().getCurrentUserId()), getContactView().getColNames());
        getContactView().getContactTable().setModel(getContactView().getModel());
    }
    
    class AddContactButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e) 
        {
            String firstName = getContactView().getAddContact().getFirstNameField().getText();
            String lastName = getContactView().getAddContact().getLastNameField().getText();
            String phoneNumber = getContactView().getAddContact().getPhoneField().getText();
            String email = getContactView().getAddContact().getEmailField().getText();
            String address = getContactView().getAddContact().getAddressField().getText()
                    + " ," + getContactView().getAddContact().getCityField().getText()
                    + " ," + getContactView().getAddContact().getStateField().getText()
                    + " ," + getContactView().getAddContact().getZipField().getText();
            System.out.println("address: " + address);
          
            if(firstName.equals("") || lastName.equals(""))
            {
                System.out.println("Error Adding Contact");
            }
            else
            {
                getContactModel().addContact(firstName, lastName, phoneNumber, email, address);
                getContactView().getAddContact().setVisible(false);
                updateTable();
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
            getContactModel().deleteContact((String) getContactView()
                    .getContactTable().getModel().getValueAt(getContactView().getContactTable().getSelectedRow(), 0));
            updateTable();
        }
    }
     
    class updateButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e) 
        {
           getContactView().getUpdateContact().setVisible(true);
           getContactView().getUpdateContact().setContactId(getContactView().getUpdateContact().getContactId());
        }
    }
}


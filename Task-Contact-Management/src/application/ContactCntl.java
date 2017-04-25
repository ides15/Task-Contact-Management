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
        contactView.getUpdateContact().addUpdateContactButtonListener(new updateContactButtonListener());
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
            String address = getContactView().getAddContact().getAddressField().getText();
            
            if(firstName.equals("") || lastName.equals(""))
            {
                System.out.println("Error Adding Contact");
            }
            else
            {
                getContactModel().addContact(firstName, lastName, phoneNumber, email, address);
                //getContactView().getUpdateContact().setContactId(1000);
                getContactView().getAddContact().dispose();
                getContactView().getAddContact().getFirstNameField().setText("");
                getContactView().getAddContact().getLastNameField().setText("");
                getContactView().getAddContact().getAddressField().setText("");
                getContactView().getAddContact().getPhoneField().setText("");
                getContactView().getAddContact().getEmailField().setText("");
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
            if (getContactView().getContactTable().getSelectedRow() != -1) {
                getContactModel().deleteContact((String) getContactView()
                        .getContactTable().getModel().getValueAt(getContactView().getContactTable().getSelectedRow(), 0));
                updateTable();
            }
        }
    }
     
    class updateButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e) 
        {
            if (getContactView().getContactTable().getSelectedRow() != -1) {
                getContactView().getUpdateContact().setVisible(true);
            }
        }
    }
    
    class updateContactButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String firstName = getContactView().getContactTable().getModel()
                    .getValueAt(getContactView().getContactTable().getSelectedRow(), 0).toString();
            String lastName = getContactView().getContactTable().getModel()
                    .getValueAt(getContactView().getContactTable().getSelectedRow(), 1).toString();
            String phone = getContactView().getUpdateContact().getPhoneField().getText();
            String email = getContactView().getUpdateContact().getEmailField().getText();
            String address = getContactView().getUpdateContact().getAddressField().getText();
            int userID = getContactModel().getCurrentUserId();
            
            getContactModel().updateContact(firstName, lastName, phone, email, address, userID);
            getContactView().getUpdateContact().dispose();
            getContactView().getUpdateContact().getFirstNameField().setText("");
            getContactView().getUpdateContact().getLastNameField().setText("");
            getContactView().getUpdateContact().getPhoneField().setText("");
            getContactView().getUpdateContact().getEmailField().setText("");
            getContactView().getUpdateContact().getAddressField().setText("");
            updateTable();
        }
    }
}


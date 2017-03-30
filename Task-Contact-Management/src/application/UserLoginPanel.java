/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import javax.swing.JTextField;

/**
 *
 * @author John Ide - JCI5048
 */
public class UserLoginPanel extends javax.swing.JPanel {
    private Database db;
    private MainView mView;
    private String username;
    private String password;
    
    /**
     * Creates new form UserLoginPanel_revised
     */
    public UserLoginPanel() 
    {
        initComponents();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        newUserButton = new javax.swing.JButton();
        userSubmitButton = new javax.swing.JButton();
        usernameTextField = new javax.swing.JTextField();
        usernameLabel = new javax.swing.JLabel();
        passwordLabel = new javax.swing.JLabel();
        passwordTextField = new javax.swing.JPasswordField();
        failedLoginLabel = new javax.swing.JLabel();

        newUserButton.setText("New User");
        newUserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newUserButtonActionPerformed(evt);
            }
        });

        userSubmitButton.setText("Login");
        userSubmitButton.setMaximumSize(new java.awt.Dimension(100, 77));
        userSubmitButton.setMinimumSize(new java.awt.Dimension(100, 77));
        userSubmitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userSubmitButtonActionPerformed(evt);
            }
        });

        usernameLabel.setText("Username:");

        passwordLabel.setText("Password:");

        failedLoginLabel.setFont(new java.awt.Font("Dialog", 2, 11)); // NOI18N
        failedLoginLabel.setForeground(java.awt.Color.red);
        failedLoginLabel.setText("Username or Password incorrect");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(usernameLabel)
                            .addComponent(passwordLabel))
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(usernameTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(passwordTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(50, 50, 50))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(failedLoginLabel)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(newUserButton)
                                .addGap(50, 50, 50)
                                .addComponent(userSubmitButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(100, 100, 100))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(usernameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(usernameLabel))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordLabel)
                    .addComponent(passwordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userSubmitButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(newUserButton))
                .addGap(43, 43, 43)
                .addComponent(failedLoginLabel)
                .addContainerGap(75, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void userSubmitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userSubmitButtonActionPerformed

    }//GEN-LAST:event_userSubmitButtonActionPerformed

    private void newUserButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newUserButtonActionPerformed

    }//GEN-LAST:event_newUserButtonActionPerformed

    public javax.swing.JButton getNewUserButton() {
        
        return newUserButton;
        
    }
    
    public javax.swing.JButton getUserSubmitButton() {
        
        return userSubmitButton;
        
    }
    
    public javax.swing.JTextField getUsernameTextField() {
        
        return usernameTextField;
        
    }
    
    public javax.swing.JTextField getPasswordTextField() {
        
        return (JTextField) passwordTextField;
        
    }
    public javax.swing.JLabel getFailedLoginLabel()
    {
        return failedLoginLabel;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel failedLoginLabel;
    public javax.swing.JButton newUserButton;
    private javax.swing.JLabel passwordLabel;
    public javax.swing.JPasswordField passwordTextField;
    public javax.swing.JButton userSubmitButton;
    private javax.swing.JLabel usernameLabel;
    public javax.swing.JTextField usernameTextField;
    // End of variables declaration//GEN-END:variables

}

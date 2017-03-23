/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

/**
 *
 * @author reesmcdevitt
 */
public class LoginModel {
    private Boolean authenticated;
    
    public LoginModel() {
        this.authenticated = false;
    }
    
    public void setAuthenticatedTrue() {
        this.authenticated = true;
    }
    
    public Boolean isAuthenticated() {
        return authenticated;
    }
}

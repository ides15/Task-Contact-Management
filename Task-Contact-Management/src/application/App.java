/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.util.Arrays;

/**
 *
 * @author John Ide - JCI5048
 */
public class App {
    public static void main(String[] args) {
        Database loginModel = new Database("tcm.db");
        LoginView loginView = new LoginView(loginModel);
        LoginCntl loginCntl = new LoginCntl(loginModel, loginView);
        
        
    }
}

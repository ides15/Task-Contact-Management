/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

/**
 *
 * @author John Ide - JCI5048
 */
public class App {
    public static void main(String[] args) {
      LoginModel loginModel = new LoginModel();
      LoginView loginView = new LoginView(loginModel);
      LoginCntl loginCntl = new LoginCntl(loginModel, loginView);
      
      loginView.setVisible(true);
    }
}

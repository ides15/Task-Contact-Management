/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.sql.*;

/**
 * Extendable database class to be used with a SQlite database
 * 
 * @author John Ide - JCI5048
 */
public class Database {
    
    public void connect() {
        
        Connection conn = null;
        
        try {
            
            String url = "jdbc:sqlite:tcm.db";
            
            conn = DriverManager.getConnection(url);
            System.out.println("Connection to db established");
            
        } catch (SQLException ex) {
            
            System.out.println(ex.getMessage());
            
        } finally {
            
            try {
                
                if (conn != null) {
                    
                    conn.close();
                    
                }
                
            } catch (SQLException ex) {
                
                System.out.println(ex.getMessage());
                
            }
            
        }
        
    }
    
}
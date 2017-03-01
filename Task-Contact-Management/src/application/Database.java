/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.sql.*;

/*

        USAGE

        Constructor of database class takes one parameter, which is the database name.
        If there is no database with that name in the project, a new database will be made.

        In order to do anything with the database, you must first call connectToDatabase().

        The private connect() function works with the selectAll() function to connect to the db.

        selectAll(String table) will eventually print out all of the information in that table.

        testDatabase() will return a string just to test if the implementation of the db is right.

*/

/**
 * Extendable database class to be used with a SQlite database
 * 
 * @author John Ide - JCI5048
 */
public class Database {
    
    private String dbName;
    private final String url;
    
    public Database(String dbName) {
        
        this.dbName = dbName;
        url = "jdbc:sqlite:" + dbName;
        
    }
    
    /**
     * connectToDatabase will either connect to an existing database,
     * or, if the database does not exist, create a database with the 
     * name you create in dbName.
     * 
     * @return connection to database
     */
    public Connection connectToDatabase() {
        
        Connection conn = null;
        
        try {
            
            conn = DriverManager.getConnection(url);
            System.out.println("Connection to db " + dbName + " is established");
            
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
        
        return conn;
        
    }
    
    private Connection connect() {
        
        Connection conn = null;
        
        try {
            
            conn = DriverManager.getConnection(url);
            
        } catch (SQLException ex) {
            
            System.out.println(ex.getMessage());
            
        }
        
        return conn;
        
    }
    
    public void selectAll(String table) {
        
        String sql = "SELECT * FROM " + table;
        
        try (Connection conn = this.connect();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                
                System.out.println("selected information");
                
            }
            
        } catch (SQLException ex) {
            
            System.out.println(ex.getMessage());
            
        }
        
    }
    
    public boolean authenticate(String table, String username, String password) {
        
        boolean authenticated = false;
        String sql = "SELECT PASSWORD FROM " + table + " WHERE USERNAME = \"" + username + "\"";
        
        try (Connection conn = this.connect();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                
                if (rs.getString("PASSWORD").equals(password)) {
                    
                    authenticated = true;
                    System.out.println("User authenticated.");
                    
                }
                
                else
                    System.out.println("User NOT authenticated.");
                
            }
            
        } catch (SQLException ex) {
            
            System.out.println(ex.getMessage());
            
        }
        
        return authenticated;
        
    }
    
    public String testDatabase() {
        
        return "Database is alive!";
        
    }
    
}
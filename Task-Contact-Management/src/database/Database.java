/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.*;

/**
 * Extendable database class to be used with a SQlite database
 * 
 * @author John Ide - JCI5048
 */
public class Database {
    
    private String filename;
    
    public Database(String filename) {
        
        this.filename = filename;
        
    }
    
    private Connection connect() {
        
        String url = "jdbc:sqlite:" + filename;
        Connection conn = null;
        
        try {
            
            conn = DriverManager.getConnection(url);
            
        } catch (SQLException ex) {
            
            System.out.println(ex.getMessage());
            
        }
        
        return conn;
        
    }
    
    /**
     * Creates a new database as indicated in the constructor
     * 
     */
    public void createNewDatabase() {
        
        String url = "jdbc:sqlite:" + filename;
        
        try (Connection conn = DriverManager.getConnection(url)) {
            
            if (conn != null) {
                
                DatabaseMetaData meta = conn.getMetaData();
                System.out.println("Driver name: " + meta.getDriverName());
                System.out.println("A new database has been created");
                
            }
            
        } catch (SQLException ex) {
            
            System.out.println(ex.getMessage());
            
        }
        
    }
    
    /**
     * Creates a new table in the database indicated in constructor.
     * 
     * Table:
     *      FIRST_NAME VARCHAR(30)
     *      LAST_NAME VARCHAR(30)
     *      AGE INTEGER
     * 
     * (TODO: change function in order to be more flexible in creating tables)
     * 
     * @param tableName name of the table being created
     */
    public void createNewTable(String tableName) {
        
        String url = "jdbc:sqlite:" + filename;
        
        String sql = "CREATE NEW TABLE IF NOT EXISTS " + tableName + " (\n"
                + " FIRST_NAME VARCHAR(30),\n"
                + " LAST_NAME VARCHAR(30), \n"
                + " AGE INTEGER\n"
                + ");";
        
        try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement()) {
            
            stmt.execute(sql);
            System.out.println("Table " + tableName + " created");
            
        } catch (SQLException ex) {
            
            System.out.println(ex.getMessage());
            
        }
        
    }
    
    /**
     * Selects all data from 'table'
     * 
     * Currently only returns:
     *      FIRST_NAME
     *      LAST_NAME
     *      AGE
     * 
     * @param table table that information is being retrieved from
     */
    public void selectALL(String table) {
        
        String sql = "SELECT * FROM " + table;
        
        try (Connection conn = this.connect();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                
                System.out.println(rs.getShort("FIRST_NAME") + "\t" + 
                        rs.getString("LAST_NAME") + "\t" + 
                        rs.getInt("AGE"));
                
            }
            
        } catch (SQLException ex) {
            
            System.out.println(ex.getMessage());
            
        }
        
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.sql.*;
import java.util.ArrayList;

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
 * Extendable database class to be used with a SQlite database, runs as model.
 * 
 * @author John Ide - JCI5048
 */
public class Database {
    private int CURRENT_USER_ID;
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
    
    /**
     * Authenticates a person to the system.
     * @param table whatever table you want to query
     * @param username whatever username person is trying to log in with
     * @param password whatever password person is trying to log in with
     * @return boolean of whether the person is authenticated or not
     */
    public boolean authenticate(String table, String username, String password) {
        boolean authenticated = false;
        String sql = "SELECT PASSWORD, ACCOUNT_ID FROM " + table + " WHERE USERNAME = \"" + username + "\"";
        
        try (Connection conn = this.connect();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                if (rs.getString("PASSWORD").equals(password)) {
                    authenticated = true;
                    CURRENT_USER_ID = rs.getInt("ACCOUNT_ID");
                    System.out.println("Current user: " + CURRENT_USER_ID);
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return authenticated;
    }
    
    /**
     * Selects all data from table.
     * @param table table you are selecting all data from
     */
    public void selectAll(String table) {
        String sql = "SELECT * FROM " + table;
        
        try (Connection conn = this.connect();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println(rs.getString("FIRST_NAME") +  "\t\t" + 
                                   rs.getString("LAST_NAME") + "\t\t" +
                                   rs.getString("USERNAME") + "\t" + 
                                   rs.getString("PASSWORD"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    /**
     * Gets the ACCOUNT_ID of the user currently logged into the system
     * @return ACCOUNT_ID of current user
     */
    public int getCurrentUserId() {
        return CURRENT_USER_ID;
    }
    
        
    //Gets the information of a all tasks of a user
    public Object[][] getTaskInfo()
    { 
        Object[][] info;
        ArrayList<ArrayList> allTaskInfo = new ArrayList<ArrayList>();
        ArrayList<String> taskInfo;
        String taskName = "";
        String taskType = "";
        String taskDate = "";
        String taskDescript = "";
        NavModel navModel = new NavModel();
        NavView navView = new NavView(navModel);
        
            String sql = "SELECT * FROM Task \n WHERE TASK_USER_ID = " + CURRENT_USER_ID;

            //Database stores task info in 2D arrayList - arraylist used because dynamicly sized
            try (Connection conn = this.connect();
                    Statement stmt = conn.createStatement();
                    ResultSet rs = stmt.executeQuery(sql)) {

                  while(rs.next())
                  {
                      taskInfo = new ArrayList<String>();

                      taskName = rs.getString("NAME"); 
                      taskType = rs.getString("TYPE");
                      taskDate = rs.getString("DUE_DATE");
                      taskDescript = rs.getString("DESCRIPTION");

                      taskInfo.add(taskName);
                      taskInfo.add(taskType);
                      taskInfo.add(taskDate);
                      taskInfo.add(taskDescript);

                      allTaskInfo.add(taskInfo);
                  }

            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            
            //Conversion to Object
            info = new Object[allTaskInfo.size()][4];

            for(int i = 0; i < allTaskInfo.size(); i++)
            {
                for(int j = 0; j < 4; j++)
                {
                    info[i][j] = allTaskInfo.get(i).get(j);
                }
            }
            //

        return info;
    }

    /**
     * Adds a new task in Task table.
     * @param NAME name of the new task
     * @param DESCRIPTION description of the new task
     * @param DUE_DATE due date of the new task
     * @param TYPE type of new task (Personal, School, Business)
     */
    public void addTask(String NAME, String DESCRIPTION, String DUE_DATE, String TYPE) {
        
        String sql = "INSERT INTO Task (TASK_USER_ID, NAME, DESCRIPTION, DUE_DATE, TYPE) "
                + "VALUES (" + CURRENT_USER_ID + ",?,?,?,?)";
        
        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, NAME);
            pstmt.setString(2, DESCRIPTION);
            pstmt.setString(3, DUE_DATE);
            pstmt.setString(4, TYPE);
            
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    /**
     * Adds a new contact to the Contact table.
     * @param FIRST_NAME first name for the new contact
     * @param LAST_NAME last name for the new contact
     * @param EMAIL email for the new contact
     * @param ADDRESS address for the new contact
     */
    public void addContact(String FIRST_NAME, String LAST_NAME, String EMAIL, String ADDRESS) {
        String sql = "INSERT INTO Contact (CONTACT_USER_ID, FIRST_NAME, LAST_NAME, EMAIL, ADDRESS) "
                + "VALUES (" + CURRENT_USER_ID + ",?,?,?,?)";
        
        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, FIRST_NAME);
            pstmt.setString(2, LAST_NAME);
            pstmt.setString(3, EMAIL);
            pstmt.setString(4, ADDRESS);
            
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    /**
     * Adds a new user to the User table. If a new user tries to add an account with a
     * username already in use, the function will throw an error and prevent that 
     * username from being used.
     * @param FIRST_NAME first name of new account
     * @param LAST_NAME last name of new account
     * @param USERNAME username of new account
     * @param PASSWORD password of new account
     */
    public void addNewUser(String FIRST_NAME, String LAST_NAME, String USERNAME, String PASSWORD) {
        String conflictingUser = "test";
        String sql = "INSERT INTO User (FIRST_NAME, LAST_NAME, USERNAME, PASSWORD) "
                + "VALUES (?,?,?,?)";
        String check = "SELECT USERNAME FROM User WHERE USERNAME = \"" + USERNAME + "\"";
        
        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(check)) {
            
            while (rs.next()) {
                conflictingUser = rs.getString("USERNAME");
            }

            pstmt.setString(1, FIRST_NAME);
            pstmt.setString(2, LAST_NAME);
            pstmt.setString(3, USERNAME);
            pstmt.setString(4, PASSWORD);
            
            if (conflictingUser.equals(USERNAME)) {
                System.out.println("Username " + USERNAME + " is already in use.");
            } else {
                pstmt.executeUpdate();
                System.out.println("User " + USERNAME + " created.");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public String testDatabase() {
        return "Database is alive!";
    }
}
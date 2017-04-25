/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/*
        USAGE

        Constructor of database class takes one parameter, which is the database name.
        If there is no database with that name in the project, a new database will be made.
*/

/**
 * Database class to be used with a SQlite database, runs as model.
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
    public int[] authenticate(String table, String username, String password) {
        int[] authenticated = new int[2];
        authenticated[0] = 0;   // sets authenticated to false by default
        
        String sql = "SELECT PASSWORD, ACCOUNT_ID FROM " + table + " WHERE USERNAME = \"" + username + "\"";
        
        try (Connection conn = this.connect();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                if (rs.getString("PASSWORD").equals(password)) {
                    authenticated[0] = 1;   // sets authenticated to true
                    setCurrentUserId(rs.getInt("ACCOUNT_ID"));
                    authenticated[1] = CURRENT_USER_ID;
//                    System.out.println("User id in database: " + getCurrentUserId());
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return authenticated;
    }
    
//    public void setAuthenticatedFalse() {
//        
//    }
    
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
    
    public void setCurrentUserId(int userId) {
        this.CURRENT_USER_ID = userId;
    }
    
    public String getUserFirstName(int userID)
    {
        String name = "";
        String sql = "SELECT FIRST_NAME FROM User \n WHERE ACCOUNT_ID = " + userID;

            //Database stores task info in 2D arrayList - arraylist used because dynamicly sized
            try (Connection conn = this.connect();
                    Statement stmt = conn.createStatement();
                    ResultSet rs = stmt.executeQuery(sql)) {

                  while(rs.next())
                  {
                     name = rs.getString("FIRST_NAME");
                  }

            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            
            return name;
    }
    
    public String[] getTaskNames(int userID)
    {
        String[] names = new String[0];
        ArrayList<String> taskNames = new ArrayList();
        
        String sql = "SELECT NAME FROM Task \n WHERE TASK_USER_ID = " + userID;

            //Database stores task info in 2D arrayList - arraylist used because dynamicly sized
            try (Connection conn = this.connect();
                    Statement stmt = conn.createStatement();
                    ResultSet rs = stmt.executeQuery(sql)) {

                  while(rs.next())
                  {
                      taskNames.add(rs.getString("NAME"));
                  }
                  
                  names = new String[taskNames.size()];
                  
                  for(int i = 0; i < taskNames.size(); i++)
                  {
                      names[i] = taskNames.get(i);
                  }

            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            
            return names;
    }
    
    //For Calender
    public Object[][] getTaskDate(int userID, String date)
    {
        Object[][] info;
        ArrayList<ArrayList> allTaskInfo = new ArrayList<ArrayList>();
        ArrayList<String> taskInfo;
        String taskName = "";
        String taskDate = "";
//        NavModel navModel = new NavModel();
//        NavView navView = new NavView(navModel);
        
            String sql = "SELECT * FROM Task \n WHERE TASK_USER_ID = " + userID + " AND DUE_DATE = '" + date + "'";

            //Database stores task info in 2D arrayList - arraylist used because dynamicly sized
            try (Connection conn = this.connect();
                    Statement stmt = conn.createStatement();
                    ResultSet rs = stmt.executeQuery(sql)) {

                  while(rs.next())
                  {
                      taskInfo = new ArrayList<String>();

                      taskName = rs.getString("NAME"); 
                      taskDate = rs.getString("DUE_DATE");
                      

                      taskInfo.add(taskName);
                      taskInfo.add(taskDate);

                      allTaskInfo.add(taskInfo);
                  }

            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            
            //Conversion to Object
            info = new Object[allTaskInfo.size()][2];

            for(int i = 0; i < allTaskInfo.size(); i++)
            {
                for(int j = 0; j < 2; j++)
                {
                    info[i][j] = allTaskInfo.get(i).get(j);
                }
            }
           // System.out.println(allTaskInfo);
        return info;
    }
    
    //For Search
    public Object[][] getTasks(int userID, String task)
    {
        Object[][] info;
        ArrayList<ArrayList> allTaskInfo = new ArrayList<ArrayList>();
        ArrayList<String> taskInfo;
        String taskName = "";
        String taskDate = "";
//        NavModel navModel = new NavModel();
//        NavView navView = new NavView(navModel);
        
            String sql = "SELECT * FROM Task \n WHERE TASK_USER_ID = " + userID + " AND NAME = '" + task + "'";

            //Database stores task info in 2D arrayList - arraylist used because dynamicly sized
            try (Connection conn = this.connect();
                    Statement stmt = conn.createStatement();
                    ResultSet rs = stmt.executeQuery(sql)) {

                  while(rs.next())
                  {
                      taskInfo = new ArrayList<String>();

                      taskName = rs.getString("NAME"); 
                      taskDate = rs.getString("DUE_DATE");
                      

                      taskInfo.add(taskName);
                      taskInfo.add(taskDate);

                      allTaskInfo.add(taskInfo);
                  }

            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            
            //Conversion to Object
            info = new Object[allTaskInfo.size()][2];

            for(int i = 0; i < allTaskInfo.size(); i++)
            {
                for(int j = 0; j < 2; j++)
                {
                    info[i][j] = allTaskInfo.get(i).get(j);
                }
            }
           // System.out.println(allTaskInfo);
        return info;
    }
    
    //Gets the information of a all tasks of a user
    public Object[][] getTaskInfo(int userID)
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
        
            String sql = "SELECT * FROM Task \n WHERE TASK_USER_ID = " + userID;

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
            info = new Object[allTaskInfo.size()][5];

            for(int i = 0; i < allTaskInfo.size(); i++)
            {
                for(int j = 0; j < 4; j++)
                {
                    info[i][j] = allTaskInfo.get(i).get(j);
                }
            }
            
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
                + "VALUES (?,?,?,?,?)";
        
        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, CURRENT_USER_ID);
            pstmt.setString(2, NAME);
            pstmt.setString(3, DESCRIPTION);
            pstmt.setString(4, DUE_DATE);
            pstmt.setString(5, TYPE);
            
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void deleteTask(String NAME)
    {
        String sql = "DELETE FROM Task \n WHERE NAME = ?";
 
        try (Connection conn = this.connect();
              PreparedStatement pstmt = conn.prepareStatement(sql)) {
 
            // set the corresponding param
            pstmt.setString(1, NAME);
            // execute the delete statement
            pstmt.executeUpdate();
 
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    /**
     * Adds a new contact to the Contact table.
     * @param FIRST_NAME first name for the new contact
     * @param LAST_NAME last name for the new contact
     * @param EMAIL email for the new contact
     * @param ADDRESS address for the new contact
     * @param PHONE phone number for the new contact
     */
    public void addContact(String FIRST_NAME, String LAST_NAME, String PHONE, String EMAIL, String ADDRESS) {
        String sql = "INSERT INTO Contact (CONTACT_USER_ID, FIRST_NAME, LAST_NAME, PHONE, EMAIL, ADDRESS) "
                + "VALUES (?,?,?,?,?,?)";
        
        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, CURRENT_USER_ID);
            pstmt.setString(2, FIRST_NAME);
            pstmt.setString(3, LAST_NAME);
            pstmt.setString(4, PHONE);
            pstmt.setString(5, EMAIL);
            pstmt.setString(6, ADDRESS);
            
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public Object[][] getContactInfo(int userID)
    { 
        Object[][] info;
        ArrayList<ArrayList> allContactInfo = new ArrayList<ArrayList>();
        ArrayList<String> contactInfo;
        String firstName = "";
        String lastName = "";
        String phoneNumber = "";
        String email = "";
        String address = "";
        NavModel navModel = new NavModel();
        NavView navView = new NavView(navModel);
        
            String sql = "SELECT * FROM Contact \n WHERE CONTACT_USER_ID = " + userID; //<-- change to userID

            //Database stores task info in 2D arrayList - arraylist used because dynamicly sized
            try (Connection conn = this.connect();
                    Statement stmt = conn.createStatement();
                    ResultSet rs = stmt.executeQuery(sql)) {
                while(rs.next())
                {
                    contactInfo = new ArrayList<String>();

                    firstName = rs.getString("FIRST_NAME"); 
                    lastName = rs.getString("LAST_NAME");
                    phoneNumber = rs.getString("PHONE");
                    email = rs.getString("EMAIL");
                    address = rs.getString("ADDRESS");

                    contactInfo.add(firstName);
                    contactInfo.add(lastName);
                    contactInfo.add(phoneNumber);
                    contactInfo.add(email);
                    contactInfo.add(address);

                    allContactInfo.add(contactInfo);
                }

            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            
            //Conversion to Object
            info = new Object[allContactInfo.size()][6];

            for(int i = 0; i < allContactInfo.size(); i++)
            {
                for(int j = 0; j < 5; j++)
                {
                    info[i][j] = allContactInfo.get(i).get(j);
                }
            }
            
        return info;
    }
    
    public void deleteContact(String NAME) //Has to be modified so it takes first and last name 
    {
        String sql = "DELETE FROM Contact \n WHERE FIRST_NAME = ?";
 
        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
 
            // set the corresponding param
            pstmt.setString(1, NAME);
            // execute the delete statement
            pstmt.executeUpdate();
 
        } catch (SQLException e) {
            System.out.println(e.getMessage());
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
                JOptionPane.showMessageDialog(null, "User Name Already in Use");
            } else {
                pstmt.executeUpdate();
                System.out.println("User " + USERNAME + " created.");
                JOptionPane.showMessageDialog(null, "New User Added");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void updateUser(String USERNAME, String PASSWORD, int userID) {
        int askUpdate = JOptionPane.showConfirmDialog(null, "Do You Want to Update?", "Confirm", JOptionPane.YES_NO_OPTION);
        
        if(askUpdate == 0)
        {
            String sql = "UPDATE User SET USERNAME = '" + USERNAME + "', PASSWORD = '" + PASSWORD + "' WHERE ACCOUNT_ID = '" + userID + "'";
            try (Connection conn = this.connect();
                Statement stmt = conn.createStatement()) {

                stmt.executeUpdate(sql);
                JOptionPane.showMessageDialog(null, "Saved");
                
            } catch(SQLException se) {
                System.out.println(se.getMessage());
            }
        }
    }
    
    public void updateTask(String NAME, String TYPE, String DATE, String DESC, int userID) {
        int askUpdate = JOptionPane.showConfirmDialog(null, "Do you want to update?", "Confirm", JOptionPane.YES_NO_OPTION);
        
        if(askUpdate == 0)
        {
            String sql = "UPDATE Task SET NAME = ?, TYPE = ?, DUE_DATE = ?, "
                    + "DESCRIPTION = ? WHERE NAME = ? AND TASK_USER_ID = ?";
         
            try(Connection conn = this.connect();
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, NAME);
                pstmt.setString(2, TYPE);
                pstmt.setString(3, DATE);
                pstmt.setString(4, DESC);
                pstmt.setString(5, NAME);
                pstmt.setInt(6, userID);
                
                pstmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "Saved");
            } catch(SQLException se) {
                System.out.println(se.getMessage());
            }
        }
    }
    
    public void updateContact(String FIRST_NAME, String LAST_NAME, String PHONE, String EMAIL, String ADDRESS, int userID) {
        int askUpdate = JOptionPane.showConfirmDialog(null, "Do You Want to Update?", "Confirm", JOptionPane.YES_NO_OPTION);
        
        if(askUpdate == 0)
        {
            String sql = "UPDATE Contact SET FIRST_NAME = ?, LAST_NAME = ?, "
                    + "PHONE = ?, EMAIL = ?, ADDRESS = ? WHERE CONTACT_USER_ID = ? "
                    + "AND FIRST_NAME = ? AND LAST_NAME = ?";

            try(Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

                pstmt.setString(1, FIRST_NAME);
                pstmt.setString(2, LAST_NAME);
                pstmt.setString(3, PHONE);
                pstmt.setString(4, EMAIL);
                pstmt.setString(5, ADDRESS);
                pstmt.setInt(6, userID);
                pstmt.setString(7, FIRST_NAME);
                pstmt.setString(8, LAST_NAME);
                
                pstmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "Saved");
            } catch(SQLException se) {
                System.out.println(se.getMessage());
            }
        }
    }
    
    public String testDatabase() {
        return "Database is alive!";
    }
}

package dbcheck;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class dbconnector {
    public static void main(String[] args) {
        String driverClassName = "com.mysql.cj.jdbc.Driver"; // Updated to use MySQL Connector Driver
        String URL = "jdbc:mysql://localhost:3306/nishadb";
        String user = "root";
        String pwd = "ahsin@317";
        String showTablesQuery = "SELECT first_name, last_name,phone_no FROM students;"; // Corrected column names
        
        try {
            
            Class.forName(driverClassName);

   
            Connection con = DriverManager.getConnection(URL, user, pwd);

            // Create statement
            Statement stat = con.createStatement();

            System.out.println("Details of students:");
            
            // Execute query
            ResultSet tablesResultSet = stat.executeQuery(showTablesQuery);
            
            // Process results
            while (tablesResultSet.next()) {
                String firstName = tablesResultSet.getString("first_name");
                String lastName = tablesResultSet.getString("last_name");
                String phoneNo=tablesResultSet.getString("phone_no");
                System.out.println("First Name: " + firstName + ", Last Name: " + lastName +",phone No."+ phoneNo);
            }
            
            // Clean upS
            tablesResultSet.close();
            stat.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace(); // Handle exceptions and print stack trace for debugging
        }
    }
}

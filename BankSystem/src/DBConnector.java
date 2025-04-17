import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBConnector {
    public static Connection getConnection() {
        // Database credentials
        String url = "jdbc:mysql://localhost:3306/bankdb"; 
        String user = "root";  
        String password = "ahsin@317";  
        String showTablesQuery = "SHOW TABLES;";

        Connection connection = null;

        try {
            // Connect to the database
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to BankDB!");

            // Create a Statement object for executing SQL
            Statement statement = connection.createStatement();

            // Display all tables in BankDB
            System.out.println("Tables in BankDB:");
            ResultSet tablesResultSet = statement.executeQuery(showTablesQuery);
            while (tablesResultSet.next()) {
                System.out.println("- " + tablesResultSet.getString(1));
            }

            // Close the statement and result set
            tablesResultSet.close();
            statement.close();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }

        return connection; // Returning the connection for further use
    }
}

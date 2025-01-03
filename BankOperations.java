import java.sql.*;

public class BankOperations {

    // View current balance of the account
    public static double viewBalance(int userId) {
        String query = "SELECT balance FROM accounts WHERE user_id = ?";
        try (Connection connection = DBConnector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, userId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getDouble("balance");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0.00;
    }

    // Withdraw amount from account
    public static void withdraw(int userId, double amount) {
        String query = "UPDATE accounts SET balance = balance - ? WHERE user_id = ?";
        try (Connection connection = DBConnector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setDouble(1, amount);
            preparedStatement.setInt(2, userId);
            int rowsUpdated = preparedStatement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Withdrawal successful!");
            } else {
                System.out.println("Withdrawal failed or user not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Deposit amount into account
    public static void deposit(int userId, double amount) {
        String query = "UPDATE accounts SET balance = balance + ? WHERE user_id = ?";
        try (Connection connection = DBConnector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setDouble(1, amount);
            preparedStatement.setInt(2, userId);
            int rowsUpdated = preparedStatement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Deposit successful!");
            } else {
                System.out.println("Deposit failed or user not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Transfer amount between two accounts
    public static void transfer(int fromUserId, int toUserId, double amount) {
        Connection connection = null;
        PreparedStatement withdrawStmt = null, depositStmt = null;

        try {
            connection = DBConnector.getConnection();
            connection.setAutoCommit(false); // Enable transaction

            // Withdraw from source account
            String withdrawQuery = "UPDATE accounts SET balance = balance - ? WHERE user_id = ?";
            withdrawStmt = connection.prepareStatement(withdrawQuery);
            withdrawStmt.setDouble(1, amount);
            withdrawStmt.setInt(2, fromUserId);
            int withdrawStatus = withdrawStmt.executeUpdate();

            // Deposit to target account
            String depositQuery = "UPDATE accounts SET balance = balance + ? WHERE user_id = ?";
            depositStmt = connection.prepareStatement(depositQuery);
            depositStmt.setDouble(1, amount);
            depositStmt.setInt(2, toUserId);
            int depositStatus = depositStmt.executeUpdate();

            if (withdrawStatus > 0 && depositStatus > 0) {
                connection.commit();
                System.out.println("Transfer successful!");
            } else {
                connection.rollback();
                System.out.println("Transfer failed.");
            }
        } catch (SQLException e) {
            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            e.printStackTrace();
        } finally {
            try {
                if (withdrawStmt != null) withdrawStmt.close();
                if (depositStmt != null) depositStmt.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

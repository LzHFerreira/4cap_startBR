package exercises2capinterview;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static Connection connection;

    private DatabaseConnection() {}

    public static Connection getConnection() throws SQLException {
        if (connection == null) {
            String url = "jdbc:mysql://localhost:3306/your_database_name";
            String username = "your_username";
            String password = "your_password";
            connection = DriverManager.getConnection(url, username, password);
        }
        return connection;
    }

    public static void closeConnection() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }
}

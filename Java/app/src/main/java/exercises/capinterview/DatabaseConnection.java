package exercises.capinterview;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static Connection connection;

    private DatabaseConnection() {}

    public static Connection getConnection() throws SQLException {
        if (connection == null) {
            // Replace these with your actual MySQL credentials
            String url = "jdbc:mysql://localhost:3306/capinterview"; // Database name: capinterview
            String username = "root";  // Default MySQL username
            String password = System.getenv("DB_PASSWORD");
            connection = DriverManager.getConnection(url, username, password);
        }
        return connection;
    }

    public static void closeConnection() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();  // Close the connection
        }
    }
}

//todo: buld environment variable for DB_PASSWORD
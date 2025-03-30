package exercises.capinterview;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

public class DatabaseConnection {
    private static final Logger logger = Logger.getLogger(DatabaseConnection.class.getName());
    private static Connection connection;

    private DatabaseConnection() {}

    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            String url = "jdbc:mysql://localhost:3306/capinterview"; // Database name: capinterview
            String username = "root";  // Default MySQL username
            
            // Load password from environment variable
            String password = System.getenv("DB_PASSWORD");
            if (password == null || password.isEmpty()) {
                throw new SQLException("Database password is not set. Please define DB_PASSWORD as an environment variable.");
            }

            // Establish connection
            connection = DriverManager.getConnection(url, username, password);
            logger.info("Database connection established successfully.");
        }
        return connection;
    }

    public static void closeConnection() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
            logger.info("Database connection closed.");
        }
    }
}

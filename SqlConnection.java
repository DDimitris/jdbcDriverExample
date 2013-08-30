package jdbc_example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SqlConnection {

    public Connection connection = null;

    /**
     * Load the JDBC driver in to the memory. This method is type void.
     */
    protected void initializeJDBC() {
        try {
            System.out.println("Initializing Driver...");
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Done!");
        } catch (ClassNotFoundException error) {
            System.out.println("Error: " + error.getMessage());
        }
    }

    /**
     * Connect to MySQL database with username: root and password: root on a
     * different machine. Remember to GRANT PRIVILEGES for this computer ip
     * address. This method is type void.
     */
    public void ConnectToDataBase(String username, String password, String url) {
        try {
            System.out.println("Connecting to DataBase...");
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connection Successful!");
        } catch (SQLException error) {
            System.out.println("Error: " + error.getMessage());
        }
    }

    /**
     * Close the connection with the MySQL Database. This method is type void.
     */
    protected void ConnectionClose() {
        if (connection != null) {
            try {
                System.out.println("Closing Connection...");
                connection.close();
                System.out.println("Connection Closed!");
            } catch (SQLException ignore) {
            }
        }
    }
}
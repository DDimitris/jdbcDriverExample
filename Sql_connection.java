package yolo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Sql_connection {

    protected Connection connection = null;

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
    protected void ConnectToDataBase() {
        try {
            System.out.println("Connecting to DataBase...");
            connection = DriverManager.getConnection("jdbc:mysql://192.168.1.4:3306/jdbc_example", "name", "root");
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

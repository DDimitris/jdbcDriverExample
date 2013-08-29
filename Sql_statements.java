package yolo;

import java.sql.SQLException;
import java.sql.Statement;

public class Sql_statements extends Sql_connection {

    private Statement statement = null;
    String first_name;
    String last_name;
    String mobile_phone;

    /**
     *
     * @param first_name
     * @param last_name
     * @param mobile_phone
     *
     * This is the constructor for the class Sql_statements. It takes arguments
     * from the textFields on the gui class.
     */
    public Sql_statements(String first_name, String last_name, String mobile_phone) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.mobile_phone = mobile_phone;
    }

    /**
     * Prepare and execute a statement to the Database. This method is type
     * void.
     */
    public void setNewPerson() {
        try {
            System.out.println("Prepare Statement...");
            statement = connection.createStatement();
            System.out.println("Execute Statement...");
            statement.execute(" INSERT INTO person (first_name, last_name, mobile_phone) VALUES ('" + first_name + "','" + last_name + "','" + mobile_phone + "')");
            System.out.println("Preparation and Execution was successful!");
        } catch (SQLException error) {
            System.out.println("Error: " + error.getMessage());
        } finally {

            if (statement != null) {
                try {
                    System.out.println("Closing statement...");
                    statement.close();
                    System.out.println("Statement closed!");
                } catch (SQLException ignore) {
                }
            }
        }
    }
}

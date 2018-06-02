package gr.aueb.model;

import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class SqlStatements extends SqlConnection {

    private ArrayList<String> names = new ArrayList<String>();
    private Statement statement = null;
    private ResultSet resultSet = null;


    /**
     * Create a statement for use with INSERT and SELECT commands.
     */
    public void createStatement() {
        try {
            System.out.println("Prepare Statement.");
            statement = connection.createStatement();
            System.out.println("Done!");
        } catch (SQLException error) {
            System.out.println("Error in creating the statement: " + error.getMessage());
        }
    }

    /**
     *
     * @param first_name
     * @param last_name
     * @param mobile_phone
     *
     * Execute a statement to the Database.
     */
    public void setNewPerson(String first_name, String last_name, String mobile_phone) {
        try {
            System.out.println("Execute Statement.");
            statement.execute(" INSERT INTO person (first_name, last_name, mobile_phone) VALUES ('" + first_name + "','" + last_name + "','" + mobile_phone + "')");
            System.out.println("Execution was successful!");
        } catch (SQLException error) {
            System.out.println("Error: " + error.getMessage());
        }
    }

    /**
     * Executes a query to the database and appends the results on an ArrayList.
     *
     */
    public void getPersonsInfo() {
        try {
            resultSet = statement.executeQuery("SELECT * FROM person");
            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String identificationNumber = id.toString();
                String fname = resultSet.getString("first_name");
                String lname = resultSet.getString("last_name");
                String number = resultSet.getString("mobile_phone");
                names.add(identificationNumber);
                names.add(fname);
                names.add(lname);
                names.add(number);
            }


        } catch (SQLException error) {
            System.out.println("Error: " + error.getMessage());
        }
    }

    /**
     * Close the statement and the resultSet.
     */
    public void closeStatement() {

        if (statement != null) {
            try {
                System.out.println("Closing statement.");
                statement.close();
                System.out.println("Statement closed!");
            } catch (SQLException ignore) {
            }
            if (resultSet != null) {
                try {
                    System.out.println("Closing statement.");
                    resultSet.close();
                    System.out.println("Statement closed!");
                } catch (SQLException ignore) {
                }
            }
        }
    }

    public ArrayList<String> getNames() {
        return names;
    }

    public void clearNames(){
        names.clear();
    }
}

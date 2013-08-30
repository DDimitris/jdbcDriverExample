package jdbc_example;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;

public class XmlParser {

    private String username;
    private String password;
    private String url;
    SqlConnection connect = new SqlConnection();

    /**
     * ReadXmlFile opens an xml file in a given directory and reads it until it
     * find the tags "username" and "password".
     */
    public void ReadXmlFile() {
        try {
            File credentials = new File("src\\jdbc_example\\credentials.xml");
            DocumentBuilderFactory Factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder Builder = Factory.newDocumentBuilder();
            Document doc = Builder.parse(credentials);
            doc.getDocumentElement().normalize();
            username = doc.getElementsByTagName("username").item(0).getTextContent();
            password = doc.getElementsByTagName("password").item(0).getTextContent();
            url = doc.getElementsByTagName("url").item(0).getTextContent();
            setUsername(username);
            setPassword(password);
            setURL(url);
            connection();
        } catch (Exception error) {
            System.out.println("Error: " + error.getMessage());
        }
    }

    /**
     *
     * @param username
     *
     * Sets the parameter username for the database connection.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     *
     * @param password
     *
     * Sets the parameter password for the database connection.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     *
     * @param url
     *
     * Sets the parameter url for the database connection.
     */
    public void setURL(String url) {
        this.url = url;
    }

    /**
     *
     * Returns the argument "username", which is type string.
     */
    public String getUsername() {
        return username;
    }

    /**
     *
     * Returns the argument "password", which is type string.
     */
    public String getPassword() {
        return password;
    }

    /**
     *
     * Returns the argument "url", which is type string.
     */
    public String getURL() {
        return url;
    }

    /**
     * Pass arguments to ConnectToDataBase method for connection with your
     * DataBase.
     */
    public void connection() {
        connect.ConnectToDataBase(getUsername(), getPassword(), getURL());
    }
}
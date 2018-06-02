package gr.aueb.utils;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;

public class XmlParser {

    private String username;
    private String password;
    private String url;

    /**
     * readXmlFile opens an xml file in a given directory and reads it until it
     * find the tags "username" and "password".
     */
    public void readXmlFile() {
        try {
            ClassLoader classLoader = getClass().getClassLoader();
            File credentials = new File(classLoader.getResource("credentials_example.xml").getFile());
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
        } catch (Exception error) {
            System.out.println("Error in parssing the given xml file: " + error.getMessage());
        }
    }

    /**
     *
     * @param username
     *
     * Sets the parameter username for the database connection.
     */
    public void setUsername(String username) {
        System.out.println("Selected username: " + username);
        this.username = username;
    }

    /**
     *
     * @param password
     *
     * Sets the parameter password for the database connection.
     */
    public void setPassword(String password) {
        System.out.println("Selected password: " + password);
        this.password = password;
    }

    /**
     *
     * @param url
     *
     * Sets the parameter url for the database connection.
     */
    public void setURL(String url) {
        System.out.println("Selected URL: " + url);
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
}
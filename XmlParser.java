package jdbc_example;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XmlParser extends SqlConnection {

    private String username;
    private String password;
    private String url;

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
            NodeList list = doc.getElementsByTagName("credentials");
            for (int temp = 0; temp < list.getLength(); temp++) {
                Node node = list.item(temp);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    username = element.getElementsByTagName("username").item(temp).getTextContent();
                    password = element.getElementsByTagName("password").item(temp).getTextContent();
                    url = element.getElementsByTagName("url").item(temp).getTextContent();
                    setUsername(username);
                    setPassword(password);

                }
            }
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
     * Returns the argument "username", that is type string.
     */
    public String getUsername() {
        return username;
    }

    /**
     *
     * Returns the argument "password", that is type string.
     */
    public String getPassword() {
        return password;
    }

    /**
     *
     * Returns the argument "url", that is type string.
     */
    public String getURL() {
        return url;
    }
}

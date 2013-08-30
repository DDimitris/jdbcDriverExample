/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc_example;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Dimitris
 */
public class Controller {

    String character;
    int count = 0;
    SqlStatements statements;
    XmlParser parser;
    gui gui;

    /**
     *
     * @param statements
     * @param parser
     * @param gui
     *
     * Constructor of Controller.
     */
    public Controller(SqlStatements statements, XmlParser parser, gui gui) {
        this.gui = gui;
        this.statements = statements;
        this.parser = parser;

        gui.submit.addActionListener(new SubmitListener());
        gui.refresh.addActionListener(new RefreshListener());
    }

    /**
     * Method for initialize JDBC driver, connect to DataBase, parse XML file
     * and create statement.
     */
    public void Connect() {
        statements.initializeJDBC();
        parser.ReadXmlFile();
        statements.createStatement();
    }

    /**
     * This Method appends data to the TextArea.
     */
    public void printData() {
        for (String i : statements.name) {
            count++;
            if (count == 4) {
                character = "\n";
                count = 0;
            } else {
                character = "";
            }
            gui.infoLog.append(i + "\t" + character);
        }
        statements.name.clear();
    }

    /**
     * Method for closing statement and close the connection with the DataBase.
     */
    public void Disconnect() {
        statements.CloseStatement();
        statements.ConnectionClose();
    }

    /**
     * Inner class using actionlistener for submit button.
     */
    class SubmitListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            Connect();
            statements.setNewPerson(gui.fname.getText(), gui.lname.getText(), gui.number.getText());
            Disconnect();
            gui.fname.setText("");
            gui.lname.setText("");
            gui.number.setText("");
        }
    }

    /**
     * Inner class using actionlistener for refresh button.
     */
    class RefreshListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            gui.infoLog.setText("");
            Connect();
            statements.getPersonsInfo();
            printData();
            Disconnect();
        }
    }
}

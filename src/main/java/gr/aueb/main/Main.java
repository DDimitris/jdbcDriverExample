package gr.aueb.main;

import gr.aueb.controller.Controller;
import gr.aueb.model.SqlStatements;
import gr.aueb.utils.XmlParser;
import gr.aueb.view.Gui;

public class Main {

    public static void main(String args[]) {

        SqlStatements model = new SqlStatements();
        XmlParser parser = new XmlParser();
        Gui view = new Gui();
        Controller controller = new Controller(model, parser, view);
        view.setVisible(true);


    }
}

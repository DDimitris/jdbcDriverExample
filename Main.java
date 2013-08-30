package jdbc_example;

public class Main {

    public static void main(String args[]) {

        SqlStatements model = new SqlStatements();
        XmlParser parser = new XmlParser();
        gui view = new gui();
        Controller controller = new Controller(model, parser, view);
        view.setVisible(true);


    }
}

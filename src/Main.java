import Application.Application;
import controllers.CoffeeController;
import data.DatabaseConnection;
import data.interfaces.IDB;
import repositories.CoffeeRepository;
import repositories.interfaces.ICoffeeRepository;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        IDB db = DatabaseConnection.getInstance();
        ICoffeeRepository repo = new CoffeeRepository(db);
        CoffeeController controller = new CoffeeController(repo);
        Application app = new Application(controller);
        app.start();
    }
}
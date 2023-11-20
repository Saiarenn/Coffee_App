package repositories.interfaces;

import CoffeeFactoryPac.ICoffeePac.ICoffee;

import java.util.List;

public interface ICoffeeRepository {
    boolean createCoffee(double price, String description);
    boolean getOrder(int id);
    boolean getAllOrders();
}

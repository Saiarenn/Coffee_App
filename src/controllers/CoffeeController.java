package controllers;

import CoffeeFactoryPac.CoffeesPac.LatteCoffee;
import CoffeeFactoryPac.ICoffeePac.ICoffee;
import CoffeeStrategy.IStrategyCoffee.IBrewStrategy;
import repositories.interfaces.ICoffeeRepository;

import java.util.List;

public class CoffeeController {
    private final ICoffeeRepository repo;

    public CoffeeController(ICoffeeRepository repo) {
        this.repo = repo;
    }

    public boolean createCoffee(double price, String description) {
        return repo.createCoffee(price, description);
    }

    public boolean getOrder(int id) {
        return repo.getOrder(id);
    }

    public String getOrders() {
        return repo.getAllOrders() ? "Orders was found!" : "Orders not found";
    }
}

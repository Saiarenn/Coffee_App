package CoffeeFactoryPac;

import CoffeeFactoryPac.ICoffeePac.ICoffee;
import CoffeeStrategy.IStrategyCoffee.IBrewStrategy;

public abstract class Coffees implements ICoffee {
    private double price;
    private String coffeeName;
    private IBrewStrategy iBrewStrategy;


    public Coffees(double price, String coffeeName, IBrewStrategy iBrewStrategy) {
        this.price = price;
        this.coffeeName = coffeeName;
        setIBrewStrategy(iBrewStrategy);
    }
    @Override
    public double getCost() {
        return this.price;
    }

    @Override
    public String getDescription() {
        return this.coffeeName + " | " + iBrewStrategy.brew() + " | ";
    }

    public void setIBrewStrategy(IBrewStrategy iBrewStrategy) {
        this.iBrewStrategy = iBrewStrategy;
    }
}

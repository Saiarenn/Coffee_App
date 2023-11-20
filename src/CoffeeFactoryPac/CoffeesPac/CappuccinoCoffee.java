package CoffeeFactoryPac.CoffeesPac;

import CoffeeFactoryPac.Coffees;
import CoffeeStrategy.IStrategyCoffee.IBrewStrategy;

public class CappuccinoCoffee extends Coffees {
    public CappuccinoCoffee(IBrewStrategy iBrewStrategy) {
        super(4.0, "Cappuccino", iBrewStrategy);
    }
    @Override
    public String draw() {
        return null;
    }
}

package CoffeeFactoryPac.CoffeesPac;

import CoffeeFactoryPac.Coffees;
import CoffeeStrategy.BrewPackage.EspressoCoffee;
import CoffeeStrategy.IStrategyCoffee.IBrewStrategy;

public class AmericanoCoffee extends Coffees {
    public AmericanoCoffee(IBrewStrategy iBrewStrategy) {
        super(2.0, "Americano", iBrewStrategy);
    }
    @Override
    public String draw() {
        return null;
    }
}

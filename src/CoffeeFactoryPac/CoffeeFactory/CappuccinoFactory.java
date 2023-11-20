package CoffeeFactoryPac.CoffeeFactory;

import CoffeeFactoryPac.Coffees;
import CoffeeFactoryPac.CoffeesPac.CappuccinoCoffee;
import CoffeeFactoryPac.ICoffeePac.ICoffeeFactory;
import CoffeeStrategy.IStrategyCoffee.IBrewStrategy;

public class CappuccinoFactory implements ICoffeeFactory {
    private  IBrewStrategy iBrewStrategy;
    public CappuccinoFactory(IBrewStrategy iBrewStrategy) {
        this.iBrewStrategy = iBrewStrategy;
    }

    @Override
    public Coffees createCoffee() {
        return new CappuccinoCoffee(this.iBrewStrategy);
    }
}

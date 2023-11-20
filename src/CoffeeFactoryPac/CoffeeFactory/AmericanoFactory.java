package CoffeeFactoryPac.CoffeeFactory;

import CoffeeFactoryPac.Coffees;
import CoffeeFactoryPac.CoffeesPac.AmericanoCoffee;
import CoffeeFactoryPac.ICoffeePac.ICoffeeFactory;
import CoffeeStrategy.IStrategyCoffee.IBrewStrategy;

public class AmericanoFactory implements ICoffeeFactory {

    private  IBrewStrategy iBrewStrategy;
    public AmericanoFactory(IBrewStrategy iBrewStrategy) {
        this.iBrewStrategy = iBrewStrategy;
    }

    @Override
    public Coffees createCoffee() {
        return new AmericanoCoffee(this.iBrewStrategy);
    }
}

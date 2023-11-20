package CoffeeFactoryPac.CoffeeFactory;

import CoffeeAdapter.AdvancedCoffeeAdapter;
import CoffeeFactoryPac.Coffees;
import CoffeeFactoryPac.CoffeesPac.LatteCoffee;
import CoffeeFactoryPac.ICoffeePac.ICoffeeFactory;
import CoffeeStrategy.IStrategyCoffee.IBrewStrategy;

public class LatteFactory implements ICoffeeFactory {
    private IBrewStrategy iBrewStrategy;

    private AdvancedCoffeeAdapter advancedCoffeeAdapter;

    public LatteFactory(IBrewStrategy iBrewStrategy, AdvancedCoffeeAdapter advancedCoffeeAdapter) {
        this.iBrewStrategy = iBrewStrategy;
        this.advancedCoffeeAdapter = advancedCoffeeAdapter != null ? advancedCoffeeAdapter : null;

    }

    @Override
    public Coffees createCoffee() {
        return new LatteCoffee(this.iBrewStrategy, this.advancedCoffeeAdapter);
    }
}

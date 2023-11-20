package CoffeeFactoryPac.CoffeesPac;

import CoffeeAdapter.CoffeeAdapter;
import CoffeeAdapter.CoffeeArt;
import CoffeeAdapter.AdvancedCoffeeAdapter;
import CoffeeFactoryPac.Coffees;
import CoffeeStrategy.IStrategyCoffee.IBrewStrategy;

public class LatteCoffee extends Coffees implements CoffeeArt {


    public LatteCoffee(IBrewStrategy brewStrategy, AdvancedCoffeeAdapter coffeeAdapter) {
        super(3.5, "Latte", brewStrategy);
        if (coffeeAdapter != null) {
            setArtAdapter(coffeeAdapter);
        }
    }

    private CoffeeAdapter coffeeAdapter;

    public void setArtAdapter(AdvancedCoffeeAdapter coffeeAdapter) {
        this.coffeeAdapter = new CoffeeAdapter(coffeeAdapter);
    }

    @Override
    public String draw() {
        return coffeeAdapter.draw();
    }

    @Override
    public String getDescription() {
        return super.getDescription() + (coffeeAdapter == null ? "" : coffeeAdapter.draw() + " | ");
    }
}


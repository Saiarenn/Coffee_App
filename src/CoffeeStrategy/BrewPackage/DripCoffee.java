package CoffeeStrategy.BrewPackage;

import CoffeeStrategy.IStrategyCoffee.IBrewStrategy;

public class DripCoffee implements IBrewStrategy {
    @Override
    public String brew() {
        return "Капельная заварка кофе";
    }
}

package CoffeeStrategy.BrewPackage;

import CoffeeStrategy.IStrategyCoffee.IBrewStrategy;

public class EspressoCoffee implements IBrewStrategy {
    @Override
    public String brew() {
        return "Приготовление эспрессо";
    }
}

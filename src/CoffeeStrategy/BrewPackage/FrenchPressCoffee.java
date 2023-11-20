package CoffeeStrategy.BrewPackage;

import CoffeeStrategy.IStrategyCoffee.IBrewStrategy;

public class FrenchPressCoffee implements IBrewStrategy {
    @Override
    public String brew() {
        return "Приготовление кофе во френч-прессе";
    }
}

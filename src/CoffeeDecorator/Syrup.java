package CoffeeDecorator;

import CoffeeFactoryPac.ICoffeePac.ICoffee;

public class Syrup extends CoffeeDecorator {
    public Syrup(ICoffee iCoffeeAdd) {
        super(iCoffeeAdd);
    }

    @Override
    public double getCost() {
        return super.getCost() + 3.0; // Добавляем стоимость сиропа
    }

    @Override
    public String getDescription() {
        return super.getDescription() + "Syrup ";
    }

    @Override
    public String draw() {
        return null;
    }
}

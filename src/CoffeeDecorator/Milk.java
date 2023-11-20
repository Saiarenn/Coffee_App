package CoffeeDecorator;

import CoffeeFactoryPac.ICoffeePac.ICoffee;

public class Milk extends CoffeeDecorator {
    public Milk(ICoffee iCoffeeAdd) {
        super(iCoffeeAdd);
    }

    @Override
    public double getCost() {
        return super.getCost() + 2.0; // Добавляем стоимость молока
    }

    @Override
    public String getDescription() {
        return super.getDescription() + "Milk ";
    }

    @Override
    public String draw() {
        return null;
    }
}

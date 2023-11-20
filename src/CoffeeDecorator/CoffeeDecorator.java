package CoffeeDecorator;


import CoffeeFactoryPac.ICoffeePac.ICoffee;

abstract class CoffeeDecorator implements ICoffee {
    private ICoffee iCoffeeWith;

    public CoffeeDecorator(ICoffee iCoffeeWith) {
        this.iCoffeeWith = iCoffeeWith;
    }

    @Override
    public double getCost() {
        return iCoffeeWith.getCost();
    }

    @Override
    public String getDescription() {
        return iCoffeeWith.getDescription();
    }
}

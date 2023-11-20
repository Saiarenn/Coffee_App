package CoffeeObserver;

public class CoffeeDrinker implements CoffeeObserver {
    @Override
    public void update() {
        System.out.println("CoffeeDrinker: Time to enjoy the coffee!");
    }
}

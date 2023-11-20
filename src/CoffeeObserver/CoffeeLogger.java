package CoffeeObserver;

public class CoffeeLogger implements CoffeeObserver {
    @Override
    public void update() {
        System.out.println("CoffeeLogger: Logging the coffee consumption.");
    }
}


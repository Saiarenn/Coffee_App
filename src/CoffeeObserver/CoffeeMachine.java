package CoffeeObserver;

public interface CoffeeMachine {
    void addObserver(CoffeeObserver observer);
    void removeObserver(CoffeeObserver observer);
    void notifyObservers();
}


package CoffeeObserver;

import java.util.ArrayList;
import java.util.List;

public class CoffeeMaker implements CoffeeMachine {
    private List<CoffeeObserver> observers = new ArrayList<>();

    @Override
    public void addObserver(CoffeeObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(CoffeeObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (CoffeeObserver observer : observers) {
            observer.update();
        }
    }
}


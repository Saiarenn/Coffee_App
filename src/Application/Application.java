package Application;

import java.util.InputMismatchException;
import java.util.Scanner;

import CoffeeAdapter.AdvancedCoffeeAdapter;
import CoffeeAdapter.HeartDrawer;
import CoffeeAdapter.TulipDrawer;
import CoffeeDecorator.Milk;
import CoffeeDecorator.Syrup;
import CoffeeFactoryPac.CoffeeFactory.AmericanoFactory;
import CoffeeFactoryPac.CoffeeFactory.CappuccinoFactory;
import CoffeeFactoryPac.CoffeeFactory.LatteFactory;
import CoffeeFactoryPac.ICoffeePac.ICoffee;
import CoffeeFactoryPac.ICoffeePac.ICoffeeFactory;
import CoffeeStrategy.BrewPackage.DripCoffee;
import CoffeeStrategy.BrewPackage.EspressoCoffee;
import CoffeeStrategy.BrewPackage.FrenchPressCoffee;
import CoffeeStrategy.IStrategyCoffee.IBrewStrategy;
import controllers.CoffeeController;
import CoffeeObserver.*;

public class Application {
    private final CoffeeController controller;
    private final Scanner scanner;

    public Application(CoffeeController controller) {
        this.controller = controller;
        scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            System.out.println();
            System.out.println("Welcome to My Application");
            System.out.println("Select option:");
            System.out.println("1. Get all Orders");
            System.out.println("2. Get Order");
            System.out.println("3. Create Order");
            System.out.println("0. Exit");
            System.out.println();
            try {
                System.out.print("Enter option (1-3): ");
                int option = scanner.nextInt();
                switch (option) {
                    case 1:
                        getAllOrdersMenu();
                        break;
                    case 2:
                        getOrderByIdMenu();
                        break;
                    case 3:
                        createOrderDescription();
                        break;
                    default:
                        return;
                }
            } catch (InputMismatchException x) {
                System.out.println("Input must be integer");
                scanner.nextLine(); // to ignore incorrect input
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            System.out.println("--------------------------------------------------------------");
        }
    }

    public void getAllOrdersMenu() {
        System.out.println(controller.getOrders());
    }

    public void getOrderByIdMenu() {
        System.out.println("Please what your id order?");
        int order = scanner.nextInt();
        feedbackForCreatingCoffee(controller.getOrder(order), 2);
    }

    public void createOrderDescription() {
        ICoffeeFactory coffeeFactory = getFactory();
        ICoffee iCoffee = addMilkOrSyrup(getAddFirstMilkOrSyrup(coffeeFactory));
        feedbackForCreatingCoffee((controller.createCoffee(iCoffee.getCost(), iCoffee.getDescription())), 1);
    }

    private ICoffeeFactory getFactory() {
        ICoffeeFactory coffeeFactory = null;
        System.out.println("Please what you want?\n1.Latte\n2.Americano\n3.Cappuccino");

        int coffee = scanner.nextInt();
        switch (coffee) {
            case 1:
                System.out.println("You want art on your coffee?\n1.Yes\n2.No");
                int num = scanner.nextInt();
                coffeeFactory = num == 1 ? new LatteFactory(getBrew(), getArtOnCoffee()) : new LatteFactory(getBrew(), null);
                break;
            case 2:
                coffeeFactory = new CappuccinoFactory(getBrew());
                break;
            case 3:
                coffeeFactory = new AmericanoFactory(getBrew());
                break;
        }
        return coffeeFactory;
    }

    private ICoffee getAddFirstMilkOrSyrup(ICoffeeFactory coffeeFactory) {
        ICoffee iCoffee = null;
        System.out.println("Please what you want to add to coffee?\n1.Milk\n2.Syrup");
        int num3 = scanner.nextInt();
        switch (num3) {
            case 1:
                iCoffee = new Milk(coffeeFactory.createCoffee());
                break;
            case 2:
                iCoffee = new Syrup(coffeeFactory.createCoffee());
                break;
            default:
                iCoffee = coffeeFactory.createCoffee();
        }
        return iCoffee;
    }

    private IBrewStrategy getBrew() {
        IBrewStrategy iBrewStrategy = null;
        System.out.println("Please what brew you want?\n1.Drip\n2.Espresso\n3.French");
        int brew = scanner.nextInt();
        switch (brew) {
            case 1:
                iBrewStrategy = new DripCoffee();
                break;
            case 2:
                iBrewStrategy = new EspressoCoffee();
                break;
            case 3:
                iBrewStrategy = new FrenchPressCoffee();
                break;
        }
        return iBrewStrategy;
    }


    private AdvancedCoffeeAdapter getArtOnCoffee() {
        AdvancedCoffeeAdapter advancedCoffeeAdapter = null;

        System.out.println("What type of art you want?\n1.Heart\n2.Tulip");
        int art = scanner.nextInt();
        switch (art) {
            case 1:
                advancedCoffeeAdapter = new HeartDrawer();
                break;
            case 2:
                advancedCoffeeAdapter = new TulipDrawer();
                break;
        }
        return advancedCoffeeAdapter;
    }

    private ICoffee addMilkOrSyrup(ICoffee iCoffee) {
        while (true) {
            System.out.println("You want add more a milk or syrup.\nIf you don't need, you can press any number\n1.Milk\n2.Syrup");
            int num = scanner.nextInt();
            switch (num) {
                case 1:
                    iCoffee = new Milk(iCoffee);
                    break;
                case 2:
                    iCoffee = new Syrup(iCoffee);
                    break;
                default:
                    return iCoffee;
            }
        }
    }

    private void feedbackForCreatingCoffee(boolean answer, int seq) {
        CoffeeMachine coffeeMachine = new CoffeeMaker();
        if (answer) {
            switch (seq) {
                case 1:
                    coffeeMachine.addObserver(new CoffeeLogger());
                    break;
                case 2:
                    coffeeMachine.addObserver(new CoffeeDrinker());
                    break;
            }
            coffeeMachine.notifyObservers();
        } else {
            System.out.println("Unfortunately the coffee machine doesn't work");
        }
    }
}

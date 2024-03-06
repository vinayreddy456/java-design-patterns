// Pizza.java - Component interface
 abstract class Pizza {
    protected String description;

    public String getDescription() {
        return description;
    }

    public abstract double getCost();
}


 class PlainPizza extends Pizza {
    public PlainPizza() {
        description = "Plain Pizza";
    }

    @Override
    public double getCost() {
        return 500;
    }
}

// Decorator abstract class
 abstract class ToppingDecorator extends Pizza {
    protected Pizza pizza;

    public ToppingDecorator(Pizza pizza) {
        this.pizza = pizza;
        System.out.println("parent");
    }

    @Override
    public abstract String getDescription();
}

// Concrete decorators
 class Cheese extends ToppingDecorator {
    public Cheese(Pizza pizza) { 
        super(pizza);
        System.out.println("child");
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + ", Cheese";
    }

    @Override
    public double getCost() {
        return pizza.getCost() + 150;
    }
}

 class Pepperoni extends ToppingDecorator {
    public Pepperoni(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + ", Pepperoni";
    }

    @Override
    public double getCost() {
        return pizza.getCost() + 200;
    }
}

// Main class to test the Decorator pattern
public class Decorator_Pattern {
    public static void main(String[] args) {
        // Create a plain pizza
        Pizza plainPizza = new PlainPizza();
        System.out.println("Ordered: " + plainPizza.getDescription() + ", Cost: " + plainPizza.getCost());

        // Add cheese to the pizza
        Pizza cheesePizza = new Cheese(plainPizza);
        System.out.println("Ordered: " + cheesePizza.getDescription() + ", Cost: " + cheesePizza.getCost());

        // Add pepperoni to the pizza with cheese
        Pizza pepperoniPizza = new Pepperoni(plainPizza);
        System.out.println("Ordered: " + pepperoniPizza.getDescription() + ", Cost: " + pepperoniPizza.getCost());

        Pizza pepperonicheesePizza = new Pepperoni(cheesePizza);
        System.out.println("Ordered: " + pepperonicheesePizza.getDescription() + ", Cost: " + pepperonicheesePizza.getCost());
    }
}

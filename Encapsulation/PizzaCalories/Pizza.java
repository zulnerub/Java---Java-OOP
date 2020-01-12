package Encapsulation.PizzaCalories;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private String name;
    private Dough dough;
    private List<Topping> toppings;
    private double totalCals = 0;

    public Pizza(String name, int numberOfToppings) {
        this.setName(name);
        this.setToppings(numberOfToppings);
    }

    private void setName(String name) {
        if (name.trim().isEmpty() || name.length() > 15){
            throw new IllegalArgumentException("Pizza name should be between 1 and 15 symbols.");
        }
        this.name = name;
    }

    public void setDough(Dough dough) {
        this.dough = dough;
    }

    private void setToppings(int numberOfToppings){
        if (numberOfToppings < 0 || numberOfToppings > 10){
            throw new IllegalArgumentException("Number of toppings should be in range [0..10].");
        }
        this.toppings = new ArrayList<>(numberOfToppings);
    }

    public String getName() {
        return this.name;
    }

    public void addTopping(Topping topping){
        this.toppings.add(topping);
    }

    public double getOverallCalories(){
        totalCals += this.dough.calculateCalories();

        this.toppings.forEach(e -> {
            totalCals += e.calculateCalories();
        });

        return totalCals;

    }
}

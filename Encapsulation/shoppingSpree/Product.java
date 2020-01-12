package Encapsulation.shoppingSpree;

public class Product {
    private String name;
    private double cost;

    public Product(String name, double cost) {

        this.setName(name);
        this.setCost(cost);
    }

    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        if (name.trim().isEmpty() || name.contains("\\W+")){
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    public double getCost() {
        return this.cost;
    }

    private void setCost(double cost) {
        this.cost = cost;
    }
}

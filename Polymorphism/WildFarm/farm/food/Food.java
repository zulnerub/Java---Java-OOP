package Polymorphism.WildFarm.farm.food;

public abstract class Food {
    private Integer quantity;

    protected Food(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return this.quantity;
    }

}

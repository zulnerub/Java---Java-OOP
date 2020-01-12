package Polymorphism.WildFarm.farm.animal;

import Polymorphism.WildFarm.farm.food.Food;

import java.text.DecimalFormat;

public abstract class Animal {
    private String animalName;
    private String animalType;
    private double animalWeight;
    private int foodEaten;

    protected Animal(String animalName, String animalType, Double animalWeight) {
        this.animalName = animalName;
        this.animalType = animalType;
        this.animalWeight = animalWeight;
        this.foodEaten = 0;
    }

    public String getAnimalName() {
        return this.animalName;
    }

    protected String getAnimalType() {
        return this.animalType;
    }

    public Double getAnimalWeight() {
        return this.animalWeight;
    }

    public Integer getFoodEaten() {
        return this.foodEaten;
    }

    protected void setFoodEaten(Integer foodEaten) {
        this.foodEaten = foodEaten;
    }

    public abstract void makeSound();
    public void eatFood(Food food){
        this.foodEaten += food.getQuantity();
    }


    @Override
    public String toString() {
        return String.format("%s[%s, %s, region, %d]",
                this.getAnimalType(),
                this.getAnimalName(),
                new DecimalFormat("#.##").format(this.getAnimalWeight()),
                this.getFoodEaten());

    }
}

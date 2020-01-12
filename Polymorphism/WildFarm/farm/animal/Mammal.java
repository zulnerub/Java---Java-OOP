package Polymorphism.WildFarm.farm.animal;

import Polymorphism.WildFarm.farm.food.Food;

public abstract class Mammal extends Animal {
    private String livingRegion;
    protected Mammal(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight);
        this.livingRegion = livingRegion;
    }


    public String getLivingRegion() {
        return this.livingRegion;
    }

    @Override
    public void eatFood(Food food){
        boolean foodIsMeat = food.getClass().getSimpleName().equals("Meat");
        if (foodIsMeat && !(this instanceof Felime)){
            String message = (this.getAnimalType() + "s are not eating that type of food!").replace("Mouses","Mice");
            throw new IllegalArgumentException(message);

        }else if (!foodIsMeat && this.getAnimalType().equals("Tiger")){
            throw new IllegalArgumentException(
                    "Tigers are not eating that type of food!"
            );
        }
        super.eatFood(food);
    }

    @Override
    public String toString() {
        return super.toString().replace("region", this.livingRegion);
    }
}

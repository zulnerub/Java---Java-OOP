package Polymorphism.WildFarm.farm.animal;

public class Mouse extends Mammal {
    public Mouse(String animalName, String animalType, Double animalWeight, String livinRegion) {
        super(animalName, animalType, animalWeight, livinRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("SQUEEEAAAK!");
    }


}

package Polymorphism.WildFarm.farm.animal;

public class Zebra extends Mammal {
    public Zebra(String animalName, String animalType, Double animalWeight , String livinRegion) {
        super(animalName, animalType, animalWeight, livinRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("Zs");
    }




}

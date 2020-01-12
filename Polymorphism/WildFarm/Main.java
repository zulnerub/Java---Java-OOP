package Polymorphism.WildFarm;

import Polymorphism.WildFarm.farm.animal.*;
import Polymorphism.WildFarm.farm.food.Food;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));

        String input = "";

        List<Animal> animals = new ArrayList<>();

        while (!"End".equals(input = rd.readLine())){
            String[] animal = input.split("\\s+");
            String[] food = rd.readLine().split("\\s+");

            Animal animaNew = produceAnimal(animal);

            Food foodNew = produce(food);



            try {
                animaNew.makeSound();
                animaNew.eatFood(foodNew);
            }catch (IllegalArgumentException ex){
                System.out.println(ex.getMessage());
            }

            animals.add(animaNew);
        }

        for (Animal animal : animals) {
            System.out.println(animal.toString());
        }
    }

    private static Food produce(String[] food) {
        String type = food[0];

        Food foodNew = null;
        try {
            Class foodClass = Class.forName("farm.food." + type);
            Constructor constructor = foodClass.getConstructor(int.class);
            foodNew = (Food) constructor.newInstance(Integer.parseInt(food[1]));
        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        return foodNew;
    }

    private static Animal produceAnimal(String[] animal) {
        Animal animalNew = null;

        String type = animal[0];
        if (type.equals("Mouse")){
            animalNew = new Mouse(animal[1], animal[0], Double.parseDouble(animal[2]), animal[3]);

        }else if (type.equals("Zebra")){
            animalNew = new Zebra(animal[1], animal[0], Double.parseDouble(animal[2]), animal[3]);

        }else if (type.equals("Tiger")){
            animalNew = new Tiger(animal[1], animal[0], Double.parseDouble(animal[2]), animal[3]);

        }else if (type.equals("Cat")){
            animalNew = new Cat(animal[1], animal[0], Double.parseDouble(animal[2]), animal[3], animal[4]);
        }


        return animalNew;
    }
}

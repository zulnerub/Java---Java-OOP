package Encapsulation.PizzaCalories;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));

        String pizzaInfo[] = rd.readLine().split("\\s+");
        String doughInfo[] = rd.readLine().split("\\s+");

        try{
            Pizza pizza = new Pizza(pizzaInfo[1], Integer.parseInt(pizzaInfo[2]));
            Dough dough = new Dough(doughInfo[1], doughInfo[2], Double.parseDouble(doughInfo[3]));

            pizza.setDough(dough);

            String input = "";
            while (!"END".equals(input = rd.readLine())){
                String toppingInfo[] = input.split("\\s+");
                Topping topping = new Topping(toppingInfo[1], Double.parseDouble(toppingInfo[2]));
                pizza.addTopping(topping);
            }

            System.out.printf("%s - %.2f",pizza.getName(), pizza.getOverallCalories());
        }catch (IllegalArgumentException ex){
            System.out.println(ex.getMessage());
        }





    }
}

package Encapsulation.shoppingSpree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        String[] persons = rd.readLine().trim().split(";");
        String[] products = rd.readLine().trim().split(";");

        LinkedHashMap<String, Person> personsAll = new LinkedHashMap<>();
        LinkedHashMap<String, Product> productsAll = new LinkedHashMap<>();


        for (String value : persons) {
            String name = value.substring(0, value.indexOf("="));
            double money = Double.parseDouble(value.substring(value.indexOf("=") + 1));
            try {
                Person person = new Person(name, money);
                personsAll.put(person.getName(), person);
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }


        }

        for (String s : products) {
            String name = s.substring(0, s.indexOf("="));
            double cost = Double.parseDouble(s.substring(s.indexOf("=") + 1));
            try {
                Product product = new Product(name, cost);
                productsAll.put(product.getName(), product);
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }

        }

        String input;

        while (!"END".equals(input = rd.readLine())){
            String[] command = input.split("\\s+");
            Product pr = productsAll.get(command[1]);
            try{
                personsAll.get(command[0]).buyProduct(pr);
            }catch (IllegalArgumentException ex){
                System.out.println(ex.getMessage());
            }
        }

        personsAll.forEach((k, v) -> System.out.println(v.toString()));
    }
}

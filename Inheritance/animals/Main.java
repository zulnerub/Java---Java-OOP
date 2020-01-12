package Inheritance.animals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        Map<String, List<Animal>> animals = new LinkedHashMap<>();

        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));

        String type = rd.readLine();

        while (!"Beast!".equals(type)) {
            String input = rd.readLine();
            String[] data = input.split("\\s+");

            if ((data.length >= 2 && data.length <= 3) &&
                    type.equalsIgnoreCase("tomcat") ||
                    type.equalsIgnoreCase("kitten")) {
                if (!animals.containsKey(type)) {
                    animals.put(type, new ArrayList<>());
                }
                switch (type) {
                    case "Tomcat":
                        animals.get(type).add(new Tomcat(data[0], Integer.parseInt(data[1])));
                        break;
                    case "Kitten":
                        animals.get(type).add(new Kitten(data[0], Integer.parseInt(data[1])));
                        break;
                }

            } else if (data.length == 3 && (Integer.parseInt(data[1]) > 0
                    && (data[2].equalsIgnoreCase("male")
                    || data[2].equalsIgnoreCase("female")))) {
                if (!animals.containsKey(type)) {
                    animals.put(type, new ArrayList<>());
                }
                switch (type) {
                    case "Tomcat":
                    case "Kitten":
                        if (data[2].equals("Male")) {
                            animals.get(type).add(new Tomcat(data[0], Integer.parseInt(data[1])));
                        } else {
                            animals.get(type).add(new Kitten(data[0], Integer.parseInt(data[1])));
                        }
                        break;

                    case "Cat":
                        animals.get(type).add(new Cat(data[0], Integer.parseInt(data[1]), data[2]));
                        break;

                    case "Dog":
                        animals.get(type).add(new Dog(data[0], Integer.parseInt(data[1]), data[2]));
                        break;

                    case "Frog":
                        animals.get(type).add(new Frog(data[0], Integer.parseInt(data[1]), data[2]));
                        break;
                }
            } else {
                System.out.println("Invalid input!");
            }
            type = rd.readLine();
        }

        animals.values().forEach(o -> System.out.println(o.toString().replaceAll("[\\[\\]]", "")));
    }
}

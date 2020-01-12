package Encapsulation.animalFarm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));

        String name = rd.readLine();
        int age = Integer.parseInt(rd.readLine());

        try{
            Chicken chicken = new Chicken(name, age);
            System.out.println(chicken.toString());
        }catch (IllegalArgumentException ex){
            System.out.println(ex.getMessage());
        }

    }
}

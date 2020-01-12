package Polymorphism.Vehicles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));

        String[] input = rd.readLine().split("\\s+");
        Car car = new Car(Double.parseDouble(input[1]), Double.parseDouble(input[2]));
        input = rd.readLine().split("\\s+");
        Truck truck = new Truck(Double.parseDouble(input[1]), Double.parseDouble(input[2]));
        int n = Integer.parseInt(rd.readLine());
        DecimalFormat df = new DecimalFormat("#.##");
        for (int i = 0; i < n; i++) {
            input = rd.readLine().split("\\s+");
            if (input[0].equals("Drive")){
                if (input[1].equals("Car")){
                    try{
                        car.drive(Double.parseDouble(input[2]));
                        System.out.printf("Car travelled %s km%n", df.format(Double.parseDouble(input[2])));
                    }catch (IllegalArgumentException ex){
                        System.out.println(ex.getMessage());
                    }
                }else{
                    try{
                        truck.drive(Double.parseDouble(input[2]));
                        System.out.printf("Truck travelled %s km%n", df.format(Double.parseDouble(input[2])));
                    }catch (IllegalArgumentException ex){
                        System.out.println(ex.getMessage());
                    }
                }
            }else{
                if (input[1].equals("Car")){
                    car.refuel(Double.parseDouble(input[2]));

                }else{
                    truck.refuel(Double.parseDouble(input[2]));

                }
            }
        }

        System.out.printf("Car: %.2f%n", car.getFuel());
        System.out.printf("Truck: %.2f%n", truck.getFuel());
    }
}

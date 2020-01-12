package Polymorphism.VehiclesExtended;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));

        String[] input = rd.readLine().split("\\s+");
        Car car = new Car(Double.parseDouble(input[1]), Double.parseDouble(input[2]), Double.parseDouble(input[3]));
        input = rd.readLine().split("\\s+");
        Truck truck = new Truck(Double.parseDouble(input[1]), Double.parseDouble(input[2]), Double.parseDouble(input[3]));
        input = rd.readLine().split("\\s+");
        Bus bus = new Bus(Double.parseDouble(input[1]), Double.parseDouble(input[2]), Double.parseDouble(input[3]));

        int n = Integer.parseInt(rd.readLine());

        DecimalFormat df = new DecimalFormat("#.##");

        for (int i = 0; i < n; i++) {
            input = rd.readLine().split("\\s+");
            switch (input[0]) {
                case "Drive":
                    switch (input[1]) {
                        case "Car":
                            try {
                                car.drive(Double.parseDouble(input[2]));
                                System.out.printf("Car travelled %s km%n", df.format(Double.parseDouble(input[2])));
                            } catch (IllegalArgumentException ex) {
                                System.out.println(ex.getMessage());
                            }
                            break;
                        case "Truck":
                            try {
                                truck.drive(Double.parseDouble(input[2]));
                                System.out.printf("Truck travelled %s km%n", df.format(Double.parseDouble(input[2])));
                            } catch (IllegalArgumentException ex) {
                                System.out.println(ex.getMessage());
                            }
                            break;
                        case "Bus":
                            try {
                                bus.setEmpty(false);
                                bus.drive(Double.parseDouble(input[2]));
                                System.out.printf("Bus travelled %s km%n", df.format(Double.parseDouble(input[2])));
                            } catch (IllegalArgumentException ex) {
                                System.out.println(ex.getMessage());
                            }
                            break;
                    }
                    break;
                case "Refuel":
                    try {

                        switch (input[1]) {
                            case "Car":
                                car.refuel(Double.parseDouble(input[2]));

                                break;
                            case "Truck":
                                truck.refuel(Double.parseDouble(input[2]));

                                break;
                            case "Bus":
                                bus.refuel(Double.parseDouble(input[2]));
                                break;
                        }
                    } catch (IllegalArgumentException ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                case "DriveEmpty":
                    try {
                        bus.setEmpty(true);
                        bus.drive(Double.parseDouble(input[2]));
                        System.out.printf("Bus travelled %s km%n", df.format(Double.parseDouble(input[2])));
                    } catch (IllegalArgumentException ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
            }
        }

        System.out.printf("Car: %.2f%n", car.getFuel());
        System.out.printf("Truck: %.2f%n", truck.getFuel());
        System.out.printf("Bus: %.2f%n", bus.getFuel());
    }
}

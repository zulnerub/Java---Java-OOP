package Encapsulation.ClassBox;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));

        double length = Double.parseDouble(rd.readLine());
        double width = Double.parseDouble(rd.readLine());
        double height = Double.parseDouble(rd.readLine());

        try {
            Box box = new Box(length, width, height);
            System.out.printf("Surface Area - %.2f%n",
                    box.calculateSurfaceArea());
            System.out.printf("Lateral Surface Area - %.2f%n",
                    box.calculateLateralSurfaceArea());
            System.out.printf("Volume - %.2f%n",
                    box.calculateVolume());
        }catch (IllegalArgumentException ex){
            System.out.println(ex.getMessage());
        }

    }
}

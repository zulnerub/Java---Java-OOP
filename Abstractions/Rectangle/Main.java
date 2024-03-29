package Abstractions.Rectangle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));

        int[] coordinates = Arrays.stream(rd.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        Point bottomLeft = new Point(coordinates[0], coordinates[1]);
        Point topLeft = new Point(coordinates[2], coordinates[3]);

        Rectangle rectangle = new Rectangle(bottomLeft, topLeft);

        int pointCount = Integer.parseInt(rd.readLine());

        while (pointCount-- > 0){
            int[] pointCoordinates = Arrays.stream(rd.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            Point newPoint = new Point(pointCoordinates[0], pointCoordinates[1]);

            System.out.println(rectangle.contains(newPoint));
        }

    }
}

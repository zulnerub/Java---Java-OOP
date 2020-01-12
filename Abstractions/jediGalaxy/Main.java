package Abstractions.jediGalaxy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));

        int[] dimensions = readIntegerArray(rd.readLine());

        int x = dimensions[0];
        int y = dimensions[1];

        Galaxy galaxy = new Galaxy(x, y);

        Player player = new Player();

        Cluster cluster = new Cluster(galaxy);

        String input;
        while (!"Let the Force be with you".equals(input = rd.readLine())) {
            int[] playerRC = readIntegerArray(input);
            int[] evilPower = readIntegerArray(rd.readLine());

            cluster.moveEvilForce(evilPower[0],evilPower[1] );
            long starsToAdd = cluster.collectPlayerStars(playerRC[0],playerRC[1] );
            player.addStars(starsToAdd);
        }
        System.out.println(player.getStars());
    }

    private static int[] readIntegerArray(String input) {
        return Arrays.stream(input.split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}

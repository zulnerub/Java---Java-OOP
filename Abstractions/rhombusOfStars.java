package Abstractions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class rhombusOfStars {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(rd.readLine());

        for (int row = 1; row <= n; row++) {

            System.out.print(printSpace(" ", n - row));
            System.out.print(printSpace("* ", row));
            System.out.println();
        }

        for (int brow = n - 1; brow > 0 ; brow--) {
            System.out.print(printSpace(" ", n - brow));
            System.out.print(printSpace("* ", brow));
            System.out.println();
        }
    }

    private static String printSpace(String str, int count) {
        StringBuilder sb = new StringBuilder();

        while (count-- > 0){
            sb.append(str);
        }
        return sb.toString();
    }
}

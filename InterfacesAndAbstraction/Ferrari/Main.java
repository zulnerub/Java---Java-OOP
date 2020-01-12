package InterfacesAndAbstraction.Ferrari;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));

        Ferrari ferrari = new Ferrari(rd.readLine());
        System.out.println(ferrari.toString());
    }
}

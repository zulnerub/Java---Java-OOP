package InterfacesAndAbstraction.SmartPhone;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader rd= new BufferedReader(new InputStreamReader(System.in));

        List<String> numbers = new ArrayList<>(Arrays.asList(rd.readLine().split("\\s+")));
        List<String> urls = new ArrayList<>(Arrays.asList(rd.readLine().split("\\s+")));


        Smartphone smartphone = new Smartphone(numbers, urls);

        System.out.print(smartphone.call());
        System.out.print(smartphone.browse());
    }
}

package InterfacesAndAbstraction.BorderControl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));

        List<Identifiable> list = new ArrayList<>();

        String input = "";

        while (!"End".equals(input = rd.readLine())){
            String[] data = input.split("\\s+");
            if (data.length == 2){
                Robot robot = new Robot(data[0], data[1]);
                list.add(robot);
            }else{
                Citizen citizen = new Citizen(data[0], Integer.parseInt(data[1]), data[2]);
                list.add(citizen);
            }
        }

        String toEnd = rd.readLine();

        list.stream()
                .filter(e -> e.getId().endsWith(toEnd))
                .forEach(e -> System.out.println(e.getId()));
        ;
    }
}

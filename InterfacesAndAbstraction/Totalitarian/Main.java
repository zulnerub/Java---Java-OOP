package InterfacesAndAbstraction.Totalitarian;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Buyer> list = new LinkedHashMap<>();

        int people = Integer.parseInt(rd.readLine());

        for (int i = 0; i < people; i++) {
            String[] info = rd.readLine().split("\\s+");
            if (info.length == 3){
                Rebel rebel = new Rebel(info[0], Integer.parseInt(info[1]), info[2]);
                list.put(info[0], rebel);
            }else if (info.length == 4){
                Citizen citizen = new Citizen(info[0], Integer.parseInt(info[1]), info[2], info[3]);
                list.put(info[0], citizen);
            }
        }

        String input = "";
        while (!"End".endsWith(input = rd.readLine())){
            if (list.containsKey(input)){
                list.get(input).buyFood();
            }
        }

        int totalFood = list.values().stream().mapToInt(Buyer::getFood).sum();
        System.out.println(totalFood);
    }
}

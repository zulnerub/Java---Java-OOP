package InterfacesAndAbstraction.BirthdayCeleb;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));

        Map<String, String> data = new LinkedHashMap<>();

        String input = "";

        while (!"End".equals(input = rd.readLine())){
            String[] command = input.split("\\s+");
            if (command[0].equals("Citizen") || command[0].equals("Pet")){
                data.putIfAbsent(command[1], command[command.length -1]);
            }
        }
        String birthdayData = rd.readLine();
        data.values().forEach(e -> {
            if (e.endsWith(birthdayData)){
                System.out.println(e);
            }
        });
    }
}

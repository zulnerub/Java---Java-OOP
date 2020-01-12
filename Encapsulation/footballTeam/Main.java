package Encapsulation.footballTeam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Team> teams = new LinkedHashMap<>();

        String input = "";

        while (!"END".equals(input = rd.readLine())){
            String command[] = input.split(";");

            switch (command[0]){
                case "Team":
                    if (!teams.containsKey(command[1])){
                        try{
                            Team team = new Team(command[1]);
                            teams.put(command[1], team);
                        }catch (IllegalArgumentException ex){
                            System.out.println(ex.getMessage());
                        }

                    }
                break;

                case "Add":
                    if (!teams.containsKey(command[1])){
                        System.out.println("Team " + command[1] + " does not exist.");
                    }else{
                        try {
                            Player player = new Player(command[2],
                                    Integer.parseInt(command[3]),
                                    Integer.parseInt(command[4]),
                                    Integer.parseInt(command[5]),
                                    Integer.parseInt(command[6]),
                                    Integer.parseInt(command[7]));
                            teams.get(command[1]).addPlayer(player);
                        }catch (IllegalArgumentException ex){
                            System.out.println(ex.getMessage());
                        }

                    }
                    break;

                case "Remove":
                    try {
                        teams.get(command[1]).removePlayer(command[2]);
                    }catch (IllegalArgumentException ex){
                        System.out.println(ex.getMessage());
                    }
                    break;

                case "Rating":
                    if (!teams.containsKey(command[1])){
                        System.out.println("Team " + command[1] + " does not exist.");
                    }else{
                        System.out.printf("%s - %d%n",
                                command[1],
                                Math.round(teams.get(command[1]).getRating()));
                    }
                    break;
            }
        }
    }
}

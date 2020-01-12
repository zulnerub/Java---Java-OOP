package Abstractions.TrafficLights;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));

        String[] trafficLights = rd.readLine().split("\\s+");
        int shifter = Integer.parseInt(rd.readLine());

        TrafficLights[] traf = TrafficLights.values();

        for (int i = 0; i < shifter; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < trafficLights.length; j++) {
                if (TrafficLights.valueOf(trafficLights[j]).getValue() == 2) {
                    sb.append(traf[0]).append(" ");
                    trafficLights[j] = traf[0].name();
                } else {
                    int index = TrafficLights.valueOf(trafficLights[j]).getValue() + 1;
                    sb.append(traf[index]).append(" ");
                    trafficLights[j] = traf[index].name();
                }
            }
            System.out.println(sb.toString());
        }
    }
}

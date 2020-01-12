package InterfacesAndAbstraction.army;

import InterfacesAndAbstraction.army.Enums.Corps;
import InterfacesAndAbstraction.army.Enums.MissionState;
import InterfacesAndAbstraction.army.HelperClasses.Interfaces.Mission;
import InterfacesAndAbstraction.army.HelperClasses.MissionImpl;
import InterfacesAndAbstraction.army.HelperClasses.RepairImpl;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        Map<Integer, PrivateImpl> privates = new LinkedHashMap<>();


        String input = "";


            while (!"End".equals(input = rd.readLine())){
                String[] data = input.split("\\s+");
                switch (data[0]){
                    case "Private":
                        PrivateImpl soldier = new PrivateImpl(Integer.parseInt(data[1]), data[2], data[3], Double.parseDouble(data[4]));
                        privates.put(soldier.getId(), soldier);
                        System.out.println(soldier.toString());
                        break;

                    case "LeutenantGeneral":
                        LieutenantGeneralImpl general = new LieutenantGeneralImpl(Integer.parseInt(data[1]), data[2], data[3], Double.parseDouble(data[4]));
                        for (int i = 5; i < data.length ; i++) {
                            general.addPrivate(privates.get(Integer.parseInt(data[i])));
                        }

                        System.out.println(general.toString());
                        break;

                    case "Engineer":
                        try{
                            EngineerImpl engineer = new EngineerImpl(Integer.parseInt(data[1]),
                                    data[2],
                                    data[3],
                                    Double.parseDouble(data[4]),
                                    Corps.valueOf(data[5])
                            );

                            for (int i = 6; i < data.length; i+=2) {
                                RepairImpl repair = new RepairImpl(data[i],data[i + 1]);
                                engineer.addRepair(repair);
                            }

                            System.out.println(engineer.toString());
                            break;
                        } catch (IllegalArgumentException ex){
                            continue;
                        }





                    case "Commando":
                        try {
                            CommandoImpl commando = new CommandoImpl(Integer.parseInt(data[1]),
                                    data[2],
                                    data[3],
                                    Double.parseDouble(data[4]),
                                    Corps.valueOf(data[5])
                            );
                            for (int i = 6; i < data.length; i+=2) {
                                if (!data[i + 1].equals("Finished") && !data[i + 1].equals("inProgress")){
                                    continue;
                                }
                                MissionImpl mission = new MissionImpl(data[i], MissionState.valueOf(data[i + 1]));
                                commando.addMission(mission);
                            }

                            System.out.println(commando.toString());
                            break;
                        }catch (IllegalArgumentException ex){
                            continue;
                        }


                    case "Spy":
                        SpyImpl spy = new SpyImpl(Integer.parseInt(data[1]), data[2], data[3], data[4]);

                        System.out.println(spy.toString());
                        break;
                }
            }
    }
}

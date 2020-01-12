package InterfacesAndAbstraction.army;

import InterfacesAndAbstraction.army.Enums.Corps;
import InterfacesAndAbstraction.army.HelperClasses.Interfaces.Mission;
import InterfacesAndAbstraction.army.Interfaces.Commando;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CommandoImpl extends SpecialisedSoldierImpl implements Commando {
    private List<Mission> missions;

    public CommandoImpl(int id, String firstName, String secondName, double salary, Corps corps) throws IllegalArgumentException {
        super(id, firstName, secondName, salary, corps);
        this.missions = new ArrayList<>();
    }

    @Override
    public void addMission(Mission mission) {
        this.missions.add(mission);
    }

    @Override
    public Collection<Mission> getMissions() {
        return this.getMissions();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append(System.lineSeparator())
                .append("Missions:")
                .append(System.lineSeparator());
        if (!missions.isEmpty()){
            for (Mission mission : missions) {
                if (mission.getState().equals("inProgress")){
                    sb.append("  ")
                            .append(mission.toString())
                            .append(System.lineSeparator());
                }

            }
        }


        return sb.toString().trim();
    }
}

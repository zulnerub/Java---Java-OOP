package InterfacesAndAbstraction.army.HelperClasses;

import InterfacesAndAbstraction.army.Enums.MissionState;
import InterfacesAndAbstraction.army.HelperClasses.Interfaces.Mission;


public class MissionImpl implements Mission {
    private String name;
    private MissionState state;

    public MissionImpl(String name, MissionState state) {
        this.name = name;
        this.state = state;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getState() {
        return this.state.name();
    }


    @Override
    public void completeMission() {
        this.state = MissionState.Finished;
    }

    @Override
    public String toString() {
        return String.format("Code Name: %s State: %s", this.getName(), this.getState());
    }
}

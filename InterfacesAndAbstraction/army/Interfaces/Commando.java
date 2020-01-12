package InterfacesAndAbstraction.army.Interfaces;

import InterfacesAndAbstraction.army.HelperClasses.Interfaces.Mission;

import java.util.Collection;

public interface Commando {
    void addMission(Mission mission);
    Collection<Mission> getMissions();
}

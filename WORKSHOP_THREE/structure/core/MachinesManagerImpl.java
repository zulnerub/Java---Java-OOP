package WORKSHOP_THREE.structure.core;

import WORKSHOP_THREE.structure.core.interfaces.MachineFactory;
import WORKSHOP_THREE.structure.core.interfaces.PilotFactory;
import WORKSHOP_THREE.structure.core.interfaces.MachinesManager;

import WORKSHOP_THREE.structure.entities.interfaces.Machine;
import WORKSHOP_THREE.structure.entities.interfaces.Pilot;

import java.util.Map;

public class MachinesManagerImpl implements MachinesManager {

    public MachinesManagerImpl(PilotFactory pilotFactory, MachineFactory machineFactory, Map<String, Pilot> pilots, Map<String, Machine> machines) {
     //TODO: Implement me

    }


    @Override
    public String hirePilot(String name) {
        return null;
    }

    @Override
    public String manufactureTank(String name, double attackPoints, double defensePoints) {
        return null;
    }

    @Override
    public String manufactureFighter(String name, double attackPoints, double defensePoints) {
        return null;
    }

    @Override
    public String engageMachine(String selectedPilotName, String selectedMachineName) {
        return null;
    }

    @Override
    public String attackMachines(String attackingMachineName, String defendingMachineName) {
        return null;
    }

    @Override
    public String pilotReport(String pilotName) {
        return null;
    }

    @Override
    public String toggleFighterAggressiveMode(String fighterName) {
        return null;
    }

    @Override
    public String toggleTankDefenseMode(String tankName) {
        return null;
    }
}

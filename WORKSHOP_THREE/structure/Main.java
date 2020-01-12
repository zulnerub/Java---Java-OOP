package WORKSHOP_THREE.structure;

import WORKSHOP_THREE.structure.core.MachinesManagerImpl;

import WORKSHOP_THREE.structure.core.interfaces.MachineFactory;
import WORKSHOP_THREE.structure.core.interfaces.PilotFactory;
import WORKSHOP_THREE.structure.core.interfaces.MachinesManager;
import WORKSHOP_THREE.structure.entities.interfaces.Machine;
import WORKSHOP_THREE.structure.entities.interfaces.Pilot;


import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        PilotFactory pilotFactory = null; //TODO change null with your implementation
        MachineFactory machineFactory = null; //TODO change null with your implementation
        Map<String, Pilot> pilots = new LinkedHashMap<>();
        Map<String, Machine> machines = new LinkedHashMap<>();

        MachinesManager machinesManager = new MachinesManagerImpl(pilotFactory, machineFactory, pilots, machines);

    }
}

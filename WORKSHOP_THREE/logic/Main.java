package WORKSHOP_THREE.logic;

import WORKSHOP_THREE.logic.core.*;

import WORKSHOP_THREE.logic.core.interfaces.MachineFactory;
import WORKSHOP_THREE.logic.core.interfaces.PilotFactory;
import WORKSHOP_THREE.logic.core.interfaces.MachinesManager;
import WORKSHOP_THREE.logic.entities.interfaces.Machine;
import WORKSHOP_THREE.logic.entities.interfaces.Pilot;


import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        PilotFactory pilotFactory = new PilotFactoryImpl();
        MachineFactory machineFactory = new MachineFactoryImpl();
        Map<String, Pilot> pilots = new LinkedHashMap<>();
        Map<String, Machine> machines = new LinkedHashMap<>();

        InputReader inputReader = new InputReader();
        OutputWriter outputWriter = new OutputWriter();

        MachinesManager machinesManager =
                new MachinesManagerImpl(pilotFactory, machineFactory, pilots, machines);

        Engine engine = new Engine(machinesManager,inputReader, outputWriter);
        engine.run(inputReader, outputWriter);


    }
}

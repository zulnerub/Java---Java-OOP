package WORKSHOP_THREE.structure.entities;

import WORKSHOP_THREE.structure.entities.interfaces.Machine;
import WORKSHOP_THREE.structure.entities.interfaces.Pilot;

import java.util.ArrayList;
import java.util.List;

public class PilotImpl implements Pilot {
    private String name;
    private List<Machine> machines;

    public PilotImpl(String name) {
        this.setName(name);
        this.machines = new ArrayList<>();
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()){
            throw new IllegalArgumentException(" Pilot name cannot be null or empty string.");
        }
        this.name = name;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public void addMachine(Machine machine) {

    }

    @Override
    public List<Machine> getMachines() {
        return null;
    }

    @Override
    public String report() {
        return null;
    }
}

package WORKSHOP_THREE.logic.entities;

import WORKSHOP_THREE.logic.entities.interfaces.Machine;
import WORKSHOP_THREE.logic.entities.interfaces.Pilot;

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
        return this.name;
    }

    @Override
    public void addMachine(Machine machine) {
        if (machine == null){
            throw new NullPointerException("Null machine cannot be added to the pilot.");
        }
        this.machines.add(machine);
    }

    @Override
    public List<Machine> getMachines() {
        return this.getMachines();
    }

    @Override
    public String report() {
        return super.toString();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getName()).append(" - ").append(this.machines.size());
        if (this.machines.size() > 0){
            this.machines.forEach(m -> sb.append(m.toString()).append(System.lineSeparator()));
        }
        return sb.toString();
    }
}

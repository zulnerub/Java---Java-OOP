package WORKSHOP_THREE.structure.entities;

import WORKSHOP_THREE.structure.entities.interfaces.Machine;
import WORKSHOP_THREE.structure.entities.interfaces.Pilot;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class BaseMachine implements Machine {
    private String name;
    private Pilot pilot;
    private double attackPoints;
    private double defencePoints;
    private double healthPoints;
    private List<String> targets;

    public BaseMachine(String name, double attackPoints, double defencePoints, double healthPoints) {
        this.setName(name);
        this.setAttackPoints(attackPoints);
        this.setDefencePoints(defencePoints);
        this.setHealthPoints(healthPoints);
        List<String> targets = new ArrayList<>();
    }

    private void setAttackPoints(double attackPoints) {
        this.attackPoints = attackPoints;
    }

    private void setDefencePoints(double defencePoints) {
        this.defencePoints = defencePoints;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()){
            throw new IllegalArgumentException("Machine name cannot be null or empty.");
        }

        this.name = name;
    }

    @Override
    public Pilot getPilot() {
        return this.pilot;
    }

    @Override
    public void setPilot(Pilot pilot) {
        if (pilot == null){
            throw new NullPointerException("Pilot cannot be null.");
        }
        this.pilot = pilot;
    }

    @Override
    public double getHealthPoints() {
        return this.healthPoints;
    }

    @Override
    public void setHealthPoints(double healthPoints) {
        this.healthPoints = healthPoints;
    }

    @Override
    public double getAttackPoints() {
        return this.attackPoints;
    }

    @Override
    public double getDefensePoints() {
        return this.defencePoints;
    }

    @Override
    public List<String> getTargets() {
        return Collections.unmodifiableList(this.targets);
    }

    @Override
    public void attack(String target) {

    }
}

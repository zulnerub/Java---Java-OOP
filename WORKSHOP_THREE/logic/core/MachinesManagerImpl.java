package WORKSHOP_THREE.logic.core;

import WORKSHOP_THREE.logic.common.OutputMessages;
import WORKSHOP_THREE.logic.core.interfaces.MachineFactory;
import WORKSHOP_THREE.logic.core.interfaces.PilotFactory;
import WORKSHOP_THREE.logic.core.interfaces.MachinesManager;

import WORKSHOP_THREE.logic.entities.interfaces.Fighter;
import WORKSHOP_THREE.logic.entities.interfaces.Machine;
import WORKSHOP_THREE.logic.entities.interfaces.Pilot;
import WORKSHOP_THREE.logic.entities.interfaces.Tank;

import javax.print.attribute.standard.MediaSize;
import java.util.LinkedHashMap;
import java.util.Map;

public class MachinesManagerImpl implements MachinesManager {
    private PilotFactory pilotFactory;
    private MachineFactory machineFactory;
    private Map<String, Pilot> pilots;
    private Map<String, Machine> machines;

    public MachinesManagerImpl(PilotFactory pilotFactory,
                               MachineFactory machineFactory,
                               Map<String, Pilot> pilots,
                               Map<String, Machine> machines) {

        this.pilotFactory = pilotFactory;
        this.machineFactory = machineFactory;
        this.machines = machines;
        this.pilots = pilots;
    }


    @Override
    public String hirePilot(String name) {
        Pilot pilot = null;
        if (this.pilots.containsKey(name)){
            throw new IllegalArgumentException(String.format(OutputMessages.pilotExists, name));
        }
        pilot = this.pilotFactory.createPilot(name);
        this.pilots.put(pilot.getName(), pilot);
        return String.format(OutputMessages.pilotHired, pilot.getName());
    }

    @Override
    public String manufactureTank(String name, double attackPoints, double defensePoints) {
        Tank tank = null;
        if (!this.machines.containsKey(name)){
            tank = this.machineFactory.createTank(name,attackPoints, defensePoints);
            this.machines.put(tank.getName(), tank);
        }else{
            throw new IllegalArgumentException(String.format(OutputMessages.machineExists, name));
        }

        return String.format(OutputMessages.tankManufactured, tank.getName(), tank.getAttackPoints(), tank.getDefensePoints());
    }

    @Override
    public String manufactureFighter(String name, double attackPoints, double defensePoints) {
        Fighter fighter = null;
        if (!this.machines.containsKey(name)){
            fighter = this.machineFactory.createFighter(name, attackPoints, defensePoints);
            this.machines.put(fighter.getName(), fighter);
        }else{
            throw new IllegalArgumentException(String.format(OutputMessages.machineExists, name));
        }


        return String.format(OutputMessages.fighterManufactured, fighter.getName(), fighter.getAttackPoints(), fighter.getDefensePoints());
    }

    @Override
    public String engageMachine(String selectedPilotName, String selectedMachineName) {
        Pilot pilot = this.pilots.values().stream()
                .filter(p -> p.getName().equals(selectedPilotName))
                .findFirst()
                .orElse(null);

        if (pilot == null){
            throw new NullPointerException(String.format(OutputMessages.pilotNotFound, selectedPilotName));
        }

        Machine machine = this.machines.values().stream()
                .filter(m -> m.getName().equals(selectedMachineName))
                .findFirst()
                .orElse(null);

        if (machine == null){
            throw new IllegalArgumentException(String.format(OutputMessages.machineNotFound, selectedMachineName));
        }

        if (machine.getPilot() != null){
            throw new IllegalArgumentException(String.format(OutputMessages.machineHasPilotAlready, machine.getName()));
        }
        machine.setPilot(pilot);
        pilot.addMachine(machine);


        return String.format(OutputMessages.machineEngaged, pilot.getName(), machine.getName());
    }

    @Override
    public String attackMachines(String attackingMachineName, String defendingMachineName) {
        Machine firstMachine = this.getMachine(attackingMachineName);
        if (firstMachine == null){
            throw new IllegalArgumentException(String.format(OutputMessages.machineNotFound, attackingMachineName));
        }

        firstMachine.attack(defendingMachineName);

        Machine secondMachine = this.getMachine(defendingMachineName);

        if (firstMachine.getAttackPoints() > secondMachine.getDefensePoints()){
            if (secondMachine.getHealthPoints() - firstMachine.getAttackPoints() < 0){
                secondMachine.setHealthPoints(0);
            }else{
                secondMachine.setHealthPoints(secondMachine.getHealthPoints() - firstMachine.getAttackPoints());
            }
        }

        return String.format(OutputMessages.attackSuccessful, secondMachine.getName(), firstMachine.getName(), secondMachine.getHealthPoints());
    }

    @Override
    public String pilotReport(String pilotName) {
        Pilot pilot = this.pilots.values().stream()
                .filter(p -> p.getName().equals(pilotName))
                .findFirst()
                .orElse(null);
        if (pilot == null){
            throw new NullPointerException(String.format(OutputMessages.pilotNotFound, pilotName));
        }

        return pilot.report();

    }

    @Override
    public String toggleFighterAggressiveMode(String fighterName) {
        if (this.machines.containsKey(fighterName)){
            if (this.machines.get(fighterName) instanceof Fighter){
                Fighter fighter = (Fighter) this.machines.get(fighterName);
                fighter.toggleAggressiveMode();
            }else{
                throw new UnsupportedOperationException(String.format(OutputMessages.notSupportedOperation, fighterName));
            }        }
        return String.format(OutputMessages.fighterOperationSuccessful, fighterName);
    }

    @Override
    public String toggleTankDefenseMode(String tankName) {
        if (this.machines.containsKey(tankName)){
            if (this.machines.get(tankName) instanceof Tank){
                Tank tank = (Tank) this.machines.get(tankName);
                tank.toggleDefenseMode();
            }else {
                throw new UnsupportedOperationException(String.format(OutputMessages.notSupportedOperation, tankName));
            }

        }
        return String.format(OutputMessages.tankOperationSuccessful, tankName);
    }

    private Pilot getPilot(String name){
        return this.pilots.values().stream()
                .filter(p -> p.getName().equals(name))
                .findFirst()
                .orElse(null);
    }


    private Machine getMachine(String name){
        return this.machines.values().stream()
                .filter(m -> m.getName().equals(name))
                .findFirst()
                .orElse(null);
    }
}

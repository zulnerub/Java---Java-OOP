package WORKSHOP_THREE.logic.core;

import WORKSHOP_THREE.logic.core.interfaces.MachinesManager;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Engine {
    private static final String END_PROGRAM_COMMAND = "Over";
    private MachinesManager machinesManager;
    private InputReader inputReader;
    private OutputWriter outputWriter;

    public Engine(MachinesManager machinesManager, InputReader inputReader, OutputWriter outputWriter) {
        this.machinesManager = machinesManager;
        this.inputReader = inputReader;
        this.outputWriter = outputWriter;
    }

    public void run(InputReader inputReader, OutputWriter outputWriter) throws IOException {
        String input = this.inputReader.line();

        while (!input.equals(END_PROGRAM_COMMAND)) {
            List<String> commandArgs = Arrays.asList(input.split("\\s+"));

            String commandName = commandArgs.get(0);

            try {
                String output = this.handleCommand(commandName, commandArgs);
                this.outputWriter.writeLine(output);
            }catch (IllegalArgumentException | NullPointerException ex){
                this.outputWriter.writeLine(ex.getMessage());
            }


            input = this.inputReader.line();
        }
    }

    private String handleCommand(String commandName, List<String> arguments) {
        String output = "";

        switch (commandName){
            case "Hire":
                output = this.machinesManager.hirePilot(arguments.get(1));
                break;
            case "ManufactureTank":
                output = this.machinesManager.manufactureTank(arguments.get(1),
                        Double.parseDouble(arguments.get(2)),
                        Double.parseDouble(arguments.get(3)));
                break;
            case "ManufactureFighter":
                output = this.machinesManager.manufactureFighter(arguments.get(1),
                        Double.parseDouble(arguments.get(2)),
                        Double.parseDouble(arguments.get(3)));
                break;
            case "Engage":
                output = this.machinesManager.engageMachine(arguments.get(1), arguments.get(2));
                break;
            case "Attack":
                output = this.machinesManager.attackMachines(arguments.get(1), arguments.get(2));
                break;
            case "DefensiveMode":
                output = this.machinesManager.toggleTankDefenseMode(arguments.get(1));
                break;
            case "AggressiveMode":
                output = this.machinesManager.toggleFighterAggressiveMode(arguments.get(1));
                break;
            case "Report":
                output = this.machinesManager.pilotReport(arguments.get(1));
                break;
        }
        return output;

    }


}

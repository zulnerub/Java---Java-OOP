package WORKSHOP_THREE.structure.entities.interfaces;
import java.util.List;

public interface Pilot {

    String getName();

    void addMachine(Machine machine);

    List<Machine> getMachines();

    String report();

}

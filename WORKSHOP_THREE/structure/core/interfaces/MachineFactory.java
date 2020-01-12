package WORKSHOP_THREE.structure.core.interfaces;

import WORKSHOP_THREE.structure.entities.interfaces.Fighter;
import WORKSHOP_THREE.structure.entities.interfaces.Tank;

public interface MachineFactory {
    Tank createTank(String name, double attackPoints, double defensePoints);

    Fighter createFighter(String name, double attackPoints, double defensePoints);
}

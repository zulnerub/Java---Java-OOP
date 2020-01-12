package WORKSHOP_THREE.logic.core.interfaces;

import WORKSHOP_THREE.logic.entities.interfaces.Fighter;
import WORKSHOP_THREE.logic.entities.interfaces.Tank;

public interface MachineFactory {
    Tank createTank(String name, double attackPoints, double defensePoints);

    Fighter createFighter(String name, double attackPoints, double defensePoints);
}

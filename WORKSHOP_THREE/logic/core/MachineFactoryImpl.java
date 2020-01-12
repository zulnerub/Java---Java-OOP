package WORKSHOP_THREE.logic.core;

import WORKSHOP_THREE.logic.core.interfaces.MachineFactory;
import WORKSHOP_THREE.logic.entities.FighterImpl;
import WORKSHOP_THREE.logic.entities.TankImpl;
import WORKSHOP_THREE.logic.entities.interfaces.Fighter;
import WORKSHOP_THREE.logic.entities.interfaces.Tank;

public class MachineFactoryImpl implements MachineFactory {


    @Override
    public Tank createTank(String name, double attackPoints, double defensePoints) {
        return new TankImpl(name, attackPoints, defensePoints);
    }

    @Override
    public Fighter createFighter(String name, double attackPoints, double defensePoints) {
        return new FighterImpl(name, attackPoints, defensePoints);
    }
}

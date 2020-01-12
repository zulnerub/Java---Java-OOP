package WORKSHOP_THREE.structure.entities;

import WORKSHOP_THREE.structure.entities.interfaces.Tank;

public class TankImpl extends BaseMachine implements Tank {
    private static final double TANK_HEALTH_POINTS = 100.0;
    private boolean defenceMode;
    private static final double TANK_DEFFENCE_POINTS_MODIFFIER = 30.0;
    private static final double TANK_ATTACK_POINTS_MODIFFIER = 40.0;


    public TankImpl(String name, double attackPoints, double defencePoints) {
        super(name, attackPoints, defencePoints, TANK_HEALTH_POINTS);
    }

    @Override
    public boolean getDefenseMode() {
        return this.defenceMode;
    }

    @Override
    public void toggleDefenseMode() {

    }
}

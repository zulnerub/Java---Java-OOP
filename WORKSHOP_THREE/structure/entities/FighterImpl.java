package WORKSHOP_THREE.structure.entities;

import WORKSHOP_THREE.structure.entities.interfaces.Fighter;

public class FighterImpl extends BaseMachine implements Fighter {
    private static final double FIGHTER_HEALTH_POINTS = 200.0;
    private boolean agressiveMode;
    private static final double FIGHTER_ATTACK_PPOINTS_MODIFFIER = 50.0;
    private static final double FIGHTER_DEFFENCE_POINTS_MODIFFIER = 25.0;


    public FighterImpl(String name, double attackPoints, double defencePoints) {
        super(name, attackPoints, defencePoints, FIGHTER_HEALTH_POINTS);
        this.agressiveMode = true;
    }

    @Override
    public boolean getAggressiveMode() {
        return this.agressiveMode;
    }

    @Override
    public void toggleAggressiveMode() {

    }
}

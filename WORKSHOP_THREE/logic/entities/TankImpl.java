package WORKSHOP_THREE.logic.entities;

import WORKSHOP_THREE.logic.entities.interfaces.Tank;

public class TankImpl extends BaseMachine implements Tank {
    private static final double TANK_HEALTH_POINTS = 100.0;
    private boolean defenceMode;
    private static final double TANK_DEFENCE_POINTS_MODIFIER = 30.0;
    private static final double TANK_ATTACK_POINTS_MODIFIER = 40.0;


    public TankImpl(String name, double attackPoints, double defencePoints) {
        super(name, attackPoints, defencePoints, TANK_HEALTH_POINTS);
        this.defenceMode = true;
    }

    @Override
    protected void setAttackPoints(double attackPoints) {
        super.setAttackPoints(attackPoints);
    }

    private void calculateAttackDef(){
        if (this.defenceMode){
            this.setAttackPoints(this.getAttackPoints() - TANK_ATTACK_POINTS_MODIFIER);
            this.setDefencePoints(this.getDefensePoints() + TANK_DEFENCE_POINTS_MODIFIER);
        }else{
            this.setAttackPoints(this.getAttackPoints() + TANK_ATTACK_POINTS_MODIFIER);
            this.setDefencePoints(this.getDefensePoints() - TANK_DEFENCE_POINTS_MODIFIER);
        }
    }

    @Override
    protected void setDefencePoints(double defencePoints) {
        super.setDefencePoints(defencePoints);
    }

    @Override
    public boolean getDefenseMode() {
        return this.defenceMode;
    }

    @Override
    public void toggleDefenseMode() {
        this.defenceMode = !this.getDefenseMode();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("- ").append(this.getName()).append(System.lineSeparator());
        sb.replace(8, 9, "Tank");
        sb.append(System.lineSeparator());
        sb.append(String.format(" *Aggressive Mode %s", this.getDefenseMode() ? "ON" : "OFF"));
        return sb.toString();
    }
}

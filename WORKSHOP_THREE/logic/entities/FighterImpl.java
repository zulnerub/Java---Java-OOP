package WORKSHOP_THREE.logic.entities;

import WORKSHOP_THREE.logic.entities.interfaces.Fighter;

public class FighterImpl extends BaseMachine implements Fighter {
    private static final double FIGHTER_HEALTH_POINTS = 200.0;
    private boolean aggressiveMode;
    private static final double FIGHTER_ATTACK_POINTS_MODIFIER = 50.0;
    private static final double FIGHTER_DEFENCE_POINTS_MODIFIER = 25.0;


    public FighterImpl(String name, double attackPoints, double defencePoints) {
        super(name, attackPoints, defencePoints, FIGHTER_HEALTH_POINTS);
        this.aggressiveMode = true;
    }

    @Override
    public boolean getAggressiveMode() {
        return this.aggressiveMode;
    }

    @Override
    public void toggleAggressiveMode() {
        this.aggressiveMode = !this.getAggressiveMode();
    }

    @Override
    protected void setAttackPoints(double attackPoints) {
        super.setAttackPoints(attackPoints);
    }

    @Override
    protected void setDefencePoints(double defencePoints) {
        super.setDefencePoints(defencePoints);
    }

    private void calculateAttackDef(){
        if (this.aggressiveMode){
            this.setAttackPoints(this.getAttackPoints() + FIGHTER_ATTACK_POINTS_MODIFIER);
            this.setDefencePoints(this.getDefensePoints() - FIGHTER_DEFENCE_POINTS_MODIFIER);
        }else{
            this.setAttackPoints(this.getAttackPoints() - FIGHTER_ATTACK_POINTS_MODIFIER);
            this.setDefencePoints(this.getDefensePoints() + FIGHTER_DEFENCE_POINTS_MODIFIER);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("- ").append(this.getName()).append(System.lineSeparator());
        sb.replace(8, 9, "Fighter");
        sb.append(System.lineSeparator());
        sb.append(String.format(" *Aggressive Mode %s", this.getAggressiveMode() ? "ON" : "OFF"));

        return sb.toString();
    }
}

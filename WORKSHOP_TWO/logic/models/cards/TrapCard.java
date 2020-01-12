package WORKSHOP_TWO.logic.models.cards;

public class TrapCard extends BaseCard {
    private static final int TRAP_CARD_DEFAULT_DAMAGE_POINTS = 120;
    private static final int TRAP_CARD_DEFAULT_HEALTH_POINTS = 5;

    public TrapCard(String name) {
        super(name, TRAP_CARD_DEFAULT_DAMAGE_POINTS, TRAP_CARD_DEFAULT_HEALTH_POINTS);
    }
}

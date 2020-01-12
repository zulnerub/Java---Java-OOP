package WORKSHOP_TWO.logic.models.cards;

public class MagicCard extends BaseCard {
    private static final int MAGIC_CARD_DEFAULT_DAMAGE_POINTS = 5;
    private static final int MAGIC_CARD_DEFAULT_HEALTH_POINTS = 80;

    public MagicCard(String name) {
        super(name, MAGIC_CARD_DEFAULT_DAMAGE_POINTS, MAGIC_CARD_DEFAULT_HEALTH_POINTS );
    }
}

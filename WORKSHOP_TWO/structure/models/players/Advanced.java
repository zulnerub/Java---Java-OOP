package WORKSHOP_TWO.structure.models.players;

import WORKSHOP_TWO.structure.repositories.interfaces.CardRepository;

public class Advanced extends BasePlayer {
    private static final int DEFAULT_HEALTH_POINTS_ADVANCED = 250;

    public Advanced(String userName, CardRepository cardRepository) {
        super(userName, DEFAULT_HEALTH_POINTS_ADVANCED, cardRepository);
    }
}

package WORKSHOP_TWO.logic.models.players;

import WORKSHOP_TWO.logic.repositories.interfaces.CardRepository;

public class Beginner extends BasePlayer {
    private static final int DEFAULT_HEALTH_POINTS_BEGINNER = 50;

    public Beginner(String userName, CardRepository cardRepository) {
        super(userName, DEFAULT_HEALTH_POINTS_BEGINNER, cardRepository);
    }
}

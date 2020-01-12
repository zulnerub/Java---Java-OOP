package WORKSHOP_TWO.structure.models.players;

import WORKSHOP_TWO.structure.repositories.interfaces.CardRepository;

public class Beginner extends BasePlayer {
    private static final int DEFAULT_HEALTH_POINTS_BEGINNER = 50;

    public Beginner(String userName, CardRepository cardRepository) {
        super(userName, DEFAULT_HEALTH_POINTS_BEGINNER, cardRepository);
    }
}

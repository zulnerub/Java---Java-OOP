package WORKSHOP_TWO.logic.models.players;

import WORKSHOP_TWO.logic.models.players.interfaces.Player;
import WORKSHOP_TWO.logic.repositories.interfaces.CardRepository;

public abstract class BasePlayer implements Player {
    private String userName;
    private int health;
    private CardRepository cardRepository;

    BasePlayer(String username, int health, CardRepository cardRepository) {
        this.setUserName(username);
        this.setHealth(health);
        this.setCardRepository(cardRepository);
    }


    private void setCardRepository(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    private void setUserName(String userName) {
        if (userName == null || userName.trim().isEmpty()){
            throw new IllegalArgumentException("Players's username cannot be null or an empty string.");
        }
        this.userName = userName;
    }

    @Override
    public CardRepository getCardRepository() {
        return this.cardRepository;
    }

    @Override
    public String getUsername() {
        return this.userName;
    }

    @Override
    public int getHealth() {
        return this.health;
    }

    @Override
    public void setHealth(int healthPoints) {
        if (healthPoints < 0){
            throw new IllegalArgumentException("Player's health bonus cannot be less than zero.");
        }
        this.health = healthPoints;
    }

    @Override
    public boolean isDead() {
        return this.getHealth() == 0;
    }

    @Override
    public void takeDamage(int damagePoints) {
        if (damagePoints < 0){
            throw new IllegalArgumentException("Damage points cannot be less than zero.");
        }

        int healthNew = this.health - damagePoints;

        if (healthNew < 0){
            healthNew = 0;
        }

        this.setHealth(healthNew);
    }
}

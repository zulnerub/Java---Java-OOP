package WORKSHOP_TWO.logic.models.battleFields;

import WORKSHOP_TWO.logic.models.battleFields.interfaces.Battlefield;
import WORKSHOP_TWO.logic.models.cards.interfaces.Card;
import WORKSHOP_TWO.logic.models.players.interfaces.Player;

public class BattleFieldImpl implements Battlefield {


    @Override
    public void fight(Player attackPlayer, Player enemyPlayer) {
        if (attackPlayer.isDead() || enemyPlayer.isDead()){
            throw new IllegalArgumentException("Player is dead!");
        }

        addToHealth(attackPlayer);
        addToHealth(enemyPlayer);

        int attackerDPA = getDPA(attackPlayer);
        int enemyDPA = getDPA(enemyPlayer);

        while (!attackPlayer.isDead() && !enemyPlayer.isDead()){
            enemyPlayer.takeDamage(attackerDPA);
            if (enemyPlayer.isDead()){
                break;
            }
            attackPlayer.takeDamage(enemyDPA);
        }
    }

    private void addToHealth(Player player){
        if (player.getClass().getSimpleName().equals("Beginner")){
            player.setHealth(player.getHealth() + 40);
            player
                    .getCardRepository()
                    .getCards()
                    .forEach(c -> c.setDamagePoints(c.getDamagePoints() + 30));
        }
        player.getCardRepository()
                .getCards()
                .forEach(c -> player.setHealth(player.getHealth()
                        + c.getHealthPoints()));
    }

    private int getDPA(Player player){
        return player.getCardRepository().getCards().stream()
                .mapToInt(Card::getDamagePoints)
                .sum();
    }
}

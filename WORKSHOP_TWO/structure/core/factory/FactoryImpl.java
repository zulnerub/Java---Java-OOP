package WORKSHOP_TWO.structure.core.factory;

import WORKSHOP_TWO.structure.models.cards.MagicCard;
import WORKSHOP_TWO.structure.models.cards.TrapCard;
import WORKSHOP_TWO.structure.models.cards.interfaces.Card;
import WORKSHOP_TWO.structure.models.players.Advanced;
import WORKSHOP_TWO.structure.models.players.Beginner;
import WORKSHOP_TWO.structure.models.players.interfaces.Player;
import WORKSHOP_TWO.structure.repositories.CardRepositoryImpl;

public class FactoryImpl implements Factory {
    @Override
    public Player createPlayer(String type, String username) {
        Player player = null;
        if (type.equals("Beginner")) {
            player = new Beginner(username, new CardRepositoryImpl());
        } else if (type.equals("Advanced")){
            player = new Advanced(username, new CardRepositoryImpl());
        }
        return player;
    }

    @Override
    public Card createCard(String type, String name) {
        Card card = null;
        if (type.equals("Trap")) {
            card = new TrapCard(name);
        } else if (type.equals("Magic")){
            card = new MagicCard(name);
        }
        return card;
    }
}

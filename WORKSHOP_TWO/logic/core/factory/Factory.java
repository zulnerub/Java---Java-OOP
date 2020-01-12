package WORKSHOP_TWO.logic.core.factory;

import WORKSHOP_TWO.logic.models.cards.interfaces.Card;
import WORKSHOP_TWO.logic.models.players.interfaces.Player;

public interface Factory {
    Player createPlayer(String type, String username);

    Card createCard(String type, String username);
}

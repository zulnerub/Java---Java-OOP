package WORKSHOP_TWO.structure.core.factory;

import WORKSHOP_TWO.structure.models.cards.interfaces.Card;
import WORKSHOP_TWO.structure.models.players.interfaces.Player;

public interface Factory {
    Player createPlayer(String type, String username);

    Card createCard(String type, String username);
}

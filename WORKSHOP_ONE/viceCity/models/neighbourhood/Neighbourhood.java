package WORKSHOP_ONE.viceCity.models.neighbourhood;

import WORKSHOP_ONE.viceCity.models.players.Player;

import java.util.Collection;

public interface Neighbourhood {
    void action(Player mainPlayer, Collection<Player> civilPlayers);
}

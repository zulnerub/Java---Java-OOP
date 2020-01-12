package WORKSHOP_ONE.viceCitySecondPart.models.neighbourhood;

import WORKSHOP_ONE.viceCitySecondPart.models.players.Player;

import java.util.Collection;

public interface Neighbourhood {
    void action(Player mainPlayer, Collection<Player> civilPlayers);
}

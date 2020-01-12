package WORKSHOP_TWO.structure.repositories.interfaces;

import WORKSHOP_TWO.structure.models.players.interfaces.Player;

import java.util.List;

public interface PlayerRepository {
    int getCount();

    List<Player> getPlayers();

    void add(Player player);

    boolean remove(Player player);

    Player find(String name);
}

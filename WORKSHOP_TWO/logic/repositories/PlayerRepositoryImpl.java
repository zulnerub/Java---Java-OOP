package WORKSHOP_TWO.logic.repositories;

import WORKSHOP_TWO.logic.models.players.interfaces.Player;
import WORKSHOP_TWO.logic.repositories.interfaces.PlayerRepository;

import java.util.ArrayList;
import java.util.List;

public class PlayerRepositoryImpl implements PlayerRepository {
    private List<Player> players;

    public PlayerRepositoryImpl() {
        this.players = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return this.players.size();
    }

    @Override
    public List<Player> getPlayers() {
        return this.players;
    }

    @Override
    public void add(Player player) {
        if (player == null){
            throw new IllegalArgumentException("Player cannot be null");
        }

        if (this.players.contains(player)){
            throw new IllegalArgumentException(String.format("Player %s already exists!", player.getUsername()));
        }

        this.players.add(player);
    }

    @Override
    public boolean remove(Player player) {
        if (player == null){
            throw new IllegalArgumentException("Player cannot be null");
        }

        if (this.players.contains(player)){
            this.players.remove(player);
            return true;
        }
        return false;

    }

    @Override
    public Player find(String name) {
        if (name == null || name.trim().isEmpty()){
            throw new IllegalArgumentException("Player's username cannot be null or an empty string.");
        }
        return this.getPlayers().stream().filter(player -> player.getUsername().equals(name))
                .findFirst().orElse(null);

    }
}

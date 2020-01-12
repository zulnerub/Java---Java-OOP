package Encapsulation.footballTeam;


import java.util.ArrayList;
import java.util.List;

public class Team {
    private String name;
    private List<Player> players;
    private double totalRating = 0;

    public Team(String name) {
        this.setName(name);
        this.players = new ArrayList<>();
    }

    private String getName() {
        return this.name;
    }

    public void setName(String name) {
        if (name.trim().isEmpty()){
            throw new IllegalArgumentException("A name should not be empty.");
        }
        this.name = name;
    }

    public void addPlayer(Player player){
        this.players.add(player);
    }

    public void removePlayer(String player){

        if (!this.players.removeIf(p -> p.getName().equals(player))){
            throw new IllegalArgumentException("Player " + player + " is not in " + this.getName() + " team.");
        }
    }

    public double getRating(){

        this.players.forEach(p -> {
            totalRating += p.overallSkillLevel();
        });

         return totalRating /= this.players.size();
    }
}

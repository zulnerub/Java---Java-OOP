package WORKSHOP_ONE.viceCity.models.players;


public class CivilPlayer extends BasePlayer {

    private static final int CIVIL_PLAYER_LIFE_POINTS = 50;

    public CivilPlayer(String name) {
        super(name, CIVIL_PLAYER_LIFE_POINTS);
    }
}

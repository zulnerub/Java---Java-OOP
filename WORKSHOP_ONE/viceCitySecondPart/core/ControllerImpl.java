package WORKSHOP_ONE.viceCitySecondPart.core;

import WORKSHOP_ONE.viceCitySecondPart.common.ConstantMessages;
import WORKSHOP_ONE.viceCitySecondPart.core.interfaces.Controller;
import WORKSHOP_ONE.viceCitySecondPart.models.guns.Gun;
import WORKSHOP_ONE.viceCitySecondPart.models.guns.Pistol;
import WORKSHOP_ONE.viceCitySecondPart.models.guns.Rifle;
import WORKSHOP_ONE.viceCitySecondPart.models.neighbourhood.GangNeighbourhood;
import WORKSHOP_ONE.viceCitySecondPart.models.neighbourhood.Neighbourhood;
import WORKSHOP_ONE.viceCitySecondPart.models.players.CivilPlayer;
import WORKSHOP_ONE.viceCitySecondPart.models.players.MainPlayer;
import WORKSHOP_ONE.viceCitySecondPart.models.players.Player;


import java.util.*;

public class ControllerImpl implements Controller {
    private static final String MAIN_PLAYER_FAMILY_NAME = "Vercetti";
    private Player mainPlayer;
    private List<Player> players;
    private Deque<Gun> gunRepository;
    private Neighbourhood gangNeighbourhood;

    public ControllerImpl() {
        this.mainPlayer = new MainPlayer();
        this.players = new ArrayList<>();
        this.gunRepository = new ArrayDeque<>();
        this.gangNeighbourhood = new GangNeighbourhood();
    }

    @Override
    public String addPlayer(String name) {
        players.add(new CivilPlayer(name));
        return String.format(ConstantMessages.PLAYER_ADDED, name);
    }

    @Override
    public String addGun(String type, String name) {
        if (type.equals("Pistol")) {
            this.gunRepository.offer(new Pistol(name));
            return String.format(ConstantMessages.GUN_ADDED, name, type);
        } else if (type.equals("Rifle")) {
            this.gunRepository.offer(new Rifle(name));
            return String.format(ConstantMessages.GUN_ADDED, name, type);
        } else {
            return ConstantMessages.GUN_TYPE_INVALID;
        }
    }

    @Override
    public String addGunToPlayer(String name) {
        if (gunRepository.isEmpty()) {
            return ConstantMessages.GUN_QUEUE_IS_EMPTY;
        }
        Gun gun;
        if (name.equals(MAIN_PLAYER_FAMILY_NAME)){
            gun = this.gunRepository.poll();
            this.mainPlayer.getGunRepository().add(gun);
            return String.format(ConstantMessages.GUN_ADDED_TO_MAIN_PLAYER, gun.getName(), this.mainPlayer.getName());
        }

        Player player = null;
        for (Player civilPlayer : Collections.unmodifiableCollection(this.players)) {
            if (civilPlayer.getName().equals(name)){
                player = civilPlayer;
                break;
            }
        }

        if (player != null){
            gun = this.gunRepository.poll();
            player.getGunRepository().add(gun);
            return String.format(ConstantMessages.GUN_ADDED_TO_CIVIL_PLAYER, gun.getName(), name);
        }else{
            return ConstantMessages.CIVIL_PLAYER_DOES_NOT_EXIST;
        }
    }

    @Override
    public String fight() {
        int initialMainPlayerHP = this.mainPlayer.getLifePoints();
        int initialCiviliansHP = 0;
        for (Player currentPlayer : this.players) {
            initialCiviliansHP += currentPlayer.getLifePoints();
        }

        this.gangNeighbourhood.action(this.mainPlayer, Collections.unmodifiableCollection(this.players));

        int afterFightMainPlayerHP = this.mainPlayer.getLifePoints();
        int afterFightCivilPlayersHP = 0;

        for (Player afterFightPlayer : this.players) {
            afterFightCivilPlayersHP += afterFightPlayer.getLifePoints();
        }

        boolean noFightOccurred = initialMainPlayerHP == afterFightMainPlayerHP &&
                initialCiviliansHP == afterFightCivilPlayersHP;

        if (noFightOccurred){
            return ConstantMessages.FIGHT_HOT_HAPPENED;
        }else{
            int allCiviliansCount = this.players.size();
            this.players.removeIf(player -> !player.isAlive());
            int killedCivilians = allCiviliansCount - this.players.size();
            StringBuilder sb = new StringBuilder();
            sb.append(ConstantMessages.FIGHT_HAPPENED)
                    .append(System.lineSeparator())
                    .append(String.format(ConstantMessages.MAIN_PLAYER_LIVE_POINTS_MESSAGE, mainPlayer.getLifePoints()))
                    .append(System.lineSeparator())
                    .append(String.format(ConstantMessages.MAIN_PLAYER_KILLED_CIVIL_PLAYERS_MESSAGE, killedCivilians))
                    .append(System.lineSeparator())
                    .append(String.format(ConstantMessages.CIVIL_PLAYERS_LEFT_MESSAGE, this.players.size()));

            return sb.toString();
        }

    }
}

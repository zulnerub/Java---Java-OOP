package WORKSHOP_ONE.viceCity.models.neighbourhood;

import WORKSHOP_ONE.viceCity.models.guns.Gun;
import WORKSHOP_ONE.viceCity.models.players.Player;

import java.util.ArrayDeque;
import java.util.Collection;


public class GangNeighbourhood implements Neighbourhood {
    @Override
    public void action(Player mainPlayer, Collection<Player> civilPlayers) {
        this.mainPlayerAttacksNPCs(mainPlayer, civilPlayers);

        this.NPCsAttackMainPlayer(mainPlayer, civilPlayers);
    }

    private void mainPlayerAttacksNPCs(Player mainPlayer, Collection<Player> civilPlayers){
        for (Player civilPlayer: civilPlayers){
            this.shootEnemy(mainPlayer, civilPlayer);
        }
    }

    private void NPCsAttackMainPlayer(Player mainPlayer, Collection<Player> civilPlayers){
        for (Player civilPlayer: civilPlayers){
            if (!mainPlayer.isAlive()){
                break;
            }
            if (civilPlayer.isAlive()){
                this.shootEnemy(civilPlayer, mainPlayer);
            }
        }
    }


    private void shootEnemy(Player attacker, Player victim){
        ArrayDeque<Gun> guns = new ArrayDeque<>();
        attacker.getGunRepository().getModels().forEach(guns::offer);

        while (!guns.isEmpty() && victim.isAlive()){
            Gun currentGun = guns.poll();

            while (currentGun.canFire() && victim.isAlive()){
                int dmg = currentGun.fire();
                victim.takeLifePoints(dmg);
            }
        }
    }
}

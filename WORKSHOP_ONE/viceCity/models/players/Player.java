package WORKSHOP_ONE.viceCity.models.players;

import WORKSHOP_ONE.viceCity.models.guns.Gun;
import WORKSHOP_ONE.viceCity.repositories.interfaces.Repository;

public interface Player {
    String getName();

    int getLifePoints();

    boolean isAlive();

    Repository<Gun> getGunRepository();

    void takeLifePoints(int points);
}

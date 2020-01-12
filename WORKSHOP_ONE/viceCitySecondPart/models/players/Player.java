package WORKSHOP_ONE.viceCitySecondPart.models.players;

import WORKSHOP_ONE.viceCitySecondPart.models.guns.Gun;
import WORKSHOP_ONE.viceCitySecondPart.repositories.interfaces.Repository;

public interface Player {
    String getName();

    int getLifePoints();

    boolean isAlive();

    Repository<Gun> getGunRepository();

    void takeLifePoints(int points);
}

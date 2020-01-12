package WORKSHOP_ONE.viceCitySecondPart.models.players;


import WORKSHOP_ONE.viceCitySecondPart.common.ExceptionMessages;
import WORKSHOP_ONE.viceCitySecondPart.models.guns.Gun;
import WORKSHOP_ONE.viceCitySecondPart.repositories.interfaces.GunRepository;
import WORKSHOP_ONE.viceCitySecondPart.repositories.interfaces.Repository;


public abstract class BasePLayer implements Player {
    private String name;
    private int lifePoints;
    private Repository<Gun> gunRepository;

    protected BasePLayer(String name, int lifePoints) {
        this.setLifePoints(lifePoints);
        this.setName(name);
        this.gunRepository = new GunRepository();
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()){
            throw new NullPointerException(ExceptionMessages.PLAYER_NULL_USERNAME);
        }
        this.name = name;
    }

    private void setLifePoints(int lifePoints) {
        if (lifePoints < 0){
            throw new IllegalArgumentException(ExceptionMessages.PLAYER_LIFE_POINTS_LESS_THAN_ZERO);
        }
        this.lifePoints = lifePoints;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getLifePoints() {
        return this.lifePoints;
    }

    @Override
    public boolean isAlive() {
        return this.getLifePoints() > 0;
    }

    @Override
    public Repository<Gun> getGunRepository() {
        return this.gunRepository;
    }

    @Override
    public void takeLifePoints(int points) {
        int hpAfetDmg = this.getLifePoints() - points;
        if (hpAfetDmg < 0) {
            hpAfetDmg = 0;
        }
        this.setLifePoints(hpAfetDmg);
    }
}

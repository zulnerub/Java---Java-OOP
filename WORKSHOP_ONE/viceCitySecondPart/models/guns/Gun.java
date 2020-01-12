package WORKSHOP_ONE.viceCitySecondPart.models.guns;

public interface Gun {
    String getName();

    int getBulletsPerBarrel();

    boolean canFire();

    int getTotalBullets();

    int fire();
}

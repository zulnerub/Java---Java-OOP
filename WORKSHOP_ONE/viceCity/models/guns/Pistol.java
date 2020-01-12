package WORKSHOP_ONE.viceCity.models.guns;

public class Pistol extends BaseGun {
    private static final int PISTOL_BULLETS_PER_BARREL = 10;
    private static final int PISTOL_TOTAL_BULLETS = 100;
    private static final int BULLETS_FIRED_PER_SHOT = 1;


    public Pistol(String name) {
        super(name, PISTOL_BULLETS_PER_BARREL, PISTOL_TOTAL_BULLETS );
        super.setBulletsPerShot(BULLETS_FIRED_PER_SHOT);
    }
}

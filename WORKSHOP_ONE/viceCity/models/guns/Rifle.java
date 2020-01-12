package WORKSHOP_ONE.viceCity.models.guns;

public class Rifle extends BaseGun {
    private static final int RIFLE_BULLETS_PER_BARREL = 50;
    private static final int RIFLE_TOTAL_BULLETS = 500;
    private static final int RIFLE_BULLETS_PER_SHOT = 5;

    public Rifle(String name) {
        super(name, RIFLE_BULLETS_PER_BARREL, RIFLE_TOTAL_BULLETS);
        super.setBulletsPerShot(RIFLE_BULLETS_PER_SHOT);
    }


}

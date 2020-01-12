package Abstractions.jediGalaxy;

public class Player {
    private long stars;

    public Player(){
        this.stars = 0;
    }

    public void addStars(long starsToAdd) {
        this.stars += starsToAdd;
    }

    public long getStars(){
        return this.stars;
    }
}

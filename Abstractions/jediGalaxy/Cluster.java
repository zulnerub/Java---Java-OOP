package Abstractions.jediGalaxy;

public class Cluster {
    private Galaxy galaxy;

    public Cluster(Galaxy matrix) {
        this.galaxy = matrix;
    }


    public void moveEvilForce(int evilRow, int evilCol) {
        while (evilRow >= 0 && evilCol >= 0) {
            if (evilRow < galaxy.getRow() && evilCol < galaxy.getCol()) {
                galaxy.setStarValue(evilRow, evilCol, 0);
            }
            evilRow--;
            evilCol--;
        }
    }

    public long collectPlayerStars(int playerRow, int playerCol) {
        long sum = 0;
        while (playerRow >= 0 && playerCol < galaxy.getCol()) {
            if (playerRow < galaxy.getRow() && playerCol >= 0 && playerCol < galaxy.getCol()) {
                sum += galaxy.getStarValue(playerRow, playerCol);
            }

            playerCol++;
            playerRow--;
        }

        return sum;
    }
}

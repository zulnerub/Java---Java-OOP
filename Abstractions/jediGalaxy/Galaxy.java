package Abstractions.jediGalaxy;

public class Galaxy {
    private int row;
    private int col;
    private int[][] matrix;


    public Galaxy(int x, int y) {
        this.row = x;
        this.col = y;
        this.matrix = new int[x][y];
        this.fillMatrix();

    }


    private void fillMatrix() {
        int value = 0;
        for (int i = 0; i < this.row; i++) {
            for (int j = 0; j < this.col; j++) {
                matrix[i][j] = value++;
            }
        }

    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public void setStarValue(int row, int col, int newValue) {
        this.matrix[row][col] = newValue;
    }

    public long getStarValue(int playerRow, int playerCol) {
        return this.matrix[playerRow][playerCol];
    }
}

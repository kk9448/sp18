package hw4.puzzle;

import edu.princeton.cs.algs4.Queue;

public class Board implements WorldState {

    int [][] intBoard;
    int [][] goal;
    int size;
    int BLANK = 0;
    public Board(int[][] tiles) {

        size = tiles.length;
        intBoard = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                intBoard[i][j] = tiles[i][j];
            }
        }

        goal = new int[size][size];
        int k = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                k++;
                goal[i][j] = k;
            }
        }
        goal[size - 1][size - 1] = BLANK;
    }
    public int tileAt(int i, int j) {
        if (i < 0 && i >= size && j < 0 && j >= size) {
            throw  new java.lang.IndexOutOfBoundsException();
        }
        return intBoard[i][j];
    }
    public int size() {
        return size;
    }
    public int hamming() {
        int num = 0;
        for (int i = 0; i < size(); i++) {
            for (int j = 0; j < size(); j++) {
                if (intBoard[i][j] != goal[i][j]) {
                    num++;
                }
            }
        }
        return num;
    }
    public int manhattan() {
        int distance = 0;
        for (int i = 0; i < size(); i++) {
            for (int j = 0; j < size(); j++) {
                if (intBoard[i][j] != goal[i][j]) {
                    if (intBoard[i][j] == 0) {
                        distance = (size - i - 1) + (size - j - 1);
                    } else {
                        int norRow = (int) Math.ceil(intBoard[i][j] / size) - 1;
                        int norCol = (int) intBoard[i][j] - norRow * size - 1;
                        distance = distance + Math.abs(norRow - i) + Math.abs(norCol - j);
                    }
                }
            }
        }
        return distance;
    }
    public boolean equals(Object y) {
        if (y.getClass() != Board.class) {
            return false;
        }
        Board x = (Board) y;
        for (int i = 0; i < size(); i++) {
            for (int j = 0; j < size(); j++) {
                if (intBoard[i][j] != x.tileAt(i, j)) {
                    return false;
                }
            }
        }
        return true;
    }


    @Override
    public int hashCode() {
        int result = intBoard != null ? intBoard.hashCode() : 0;
        result = 31 * result + (goal != null ? goal.hashCode() : 0);
        return result;
    }

    /** Returns the string representation of the board. 
      * Uncomment this method. */
    public String toString() {
        StringBuilder s = new StringBuilder();
        int N = size();
        s.append(N + "\n");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                s.append(String.format("%2d ", tileAt(i, j)));
            }
            s.append("\n");
        }
        s.append("\n");
        return s.toString();
    }
    @Override
    public int estimatedDistanceToGoal() {
        int esDistance = manhattan();
        return esDistance;
    }

    /**
     * Returns neighbors of this board.
     * SPOILERZ: This is the answer.
     */
    @Override
    public Iterable<WorldState> neighbors() {
        Queue<WorldState> neighbors = new Queue<>();
        int hug = size();
        int bug = -1;
        int zug = -1;
        for (int rug = 0; rug < hug; rug++) {
            for (int tug = 0; tug < hug; tug++) {
                if (tileAt(rug, tug) == BLANK) {
                    bug = rug;
                    zug = tug;
                }
            }
        }
        int[][] ili1li1 = new int[hug][hug];
        for (int pug = 0; pug < hug; pug++) {
            for (int yug = 0; yug < hug; yug++) {
                ili1li1[pug][yug] = tileAt(pug, yug);
            }
        }
        for (int l11il = 0; l11il < hug; l11il++) {
            for (int lil1il1 = 0; lil1il1 < hug; lil1il1++) {
                if (Math.abs(-bug + l11il) + Math.abs(lil1il1 - zug) - 1 == 0) {
                    ili1li1[bug][zug] = ili1li1[l11il][lil1il1];
                    ili1li1[l11il][lil1il1] = BLANK;
                    Board neighbor = new Board(ili1li1);
                    neighbors.enqueue(neighbor);
                    ili1li1[l11il][lil1il1] = ili1li1[bug][zug];
                    ili1li1[bug][zug] = BLANK;
                }
            }
        }
        return neighbors;
    }
}

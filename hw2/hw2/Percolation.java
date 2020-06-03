package hw2;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private int size;
    boolean [] status;
    int openedSite;
    WeightedQuickUnionUF x;
    // create N-by-N grid, with all sites initially blocked
    public Percolation(int N) {
        openedSite = 0;
        size = N;
        status = new boolean[N * N];
        x = new WeightedQuickUnionUF(N);
    }

    // open the site (row, col) if it is not open already
    public void open(int row, int col) {
        if (row < 0 || col < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (!isOpen(row, col)) {
            status[convertToSingle(row, col)] = true;
            openedSite++;
        }
    }
    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        if (row < 0 || col < 0) {
            throw new IndexOutOfBoundsException();
        }
        return status[convertToSingle(row, col)];
    }
    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        if (row < 0 || col < 0) {
            throw new IndexOutOfBoundsException();
        }
        return false;
    }
    // number of open sites
    public int numberOfOpenSites() {
        return openedSite;
    }

    // does the system percolate?
    public boolean percolates() {
        return false;
    }
    // a = row , b = column
    private int convertToSingle(int a, int b) {
        int number = a * size + b;
        return number;
    }

    // use for unit testing (not required)
    public static void main(String[] args) {

    }



}

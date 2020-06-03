package hw2;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    // create N-by-N grid, with all sites initially blocked
    public Percolation(int N) {}

    // open the site (row, col) if it is not open already
    public void open(int row, int col) {
        if (row < 0 || col < 0) {
            throw new IndexOutOfBoundsException();
        }
    }
    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        return false;
    }
    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        return false;
    }
    // number of open sites
    public int numberOfOpenSites() {
        return 0;
    }

    // does the system percolate?
    public boolean percolates() {
        return false;
    }

    // use for unit testing (not required)
    public static void main(String[] args) {

    }



}

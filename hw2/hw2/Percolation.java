package hw2;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;


public class Percolation {
    private int size;
    private boolean [] status;
    private int openedSite;
    private WeightedQuickUnionUF x;
    private WeightedQuickUnionUF onlyTop;
    // create N-by-N grid, with all sites initially blocked
    public Percolation(int N) {
        openedSite = 0;
        size = N;
        status = new boolean[N * N];
        x = new WeightedQuickUnionUF(N * N + 2);
        onlyTop = new WeightedQuickUnionUF(N * N + 1);
    }

    // open the site (row, col) if it is not open already
    public void open(int row, int col) {
        if (row < 0 || col < 0) {
            throw new IndexOutOfBoundsException();
        }
        int singleNumber = convertToSingle(row, col);
        if (!isOpen(row, col)) {
            status[singleNumber] = true;
            openedSite++;
            connectAdjacent(row, col, singleNumber);
            if (row == 0) {
                x.union(singleNumber, size * size);
                onlyTop.union(singleNumber, size * size);
            }
            if (row == size - 1) {
                x.union(singleNumber, size * size + 1);
            }
        }


        System.out.println(x.find(singleNumber));

//        System.out.println(singleNumber);
//        boolean result = x.connected(4,5);
//        System.out.println("4,5" + result);
//        System.out.println("1,5" + x.connected(1,5));

    }
    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        if (row < 0 || col < 0) {
            throw new IndexOutOfBoundsException();
        }
        return status[convertToSingle(row, col)];
    }

    private void connectAdjacent(int row, int col, int singleNumber) {
        if (row - 1 >= 0) {
            if (isOpen(row - 1, col)) {
                int aroundItem = convertToSingle(row - 1, col);
                x.union(singleNumber, aroundItem);
                onlyTop.union(singleNumber, aroundItem);
            }
        }
        if (row + 1 < size) {
            if (isOpen(row + 1, col)) {
                int aroundItem = convertToSingle(row + 1, col);
                x.union(singleNumber, aroundItem);
                onlyTop.union(singleNumber, aroundItem);
            }
        }
        if (col - 1 >= 0) {
            if (isOpen(row, col - 1)) {
                int aroundItem = convertToSingle(row, col - 1);
                x.union(singleNumber, aroundItem);
                onlyTop.union(singleNumber, aroundItem);
            }
        }
        if (col + 1 < size) {
            if (isOpen(row, col + 1)) {
                int aroundItem = convertToSingle(row, col + 1);
                x.union(singleNumber, aroundItem);
                onlyTop.union(singleNumber, aroundItem);
            }
        }

    }
    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        if (row < 0 || col < 0) {
            throw new IndexOutOfBoundsException();
        }
        int singleNumber = convertToSingle(row, col);

        return onlyTop.connected(singleNumber, size * size);
    }

    // number of open sites
    public int numberOfOpenSites() {
        return openedSite;
    }

    // does the system percolate?
    public boolean percolates() {

        return x.connected(size * size, size * size + 1);

    }
    // a = row , b = column
    private int convertToSingle(int a, int b) {
        int number = a * size + b;
        return number;
    }

    // use for unit testing (not required)


}

package hw2;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private int size;
    private boolean [] status;
    private int openedSite;
    private WeightedQuickUnionUF x;
    // create N-by-N grid, with all sites initially blocked
    public Percolation(int N) {
        openedSite = 0;
        size = N;
        status = new boolean[N * N];
        x = new WeightedQuickUnionUF(N * N + 2);
//        for (int i = 0; i < N; i++) {
//            x.union(i, N * N);
//            x.union(N * N - 1 - i, N * N + 1);
//        }
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
            if (singleNumber < size) {
                x.union(singleNumber, size * size);
            }
            if ((singleNumber >= size * (size - 1))
                    && (singleNumber < size * size)) {
                if (!percolates()) {
                    x.union(singleNumber, size * size + 1);
                }
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
                x.union(singleNumber, singleNumber - size);
            }
        }
        if (row + 1 < size) {
            if (isOpen(row + 1, col)) {
                x.union(singleNumber, singleNumber + size);
            }
        }
        if (col - 1 >= 0) {
            if (isOpen(row, col - 1)) {
                x.union(singleNumber, singleNumber - 1);
            }
        }
        if (col + 1 < size) {
            if (isOpen(row, col + 1)) {
                x.union(singleNumber, singleNumber + 1);
            }
        }

    }
    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        if (row < 0 || col < 0) {
            throw new IndexOutOfBoundsException();
        }
        int singleNumber = convertToSingle(row, col);

        if (row == size - 1 && !x.connected(singleNumber, size * size)) {
            return false;
        }
//        if (x.find(singleNumber) == size * size + 1) {
//
//        }
        return x.connected(singleNumber, size * size);
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

package hw2;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.introcs.StdStats;

public class PercolationStats {
    private int size;
    private int T;
    private int[] save;
    private Percolation x;
    private PercolationFactory factory;

    public PercolationStats(int N, int T, PercolationFactory pf) {
        if (N <= 0 || T <= 0) {
            throw new IllegalArgumentException();
        }
        save = new int[T];
        size = N;
        this.T = T;
        factory = pf;
        saveToArray(T);


    }  // perform T independent experiments on an N-by-N grid
    private void saveToArray(int times) {
        for (int i = 0; i < times; i++) {
            save[i] = singleResult();
        }
    }


    private int singleResult() {
        int i;
        x = factory.make(size);
        for (i = 0; i < size * size; ) {
            int row = (int) Math.round((size - 1) * StdRandom.uniform());
            int col = (int) Math.round((size - 1) * StdRandom.uniform());
            if (!x.isOpen(row, col)) {
                x.open(row, col);
                if (x.percolates()) {
                    return i;
                }
                i++;
            }
        }
        return 0;

    }

    public double mean() {
        return StdStats.mean(save);
    }                                          // sample mean of percolation threshold
    public double stddev() {
        return StdStats.stddev(save);
    }                                        // sample standard deviation of percolation threshold
    public double confidenceLow() {
        return mean() - 1.96 * Math.sqrt(stddev()) / Math.sqrt(T);
    }                                 // low endpoint of 95% confidence interval
    public double confidenceHigh() {
        return mean() + 1.96 * Math.sqrt(stddev()) / Math.sqrt(T);
    }


}

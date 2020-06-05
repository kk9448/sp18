package hw2;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.introcs.StdStats;

public class PercolationStats {
    private int size;
    private int T;
    private double[] save;
    private Percolation x;
    private PercolationFactory factory;

    public PercolationStats(int N, int T, PercolationFactory pf) {
        if (N <= 0 || T <= 0) {
            throw new IllegalArgumentException();
        }
        save = new double[T];
        size = N;
        this.T = T;
        factory = pf;
        saveToArray(T);


    }  // perform T independent experiments on an N-by-N grid
    private void saveToArray(int times) {
        for (int i = 0; i < times; i++) {
            save[i] = singleResult() / (size * size);
        }
    }


    private int singleResult() {
        int i = 0;
        x = factory.make(size);
        while (!x.percolates()) {
            int row = (int) Math.round((size - 1) * StdRandom.uniform());
            int col = (int) Math.round((size - 1) * StdRandom.uniform());
            if (!x.isOpen(row, col)) {
                x.open(row, col);
                i++;
            }
        }
        return i;

    }

    public double mean() {
        return StdStats.mean(save);
    }                                          // sample mean of percolation threshold
    public double stddev() {
        return StdStats.stddev(save);
    }                                        // sample standard deviation of percolation threshold
    public double confidenceLow() {
        return mean() - 1.96 * stddev() / Math.sqrt(T);
    }                                 // low endpoint of 95% confidence interval
    public double confidenceHigh() {
        return mean() + 1.96 * stddev() / Math.sqrt(T);
    }

//    public static void main(String[] args){
//        PercolationFactory factory = new PercolationFactory();
//        Percolation x1 = factory.make(10);
//        System.out.println(factory);
//        PercolationStats x = new PercolationStats(10, 20, factory);
//    }


}

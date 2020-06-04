package hw2;

import edu.princeton.cs.algs4.StdRandom;

public class PercolationStats {

    public PercolationStats(int N, int T, PercolationFactory pf) {
        if (N <= 0 || T <= 0) {
            throw new IllegalArgumentException();
        }
        Percolation x = pf.make(N);


    }  // perform T independent experiments on an N-by-N grid
    public double mean() {
        return 0.0;
    }                                          // sample mean of percolation threshold
    public double stddev() {
        return 0.0;
    }                                        // sample standard deviation of percolation threshold
    public double confidenceLow() {
        return 0.0;
    }                                 // low endpoint of 95% confidence interval
    public double confidenceHigh() {
        return 0.0;
    }
    public static void main(String[] args) {
        System.out.println(StdRandom.uniform());
    }

}

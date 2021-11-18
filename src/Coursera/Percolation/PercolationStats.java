package Percolation;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {

    private final double mean;

    private static final double CONFIDENCE_95 = 1.96;

    private final double stddev;

    private final int trials;

    // perform independent trials on an n-by-n grid
    public PercolationStats(int n, int trials) {
        if (n <= 0 || trials <= 0) {
            throw new IllegalArgumentException();
        }
        double[] x = new double[trials];

        int[] blockSites = new int[n * n];

        for (int i = 0; i < n * n; i++) {
            blockSites[i] = i;
        }

        for (int i = 0; i < trials; i++) {
            StdRandom.shuffle(blockSites);
            Percolation percolation = new Percolation(n);
            for (int j = 0; j < n * n; j++) {
                percolation.open(blockSites[j] / n + 1, blockSites[j] % n + 1);
                if (percolation.percolates()) {
                    break;
                }
            }
            x[i] = (double) percolation.numberOfOpenSites() / (n * n);
        }
        mean = StdStats.mean(x);
        stddev = StdStats.stddev(x);
        this.trials = trials;
    }

    // sample mean of percolation threshold
    public double mean() {
        return mean;
    }

    // sample standard deviation of percolation threshold
    public double stddev() {
        return stddev;
    }

    // low endpoint of 95% confidence interval
    public double confidenceLo() {
        return mean - CONFIDENCE_95 * stddev / Math.sqrt(trials);
    }

    // high endpoint of 95% confidence interval
    public double confidenceHi() {
        return mean + CONFIDENCE_95 * stddev / Math.sqrt(trials);
    }

    public static void main(String[] args) {
        int n = 200;
        int t = 100;
        PercolationStats percolationStats = new PercolationStats(n, t);
        StdOut.printf("%s%f\n", "mean                    = ", percolationStats.mean());
        StdOut.printf("%s%f\n", "stddev                  = ", percolationStats.stddev());
        StdOut.printf("%s%f%s%f%s\n", "95% confidence interval = [", percolationStats.confidenceLo(), ", ", percolationStats.confidenceHi(), "]");
    }
}

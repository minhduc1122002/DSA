package Coursera.Percolation;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

    private boolean [][] sites;

    private final int size;

    private int sizeOpened;

    private final WeightedQuickUnionUF fullUF;

    private final WeightedQuickUnionUF percolateUF;

    public Percolation(int n) {
        sizeOpened = 0;
        size = n;
        fullUF = new WeightedQuickUnionUF(n * n + 1);
        percolateUF = new WeightedQuickUnionUF(n * n + 2);
        sites = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sites[i][j] = false;
            }
        }
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        if (isOpen(row, col)) {
            return;
        } else {
            sites[row - 1][col - 1] = true;
            sizeOpened++;
        }
        int current = code(row - 1, col - 1);

        if (row == 1) {
            fullUF.union(current, size * size);
            percolateUF.union(current, size * size);
        }
        if (row == size) {
            percolateUF.union(current, size * size + 1);
        }

        int[] dx = {-1, 0, 0, +1};
        int[] dy = {0, -1, +1, 0};

        for (int i = 0; i < 4; i++) {
            if (isOnSites(row + dx[i], col + dy[i]) && isOpen(row + dx[i], col + dy[i])){
                int neighbor = code(row - 1 + dx[i], col - 1 + dy[i]);
                if (fullUF.find(current) != fullUF.find(neighbor)) {
                    fullUF.union(current, neighbor);
                }
                if (percolateUF.find(current) != percolateUF.find(neighbor)) {
                    percolateUF.union(current, neighbor);
                }
            }
        }
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        checkOnSites(row, col);
        return sites[row -1][col - 1];
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        checkOnSites(row, col);
        if (isOpen(row, col) && fullUF.find(size * size)
                == fullUF.find(code(row - 1, col - 1))) {
            return true;
        }
        return false;
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        return sizeOpened;
    }

    // does the system percolateUF?
    public boolean percolates() {
        if (percolateUF.find(size * size) == percolateUF.find(size * size + 1)) {
            return true;
        }
        return false;
    }

    private boolean isOnSites(int row, int col) {
        return 1 <= row && row <= size && 1 <= col && col <= size;
    }
    private void checkOnSites(int row, int col) {
        if (!isOnSites(row, col)) {
            throw new IllegalArgumentException();
        }
    }

    private int code(int row, int col) {
        return col + row * size;
    }
}

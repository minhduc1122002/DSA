package Coursera.Puzzle;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private final int[][] board;

    // create board board from an n-by-n array of tiles,
    // where tiles[row][col] = tile at (row, col)

    public Board(int[][] tiles) {
        board = new int[tiles.length][tiles.length];
        for (int i = 0; i < tiles.length; i++) {
            System.arraycopy(tiles[i], 0, board[i], 0, tiles[0].length);
        }
    }

    private int[][] getBoard() {
        return board;
    }

    // string representation of this board
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(dimension()).append("\n");
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                s.append(String.format("%2d ", board[i][j]));
            }
            s.append("\n");
        }
        return s.toString();
    }

    // board dimension n
    public int dimension() {
        return board.length;
    }

    // number of tiles out of place
    public int hamming() {
        int hamming = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (((i != (board[i][j] - 1) / board.length) || (j != (board[i][j] - 1) % board.length)) && board[i][j] != 0) {
                    hamming++;
                }
            }
        }
        return hamming;
    }

    // sum of Manhattan distances between tiles and goal
    public int manhattan() {
        int manhattan = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] != 0) {
                    manhattan = manhattan + Math.abs(i - (board[i][j] - 1) / board.length) +
                            Math.abs(j - (board[i][j] - 1) % board.length);
                }
            }
        }
        return manhattan;
    }

    // is this board the goal board?
    public boolean isGoal() {
        if (hamming() == 0) {
            return true;
        }
        return false;
    }

    // does this board equal y?
    public boolean equals(Object y) {
        if (y == this) {
            return true;
        }
        if (y == null) {
            return false;
        }
        if (y.getClass() != this.getClass()) {
            return false;
        }

        Board that = (Board) y;
        int [][] temp = that.getBoard();
        if (this.dimension() != that.dimension()) {
            return false;
        } else {
            for (int i = 0; i < this.dimension(); i++) {
                for (int j = 0; j < this.dimension(); j++) {
                    if (temp[i][j] != board[i][j]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    // all neighboring boards
    public Iterable<Board> neighbors() {
        List<Board>mates = new ArrayList<Board>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == 0) {
                    if (i - 1 >= 0) {
                        int[][] temp = exchange(board, i, j, i - 1, j);
                        mates.add(new Board(temp));
                    }
                    if (i + 1 < board.length) {
                        int[][] temp = exchange(board, i, j, i + 1, j);
                        mates.add(new Board(temp));
                    }
                    if (j - 1 >= 0) {
                        int[][] temp = exchange(board, i, j, i, j - 1);
                        mates.add(new Board(temp));
                    }
                    if (j + 1 < board.length) {
                        int[][] temp = exchange(board, i, j, i, j + 1);
                        mates.add(new Board(temp));
                    }
                }
            }
        }
        return mates;
    }

    private int[][] exchange(int[][] a, int x1, int y1, int x2, int y2) {
        int[][] clone = new int[a.length][a.length];
        for (int i = 0; i < a.length; i++) {
            System.arraycopy(a[i], 0, clone[i], 0, a[0].length);
        }
        int temp = clone[x1][y1];
        clone[x1][y1] = clone[x2][y2];
        clone[x2][y2] = temp;
        return clone;
    }

    // board board that is obtained by exchanging any pair of tiles
    public Board twin() {
        int[][] clone = new int[board.length][board.length];
        for (int i = 0; i < board.length; i++) {
            System.arraycopy(board[i], 0, clone[i], 0, board[0].length);
        }
        if (board[0][0] == 0 || board[0][1] == 0) {
            clone = exchange(clone, 1, 1, 1, 0);
        } else {
            clone = exchange(clone, 0, 0, 0, 1);
        }
        return new Board(clone);
    }
}

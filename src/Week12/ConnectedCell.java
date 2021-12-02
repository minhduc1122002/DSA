package Week12;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Cell {
    public int r, c;
    public Cell(int i, int j) {
        r = i;
        c = j;
    }
}

public class ConnectedCell {

    public static int[][] grid;
    public static boolean[][] visited;
    public static int N, M;


    public static int count_connected(int row, int col) {
        int cnt = 0;
        Queue<Cell> queue = new LinkedList<>();
        queue.add(new Cell(row, col));
        visited[row][col] = true;
        while (!queue.isEmpty()) {
            int y = queue.peek().r;
            int x = queue.peek().c;
            queue.poll();
            cnt++;
            int[] dx = {-1, -1, -1, 0, 0, +1, +1, +1};
            int[] dy = {0, +1, -1, -1, +1, 0, -1, +1};
            for (int i = 0; i < 8; i++) {
                if ((x + dx[i] >= 0 && x + dx[i] < M) && (y + dy[i] >= 0 && y + dy[i] < N)
                    && !visited[y + dy[i]][x + dx[i]] && grid[y + dy[i]][x + dx[i]] == 1) {
                    queue.add(new Cell(y + dy[i], x + dx[i]));
                    visited[y + dy[i]][x + dx[i]] = true;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Week12.ShortestReach. */
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();
        grid = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < M; ++j) {
                grid[i][j] = scanner.nextInt();
                visited[i][j] = false;
            }
        }
        int max = count_connected(0, 1);
        /*for (int i = 0; i < N; ++i) {
            for (int j = 0; j < M; ++j) {
                if (grid[i][j] == 0 || visited[i][j]) continue;
                int cnt = count_connected(i, j);
                if (max < cnt) max = cnt;
            }
        }*/
        System.out.println(max);
    }
}

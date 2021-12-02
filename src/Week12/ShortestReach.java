package Week12;

import java.util.*;

public class ShortestReach {

    public static int[] findShortestReach(ArrayList<ArrayList<Integer>> graph, int start) {
        int[] costs = new int[graph.size()];
        boolean[] visited = new boolean[graph.size()];
        int UNIT_COST = 6;
        for (int i = 0; i < costs.length; ++i) {
            costs[i] = -1;
            visited[i] = false;
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        costs[start] = 0;
        while (!queue.isEmpty()) {
            int v = queue.poll();
            for (Integer w : graph.get(v)) {
                if (!visited[w]) {
                    queue.add(w);
                    visited[w] = true;
                    costs[w] = costs[v] + UNIT_COST;
                }
            }
        }
        return costs;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int Q = scanner.nextInt();
        for (int q = 0; q < Q; ++q) {
            int N, M, start;
            N = scanner.nextInt();
            M = scanner.nextInt();
            ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
            for (int i = 0; i <= N; ++i) {
                graph.add(new ArrayList<Integer>());
            }
            for (int i = 0; i < M; ++i) {
                int n1, n2;
                n1 = scanner.nextInt();
                n2 = scanner.nextInt();
                graph.get(n1).add(n2);
                graph.get(n2).add(n1);
            }
            start = scanner.nextInt();

            int[] costs = findShortestReach(graph, start);
            for (int i = 1; i < costs.length; ++i) {
                if (i == start) continue;
                System.out.print(costs[i] + " ");
            }
            System.out.println();
        }
    }
}

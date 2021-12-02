package Week12;

import java.util.*;

public class Libraries {

    static boolean[] visited;
    static int[] edgeTo;

    public static void roadsAndLibraries(ArrayList<ArrayList<Integer>> cities, int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        while (!queue.isEmpty()) {
            int v = queue.poll();
            for (Integer w : cities.get(v)) {
                if (!visited[w]) {
                    queue.add(w);
                    visited[w] = true;
                    edgeTo[w] = v;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int Q = scanner.nextInt();
        for (int q = 0; q < Q; ++q) {
            long cost = 0;
            int N, M;
            N = scanner.nextInt();
            M = scanner.nextInt();
            int lib, road;
            lib = scanner.nextInt();
            road = scanner.nextInt();
            ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
            for (int i = 0; i < N; ++i) {
                graph.add(new ArrayList<Integer>());
            }
            for (int i = 0; i < M; ++i) {
                int n1, n2;
                n1 = scanner.nextInt();
                n2 = scanner.nextInt();
                graph.get(n1 - 1).add(n2 - 1);
                graph.get(n2 - 1).add(n1 - 1);
            }
            if (lib <= road) {
                cost = (long) lib * N;
            } else {
                visited = new boolean[N];
                edgeTo = new int[N];
                for (int i = 0; i < N; i++) {
                    edgeTo[i] = -1;
                }
                for (int i = 0; i < N; ++i) {
                    if (!visited[i]) {
                        roadsAndLibraries(graph, i);
                    }
                }
                for (int i = 0; i < N; i++) {
                    if (edgeTo[i] >= 0) {
                        cost += road;
                    } else {
                        cost += lib;
                    }
                }
            }
            System.out.println(cost);
        }
    }
}

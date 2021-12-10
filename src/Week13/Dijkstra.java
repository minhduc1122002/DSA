package Week13;

import java.util.*;

public class Dijkstra {
    protected static class Cost {
        public int r, v;
        public Cost(int cost, int vertex) {
            r = cost;
            v = vertex;
        }
    }

    protected static class EdgeWithIndex implements Comparable<EdgeWithIndex> {
        public int key;
        public int distance;
        public EdgeWithIndex(int key, int distance) {
            this.key = key;
            this.distance = distance;
        }
        @Override
        public int compareTo(EdgeWithIndex c) {
            if (distance < c.distance) return -1;
            if (distance > c.distance) return 1;
            if (key < c.key) return -1;
            if (key > c.key) return 1;
            return 0;
        }
    }

    public static boolean[] marked;

    public static Queue<EdgeWithIndex> pq = new PriorityQueue<>();

    public static int []distTo;

    public static void dijkstra(ArrayList<ArrayList<Cost>> graph, int start) {
        marked = new boolean[graph.size()];
        distTo = new int[graph.size()];
        Arrays.fill(distTo, Integer.MAX_VALUE);
        distTo[start] = 0;
        relax(graph, start);
        while (!pq.isEmpty()) {
            int v = pq.remove().key;
            if (!marked[v]) {
                relax(graph, v);
            }
        }
    }

    public static void relax(ArrayList<ArrayList<Cost>> graph, int v) {
        marked[v] = true;
        for (Cost w : graph.get(v)) {
            if (!marked[w.v] && distTo[w.v] > distTo[v] + w.r) {
                distTo[w.v] = distTo[v] + w.r;
                pq.add(new EdgeWithIndex(w.v, distTo[w.v]));
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int t = 0; t < T; t++) {
            int N, M;
            N = scanner.nextInt();
            M = scanner.nextInt();
            ArrayList<ArrayList<Cost>> graph = new ArrayList<ArrayList<Cost>>();
            for (int i = 0; i < N; ++i) {
                graph.add(new ArrayList<Cost>());
            }
            for (int i = 0; i < M; ++i) {
                int n1, n2, cost;
                n1 = scanner.nextInt();
                n2 = scanner.nextInt();
                cost = scanner.nextInt();
                graph.get(n1 - 1).add(new Cost(cost, n2 - 1));
                graph.get(n2 - 1).add(new Cost(cost, n1 - 1));
            }
            int start = scanner.nextInt();
            dijkstra(graph, start - 1);
            for (int i = 0; i < distTo.length; i++) {
                if (distTo[i] == Integer.MAX_VALUE) {
                    System.out.print(-1 + " ");
                } else if (distTo[i] != 0) {
                    System.out.print(distTo[i] + " ");
                }
            }
            System.out.println();
        }
    }
}

package Week13;

import java.util.*;

public class Prim {
    protected static class Cost implements Comparable<Cost> {
        public int r, v;
        public Cost(int cost, int vertex) {
            r = cost;
            v = vertex;
        }
        @Override
        public int compareTo(Cost c) {
            if (r < c.r) return -1;
            if (r> c.r) return 1;
            if (v < c.v) return -1;
            if (v > c.v) return 1;
            return 0;
        }
    }

    public static boolean[] marked;

    public static Queue<Cost> pq = new PriorityQueue<>();

    public static List<Cost> edge = new ArrayList<>();

    public static int prim(ArrayList<ArrayList<Cost>> graph, int start) {
        marked = new boolean[graph.size()];
        visit(graph, start);
        while (!pq.isEmpty() && edge.size() < graph.size() - 1) {
            Cost e = pq.remove();
            if (marked[e.v]) continue;
            edge.add(e);
            visit(graph, e.v);
        }
        int shortest = 0;
        for (int i = 0; i < edge.size(); i++) {
            shortest += edge.get(i).r;
        }
        return shortest;
    }

    private static void visit(ArrayList<ArrayList<Cost>> graph, int v) {
        marked[v] = true;
        for (Cost w : graph.get(v)) {
            if (!marked[w.v]) {
                pq.add(w);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
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
        System.out.println(prim(graph, start - 1));
    }
}

package Week8;

import java.util.*;

public class RunningMedian {
    public static List<Double> runningMedian(List<Integer> a) {
        // Write your code here
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>(a.size() / 2 + 1, Collections.reverseOrder());
        PriorityQueue<Integer> minPQ = new PriorityQueue<>(a.size() / 2 + 1);
        List<Double> medians = new ArrayList<>();
        double median = 0;
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i) > median) {
                minPQ.add(a.get(i));
            } else {
                maxPQ.add(a.get(i));
            }
            if (maxPQ.size() > minPQ.size() + 1) {
                minPQ.add(maxPQ.remove());
            }
            if (minPQ.size() > maxPQ.size() + 1) {
                maxPQ.add(minPQ.remove());
            }
            if (maxPQ.size() == minPQ.size()) {
                median = (double) (maxPQ.element() + minPQ.element()) / 2;
            } else if (maxPQ.size() > minPQ.size()) {
                median = maxPQ.element();
            } else {
                median = minPQ.element();
            }
            medians.add(median);
        }
        return medians;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N;
        N = scanner.nextInt();
        List<Integer> pqueue = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            pqueue.add(scanner.nextInt());
        }
        System.out.println(runningMedian(pqueue));
    }
}

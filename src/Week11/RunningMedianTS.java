package Week11;

import java.util.*;

public class RunningMedianTS {
    public static List<Double> runningMedian(List<Integer> a) {
        // Write your code here
        TreeSet<Integer> set = new TreeSet<>();
        List<Double> medians = new ArrayList<>();
        double median = 0;
        for (int i = 0; i < a.size(); i++) {
            set.add(a.get(i));
            int min = set.first();
            int max = set.last();
            if (set.size() % 2 == 0) {
                int k = set.size();
                while (k / 2 > 0) {
                    min = set.higher(min);
                    max = set.lower(max);
                    k = k / 2;
                }
                median = (double) (min + max) / 2;
                medians.add(median);
            } else {
                int k = 0;
                int n = set.size() / 2;
                while (k < n) {
                    min = set.higher(min);
                    k++;
                }
                median = (double) min;
                medians.add(median);
            }
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

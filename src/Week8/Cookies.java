package Week8;

import java.util.*;

public class Cookies {
    public static int cookies(int k, List<Integer> A) {
        // Write your code here
        PriorityQueue<Integer> pq = new PriorityQueue<>(A.size(), new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        int count = 0;
        pq.addAll(A);
        while(pq.size() > 1) {
            if (pq.peek() >= k) {
                return count;
            } else {
                int min1 = pq.remove();
                int min2 = pq.remove();
                pq.add(min1 + 2 * min2);
                count++;
            }
        }
        if(pq.size() > 0 && pq.peek() >= k) {
            return count;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N, K;
        N = scanner.nextInt();
        K = scanner.nextInt();
        List<Integer> pqueue = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            pqueue.add(scanner.nextInt());
        }
        System.out.println(cookies(K, pqueue));
    }
}

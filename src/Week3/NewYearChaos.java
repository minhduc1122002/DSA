package Week3;
import edu.princeton.cs.algs4.StdIn;
import java.util.*;

public class NewYearChaos {
    public static void minimumBribes(List<Integer> q) {
        // Write your code here
        int count = 0;
        for (int i = q.size() - 1; i >= 0; i--) {
            if (q.get(i) - i > 3) {
                System.out.println("Too chaotic");
                return;
            }
            for (int j = Math.max(0,q.get(i)-2); j < i; j++) {
                if (q.get(j) > q.get(i)) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    public static void main(String[] args) {
        int n = StdIn.readInt();
        List<Integer> arr = new ArrayList<Integer>();
        for(int i = 0; i < n; i++) {
            int s = StdIn.readInt();
            arr.add(s);
        }
        minimumBribes(arr);
    }
}

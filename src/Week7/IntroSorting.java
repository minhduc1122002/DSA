package Week7;

import java.util.List;

public class IntroSorting {
    public static int introTutorial(int V, List<Integer> arr) {
        // Write your code here
        int start = 0;
        int end = arr.size();
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if (arr.get(mid) > V) {
                end = mid - 1;
            } else if (arr.get(mid) < V) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}

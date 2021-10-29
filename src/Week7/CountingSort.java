package Week7;

import java.util.ArrayList;
import java.util.List;

public class CountingSort {
    public static List<Integer> countingSort(List<Integer> arr) {
        // Write your code here
        List<Integer> a = new ArrayList<Integer>();
        for (int i = 0; i < 100; i++) {
            a.add(0);
        }
        for (int i = 0; i < arr.size(); i++) {
            int x = a.get(arr.get(i)) + 1;
            a.set(arr.get(i), x);
        }
        return a;
    }
}

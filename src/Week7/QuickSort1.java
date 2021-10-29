package Week7;

import java.util.ArrayList;
import java.util.List;

public class QuickSort1 {
    public static List<Integer> quickSort(List<Integer> arr) {
        // Write your code here
        int x = arr.get(0);
        List<Integer> sorted = new ArrayList<Integer>();
        List<Integer> left = new ArrayList<Integer>();
        List<Integer> right = new ArrayList<Integer>();
        for (int i = 1; i < arr.size(); i++) {
            if (arr.get(i) < x) {
                left.add(arr.get(i));
            } else {
                right.add(arr.get(i));
            }
        }
        for (int i = 0; i < left.size(); i++) {
            sorted.add(left.get(i));
        }
        sorted.add(x);
        for (int i = 0; i < right.size(); i++) {
            sorted.add(right.get(i));
        }
        return sorted;
    }
}

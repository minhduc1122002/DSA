package Week7;

import java.util.List;

public class Median {
    public static int partition(List<Integer>a, int low, int high) {
        int pivot = a.get(high);
        int i = low;
        for (int j = low; j < high; j++) {
            if (a.get(j) <= pivot) {
                int temp = a.get(i);
                a.set(i, a.get(j));
                a.set(j, temp);
                i = i + 1;
            }
        }
        int temp = a.get(i);
        a.set(i, a.get(high));
        a.set(high, temp);
        return i;
    }

    public static void quickSort(List<Integer> a, int low, int high) {
        if(high <= low) return;
        int j = partition(a, low, high);

        quickSort(a, low, j-1);
        quickSort(a, j+1, high);
    }

    public static int findMedian(List<Integer> arr) {
        // Write your code here
        quickSort(arr, 0, arr.size() - 1);
        return arr.get((arr.size() - 1 ) / 2);
    }
}

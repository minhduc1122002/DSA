package Week9;

import java.util.ArrayList;
import java.util.List;

public class ClosestNumber {
    public static void merge(List<Integer> a, List<Integer> aux, int lo, int mid, int hi) {
        for (int k = lo; k <= hi; k++) {
            aux.set(k, a.get(k));
        }
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if      (i > mid)                 a.set(k, aux.get(j++));
            else if (j > hi)                  a.set(k, aux.get(i++));
            else if (aux.get(j) < aux.get(i)) a.set(k, aux.get(j++));
            else                              a.set(k, aux.get(i++));
        }
    }
    public static void sort(List<Integer> a, List<Integer> aux, int lo, int hi) {
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        sort(a, aux, lo, mid);
        sort(a, aux, mid + 1, hi);
        merge(a, aux, lo, mid, hi);
    }

    public static void sort(List<Integer> a) {
        List<Integer> aux = new ArrayList<>(a);
        sort(a, aux, 0, a.size() - 1);
    }
    public static List<Integer> closestNumbers(List<Integer> arr) {
        // Write your code here
        List<Integer> newarr = new ArrayList<Integer>();
        sort(arr);
        int Difference = arr.get(1) - arr.get(0);
        for(int i = 1; i < arr.size()-1; i++) { //find min difference
            if(Difference > arr.get(i+1) - arr.get(i)) {
                Difference = arr.get(i+1) - arr.get(i);
            }
        }
        for(int i = 0; i < arr.size()-1; i++) {
            if(Difference == arr.get(i+1) - arr.get(i)) {
                newarr.add(arr.get(i));
                newarr.add(arr.get(i+1));
            }
        }
        return newarr;
    }
}

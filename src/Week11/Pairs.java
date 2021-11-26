package Week11;

import edu.princeton.cs.algs4.StdIn;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Pairs {
    public static int pairs(int k, List<Integer> arr) {
        int count = 0;
        HashSet<Integer> set = new HashSet<>(arr);
        for (int i = 0; i < arr.size(); i++) {
            if (set.contains(arr.get(i) + k)) {
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int n = StdIn.readInt();
        int k = StdIn.readInt();
        List<Integer> a = new ArrayList<Integer>();
        for(int i = 0; i < n; i++) {
            int s=StdIn.readInt();
            a.add(s);
        }
        System.out.println(pairs(k,a));
    }
}

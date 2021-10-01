package Week3;

import edu.princeton.cs.algs4.StdIn;
import java.util.*;

public class ClosestNumber {
    public static void Result(List<Integer> a) {
        List<Integer> b = new ArrayList<Integer>();
        Collections.sort(a);
        int Difference = a.get(1) - a.get(0);
        for(int i = 1; i < a.size() - 1; i++) { //find min difference
            if(Difference > a.get(i+1) - a.get(i)) {
                Difference = a.get(i+1) - a.get(i);
            }
        }
        for(int i = 0; i < a.size()-1; i++) {
            if(Difference == a.get(i+1) - a.get(i)) {
                b.add(a.get(i));
                b.add(a.get(i+1));
            }
        }
        System.out.println(b);
    }
    public static void main(String[] args) {
        int n = StdIn.readInt();
        List<Integer> a = new ArrayList<Integer>();
        for(int i = 0; i < n; i++) {
            int s = StdIn.readInt();
            a.add(s);
        }
        Result(a);
    }
}

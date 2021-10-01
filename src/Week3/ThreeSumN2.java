package Week3;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import java.util.Arrays;

public class ThreeSumN2 {
    public static int threeSum(int []arr) {
        Arrays.sort(arr);
        int count = 0;
        for (int i = 0; i < arr.length - 2; i++) {
            int start = i + 1;
            int end = arr.length - 1;
            while (start < end) {
                if (arr[i] + arr[start] + arr[end] == 0) {
                    count++;
                }
                if (arr[i] + arr[start] + arr[end] < 0) {
                    start++;
                }
                else {
                    end--;
                }
            }
        }
        return count;
    }

    public static void main(String[] args)  {
        In in = new In(args[0]);
        int[] a = in.readAllInts();
        StdOut.println(threeSum(a));
    }
}

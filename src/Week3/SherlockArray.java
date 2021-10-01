package Week3;
import edu.princeton.cs.algs4.StdIn;

import java.util.ArrayList;
import java.util.List;

public class SherlockArray {
    public static String balancedSums(List<Integer> arr) {
        // Write your code here
        int SumOfArray=0;
        int i=0;
        int x=0;
        for(int j=0;j<arr.size();j++) {
            SumOfArray+=arr.get(j);
        }
        while(i<arr.size()) {
            if(2*x==SumOfArray-arr.get(i)) {
                return "YES";
            }
            x+=arr.get(i);
            i++;
        }
        if(i==arr.size()) {
            return "NO";
        }
        return " ";
    }

    public static void main(String[] args) {
        int n = StdIn.readInt();
        List<Integer> a = new ArrayList<Integer>();
        for(int i = 0; i < n; i++) {
            int s=StdIn.readInt();
            a.add(s);
        }
        System.out.println(balancedSums(a));
    }

}

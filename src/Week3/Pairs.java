package Week3;
import edu.princeton.cs.algs4.StdIn;
import java.util.*;

public class Pairs {
    public static int BinarySearch(List<Integer> arr, int key) {
        int start=0;
        int end=arr.size()-1;
        while(start <= end) {
            int mid=start+(end-start)/2;
            if(arr.get(mid)>key) {
                end=mid-1;
            }
            else if(arr.get(mid)<key) {
                start=mid+1;
            }
            else {
                return mid;
            }
        }
        return -1;
    }
    public static int pairs(int k, List<Integer> arr) {
        int count=0;
        Collections.sort(arr);
        for(int i=0;i<arr.size();i++) {
            int x=BinarySearch(arr,arr.get(i)+k);
            if(x!=-1) {
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

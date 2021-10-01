package Week2;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Sum3 {
    public static int BinarySearch(int []a, int key) {
        int start = 0;
        int end = a.length-1;
        while(start <= end) {
            int mid = start + (end - start)/2;
            if(key < a[mid]) {
                end = mid - 1;
            }
            else if(key > a[mid]) {
                start = mid + 1;
            }
            else {
                return mid;
            }
        }
        return -1;
    }
    public static void Sort(int []a) {
        for(int i = 0; i < a.length; i++) {
            for(int j = i+1; j < a.length-1; j++) {
                if(a[i] > a[j]) {
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
    }
    public static void main(String[] args) {
        int n = StdIn.readInt();
        int []a = new int [n];
        for(int i = 0; i < n; i++) {
            a[i]= StdIn.readInt();
        }
        Sort(a);
        for(int i = 0; i < n; i++) {
            for(int j = i+1; j < n-1; j++) {
                int k = BinarySearch(a, -(a[i] + a[j]));
                if(k != -1 && (a[i] < a[j]) && (a[j] < a[k])) {
                    StdOut.println(a[i] + " " + a[j] + " " + a[k]);
                }
            }
        }
    }
}

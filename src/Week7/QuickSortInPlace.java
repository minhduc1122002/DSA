package Week7;

import java.util.Scanner;

public class QuickSortInPlace {

    public static int partition(int []a, int low, int high) {
        int pivot = a[high];
        int i = low;
        for (int j = low; j < high; j++) {
            if (a[j] <= pivot) {
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
                i = i + 1;
            }
        }
        int temp = a[i];
        a[i] = a[high];
        a[high] = temp;
        for (int z = 0; z < a.length; z++) {
            System.out.print(a[z] + " ");
        }
        System.out.println();
        return i;
    }

    public static void quickSort(int []a, int low, int high) {
        if(high <= low) return;
        int j = partition(a, low, high);

        quickSort(a, low, j-1);
        quickSort(a, j+1, high);
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int []a = new int [n];
        for (int i = 0; i < n; i++) {
            a[i] = scan.nextInt();
        }
        quickSort(a, 0, n - 1);
    }
}

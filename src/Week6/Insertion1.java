package Week6;

import java.util.List;

public class Insertion1 {
    public static void insertionSort1(int n, List<Integer> arr) {
        // Write your code here
        int num = arr.get(n-1);
        for(int i = n-2; i >= 0; i--){
            if(arr.get(i) > num) {
                arr.set(i+1, arr.get(i));
            }
            else {
                arr.set(i+1, num);
                for(int j = 0; j < n; j++){
                    System.out.print(arr.get(j) + " ");
                }
                break;
            }
            for(int j = 0; j < n; j++){
                System.out.print(arr.get(j) + " ");
            }
            System.out.println();
        }
        if(arr.get(0) > num){
            arr.remove(0);
            arr.add(0, num);
            for(int j  =0; j < n; j++){
                System.out.print(arr.get(j) + " ");
            }
        }
    }
}


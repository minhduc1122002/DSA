package Week6;

import java.util.List;

public class Insertion2 {
    public static void insertionSort2(int n, List<Integer> arr) {
        // Write your code here
        for(int i = 1; i < n; i++){
            for(int j = i; j > 0; j--){
                if(arr.get(j) < arr.get(j - 1)){
                    int temp = arr.get(j - 1);
                    arr.set(j - 1, arr.get(j));
                    arr.set(j, temp);
                }
            }
            for(int j = 0; j < n; j++){
                System.out.print(arr.get(j) + " ");
            }
            System.out.println();
        }
    }
}

package Week3;

public class BinarySearch {
    public static int binarySearch(int[] arr, int key) {
        int start = 0;
        int end = arr.length - 1;
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(arr[mid] > key) {
                end = mid - 1;
            }
            else if(arr[mid] < key) {
                start = mid + 1;
            }
            else {
                return mid;
            }
        }
        return -1;
    }
}

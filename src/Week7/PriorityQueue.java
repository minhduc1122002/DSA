package Week7;

import java.util.ArrayList;
import java.util.List;

public class PriorityQueue {
    private int []a = new int [10000];

    private int contain = 0;

    public PriorityQueue() {

    }

    public void insert(int x) {
        if (contain < 10000) {
            a[contain] = x;
            contain++;
        }
    }

    public int deleteMin() {
        if (contain > 0) {
            int min = a[0];
            int min_index = 0;
            for (int i = 0; i < contain; i++) {
                if (a[i] < min) {
                    min = a[i];
                    min_index = i;
                }
            }
            for (int j = min_index; j < contain; j++) {
                a[j] = a[j + 1];
            }
            contain--;
            return min;
        } else {
            return -1;
        }
    }

    public void print() {
        for (int i = 0; i < contain; i++) {
            System.out.print(a[i] + " ");
        }
    }

    public static void main(String[] args) {
        PriorityQueue priorityQueue = new PriorityQueue();
        priorityQueue.insert(5);
        priorityQueue.insert(3);
        priorityQueue.insert(7);
        priorityQueue.insert(1);
        int x = priorityQueue.deleteMin();
        priorityQueue.print();
    }
}

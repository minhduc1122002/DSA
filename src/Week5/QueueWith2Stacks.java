package Week5;

import java.util.*;
public class QueueWith2Stacks {
    private static class Queue2Stacks {
        Stack<Integer> tail = new Stack<>();

        Stack<Integer> head = new Stack<>();

        void Enqueue (int x) {
            tail.push(x);
        }
        void Dequeue() {
            while (!tail.isEmpty()) {
                head.push(tail.pop());
            }
            head.pop();
        }
        int print() {
            while (!tail.isEmpty()) {
                head.push(tail.pop());
            }
            return head.peek();
        }
    }

    public static void main(String[] args) {
        Queue2Stacks q2s = new Queue2Stacks();
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        for (int i = 0; i < n; i++) {
            Scanner scanX = new Scanner(System.in);
            int x = scanX.nextInt();
            if (x == 2) {
                q2s.Dequeue();
            } else if (x == 3) {
                System.out.print(q2s.print());
            } else if (x == 1) {
                Scanner scanY = new Scanner(System.in);
                int y = scanY.nextInt();
                q2s.Enqueue(y);
            }
        }
    }
}

package Week5;

import java.util.*;

public class EqualStacks {
    public static void sum(List<Integer> h, Stack<Integer> s) {
        for (int i = h.size() - 1; i >= 0; i--) {
            if (s.isEmpty()) {
                s.push(h.get(i));
            } else {
                s.push(h.get(i) + s.peek());
            }
        }
    }
    public static int equalStacks(List<Integer> h1, List<Integer> h2, List<Integer> h3) {
        // Write your code here
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        Stack<Integer> s3 = new Stack<>();
        sum(h1, s1);
        sum(h2, s2);
        sum(h3, s3);
        while (!s1.isEmpty() && !s2.isEmpty() && !s3.isEmpty()) {
            int stack1Height = s1.peek();
            int stack2Height = s2.peek();
            int stack3Height = s3.peek();
            if (stack1Height == stack2Height && stack2Height == stack3Height) {
                return s1.peek();
            }
            if ((stack1Height > stack2Height) && (stack1Height > stack3Height)) {
                System.out.println(1);
                s1.pop();
            } else if ((stack2Height > stack1Height) && (stack2Height > stack3Height)) {
                System.out.println(2);
                s2.pop();
            } else if ((stack3Height > stack1Height) && (stack1Height > stack2Height)) {
                System.out.println(3);
                s3.pop();
            }
        }
        return 0;
    }
}

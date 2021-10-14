package Week5;

import java.util.Scanner;
import java.util.Stack;

public class TextEditor {
    public static void main(String[] args) {
        Stack<String> strings = new Stack<>();
        String s = "";
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        for (int i = 0; i < n; i++) {
            int op = scan.nextInt();
            if (op == 1) {
                String w = scan.next();
                s = s + w;
                strings.push(s);
                System.out.println(s);
            } else if (op == 2) {
                int k = scan.nextInt();
                s = s.substring(0, s.length() - k);
                strings.push(s);
                System.out.println(strings.peek());
            } else if (op == 3) {
                int k = scan.nextInt();
                System.out.println(s.charAt(k - 1));
            } else {
                strings.pop();
                s = strings.peek();
                System.out.println(s);
            }
        }
    }
}

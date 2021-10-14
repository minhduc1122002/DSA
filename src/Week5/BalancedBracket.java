package Week5;

import java.util.*;

public class BalancedBracket {
    public static String isBalanced(String s) {
        // Write your code here
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '{' || s.charAt(i) == '[' || s.charAt(i) == '(') {
                stack.push(s.charAt(i));
            } else if (s.charAt(i) == '}') {
                if (stack.peek() != '{') {
                    return "NO";
                } else {
                    stack.pop();
                }
            } else if (s.charAt(i) == ']') {
                if (stack.peek() != '[') {
                    return "NO";
                } else {
                    stack.pop();
                }
            } else if (s.charAt(i) == ')') {
                if (stack.peek() != '(') {
                    return "NO";
                } else {
                    stack.pop();
                }
            }
        }
        if (!stack.isEmpty()) {
            return "NO";
        }
        return "YES";
    }
}

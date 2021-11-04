package Week8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Count {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] strings = s.split(" ");
        Arrays.sort(strings);
        for (int i = 0; i < strings.length - 1; ) {
            int count = 1;
            int j = i + 1;
            for ( ; j < strings.length; j++) {
                if (strings[j].equals(strings[i])) {
                    count++;
                } else {
                    break;
                }
            }
            System.out.println(strings[i] + " " + count);
            i = j;
        }
    }
}

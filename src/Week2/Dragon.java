package Week2;

import edu.princeton.cs.algs4.StdIn;

public class Dragon {
    public static String reverseDragonString(String s) {
        String result = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == 'L') {
                result = result + "R";
            }
            else if (s.charAt(i) == 'R') {
                result = result + "L";
            }
            else {
                result = result + s.charAt(i);
            }
        }
        return result;
    }
    public static void main(String[] args) {
        String DragonFractal = "F";
        int n = StdIn.readInt();
        for (int i = 1; i <= n; i++) {
            String ReverseDragon = reverseDragonString(DragonFractal);
            DragonFractal = DragonFractal + "L";
            DragonFractal = DragonFractal + ReverseDragon;
        }
        System.out.println(DragonFractal);
    }
}

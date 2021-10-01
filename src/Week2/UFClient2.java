package Week2;
import edu.princeton.cs.algs4.*;

public class UFClient2 {
    public static boolean Connected_All(UF uf, int N) {
        for(int i = 1; i < N; i++) {
            if(!uf.connected(0,i)) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        int N = StdIn.readInt();
        UF uf = new UF(N);
        int count = 0;
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (!uf.connected(p, q)) {
                uf.union(p, q);
            }
            count++;
            if(Connected_All(uf,N)) {
                StdOut.println(count);
                System.exit(1);

            }
        }
        System.out.println("FALSE");
    }
}

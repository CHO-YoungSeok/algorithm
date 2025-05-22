import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] ins = br.readLine().split(" ");
        int n = Integer.parseInt(ins[0]);
        int r = Integer.parseInt(ins[1]);
        int c = Integer.parseInt(ins[2]);

        long ans = 0;
        int size = 1 << n;

        while (size > 0) {
            size /= 2;
            if (r < size && c < size) {
                // 1사분면
            } else if (r < size && c >= size) {
                // 2사분면
                ans += (long) size * size;
                c -= size;
            } else if (r >= size && c < size) {
                // 3사분면
                ans += 2L * size * size;
                r -= size;
            } else {
                // 4사분면
                ans += 3L * size * size;
                r -= size;
                c -= size;
            }

            if (size == 0) break;
        }

        System.out.println(ans);
    }
}

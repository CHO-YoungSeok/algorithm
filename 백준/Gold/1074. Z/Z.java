import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] ins = br.readLine().split(" ");
        int n = Integer.parseInt(ins[0]);
        int r = Integer.parseInt(ins[1]);
        int c = Integer.parseInt(ins[2]);
        int size = 1 << n;
        long ans = 0;

        while (0 < n--) {
            size /= 2;
            if (r < size && c < size) {

            } else if (r < size && c >= size) {
                c -= size;
                ans += (size * size) * 1L;
            } else if (r >= size && c < size) {
                r -= size;
                ans += (size * size) * 2L; 
            } else if (r >= size && c >= size) {
                c -= size;
                r -= size;
                ans += (size * size) * 3L;
            } else {}
        }

        System.out.println(ans);

    }
}

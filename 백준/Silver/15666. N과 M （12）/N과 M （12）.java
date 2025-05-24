import java.util.*;
import java.io.*;

class Main {

    static StringBuilder sb;
    static List<Integer> permutation;
    static int[] arr ;
    static int n, m;

    static void choose(int digit) {
        if (digit > m) {
            for (int e : permutation) {
                sb.append(e).append(' ');
            }

            sb.append('\n');
            return;
        }

        int pre = 0;
        for (int i = 0; i < n; i++) {
            if ((arr[i] != pre) && (permutation.size() == 0 || permutation.get(permutation.size() - 1) <= arr[i])) {
                pre = arr[i];
                permutation.add(arr[i]);
                choose(digit + 1);
                permutation.remove(digit - 1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        permutation = new ArrayList<>();

        String[] ins1 = br.readLine().split(" ");
        n = Integer.parseInt(ins1[0]);
        m = Integer.parseInt(ins1[1]);

        arr = new int[n];
        String[] ins2 = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(ins2[i]);
        }

        Arrays.sort(arr);
        choose(1);
        System.out.println(sb);

    }
}
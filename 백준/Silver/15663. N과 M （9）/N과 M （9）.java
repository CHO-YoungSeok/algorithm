import java.util.*;
import java.io.*;

class Main {

    static int m, n;
    static int[] arr;
    static List<Integer> permutation = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    static boolean[] used;


    static void choose(int digit) {
        if (digit > m) {
            for (int e : permutation) {
                sb.append(e).append(' ');
            }
            sb.append("\n");
            return;
        }

        int pre = 0;
        for (int i = 0; i < arr.length; i++) {

            if (!used[i] && pre != arr[i]) {
                pre = arr[i];
                used[i] = true;
                permutation.add(arr[i]);
                choose(digit + 1);
                used[i] = false;
                permutation.remove(permutation.size() - 1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] ins = br.readLine().split(" ");
        n = Integer.parseInt(ins[0]);
        m = Integer.parseInt(ins[1]);
        used = new boolean[n];

        String[] ins1 = br.readLine().split(" ");
        arr = new int[n];
        for (int i = 0; i < n; i++ ){
            arr[i] = Integer.parseInt(ins1[i]);
        }
        Arrays.sort(arr);

        choose(1);
        System.out.println(sb);
    }
}

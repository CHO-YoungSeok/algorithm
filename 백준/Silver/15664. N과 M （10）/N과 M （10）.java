import java.util.*;
import java.io.*;

class Main {

    static StringBuilder sb;
    static int n, m;
    static int[] arr;
    static List<Integer> permutation;
    static boolean[] used;

    static void choose(int digit) {
        if (digit == m) {
            for (int e : permutation) {
                sb.append(e).append(' ');
            }
            sb.append('\n');
            return;
        }

        int pre = 0;
        for (int i = 0; i < n; i++) {
            boolean flag = false;
            if (digit != 0 && permutation.get(permutation.size() - 1) <= arr[i] && !used[i] && pre != arr[i] ) {
                flag = true;
            }

            if (digit == 0 && pre != arr[i]) {
                flag = true;
            }

            if (flag) {
                pre = arr[i];
                used[i] = true;
                permutation.add(arr[i]);
                choose(digit + 1);
                permutation.remove(permutation.size() - 1);
                used[i] = false;
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        permutation = new ArrayList<>();

        String[] ins = br.readLine().split(" ");
        n = Integer.parseInt(ins[0]);
        m = Integer.parseInt(ins[1]);
        arr = new int[n];
        used = new boolean[n];

        String[] ins2 = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(ins2[i]);
        }
        Arrays.sort(arr);

        choose(0);
        System.out.print(sb);
    }
}

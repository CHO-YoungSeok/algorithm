import java.util.*;
import java.io.*;

class Main {
    static List<Integer> permutation;
    static StringBuilder sb;
    static List<Integer> list;
    static int n, m;

    static void choose(int digit) {
        if (digit > m) {
            for (int  e : permutation) {
                sb.append(e).append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int i = 0; i < list.size(); i++) {
            if (digit == 1 || permutation.get(permutation.size() - 1) <= list.get(i)) {
                permutation.add(list.get(i));
                choose(digit + 1);
                permutation.remove(digit - 1);
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        permutation  = new ArrayList<>();
        String[] ins1 = br.readLine().split(" ");
        n = Integer.parseInt(ins1[0]);
        m = Integer.parseInt(ins1[1]);
        list = new ArrayList<>();
        String[] ins2 = br.readLine().split(" ");
        int temp = 0;
        for (int i = 0; i < n; i++) {
            temp = Integer.parseInt(ins2[i]);
            if (list.contains(temp)) {
                continue;
            }

            list.add(temp);
        }

        list.sort((e1, e2) -> e1 - e2);

        choose(1);
        System.out.println(sb);
    }
}
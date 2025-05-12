import java.util.*;
import java.io.*;

class Main {
    static StringBuilder result = new StringBuilder();
    static List<Integer> list = new ArrayList<>();

    static void choose(int maxNum, int maxDigit, int digit) {
        if (maxDigit < digit) {
            for (int e : list) {
                result.append(e).append(" ");
            }
            result.append("\n");
            return;
        }

        for (int  i = 1; i <= maxNum; i++) {
            if (list.size() == 0 || list.get(list.size() - 1) <= i) {
                list.add(i);
                choose(maxNum, maxDigit, digit + 1);
                list.remove(list.size() - 1);
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] ins = br.readLine().split(" ");
        int n  = Integer.parseInt(ins[0]);
        int m  = Integer.parseInt(ins[1]);

        choose(n, m, 1);
        System.out.println(result);

    }
}
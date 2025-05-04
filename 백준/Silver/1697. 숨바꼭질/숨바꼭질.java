import java.util.*;
import java.io.*;
class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = br.readLine().split(" ");


        int n = Integer.parseInt(strs[0]);
        int m = Integer.parseInt(strs[1]);
        boolean[]field = new boolean[100001];
        field[n] = true;
        Queue<Integer> q = new LinkedList<>();
        q.offer(n);
        int count = 0;
        while (!field[m]) {
            int size = q.size();
            while(0 < size--) {
                int currNode = q.remove();
                if (0 <= currNode -1 && !field[currNode -1]) {
                    field[currNode -1] = true;
                    q.add(currNode -1);
                }
                if (currNode + 1 < 100001 && !field[currNode + 1] ) {
                    field[currNode +1] = true;
                    q.add(currNode + 1);
                }
                if (currNode * 2 < 100001 && !field[currNode*2]) {
                    field[currNode * 2] = true;
                    q.add(currNode * 2);
                }
            }
            count++;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(count);
        System.out.println(sb);
    }
}
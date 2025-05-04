import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] inputs = br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int m = Integer.parseInt(inputs[1]);
        int[][] distance = new int[n][n];
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    distance[i][j] = 0;
                } else {
                    distance[i][j] = 10000;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            inputs = br.readLine().split(" ");
            int n1 = Integer.parseInt(inputs[0]) -1;
            int n2 = Integer.parseInt(inputs[1]) -1;
            distance[n1][n2] = 1;
            distance[n2][n1] = 1;
        }

        for (int k = 0; k  < n; k++) {
            for (int  i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    distance[i][j] = Math.min(distance[i][j], distance[i][k] + distance[k][j]);
                }
            }
        }
        int result = -1, min = 10000;
        for(int i = 0; i < n; i++) {
            int count = 0;
            for(int j = 0; j < n; j++) {
                count += distance[i][j];
            }
            if(count < min) {
                min = count;
                result = i;
            }
        }

        sb.append(result + 1);
        System.out.println(sb);
    }
}
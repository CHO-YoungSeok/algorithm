import java.util.*;
import java.io.*;

public class Main {

    static int[][] field;
    static int white = 0;
    static int blue = 0;
    static int count = 0;
    
    static void search(int n, int r, int c) {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(field[r][c] != field[r+i][c+j]) {
                    int nextN = n/2;
                    search(nextN, r, c);
                    search(nextN, r, c + nextN);
                    search(nextN, r + nextN, c);
                    search(nextN, r + nextN, c + nextN);
                    return;
                }
            }
        }
        if(field[r][c] == 0) {
            white++;
        } else {
            blue++;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        field = new int[n][n];

        for(int i = 0; i < n; i++) {
            String[] rowStrs = br.readLine().split(" ");
            for(int j = 0; j < n; j++) {
                field[i][j] = Integer.parseInt(rowStrs[j]);
            }
        }

        search(n, 0, 0);
        sb.append(white + "\n");
        sb.append(blue);
        System.out.println(sb);
    }
}
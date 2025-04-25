import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int m = Integer.parseInt(inputs[1]);
        int[][] feild = new int[n][m];
        for(int i = 0; i < n; i++) {
            String s = br.readLine();
            for(int j = 0; j < m; j++) {
                char c = s.charAt(j);
                feild[i][j] = (c == 'W') ? 0 : 1;
            }
        }

        int min  = Integer.MAX_VALUE;
        for(int i = 0; i <= n - 8; i++) {
            for(int j = 0; j <= m - 8; j++) {
                int count = 0;
                boolean flag = true;
                for(int r = 0; r < 8; r++) {
                    for(int c = 0; c < 8; c++) {
                        if(flag && feild[i+ r][j + c] != 0) {
                            count++;
                        }
                        else if(!flag && feild[i + r][j + c] != 1) {
                            count++;
                        }

                        flag = !flag;
                    }
                    flag = !flag;
                }
                min = Math.min(min, count);

                count = 0;
                flag = true;
                for(int r = 0; r < 8; r++) {
                    for(int c = 0; c < 8; c++) {
                        if(flag && feild[i+ r][j + c] != 1)
                            count++;
                        else if(!flag && feild[i + r][j + c] != 0) {
                            count++;
                        } 
                        flag = !flag;
                    }
                    flag = !flag;
                }
                min = Math.min(min, count);
            }
        }
        System.out.println(min);
    }
}
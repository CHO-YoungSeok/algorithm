import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        while (0 < t--) {
            String[] ins = br.readLine().split(" ");
            int h = Integer.parseInt(ins[0]);
            int w = Integer.parseInt(ins[1]);
            int n = Integer.parseInt(ins[2]);

            int hUsed = (n -1) % h + 1;
            int wUsed = (n - 1) / h + 1;

            String result;
            if (wUsed < 10) {
                result = "" + hUsed + "0" + wUsed;    
            } else {
                result = "" + hUsed + "" + wUsed;    
            }
            
            sb.append(result).append('\n');

        }
        System.out.print(sb);

    }
}
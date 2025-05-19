import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        String str = br.readLine();

        int result = 0;
        for (int  i = 0; i < m; i++) {
            int len = 0;
            while (i + 2 < m && str.charAt(i) == 'I' && str.charAt(i+1) == 'O' && str.charAt(i+2) == 'I') {
                len++;
                i += 2; 
            }
            int count = len - n;
            if (count >= 0) {
                result += count + 1;
            }
        }
        System.out.println(result);

    }
}   
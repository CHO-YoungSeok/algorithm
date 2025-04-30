import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n+1];
        for(int i = 1; i < n+1; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }
        int count = 0;
        StringBuilder sb = new StringBuilder();
        Deque<Integer> stack = new ArrayDeque<>();
        for(int j = count; j < nums[1]; j++) {
            stack.push(++count);
            sb.append("+\n");
        }
        for(int i = 1; i <= n; i++) {
            for(int j = count; j < nums[i]; j++) {
                stack.push(++count);
                sb.append("+\n");
            }
            int currN = stack.pop();
            sb.append("-\n");
            if(currN != nums[i]) {
                System.out.println("NO");
                System.exit(0);
            }
        }
        System.out.println(sb);
    }
}
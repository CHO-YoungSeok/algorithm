import java.util.*;

public class Main {

     public static void main(String[] args) {
          Scanner sc = new Scanner(System.in);
          int n = sc.nextInt();
          int m = sc.nextInt();
          HashMap<Integer, Integer> map = new HashMap<>();
          map.put(0, 0);
          map.put(1, sc.nextInt());
          for(int i = 2; i <= n; i++) {
               int num = sc.nextInt();
               map.put(i, map.get(i-1) + num);
          }
          
          StringBuffer sb = new StringBuffer();
          while(0 < m--) {
               int a = sc.nextInt();
               int b = sc.nextInt();
               int sum = map.get(b) - map.get(a-1);
               sb.append(Integer.toString(sum) + '\n');
          }
          System.out.println(sb);

     }
}

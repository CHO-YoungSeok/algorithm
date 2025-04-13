import java.util.*;

public class Main {
    public static void main(String[] args) {
          Scanner sc = new Scanner(System.in);
          int n = sc.nextInt();
          HashMap<Integer, Integer> map = new HashMap<>();
          for(int i = 0; i < n; i++) {
               int num = sc.nextInt();
               if(map.containsKey(num)) {
                    int a = map.get(num);
                    map.remove(num);
                    map.put(num, a+1);
               }
               else {
                    map.put(num, 1);
               }
          }
          int m = sc.nextInt();
          StringBuilder sb = new StringBuilder();
          for(int i = 0; i < m; i++) {
               int num = sc.nextInt();
               if(map.containsKey(num))
                    sb.append(map.get(num) + " ");
               else
                    sb.append(0 + " ");
          }

          System.out.println(sb);
    }
}
import java.util.*;

public class Main {

     static HashMap<Integer, Integer> map = new HashMap<>();

     public static void main(String[] args) {
          Scanner sc = new Scanner(System.in);
          int n = sc.nextInt();
          map.put(1, 0);
          map.put(2, 1);
          map.put(3, 1);

          
          if(n <= 3) {
               System.out.println(map.get(n));
               System.exit(0);
          }

          int p = n;
          for(int i = 4; i <= n; i++) {
               int one = Integer.MAX_VALUE;
               int two = Integer.MAX_VALUE;
               int three = Integer.MAX_VALUE;
               if(i % 3 == 0) {
                    one = map.get(i/3);
               }
               if(i % 2 == 0) {
                    two = map.get(i/2);
               }
                    three = map.get(i-1);

               int smallest = Math.min(one, two);
               smallest = Math.min(smallest, three);
               map.put(i, smallest + 1);
               // System.out.println(map.get(i));
          }
          System.out.println(map.get(n));


     }
}

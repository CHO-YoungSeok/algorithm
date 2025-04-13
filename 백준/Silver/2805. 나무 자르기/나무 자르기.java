import java.util.*;

public class Main{

     public static void main(String[] args) {
          Scanner sc = new Scanner(System.in);
          int m = sc.nextInt(), n = sc.nextInt();
          int[] trees = new int[m];
          int max = 0, min = 0;

          for(int i = 0; i < m; i++) {
               trees[i] = sc.nextInt();
               max = Math.max(trees[i], max);
          }

          int mid = 0;
          while(min < max) {
               long get = 0;
               mid = (max + min) / 2;
               // System.out.println(mid);
               for(int i = 0; i < m; i++) {
                    if(trees[i] - mid > 0) {
                         get += (trees[i] - mid);
                    }
               }

               if(get < n) {
                    max = mid;
               } else {
                    min = mid + 1;
               }
          }

          System.out.println(min-1);

     }
}
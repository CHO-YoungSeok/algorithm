import java.util.*;

public class Main {

     public static void main(String[] args) {
          Scanner sc = new Scanner(System.in);
          int n  = sc.nextInt();
          int[] result = new int[50001];
          result[0] = 0;
          result[1] = 1;

          for(int i = 2; i < (int)Math.pow(10, 4) * 5 + 1 ; i++) {
               int sqrt = (int)Math.sqrt(i);
               int min = 4;
               for(int j = 1; j <= sqrt; j++) {
                    min  = Math.min(result[i - (int)Math.pow(j, 2)] + 1, min);
               }
               result[i] = min;
          }
          System.out.println(result[n]);
     }
}


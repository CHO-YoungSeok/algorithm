import java.util.*;

public class Main{

     public static void main(String[] args) {
          Scanner sc = new Scanner(System.in);

          int m = sc.nextInt(), n = sc.nextInt();

          int sqrt = (int)Math.sqrt(n);
          boolean[] bisPrimes = new boolean[1000001];
          Arrays.fill(bisPrimes, true);
          int count = 0;
          bisPrimes[1] = false;
          for(int i = 2; i < 1000000 + 1; i++) {
               if(!bisPrimes[i]) {
                    continue;
               }
               for(int j = 2; i*j < 1000000 + 1; j++) {
                    count++;
                    bisPrimes[i*j] = false;
               }
          }
          StringBuilder sb = new StringBuilder();
          for(int i = m; i < n +1; i++) {
               if(bisPrimes[i]) {
                    sb.append(i + "\n");     
               }
          }
          System.out.println(sb);


     }
}